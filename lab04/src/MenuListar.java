public enum MenuListar {

    VOLTAR(0),
    LISTAR_CLIENTE(1),
    LISTAR_SINISTROS_SEGURADORA(2),
    LISTAR_SINISTROS_CLIENTE(3),
    LISTAR_VEICULO_CLIENTE(4),
    LISTAR_VEICULO_SEGURADORA(5);

    public final int operacao;

    MenuListar(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }
}
