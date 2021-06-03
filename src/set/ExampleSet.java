package set;

import java.util.*;

public class ExampleSet {
    public static void main(String[] args) {
//        Formas de criar sets:
//        Set notas = new HashSet(); // antes do java 5
//        Set<Double> notas = new HashSet<>(); // Generics - Diamond Operator
//        HashSet<Double> notas = new HashSet<>();
//        Set<Double> notas = new HashSet<>();
//        Set<Double> notas = Set.of(7d, 8.5, 3.8, 5d, 8.7); // lista imutavel

        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);
        System.out.print("\n");

        System.out.println("Confira se a nota 5.0 está no set: " + notas.contains(5d));
        System.out.print("\n");

        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        System.out.print("\n");

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.print("\n");

        System.out.println("Exiba a soma das notas: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);
        System.out.print("\n");

        System.out.println("Exibir a media das notas: " + (soma / notas.size()));
        System.out.print("\n");

        System.out.println("Remova a nota 0");
        notas.remove(0d);
        System.out.println(notas);
        System.out.print("\n");

        System.out.println("Exiba todas as notas na ordem em que form informados:");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente:");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto");
        notas3.clear();

        System.out.println("Confirmar se o set está vazio: " + notas3.isEmpty());

    }
}
