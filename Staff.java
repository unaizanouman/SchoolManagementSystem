import java.io.Serializable;

public class Staff implements Serializable {
    private String name;
    private int id;
    private String position;

    public Staff(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }
}
