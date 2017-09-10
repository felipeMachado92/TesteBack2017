package ContaCliente;

/**
 *
 * @author Felipe
 */
public class Cliente {
    private int idCliente;
    private String cpfCnpj;
    private String nome;
    private int estaAtivo;
    private double valorTotal;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(int estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
