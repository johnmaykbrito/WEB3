package servlets;

import basicas.Funcionario;
import cadastro.FachadaFuncionarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class Exemplo6c extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("codigo");
        int codigo = Integer.parseInt(id);

        FachadaFuncionarios fachada = FachadaFuncionarios.getInstance();
        Funcionario f = fachada.procurarPorCodigo(codigo);
        resp.setContentType("text/plain");
        JSONObject json = new JSONObject(f);
        resp.getWriter().write(json.toString());
    }
}
