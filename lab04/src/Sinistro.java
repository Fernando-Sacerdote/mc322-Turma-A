import java.util.Random;
import java.util.Date;

public class Sinistro {
    // declaraçao dos atributos
    private final int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    // consrtutor
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = randomId();
        setData(data);
        setEndereco(endereco);
        setCliente(cliente);
        setSeguradora(seguradora);
        setVeiculo(veiculo);
    }

    // declaraçao das classes
    public int getId() {
        return id;
    }

    public int randomId() {
        Random id = new Random();
        return id.nextInt();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    // metodos

    public String toString() {
        String retorno;
        retorno = "-----SINISTRO-----\n" + "ID: " + getId() + "\n" + "VEICULO: " + getVeiculo().getModelo() + "\n"
                + "SEGURADORA: "
                + getSeguradora().getNome() + "\n"
                + "CLIENTE: " + getCliente().getNome() + "\n" + "DATA: " + getData() + "\n" + "ENDERECO: "
                + getEndereco()
                + "\n";
        return retorno;
    }
}
