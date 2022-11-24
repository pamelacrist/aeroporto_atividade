
public class Aviao extends Voo {
    private String prefixo;
    private int capacidade;
         
    public Aviao (String prefixo,int capacidade) {
    
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
}