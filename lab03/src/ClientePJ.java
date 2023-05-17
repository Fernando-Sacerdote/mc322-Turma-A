import java.util.Date;

public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;

    // construtor

    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao) {
        super(nome, endereco);
        this.tipo = "PJ";
        this.CNPJ = CNPJ;
        setDataFundacao(dataFundacao);
    }

    // metodos da classe

    public boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");
        if (cnpj.length() != 14) {
            return false;
        }
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        int soma = 0;
        int peso = 5;
        for (int i = 0; i < 12; i++) {
            int num = Character.getNumericValue(cnpj.charAt(i));
            soma += num * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int dv1 = 11 - (soma % 11);
        if (dv1 >= 10) {
            dv1 = 0;
        }
        soma = 0;
        peso = 6;
        for (int i = 0; i < 13; i++) {
            int num = Character.getNumericValue(cnpj.charAt(i));
            soma += num * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int dv2 = 11 - (soma % 11);
        if (dv2 >= 10) {
            dv2 = 0;
        }
        return (dv1 == Character.getNumericValue(cnpj.charAt(12)))
                && (dv2 == Character.getNumericValue(cnpj.charAt(13)));
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
