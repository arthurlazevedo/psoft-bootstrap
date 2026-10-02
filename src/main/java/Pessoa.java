import java.util.*;

public class Pessoa {
    private String matr;
    private String nome;
    private Cargo cargo;

    public Pessoa(String matr, String nome, String cargo) {
        this.matr = matr;
        this.nome = nome;
        this.cargo = derivaCargo(cargo);
    }

    public void setCargo(String cargo) {
        this.cargo = derivaCargo(cargo);
    }

    public String getCargoNome() {
        return this.cargo.getNome();
    }

    public String getMatr() {
        return this.matr;
    }

    public boolean equals(Object o) {
        if (o instanceof Pessoa) {
            return ((Pessoa) o).matr == this.matr;
        }

	return false;
    }

    public int hashCode() {
        return this.matr.hashCode();
    }

    private Cargo derivaCargo(String cargo) {
        cargo = cargo.toUpperCase();
        if (cargo == "DEV") return new Dev();
        if (cargo == "GERENTE") return new Gerente();
        if (cargo == "PO") return new PO();
        throw new IllegalArgumentException("Cargo não reconhecido");
    }
}
