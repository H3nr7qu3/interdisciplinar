package view;

import DAO.ConexaoSockets;
import DAO.UsuarioDAO;
import javax.swing.JLabel;
import fabricaDeConexao.PegandoIP;
import javax.swing.JOptionPane;
import model.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Principal
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    //Recuperar recuperar = new Recuperar();
    //Cadastro cadastro = new Cadastro();
    //Login login = new Login();
    UsuarioDAO usuario = new UsuarioDAO();
    Usuario userInfo = new Usuario();
    //Usuario userInfo = new Usuario(8, "alguem", "alguem@gmail.com", "12345");

    public View(Usuario userInfo) {

        this.userInfo = userInfo;
//        setLocationRelativeTo(null);

        initComponents();
        setLocationRelativeTo(null);
        //pegandoip();
    }

    public View() {
//        setLocationRelativeTo(null);
        initComponents();
        //pegandoip();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDados = new javax.swing.JPanel();
        jLabelIP = new javax.swing.JLabel();
        IjLabelVerIP = new javax.swing.JLabel();
        jLabelPorta = new javax.swing.JLabel();
        jLabelVerPorta = new javax.swing.JLabel();
        jPanelConexao = new javax.swing.JPanel();
        jLabelConectarPorta = new javax.swing.JLabel();
        jTextFieldPorta = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();
        jPanelImage = new javax.swing.JPanel();
        ImagemLabel = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelEmail1 = new javax.swing.JLabel();
        jLabelEmail2 = new javax.swing.JLabel();
        jButttonLogout = new javax.swing.JButton();
        jButtonAlterarNome = new javax.swing.JButton();
        jButtonAlterarSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelIP.setText("IP:");

        jLabelPorta.setText("porta:");

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabelIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IjLabelVerIP))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabelPorta)
                        .addGap(26, 26, 26)
                        .addComponent(jLabelVerPorta)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIP)
                    .addComponent(IjLabelVerIP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPorta)
                    .addComponent(jLabelVerPorta))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanelConexao.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));

        jLabelConectarPorta.setText("Porta:");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConexaoLayout = new javax.swing.GroupLayout(jPanelConexao);
        jPanelConexao.setLayout(jPanelConexaoLayout);
        jPanelConexaoLayout.setHorizontalGroup(
            jPanelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConexaoLayout.createSequentialGroup()
                        .addComponent(jLabelConectarPorta)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPorta, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConexaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelConexaoLayout.setVerticalGroup(
            jPanelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConectarPorta)
                    .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonEditar)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jPanelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanelImage.setPreferredSize(new java.awt.Dimension(450, 450));

        javax.swing.GroupLayout jPanelImageLayout = new javax.swing.GroupLayout(jPanelImage);
        jPanelImage.setLayout(jPanelImageLayout);
        jPanelImageLayout.setHorizontalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagemLabel)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanelImageLayout.setVerticalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImageLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(ImagemLabel)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setText("Usuário");

        jLabelNome.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabelNome.setText("Seja bem-vindo(a), " + userInfo.getNome());
        jLabelNome.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelNome.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabelEmail1.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabelEmail1.setText("Email: ");

        jLabelEmail2.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabelEmail2.setText(userInfo.getEmail());

        jButttonLogout.setText("Logout");
        jButttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButttonLogoutActionPerformed(evt);
            }
        });

        jButtonAlterarNome.setBackground(getBackground());
        jButtonAlterarNome.setText("Alterar Nome");
        jButtonAlterarNome.setBorder(null);
        jButtonAlterarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarNomeActionPerformed(evt);
            }
        });

        jButtonAlterarSenha.setBackground(getBackground());
        jButtonAlterarSenha.setText("Alterar Senha");
        jButtonAlterarSenha.setBorder(null);
        jButtonAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelEmail1)
                    .addComponent(jLabelEmail2)
                    .addComponent(jButttonLogout)
                    .addComponent(jButtonAlterarNome)
                    .addComponent(jButtonAlterarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jPanelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelConexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelConexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlterarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlterarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEmail1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmail2)
                        .addGap(98, 98, 98)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButttonLogout)
                    .addComponent(jPanelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getPortaLabel() {
        return jLabelVerPorta;
    }

    public void setPortaLabel(JLabel portaLabel) {
        this.jLabelVerPorta = portaLabel;
    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        String portaI = jTextFieldPorta.getText();
        jLabelVerPorta.setText(jTextFieldPorta.getText());
        ConexaoSockets Trata = new ConexaoSockets(Integer.parseInt(portaI));
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButttonLogoutActionPerformed
        usuario = new UsuarioDAO();

        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButttonLogoutActionPerformed

    private void jButtonAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarSenhaActionPerformed
        String novaSenha = JOptionPane.showInputDialog(this, "Nova senha:");
        if (novaSenha != null) {
            userInfo.setSenha(novaSenha);
            usuario.updateUsuario(userInfo);
            JOptionPane.showMessageDialog(this, ("Senha atualizada!"));
        }
    }//GEN-LAST:event_jButtonAlterarSenhaActionPerformed

    private void jButtonAlterarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarNomeActionPerformed
        String novoNome = JOptionPane.showInputDialog(this, "Novo nome:");
        if (novoNome != null) {
            userInfo.setNome(novoNome);
            usuario.updateUsuario(userInfo);

            JOptionPane.showMessageDialog(this, ("Nome atualizado, " + novoNome));
            jLabelNome.setText("Seja bem-vindo(a), " + userInfo.getNome());
        }
    }//GEN-LAST:event_jButtonAlterarNomeActionPerformed

    public JLabel getImagemLabel() {
        return ImagemLabel;
    }

    public void setImagemLabel(JLabel ImagemLabel) {
        this.ImagemLabel = ImagemLabel;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        
//        /* Create and display the form */
//        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new View().setVisible(true);
//            }
//        });
//        
//        
//       
//    }
    void pegandoip() {
        PegandoIP ip = new PegandoIP();
        IjLabelVerIP.setText(ip.PickIP());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IjLabelVerIP;
    private javax.swing.JLabel ImagemLabel;
    private javax.swing.JButton jButtonAlterarNome;
    private javax.swing.JButton jButtonAlterarSenha;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButttonLogout;
    private javax.swing.JLabel jLabelConectarPorta;
    private javax.swing.JLabel jLabelEmail1;
    private javax.swing.JLabel jLabelEmail2;
    private javax.swing.JLabel jLabelIP;
    protected javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPorta;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelVerPorta;
    private javax.swing.JPanel jPanelConexao;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelImage;
    private javax.swing.JTextField jTextFieldPorta;
    // End of variables declaration//GEN-END:variables
}
