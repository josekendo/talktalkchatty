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
                    if(accion.compareTo("SConectado") == 0)
                    {
                        System.out.println("El servidor te da la bievenida");
                    }
                    else if(accion.contains("SRSAPUBLICA"))//el servidor te envia una clave rsa publica
                    {
                        System.out.println("Recepcion de RSA publica");
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
