import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Carro carro = new Carro();
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        
        while (escolha != 0) {
            System.out.println("\n" + //
                                "    1- Ligar o carro;\n" + //
                                "    2- Desligar o carro;\n" + //
                                "    3- Acelerar;\n" + //
                                "    4- diminuir velocidade;\n" + //
                                "    5- virar para esquerda/direita\n" + //
                                "    6- verificar velocidade;\n" + //
                                "    7- trocar a marcha\n" + //
                                "");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 0:
                    break;
                case 1:
                    carro.ligarCarro();
                    break;
                case 2:
                    carro.desligarCarro();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.diminuirVelocidade();
                    break;
                case 5:
                    System.out.println("Em qual direcao deseja virar? (esquerda, direita)");
                    String direcao = scanner.next();
                    carro.virar(direcao);
                    break;
                case 6:
                    carro.verificarVelocidade();
                    break;
                case 7:
                    System.out.println("Qual marcha deseja selecionar? (0-6)");
                    int marchaNova = scanner.nextInt();
                    carro.trocarMarcha(marchaNova);
                    break;
            
                default:
                    System.out.println("Escolha invalida.");
                    break;
            }
        }
        scanner.close();
    }
}
