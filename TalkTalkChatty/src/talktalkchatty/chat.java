/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

<<<<<<< HEAD
=======
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

>>>>>>> master
/**
 *
 * @author JVAC
 */
public class chat extends javax.swing.JFrame {

    /**
     * Creates new form chat
     */
    public chat() {
        initComponents();
<<<<<<< HEAD
=======
        
        Imagen imgUsu = new Imagen(50,50,"logoTTC.png");
        panelImgConversacion.add(imgUsu);
        panelImgConversacion.repaint();
        
        // Preparada para anyadir usuarios y conversaciones
        CargarListaConversaciones();
>>>>>>> master
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
        jPanel1 = new javax.swing.JPanel();
<<<<<<< HEAD
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
=======
        botonAnyadir = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaConversaciones = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JEditorPane();
        botonEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTexto = new javax.swing.JEditorPane();
        lab_ConectUsu = new javax.swing.JLabel();
        nomConversacion = new javax.swing.JLabel();
        panelImgConversacion = new javax.swing.JPanel();
        botonEmoji = new javax.swing.JButton();
        botonAdjuntar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
>>>>>>> master

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

<<<<<<< HEAD
=======
        botonAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/plusIconMini.png"))); // NOI18N
        botonAnyadir.setMaximumSize(new java.awt.Dimension(35, 35));
        botonAnyadir.setMinimumSize(new java.awt.Dimension(35, 35));
        botonAnyadir.setPreferredSize(new java.awt.Dimension(35, 35));
        botonAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnyadirActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/trashIconMini.png"))); // NOI18N
        botonEliminar.setToolTipText("");
        botonEliminar.setPreferredSize(new java.awt.Dimension(35, 35));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        listaConversaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaConversacionesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listaConversaciones);

>>>>>>> master
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 153, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jEditorPane2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);
=======
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAnyadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAnyadir, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pantalla.setEditable(false);
        jScrollPane2.setViewportView(pantalla);

        botonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/sendIconMini.png"))); // NOI18N
        botonEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEnviarMouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(inputTexto);
        inputTexto.getAccessibleContext().setAccessibleName("cosaPrueba");

        lab_ConectUsu.setText("Última conexión: 18:09");

        nomConversacion.setText("Conversación");

        panelImgConversacion.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout panelImgConversacionLayout = new javax.swing.GroupLayout(panelImgConversacion);
        panelImgConversacion.setLayout(panelImgConversacionLayout);
        panelImgConversacionLayout.setHorizontalGroup(
            panelImgConversacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelImgConversacionLayout.setVerticalGroup(
            panelImgConversacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        botonEmoji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/emoji CS mini.png"))); // NOI18N
        botonEmoji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmojiActionPerformed(evt);
            }
        });

        botonAdjuntar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/clipIconMini.png"))); // NOI18N
        botonAdjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdjuntarActionPerformed(evt);
            }
        });

        menuArchivo.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Enviar imagen");
        menuArchivo.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Enviar vídeo");
        menuArchivo.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem3.setText("Enviar audio");
        menuArchivo.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Enviar documento");
        menuArchivo.add(jMenuItem4);

        jMenuBar1.add(menuArchivo);
>>>>>>> master

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImgConversacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomConversacion)
                            .addComponent(lab_ConectUsu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAdjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
>>>>>>> master
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
<<<<<<< HEAD
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(nomConversacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_ConectUsu))
                            .addComponent(panelImgConversacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAdjuntar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
>>>>>>> master
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
=======
    private void botonEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEnviarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEnviarMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void botonAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnyadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAnyadirActionPerformed

    private void listaConversacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaConversacionesMouseClicked
        String valor = listaConversaciones.getSelectedValue();
        int indice = listaConversaciones.getSelectedIndex(); // empieza en 0
        
        nomConversacion.setText(valor);
        
        /*if (valor == grupo) {
            // count miembros del grupo
            lab_ConectUsu.setText(SacarNumeroMiembrosGrupo(indice,valor)+" miembros");
        } else {
            lab_ConectUsu.setText("Última conexión de la persona");
        }*/
        
        // Cargar los textos de esta conversación
        //CargarConversacion();
    }//GEN-LAST:event_listaConversacionesMouseClicked

    private void botonEmojiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmojiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEmojiActionPerformed

    private void botonAdjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdjuntarActionPerformed
        // TODO add your handling code here:
        int relVal = adjuntarArchivo.showOpenDialog(adjuntarFrame);
        if (relVal == JFileChooser.APPROVE_OPTION) {
            //Ha subido un archivo
            File file = adjuntarArchivo.getSelectedFile();
            try {
              //Aqui habria que poner lo que hace con el archivo
            } catch (Exception ex) {
              System.out.println("problem accessing file"+file.getAbsolutePath());
            }
        } 
        else {
            //No ha subido nada
            System.out.println("File access cancelled by user.");
        }   
    }//GEN-LAST:event_botonAdjuntarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        EliminarConversacion();
    }//GEN-LAST:event_botonEliminarActionPerformed

>>>>>>> master
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
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat().setVisible(true);
            }
        });
<<<<<<< HEAD
=======
        
        /*botonEnviar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        //ComprobarIpPuerto(textFieldIpServidor.getText());
                }
        });*/
        
        
>>>>>>> master
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
<<<<<<< HEAD
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
=======
    private javax.swing.JFileChooser adjuntarArchivo;
    private javax.swing.JFrame adjuntarFrame;
    private javax.swing.JButton botonAdjuntar;
    private javax.swing.JButton botonAnyadir;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEmoji;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JEditorPane inputTexto;
>>>>>>> master
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
<<<<<<< HEAD
    private javax.swing.JScrollPane jScrollPane2;
=======
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lab_ConectUsu;
    private javax.swing.JList<String> listaConversaciones;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JLabel nomConversacion;
    private javax.swing.JPanel panelImgConversacion;
    private javax.swing.JEditorPane pantalla;
>>>>>>> master
    // End of variables declaration//GEN-END:variables
    
    
    
    private void CargarConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int SacarNumeroMiembrosGrupo(int indice, String grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void CargarListaConversaciones() {
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement("Maria");
        modelo.addElement("Perez");
        modelo.addElement("Grupo 1");
        modelo.addElement("Grupo 2");
        modelo.addElement("Conversación");
        listaConversaciones.setModel(modelo);
        
    }
    
    private void EliminarConversacion() {
        int indice = listaConversaciones.getSelectedIndex(); // empieza en 0
        
        //Comprobamos que haya algo seleccionado
        if (indice >= 0) {
            String mensaje = "¿Estás seguro de eliminar esta conversación?";
            int resp = JOptionPane.showConfirmDialog(this,mensaje,"Eliminar",
                JOptionPane.YES_NO_OPTION);

            if (resp == 0) {
                DefaultListModel modelo = (DefaultListModel) listaConversaciones.getModel();
                modelo.remove(indice);
            }
        }
    }
}
