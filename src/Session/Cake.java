package Session;

public class Cake {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    public Cake() {}
    public Cake(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
