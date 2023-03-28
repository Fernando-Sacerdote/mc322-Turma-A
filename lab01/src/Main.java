public class Main {
    public static void main(String[] args) throws Exception {
        Cliente pedrinho;
        Sinistro batida;
        batida = new Sinistro("13/02/2023", "rua pequim");
        pedrinho = new Cliente("pedrinho", "502.389.088-01", "24/07/2003", 19, "rua do caju");
        if (pedrinho.validarCpf(pedrinho.getCpf())) {
            System.out.println("Cpf verificacdo!");
        } else {
            System.out.println("Cpf inválido!");
        }
        System.out.println(pedrinho.toString());
        System.out.println(batida.getId());
    }
}