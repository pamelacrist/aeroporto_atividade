public abstract class Aeromodelo {
    private int id;
    private String marca;
    private String modelo;


    public Aeromodelo (int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca; 
        this.modelo = modelo; 
    }
        
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getmarca() {
        return marca;
    }
    public void setmarca(String marca) { 
        this.marca = marca;
    }
    public String getmodelo() {
        return modelo;
    }
    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }
    
}
