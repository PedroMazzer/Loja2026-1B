package view;

import controller.Controlador;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Excluir")
public class Excluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int i = Integer.parseInt(req.getParameter("i"));
        Controlador.carrinho.remove(i);

        resp.sendRedirect("Carrinho");
    }
}