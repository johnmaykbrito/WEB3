package servlets;

import basicas.Funcionario;
import cadastro.FachadaFuncionarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exemplo6e extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("codigo");
        int codigo = Integer.parseInt(id);

        FachadaFuncionarios fachada = FachadaFuncionarios.getInstance();
        Funcionario func = fachada.procurarPorCodigo(codigo);
        fachada.remover(func);
        req.getRequestDispatcher("Exemplo6a").forward(req, resp);
    }
}
