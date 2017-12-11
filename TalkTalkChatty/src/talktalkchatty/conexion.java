/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JVAC
 */
public class conexion {
    private String ip;
    private int puerto;
    private Socket conexion;   
    protected DataOutputStream salida;
    protected DataInputStream entrada;
    private seguridad se;
    private registro re;
    private Login lo;
    private chat ch;
    private int estado;
    //inicializamos el objeto conexion(unico) pasandole la ip y el puerto
    public conexion(String ipp, int puertop) 
    {
        this.ip = ipp;
        this.puerto = puertop;
        this.entrada = null;
        this.salida = null;
        this.estado = 0;//no hay conexion
    }
    //este metodo informa si el servidor esta disponible, devuelve true si lo esta y false si no
    public boolean testserver()
    {
        int contador = 0;
        try 
        {
            InetAddress ping = InetAddress.getByName(ip);
            if(ping.isReachable(5000))
            {
                contador++;
            }
            else 
            {
                contador--;
                System.out.println("no");
            }
        } 
        catch (IOException ex) 
        { 
            System.out.println("No se ha podido realizar la prueba de conexion -> "+ ex); 
        } 
        if(contador == 1)
        {
            System.out.println("Servidor disponible "+ip+"  [OK]");
            return true;
        }
        System.out.println("No esta disponible el servidor por la ip -> "+ip);
        return false;
    }
    //creamos el objeto que establece la conexion con el servidor
    public boolean nuevaconexion(seguridad seg)
    {
        try 
        {
            conexion = new Socket(ip,puerto);
            salida = new DataOutputStream(conexion.getOutputStream());
            entrada = new DataInputStream(conexion.getInputStream());
            se = seg;
            ((hilo) new hilo(conexion,this)).start();//iniciamos escucha 
            return true;
        } 
        catch (IOException ex) 
        {
            estado = 0;
            System.out.println("Ha ocurrido un error al establecer la conexion ->"+ex);
        }
        return false;
    }
    //envia un mensaje al servidor para que lo prepare para el cliente (quizas lo pase a json.... vere) 
    public boolean enviarmensaje(String miID, String destinoID, String men)
    {
        if(this.entrada != null && this.salida != null)
        {
            try {
                String mensaje = "SentMen#odin@"+miID+"#odin@"+destinoID+"#odin@"+men;
                mensaje = se.encriptarMiSessionSuSession("servidor",mensaje); 
                salida.writeUTF(mensaje);
            } catch (IOException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    //recupera seguridad
    public seguridad recuperarSE()
    {
        return se;
    }
    
    
    
    // ------------------------ Registro
    //comprobar envia una peticion al servidor para comprobar la disponibilidad de ese correo 
    public void comprobarEmail(String email,registro res)
    {
        try {
            String mensaje = "existEmail"+"#odin@"+email;
            mensaje = se.encriptarMiSessionSuSession("servidor",mensaje);
            salida.writeUTF(mensaje); 
            re = res;
        } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //cuando se devuelve la peticion de comprobaremail se llama a este funcion
    public void contestEmail(String email, boolean estado)
    {
        if(re != null)
        {
            re.contestEmail(email, estado);
        }
    }
    //enviamos una peticion de registro
    public void registro(String email,String nombre, String password, String foto,registro res)
    {
        try {
            if(estado == 2)
            {
                re = res;
                String mensaje = "RegistroUser"+"#odin@"+email+"#odin@"+nombre+"#odin@"+password;
                System.out.println(mensaje);
                mensaje = se.encriptarMiSessionSuSession("servidor",mensaje);
                mensaje = mensaje+"#hela@"+foto;
                System.out.print(salida.size());
                salida.writeUTF(mensaje);
            }
            else
            {
                res.mensajeError("El servidor no esta disponible intentelo mas tarde");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //
    public void contestRegistro(String id)
    {
        re.contestRegistro(id);
    }
    // -------------------------Fin registro
    //login
    public void login(String nombre, String pass, Login log)
    {
        try {
            lo = log;
            if(estado == 2)
            {
                String mensaje = "LoginUser"+"#odin@"+nombre+"#odin@"+pass;
                mensaje = se.encriptarMiSessionSuSession("servidor",mensaje);
                salida.writeUTF(mensaje);
            }
            else
            {
                if(log != null)
                log.mensajeError("El servidor no esta disponible intentelo mas tarde");
            }
        } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void contestLogin(String nombre, String id, String foto)
    {
        lo.contestLogin(id, nombre, foto);
    }
    //fin login
    //chat
    public void searchUser(String ids, chat cha)
    {
        try {
            ch = cha;
            String mensaje = "searchUser"+"#odin@"+ids;
            mensaje = se.encriptarMiSessionSuSession("servidor",mensaje);
            System.out.println("comprobando usuario");
            salida.writeUTF(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void contestSearchUser(String id,String nombre, String confirmacion, String foto)
    {
        ch.contestSearchUser(id,nombre,confirmacion,foto);
    }
    
    public void sentMen(String origen,String mensaje)
    {
        ch.sentMen(origen,mensaje);
    }
    
    public void asignarCH(chat c)
    {
        ch = c;
    }
    
    public void cambiarImagen(String id, String photo)
    {
        try {
            String mensaje = "CambioImagen#odin@"+id;
            mensaje = se.encriptarMiSessionSuSession("servidor",mensaje);
            mensaje = mensaje+"#hela@"+photo;
            salida.writeUTF(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarEstado(int e)
    {
        this.estado = e;
    }
    
    public int getEstado()
    {
        return this.estado;
    }
    
}
