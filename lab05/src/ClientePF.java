import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    final private String CPF;
    private String genero;
    private String educacao;
    private Date dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;

    // construtor

    public ClientePF(String nome, String telefone, String endereco, String email, String CPF, String genero,
            String educacao,
            Date dataNascimento) {
        super(nome, telefone, endereco, email);
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        setListaVeiculos(listaVeiculos);
        this.CPF = CPF;
        setGenero(genero);
        setEducacao(educacao);
        setDataNascimento(dataNascimento);
    }

    // metodos da classe

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        return getListaVeiculos().add(veiculo);
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        return getListaVeiculos().remove(veiculo);
    }

    // getter and setters

    public String getCPF() {
        return this.CPF;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    // toString

    @Override
    public String toString() {
        String retorno;
        retorno = "-----CLIENTE PF-----\n" + "Nome: " + getNome() + "\n" + "Endereco: " + getEndereco() + "\n" + "CPF: "
                + getCPF() + "\n" + "Genero: " + getGenero() + "\n" + "Data Nascimento: " + getDataNascimento() + "\n"
                + "Educacao: " + getEducacao() + "\n" + "--------------------\n";
        return retorno;
    }
}
