public class Carro {
    private Boolean isLigado = false;
    private int marcha = 0;
    private int velocidade = 0;

    public void ligarCarro() {
        if(!this.isLigado) {
            this.isLigado = true;
            System.out.println("Carro ligado.");
            return;
        }
        System.out.println("Não foi possível ligar: carro já ligado.");
    }

    public void desligarCarro() {
        if (this.marcha != 0) {
            System.out.println("Não foi possível desligar: marcha diferente de zero.");
            return;
        }
        if (this.velocidade > 0) {
            System.out.println("Não foi possível desligar: velocidade diferente de zero.");
            return;
        }
        if (!this.isLigado) {
            System.out.println("Não foi possível desligar: carro já desligado.");
            return;
        }
        if(isLigado) {
            this.isLigado = false;
            System.out.println("Carro desligado.");
            return;
        }
    }

    public void acelerar() {
        int maxVel = marcha*20;
        if (this.velocidade < maxVel) {
            this.velocidade++;
            System.out.println("Velocidade aumentada.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Não foi possível acelerar: marcha na posicao morta.");
            return;
        }
        System.out.println("Não foi possível acelerar: velocidade maior que permitido pela marcha.");

    }

    public void diminuirVelocidade() {
        if (this.velocidade > 0) {
            this.velocidade--;
            System.out.println("Velocidade diminuida.");
            return;
        }
        System.out.println("Não foi possível diminuir: velocidade igual a zero.");
    }

    public void virar(String direcao) {
        if(this.velocidade > 1 && this.velocidade <= 40) {
            System.out.printf("Virando para %s\n", direcao);
            return;
        }
        if (this.velocidade == 0) {
            System.out.println("Não foi possível virar: velocidade igual a zero.");
        }
        else {
            System.out.println("Não foi possível virar: velocidade maior que 40.");
        }
    }

    public void verificarVelocidade() {
        System.out.printf("Velocidade atual: %s kmph\n", this.velocidade);
        return;
    }
    public void trocarMarcha(int marcha) {
        if(marcha >= 0 && marcha <= 6) {
            this.marcha = marcha;
            System.out.printf("Marcha trocada para %s\n", this.marcha);
            return;
        }
        System.out.println("Não foi trocar a marcha: marcha inválida");
    }

}