public class Gerente extends Funcionario{

    public Gerente(String name, String email, String senha) {
        super(name, email, senha);
        this.ehAdmin = true;
        
    }
    // relatorio, consultavendas
}
