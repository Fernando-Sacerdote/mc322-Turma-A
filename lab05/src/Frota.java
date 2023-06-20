import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    // toString

    public String toString() {
        String retorno;
        retorno = "-----Frota-----\n" + "Codigo: " + getCode() + "\n" + "--------------------\n";
        return retorno;
    }

    // construtor

    public Frota(String code) {
        setCode(code);
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        setListaVeiculos(listaVeiculos);
    }

    // getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    // metodos

    public boolean addVeiculo(Veiculo veiculo) {
        return getListaVeiculos().add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return getListaVeiculos().remove(veiculo);
    }

}
