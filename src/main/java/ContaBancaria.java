public class ContaBancaria {
   private double saldo;
    private RegraMovimentacao regraMovimentacao;

    public ContaBancaria(double saldo, RegraMovimentacao regraMovimentacao) {
        this.saldo = saldo;
        this.regraMovimentacao = new RegraMovimentacao();
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        if (regraMovimentacao.podeRealizarMovimentacao()) {
            saldo += valor;
            regraMovimentacao.registrarMovimentacao();
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (regraMovimentacao.podeRealizarMovimentacao() && saldo >= valor) {
            saldo -= valor;
            regraMovimentacao.registrarMovimentacao();
            return true;
        }
        return false;
    }
}
