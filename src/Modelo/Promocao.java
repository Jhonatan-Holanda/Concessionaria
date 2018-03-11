package Modelo;

/**
 *
 * @author Rudinilly
 */
public class Promocao {
    private int code;

    private String Veiculo;
    private String data_expiracao;
    private int percentual;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String getVeiculo() {
        return Veiculo;
    }

    public void setVeiculo(String Veiculo) {
        this.Veiculo = Veiculo;
    }

    public String getData_expiracao() {
        return data_expiracao;
    }

    public void setData_expiracao(String data_expiracao) {
        this.data_expiracao = data_expiracao;
    }

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }
   
    
}
