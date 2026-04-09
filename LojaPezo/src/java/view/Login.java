package controller;

import java.io.IOException;
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
                resp.sendRedirect("index.html");
                return;
            }
        }

        resp.getWriter().println("Login inválido");
    }
}