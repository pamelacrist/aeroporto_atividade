import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangar {

    private int id;
    private String local;

    public Hangar(String local) {
        this.local = local;
        try{
        PreparedStatement insert = DAO.createConnection().prepareStatement(
            "INSERT INTO hangar (local) VALUES (?);"
        );
        insert.setString(1, this.getlocal());
        insert.execute();
        DAO.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Hangar(int id, String local) {
        this.id = id;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlocal() {
        return local;
    }

    public void setlocal(String local) {
        this.local = local;
    }

    public static Hangar getHangar(int id) throws Exception {
        //for (Hangar hangar : Hangar) {
        ////    if (hangar.getId() == id) {
        //      return hangar;
        // }
        // }
        throw new Exception("Jato não encontrado");
    }

    @Override
    public String toString() {
        return super.toString()
                + "id=" + id + "\n"
                + "local=" + local + "\n";
    }

    
    public static Hangar getById(int id)  {
        try {
            Hangar hangar = null;
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM hangar where id="+id+";"
            );
            while(select.next()){
                hangar = new Hangar(
                    select.getInt("id"), 
                    select.getString("local")
                );
                return hangar;
            }
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }


    public static ArrayList<Hangar> getAll()  {
        try {
            ArrayList<Hangar> hangars = new ArrayList<>();
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM hangar;"
            );
            while(select.next()){
                Hangar hangar = new Hangar(
                    select.getInt("id"), 
                    select.getString("local")
                );
                hangars.add(hangar);
            }
            return hangars;
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public  boolean atualizar(Scanner scanner){
        try{

            PreparedStatement update = DAO.createConnection().prepareStatement(
                "UPDATE INTO hangar (local) VALUES (?) where id = ?;"
            );
            update.setString(1, this.getlocal());
            update.setInt(2, this.getId());
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
                "DELETE FROM hangar WHERE id = ?;"
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
