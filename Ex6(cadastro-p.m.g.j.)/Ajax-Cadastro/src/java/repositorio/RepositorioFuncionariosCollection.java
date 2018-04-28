package repositorio;

import basicas.Funcionario;
import java.util.ArrayList;
import java.util.Collection;

public class RepositorioFuncionariosCollection {

    private Collection<Funcionario> repositorio = new ArrayList<Funcionario>();
    private static int id = 0;

    public void inserir(Funcionario func) {
        func.setCodigo(id++);
        repositorio.add(func);
    }

    public void remover(Funcionario func) {
        repositorio.remove(func);
    }

    public void alterar(Funcionario func) {
        Funcionario f = this.procurarPorCodigo(func.getCodigo());
        repositorio.remove(f);
        repositorio.add(func);
    }

    public Funcionario procurarPorCodigo(int codigo) {
        for (Funcionario func : repositorio) {
            if (func.getCodigo() == codigo) {
                return func;
            }
        }
        return null;
    }

    public Collection<Funcionario> listarTodos() {
        return repositorio;
    }
}
