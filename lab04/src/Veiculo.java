public class Veiculo {
    // declaraçao dos atributos da classe
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    // construtor
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        setAnoFabricacao(anoFabricacao);
    }

    // declaraçao dos metodos
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    // metodos

    public String toString() {
        String retorno;
        retorno = "----- VEICULO -----\n" + "placa: " + getPlaca() + "\n" + "marca: " + getMarca() + "\n" + "modelo: "
                + getModelo() + "\n" + "ano de fabricacao: " + getAnoFabricacao() + "\n";
        return retorno;
    }
}
