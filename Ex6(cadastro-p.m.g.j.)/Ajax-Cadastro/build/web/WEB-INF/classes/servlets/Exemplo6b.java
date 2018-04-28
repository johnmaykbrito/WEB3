package servlets;

import basicas.Funcionario;
import cadastro.FachadaFuncionarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class Exemplo6b extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String dataNascimento = req.getParameter("dataNascimento");
        String salario = req.getParameter("salario");

        Funcionario func = new Funcionario(nome, salario, dataNascimento);
        FachadaFuncionarios fachada = FachadaFuncionarios.getInstance();
        fachada.inserir(func);
        req.getRequestDispatcher("Exemplo6a").forward(req, resp);
    }
}
