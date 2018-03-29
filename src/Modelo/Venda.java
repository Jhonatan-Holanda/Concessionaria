
package Modelo;


public class Venda {
   private int cod;
   private String cliente;
   private String veiculo;
   private String fabricante;
   private String chassi;
   private String ModoPagamento;
   private String TipoPagamento;
   private String parcelas;
   private String preco; 
   private double desconto;
   private double valofinal;
   private int idfuncionario;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModoPagamento() {
        return ModoPagamento;
    }

    public void setModoPagamento(String ModoPagamento) {
        this.ModoPagamento = ModoPagamento;
    }

    public String getTipoPagamento() {
        return TipoPagamento;
    }

    public void setTipoPagamento(String TipoPagamento) {
        this.TipoPagamento = TipoPagamento;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValofinal() {
        return valofinal;
    }

    public void setValofinal(double valofinal) {
        this.valofinal = valofinal;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }
   
}
