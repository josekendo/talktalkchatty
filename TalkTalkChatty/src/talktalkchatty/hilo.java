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
                        System.out.println("El servidor te da la bievenida y su clave publica");
                        this.clave_publica = padre.recuperarSE().loadcp_externa(accion.split("#odin@")[1]);
                        //ahora encriptamos con su publica nuestra clave publica 
                        String mensaje = "Cbienvenida"+"#odin@"+padre.recuperarSE().getClavePublica_envio();
                        dos.writeUTF(padre.recuperarSE().encriptarPublica(this.clave_publica, mensaje));
                    }
                    else if(padre.recuperarSE().desencriptarPrivada(accion).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarPrivada(accion).split("#odin@")[0].compareToIgnoreCase("CVok") == 0)//el servidor te envia una clave aes CVok
                    {
                        System.out.println("recibimos la aes del servidor");
                        String partes [] = padre.recuperarSE().desencriptarPrivada(accion).split("#odin@");
                        this.clave_session = padre.recuperarSE().loadcs_externa(partes[1]);
                        String mensaje = "CSok#odin@"+padre.recuperarSE().getClaveSession_envio();
                        dos.writeUTF(padre.recuperarSE().encriptarPublica(this.clave_publica,padre.recuperarSE().desencriptarAes(clave_session, mensaje)));
                    }
                    else if(accion.contains("SAES"))//el servidor te envia una clave aes
                    {
                        System.out.println("Recepcion de AES");                    
                    }
                    else if(accion.contains("men#@"))
                    {
                        System.out.println("Recepcion de mensaje");                              
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
