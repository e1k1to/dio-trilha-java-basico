public class Vendedor extends Funcionario {
    private int qtdeVendas;

    public Vendedor(String nome, String email, String senha, int qtdeVendas) {
        super(nome, email, senha);
        this.qtdeVendas = qtdeVendas;
    }

    //realizar evnda, consultar vendas'

}
