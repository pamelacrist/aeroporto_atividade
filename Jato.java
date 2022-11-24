public class Jato extends Voo {
    private String cor;
    private int velocidade;
        
    public Jato (String cor,int velocidade) {
        super(velocidade, cor, cor, cor, cor, cor, cor, cor, cor)
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
}