
package Principal;

import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.PromocaoDAO;
import DAO.VeiculoDAO;
import DAO.VendasDAO;
import Modelo.Cliente;
import Modelo.Promocao;
import Modelo.Veiculos;
import Modelo.Venda;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rudinilly
 */
public class Vendas extends javax.swing.JFrame {

    public Vendas() {
        initComponents();
        jComboBox3.setEnabled(false);
        AtualizaComboCliente();
        AtualizaComboVeiculo();
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("Concessionaria");
    }
    public void AtualizaComboCliente(){
     Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = sql.ListarComboCliente();
        
        for(Cliente b : lista){
            jComboBox1.addItem(b.getNome());
        }
        Conexao.FecharConexao(con);    
    }
     public void AtualizaComboVeiculo(){
     Connection con = Conexao.AbrirConexao();
         VeiculoDAO sql = new VeiculoDAO(con);
        List<Veiculos> lista = new ArrayList<>();
        lista = sql.ListarComboVeiculo()    ;
        
        for(Veiculos b : lista){
            jComboBox2.addItem(b.getModelo());
        }
        Conexao.FecharConexao(con);    
    }
    public void Pesquisacliente(String nome){
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
    
        lista = sql.ListarTabelaNome(nome);
        for (Cliente cliente : lista) {
            jComboBox1.setSelectedItem(cliente.getNome());
        }
        Conexao.FecharConexao(con);
    }
    public void getid(int id){
    JOptionPane.showMessageDialog(null,id);
    }
    String formapagamento = "";
    String parcelas = "";
    String modopagamento = "";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        idfun = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 51, 65));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(14, 82, 95));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel2.setText("Cliente:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 20, 70, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Cliente" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(90, 20, 230, 30);

        jLabel3.setText("Veículo:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 80, 70, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Veículo" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(90, 80, 230, 30);

        jLabel4.setText("Pesquisar:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(340, 20, 80, 30);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(410, 20, 240, 30);

        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(670, 20, 50, 30);

        jLabel5.setText("Preço:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 150, 60, 30);

        jTextField2.setEditable(false);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(90, 150, 110, 30);

        jLabel6.setText("Chassi:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 220, 60, 30);

        jTextField3.setEditable(false);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(90, 220, 180, 30);

        jLabel7.setText("Desconto(%):");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(210, 150, 80, 30);

        jTextField4.setEditable(false);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(290, 150, 50, 30);

        jLabel8.setText("Fabricante:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(300, 220, 80, 30);

        jTextField5.setEditable(false);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(380, 220, 190, 30);

        jLabel9.setText("Valor Final:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(380, 150, 80, 30);

        jTextField6.setEditable(false);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(450, 150, 120, 30);

        jLabel10.setText("Pagamento:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(640, 80, 120, 30);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("A Vista");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(640, 120, 120, 30);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Parceladdo");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(640, 170, 120, 30);

        jPanel2.add(jComboBox3);
        jComboBox3.setBounds(640, 220, 120, 30);

        jLabel11.setText("Modo Pagamento:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(340, 80, 120, 30);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Boleto");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton3);
        jRadioButton3.setBounds(450, 80, 80, 30);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Cartão");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton4);
        jRadioButton4.setBounds(540, 80, 70, 30);
        jPanel2.add(idfun);
        idfun.setBounds(730, 20, 40, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 90, 790, 270);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venda De Veículos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 90);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(600, 380, 120, 50);

        jButton4.setBackground(new java.awt.Color(0, 204, 0));
        jButton4.setText("Concluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(70, 380, 140, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    jComboBox3.setEnabled(true);
    formapagamento = "Parcelado";
    parcelas = jComboBox3.getSelectedItem().toString();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
    jComboBox3.setEnabled(false);
    formapagamento = "A vista";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String nome = jTextField1.getText();
    Pesquisacliente(nome);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
    String nome = jComboBox2.getSelectedItem().toString();
    Connection con = Conexao.AbrirConexao();
    VeiculoDAO sql = new VeiculoDAO(con);
    PromocaoDAO sql2 = new PromocaoDAO(con);
    List<Veiculos> lista1 = new ArrayList<>();
    List<Promocao> lista2 = new ArrayList<>();
    lista1 = sql.ListarTabelaNome(nome);
    lista2 = sql2.ListarTabelaNome(nome);
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
            jTextField4.setText("");
            jTextField6.setText("");
            DefaultComboBoxModel tbm = (DefaultComboBoxModel) jComboBox3.getModel();
            tbm.removeAllElements();
        for (Veiculos veiculos : lista1) {
            jTextField2.setText(""+veiculos.getPreço());
            jTextField3.setText(veiculos.getChassi());
            jTextField5.setText(veiculos.getFabricante());
            double total = Integer.parseInt(veiculos.getPreço());
            int p = 0;
            for (Promocao promocao : lista2) {
                p = promocao.getPercentual();                
                if(p!=0){
                total = (total/100)*(100-p);
                }                
            }
            DecimalFormat d = new DecimalFormat("0.00");
            jTextField4.setText(p+"");
            jTextField6.setText(""+total);
            for (int i = 2; i <= 10; i++) {
                jComboBox3.addItem(i+" X "+d.format((total/i)));
            }
        }
    
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        modopagamento = "Boleto";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        modopagamento = "Cartão";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String cliente = jComboBox1.getSelectedItem().toString();
        String veiculo = jComboBox2.getSelectedItem().toString();
        String fabricante = jTextField5.getText();
        String chassi = jTextField3.getText();
        String Preco = jTextField2.getText();        
        String desconto = jTextField4.getText();       
        String ValorFinal = jTextField6.getText();
        String id = "1";
        if (formapagamento.equals("Parcelado")) {
            parcelas = jComboBox3.getSelectedItem().toString();
        }else{
            parcelas = "1 X "+ValorFinal;
        }
        if (cliente.equals("Selecione um Cliente")||veiculo.equals("Selecione um Veículo")||Preco.equals("")||chassi.equals("")||desconto.equals("")||fabricante.equals("")||ValorFinal.equals("")||formapagamento.equals("")||modopagamento.equals("")||id.equals("")) {
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos","Concessionaria",JOptionPane.WARNING_MESSAGE);
        }else{
        double desc = Double.parseDouble(desconto);
        int idfunc = Integer.parseInt(id);
        double VF = Double.parseDouble(ValorFinal);
        Connection con = Conexao.AbrirConexao();
        VendasDAO sql = new VendasDAO(con);
        Venda v = new Venda();
        v.setCliente(cliente);
        v.setVeiculo(veiculo);
        v.setFabricante(fabricante);
        v.setChassi(chassi);
        v.setModoPagamento(modopagamento);
        v.setTipoPagamento(formapagamento);
        v.setParcelas(parcelas);
        v.setPreco(Preco);
        v.setDesconto(desc);
        v.setValofinal(VF);
        v.setIdfuncionario(idfunc);
        sql.InserirVenda(v);
        Conexao.FecharConexao(con);
        
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel idfun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
