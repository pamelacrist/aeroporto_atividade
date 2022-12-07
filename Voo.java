import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

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

    protected Voo (String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao) {
      
        this.numero = numero;
        this.data = data;
        this.hora = hora; 
        this.origem = origem; 
        this.destino = destino; 
        this.piloto = piloto;    
        this.copiloto = copiloto; 
        this.observacao = observacao;
        try{
            PreparedStatement insert = DAO.createConnection().prepareStatement(
                "INSERT INTO jato (numero, data, hora, origem, destino,piloto,copiloto,observacao) VALUES (?, ?, ?, ?, ?,?,?,?);"
            );
            insert.setString(1, this.getnumero());
            insert.setString(2, this.getdata());
            insert.setString(3, this.gethora());
            insert.setString(4, this.getorigem());
            insert.setString(5, this.getdestino());
            insert.setString(6, this.getpiloto());
            insert.setString(7, this.getcopiloto());
            insert.setString(8, this.getobservacao());
            insert.execute();
            DAO.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

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
        throw new Exception("Erro, Voo Não Encontrado");
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
     
        
    public static Voo getById(int id)  {
        try {
            Voo voo = null;
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM voo where id="+id+";"
            );

            while(select.next()){
                voo = new Voo(
                    select.getInt("id"), 
                    select.getString("numero"), 
                    select.getString("data"), 
                    select.getString("hora"), 
                    select.getString("origem"), 
                    select.getString("destino"), 
                    select.getString("piloto"), 
                    select.getString("copiloto"), 
                    select.getString("observacao")
                );
                return voo;
            }
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }


    public static ArrayList<Voo> getAll()  {
        try {
            ArrayList<Voo> voos = new ArrayList<>();
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM voo;"
            );
            while(select.next()){
                Voo voo = new Voo(
                    select.getInt("id"), 
                    select.getString("numero"), 
                    select.getString("data"), 
                    select.getString("hora"), 
                    select.getString("origem"), 
                    select.getString("destino"), 
                    select.getString("piloto"), 
                    select.getString("copiloto"), 
                    select.getString("observacao")
                );
                voos.add(voo);
            }
            return voos;
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public  boolean atualizar(Scanner scanner){
        try{

            PreparedStatement update = DAO.createConnection().prepareStatement(
                "UPDATE INTO voo (numero,data,hora,origem,destino,piloto,copiloto,observacao) VALUES (?,?,?,?,?,?,?,?) where id = ?;"
            );
            
            update.setString(1, this.getnumero());
            update.setString(2, this.getdata());
            update.setString(3, this.gethora());
            update.setString(4, this.getorigem());
            update.setString(5, this.getdestino());
            update.setString(6, this.getpiloto());
            update.setString(7, this.getcopiloto());
            update.setString(8, this.getobservacao());
            update.setInt(9, this.getid());
            update.execute();
            DAO.closeConnection();
            return true; 
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean remove(Scanner scanner){
        try {
            System.out.println("Digite o Id:");
            int id = scanner.nextInt();
            PreparedStatement stmt = DAO.createConnection().prepareStatement(
                "DELETE FROM voo WHERE id = ?;"
            );
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possivel remover");
            return false;
            // TODO: handle exception
        }
       
    }
}
