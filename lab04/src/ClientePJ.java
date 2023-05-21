import java.util.Date;

public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    // construtor

    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao) {
        super(nome, endereco);
        this.tipo = "PJ";
        this.CNPJ = CNPJ;
        setDataFundacao(dataFundacao);
        calculaScore();
    }

    // metodos da classe

    @Override
    public void calculaScore() {
        setValorSeguro(
                CalcSeguro.VALOR_BASE.getValor() * (1 + (getQtdeFuncionarios()) / 100) * getListaVeiculos().size());
    }

    @Override
    public String toString() {
        String retorno;
        retorno = "-----CLIENTE PJ-----\n" + "Nome: " + getNome() + "\n" + "Endereco: " + getEndereco() + "\n"
                + "CNPJ: " + getCNPJ() + "\n" + "Data de Fundacao: " + getDataFundacao() + "\n"
                + "--------------------\n";
        return retorno;
    }

    // getters and setters

    public int getQtdeFuncionarios() {
        return this.qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public Date getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
