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

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Carrinho</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Carrinho</h1>");

        if (Controlador.carrinho.isEmpty()) {
            out.println("<p>Carrinho vazio</p>");
        } else {
            for (Produto p : Controlador.carrinho) {
                out.println("<div class='item'>");
                out.println("<p>Produto: " + p.getNome() + "</p>");
                out.println("<p>Quantidade: " + p.getQuantidade() + "</p>");
                out.println("<p>Preço: R$ " + p.getPreco() + "</p>");
                out.println("<p>Total do item: R$ " + p.getTotal() + "</p>");
                out.println("<a href='Excluir?i=" + i + "'>Excluir</a>");
                out.println("</div>");
                totalGeral += p.getTotal();
                i++;
            }

            out.println("<h2>Total geral: R$ " + totalGeral + "</h2>");
            out.println("<a href='Finalizar'>Finalizar compra</a>");
        }

        out.println("<br><br><a href='index.html'>Voltar</a>");
        out.println("</body>");
        out.println("</html>");
    }
}