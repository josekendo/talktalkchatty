/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import java.awt.Color;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author JVAC
 */
public class Perfil extends javax.swing.JFrame {

    /**
     * Creates new form Perfil
     */
    private seguridad se;
    private conexion co;
    private String id;
    private String nombre;
    private String foto;
    private String email;
    private File file;
    public Perfil(seguridad seg, conexion con, String ids, String nom, String photo,String e) {
        initComponents();
        se = seg;
        co = con;
        id = ids;
        email = e;
        nombre = nom;
        file = null;
        foto = photo;
        Imagen img;
        String ima = new almacenamiento().descomprimir(photo,email+"/archivo.temp",email+"/");
        if(ima != "")
        {
           img = new Imagen(fotoPerfil.getWidth(),fotoPerfil.getHeight(),ima,1);
        }
        else
        {
           img = new Imagen(fotoPerfil.getWidth(),fotoPerfil.getHeight(),"logoTTC.png");        
        }
        fotoPerfil.add(img);
        fotoPerfil.repaint();
        
        
        Imagen cambiar = new Imagen(fotoPerfil1.getHeight(), fotoPerfil1.getWidth(),"CambiarImagen.png");
        fotoPerfil1.add(cambiar);
        fotoPerfil1.repaint();
        fotoPerfil1.setVisible(false);
        
        
        inputName.setText(nombre);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adjuntarFrame = new javax.swing.JFrame();
        adjuntarArchivo = new javax.swing.JFileChooser();
        fotoPerfil = new javax.swing.JPanel();
        fotoPerfil1 = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();

        javax.swing.GroupLayout adjuntarFrameLayout = new javax.swing.GroupLayout(adjuntarFrame.getContentPane());
        adjuntarFrame.getContentPane().setLayout(adjuntarFrameLayout);
        adjuntarFrameLayout.setHorizontalGroup(
            adjuntarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(adjuntarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adjuntarFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(adjuntarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        adjuntarFrameLayout.setVerticalGroup(
            adjuntarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(adjuntarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adjuntarFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(adjuntarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fotoPerfil.setBackground(new java.awt.Color(204, 255, 255));
        fotoPerfil.setPreferredSize(new java.awt.Dimension(175, 175));
        fotoPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirCambiar(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarCambiar(evt);
            }
        });

        fotoPerfil1.setBackground(new java.awt.Color(255, 255, 255));
        fotoPerfil1.setPreferredSize(new java.awt.Dimension(175, 175));
        fotoPerfil1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotoPerfil1inputFoto(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fotoPerfil1abrirCambiar(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fotoPerfil1cerrarCambiar(evt);
            }
        });
        fotoPerfil1.setLayout(new javax.swing.OverlayLayout(fotoPerfil1));

        javax.swing.GroupLayout fotoPerfilLayout = new javax.swing.GroupLayout(fotoPerfil);
        fotoPerfil.setLayout(fotoPerfilLayout);
        fotoPerfilLayout.setHorizontalGroup(
            fotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fotoPerfilLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(fotoPerfil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fotoPerfilLayout.setVerticalGroup(
            fotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fotoPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoPerfil1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonCancelar.setText("Cancelar");
        botonCancelar.setPreferredSize(new java.awt.Dimension(78, 41));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText("Guardar");
        botonAceptar.setPreferredSize(new java.awt.Dimension(78, 41));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel.setText("Nombre:");

        inputName.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(fotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputName))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        //Cancela
        JOptionPane.showMessageDialog(this, "No se han realizado cambios");
        java.awt.EventQueue.invokeLater(() -> {
            new chat(co,se,id,nombre,foto,email).setVisible(true);
            
        });
        this.setVisible(false);
        
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void abrirCambiar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirCambiar
        // TODO add your handling code here:
        fotoPerfil1.setVisible(true);
    }//GEN-LAST:event_abrirCambiar

    private void cerrarCambiar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarCambiar
        // TODO add your handling code here:
        fotoPerfil1.setVisible(false);
    }//GEN-LAST:event_cerrarCambiar

    private void fotoPerfil1inputFoto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoPerfil1inputFoto
        // TODO add your handling code here:
        int relVal = adjuntarArchivo.showOpenDialog(adjuntarFrame);
        if (relVal == JFileChooser.APPROVE_OPTION) {
            //Ha subido un archivo
            this.file = adjuntarArchivo.getSelectedFile();
            if(this.file.length() < 2500)
            try{
                int i;
                String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                String[] extPermitidos = {"png","jpg"};
                
                for (i = 0; i < extPermitidos.length; i++) {
                    if(extPermitidos[i].equals(ext))break;
                }
                if(i<extPermitidos.length){
                    //Aqui habria que poner lo que hace con la foto
                    //Pero no la debe enviar al servidor, eso es al darle a guardar
                    Imagen cambiar = new Imagen(fotoPerfil1.getHeight(), fotoPerfil1.getWidth(),file.getPath(),1);
                    fotoPerfil1.add(cambiar);
                    fotoPerfil1.repaint();
                    fotoPerfil1.setVisible(true);
                }else{
                    throw new Exception(". Formato no permitido");
                }
            } catch (Exception ex) {
              System.out.println("problem accessing file"+file.getAbsolutePath());
            }
            else
            {
                this.file = null;
                JOptionPane.showMessageDialog(this, "La imagen es demasiado grande(2.5KB Maximo)");               
            }
        } 
        else {
            //No ha subido nada
            System.out.println("File access cancelled by user.");
        }   
    }//GEN-LAST:event_fotoPerfil1inputFoto

    private void fotoPerfil1abrirCambiar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoPerfil1abrirCambiar
        // TODO add your handling code here:
        fotoPerfil1.setVisible(true);
    }//GEN-LAST:event_fotoPerfil1abrirCambiar

    private void fotoPerfil1cerrarCambiar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoPerfil1cerrarCambiar
        // TODO add your handling code here:
        fotoPerfil1.setVisible(false);
    }//GEN-LAST:event_fotoPerfil1cerrarCambiar

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // GUARDAR EN EL SERVIDOR LOS DATOS
        //aqui envio de cambio de foto
        if(file != null)
        {
            almacenamiento al = new almacenamiento();
            String imagennueva = al.comprimir(file.getPath(), se);
            foto = imagennueva;
            co.cambiarImagen(this.id, imagennueva);
            JOptionPane.showMessageDialog(this, "Tus datos han sido guardados, en breve se actualizara su foto de perfil");
            java.awt.EventQueue.invokeLater(() -> {
                new chat(co,se,id,nombre,foto,email).setVisible(true);
            });
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No a seleccionado una imagen valida.");  
        }
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser adjuntarArchivo;
    private javax.swing.JFrame adjuntarFrame;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JPanel fotoPerfil;
    private javax.swing.JPanel fotoPerfil1;
    private javax.swing.JTextField inputName;
    private javax.swing.JLabel jLabel;
    // End of variables declaration//GEN-END:variables
}
