public class Companhia {
    private int id;
    private String nome;
    private String cnpj;
         
    public Companhia (int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome; 
        this.cnpj = cnpj;  
    }
        
    public int getid() {
        return id;
    }
    public void setprefixo(int id) {
        this.id = id;
    }
    public String getnome() {
        return nome;
    }
    public void setnome(String nome) { 
        this.nome = nome;
    }
    public String getcnpj() {
        return cnpj;
    }
    public void setcnpj(String cnpj) { 
        this.cnpj = cnpj;
    }
    public static Companhia getCompanhia(int id) throws Exception {
        for (Companhia Companhia : Companhias) {
            if (Jato.getId() == id) {
                return Companhia;
            }
        }
        throw new Exception("Erro, Companhia Não Encontrado");
    }

    public static void removeCompanhia(int id) throws Exception {
        Companhia Companhia = getCompanhia(id);
        Jato.remove(Companhia);
    }
    @Override
    public String toString() {
        return super.toString() 
        + "id=" + id + "\n"
        + "nome=" + nome + "\n"
        + "cnpj=" + cnpj + "\n";   
     }  
}