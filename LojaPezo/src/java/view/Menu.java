package view;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;

@WebServlet("/Menu")
public class Menu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Pessoa usuario = (Pessoa) req.getSession().getAttribute("usuario");

        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Departamentos</h3>");

        if (usuario != null) {
            out.println("<p>Usuário: " + usuario.getNome() + "</p>");
        } else {
            out.println("<p>Usuário: não logado</p>");
        }

        out.println("<ul>");
        out.println("<li><a href='produtos1.html' target='produtos'>Eletrônicos</a></li>");
        out.println("<li><a href='produtos2.html' target='produtos'>Roupas</a></li>");
        out.println("<li><a href='produtos3.html' target='produtos'>Jogos</a></li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}