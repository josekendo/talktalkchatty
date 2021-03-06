/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package talktalkchatty;

import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author debor
 */
public class registro extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private seguridad se;
    private conexion co;
    
    public registro(seguridad seg, conexion con) {
        initComponents();
        se = seg;
        co = con;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNombreUsuario = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        campoDireccionFoto = new javax.swing.JTextField();
        botonExaminar = new javax.swing.JButton();
        botonVolverLogin = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        wrongRegistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("logoTTC.png")).getImage());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Registro de usuario");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nombre de usuario:");

        campoNombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        campoNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreUsuarioActionPerformed(evt);
            }
        });

        campoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        campoEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoEmailKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Correo electrónico:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Repetir contraseña:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

        jPasswordField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Foto de Usuario:");

        campoDireccionFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

        botonExaminar.setText("Examinar");
        botonExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExaminarActionPerformed(evt);
            }
        });

        botonVolverLogin.setText("Volver al login");
        botonVolverLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverLoginActionPerformed(evt);
            }
        });

        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        wrongRegistro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        wrongRegistro.setForeground(new java.awt.Color(255, 0, 0));
        wrongRegistro.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoDireccionFoto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonExaminar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(1, 1, 1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(1, 1, 1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoEmail)
                                    .addComponent(campoNombreUsuario))
                                .addGap(1, 1, 1)))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVolverLogin)
                        .addGap(100, 100, 100))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(wrongRegistro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(wrongRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(botonExaminar))
                    .addComponent(campoDireccionFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrar)
                    .addComponent(botonVolverLogin))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreUsuarioActionPerformed
    //funcion de abrir la ventana de seleccion de archivo para escoger una foto
    private void botonExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExaminarActionPerformed
        // TODO add your handling code here:
        int seleccion=0;

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);    //para solo abrir archivos
        seleccion = jFileChooser1.showOpenDialog(this);                             //abrimos la ventana de seleccion de archivo

        if(seleccion == javax.swing.JFileChooser.APPROVE_OPTION)                    //En caso de haber abierto la ventana de seleccion
        {
            java.io.File archivoElegido = jFileChooser1.getSelectedFile();          //copiamos el archivo
            try{
                String nombre = archivoElegido.getName();                           //copiamos su nombre
                String direccion = archivoElegido.getAbsolutePath();                //copiamos su direccion
                this.setTitle(nombre);                                              //ponemos su nombre como titulo en el selector de archivo
                campoDireccionFoto.setText(direccion);                              //y en el campo de texto de seleccion de foto de registro
                //vamos a comprobar las dimensiones de la imagen
                File archivo = new File(this.campoDireccionFoto.getText());
                if(archivo.exists() && archivo.isFile())
                {
                    if(!(archivo.length() < 2500*8))
                    {
                            wrongRegistro.setForeground(Color.RED);
                            wrongRegistro.setText("La imagen debe ser de 2,5KB maximo.");
                            this.campoDireccionFoto.setText("");
                    }
                }
            }                                                                       //copiamos la direccion del archivo para subirla al servidor
            catch(NullPointerException ex){}
        }
    }//GEN-LAST:event_botonExaminarActionPerformed

    private void botonVolverLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverLoginActionPerformed
        // TODO add your handling code here:
                new Login(se,co).setVisible(true); 
                this.dispose();
    }//GEN-LAST:event_botonVolverLoginActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:


        char[] psw1 = jPasswordField1.getPassword();
        char[] psw2 = jPasswordField2.getPassword();
        boolean iguales = false, lleno = true, nombreLleno=campoNombreUsuario.getText().isEmpty(),
                eMail = campoEmail.getText().isEmpty(), foto = campoDireccionFoto.getText().isEmpty();
        int letra = 0;
        campoNombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        campoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        jPasswordField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        campoDireccionFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

        if(nombreLleno||eMail||jPasswordField1.getPassword().length==0||jPasswordField2.getPassword().length==0||foto){
            if(nombreLleno)
                campoNombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
            if(eMail)
                campoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
            if(jPasswordField1.getPassword().length==0)
                jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
            if(jPasswordField2.getPassword().length==0)
                jPasswordField2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
            if(foto)
                campoDireccionFoto.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
            wrongRegistro.setText("Faltan campos por rellenar");
        }


        else{
            iguales=true;
            if(psw1.length==psw2.length){
                while(iguales&&letra<psw1.length){
                    if(psw1[letra]!=psw2[letra])
                        iguales=false;
                    letra++;
                }
            }
            else
                iguales=false;
            if(!iguales){
                jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
                jPasswordField2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 1));
                wrongRegistro.setForeground(Color.RED);
                wrongRegistro.setText("Las contraseñas no coinciden");
            }
        }
        if(iguales && new File(this.campoDireccionFoto.getText()).exists()){
                    //email, nombre, password, foto
                    campoEmail.setEditable(false);
                    campoNombreUsuario.setEditable(false);
                    jPasswordField1.setEditable(false);
                    jPasswordField2.setEditable(false);
                    almacenamiento al = new almacenamiento();
                    wrongRegistro.setForeground(Color.BLUE);
                    wrongRegistro.setText("Se esta registrando... Espere please..");
                    se.crearSecreta(se.sha512(new String(jPasswordField1.getPassword())));
                    String fotoEncriptada = al.comprimir(campoDireccionFoto.getText(), se);
                    co.registro(this.campoEmail.getText(),this.campoNombreUsuario.getText(),se.sha512(new String(jPasswordField1.getPassword())),fotoEncriptada, this);
                    //co.registro(campoEmail.getText(),campoNombreUsuario.getText(),se.sha512(password));
                    //new Login(se,co).setVisible(true);
        }      
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void campoEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEmailKeyReleased
        // TODO add your handling code here:
        //comprobamos que el email es valido
        if(co.getEstado() == 2)
            co.comprobarEmail(campoEmail.getText(), this);
        else
            wrongRegistro.setText("No se puede comprobar el correo");
    }//GEN-LAST:event_campoEmailKeyReleased

    public void contestEmail(String email,boolean estado)
    {
        if(estado && campoEmail.getText().compareToIgnoreCase(email) == 0)
        {
             wrongRegistro.setForeground(Color.GREEN);
             wrongRegistro.setText("Esta disponible");
        }
        else
        {
            wrongRegistro.setForeground(Color.RED);
            wrongRegistro.setText("No esta disponible este email");
        }
    }
    
    public void mensajeError(String error)
    {
        JOptionPane.showMessageDialog(this,error); 
    }
    
    public void contestRegistro(String id)
    {
        try {
            if(id.compareToIgnoreCase("00") != 0)
            {
                wrongRegistro.setForeground(Color.BLUE);
                wrongRegistro.setText("Registro Correcto, Pasando a Login ----->");
                Thread.sleep(4000);
                new Login(se,co,this.campoEmail.getText()).setVisible(true);
                this.dispose();
            }
            else
            {
                wrongRegistro.setForeground(Color.RED);
                wrongRegistro.setText("Ha ocurrido un error, intentelo mas tarde.");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonExaminar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonVolverLogin;
    private javax.swing.JTextField campoDireccionFoto;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombreUsuario;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel wrongRegistro;
    // End of variables declaration//GEN-END:variables
}
