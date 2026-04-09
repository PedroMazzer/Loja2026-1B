package view;

import controller.Controlador;
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

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Departamentos</h3>");

        if (usuario != null) {
            out.println("<p class='usuario-logado'>Olá, " + usuario.getNome() + "</p>");
        } else {
            out.println("<p class='usuario-logado'>Usuário: não logado</p>");
        }

        out.println("<ul>");
        out.println("<li><a href='camisa.html' target='produtos'>Camisas</a></li>");
        out.println("<li><a href='cal%C3%A7a.html' target='produtos'>Calças</a></li>");
        out.println("<li><a href='acessorio.html' target='produtos'>Acessórios</a></li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
