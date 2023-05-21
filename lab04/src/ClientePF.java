import java.util.Calendar;
import java.util.Date;

public class ClientePF extends Cliente {
    final private String CPF;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    // construtor

    public ClientePF(String nome, String endereco, String CPF, String genero, Date dataLicenca, String educacao,
            Date dataNascimento, String classeEconomica) {
        super(nome, endereco);
        this.tipo = "PF";
        this.CPF = CPF;
        setGenero(genero);
        setDataLicenca(dataLicenca);
        setEducacao(educacao);
        setDataNascimento(dataNascimento);
        setClasseEconomica(classeEconomica);
        calculaScore();
    }

    // metodos da classe

    @Override
    public void calculaScore() {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this.dataNascimento);
        int ano = calendario.get(Calendar.YEAR);
        int idade = 2023 - ano;
        double faixaIdade = 0;
        if (idade >= 18 && idade < 30) {
            faixaIdade = CalcSeguro.FATOR_18_30.getValor();
        } else if (idade >= 30 && idade < 60) {
            faixaIdade = CalcSeguro.FATOR_30_60.getValor();
        } else if (idade >= 60 && idade < 90) {
            faixaIdade = CalcSeguro.FATOR_60_90.getValor();
        }
        setValorSeguro(CalcSeguro.VALOR_BASE.getValor() * faixaIdade * getListaVeiculos().size());
    }

    @Override
    public String toString() {
        String retorno;
        retorno = "-----CLIENTE PF-----\n" + "Nome: " + getNome() + "\n" + "Endereco: " + getEndereco() + "\n" + "CPF: "
                + getCPF() + "\n" + "Genero: " + getGenero() + "\n" + "Data Nascimento: " + getDataNascimento() + "\n"
                + "Educacao: " + getEducacao() + "\n" + "Data Licenca: " + getDataLicenca() + "\n"
                + "Classe Economica: " + getClasseEconomica() + "\n" + "--------------------\n";
        return retorno;
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

    public Date getDataLicenca() {
        return this.dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
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

    public String getClasseEconomica() {
        return this.classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
}
