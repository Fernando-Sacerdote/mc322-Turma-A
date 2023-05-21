public class Validacao {

    public static boolean validarCPF(String cpf) {
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

    public static boolean validarCNPJ(String cnpj) {
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

    public static boolean validaNome(String nome) {
        boolean soTemLetra = nome.matches("[a-zA-Z]+");
        return soTemLetra;
    }

}
