import java.util.Calendar;
import java.util.Date;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    // toString

    @Override
    public String toString() {
        String retorno;
        retorno = "-----SEGURO PJ-----\n" + "Data inicio: " + getDataInicio() + "\n" + "Data fim: " + getDataFim()
                + "\n" + "---------------------\n";
        return retorno;
    }

    // construtor

    public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota,
            ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        setValorMensal(0);
        setFrota(frota);
        setCliente(cliente);
    }

    // gets and sets

    public Frota getFrota() {
        return this.frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePJ cliente) {
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
        ClientePJ cliente = getCliente();
        int quantidadeFuncionarios = cliente.getQtdeFuncionarios();
        int quantidadeVeiculos = getFrota().getListaVeiculos().size();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(cliente.getDataFundacao());
        int ano = calendario.get(Calendar.YEAR);
        int anosPosFundacao = 2023 - ano;
        int quantidadeSinistrosCliente = getListaSinistro().size();
        int quantidadeSinistrosCondutor = condutor.getListaSinistros().size();
        setValorMensal(CalcSeguro.VALOR_BASE_PJ.getValor() * (10 + (quantidadeFuncionarios) / 10)
                * (1 + 1 / (quantidadeVeiculos + 2)) * (1 + 1 / (anosPosFundacao + 2))
                * (2 + quantidadeSinistrosCliente / 10) * (5 + quantidadeSinistrosCondutor / 10));
    }

    @Override
    public void gerarSinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
        getListaSinistro().add(new Sinistro(data, endereco, condutor, seguro));
    }
}
