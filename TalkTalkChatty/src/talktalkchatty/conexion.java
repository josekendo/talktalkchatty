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
    //comprobar email 
    public void comprobaremail(String email)
    {
    }
}
