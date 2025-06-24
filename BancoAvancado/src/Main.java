public class Main {
    public static void main(String[] args) throws Exception {
        Cliente yuki = new Cliente();
        yuki.setNome("Yuki");

        Investimento google = new Investimento("Google", 1.1);

        Conta cc = new ContaCorrente(yuki);
        Conta poupanca = new ContaPoupanca(yuki);

        cc.depositar(100);
        cc.transferir(50, poupanca);

        cc.investir(50, google);
        
        cc.sacarInvestimento(30, google);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        google.consultarInvestimento();

        cc.sacarInvestimento(10, google);
        
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        google.consultarInvestimento();

    }
}
