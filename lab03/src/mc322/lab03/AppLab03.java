package mc322.lab03;

public class AppLab03 {

    public static void main(String[] args) {
        String b = "080403MCMVM";
        Animacao a = new Animacao(b);
        a.apresenta();
        for(int i = 0; i < 5; i++) {
            a.passo();
            a.apresenta();
        }
    }
}