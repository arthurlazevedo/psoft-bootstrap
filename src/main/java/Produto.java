public class Produto {
    private int id;
    private String nome;

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public boolean equals(Object o) {
        if (o instanceof Produto) {
            return ((Produto) o).id == this.id;
        }

        return false;
    }

    public int hashCode() {
        return this.id;
    }
}
