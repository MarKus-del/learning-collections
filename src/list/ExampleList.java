package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleList {

    public static void main(String[] args) {
//        Formas de criar listas:
//        List notas = new ArrayList(); // antes do java 5
//        List<Double> notas = new ArrayList<>(); // Generics - Diamond Operator
//        ArrayList<Double> notas = new ArrayList<>();
//        List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 1.65, 9, 5d));
//        List<Double> notas = Arrays.asList(7d, 8.5, 1.6, 9, 5d); // limitada - não pode inserir ou alterar
//        List<Double> notas = List.of(7d, 8.5, 3.8, 5d, 8.7); // lista imutavel

        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

//        System.out.println(notas.toString());
        System.out.println(notas);
        System.out.println("Exibir a posição da nota 5.0: " + notas.indexOf(5.0) + "\n");

        System.out.println("Mudar o  valor posição 4 para 8.0 :");
        notas.add(4, 8.0);
        System.out.println(notas + "\n");

        System.out.println("Substituir a nota 5.0 para 6.0:");
        notas.set(notas.indexOf(5.0), 6.0);
        System.out.println(notas + "\n");

        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5.0) + "\n");

        System.out.println("imprimir a lista em ordem de inserção");
        notas.forEach(System.out::println);

    }
}
