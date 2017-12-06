/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Key;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JVAC
 */
public class hilo extends Thread {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private conexion padre;
    private Key clave_session;
    private PublicKey clave_publica;
            
    public hilo(Socket socket, conexion p) 
    {
        this.socket = socket;
        this.padre = p;
        try 
        {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) 
        {
            Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconnectar() 
    {
        try 
        {
            socket.close();
        } catch (IOException ex)
        {
            Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        String accion;
        try {
            boolean seguir = true;
            while (seguir)
            {
                accion = dis.readUTF();
                if(accion.compareTo("") != 0)
                {
                    if(accion.split("#odin@").length >= 2 && accion.split("#odin@")[0].compareToIgnoreCase("Sbienvenida")== 0)
                    {
                        System.out.println("recibimos su publica");
                        this.clave_publica = padre.recuperarSE().loadcp_externa(accion.split("#odin@")[1]);
                        //ahora encriptamos con su publica nuestra clave publica 
                        String mensaje = "Cbienvenida"+"#odin@"+padre.recuperarSE().getClavePublica_envio();
                        dos.writeUTF(mensaje);
                        System.out.println("enviamos nuestra publica");
                    }
                    else if(padre.recuperarSE().desencriptarPrivada(accion) != null && padre.recuperarSE().desencriptarPrivada(accion).contains("#odin@") && padre.recuperarSE().desencriptarPrivada(accion).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarPrivada(accion).split("#odin@")[0].compareToIgnoreCase("CVok") == 0)//el servidor te envia una clave aes CVok
                    {
                        System.out.println("recibimos la aes de session del servidor");
                        String partes [] = padre.recuperarSE().desencriptarPrivada(accion).split("#odin@");
                        this.clave_session = padre.recuperarSE().loadcs_externa(partes[1]);
                        String mensaje = "CSok#odin@"+padre.recuperarSE().getClaveSession_envio();
                        dos.writeUTF(padre.recuperarSE().encriptarPublica(this.clave_publica,mensaje));
                        System.out.println("enviamos nuestra aes de session");
                    }
                    else if(padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@")[0].compareToIgnoreCase("CONFISECURITY") == 0)//el servidor te envia una clave aes
                    {
                        System.out.println("Conexion segura establecida");
                    }
                    else if(padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@")[0].compareToIgnoreCase("existEmail") == 0)
                    {
                        String partes [] = padre.recuperarSE().desencriptarMiSessionSuSession(accion,this.clave_session).split("#odin@");
                        if(partes[1].compareToIgnoreCase("true") == 0)
                        {
                            System.out.println("Si existe");
                        }
                        else
                        {
                            System.out.println("No existe");
                        }
                    }
                    else
                    {
                       System.out.println("mensaje no reconocido -> "+accion);
                    }
                }
            }
        } catch (IOException ex) {
            /*Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);*/
           /*detectar cierre de sesion*/
        }
    }
    
}
