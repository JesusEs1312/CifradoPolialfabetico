/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import model.Letra;

/**
 *
 * @author jesus
 */
public class Cifrado extends javax.swing.JFrame {

    private String alfabeto1 = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private String alfabeto2 = "ÄªÇÐ£«÷║Î¬®└©±‗»¶@Þ§┬Û¤%×¥$";
    private char alfabetoLetras1 [];
    private char alfabetoLetras2 [];
    private List<String> textoEnPalabras;
    private List<Letra> alfabetoOriginal;
    
    public Cifrado() {
        initComponents();
        inicializarVariables();
    }

    public void inicializarVariables(){
        alfabetoLetras1 = alfabeto1.toCharArray();//-Generar arreglo de alfabeto1
        alfabetoLetras2 = alfabeto2.toCharArray();//-Generar arreglo de alfabeto2
        textoEnPalabras = new ArrayList<String>();
        alfabetoOriginal = new ArrayList<Letra>();
        btnDescifrar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        txtCifrado.setEditable(false);
        txtDescifrado.setEditable(false);
        setLocationRelativeTo(this);
        //--Añadir letras al modelo 
        for(int i = 0; i < 27; i++){
            alfabetoOriginal.add(new Letra(alfabetoLetras1[i], alfabetoLetras2[i], i));
        }
    }
    
    public void cortarTextoEnPalabras(String tipoFuncion){
        String texto = "";
        if(tipoFuncion.equals("cifrar")){
            texto = txtCifrar.getText().toUpperCase();
        } else if(tipoFuncion.equals("descifrar")){
            texto = txtCifrado.getText().toUpperCase();
        }
        textoEnPalabras = Arrays.asList(texto.split("\\ "));//--Generar palabras
    }
    
    public String cifrar(int numDesplazamientos){
        cortarTextoEnPalabras("cifrar");
        String textoCifrado = "";
        for(String palabra : textoEnPalabras){//---Recorrer palabras
            String palabraTemp = palabra;
            char letrasTemp [] = palabraTemp.toCharArray();
            for(int i = 0; i < letrasTemp.length; i++){//---Recorrer caracteres de palabras
                String letraTempString = String.valueOf(letrasTemp[i]);
                if(letraTempString.matches("[0-9._-]+")){
                    textoCifrado += letraTempString;
                }
                int posicion = i;
                for(Letra letra : alfabetoOriginal){//---Recorrer el alfabeto
                    if(letrasTemp[i] == letra.getLetra()){//---Validar si caracter es igual a la letra
                        int posicionLetra = letra.getPosicion();
                        int nuevaPosicionLetra = (posicionLetra + numDesplazamientos) % (27);
                        if(posicion%2 == 0){
                            textoCifrado += alfabetoLetras1[nuevaPosicionLetra];
                        } else if(posicion%2 == 1){
                            textoCifrado += alfabetoLetras2[nuevaPosicionLetra];
                        } 
                    }
                }
            }
            if(textoEnPalabras.size() > 1){
                textoCifrado += " ";
            }
        }
        return textoCifrado;
    }
    
    public String descifrar(int numDesplazamientos){
        cortarTextoEnPalabras("descifrar");
        String textoDescifrado = "";
        for(String palabra : textoEnPalabras){//--Recorrer
            String palabraTemp = palabra;
            char letrasTemp [] = palabraTemp.toCharArray();
            for(int i = 0; i < letrasTemp.length; i++){
                String letraTempString = String.valueOf(letrasTemp[i]);
                if(letraTempString.matches("[0-9._-]+")){
                    textoDescifrado += letraTempString;
                }
                int posicion = i;
                for(Letra letra : alfabetoOriginal){
                    if(posicion%2 == 0){
                        if(letrasTemp[i] == letra.getLetra()){
                            int posicionLetra = letra.getPosicion();
                            int nuevaPosicionLetra = 0;
                            if(posicionLetra < numDesplazamientos){
                                nuevaPosicionLetra = (posicionLetra + 27) - numDesplazamientos;
                            } else {
                                nuevaPosicionLetra = (posicionLetra - numDesplazamientos) % (27);
                            }
                            textoDescifrado += alfabetoLetras1[nuevaPosicionLetra];
                        }
                    } else if(posicion%2 == 1){
                         if(letrasTemp[i] == letra.getLetra2()){
                            int posicionLetra = letra.getPosicion();
                            int nuevaPosicionLetra = 0;
                            if(posicionLetra < numDesplazamientos){
                                nuevaPosicionLetra = (posicionLetra + 27) - numDesplazamientos;
                            } else {
                                nuevaPosicionLetra = (posicionLetra - numDesplazamientos) % (27);
                            }
                            textoDescifrado += alfabetoLetras1[nuevaPosicionLetra];
                        }
                    }
                }
            }
            if(textoEnPalabras.size() > 1){
                textoDescifrado += " ";
            }
        }
        return textoDescifrado;
    }
    
    public void limpiar(){
        txtCifrar.setEditable(true);
        txtDesplazamiento.setEditable(true);
        txtCifrar.setText("");
        txtDesplazamiento.setText("");
        txtCifrado.setText("");
        txtDescifrado.setText("");
        btnCifrar.setEnabled(true);
        btnLimpiar.setEnabled(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        txtCifrar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCifrar = new javax.swing.JButton();
        btnDescifrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCifrado = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescifrado = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDesplazamiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese texto a cifrar:");

        btnCifrar.setText("Cifrar");
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        btnDescifrar.setText("Descifrar");
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrarActionPerformed(evt);
            }
        });

        txtCifrado.setColumns(20);
        txtCifrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCifrado.setRows(5);
        jScrollPane1.setViewportView(txtCifrado);

        jLabel2.setText("Texto cifrado");

        txtDescifrado.setColumns(20);
        txtDescifrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDescifrado.setRows(5);
        jScrollPane2.setViewportView(txtDescifrado);

        jLabel3.setText("Texto descifrado");

        jLabel4.setText("Num. Desplazamientos:");

        jLabel5.setText("Cifrado Polialfabetico");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDesplazamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnDescifrar)
                            .addGap(18, 18, 18)
                            .addComponent(btnLimpiar)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDesplazamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDescifrar)
                    .addComponent(btnCifrar)
                    .addComponent(btnLimpiar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
        String texto = txtCifrar.getText().toUpperCase();
        String numDesplazamientosString = txtDesplazamiento.getText();
        if(!texto.equals("") && !numDesplazamientosString.equals("")){
            int numDesplazamientos = Integer.parseInt(numDesplazamientosString);
            txtCifrado.setText(cifrar(numDesplazamientos));
            btnCifrar.setEnabled(false);
            btnDescifrar.setEnabled(true);
            btnLimpiar.setEnabled(true);
            txtCifrar.setEditable(false);
            txtDesplazamiento.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "No hay texto o desplazamientos");
        }
    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrarActionPerformed
        int numDesplazamientos = Integer.parseInt(txtDesplazamiento.getText());
        txtDescifrado.setText(descifrar(numDesplazamientos));
        btnCifrar.setEnabled(false);
        btnDescifrar.setEnabled(false);
        btnLimpiar.setEnabled(true);
    }//GEN-LAST:event_btnDescifrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cifrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtCifrado;
    private javax.swing.JTextField txtCifrar;
    private javax.swing.JTextArea txtDescifrado;
    private javax.swing.JTextField txtDesplazamiento;
    // End of variables declaration//GEN-END:variables
}
