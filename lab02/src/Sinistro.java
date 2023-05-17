import java.util.Random;

public class Sinistro {
    // declaraçao dos atributos
    private int id;
    private String data;
    private String endereco;

    // consrtutor
    public Sinistro(String data, String endereco) {
        this.data = data;
        this.endereco = endereco;
        setRandomId();
    }

    // declaraçao das classes
    public int getId() {
        return id;
    }

    public void setRandomId() {
        Random id = new Random();
        this.id = id.nextInt();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
