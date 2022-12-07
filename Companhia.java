import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Companhia {
    private int id;
    private String nome;
    private String cnpj;
         
    public Companhia(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        try{
        PreparedStatement insert = DAO.createConnection().prepareStatement(
            "INSERT INTO companhia (nome,cnpj) VALUES (?,?);"
        );
        insert.setString(1, this.getnome());
        insert.setString(12, this.getcnpj());
        insert.execute();
        DAO.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
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
        throw new Exception("Erro, Companhia Não Encontrado");
    }

    @Override
    public String toString() {
        return super.toString() 
        + "id=" + id + "\n"
        + "nome=" + nome + "\n"
        + "cnpj=" + cnpj + "\n";   
     }
     
     
    public static Companhia getById(int id)  {
        try {
            Companhia companhia = null;
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM companhia where id="+id+";"
            );
            while(select.next()){
                companhia = new Companhia(
                    select.getInt("id"), 
                    select.getString("nome"),
                    select.getString("cnpj")
                );
                return companhia;
            }
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }


    public static ArrayList<Companhia> getAll()  {
        try {
            ArrayList<Companhia> companhias = new ArrayList<>();
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM companhia;"
            );
            while(select.next()){
                Companhia companhia = new Companhia(
                    select.getInt("id"), 
                    select.getString("nome"),
                    select.getString("cnpj")
                );
                companhias.add(companhia);
            }
            return companhias;
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public  boolean atualizar(Scanner scanner){
        try{

            PreparedStatement update = DAO.createConnection().prepareStatement(
                "UPDATE INTO companhia (nome, cnpj) VALUES (?, ?) where id = ?;"
            );
            update.setString(1, this.getnome());
            update.setString(2, this.getcnpj());
            update.setInt(3, this.getid());
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
                "DELETE FROM companhia WHERE id = ?;"
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