public class Hangar {
    private int id;
    private String local;
         
    public Hangar (int id,String local) {
        this.id = id;
        this.local = local;   
    }
        
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getlocal() {
        return local;
    }
    public void setlocal(String local) { 
        this.local = local;
    }
}