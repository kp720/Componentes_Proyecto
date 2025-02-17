/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package componente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class ContactosBloqueados extends javax.swing.JFrame {
        private boolean isPanelVisible = true;
        private Timer timer;
    /**
     * Creates new form ContactosBloqueados
     */
    public ContactosBloqueados() {
        initComponents();
        cargarDesdeArchivo("ContactosBloqueados.txt");
    }
    
    // Método para agregar un nombre bloqueado al JTextArea y al archivo
    public void agregarContactoBloqueado(String nombreBloqueado) {
        txtContactosBloqueados.append(nombreBloqueado + "\n");
        guardarEnArchivo("ContactosBloqueados.txt", nombreBloqueado);
    }

    // Método para cargar nombres bloqueados desde un archivo
    private void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                txtContactosBloqueados.append(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar contenido en un archivo
    private void guardarEnArchivo(String nombreArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(contenido);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para desbloquear un contacto
    private void desbloquearContacto() {
        String selectedText = txtContactosBloqueados.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            // Eliminar del JTextArea
            String textAreaContent = txtContactosBloqueados.getText();
            String updatedContent = textAreaContent.replace(selectedText + "\n", "");
            txtContactosBloqueados.setText(updatedContent);

            // Eliminar del archivo UsuariosBloqueados.txt
            eliminarDeArchivo("ContactosBloqueados.txt", selectedText);
        }
    }

    // Método para eliminar una línea de un archivo
    private void eliminarDeArchivo(String nombreArchivo, String nombreEliminar) {
    try {
        // Leer todo el contenido del archivo en memoria
        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
        StringBuilder contenido = new StringBuilder();
        String linea;
        
        while ((linea = reader.readLine()) != null) {
            // Si la línea no es la que queremos eliminar, la añadimos al contenido
            if (!linea.equals(nombreEliminar)) {
                contenido.append(linea).append(System.lineSeparator());
            }
        }
        reader.close();
        
        // Escribir el contenido actualizado de vuelta al archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
        writer.write(contenido.toString());
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}





    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContactos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContactosBloqueados = new javax.swing.JTextArea();
        btnDesbloquear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnContactos = new javax.swing.JButton();
        btnBloqueados = new javax.swing.JButton();
        btnOcultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContactos.setBackground(new java.awt.Color(0, 0, 0));
        panelContactos.setForeground(new java.awt.Color(255, 255, 255));

        txtContactosBloqueados.setBackground(new java.awt.Color(0, 0, 0));
        txtContactosBloqueados.setColumns(20);
        txtContactosBloqueados.setForeground(new java.awt.Color(255, 255, 255));
        txtContactosBloqueados.setRows(5);
        jScrollPane1.setViewportView(txtContactosBloqueados);

        btnDesbloquear.setText("Desbloquear");
        btnDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloquearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContactosLayout = new javax.swing.GroupLayout(panelContactos);
        panelContactos.setLayout(panelContactosLayout);
        panelContactosLayout.setHorizontalGroup(
            panelContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelContactosLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnDesbloquear)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelContactosLayout.setVerticalGroup(
            panelContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDesbloquear)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\agregar.jpg")); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnContactos.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\iconos.jpg")); // NOI18N
        btnContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactosActionPerformed(evt);
            }
        });

        btnBloqueados.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\bloqueados.png")); // NOI18N

        btnOcultar.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\Barra des.jpg")); // NOI18N
        btnOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBloqueados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBloqueados, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContactos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContactos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ComponenteVisual ComponenteVisual = new ComponenteVisual();
        ComponenteVisual.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcultarActionPerformed
        // TODO add your handling code here:
        if (isPanelVisible) {
        timer = new Timer(5, new ActionListener() {
            int panelWidth = panelContactos.getWidth();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelWidth > 0) {
                    panelWidth -= 5;
                    panelContactos.setLocation(panelContactos.getX() + 5, panelContactos.getY());
                    panelContactos.setSize(panelWidth, panelContactos.getHeight());
                } else {
                    isPanelVisible = false;
                    timer.stop();
                }
            }
        });
    } else {
        timer = new Timer(5, new ActionListener() {
            int panelWidth = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelWidth < 250) {  // assuming 250 is the original width
                    panelWidth += 5;
                    panelContactos.setLocation(panelContactos.getX() - 5, panelContactos.getY());
                    panelContactos.setSize(panelWidth, panelContactos.getHeight());
                } else {
                    isPanelVisible = true;
                    timer.stop();
                }
            }
        });
    }
    timer.start();
    }//GEN-LAST:event_btnOcultarActionPerformed

    private void btnDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloquearActionPerformed
        // TODO add your handling code here:
        desbloquearContacto();
    }//GEN-LAST:event_btnDesbloquearActionPerformed

    private void btnContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactosActionPerformed
        // TODO add your handling code here:
        ContactosCreados ContactosCreados = new ContactosCreados();
        ContactosCreados.setVisible(true);
    }//GEN-LAST:event_btnContactosActionPerformed

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
            java.util.logging.Logger.getLogger(ContactosBloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactosBloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactosBloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactosBloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactosBloqueados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBloqueados;
    private javax.swing.JButton btnContactos;
    private javax.swing.JButton btnDesbloquear;
    private javax.swing.JButton btnOcultar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContactos;
    private javax.swing.JTextArea txtContactosBloqueados;
    // End of variables declaration//GEN-END:variables
}
