
import java.util.ArrayList;

public class Helicoptero extends Aeromodelo {

    private String cor;
    private int capacidade;

    public Helicoptero(String cor, int capacidade, String nome, String locacao, ArrayList<Aeromodelo> helicopteros) {
        super(GetId.getNextId(helicopteros), nome, locacao);
        this.cor = cor;
        this.capacidade = capacidade;

        Helicoptero.add(this);
    }

    public String getcor() {
        return cor;
    }

    public void setcor(String cor) {
        this.cor = cor;
    }

    public int getcapacidade() {
        return capacidade;
    }

    public void setcapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public static Helicoptero getCarro(int id) throws Exception {
        for (Helicoptero Helicoptero : Helicopteros) {
            if (Helicoptero.getId() == id) {
                return Helicoptero;
            }
        }
        throw new Exception("Carros não encontrado");
    }

    public static void removeCarro(int id) throws Exception {
        Helicoptero Helicoptero = getHelicoptero(id);
        Helicopteros.remove(Helicoptero);
    }

    @Override
    public String toString() {
        return super.toString()
                + "capacidade=" + capacidade + "\n"
                + "cor=" + cor + "\n";
    }
}
