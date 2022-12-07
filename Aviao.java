import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Aviao extends Aeromodelo {

    private String prefixo;
    private int capacidade;


    public Aviao(String marca, String modelo, String nome,String prefixo, int capacidade) {
        super(marca,modelo,nome);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        try{
            PreparedStatement insert = DAO.createConnection().prepareStatement(
                "INSERT INTO aviao (marca, modelo, nome, prefixo, capacidade) VALUES (?, ?, ?, ?, ?);"
            );
            insert.setString(1, this.getMarca());
            insert.setString(2, this.getModelo());
            insert.setString(3, this.getNome());
            insert.setString(4, this.getprefixo());
            insert.setInt(5, this.getcapacidade());
            insert.execute();
            DAO.closeConnection();
            } catch (Exception e) {
                System.out.println(e);
            }
    }

    
    public Aviao(int id,String marca, String modelo, String nome,String prefixo, int capacidade) {
        super(id,marca,modelo,nome);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
    }

    public String getprefixo() {
        return prefixo;
    }

    public void setprefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getcapacidade() {
        return capacidade;
    }

    public void setcapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public static ArrayList<Aviao> getAviao() {
        return null;//Aviao;
    }

    public static Aviao getAviao(int id) throws Exception {
        throw new Exception("Carros não encontrado");
    }

    public static void removeAviao(int id) throws Exception {
       // Aviao Aviao = getAviao(id);
    }

    @Override
    public String toString() {
        return super.toString()
         + "prefixo=" + prefixo + "\n"
                + "capacidade=" + capacidade + "\n";
    }

    public static Aviao getById(int id)  {
        try {
            Aviao aviao = null;
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM aviao where id="+id+";"
            );
            while(select.next()){
                aviao = new Aviao(
                    select.getInt("id"), 
                    select.getString("marca"),
                    select.getString("modelo"),
                    select.getString("nome"),
                    select.getString("prefixo"),
                    select.getInt("capacidade")
                );
                return aviao;
            }
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }


    public static ArrayList<Aviao> getAll()  {
        try {
            ArrayList<Aviao> aviaos = new ArrayList<>();
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM aviao;"
            );
            while(select.next()){
                Aviao aviao = new Aviao(
                    select.getInt("id"), 
                    select.getString("marca"),
                    select.getString("modelo"),
                    select.getString("nome"),
                    select.getString("prefixo"),
                    select.getInt("capacidade")
                );
                aviaos.add(aviao);
            }
            return aviaos;
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public  boolean atualizar(Scanner scanner){
        try{

            PreparedStatement update = DAO.createConnection().prepareStatement(
                "UPDATE INTO aviao (marca, modelo, prefixo,capacidade) VALUES (?, ?, ?, ?) where id = ?;"
            );
            update.setString(1, this.getMarca());
            update.setString(2, this.getModelo());
            update.setString(3, this.getprefixo());
            update.setInt(4, this.getcapacidade());
            update.setInt(5, this.getid());
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
                "DELETE FROM aviao WHERE id = ?;"
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
