import java.text.SimpleDateFormat;

public class Main {
        public static void main(String[] args) throws Exception {
                // formato de data
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                // instanciando objetos de todas as classes
                ClientePF clientePF1 = new ClientePF("Ricardo", "(19) 99292-6745", "Rua Porto Alegre",
                                "ricardo@gmail.com",
                                "502.389.088-01", "M", "Educado", formato.parse("24/07/2003"));
                ClientePJ clientePJ1 = new ClientePJ("Ricardo's Carros", "(19) 3457-8720", "Rua da Pamonha",
                                "ricardos.motors@gmail.com", "65.387.345/0001-95", formato.parse("24/06/2022"), 5);
                Seguradora seguradora1 = new Seguradora("Segura Seguros", "(19) 3457-0871",
                                "segura.seguros@gmail.com.br",
                                "Rua Segura", "17.758.388/0001-97");
                Veiculo veiculo1 = new Veiculo("GCN-459", "Toyota", "Corolla", 2020);
                SeguroPF seguroPF1 = new SeguroPF(formato.parse("24/01/2021"), formato.parse("24/07/2021"), seguradora1,
                                veiculo1, clientePF1);
                Frota frota1 = new Frota("502A19F051K807P240");
                SeguroPJ seguroPJ1 = new SeguroPJ(formato.parse("24/07/2022"), formato.parse("24/01/2023"), seguradora1,
                                frota1,
                                clientePJ1);
                seguradora1.gerarSeguro(seguroPJ1);
                seguradora1.gerarSeguro(seguroPF1);
                Condutor condutor1 = new Condutor("602.789.022-01", "Reinaldo", "(19) 99292-6746", "Rua das Tamaras",
                                "reinaldo@gmail.com", formato.parse("27/02/1998"));
                seguroPF1.gerarSinistro(formato.parse("18/06/2023"), "Rua do Carmo", condutor1, seguroPF1);

                // toString dos objetos de cada classe
                System.out.println(seguradora1.toString());
                System.out.println(clientePJ1.toString());
                System.out.println(clientePF1.toString());
                System.out.println(veiculo1.toString());
                System.out.println(seguroPF1.toString());
                System.out.println(frota1.toString());
                System.out.println(seguroPJ1.toString());
                System.out.println(condutor1.toString());
                System.out.println(seguroPF1.getListaSinistro());

                // exemplos dos metodos da seguradora

                seguradora1.cadastrarCliente(clientePJ1);
                seguradora1.cadastrarCliente(clientePF1);
                seguradora1.removerCliente(clientePJ1);
                seguradora1.listarClientes("PF");
                seguradora1.listarClientes("PJ");
                seguradora1.cancelarSeguro(seguroPJ1);
                System.out.println(seguradora1.getSegurosPorCliente(clientePF1));
                System.out.println(seguradora1.getListaSeguros());
                seguroPF1.calcularValor(condutor1);
                seguroPJ1.calcularValor(condutor1);
                System.out.println(seguradora1.calcularReceita());
        }
}