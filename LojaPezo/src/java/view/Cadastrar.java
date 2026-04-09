package view;

import controller.Controlador;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;

@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String nome = req.getParameter("nome");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        String telefone = req.getParameter("telefone");

        Pessoa p = new Pessoa(nome, login, senha, telefone);
        Controlador.pessoas.add(p);

        resp.sendRedirect("login.html");
    }
}