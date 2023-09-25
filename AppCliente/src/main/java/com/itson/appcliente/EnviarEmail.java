/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.appcliente;

import com.itson.dto.CuentaDTO;
import com.itson.dto.ProtocoloDTO;
import com.itson.dto.ServicioDTO;
import com.itson.implementaciones.ImplementacionFachada;
import com.itson.utils.LectorArchivos;
import com.itson.utils.ValidadorEmails;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class EnviarEmail extends javax.swing.JFrame {
    ValidadorEmails validador = new ValidadorEmails();
    ImplementacionFachada interfaz = new ImplementacionFachada();
    LectorArchivos lector = new LectorArchivos();
    private List<ServicioDTO> servicios;
    private String serv, protocolo, cuenta;
    private String cuentaDestino, asunto, contenido;
    /**
     * Creates new form EnviarEmail
     */
    public EnviarEmail() {
        this.leerArchivo();
        initComponents();
        this.cargarServicios();
    }
    
    private void leerArchivo(){
        try {
            this.lector.leerArchivo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Archivo no leido", 
                    "El archivo no se ha leido correctamente", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validarDestinatario(){
        if (validador.validarCorreo(this.txtDestinatario.toString()) == false) {
            JOptionPane.showMessageDialog(null, "Destinatario incorrecto", 
                    "El formato de correo es incorrecto", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarAsunto(){
        if (validador.esVacio(this.txtAsunto.toString()) == false) {
            JOptionPane.showMessageDialog(null, "Asunto incorrecto incorrecto", 
                    "El el asunto del correo esta vacio", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarCuerpoCorreo(){
        if (validador.esVacio(this.txtCuerpoCorreo.toString()) == false) {
            JOptionPane.showMessageDialog(null, "Cuerpo de correo incorrecto", 
                    "El cuerpo del correo esta vacio", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void ejecucion(){
        this.extraerDatosCampos();
        if (this.validarAsunto() == false || this.validarCuerpoCorreo() == false || this.validarDestinatario() == false) {
            JOptionPane.showMessageDialog(null, "Campos incorrectos", 
                    "Campos del correo incorrectos", JOptionPane.INFORMATION_MESSAGE);
        }else{           
            this.enviar();
        }       
    }
    
    private void cargarServicios(){
        this.servicios = lector.getNombresServicios();
        for (ServicioDTO servicio : servicios) {
            cmbServicios.addItem(servicio.getNombre());
        }
        if (cmbServicios.getSelectedItem() != null) {
            this.serv = cmbServicios.getSelectedItem().toString();
        }
    }
    
    private void cargarCuentas(){
        String seleccionServicio = cmbServicios.getSelectedItem().toString();
        cmbCuentas.removeAllItems();
        for (ServicioDTO servicio : servicios) {
            if (seleccionServicio == servicio.getNombre()) {
                for (CuentaDTO cuentas : servicio.getCuentas()) {
                    int contador = 0;
                    String cuenta = cuentas.getDireccion();
                    if (cuenta != null) {
                        cmbCuentas.addItem(cuenta);
                        contador++;
                    }
                }
            }
        }
        if (cmbCuentas.getSelectedItem() != null) {
            this.cuenta = cmbCuentas.getSelectedItem().toString();
        }
    }
    
    private void cargarProtocolos(){
        String seleccionServicio = cmbServicios.getSelectedItem().toString();
        cmbProtocolos.removeAllItems();
        for (ServicioDTO servicio : servicios) {
            if (seleccionServicio == servicio.getNombre()) {              
                for (ProtocoloDTO protocolos : servicio.getProtocolos()) {
                    int contador = 0;
                    String protocolo = protocolos.getNombre();
                    if (protocolo != null) {
                        cmbProtocolos.addItem(protocolo);
                        contador++;
                    }
                }
            }
        }
        if (cmbProtocolos.getSelectedItem() != null) {
            this.protocolo = cmbProtocolos.getSelectedItem().toString();
        }
    }
    
    private void extraerDatosCampos(){        
        this.cuentaDestino = this.txtDestinatario.getText();
        this.asunto = this.txtAsunto.getText();
        this.contenido = this.txtAsunto.getText();
    }
    
    private void enviar(){       
        interfaz.enviarEmail(this.serv, this.protocolo, this.cuenta, 
                this.cuentaDestino, this.asunto, this.contenido);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAsunto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCuerpoCorreo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnEnviarCorreo = new javax.swing.JButton();
        cmbCuentas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbServicios = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbProtocolos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDestinatario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enviar Correo");
        setResizable(false);

        txtAsunto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Cuenta:");

        txtCuerpoCorreo.setColumns(20);
        txtCuerpoCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCuerpoCorreo.setRows(5);
        jScrollPane1.setViewportView(txtCuerpoCorreo);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Cuerpo del correo:");

        btnEnviarCorreo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnEnviarCorreo.setText("Enviar Correo");
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });

        cmbCuentas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Asunto:");

        cmbServicios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cmbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServiciosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Protocolo");

        cmbProtocolos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Envia tu correo");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("Servicio:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Destinatario:");

        txtDestinatario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEnviarCorreo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                        .addComponent(txtAsunto)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(cmbProtocolos, 0, 619, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(cmbServicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCuentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(txtDestinatario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProtocolos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarCorreo)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
        // TODO add your handling code here:   
        this.ejecucion();
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    private void cmbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServiciosActionPerformed
        // TODO add your handling code here:
        this.cargarCuentas();
        this.cargarProtocolos();
    }//GEN-LAST:event_cmbServiciosActionPerformed

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
            java.util.logging.Logger.getLogger(EnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviarEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JComboBox<String> cmbCuentas;
    private javax.swing.JComboBox<String> cmbProtocolos;
    private javax.swing.JComboBox<String> cmbServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextArea txtCuerpoCorreo;
    private javax.swing.JTextField txtDestinatario;
    // End of variables declaration//GEN-END:variables
}
