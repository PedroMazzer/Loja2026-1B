package view;

import controller.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet("/Carrinho")
public class Carrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        double totalGeral = 0;
        int i = 0;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Carrinho</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Carrinho de Compras</h1>");

        if (Controlador.carrinho.isEmpty()) {
            out.println("<p>Carrinho vazio.</p>");
        } else {
            for (Produto p : Controlador.carrinho) {
                out.println("<div class='item'>");
                out.println("<p><strong>" + p.getNome() + "</strong></p>");
                out.println("<p>Quantidade: " + p.getQuantidade() + "</p>");
                out.println("<p>Preço unitário: R$ " + String.format("%.2f", p.getPreco()) + "</p>");
                out.println("<p>Total do item: R$ " + String.format("%.2f", p.getTotal()) + "</p>");
                out.println("<a href='Excluir?i=" + i + "'>Remover item</a>");
                out.println("</div>");
                totalGeral += p.getTotal();
                i++;
            }

            out.println("<div class='carrinho-total'>Total geral: R$ " + String.format("%.2f", totalGeral) + "</div>");
            out.println("<a href='Finalizar' class='btn-finalizar'>Finalizar compra</a>");
        }

        out.println("<a href='index.html' class='btn-voltar'>Voltar para a loja</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
