import java.util.ArrayList;
import java.util.List;

public class Exemplo {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            System.out.println("Posição [" + (i + 1) +"]:" + numeros[i]);
        }
        List<Integer> n_dinamico = new ArrayList<Integer>();
        n_dinamico.add(25);
        for(int i = 1; i < 11; i++) {
            n_dinamico.add((int) Math.pow((double) i, 3.0));
        }
        n_dinamico.remove(0);
        for(int item : n_dinamico) {
            System.out.println(item);
        }
    }
}