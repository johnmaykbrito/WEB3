package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet(name = "ServletValidar", urlPatterns = {"/ServletValidar"})
@MultipartConfig
public class ServletValidar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();

        String nome = request.getParameter("nome");
        if (nome.isEmpty()) {
            obj.put("msgNome", "");
        } else {
            if (nome.length() <= 3) {
                obj.put("msgNome", "Nome deve conter mais de três caracteres.");
            } else {
                obj.put("msgNome", "");
            }
        }

        String salario = request.getParameter("salario");
        if (salario.isEmpty()) {
            obj.put("msgSalario", "");
        } else {
            double valor = Double.parseDouble(salario);
            if (valor < 987) {
                obj.put("msgSalario", "Salário deve ser maior que o salário mínimo.");
            } else {
                obj.put("msgSalario", "");
            }
        }

        String dataNascimento = request.getParameter("dataNascimento");
        if (dataNascimento.isEmpty()) {
            obj.put("msgDataNascimento", "");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date data = sdf.parse(dataNascimento);
                Date atual = new Date();
                Calendar cal = new GregorianCalendar();
                cal.setTime(atual);
                cal.add(Calendar.YEAR, -18);
                Date maior18 = cal.getTime();

                cal.setTime(atual);
                cal.add(Calendar.YEAR, -70);
                Date menor70 = cal.getTime();

                if (maior18.before(data)) {
                    obj.put("msgDataNascimento", "Você deve ter mais que 18 anos.");
                } else if (menor70.after(data)) {
                    obj.put("msgDataNascimento", "Você deve ter menos que 70 anos.");
                } else {
                    obj.put("msgDataNascimento", "");
                }
            } catch (ParseException ex) {
                obj.put("msgDataNascimento", "Data deve estar no formato yyyy-MM-dd");
            }
        }
        out.println(obj.toString());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
