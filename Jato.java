import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Jato extends Aeromodelo {

    private String cor;
    private int velocidade;

    public Jato(String marca,String modelo,String nome,String cor, int velocidade) {
        super(marca,modelo,nome);
        this.cor = cor;
        this.velocidade = velocidade;
    }
     
    public Jato(int id,String marca, String modelo, String nome,String cor, int velocidade) {
        super(id,marca,modelo,nome);
        this.cor = cor;
        this.velocidade = velocidade;
    }

    public String getcor() {
        return cor;
    }

    public void setcor(String cor) {
        this.cor = cor;
    }

    public int getvelocidade() {
        return velocidade;
    }

    public void setvelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public static Jato getJato(int id) throws Exception {
        throw new Exception("Jato não encontrado");
    }

    public static void removeJato(int id) throws Exception {
       // Jato Jato = getJato(id);
    }

    @Override
    public String toString() {
        return super.toString()
                + "cor=" + cor + "\n"
                + "velocidade=" + velocidade + "\n";
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
                "UPDATE INTO jato (marca, modelo, nome,cor,velocidade) VALUES (?, ?, ?) where id = ?;"
            );
            update.setString(1, this.getMarca());
            update.setString(2, this.getModelo());
            update.setInt(3, this.getvelocidade());
            update.setString(4, this.getcor());
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
