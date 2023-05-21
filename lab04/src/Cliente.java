import java.util.ArrayList;

public class Cliente {
    // declaracao de atributoss
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;
    protected String tipo;

    // consrtutor
    public Cliente(String nome, String endereco) {
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        this.tipo = "";
        setNome(nome);
        setEndereco(endereco);
        setListaVeiculos(listaVeiculos);
    }

    // getters and setters

    public double getValorSeguro() {
        return this.valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    // metodos

    public void adVeiculo(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
    }

    public String toString() {
        String retorno;
        retorno = "O nome do cliente é: " + getNome() + "\n" + "Atualmente reside em: " + getEndereco() + "\n"
                + "Possui os seguintes veiculos: " + getListaVeiculos();
        return retorno;
    }

    public void calculaScore() {
        setValorSeguro(CalcSeguro.VALOR_BASE.getValor());
    }
}
