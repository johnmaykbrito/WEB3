package cadastro;

import basicas.Funcionario;
import java.util.Collection;
import repositorio.RepositorioFuncionariosCollection;

public class FachadaFuncionarios {

    private static FachadaFuncionarios fachada;
    private RepositorioFuncionariosCollection repositorio;

    static {
        fachada = new FachadaFuncionarios();
    }

    private FachadaFuncionarios() {
        repositorio = new RepositorioFuncionariosCollection();
    }

    public static FachadaFuncionarios getInstance() {
        return fachada;
    }

    public void inserir(Funcionario func) {
        repositorio.inserir(func);
    }

    public void remover(Funcionario func) {
        repositorio.remover(func);
    }

    public void alterar(Funcionario func) {
        repositorio.alterar(func);
    }

    public Funcionario procurarPorCodigo(int codigo) {
        return repositorio.procurarPorCodigo(codigo);
    }

    public Collection<Funcionario> listarTodos() {
        return repositorio.listarTodos();
    }
}
