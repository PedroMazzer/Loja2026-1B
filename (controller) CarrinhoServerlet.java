package model;

// Classe que representa um produto da loja
// Cada produto tem nome, preço e quantidade
public class Produto {

    // Atributos do produto
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor - chamado quando criamos um novo produto
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters - métodos para acessar os atributos de fora da classe
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setter - permite atualizar a quantidade (usado quando adiciona mais do mesmo produto no carrinho)
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Calcula o subtotal do produto (preço x quantidade)
    public double getSubtotal() {
        return preco * quantidade;
    }
}
