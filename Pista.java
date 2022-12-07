import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Pista {
    private int id;
    private String numero;

    public Pista(String numero) {
        this.numero = numero;
        try{
        PreparedStatement insert = DAO.createConnection().prepareStatement(
            "INSERT INTO pista (numero) VALUES (?);"
        );
        insert.setString(1, this.getnumero());
        insert.execute();
        DAO.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
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

  
    @Override
    public String toString() {
        return super.toString() 
        + "id=" + id + "\n"
        + "numero=" + numero + "\n";
     }  

      
    public static Pista getById(int id)  {
        try {
            Pista pista = null;
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM pista where id="+id+";"
            );
            while(select.next()){
                pista = new Pista(
                    select.getInt("id"), 
                    select.getString("numero")
                );
                return pista;
            }
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }


    public static ArrayList<Pista> getAll()  {
        try {
            ArrayList<Pista> pistas = new ArrayList<>();
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM pista;"
            );
            while(select.next()){
                Pista pista = new Pista(
                    select.getInt("id"), 
                    select.getString("numero")
                );
                pistas.add(pista);
            }
            return pistas;
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public  boolean atualizar(Scanner scanner){
        try{

            PreparedStatement update = DAO.createConnection().prepareStatement(
                "UPDATE INTO pista (numero) VALUES (?) where id = ?;"
            );
            update.setString(1, this.getnumero());
            update.setInt(2, this.getid());
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
                "DELETE FROM pista WHERE id = ?;"
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