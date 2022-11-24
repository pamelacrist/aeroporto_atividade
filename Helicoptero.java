public class Helicoptero extends Voo {
    private String cor;
    private int capacidade;
    private Helicoptero helicoptero;
        
    public Helicoptero (String cor,int capacidade) {
        super(Getid.getNextId(helicopteros),nome,locacao);
        this.cor = cor;
        this.capacidade = capacidade;
        
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
}