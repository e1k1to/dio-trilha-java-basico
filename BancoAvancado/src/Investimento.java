public class Investimento implements IInvestimento{

    String nomeInvest;
    double lucroPMes;
    double totalInvestido;

    public Investimento(String nomeInvest, double lucroPMes) {
        this.nomeInvest = nomeInvest;
        this.lucroPMes = lucroPMes;
    }

    public void passaMes() {
        totalInvestido = totalInvestido*lucroPMes;
    }

    @Override
    public void aplicarInvestimento(double valor) {
        totalInvestido += valor;

    }

    @Override
    public void consultarInvestimento() {
        System.out.printf("\nTotal Investido na acao %s: %s\n", nomeInvest, totalInvestido);
    }

    @Override
    public double verificarValorInvestido() {
        return totalInvestido;
    }


    @Override
    public void sacarInvestimentos(double valor) {
        totalInvestido -= valor;
    }

}
