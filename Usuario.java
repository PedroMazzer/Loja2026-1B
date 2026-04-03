package model;

// Classe que representa um usuário cadastrado na loja
// Armazena os dados de cadastro e é salvo na sessão ao fazer login
public class Usuario {

    // Atributos do usuário conforme pedido pelo professor
    private String nome;
    private String login;
    private String senha;
    private String telefone;

    // Construtor - chamado ao cadastrar um novo usuário
    public Usuario(String nome, String login, String senha, String telefone) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
    }

    // Getters - métodos para acessar os atributos de fora da classe
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }
}
