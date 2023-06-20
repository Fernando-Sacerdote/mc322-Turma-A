import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;
    private ArrayList<Frota> listaFrota;
    private int qtdeFuncionarios;

    // construtor

    public ClientePJ(String nome, String telefone, String endereco, String email, String CNPJ, Date dataFundacao,
            int qtdeFuncionarios) {
        super(nome, telefone, endereco, email);
        ArrayList<Frota> listaFrota = new ArrayList<>();
        setListaFrota(listaFrota);
        this.CNPJ = CNPJ;
        setDataFundacao(dataFundacao);
        setQtdeFuncionarios(qtdeFuncionarios);
    }

    // metodos da classe

    public boolean cadastrarFrota(Frota frota) {
        return getListaFrota().add(frota);
    }

    public boolean getVeiculosPorFrota(Frota frota) {
        if (getListaFrota().contains(frota)) {
            System.out.println(frota.getListaVeiculos());
            return true;
        } else {
            return false;
        }
    }

    public void atualizarFrota(String code, ArrayList<Veiculo> listaVeiculos, Frota frota) {
        frota.setCode(code);
        frota.setListaVeiculos(listaVeiculos);
    }

    // getters and setters

    public String getCNPJ() {
        return this.CNPJ;
    }

    public Date getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }

    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    public int getQtdeFuncionarios() {
        return this.qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    // toString

    @Override
    public String toString() {
        String retorno;
        retorno = "-----CLIENTE PJ-----\n" + "Nome: " + getNome() + "\n" + "Endereco: " + getEndereco() + "\n"
                + "CNPJ: " + getCNPJ() + "\n" + "Data de Fundacao: " + getDataFundacao() + "\n"
                + "Quantidade de funcionários: " + getQtdeFuncionarios() + "\n"
                + "--------------------\n";
        return retorno;
    }
}
