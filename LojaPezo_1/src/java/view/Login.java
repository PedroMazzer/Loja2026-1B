package view;

import controller.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        for (Pessoa p : Controlador.pessoas) {
            if (p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                req.getSession().setAttribute("usuario", p);
                // Redireciona para index usando _top para atualizar os frames
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("<html><head>");
                out.println("<script>window.top.location.href = 'index.html';</script>");
                out.println("</head><body></body></html>");
                return;
            }
        }

        // Login inválido
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'>");
        out.println("<link rel='stylesheet' href='css/style.css'></head>");
        out.println("<body>");
        out.println("<div class='formulario'>");
        out.println("<h2>Login</h2>");
        out.println("<p class='erro'>Login ou senha inválidos.</p>");
        out.println("<a href='login.html'>Tentar novamente</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
