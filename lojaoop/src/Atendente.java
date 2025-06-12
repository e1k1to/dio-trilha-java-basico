public class Atendente extends Funcionario {
    private float valorCaixa;

    public Atendente(String nome, String email, String senha, float valorCaixa) {
        super(nome, email, senha);
        this.valorCaixa = valorCaixa;
    }

    //receber pagamento, fechar caixa

}
