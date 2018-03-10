package Visao.consultar;

import DAO.ClienteDAO;
import DAO.Conexao;
import Modelo.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rudinilly
 */
public class ConsultarCliente extends javax.swing.JFrame {

    public ConsultarCliente() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Concessionaria");
        setResizable(false);
        AtualizaTabela();
        AtualizaCombo();
    }
 private void AtualizaCombo(){
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista =  sql.ListarComboCliente();
    
        for(Cliente v :lista){
        jComboBox1.addItem(v.getNome());
        }
        Conexao.FecharConexao(con);
    }
    public void AtualizaTabela(){
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = sql.ListarTabela();
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while (tbm.getRowCount() >0) {            
            tbm.removeRow(0);
        }
        int i = 0;
        for(Cliente tab : lista){
        tbm.addRow(new String[i]);
        jTable2.setValueAt(tab.getCode(), i, 0);
        jTable2.setValueAt(tab.getNome(), i, 1);
        jTable2.setValueAt(tab.getEmail(), i, 2);
        jTable2.setValueAt(tab.getCidade(), i, 3);
        jTable2.setValueAt(tab.getEstado(), i, 4);
        jTable2.setValueAt(tab.getRG(), i, 5);
        jTable2.setValueAt(tab.getCPF(), i, 6);
        jTable2.setValueAt(tab.getTelefone(), i, 7);
        jTable2.setValueAt(tab.getCNH(), i, 8);
        i++;
        }
        Conexao.FecharConexao(con);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 51, 65));
        jPanel1.setLayout(null);

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Email", "Cidade", "Estado", "RG", "CPF", "Telefone", "CNH"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 120, 900, 270);

        jLabel1.setText("Pesquisar por Código");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 130, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 19, 50, 30);

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(220, 20, 50, 30);

        jLabel2.setText("Pesquisar por Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(530, 20, 130, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Cliente" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(670, 20, 200, 30);

        jButton3.setText("Todos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(790, 80, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cod = jTextField1.getText();
        if (cod.equals("")) {
            JOptionPane.showConfirmDialog(null,"Insira um código","Concessionaria",JOptionPane.WARNING_MESSAGE);
        }else{
            int codigo = Integer.parseInt(cod);
            Connection con = Conexao.AbrirConexao();
            ClienteDAO sql = new ClienteDAO(con);
            Cliente p = new Cliente();
            List<Cliente> lista = new ArrayList<>();
            lista = sql.ListarTabelaCodigo(codigo);
            DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
            while (tbm.getRowCount() >0) {
                tbm.removeRow(0);
            }
            int i = 0;
            for(Cliente tab : lista){
                tbm.addRow(new String[i]);
                jTable2.setValueAt(tab.getCode(), i, 0);
                jTable2.setValueAt(tab.getNome(), i, 1);
                jTable2.setValueAt(tab.getEmail(), i, 2);
                jTable2.setValueAt(tab.getCidade(), i, 3);
                jTable2.setValueAt(tab.getEstado(), i, 4);
                jTable2.setValueAt(tab.getRG(), i, 5);
                jTable2.setValueAt(tab.getCPF(), i, 6);
                jTable2.setValueAt(tab.getTelefone(), i, 7);
                jTable2.setValueAt(tab.getCNH(), i, 8);
                i++;
            }
            Conexao.FecharConexao(con);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String nome = jComboBox1.getSelectedItem().toString();
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        Cliente p = new Cliente();
        List<Cliente> lista = new ArrayList<>();
        lista = sql.ListarTabelaNome(nome);
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while (tbm.getRowCount() >0) {
            tbm.removeRow(0);
        }
        int i = 0;
        for(Cliente tab : lista){
            tbm.addRow(new String[i]);
            jTable2.setValueAt(tab.getCode(), i, 0);
            jTable2.setValueAt(tab.getNome(), i, 1);
            jTable2.setValueAt(tab.getEmail(), i, 2);
            jTable2.setValueAt(tab.getCidade(), i, 3);
            jTable2.setValueAt(tab.getEstado(), i, 4);
            jTable2.setValueAt(tab.getRG(), i, 5);
            jTable2.setValueAt(tab.getCPF(), i, 6);
            jTable2.setValueAt(tab.getTelefone(), i, 7);
            jTable2.setValueAt(tab.getCNH(), i, 8);
            i++;
        }
        Conexao.FecharConexao(con);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        AtualizaTabela();
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
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
