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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
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
    }
