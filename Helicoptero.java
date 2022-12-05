
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Helicoptero extends Aeromodelo {
    private String cor;
    private int capacidade;

    public Helicoptero(String cor, int capacidade, String nome ,String marca , String modelo) {
        super( marca, modelo, nome);
        this.cor = cor;
        this.capacidade = capacidade;
        try{
        PreparedStatement insert = DAO.createConnection().prepareStatement(
            "INSERT INTO helicoptero (marca, modelo, capacidade) VALUES (?, ?, ?);"
        );
        insert.setString(1, this.getMarca());
        insert.setString(2, this.getModelo());
        insert.setInt(3, this.getCapacidade());
        insert.execute();
        DAO.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Helicoptero(int id, String cor, int capacidade, String nome, String modelo, String marca) {
        super(id, marca, nome, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return super.toString()
                + "capacidade=" + capacidade + "\n"
                + "cor=" + cor + "\n";
    }

    public static Helicoptero getById(int id)  {
        try {
            Helicoptero helicoptero = null;
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM helicoptero where id="+id+";"
            );
            while(select.next()){
                helicoptero = new Helicoptero(
                    select.getInt("id"), 
                    select.getString("cor"),
                    select.getInt("capacidade"),
                    select.getString("nome"),
                    select.getString("modelo"),
                    select.getString("marca")
                );
                return helicoptero;
            }
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }


    public static ArrayList<Helicoptero> getAll()  {
        try {
            ArrayList<Helicoptero> helicopteros = new ArrayList<>();
            ResultSet select = DAO.createConnection().createStatement().executeQuery(
                "SELECT * FROM helicoptero;"
            );
            while(select.next()){
                Helicoptero helicoptero = new Helicoptero(
                    select.getInt("id"), 
                    select.getString("cor"),
                    select.getInt("capacidade"),
                    select.getString("nome"),
                    select.getString("modelo"),
                    select.getString("marca")
                );
                helicopteros.add(helicoptero);
            }
            return helicopteros;
        }
        catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public  boolean atualizar(Scanner scanner){
        try{

            PreparedStatement update = DAO.createConnection().prepareStatement(
                "UPDATE INTO helicoptero (marca, modelo, capacidade) VALUES (?, ?, ?) where id = ?;"
            );
            update.setString(1, this.getMarca());
            update.setString(2, this.getModelo());
            update.setInt(3, this.getCapacidade());
            update.setInt(4, this.getid());
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
                "DELETE FROM helicoptero WHERE id = ?;"
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
