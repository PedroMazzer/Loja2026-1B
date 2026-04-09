package model;

public class Pessoa {
    private String nome;
    private String login;
    private String senha;
    private String telefone;

    public Pessoa(String nome, String login, String senha, String telefone) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
    }

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