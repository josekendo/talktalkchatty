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
    //inicializamos el objeto conexion(unico) pasandole la ip y el puerto
    public conexion(String ipp, int puertop) 
    {
        this.ip = ipp;
        this.puerto = puertop;
        this.entrada = null;
        this.salida = null;
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
            System.out.println("Ha ocurrido un error al establecer la conexion ->"+ex);
        }
        return false;
    }
    //envia un mensaje al servidor para que lo prepare para el cliente (quizas lo pase a json.... vere) 
    public boolean enviarmensaje(String miID, String destinoID, String mensaje,int tipo)
    {
        if(this.entrada != null && this.salida != null)
        {
            try
            {
                if(tipo == 0)//envia mensajes normales aun destinatario
                {
                    this.salida.writeUTF(("@#men@#"+mensaje+"@#ori@#"+miID+"@#des@#"+destinoID+"##"));
                }
                if(tipo == 1)//envia clave publica(cifrada)
                {
                    this.salida.writeUTF(("@#clvp@#"+mensaje+"@#ori@#"+miID+"##"));                
                }
                if(tipo == 2)//envia clave secreta o aes(cifrada) 
                {
                    this.salida.writeUTF(("@#clvs@#"+mensaje+"@#ori@#"+miID));                
                }
                return true;
            } 
            catch (IOException ex)
            {
               System.out.println ("Error en el envio de mensaje [ERR] ->"+ex);
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
            re = res;
            String mensaje = "RegistroUser"+"#odin@"+email+"#odin@"+nombre+"#odin@"+password;
            System.out.println(mensaje);
            mensaje = se.encriptarMiSessionSuSession("servidor",mensaje);
            mensaje = mensaje+"#hela@"+foto;
            System.out.print(salida.size());
            salida.writeUTF(mensaje);
            
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
            String mensaje = "LoginUser"+"#odin@"+nombre+"#odin@"+pass;
            mensaje = se.encriptarMiSessionSuSession("servidor",mensaje); 
            salida.writeUTF(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void contestLogin(String nombre, String id, String foto)
    {
        lo.contestLogin(id, nombre, foto);
    }
    //fin login
}
