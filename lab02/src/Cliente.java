public class Cliente {
    // declaracao de atributos
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    // consrtutor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    // declaracao de metodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //
    public String getNascimento() {
        return dataNascimento;
    }

    public void setNascimento(String nascimento) {
        this.dataNascimento = nascimento;
    }

    //
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //
    public String toString() {
        String retorno;
        retorno = "O nome do cliente é: " + nome + "\n" + nome + " tem " + idade + " anos de idade \n" + "Seu cpf é: "
                + cpf + "\n" + "Atualmente reside em: " + endereco + "\n" + "E nasceu na seguinte data: "
                + dataNascimento + "\n";
        return retorno;
    }

    public boolean validarCpf(String cpf) {
        String cpfRetificado;
        int cnt = 0, sum1 = 0, sum2 = 0, num;
        int primeiroDigito, segundoDigito;
        cpfRetificado = cpf.replaceAll("\\p{Punct}", "");
        if (cpfRetificado.length() != 11) {
            return false;
        }
        for (int i = 0; i < 11; i++) {
            if (cpfRetificado.charAt(0) == cpfRetificado.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == 11) {
            return false;
        }
        num = 10;
        for (int j = 0; j < 9; j++) {
            sum1 = sum1 + (Character.getNumericValue(cpfRetificado.charAt(j)) * num);
            num = num - 1;
        }
        num = 11;
        for (int i = 0; i < 10; i++) {
            sum2 = sum2 + (Character.getNumericValue(cpfRetificado.charAt(i)) * num);
            num = num - 1;
        }
        primeiroDigito = sum1 * 10 % 11;
        segundoDigito = sum2 * 10 % 11;
        if (primeiroDigito == 10) {
            primeiroDigito = 0;
        }
        if (segundoDigito == 10) {
            segundoDigito = 0;
        }
        if (primeiroDigito != Character.getNumericValue(cpfRetificado.charAt(9))
                || segundoDigito != Character.getNumericValue(cpfRetificado.charAt(10))) {
            return false;
        }
        return true;
    }

}
