import java.util.ArrayList;

public class Seguradora {
    // Atributos da classe Seguradora
    final private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;

    // toString

    public String toString() {
        String retorno;
        retorno = "-----" + getNome() + "-----" + "\n" + "Endereco: " + getEndereco() + "\n" + "Telefone: "
                + getTelefone() + "\n" + "Email: " + getEmail() + "\n"
                + "---------------------\n";

        return retorno;
    }

    // construtor
    public Seguradora(String nome, String telefone, String email, String endereco, String cnpj) {
        this.cnpj = cnpj;
        ArrayList<Seguro> listaSeguros = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        setEndereco(endereco);
        setListaClientes(listaClientes);
        setListaSeguros(listaSeguros);
    }

    // metodos da classe

    public boolean cadastrarCliente(Cliente cliente) {
        return getListaClientes().add(cliente);
    }

    public boolean removerCliente(Cliente cliente) {
        return getListaClientes().remove(cliente);
    }

    public void listarClientes(String tipoCliente) {
        ArrayList<Cliente> listaClientes = getListaClientes();
        System.out.println("-----" + tipoCliente + "-----");
        if (tipoCliente == "PF") {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = listaClientes.get(i);
                if (cliente instanceof ClientePF) {
                    System.out.println(cliente.toString());
                }
            }
        } else if (tipoCliente == "PJ") {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = listaClientes.get(i);
                if (cliente instanceof ClientePJ) {
                    System.out.println(cliente.toString());
                }
            }
        }
        System.out.println("----------");
    }

    public boolean gerarSeguro(Seguro seguro) {
        return getListaSeguros().add(seguro);
    }

    public boolean cancelarSeguro(Seguro seguro) {
        return getListaSeguros().remove(seguro);
    }

    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
        ArrayList<Seguro> segurosCliente = new ArrayList<>();
        for (Seguro seguro : getListaSeguros()) {
            if (seguro.getCliente().equals(cliente)) {
                segurosCliente.add(seguro);
            }
        }
        return segurosCliente;
    }

    public double calcularReceita() {
        double sum = 0;
        for (Seguro seguro : getListaSeguros()) {
            sum += seguro.getValorMensal();
        }
        return sum;
    }

    // Getters and setters

    public String getCnpj() {
        return this.cnpj;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Seguro> getListaSeguros() {
        return this.listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
