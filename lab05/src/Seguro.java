import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

public abstract class Seguro {
    final private int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistro;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;

    // construtor

    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora) {
        this.id = randomId();
        ArrayList<Sinistro> listaSinistros = new ArrayList<>();
        ArrayList<Condutor> listaCondutores = new ArrayList<>();
        setListaSinistro(listaSinistros);
        setListaCondutores(listaCondutores);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setSeguradora(seguradora);
    }

    // gets and sets

    public int getId() {
        return id;
    }

    public int randomId() {
        Random id = new Random();
        return id.nextInt();
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistro() {
        return this.listaSinistro;
    }

    public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public abstract boolean desautorizarCondutor(String nome);

    public abstract boolean autorizarCondutor(String nome);

    public abstract void calcularValor(Condutor condutor);

    public abstract void gerarSinistro(Date data, String endereco, Condutor condutor, Seguro seguro);

    public abstract Cliente getCliente();

}
