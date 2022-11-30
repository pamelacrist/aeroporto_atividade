
public class Hangar {

    private int id;
    private String local;

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

    public static void removeHangar(int id) throws Exception {
        //Hangar hangar = getHangar(id);

    }

    @Override
    public String toString() {
        return super.toString()
                + "id=" + id + "\n"
                + "local=" + local + "\n";
    }
}
