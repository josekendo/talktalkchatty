/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */

public class talktalkchatty extends Application 
{


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Login nueva = new Login();
        //con esta linea le decimos que queremos arrancarlo en el centro 
        nueva.setLocationRelativeTo(null);
        //hacemos visible la ventana de la consola
        nueva.setVisible(true);
        //vamos a arrancar el servicio de servidor
        System.out.println("arranque chatclient");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
