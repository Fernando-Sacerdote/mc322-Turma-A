import java.util.Random;
import java.util.Date;

public class Sinistro {
    // declaraçao dos atributos
    private final int id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    // toString

    public String toString() {
        String retorno;
        retorno = "-----SINISTRO-----\n" + "ID: " + getId() + "\n"
                + "DATA: " + getData() + "\n" + "ENDERECO: " + getEndereco() + "\n" + "-----------\n";
        return retorno;
    }

    // consrtutor
    public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
        this.id = randomId();
        setData(data);
        setEndereco(endereco);
        setCondutor(condutor);
        setSeguro(seguro);
    }

    // getters and setter
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

    public Condutor geCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

}
