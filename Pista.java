public class Pista {
    private int id;
    private String numero;

    public Pista (int id, String numero) {
        this.id = id;
        this.numero = numero;  
    }
        
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getnumero() {
        return numero;
    }
    public void setnumero(String numero) { 
        this.numero = numero;
    }
    public static Pista getPista(int id) throws Exception {
        throw new Exception("Erro, Pista Não Encontrado");
    }

    public static void removePista(int id) throws Exception {
        Pista Pista = getPista(id);
    }
    @Override
    public String toString() {
        return super.toString() 
        + "id=" + id + "\n"
        + "numero=" + numero + "\n";
     }  
}