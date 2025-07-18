public class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s\n", this.cliente.getNome());
        System.out.printf("Agencia: %d\n", this.agencia);
        System.out.printf("Numero: %d\n", this.numero);
        System.out.printf("Saldo: %.2f\n", this.saldo);
    }

    public void investir(double valor, Investimento invest) {
        if((saldo-valor) < 0) {
            System.out.println("Impossivel investir: Saldo insuficiente.");
            return;
        }
        sacar(valor);
        invest.aplicarInvestimento(valor);
    }

    public void sacarInvestimento(double valor, Investimento invest) {
        if(invest.verificarValorInvestido()-valor < 0) {
            System.out.println("Impossivel sacar: quantidade investida nao eh igual ou maior que requisitado.");
            return;
        }
        invest.sacarInvestimentos(valor);
        depositar(valor);
    }



}
