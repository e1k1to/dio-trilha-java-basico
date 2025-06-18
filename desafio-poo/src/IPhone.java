public class IPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet, CorreioSMS {

    private String modelo;
    private String cor;

    public IPhone(String modelo, String cor) {
        this.modelo = modelo;
        this.cor = cor;
    }


    public String getModelo() {
        return this.modelo;
    }

    public String getCor() {
        return this.cor;
    }


    @Override
    public void tocar() {
        System.out.println("\nO Telefone esta tocando musica!\n");
    }

    @Override
    public void pausar() {
        System.out.println("\nA musica foi pausada\n");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("\nA musica "+ musica +" foi selecionada.\n");
    }

    @Override
    public void ligar(String numero) {
        System.out.println("\nRealizando ligacao para "+ numero+"\n");
    }

    @Override
    public void atender() {
        System.out.println("\nO Telefonema foi atendido.\n");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("\nCorreio de voz iniciado.\n");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("\nExibindo pagina de url "+url+"\n");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("\nCriando aba nova.\n");
    }
    @Override
    public void atualizarPagina() {
        System.out.println("\nAtualizando pagina atual.\n");
    }
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("\nMensagem \"" + mensagem + "\" enviada.\n");    
    }
    @Override
    public void lerMensagem() {
        System.out.println("\nAcessando mensagem recebida.\n");
    }
    @Override
    public void apagarMensagem() {
        System.out.println("\nMensagem apagada com sucesso.\n");
    }
}
