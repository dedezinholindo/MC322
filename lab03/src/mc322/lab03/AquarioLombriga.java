package mc322.lab03;

public class AquarioLombriga {
    int tamLombriga, tamAquario, posCabeca;
    int direcao; //direcao da cabeca da lombriga direta(1) e esquerda(0)
    int posicao; //primeira posicao da lombriga contada da esquerda para direita
    AquarioLombriga(int tamAquario, int tamLombriga, int posicao){
        this.direcao = 1;
        this.tamLombriga = tamLombriga;
        if (tamLombriga > tamAquario)
        {
            this.tamAquario = tamLombriga;
            System.out.println("[ERROR] O tamanho do aquário é menor do que a lombriga. Tamanho ajustado para " + this.tamLombriga);
        }
        this.tamAquario = tamAquario;
        if (this.tamAquario - (posicao - 1) >= this.tamLombriga){
            this.posicao = posicao - 1; //posicao ajustada para encaixar com o vetor
        } else {
            this.posicao = 0;
            System.out.println("[ERROR] A lombriga não cabe na posição solicitada. Ela foi posicionada na posição 1.");
        }
        this.posCabeca = (this.posicao + this.tamLombriga) - 1;
    }

    public void crescer(){
        if (this.direcao == 1 && (this.posicao - 1 >= 0)){
            this.tamLombriga += 1;
            this.posicao -= 1;
        } else if (this.direcao == 0 && (this.posicao + 1) < this.tamAquario){
            this.tamLombriga += 1;
        }
    }

    public void virar(){
        if (this.direcao == 0){
            this.direcao = 1;
            this.posCabeca = this.posCabeca + (this.tamLombriga - 1);
        } else {
            this.direcao = 0;
            this.posCabeca = this.posCabeca - (this.tamLombriga - 1);
        }
    }

    public void mover(){
        if (this.direcao == 0 && (this.posicao - 1 >= 0)){
            this.posicao -= 1;
            this.posCabeca -= 1;
        } else if (this.direcao == 1 && (this.posicao + this.tamLombriga) < this.tamAquario){
            this.posicao += 1;
            this.posCabeca += 1;
        } else {
            this.virar();
        }
    }

    public void apresenta(){
        if (this.direcao == 0){
            for (int i = 0; i < this.tamAquario; i++){
                if (i == this.posCabeca){
                    System.out.print("0");
                } else if (i > this.posCabeca && i < this.posCabeca + this.tamLombriga){
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
            }
        } else {
            for (int i = 0; i < this.tamAquario; i++){
                if (i == this.posCabeca){
                    System.out.print("0");
                } else if (i < this.posCabeca && i > this.posCabeca - this.tamLombriga){
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
            }
        }
        System.out.println();
    }
}
