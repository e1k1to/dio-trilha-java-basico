import java.util.Scanner;

public class ContaTerminal {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numero da sua conta:");
        int numero = scanner.nextInt();
        
        System.out.println("Digite o numero da sua agencia (xxx-x):");
        String agencia = scanner.next();
        
        System.out.println("Digite seu nome:");
        String nomeCliente = scanner.next();
        
        System.out.println("Digite seu Saldo:");
        double saldo = scanner.nextDouble();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo %s já está disponível para saque\n", nomeCliente, agencia, numero, saldo);
        scanner.close();
    }
}
