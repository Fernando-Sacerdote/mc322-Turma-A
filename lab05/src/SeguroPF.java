import java.util.Calendar;
import java.util.Date;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    // toString

    @Override
    public String toString() {
        String retorno;
        retorno = "-----SEGURO PF-----\n" + "Data inicio: " + getDataInicio() + "\n" + "Data fim: " + getDataFim()
                + "\n" + "---------------------\n";
        return retorno;
    }

    // construtor

    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo,
            ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        setVeiculo(veiculo);
        setCliente(cliente);
    }

    // sets and gets

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public ClientePF getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean desautorizarCondutor(String nome) {
        for (Condutor condutor : getListaCondutores()) {
            if (condutor.getNome() == nome) {
                condutor.setAutorizacao(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean autorizarCondutor(String nome) {
        for (Condutor condutor : getListaCondutores()) {
            if (condutor.getNome() == nome) {
                condutor.setAutorizacao(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void calcularValor(Condutor condutor) {
        ClientePF cliente = getCliente();
        int quantidadeVeiculos = cliente.getListaVeiculos().size();
        int quantidadeSinistrosClientes = getListaSinistro().size();
        int quantidadeSinistrosCondutor = condutor.getListaSinistros().size();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(cliente.getDataNascimento());
        int ano = calendario.get(Calendar.YEAR);
        int idade = 2023 - ano;
        double faixaIdade = 0;
        if (idade >= 18 && idade < 30) {
            faixaIdade = CalcSeguro.FATOR_30.getValor();
        } else if (idade >= 30 && idade < 60) {
            faixaIdade = CalcSeguro.FATOR_30_60.getValor();
        } else if (idade >= 60 && idade < 90) {
            faixaIdade = CalcSeguro.FATOR_60.getValor();
        }
        setValorMensal(CalcSeguro.VALOR_BASE_PF.getValor() * faixaIdade * (1 + 1 / (quantidadeVeiculos + 2))
                * (2 + quantidadeSinistrosClientes / 10) * (5 + quantidadeSinistrosCondutor / 10));
    }

    @Override
    public void gerarSinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
        getListaSinistro().add(new Sinistro(data, endereco, condutor, seguro));
    }

}
