import model.*;
import static util.BoardTemplate.BOARD_TEMPLATE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class App {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) throws Exception {
        final var positions = Stream.of(args)
                .collect(toMap(
                    k -> k.split(";")[0],
                    v -> v.split(";")[1]
                ));

        var option = -1;
        while(true) {
            System.out.println("Selecione uma das opcoes a seguir");
            System.out.println("1 - Iniciar um novo jogo");
            System.out.println("2 - Colocar um novo numero");
            System.out.println("3 - Remover um numero");
            System.out.println("4 - Verificar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opcao invalida.");
            }
            
        }

    }

    private static void startGame(Map<String, String> positions) {
        if(nonNull(board)) {
            System.out.println("Jogo ja iniciado.");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for(int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for(int j = 0; j < BOARD_LIMIT; j++) {

                String positionConfig = positions.get("%s,%s".formatted(i, j));

                int expected = Integer.parseInt(positionConfig.split(",")[0]);
                Boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);

                Space currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("Jogo pronto para comecar");
    }

    private static void inputNumber() {
        if(isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado.");
            return;
        }

        System.out.println("Informe a coluna em que o numero sera inserido");
        int col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o numero sera inserido");
        int row = runUntilGetValidNumber(0, 8);
        System.out.printf("Informe o numero que vai entrar na posicao [%s, %s]\n", col, row);
        int value = runUntilGetValidNumber(1, 9);
        if(!board.changeValue(col, row, value)) {
            System.out.printf("Posicao [%s,%s] tem um valor fixo\n", col, row);
            return;
        }
        System.out.printf("Posicao [%s,%s] preenchida com %s\n", col, row, value);


    }

    private static void removeNumber() {
        if(isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado.");
            return;
        }

        System.out.println("Informe a coluna em que o numero sera removido");
        int col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o numero sera removido");
        int row = runUntilGetValidNumber(0, 8);
        if(!board.clearValue(col, row)) {
            System.out.printf("Posicao [%s,%s] tem um valor fixo\n", col, row);
            return;
        }
        System.out.printf("Posicao [%s,%s] esvaziada\n", col, row);

    }

    private static void showCurrentGame() {
        if(isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado.");
            return;
        }

        var args = new Object[81];
        int argPos = 0;

        for(int i = 0; i < BOARD_LIMIT; i++) {
            for(var col: board.getSpaces()) {
                args[argPos++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("Seu jogo:");
        System.out.println(BOARD_TEMPLATE.formatted(args));

    }

    private static void showGameStatus() {
        if(isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado.");
            return;
        }
        System.out.printf("Seu jogo atualmente se encontra no status %s\n",board.getStatus().getLabel());
        if(board.hasErrors()) {
            System.out.println("Jogo contem erros");
        }
        else {
            System.out.println("Jogo nao contem erros");
        }
    }

    private static void clearGame() {
        if(isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado.");
            return;
        }

        System.out.println("Tem certeza que deseja limpar o jogo?");
        String confirm = scanner.next();
        while(!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("nao")) {
            System.out.println("Informe (sim/nao)");
            confirm = scanner.next();
        }
        if(confirm.equalsIgnoreCase("sim")) {
            board.reset();
        }

    }

    private static void finishGame() {
        if(isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado.");
            return;
        }

        if(board.gameIsFinished()) {
            System.out.println("Parabens, voce concluiu o jogo.");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Jogo contem erros");
        }
        else {
            System.out.println("Existem campos vazios");
        }
    }

    private static int runUntilGetValidNumber(final int min, final int max) {
        var current = scanner.nextInt();
        while(current < min || current > max) {
            System.out.printf("Informe numero entre %s e %s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }

}
