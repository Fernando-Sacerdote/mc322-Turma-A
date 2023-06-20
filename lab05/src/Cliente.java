public abstract class Cliente {
    // declaracao de atributoss
    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    // construtor

    public Cliente(String nome, String telefone, String endereco, String email) {
        setNome(nome);
        setTelefone(telefone);
        setEndereco(endereco);
        setEmail(email);
    }

    // getters and setters

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
