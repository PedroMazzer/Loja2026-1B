package view;

import controller.Controlador;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet("/Comprar")
public class Comprar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String nome = req.getParameter("nome");
        double preco = Double.parseDouble(req.getParameter("preco"));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        if (quantidade <= 0) {
            resp.getWriter().println("Quantidade inválida");
            return;
        }

        Produto produto = new Produto(nome, preco, quantidade);
        Controlador.carrinho.add(produto);

        resp.sendRedirect("Carrinho");
    }
}