import java.util.ArrayList;

public class Seguradora {
    // Atributos da classe Seguradora
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    // construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        ArrayList<Sinistro> listaSinistros = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        setNome(nome);
        setEndereco(endereco);
        setListaClientes(listaClientes);
        setListaSinistros(listaSinistros);
    }

    // metodos da classe

    public boolean cadastrarCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerCliente(String cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente clienteObj = listaClientes.get(i);
            if (clienteObj.getNome() == cliente) {
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public void listarClientes(String tipoCliente) {
        ArrayList<Cliente> listaClientes = getListaClientes();
        System.out.println("-----" + tipoCliente + "-----");
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            if (cliente.getTipo() == tipoCliente) {
                System.out.println(cliente.toString());
            }
        }
        System.out.println("----------");
    }

    public boolean gerarSinistro(Sinistro sinistro) {
        if (!listaSinistros.contains(sinistro)) {
            listaSinistros.add(sinistro);
            return true;
        } else {
            return false;
        }
    }

    public boolean visualizarSinistro(String cliente) {
        ArrayList<Sinistro> listaSinistros = getListaSinistros();
        for (int i = 0; i < listaSinistros.size(); i++) {
            Cliente clienteObj = listaSinistros.get(i).getCliente();
            if (clienteObj.getNome() == cliente) {
                System.out.println(listaSinistros.get(i).toString());
                return true;
            }
        }
        return false;
    }

    public void listarSinistros() {
        ArrayList<Sinistro> listaSinistros = getListaSinistros();
        for (int i = 0; i < listaSinistros.size(); i++) {
            System.out.println(listaSinistros.get(i));
        }
    }

    public String toString() {
        String retorno;
        retorno = "-----" + getNome() + "-----" + "\n" + "Endereco: " + getEndereco() + "\n" + "Telefone: "
                + getTelefone() + "\n" + "Email: " + getEmail() + "\n" + "Sinistros: " + getListaSinistros() + "\n"
                + "---------------------";

        return retorno;
    }

    // Getters and setters
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

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
