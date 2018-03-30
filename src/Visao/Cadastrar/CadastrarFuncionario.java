package Visao.Cadastrar;

import DAO.Conexao;
import DAO.FuncionarioDAO;
import Modelo.Funcionario;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author MatheusMartins
 */
public class CadastrarFuncionario extends javax.swing.JFrame {

    public CadastrarFuncionario() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("Concessionaria");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 51, 65));
        jPanel1.setLayout(null);

        jButton2.setBackground(new java.awt.Color(246, 26, 26));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(540, 380, 100, 40);

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("SALVAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(130, 380, 110, 40);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Funcionário");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 730, 80);

        jPanel2.setBackground(new java.awt.Color(14, 82, 95));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(160, 150, 100, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Número do PIS:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 230, 87, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Telefone:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 190, 53, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome Competo:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 40, 90, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("CPF:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 150, 24, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("RG:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 110, 19, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("EmailL:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 70, 37, 30);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(160, 29, 200, 30);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(160, 70, 200, 30);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(160, 110, 100, 30);

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(jFormattedTextField2);
        jFormattedTextField2.setBounds(160, 190, 130, 30);

        jLabel9.setText("Login:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(380, 30, 50, 30);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(430, 30, 140, 30);

        jLabel8.setText("Senha:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(380, 70, 50, 30);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(430, 70, 140, 30);

        try {
            jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.######.##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(jFormattedTextField3);
        jFormattedTextField3.setBounds(160, 230, 130, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 80, 730, 280);

        jButton3.setBackground(new java.awt.Color(220, 180, 19));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(330, 380, 100, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = jTextField7.getText();
        String email = jTextField6.getText();
        String login = jTextField3.getText();
        String RG = jTextField1.getText();
        String CPF = jFormattedTextField1.getText();
        String telefone = jFormattedTextField2.getText();
        String numerodopis = jFormattedTextField3.getText();
        String senha = jTextField2.getText();
        if(nome.equals("")||email.equals("")||senha.equals("")||login.equals("")||RG.equals("")||CPF.equals("")||telefone.equals("")||numerodopis.equals("")||nome.equals("")){
            JOptionPane.showMessageDialog(null,"Os campos não podem estar vazios");        
        }else{
            int numeropis = Integer.parseInt(numerodopis);
            int patente = 0;
            Connection con = Conexao.AbrirConexao();
            FuncionarioDAO sql = new FuncionarioDAO(con);
            Funcionario c = new Funcionario();
             c.setNome(nome);
             c.setEmail(email);
             c.setLogin(login);
             c.setRg(RG);
             c.setCpf(CPF);
             c.setTelefone(telefone);
             c.setNumeropis(numeropis);
             c.setSenha(senha);
             c.setPatente(patente);
            sql.SalvarFuncionario(c);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jFormattedTextField3.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jFormattedTextField1.setText("");
            jFormattedTextField2.setText("");
            JOptionPane.showMessageDialog(null,"Cadastrado ocm sucesso","Concessionaria",JOptionPane.INFORMATION_MESSAGE);
            Conexao.FecharConexao(con);
        }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jFormattedTextField3.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jFormattedTextField1.setText("");
            jFormattedTextField2.setText("");
           
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
