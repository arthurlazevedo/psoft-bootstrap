import java.util.*;

public class Time {
    private int id;
    private Map<String, Pessoa> devs;
    private Pessoa gerente;
    private List<Sprint> sprints;
    private Produto produto;

    public Time(int id, Produto produto, Pessoa gerente) {
        this.id = id;
        this.produto = produto;
        this.gerente = gerente;
        this.devs = new HashMap<>();
        this.sprints = new ArrayList<>();
    }

    public void mudaSprint(Date fim, Pessoa lider) {
        Sprint s = new Sprint(fim, lider);
        sprints.add(s);
    }

    public void addDev(Pessoa dev) {
        this.devs.put(dev.getMatr(), dev);
    }

    public boolean equals(Object o) {
        if (o instanceof Time) {
            return ((Time) o).id == this.id;
        }
        return false;
    }

    public int hashCode() {
        return this.id;
    }
}
