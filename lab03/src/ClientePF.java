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
    }

    // metodos da classe

    public boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }
        boolean todosDigitosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : 11 - resto;
        if (Character.getNumericValue(cpf.charAt(9)) != digitoVerificador1) {
            return false;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : 11 - resto;
        if (Character.getNumericValue(cpf.charAt(10)) != digitoVerificador2) {
            return false;
        }
        return true;
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
