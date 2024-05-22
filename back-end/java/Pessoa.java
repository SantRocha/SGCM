package java;

public class Pessoa {
    private String nome;
    private String email;

    //Metodos de acesso
    public void setNome(String nome) { // Alterar o nome da pessoa
        this.nome = nome;
    }

    public String getNome() { // Retorna o novo nome
        return this.nome;
    }

    public void setEmail(String email) { // Alterar o email da pessoa
        this.email = email;
    }

    public String getEmail() { // Retorna o novo email
        return this.email;
    }

}
