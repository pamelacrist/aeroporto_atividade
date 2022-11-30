
public class Aviao extends Aeromodelo {
    private String prefixo;
    private int capacidade;
    

         
    public Aviao (String prefixo,int capacidade) {
    
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        
        avioes.add(this);
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
        return Aviao;
    }
    public static Aviao getAviao(int id) throws Exception {
        for (Aviao Aviao : Avioes) {
            if (Aviao.getId() == id) {
                return Aviao;
            }
        }
        throw new Exception("Carros não encontrado");
    }

    public static void removeAviao(int id) throws Exception {
        Aviao Aviao = getAviao(id);
        avioes.remove(Aviao);
    }
    @Override
    public String toString() {
        return super.toString() 
        + "prefixo=" + prefixo + "\n"
        + "capacidade=" + capacidade + "\n";    
     }  
}