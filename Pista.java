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
}