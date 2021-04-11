package mc322.lab03;

public class Animacao {
    AquarioLombriga lomb;
    int acaoAtual;
    String acoes;
    Animacao(String strAnimacao){
        int tamAquario = Integer.parseInt(strAnimacao.substring(0, 2));
        int tamLombriga = Integer.parseInt(strAnimacao.substring(2,4));
        int posicao = Integer.parseInt(strAnimacao.substring(4,6));
        this.lomb = new AquarioLombriga(tamAquario, tamLombriga, posicao);
        this.acoes = strAnimacao.substring(6);
        this.acaoAtual = 0;
    }

    public void apresenta(){
        (this.lomb).apresenta();
    }

    public void executarAcao(){
        switch ((this.acoes).charAt(this.acaoAtual)){
            case 'C':
                this.lomb.crescer();
                break;
            case 'V':
                this.lomb.virar();
                break;
            case 'M':
                this.lomb.mover();
                break;
            default:
                break;
        }
    }

    public void passo(){
        if (this.acaoAtual < (this.acoes).length()){
            executarAcao();
            this.acaoAtual += 1;
        } else {
            System.out.println("[ERROR] Não há mais ações para a lombriga!");
        }
    }
}

