package com.example.leticia.estagia;

public class User {
    private String nome;
    private String ra;
    private String curso;
    private String email;
    private String senha;
    private boolean admin;

    public User() {
        setUser("","", "", "", "", false);
    }

    public User(String nome, String ra, String curso, String email, String senha, boolean admin) {
        setUser(nome, ra, curso, email, senha, admin);
    }

    public void setUser(String nome, String ra, String curso, String email, String senha, boolean admin) {
        this.nome = nome;
        this.ra = ra;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public String getNome() { return nome; }
    public String getCurso() { return curso; }
    public String getRA() { return ra; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

    public boolean isAdmin() { return admin; }

    public String toString() {
        return "User -> Nome: " + nome + " - RA: " + ra + " - Senha: " + senha;
    }
}
