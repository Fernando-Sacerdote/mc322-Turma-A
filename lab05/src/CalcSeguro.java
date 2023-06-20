public enum CalcSeguro {
    VALOR_BASE_PF(10.0),
    VALOR_BASE_PJ(10.0),
    FATOR_30(1.25),
    FATOR_30_60(1.0),
    FATOR_60(1.5);

    public final double valor;

    CalcSeguro(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}