import java.util.*;

public class Sprint {
    private Date inicio;
    private Date fim;
    private Pessoa lider;

    public Sprint(Date fim, Pessoa lider) {
	this.inicio = new Date();
	this.fim = fim;
        this.lider = lider;
    }
}
