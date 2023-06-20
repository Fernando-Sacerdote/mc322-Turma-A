import java.util.ArrayList;
import java.util.Date;

public class Condutor {
    final private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNasc;
    private ArrayList<Sinistro> listaSinistros;
    private boolean autorizacao;

    // toString

    @Override
    public String toString() {
        String retorno;
        retorno = "-----Condutor-----\n" + "Nome: " + getNome() + "\n" + "Telefone: " + getTelefone() + "\n"
                + "Endereco: " + getEndereco() + "\n" + "Email: " + getEmail() + "\n" + "Esta autorizado? "
                + getAutorizacao() + "\n" + "--------------------\n";
        return retorno;
    }

    // construtor

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNasc) {
        this.cpf = cpf;
        setNome(nome);
        setTelefone(telefone);
        setEndereco(endereco);
        setEmail(email);
        setDataNasc(dataNasc);
        ArrayList<Sinistro> listaSinistros = new ArrayList<>();
        setListaSinistros(listaSinistros);
        setAutorizacao(false);
    }

    // metodos de classe

    public boolean adicionarSinistro(Sinistro sinistro) {
        return getListaSinistros().add(sinistro);
    }

    // getters and setters

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public boolean getAutorizacao() {
        return this.autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

}
