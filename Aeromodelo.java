
public abstract class Aeromodelo{

    private int id;
    private String marca;
    private String nome;
    private String modelo;

    public Aeromodelo( String marca, String modelo, String nome) {
        this.marca = marca;
        this.modelo = modelo;
        this.nome = nome;
    }

    public Aeromodelo(int id, String marca, String modelo, String nome) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
