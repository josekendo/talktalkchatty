/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jmld4
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private seguridad se;
    private almacenamiento al;
    private conexion co;
    
    public Login() {
        initComponents();
        Imagen Imagen = new Imagen(jPanel1.getHeight(), jPanel1.getWidth(),"logoTTC.png");
        jPanel1.add(Imagen);
        jPanel1.repaint();
        wrong.setVisible(false);
        //conectamos con el servidor 
        se = new seguridad();//esto se hereda de una ventana a otra
        se.crearSessionAes();
        se.crearrsa();
        al = new almacenamiento();
        String infoConexion [] = al.recuperarInfoConexion();
        co = new conexion(infoConexion[0],Integer.parseInt(infoConexion[1]));
        co.nuevaconexion(se);
    }

    public Login(seguridad seg, conexion con) {
        initComponents();
        Imagen Imagen = new Imagen(jPanel1.getHeight(), jPanel1.getWidth(),"logoTTC.png");
        jPanel1.add(Imagen);
        jPanel1.repaint();
        wrong.setVisible(false);
        //conectamos con el servidor 
        se = seg;
        co = con;
    }
    
    public Login(seguridad seg, conexion con,String em) {
        initComponents();
        Imagen Imagen = new Imagen(jPanel1.getHeight(), jPanel1.getWidth(),"logoTTC.png");
        jPanel1.add(Imagen);
        jPanel1.repaint();
        wrong.setVisible(false);
        //conectamos con el servidor 
        se = seg;
        co = con;
        this.user.setText(em);
        this.password.hasFocus();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        acceder = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        forgot = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        wrong = new javax.swing.JLabel();
        registro1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jCheckBox1.setText("Recordarme");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("logoTTC.png")).getImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nick o email: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 94, 34));

        jLabel2.setText("Password: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 217, 94, 34));

        password.setNextFocusableComponent(acceder);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 223, 130, -1));

        acceder.setText("Acceder");
        acceder.setNextFocusableComponent(registro1);
        acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accederActionPerformed(evt);
            }
        });
        getContentPane().add(acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 89, 43));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(145, 145));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 18, -1, -1));

        forgot.setText("¿Password?");
        forgot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        forgot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        forgot.setNextFocusableComponent(user);
        forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotActionPerformed(evt);
            }
        });
        getContentPane().add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 130, 56));

        user.setNextFocusableComponent(password);
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 182, 130, -1));

        wrong.setVisible(false);
        wrong.setForeground(new java.awt.Color(255, 0, 0));
        wrong.setText("Usuario o contraseña incorrectos");
        wrong.setFocusable(false);
        getContentPane().add(wrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 317, -1, -1));

        registro1.setText("Regístrate");
        registro1.setNextFocusableComponent(forgot);
        registro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registro1ActionPerformed(evt);
            }
        });
        getContentPane().add(registro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 130, 56));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 20, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accederActionPerformed
        // TODO add your handling code here:

        //Buscar el nick en la "Base de datos"
        wrong.setVisible(false);
        se.crearSecreta(se.sha512(new String(this.password.getPassword())));
        co.login(this.user.getText(),se.sha512(new String(this.password.getPassword())),this);
        
    }//GEN-LAST:event_accederActionPerformed
    
    public void contestLogin(String id,String nombre,String foto)
    {
        System.out.println(id);
        if(id.compareTo("00") != 0)
        {
            //aqui nos logeamos
            chat nuevo = new chat(this.co,this.se,id,nombre,foto,this.user.getText());//pasamos foto, nombre,id,email, tambien la verificacion
            nuevo.setLocationRelativeTo(null);
            nuevo.setVisible(true);
            this.dispose();
            System.out.println("correcto");            
        }
        else
        {
            System.out.println("incorrecto");
            wrong.setVisible(true);
        }
    }
    
    public void mensajeError(String error)
    {
        JOptionPane.showMessageDialog(this,error); 
    }
    
    private void forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(() -> {
           record nueva = new record(se,co);
           nueva.setLocationRelativeTo(null);
           nueva.setVisible(true);
        });
        /*javax.swing.JPanel recordar = new record();
            this.getContentPane().add(recordar);
            recordar.setVisible(true);
        });*/
        //this.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_forgotActionPerformed

    private void registro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registro1ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(() -> {
            registro nueva = new registro(se,co);
            nueva.setLocationRelativeTo(null);
            nueva.setVisible(true);
            
        });
        this.setVisible(false);
    }//GEN-LAST:event_registro1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login nueva = new Login();
                nueva.setLocationRelativeTo(null);
                nueva.setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceder;
    private javax.swing.JButton forgot;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton registro1;
    private javax.swing.JTextField user;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
