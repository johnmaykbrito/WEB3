package servlets;

import basicas.Funcionario;
import cadastro.FachadaFuncionarios;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo6a extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        FachadaFuncionarios fachada = FachadaFuncionarios.getInstance();
        resp.setContentType("text/plain");
        JSONArray json = new JSONArray(fachada.listarTodos());
        resp.getWriter().write(json.toString());
    }

    public static void main(String[] args) {
        FachadaFuncionarios fachada = FachadaFuncionarios.getInstance();
        Funcionario f1 = new Funcionario("Joao", 21, new Date());
        fachada.inserir(f1);
        JSONArray json = new JSONArray(fachada.listarTodos());
        System.out.println(json.toString());
        JSONObject obj = new JSONObject(f1);
        System.out.println(obj.toString());
    }
}
