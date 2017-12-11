/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/**
 *
 * @author JVAC
 */
public class almacenamiento {
        //todo en esta clase se guarda en formato texto la encriptacion se hace con la clave aes secreta personal e intransferible 
    private int contadorIDS;
    //recupera nuestras claves si existen
    public void recuperarclaves(seguridad se,String clave)
    {
      File archivo=new File("keys.dat");
      if(archivo.exists())
      {
          String lineas[] = leer(archivo);
          if(lineas.length >= 3)
          {
              se.loadcp(lineas[0]);
              se.loadcpr(lineas[1]);
              se.crearSecreta(clave);
              se.crearSessionAes();
              //aqui tenemos todas las claves nuestras
          }
      }  
    }
    
    //guarda nuestras claves
    public void guardarClaves(String clavepublica,String claveprivada,String clavesecreta)
    {
        File directorio=new File("keys.dat");
        if(directorio.exists())
        {
            //sobreescribimos el archivo
            //creamos el archivo
            try{
                directorio.createNewFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorio))) {
                    bw.write(clavepublica);//primera linea clave publica
                    bw.newLine();
                    bw.write(claveprivada);//segunda linea clave privada
                    bw.newLine();
                    bw.write(clavesecreta);//tercera linea clave secreta
                    bw.newLine();
                } //primera linea clave publica
            }catch(IOException ex)
            {
                System.out.println(ex);
            }            
        }
        else
        {
            //creamos el archivo
            try{
            directorio.createNewFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorio))) {
                    bw.write(clavepublica);//primera linea clave publica
                    bw.newLine();
                    bw.write(claveprivada);//segunda linea clave privada
                    bw.newLine();
                    bw.write(clavesecreta);//tercera linea clave secreta
                    bw.newLine();
                } //primera linea clave publica
            }catch(IOException ex)
            {
                System.out.println(ex);
            }
        }
    }
    
    
    //nos sirve para crear un nuevo usuario en el sistema local 
    public void crearNuevoUsuarioLocal(String email, String VerificacionPassword,String nombre, String foto,String id)
    {
        //creamos una carpeta con el email 
        //File directorio=new File(email.replace("@", "arroba"));
        File directorio=new File(email);
        directorio.mkdir();   
        //creamos un archivo vef que contenga la varificacion del password
        String ruta = email+"/vef";//datos del usuario
        String ruta2 = email+"/chat";//este archivo actua como pila si le envian un mensaje se almacena y luego se procesa cuando se confirma se borra esa linea
        File archivo2 = new File(ruta2);
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(!archivo.exists()) 
        {
            try
            {
                archivo.createNewFile();
                archivo2.createNewFile();
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(VerificacionPassword);//password
                bw.newLine();
                bw.write(nombre);//nombre
                bw.newLine();
                bw.write(foto);//foto
                bw.newLine();
                bw.write(id);//id
                bw.newLine();
                bw.close();
            }catch(IOException ex)
            {
                System.out.println("fallo al crear los archivos "+ex.getLocalizedMessage());
            }
        }
    }
    
   
    //esto nos sirve para saber si existe el usuario(en cliente)
    public boolean existeUsuarioLocal(String email)
    {
        File directorio=new File(email);
        return directorio.exists();
    }
    
    //recupera la informacion del archivo conexion.inf para saber el host del servidor
    public String[] recuperarInfoConexion()
    {
        String ruta = "conexion.inf";
        File archivo = new File(ruta);
        if(archivo.exists())
        {
            return this.leer(archivo);
        }
        return null;    
    }
    
    
    //lee un fichero y devuelve si un string
    public String[] leer(File archivo)
    {
        String cadena,cadena3;
        cadena3="";
        try{
        String cadena2 [];
        int contador = 0;
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) 
        {
            while((cadena = b.readLine())!=null)
            {
                if(contador == 0)
                {
                    cadena3=cadena3+cadena;
                }
                else
                {
                    cadena3=cadena3+"marijose"+cadena;
                }
                contador++;
            }   
        }
        if(contador == 1)
        {
            cadena2 = new String[1];
            cadena2[0] = cadena3;
        }
        else
        {
            cadena2 = cadena3.split("marijose");
        }
        return cadena2;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(almacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(almacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //comprime audio,video o sonido y devuelve un string que esta codificado con el aes del receptor 
    public String comprimir(String rutaArchivo, seguridad seg)
    {
        boolean esta = true;
        int numeroRandom = 0;
        while(esta)
        {
            numeroRandom =(int) Math.floor(Math.random()*1000);
            File arc = new File("sec"+numeroRandom+".zip");
            if(!arc.exists())
            {
                esta = false;
            }
        }
        try
        {
            ZipOutputStream os = new ZipOutputStream(new FileOutputStream("sec"+numeroRandom+".zip"));//asginamos un archivo temporal
            File archivo = new File(rutaArchivo);
            String extension = archivo.getName();
            extension = extension.substring(extension.lastIndexOf(".")+1);
            System.out.print("se va a comprimir el archivo ->"+"archivo."+extension);
            ZipEntry entrada = new ZipEntry("archivo."+extension);
            os.putNextEntry(entrada);
            FileInputStream fis = new FileInputStream(rutaArchivo);
            byte [] buffer = new byte[1024];
            int leido=0;
            while (0 < (leido=fis.read(buffer))){
               os.write(buffer,0,leido);
            }
            fis.close();
            os.closeEntry();
            os.close();
            System.out.print(" [ok] se termino la compresion vamos a encriptarlo con el aes del usuario");
            Path path = Paths.get("sec"+numeroRandom+".zip");
            byte[] data = Files.readAllBytes(path);
            String foto = "";
            boolean primero= true;
            for(byte a:data)
            {
                if(primero)
                {
                    foto = foto+Integer.toHexString(0xFF & a);
                    primero = false;
                }
                else
                {
                    foto = foto+","+Integer.toHexString(0xFF & a);
                }
            }
            System.out.print("\nAgrupado [ok]");
            File fichero = new File("sec"+numeroRandom+".zip");
            fichero.delete();
            System.out.print("\nEliminacion [ok]");
            return foto;
        }catch(IOException ex)
        {
            System.out.println("Ha ocurrido un error durante la compresion\n "+ex);
        }
        
        return null;
    }
    //sirve para crear la estructura basica de una conversacion que es email/id/conversacion
    //tambien tiene archivo email/id/infoUser que es del usuario con el que se tiene la conversacion
    //conversacion contiene tu id - mensaje, su id - mensaje
    public void crearConversacion(String tuemail, String id,String nombre,String foto)
    {
        String carpeta = tuemail+"/"+id;
        String ruta = tuemail+"/"+id+"/conversacion";
        String ruta2 = tuemail+"/"+id+"/infoUser";
        File archivo2 = new File(ruta2);
        File archivo = new File(ruta);
        File carpet = new File(carpeta);
        if(!archivo2.exists())
        {
            if(!carpet.exists())
            carpet.mkdir();
            
            try
            {
                if(!archivo.exists())
                archivo.createNewFile();
                if(!archivo.exists())
                archivo2.createNewFile();
                
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo2));
                bw.write(id);
                bw.newLine();
                bw.write(nombre);
                bw.newLine();
                bw.write(foto);
                bw.newLine();
                bw.close();
            }catch(IOException ex)
            {
                System.out.print(ex);
            }
        }
    }
    //elimina la conversacion del directorio
    public void eliminarConversacion(String tuemail, String id)
    {
        //instanciamos el directorio
        File directorio = new File(tuemail+"/"+id+"/");
        //recorremos el directorio y borramos todos los archivos
        File[] ficheros = directorio.listFiles();
        for (File fichero : ficheros) {
            fichero.delete();
        }
        //finalmente borramos el directorio
        directorio .delete();
        //nunca habran directorios por lo que no tenemos que preocuparnos
    }
    //obtenemos los directorios de las conversaciones
    public String[] obtenerConversaciones(String tuemail)
    {
        File directorio = new File(tuemail+"/");
        //recorremos el directorio y borramos todos los archivos
        File[] ficheros = directorio.listFiles();
        int contador = 0;
        for (File fichero : ficheros) {
            if(fichero.isDirectory())
            {
                contador++;
            }
        }
        String [] conversaciones = new String[contador];
        int contador2 = 0;
        for (File fichero : ficheros) {
            if(fichero.isDirectory())
            {
               conversaciones[contador2] = fichero.getName();  
               contador2++;
            }
        }
        return conversaciones;
    }
    //obtiene nombre de grupo o chat
    public String obtenerNombre(String tuemail,String id)
    {
        String nombre = "";
        File archivo_info = new File(tuemail+"/"+id+"/infoUser");
        System.out.print("buscando conversacion ->"+id);
        if(archivo_info.exists())
        {
            if(this.leer(archivo_info).length >= 2)
            {
                return this.leer(archivo_info)[1];
            }            
        }
        return nombre;
    }
    //metodo de descompilar
    public void descomprimir(String bites,String archivoDestino, String dire)
    {
        String bitesr []= bites.split(",");
        byte [] bitesv= new byte[bitesr.length];
        boolean primero= true;
        int contador = 0;
        for(String a:bitesr)
        {
                bitesv[contador]=(byte)Integer.parseInt(a,16);              
                contador++;
        }
        try
        {
        OutputStream out = new FileOutputStream(archivoDestino);
        out.write(bitesv);
        out.close(); 
        
        ZipInputStream zis = new ZipInputStream(new FileInputStream(archivoDestino));
        ZipEntry entrada;
        while (null != (entrada=zis.getNextEntry()) ){
           System.out.println(entrada.getName());

           FileOutputStream fos = new FileOutputStream(dire+entrada.getName());
           int leido;
           byte [] buffer = new byte[1024];
           while (0<(leido=zis.read(buffer))){
              fos.write(buffer,0,leido);
           }
           fos.close();
           zis.closeEntry();
        }
        zis.close();
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    //metodo para cargar todas las conversaciones
    public String[] obtenerConversacion(String tuemail, String id)
    {
        File archivo_com = new File(tuemail+"/"+id+"/conversacion");
        if(archivo_com.exists())
        {
            if(this.leer(archivo_com).length == 1 && this.leer(archivo_com)[0].length() == 0)
            {
                return new String[0];
            }
            else
            {
                return this.leer(archivo_com);
            }
        }
        return null;
    }
    
    public void addmensaje(String tuemail,String id,String men)
    {
        File archivo_com = new File(tuemail+"/"+id+"/conversacion");
        if(archivo_com.exists())
        {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(archivo_com,true));
                bw.write(men);
                bw.newLine();
            } catch (IOException ex) {
                Logger.getLogger(almacenamiento.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(almacenamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
    }
    
    public void addmensajenuevo(String tuemail,String id,String men)
    {
        File archivo_com2 = new File(tuemail+"/"+id);
        File archivo_com = new File(tuemail+"/"+id+"/conversacion");
        if(!archivo_com.exists())
        {
            archivo_com2.mkdir();
            if(!archivo_com.exists())
            {
                try {
                    archivo_com.createNewFile();
                    BufferedWriter bw = null;
                    bw = new BufferedWriter(new FileWriter(archivo_com));
                    bw.write(men);
                    bw.newLine();
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(almacenamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    }
