/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package analizadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import proyectocupjlexwindows.ProyectoCupJlexWindows;
import analizadores.Lexico;
import analizadores.Sintactico;
import java.awt.Desktop;
/**
 *
 * @author denni
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public static String goolan="";
    public static String python="";
    public static String variable="";
   public static  String pathi="";
   public static String errorlexico="";
    public static String errorsi="";
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        golang = new javax.swing.JButton();
        py = new javax.swing.JButton();
        golang1 = new javax.swing.JButton();
        py1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        traduccion = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        golang.setText("Golang");
        golang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                golangActionPerformed(evt);
            }
        });

        py.setText("Python");
        py.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pyActionPerformed(evt);
            }
        });

        golang1.setText("Clean");
        golang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                golang1ActionPerformed(evt);
            }
        });

        py1.setText("Run");
        py1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                py1ActionPerformed(evt);
            }
        });

        traduccion.setColumns(20);
        traduccion.setRows(5);
        jScrollPane2.setViewportView(traduccion);

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Report Lexico");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reporte Sintactico");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Manual Usuario");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Manual Tecnico");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(763, 763, 763)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(golang1)
                                .addGap(32, 32, 32)
                                .addComponent(py1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(golang)
                                .addGap(32, 32, 32)
                                .addComponent(py))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(golang1)
                    .addComponent(py1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(golang)
                    .addComponent(py))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void py1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_py1ActionPerformed
        // TODO add your handling code here:
        python="";
        goolan="";
        if (pathi=="") {
           
        } else {
            ProyectoCupJlexWindows.interpretar(pathi);
        }
        
        if (errorlexico=="") {
            
        }else{
            JFrame jFrame = new JFrame();

         JOptionPane.showMessageDialog(jFrame,errorlexico);
         errorlexico="";
        }
        if (errorsi=="") {
            
        }else{
            JFrame jFrame = new JFrame();

         JOptionPane.showMessageDialog(jFrame,errorsi);
         errorsi="";
        }
        
        
    }//GEN-LAST:event_py1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
         pathi = archivo.getAbsolutePath();
        try {
             String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void pyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pyActionPerformed
        // TODO add your handling code here:
         traduccion.setText("");
        String aux="";
        String tab="\t";
     String pythons  = python;
     pythons = pythons.replaceAll("\n", "$0  ");
     char quote='"';
        aux="def main():"+"\n"+"\n"+"  "+pythons+"\n"+"if __name__ =="+quote+ "__main__"+quote+":"+"\n"+"  "+"main()";
        traduccion.setText(aux);
       
    }//GEN-LAST:event_pyActionPerformed

    private void golang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_golang1ActionPerformed
        // TODO add your handling code here:
        traduccion.setText("");
    }//GEN-LAST:event_golang1ActionPerformed

    private void golangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_golangActionPerformed
        // TODO add your handling code here:
        traduccion.setText("");
        String aux="";
        String tab="\t";
     String pythons  = goolan;
     pythons = pythons.replaceAll("\n", "$0  ");
     char quote='"';
        aux="package main"+"\n"+" import(\n" +
quote+"math"+quote+"\n"+quote+"ftm"+quote+"\n"+
")"+"\n"+"func main(){"+pythons+"}\n";
        traduccion.setText(aux);
    }//GEN-LAST:event_golangActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        JFrame jFrame = new JFrame();
                
               if ( Lexico.lista1.listar()==false) {
                   
                     JOptionPane.showMessageDialog(jFrame,"Hacer Recorrido ");
            
        } else {
                   try {
     File path = new File ("errorlexico.pdf");
     Desktop.getDesktop().open(path);
}catch (IOException ex) {
     ex.printStackTrace();
}
        }
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        JFrame jFrame = new JFrame();
                
               if ( Sintactico.lista2.listar2()==false) {
                   
                     JOptionPane.showMessageDialog(jFrame,"Hacer Recorrido ");
            
        } else {
                   try {
     File path = new File ("errorsintactico.pdf");
     Desktop.getDesktop().open(path);
}catch (IOException ex) {
     ex.printStackTrace();
}
        }
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        
              try {
     File path = new File ("usuario.pdf");
     Desktop.getDesktop().open(path);
}catch (IOException ex) {
     ex.printStackTrace();
}
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        
                try {
     File path = new File ("TECNICO.pdf");
     Desktop.getDesktop().open(path);
}catch (IOException ex) {
     ex.printStackTrace();
}
    }//GEN-LAST:event_jMenu5MouseClicked

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton golang;
    private javax.swing.JButton golang1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton py;
    private javax.swing.JButton py1;
    private javax.swing.JTextArea traduccion;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
