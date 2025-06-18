import java.util.Scanner;

public class App {

    static private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        IPhone iphone = new IPhone("15 Plus", "Azul");

        System.out.println("\n\nSeu celular tem o modelo " + iphone.getModelo() + " da cor " + iphone.getCor()+"\n\n");

        int escolha = 0;
        while(escolha != 5) {
            System.out.println("Digite o comando requisitado:\n1- SMS\n2- Musica\n3- Telefone\n4- Navegador\n5- Sair");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    acessarSMS(iphone);
                    break;
                case 2:
                    acessarMusicas(iphone);
                    break;
                case 3:
                    acessarTelefone(iphone);
                    break;
                case 4:
                    acessarNavegador(iphone);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Escolha invalida, tente novamente.");
                    break;
            }

        }
        scanner.close();
    }
    static void acessarSMS(IPhone celular) {
        System.out.println("App SMS acessado");
        int escolha2 = 0;
        String mensagemUsuario;
        while (escolha2 != 4) {
            System.out.println("Digite o comando desejado: \n1- Enviar mensagem SMS\n2- Ler mensagem SMS\n3- Apagar mensagem SMS\n4- Sair");
            escolha2 = scanner.nextInt();
            scanner.nextLine();
            switch (escolha2) {
                case 1:
                    System.out.println("Digite a mensagem que vai enviar:");
                    mensagemUsuario = scanner.nextLine();
                    celular.enviarMensagem(mensagemUsuario);
                    break;
                case 2:
                    celular.lerMensagem();
                    break;
                case 3:
                    celular.apagarMensagem();
                    break;
                case 4:
                    System.out.println("Saindo do App.");
                    break;
            
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        }
    };

    static void acessarMusicas(IPhone celular) {
        int escolha2 = 0;
        System.out.println("App Musicas acessado");
        String nomeMusica;
        while (escolha2 != 4) {
            System.out.println("Digite o comando desejado: \n1- Tocar a musica escolhida\n2- Pausar musica\n3- Selecionar musica\n4- Sair");
            escolha2 = scanner.nextInt();
            scanner.nextLine();
            
            switch (escolha2) {
                case 1:
                    celular.tocar();
                    break;
                case 2:
                    celular.pausar();
                    break;
                case 3:
                    System.out.println("Digite o nome da musica para ouvir:");
                    nomeMusica = scanner.nextLine();
                    celular.selecionarMusica(nomeMusica);
                    break;
                case 4:
                    System.out.println("Saindo do App.");
                    break;
            
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        }
    };

    static void acessarTelefone(IPhone celular) {
        int escolha2 = 0;
        String numTelefone;
        System.out.println("App Telefone acessado");
        while (escolha2 != 4) {
            System.out.println("Digite o comando desejado: \n1- Ligar para alguem \n2- Atender ligacao\n3- Iniciar Correio de voz\n4- Sair");
            escolha2 = scanner.nextInt();
            scanner.nextLine();
            
            switch (escolha2) {
                case 1:
                    System.out.println("Digite o numero que gostaria de ligar:");
                    numTelefone = scanner.nextLine();
                    celular.ligar(numTelefone);
                    break;
                case 2:
                    celular.atender();
                    break;
                case 3:
                    celular.iniciarCorreioVoz();
                    break;
                case 4:
                    System.out.println("Saindo do App.");
                    break;
            
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        }
    };

    static void acessarNavegador(IPhone celular) {
        int escolha2 = 0;
        String url_usuario;
        System.out.println("App Navegador acessado");
        while (escolha2 != 4) {
            System.out.println("Digite o comando desejado: \n1- Exibir Pagina\n2- Adicionar Aba\n3- Atualizar Pagina\n4- Sair");
            escolha2 = scanner.nextInt();
            scanner.nextLine();
            switch (escolha2) {
                case 1:
                    System.out.println("Digite a URL que gostaria de acessar:");
                    url_usuario = scanner.nextLine();
                    celular.exibirPagina(url_usuario);
                    break;
                case 2:
                    celular.adicionarNovaAba();
                    break;
                case 3:
                    celular.atualizarPagina();
                    break;
                case 4:
                    System.out.println("Saindo do App.");
                    break;
            
                default:
                    System.out.println("Comando invalido");
                    break;
            }

        }
    };


}
