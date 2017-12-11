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
import java.util.ArrayList;
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
    private int codes; 
    private ArrayList<Integer> verificaciones;
    public hilo(Socket socket, conexion p) 
    {
        this.socket = socket;
        this.padre = p;
        this.codes = 0;
        verificaciones = new ArrayList();
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
                dos.writeUTF("vivo");
                accion = dis.readUTF();
                if(accion.compareTo("") != 0 && !(accion.contains("vivo")))
                {
                    if(accion.contains("#hela@") == false && accion.split("#odin@").length >= 2 && accion.split("#odin@")[0].compareToIgnoreCase("Sbienvenida")== 0)
                    {
                        padre.cambiarEstado(1);
                        System.out.println("recibimos su publica");
                        this.clave_publica = padre.recuperarSE().loadcp_externa(accion.split("#odin@")[1]);
                        //ahora encriptamos con su publica nuestra clave publica 
                        String mensaje = "Cbienvenida"+"#odin@"+padre.recuperarSE().getClavePublica_envio();
                        dos.writeUTF(mensaje);
                        System.out.println("enviamos nuestra publica");
                    }
                    else if(accion.contains("#hela@") == false && padre.recuperarSE().desencriptarPrivada(accion) != null && padre.recuperarSE().desencriptarPrivada(accion).contains("#odin@") && padre.recuperarSE().desencriptarPrivada(accion).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarPrivada(accion).split("#odin@")[0].compareToIgnoreCase("CVok") == 0)//el servidor te envia una clave aes CVok
                    {
                        System.out.println("recibimos la aes de session del servidor");
                        String partes [] = padre.recuperarSE().desencriptarPrivada(accion).split("#odin@");
                        this.clave_session = padre.recuperarSE().loadcs_externa(partes[1]);
                        String mensaje = "CSok#odin@"+padre.recuperarSE().getClaveSession_envio();
                        dos.writeUTF(padre.recuperarSE().encriptarPublica(this.clave_publica,mensaje));
                        System.out.println("enviamos nuestra aes de session");
                        padre.recuperarSE().crearUser("servidor",this.clave_session, this.clave_publica);
                    }
                    else if(accion.contains("#hela@") == false && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@")[0].compareToIgnoreCase("CONFISECURITY") == 0)//el servidor te envia una clave aes
                    {
                        padre.cambiarEstado(2);
                        System.out.println("Conexion segura establecida");
                    }
                    else if(accion.contains("#hela@") == false && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@")[0].compareToIgnoreCase("existEmail") == 0)
                    {
                        String partes [] = padre.recuperarSE().desencriptarMiSessionSuSession(accion,this.clave_session).split("#odin@");
                        padre.contestEmail(partes[2],Boolean.parseBoolean(partes[1]));
                    }
                    else if(accion.contains("#hela@") == false && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@")[0].compareToIgnoreCase("contestRegistro") == 0)
                    {
                        String partes [] = padre.recuperarSE().desencriptarMiSessionSuSession(accion,this.clave_session).split("#odin@");
                        padre.contestRegistro(partes[2]);
                    }
                    else if(accion.contains("#hela@") && padre.recuperarSE().desencriptarMiSessionSuSession(accion.split("#hela@")[0], clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion.split("#hela@")[0], clave_session).split("#odin@")[0].compareToIgnoreCase("contestLogin") == 0)
                    {
                        String partes [] = padre.recuperarSE().desencriptarMiSessionSuSession(accion.split("#hela@")[0],this.clave_session).split("#odin@");
                        System.out.println(partes.length);
                        String foto = accion.split("#hela@")[1];
                        //id nombre foto
                        padre.contestLogin(partes[2],partes[1], foto);
                    }
                    else if(accion.contains("#hela@") && padre.recuperarSE().desencriptarMiSessionSuSession(accion.split("#hela@")[0], clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion.split("#hela@")[0], clave_session).split("#odin@")[0].compareToIgnoreCase("searchUser") == 0)
                    {
                        String partes [] = padre.recuperarSE().desencriptarMiSessionSuSession(accion.split("#hela@")[0],this.clave_session).split("#odin@");
                        String fototito = "";
                        if(accion.split("#hela@").length > 1)
                        {
                           fototito  = accion.split("#hela@")[1];
                        }
                        if(partes.length >= 4)
                        padre.contestSearchUser(partes[1], partes[2], partes[3], fototito);
                    }
                    else if(accion.contains("#hela@") == false && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@").length >= 2 && padre.recuperarSE().desencriptarMiSessionSuSession(accion, clave_session).split("#odin@")[0].compareToIgnoreCase("SentMen") == 0)
                    {
                        String partes [] = padre.recuperarSE().desencriptarMiSessionSuSession(accion,this.clave_session).split("#odin@");
                        System.out.println(partes[0]+" - "+partes[1]);
                        String partes2 [] = partes[1].split("##mensaje@@");
                        String partes3 [] = partes[1].split("#codes@");
                        if(partes3.length >= 2)
                        {   
                            if(!this.verificaciones.contains(Integer.parseInt(partes3[1])))
                            {
                                String mensaje = "OKMEN#odin@"+partes3[1];
                                System.out.println("Enviado mensaje de confirmacion de llegada ->"+mensaje);
                                dos.writeUTF(padre.recuperarSE().encriptarMiSessionSuSession(mensaje, clave_session));
                                if(partes2.length >= 2)
                                padre.sentMen(partes2[0], partes2[1]);
                                this.verificaciones.add(Integer.parseInt(partes3[1]));
                            }

                        }
                    }
                    else
                    {
                       System.out.println("mensaje no reconocido -> "+accion);
                    }
                }
                
                if(accion.contains("vivo"))
                {
                    
                }

            }
        } catch (IOException ex) {
            /*Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);*/
           /*detectar cierre de sesion*/
           padre.cambiarEstado(0);
           System.out.println("Error de hilo -> "+ex);
        }
    }
    
}
