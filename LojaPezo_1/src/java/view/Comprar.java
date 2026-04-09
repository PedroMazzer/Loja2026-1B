package view;

import controller.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
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
        String precoStr = req.getParameter("preco").trim().replace(",", ".");
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        if (quantidade <= 0) {
            resp.getWriter().println("Quantidade inválida");
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            resp.getWriter().println("Preço inválido: " + precoStr);
            return;
        }

        Produto produto = new Produto(nome, preco, quantidade);
        Controlador.carrinho.add(produto);

        // Redireciona quebrando o frameset com target _top
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head>");
        out.println("<script>window.top.location.href = 'Carrinho';</script>");
        out.println("</head><body></body></html>");
    }
}
