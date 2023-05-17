import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Seguradora seguradora1 = new Seguradora("FernandoSeguros", "(19)992926745", "fernando.sacerdote@hotmail.com",
                "Rua do Seguro");
        ClientePF clientePF = new ClientePF("Fernando", "Rua das Bolhas", "502.389.088-01", "masculino",
                formato.parse("24/07/2025"),
                "Ensino médio", formato.parse("24/07/2003"), "media");
        ClientePJ clientePJ = new ClientePJ("FernandoMotores", "Rua dos Motores", "43.711.521/0001-60",
                formato.parse("24/07/2004"));
        ClientePF clientePF2 = new ClientePF("João Removido", "Rua dos removidos", "538.903.832-02", "masculino",
                formato.parse("24/07/2021"), "educado", formato.parse("24/07/2005"), "alta");
        Veiculo veiculo1 = new Veiculo("GCN-0606", "Chevrolet", "Onix", 2020);
        Veiculo veiculo2 = new Veiculo("CAP-0707", "Toyota", "Corolla", 2019);
        Veiculo veiculo3 = new Veiculo("REM-0909", "Ferrari", "F8", 2023);
        Sinistro sinistro = new Sinistro(formato.parse("24/07/2022"), "Rua dos Acidentes", seguradora1, veiculo1,
                clientePF);

        clientePF.adVeiculo(veiculo1);
        clientePF2.adVeiculo(veiculo3);
        clientePJ.adVeiculo(veiculo2);
        System.out.println(clientePF.getListaVeiculos());
        System.out.println(clientePJ.getListaVeiculos());
        System.out.println(clientePF2.getListaVeiculos());

        if (clientePF.validarCPF(clientePF.getCPF())) {
            System.out.println("Cpf do cliente 1 é valido");
        } else {
            System.out.println("Cpf do cliente 1 é inválido");
        }
        if (clientePF2.validarCPF(clientePF2.getCPF())) {
            System.out.println("Cpf do cliente 2 é valido");
        } else {
            System.out.println("Cpf do cliente 2 é inválido");
        }
        if (clientePJ.validarCNPJ(clientePJ.getCNPJ())) {
            System.out.println("Cnpj do cliente 3 é valido");
        } else {
            System.out.println("Cnpj do cliente 3 é inválido");
        }
        seguradora1.cadastrarCliente(clientePJ);
        seguradora1.cadastrarCliente(clientePF);
        seguradora1.cadastrarCliente(clientePF2);
        System.out.println(seguradora1.getListaClientes());
        seguradora1.removerCliente("João Removido");
        System.out.println(seguradora1.getListaClientes());
        seguradora1.gerarSinistro(sinistro);
        seguradora1.visualizarSinistro("Fernando");
        menu(seguradora1);
    }

    public static void menu(Seguradora seguradora) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vindo ao menu da seguradora: " + seguradora.getNome());
        System.out.println("Digite 1 para receber o email de contato");
        System.out.println("Digite 2 para receber o telefone de contato");
        System.out.println("Digite 3 para receber o endereco comercial");
        System.out.println("Digite 4 para receber todos os dados da seguradora");
        System.out.println("Digite 5 para receber os clientes da seguradora");
        System.out.println("Digite 6 para receber os sinistros da seguradora");
        System.out.println("Digite 7 para receber os cliente PF da seguradora");
        System.out.println("Digite 8 para receber os clientes PJ da seguradora");
        System.out.println("Digite 0 para sair do menu");
        String comando = entrada.nextLine();
        while (comando != "0") {
            switch (comando) {
                case "0":
                    System.out.println("Obrigado por acessar nosso menu, volte sempre!");
                    entrada.close();
                    return;
                case "1":
                    System.out.println(seguradora.getEmail());
                    break;
                case "2":
                    System.out.println(seguradora.getTelefone());
                    break;
                case "3":
                    System.out.println(seguradora.getEndereco());
                    break;
                case "4":
                    System.out.println(seguradora.toString());
                    break;
                case "5":
                    System.out.println(seguradora.getListaClientes());
                    break;
                case "6":
                    seguradora.listarSinistros();
                    break;
                case "7":
                    seguradora.listarClientes("PF");
                    break;
                case "8":
                    seguradora.listarClientes("PJ");
                    break;
                default:
                    System.out.println("Comando invalido, tente novamente!");
                    break;
            }
            System.out.println("Digite o próximo comando");
            comando = entrada.nextLine();
        }
        entrada.close();
    }
}