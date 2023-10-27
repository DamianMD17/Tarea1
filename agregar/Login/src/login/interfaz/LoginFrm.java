package login.interfaz;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import login.codigo.baseDeDatos;

public class LoginFrm extends javax.swing.JFrame {

    ArrayList<String> usuario = new ArrayList<>();
    // NuevoUsuario ob = new NuevoUsuario();

    public LoginFrm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        contra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/imagenes/icons8-user-30.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/imagenes/icons8-password-30.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioActionPerformed(evt);
            }
        });

        contra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/imagenes/WhatsApp Image 2023-10-20 at 09.28.56_e8351b59.jpg"))); // NOI18N

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnUsuario.setText("USUARIOS");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contra)
                    .addComponent(nombreUsuario))
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(btnUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresar)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnUsuario)
                    .addComponent(btnAgregar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioActionPerformed

    }//GEN-LAST:event_nombreUsuarioActionPerformed

    private void contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraActionPerformed

    }//GEN-LAST:event_contraActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        /* if(contra.getText().equals("123")){
           JOptionPane.showMessageDialog(null,"CONTRASEÑA CORRECTA");
          
       }else{

            JOptionPane.showMessageDialog(null,"CONTRASEÑA INCORRECTA");
          
       }
         */
        baseDeDatos base = new baseDeDatos();
        if (base.iniciarSesion(nombreUsuario.getText(), contra.getText())) {
            JOptionPane.showMessageDialog(null, "CONTRASEÑA CORRECTA");
        } else {
            JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        for (String i : usuario) {
            JOptionPane.showMessageDialog(null, usuario);
        }
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        new NuevoUsuario().setVisible(true);
        usuario.add(nombreUsuario.getText());
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JTextField contra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
