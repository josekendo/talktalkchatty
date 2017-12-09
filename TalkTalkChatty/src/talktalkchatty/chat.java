/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talktalkchatty;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author JVAC
 */
public class chat extends javax.swing.JFrame {

    /**
     * Creates new form chat
     */
    private conexion co;
    private seguridad se;
    private String nombre;
    private String email;
    private String id;
    private String foto;
    DefaultListModel modelo;

    public chat(conexion con, seguridad seg, String ids, String nom, String photo) 
    {
        initComponents();
        co = con;
        se = seg;
        id = ids;
        nombre = nom;
        foto = photo;
        //AQUI imagen conversacion
        Imagen imgUsu = new Imagen(panelImgConversacion.getWidth(),panelImgConversacion.getHeight(),"logoTTC.png");
        panelImgConversacion.add(imgUsu);
        panelImgConversacion.repaint();
        
        //AQUI imagen perfil usuario
        Imagen imgPerfil = new Imagen(imagenPerfil.getWidth(),imagenPerfil.getHeight(),"logoTTC.png");
        imagenPerfil.add(imgPerfil);
        imagenPerfil.repaint();
        
        // Preparada para anyadir usuarios y conversaciones
        modelo = new DefaultListModel();
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
        botonAnyadir = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaConversaciones = new javax.swing.JList<>();
        Perfil = new javax.swing.JPanel();
        imagenPerfil = new javax.swing.JPanel();
        nomPerfil = new javax.swing.JLabel();
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
        botonMenu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

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

        botonAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/plusIconMini.png"))); // NOI18N
        botonAnyadir.setMaximumSize(new java.awt.Dimension(35, 35));
        botonAnyadir.setMinimumSize(new java.awt.Dimension(35, 35));
        botonAnyadir.setPreferredSize(new java.awt.Dimension(35, 35));
        botonAnyadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnyadirMouseClicked(evt);
            }
        });
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

        Perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirPerfilPropio(evt);
            }
        });

        imagenPerfil.setBackground(new java.awt.Color(255, 255, 255));
        imagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagenPerfil.setPreferredSize(new java.awt.Dimension(50, 50));
        imagenPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirPerfilPropio(evt);
            }
        });

        javax.swing.GroupLayout imagenPerfilLayout = new javax.swing.GroupLayout(imagenPerfil);
        imagenPerfil.setLayout(imagenPerfilLayout);
        imagenPerfilLayout.setHorizontalGroup(
            imagenPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        imagenPerfilLayout.setVerticalGroup(
            imagenPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        nomPerfil.setText("Nombre");
        nomPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nomPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirPerfilPropio(evt);
            }
        });

        javax.swing.GroupLayout PerfilLayout = new javax.swing.GroupLayout(Perfil);
        Perfil.setLayout(PerfilLayout);
        PerfilLayout.setHorizontalGroup(
            PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomPerfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PerfilLayout.setVerticalGroup(
            PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PerfilLayout.createSequentialGroup()
                        .addComponent(imagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PerfilLayout.createSequentialGroup()
                        .addComponent(nomPerfil)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Perfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botonAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAnyadir, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pantalla.setEditable(false);
        pantalla.setContentType("text/html"); // NOI18N
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

        panelImgConversacion.setBackground(new java.awt.Color(255, 255, 255));
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

        botonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/talktalkchatty/menuIconMini.png"))); // NOI18N
        botonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuActionPerformed(evt);
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(botonEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelImgConversacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomConversacion)
                            .addComponent(lab_ConectUsu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(botonAdjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(botonAdjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(nomConversacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_ConectUsu))
                            .addComponent(panelImgConversacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        botonEnviar.getAccessibleContext().setAccessibleDescription("botonEnviar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEnviarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEnviarMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarActionPerformed

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

    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        
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
    }//GEN-LAST:event_botonEliminarMouseClicked

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

    private void botonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMenuActionPerformed

    private void abrirPerfilPropio(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirPerfilPropio
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(() -> {
            new Perfil(se,co,id,nombre,foto).setVisible(true);
            
        });
        this.setVisible(false);
    }//GEN-LAST:event_abrirPerfilPropio

    private void botonAnyadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnyadirMouseClicked
            // TODO add your handling code here:
            String ids = JOptionPane.showInputDialog(this,"Agregue el id del usuario o correo(sin #):");
            co.searchUser(ids, this);
    }//GEN-LAST:event_botonAnyadirMouseClicked

    public void contestSearchUser(String ids,String nombre,String confirmacion, String foto)
    {
        System.out.println(ids);
        if(confirmacion.contains("true"))
        {
            if(!this.modelo.contains(nombre))
            {
            //aqui agregamos el contacto o grupo al listado
            this.modelo.addElement(nombre);
            this.CargarListaConversaciones();
            //creamos su apartado de chat
            
            }
            else
            {
                JOptionPane.showMessageDialog(this,"El usuario o grupo "+nombre+" ya esta en tu lista de chat activos.");
            }
        }
        else
        {
            //mostramos mensaje de error
            JOptionPane.showMessageDialog(this,"El usuario o grupo  -> "+ids+" no existe.");
        }
    }
    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Perfil;
    private javax.swing.JFileChooser adjuntarArchivo;
    private javax.swing.JFrame adjuntarFrame;
    private javax.swing.JButton botonAdjuntar;
    private javax.swing.JButton botonAnyadir;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEmoji;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonMenu;
    private javax.swing.JPanel imagenPerfil;
    private javax.swing.JEditorPane inputTexto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lab_ConectUsu;
    private javax.swing.JList<String> listaConversaciones;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JLabel nomConversacion;
    private javax.swing.JLabel nomPerfil;
    private javax.swing.JPanel panelImgConversacion;
    private javax.swing.JEditorPane pantalla;
    // End of variables declaration//GEN-END:variables
    
    
    
    private void CargarConversacion() {
        
    }

    private int SacarNumeroMiembrosGrupo(int indice, String grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void CargarListaConversaciones() {
        listaConversaciones.setModel(modelo);    
    }
}
