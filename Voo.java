public class Voo {
    private int id;
    private String numero;
    private String data;
    private String hora;
    private String origem;
    private String destino;
    private String piloto;
    private String copiloto;
    private String observacao;

    protected Voo (int id,String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.hora = hora; 
        this.origem = origem; 
        this.destino = destino; 
        this.piloto = piloto;    
        this.copiloto = copiloto; 
        this.observacao = observacao; 
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
    public String getdata() {
        return data;
    }
    public void setdata(String data) {
        this.data = data;
    }
    public String gethora() {
        return hora;
    }
    public void sethora(String hora) {
        this.hora = hora;
    }
    public String getorigem() {
        return origem;
    }
    public void setorigem(String origem) {
        this.origem = origem;
    }
    public String getdestino() {
        return destino;
    }
    public void setdestino(String destino) {
        this.destino = destino;
    }
    public String getpiloto() {
        return piloto;
    }
    public void setpiloto(String piloto) {
        this.piloto = piloto;
    }
    public String getcopiloto() {
        return copiloto;
    }
    public void setcopiloto(String copiloto) {
        this.copiloto = copiloto;
    }
    public String getobservacao() {
        return observacao;
    }
    public void setobservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public static Voo getVoo(int id) throws Exception {
        for (Voo Voo : Voos) {
            if (Voo.getId() == id) {
                return Voo;
            }
        }
        throw new Exception("Erro, Voo Não Encontrado");
    }

    public static void removeVoo(int id) throws Exception {
        Voo Voo = getVoo(id);
        Voo.remove(Voo);
    }
    @Override
    public String toString() {
        return super.toString() 
        + "id=" + id + "\n"
        + "numero=" + numero + "\n"
        + "data=" + data + "\n"
        + "hora=" + hora + "\n"
        + "origem=" + origem + "\n"
        + "destino=" + destino + "\n"
        + "piloto=" + piloto + "\n"
        + "copiloto=" + copiloto + "\n"
        + "observacao=" + observacao + "\n";
     }    
}
