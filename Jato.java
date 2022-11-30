
public class Jato extends Aeromodelo {

    private String cor;
    private int velocidade;

    public Jato(String cor, int velocidade) {

        this.cor = cor;
        this.velocidade = velocidade;

    }

    public String getcor() {
        return cor;
    }

    public void setcor(String cor) {
        this.cor = cor;
    }

    public int getvelocidade() {
        return velocidade;
    }

    public void setvelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public static Jato getJato(int id) throws Exception {
        for (Jato Jato : Jatos) {
            if (Jato.getId() == id) {
                return Jato;
            }
        }
        throw new Exception("Jato não encontrado");
    }

    public static void removeJato(int id) throws Exception {
        Jato Jato = getJato(id);
        Jato.remove(Jato);
    }

    @Override
    public String toString() {
        return super.toString()
                + "cor=" + cor + "\n"
                + "velocidade=" + velocidade + "\n";
    }
}
