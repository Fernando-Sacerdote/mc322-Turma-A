import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Sinistro> listaSinistros = new ArrayList<>();
        ;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ;
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<>();
        ;
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        ;
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
        Sinistro sinistro1 = new Sinistro(formato.parse("24/07/2022"), "Rua dos Acidentes", seguradora1, veiculo1,
                clientePF);
        Sinistro sinistro2 = new Sinistro(formato.parse("24/07/2013"), "Rua das Batidas", seguradora1, veiculo2,
                clientePJ);

        clientePF.adVeiculo(veiculo1);
        clientePF2.adVeiculo(veiculo3);
        clientePJ.adVeiculo(veiculo2);
        seguradora1.cadastrarCliente(clientePJ);
        seguradora1.cadastrarCliente(clientePF);
        seguradora1.cadastrarCliente(clientePF2);
        seguradora1.gerarSinistro(sinistro1);

        listaSinistros.add(sinistro1);
        listaSinistros.add(sinistro2);
        listaClientes.add(clientePF);
        listaClientes.add(clientePF2);
        listaClientes.add(clientePJ);
        listaSeguradoras.add(seguradora1);
        listaVeiculos.add(veiculo1);
        listaVeiculos.add(veiculo2);
        listaVeiculos.add(veiculo3);

        menu(listaSeguradoras, listaClientes, listaSinistros, listaVeiculos);
    }

    public static void exibiMenu() {
        System.out.println("1 - CADASTROS");
        System.out.println("2 - LISTAR");
        System.out.println("3 - EXCLUIR");
        System.out.println("4 - GERAR SINISTRO");
        System.out.println("5 - TRANSFERIR SEGURO");
        System.out.println("6 - CALCULAR RECEITA SEGURADORA");
        System.out.println("0 - SAIR");
    }

    public static void exibiMenuExcluir() {
        System.out.println("1 - EXCLUIR CLIENTE");
        System.out.println("2 - EXCLUIR VEICULO");
        System.out.println("3 - EXCLUIR SINISTRO");
        System.out.println("0 - VOLTAR");
    }

    public static void exibiMenuListar() {
        System.out.println("1 - LISTAR CLIENTES");
        System.out.println("2 - LISTAR SINISTROS POR SEGURADORA");
        System.out.println("3 - LISTAR SINISTRO POR CLIENTE");
        System.out.println("4 - LISTAR VEICULO POR CLIENTE");
        System.out.println("5 - LISTAR VEICULO POR SEGURADORA");
        System.out.println("0 - VOLTAR");
    }

    public static void exibiMenuCadastro() {
        System.out.println("1 - CADASTRAR CLIENTE");
        System.out.println("2 - CADASTRAR VEICULO");
        System.out.println("3 - CADASTRAR SEGURADORA");
        System.out.println("0 - VOLTAR");
    }

    public static void geraSinistro(ArrayList<Seguradora> lSeguradoras, ArrayList<Cliente> lClientes,
            ArrayList<Sinistro> lSinistros, ArrayList<Veiculo> lVeiculos) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner entrada = new Scanner(System.in);
        String endereco;
        String data;
        Cliente cliente = null;
        Veiculo veiculo = null;
        Seguradora seguradora = null;
        String entradaDados;
        boolean temCliente = false;
        boolean temSeguradora = false;
        boolean temVeiculo = false;
        Date date = null;
        System.out.println("Informe a data do sinistro:");
        data = entrada.nextLine();
        try {
            date = formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Informe o endereco do sinistro:");
        endereco = entrada.nextLine();
        System.out.println("Informe o cliente atrelado ao sinistro:");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lClientes.size(); i++) {
            if (lClientes.get(i).getNome() == entradaDados) {
                temCliente = true;
                cliente = lClientes.get(i);
            }
        }
        System.out.println("Informe a seguradora atrelada ao sinistro:");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        System.out.println("Informe a placa do veiculo atrelado ao sinistro:");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lVeiculos.size(); i++) {
            if (lVeiculos.get(i).getPlaca() == entradaDados) {
                temVeiculo = true;
                veiculo = lVeiculos.get(i);
            }
        }
        if (temCliente && temSeguradora && temVeiculo) {
            Sinistro sinistro = new Sinistro(date, endereco, seguradora, veiculo, cliente);
            lSinistros.add(sinistro);
        } else {
            System.out.println("Problema ao gerar o sinistro");
        }
        entrada.close();
    }

    public static void tranfereSeguro(ArrayList<Cliente> lClientes) {
        ArrayList<Veiculo> novaLista = new ArrayList<>();
        Cliente cliente1 = null;
        Cliente cliente2 = null;
        boolean temCliente1 = false;
        boolean temCliente2 = false;
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        System.out.println("Digite o nome do cliente que transferira o seguro");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lClientes.size(); i++) {
            if (lClientes.get(i).getNome() == entradaDados) {
                temCliente1 = true;
                cliente1 = lClientes.get(i);
            }
        }
        System.out.println("Digite o nome do cliente que recebera o seguro");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lClientes.size(); i++) {
            if (lClientes.get(i).getNome() == entradaDados) {
                temCliente2 = true;
                cliente2 = lClientes.get(i);
            }
        }
        if (temCliente1 && temCliente2) {
            for (int i = 0; i < cliente1.getListaVeiculos().size(); i++) {
                cliente2.adVeiculo(cliente1.getListaVeiculos().get(i));
            }
            cliente1.setListaVeiculos(novaLista);
            cliente1.calculaScore();
            cliente2.calculaScore();
        } else {
            System.out.println("Problema na rtanferencia de veiculos");
        }
        entrada.close();
    }

    public static void calculaReceita(ArrayList<Seguradora> lSeguradoras) {
        Seguradora seguradora = null;
        boolean temSeguradora = false;
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        System.out.println("Digite o nome da seguradora");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        if (temSeguradora) {
            System.out.println("RECEIA: " + seguradora.calcularReceita());
        } else {
            System.out.println("Problema ao calcular receita");
        }
        entrada.close();
    }

    public static void cadastraCliente(ArrayList<Cliente> lClientes, ArrayList<Seguradora> lSeguradoras) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temSeguradora = false;
        System.out.println("Informe a seguradora");
        entradaDados = entrada.nextLine();
        Seguradora seguradora = null;
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        if (!temSeguradora) {
            System.out.println("Erro no cadastro");
            entrada.close();
            return;
        }

        System.out.println("Digite o tipo do cliente");
        entradaDados = entrada.nextLine();
        if (entradaDados == "PF") {
            Date dataNasc = null;
            Date dataLisc = null;
            System.out.println("Insira o nome do cliente:");
            String nome = entrada.nextLine();
            System.out.println("Insira o endereco do cliente:");
            String endereco = entrada.nextLine();
            System.out.println("Insira o CPF do cliente:");
            String cpf = entrada.nextLine();
            System.out.println("Insira o genero do cliente:");
            String genero = entrada.nextLine();
            System.out.println("Insira a educacao do cliente:");
            String educacao = entrada.nextLine();
            System.out.println("Insira a classe economica do cliente:");
            String classeEconomica = entrada.nextLine();
            System.out.println("Insira a data de nascimento do cliente:");
            String dataNascimento = entrada.nextLine();
            try {
                dataNasc = formato.parse(dataNascimento);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Insira a data de liscensa do cliente:");
            String dataLicenca = entrada.nextLine();
            try {
                dataLisc = formato.parse(dataLicenca);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ClientePF cliente = new ClientePF(nome, endereco, cpf, genero, dataLisc, educacao, dataNasc,
                    classeEconomica);
            seguradora.getListaClientes().add(cliente);
            lClientes.add(cliente);
        } else if (entradaDados == "PJ") {
            Date dataFund = null;
            System.out.println("Insira o nome do cliente:");
            String nome = entrada.nextLine();
            System.out.println("Insira o endereco do cliente:");
            String endereco = entrada.nextLine();
            System.out.println("Insira o CNPJ do cliente:");
            String cnpj = entrada.nextLine();
            System.out.println("Insira a data de fundacao do cliente:");
            String dataFundacao = entrada.nextLine();
            try {
                dataFund = formato.parse(dataFundacao);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ClientePJ cliente = new ClientePJ(nome, endereco, cnpj, dataFund);
            seguradora.getListaClientes().add(cliente);
            lClientes.add(cliente);
        } else {
            System.out.println("Erro no cadastro");
        }
        entrada.close();
    }

    public static void cadastrarVeiculo(ArrayList<Cliente> lClientes, ArrayList<Veiculo> lVeiculos) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temCliente = false;
        System.out.println("Informe o cliente");
        entradaDados = entrada.nextLine();
        Cliente cliente = null;
        for (int i = 0; i < lClientes.size(); i++) {
            if (lClientes.get(i).getNome() == entradaDados) {
                temCliente = true;
                cliente = lClientes.get(i);
            }
        }
        if (!temCliente) {
            System.out.println("Erro no cadastro");
            entrada.close();
            return;
        }
        System.out.println("Digite a placa do veiculo");
        String placa = entrada.nextLine();
        System.out.println("Digite a marca do veiculo");
        String marca = entrada.nextLine();
        System.out.println("Digite o modelo do veiculo");
        String modelo = entrada.nextLine();
        System.out.println("Digite o ano de fabricacao do veiculo");
        int anoFabricacao = entrada.nextInt();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
        cliente.adVeiculo(veiculo);
        entrada.close();
    }

    public static void cadastrarSeguradora(ArrayList<Seguradora> lSeguradoras) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome da seguradora");
        String nome = entrada.nextLine();
        System.out.println("Digite o telefone da seguradora");
        String telefone = entrada.nextLine();
        System.out.println("Digite o email da seguradora");
        String email = entrada.nextLine();
        System.out.println("Digite o endereco da seguradora");
        String endereco = entrada.nextLine();
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
        lSeguradoras.add(seguradora);
        entrada.close();
    }

    public static void menuCadastro(ArrayList<Seguradora> lSeguradoras, ArrayList<Cliente> lClientes,
            ArrayList<Sinistro> lSinistros, ArrayList<Veiculo> lVeiculos) {
        Scanner entrada = new Scanner(System.in);
        int comando = entrada.nextInt();
        MenuCadastro menu;
        menu = MenuCadastro.values()[comando];
        while (comando != 0) {
            switch (menu) {
                case CADASTRAR_CLIENTE:
                    cadastraCliente(lClientes, lSeguradoras);
                    break;
                case CADASTRAR_SEGURADORA:
                    cadastrarSeguradora(lSeguradoras);
                    break;
                case CADASTRAR_VEICULO:
                    cadastrarVeiculo(lClientes, lVeiculos);
                    break;
                case VOLTAR:
                    System.out.println("Fechando menu...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Comando invalido, tente novamente!");
                    break;
            }
            System.out.println("Digite o próximo comando");
            comando = entrada.nextInt();
            menu = MenuCadastro.values()[comando];
        }
        entrada.close();
    }

    public static void listarCliente(ArrayList<Seguradora> lSeguradoras) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temSeguradora = false;
        System.out.println("Informe a seguradora");
        entradaDados = entrada.nextLine();
        Seguradora seguradora = null;
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        if (!temSeguradora) {
            System.out.println("Erro na listagem");
            entrada.close();
            return;
        }
        seguradora.listarClientes("PJ");
        seguradora.listarClientes("PF");
        entrada.close();
    }

    public static void listarSnistrosCliente(ArrayList<Sinistro> lSinistros) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        System.out.println("Informe o cliente");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSinistros.size(); i++) {
            if (lSinistros.get(i).getCliente().getNome() == entradaDados) {
                System.out.println(lSinistros.get(i).toString());
            }
        }
        entrada.close();
    }

    public static void listarSinistrosSegurador(ArrayList<Sinistro> lSinistros) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        System.out.println("Informe a seguradora");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSinistros.size(); i++) {
            if (lSinistros.get(i).getSeguradora().getNome() == entradaDados) {
                System.out.println(lSinistros.get(i).toString());
            }
        }
        entrada.close();
    }

    public static void lisrVeiculosCliente(ArrayList<Cliente> lClientes) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temCliente = false;
        Cliente cliente = null;
        System.out.println("Digite o nome do cliente");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lClientes.size(); i++) {
            if (lClientes.get(i).getNome() == entradaDados) {
                temCliente = true;
                cliente = lClientes.get(i);
            }
        }
        if (!temCliente) {
            System.out.println("Erro ao listar");
            entrada.close();
            return;
        } else {
            System.out.println(cliente.getListaVeiculos());
        }
        entrada.close();
    }

    public static void listarVeiculosSeguradora(ArrayList<Seguradora> lSeguradoras) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temSeguradora = false;
        Seguradora seguradora = null;
        System.out.println("Digite o nome da seguradora");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        if (!temSeguradora) {
            System.out.println("Erro ao listar");
            entrada.close();
            return;
        } else {
            ArrayList<Cliente> listaClientes = seguradora.getListaClientes();
            for (int i = 0; i < listaClientes.size(); i++) {
                System.out.println(listaClientes.get(i).getListaVeiculos());
            }
        }
        entrada.close();
    }

    public static void menuListar(ArrayList<Seguradora> lSeguradoras, ArrayList<Cliente> lClientes,
            ArrayList<Sinistro> lSinistros, ArrayList<Veiculo> lVeiculos) {
        Scanner entrada = new Scanner(System.in);
        int comando = entrada.nextInt();
        MenuListar menu;
        menu = MenuListar.values()[comando];
        while (comando != 0) {
            switch (menu) {
                case LISTAR_CLIENTE:
                    listarCliente(lSeguradoras);
                    break;
                case LISTAR_SINISTROS_CLIENTE:
                    listarSnistrosCliente(lSinistros);
                    break;
                case LISTAR_SINISTROS_SEGURADORA:
                    listarSinistrosSegurador(lSinistros);
                    break;
                case LISTAR_VEICULO_CLIENTE:
                    lisrVeiculosCliente(lClientes);
                    break;
                case LISTAR_VEICULO_SEGURADORA:
                    listarVeiculosSeguradora(lSeguradoras);
                    break;
                case VOLTAR:
                    System.out.println("Fechando menu...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Comando invalido, tente novamente!");
                    break;
            }
            System.out.println("Digite o próximo comando");
            comando = entrada.nextInt();
            menu = MenuListar.values()[comando];
        }
        entrada.close();
    }

    public static void excluirCliente(ArrayList<Seguradora> lSeguradoras, ArrayList<Cliente> lClientes) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temSeguradora = false;
        Seguradora seguradora = null;
        System.out.println("Digite o nome da seguradora");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        if (!temSeguradora) {
            System.out.println("Erro ao excuir");
            entrada.close();
            return;
        } else {
            System.out.println("Digite o nome do cliente");
            String cliente = entrada.nextLine();
            if (seguradora.removerCliente(cliente)) {
                System.out.println("Cliente removido");
                for (int i = 0; i < lClientes.size(); i++) {
                    Cliente clienteObj = lClientes.get(i);
                    if (clienteObj.getNome() == cliente) {
                        lClientes.remove(i);
                    }
                }
            } else {
                System.out.println("Cliente não existente");
            }
        }
        entrada.close();
    }

    public static void excluirSinistro(ArrayList<Seguradora> lSeguradoras, ArrayList<Sinistro> lSinistros) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temSeguradora = false;
        Seguradora seguradora = null;
        System.out.println("Digite o nome da seguradora");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lSeguradoras.size(); i++) {
            if (lSeguradoras.get(i).getNome() == entradaDados) {
                temSeguradora = true;
                seguradora = lSeguradoras.get(i);
            }
        }
        if (!temSeguradora) {
            System.out.println("Erro ao excuir");
            entrada.close();
            return;
        } else {
            System.out.println("Digite o id do sinistro");
            int id = entrada.nextInt();
            for (int i = 0; i < seguradora.getListaSinistros().size(); i++) {
                Sinistro sinistro = seguradora.getListaSinistros().get(i);
                if (sinistro.getId() == id) {
                    seguradora.getListaSinistros().remove(sinistro);
                    lSinistros.remove(sinistro);
                }
            }
        }
        entrada.close();
    }

    public static void excluirVeiculo(ArrayList<Cliente> lClientes, ArrayList<Veiculo> lVeiculos) {
        Scanner entrada = new Scanner(System.in);
        String entradaDados;
        boolean temCliente = false;
        Cliente cliente = null;
        System.out.println("Digite o nome do cliente");
        entradaDados = entrada.nextLine();
        for (int i = 0; i < lClientes.size(); i++) {
            if (lClientes.get(i).getNome() == entradaDados) {
                temCliente = true;
                cliente = lClientes.get(i);
            }
        }
        if (!temCliente) {
            System.out.println("Erro ao excuir");
            entrada.close();
            return;
        } else {
            System.out.println("Digite a placa dp veiculos");
            String placa = entrada.nextLine();
            for (int i = 0; i < cliente.getListaVeiculos().size();  i++) {
                Veiculo veiculo = cliente.getListaVeiculos().get(i);
                if (veiculo.getPlaca() == placa) {
                    cliente.getListaVeiculos().remove(veiculo);
                    lVeiculos.remove(veiculo);
                }
            }
        }
        entrada.close();
    }

    public static void menuExcluir(ArrayList<Seguradora> lSeguradoras, ArrayList<Cliente> lClientes,
            ArrayList<Sinistro> lSinistros, ArrayList<Veiculo> lVeiculos) {
        Scanner entrada = new Scanner(System.in);
        int comando = entrada.nextInt();
        MenuExcluir menu;
        menu = MenuExcluir.values()[comando];
        while (comando != 0) {
            switch (menu) {
                case EXCLUIR_CLIENTE:
                    excluirCliente(lSeguradoras, lClientes);
                    break;
                case EXCLUIR_SINISTRO:
                    excluirSinistro(lSeguradoras, lSinistros);
                    break;
                case EXCLUIR_VEICULO:
                    excluirVeiculo(lClientes, lVeiculos);
                    break;
                case VOLTAR:
                    System.out.println("Fechando menu...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Comando invalido, tente novamente!");
                    break;
            }
            System.out.println("Digite o próximo comando");
            comando = entrada.nextInt();
            menu = MenuExcluir.values()[comando];
        }
        entrada.close();
    }

    public static void menu(ArrayList<Seguradora> lSeguradoras, ArrayList<Cliente> lClientes,
            ArrayList<Sinistro> lSinistros, ArrayList<Veiculo> lVeiculos) {
        exibiMenu();
        Scanner entrada = new Scanner(System.in);
        int comando = entrada.nextInt();
        MenuOperacoes menu;
        menu = MenuOperacoes.values()[comando];
        while (comando != 0) {
            switch (menu) {
                case CADASTRAR:
                    exibiMenuCadastro();
                    menuCadastro(lSeguradoras, lClientes, lSinistros, lVeiculos);
                    break;
                case LISTAR:
                    exibiMenuListar();
                    menuListar(lSeguradoras, lClientes, lSinistros, lVeiculos);
                    break;
                case EXCLUIR:
                    exibiMenuExcluir();
                    menuExcluir(lSeguradoras, lClientes, lSinistros, lVeiculos);
                    break;
                case GERAR_SINITRO:
                    geraSinistro(lSeguradoras, lClientes, lSinistros, lVeiculos);
                    break;
                case TRANSFERIR_SEGURO:
                    tranfereSeguro(lClientes);
                    break;
                case CALCULAR_RECEITA:
                    calculaReceita(lSeguradoras);
                    break;
                case SAIR:
                    System.out.println("Fechando menu...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Comando invalido, tente novamente!");
                    break;
            }
            System.out.println("Digite o próximo comando");
            comando = entrada.nextInt();
            menu = MenuOperacoes.values()[comando];
        }
        entrada.close();
    }
}