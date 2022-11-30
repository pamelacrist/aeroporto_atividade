import java.util.ArrayList;

public class Aviao extends Aeromodelo {

    private String prefixo;
    private int capacidade;

    public Aviao(String prefixo, int capacidade, String nome, String locacao ,ArrayList<Helicoptero>  helicopteros) {
        super(GetId.getNextId(helicopteros), nome, locacao);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
    }

    public String getprefixo() {
        return prefixo;
    }

    public void setprefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getcapacidade() {
        return capacidade;
    }

    public void setcapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public static ArrayList<Aviao> getAviao() {
        return null;//Aviao;
    }

    public static Aviao getAviao(int id) throws Exception {
        throw new Exception("Carros não encontrado");
    }

    public static void removeAviao(int id) throws Exception {
        Aviao Aviao = getAviao(id);
    }

    @Override
    public String toString() {
        return super.toString()
         + "prefixo=" + prefixo + "\n"
                + "capacidade=" + capacidade + "\n";
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return 0;
    }
}
