package view;

import controller.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.Produto;

@WebServlet("/Finalizar")
public class Finalizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Pessoa usuario = (Pessoa) req.getSession().getAttribute("usuario");
        double totalGeral = 0;

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Compra finalizada</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Compra concluída</h1>");

        if (usuario != null) {
            out.println("<p>Cliente: " + usuario.getNome() + "</p>");
        } else {
            out.println("<p>Cliente: não identificado</p>");
        }

        for (Produto p : Controlador.carrinho) {
            out.println("<div class='item'>");
            out.println("<p>Produto: " + p.getNome() + "</p>");
            out.println("<p>Quantidade: " + p.getQuantidade() + "</p>");
            out.println("<p>Preço unitário: R$ " + p.getPreco() + "</p>");
            out.println("<p>Total do item: R$ " + p.getTotal() + "</p>");
            out.println("</div>");
            totalGeral += p.getTotal();
        }

        out.println("<h2>Total geral: R$ " + totalGeral + "</h2>");
        out.println("<a href='index.html'>Voltar para a loja</a>");
        out.println("</body>");
        out.println("</html>");

        Controlador.carrinho.clear();
    }
}