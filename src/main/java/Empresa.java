import java.util.*;

public class Empresa {
    private Map<Integer, Time> times;
    private Map<String, Pessoa> funcionarios;
    private Pessoa po;
    private Map<Integer, Produto> produtos;

    public Empresa() {
        this.times = new HashMap<>();
        this.funcionarios = new HashMap<>();
        this.produtos = new HashMap<>();
    }

    public void addFuncionario(String matr, String nome, String cargo) {
        Pessoa p = new Pessoa(matr, nome, cargo);
        funcionarios.put(matr, p);
    }

    public void setPO(String idFuncionario) {
        Pessoa p = funcionarios.get(idFuncionario);
        if (p.getCargoNome() == "DEV") {
            throw new IllegalArgumentException("Funcionário não pode ser promovido para PO");
        }

        p.setCargo("PO");
        this.po = p;
    }

    public void addTime(int id, String idProduto, String idGerente) {
        Produto p = produtos.get(idProduto);
        Pessoa g = funcionarios.get(idGerente);
        Time t = new Time(id, p, g);
        times.put(id, t);
    }

    public void addProduto(int id, String nome) {
        Produto p = new Produto(id, nome);
        produtos.put(id, p);
    }

    public void addDevTime(String idDev, int idTime) {
        Time t = times.get(idTime);
        t.addDev(funcionarios.get(idDev));
    }

    public void promove(String idFunc) {
        Pessoa p = funcionarios.get(idFunc);
        if (p.getCargoNome() == "DEV") p.setCargo("GERENTE");
        else if (p.getCargoNome() == "GERENTE") setPO(idFunc);
    }

    public void mudaSprintTime(Date fim, String idLider, int idTime) {
        Time t = times.get(idTime);
        Pessoa lider = funcionarios.get(idLider);
        t.mudaSprint(fim, lider);
    }
}
