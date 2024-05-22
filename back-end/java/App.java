package java;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Santiago");
        System.out.println(pessoa1.getNome());

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Santiago");
        if (pessoa1 == pessoa2) {
            System.out.println("Referencias diferentes");
        }
    }
}
