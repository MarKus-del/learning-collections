package list;

import java.util.*;

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
        System.out.print("\n");

        System.out.println("Exibir a terceira nota: " + notas.get(2));
        System.out.print("\n");

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.print("\n");

        System.out.println("Exiba a maior nota: " + Collections.max(notas));
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


        System.out.println("Remover a nota 0:");
        notas.remove(0d);
        System.out.print("\n");

        System.out.println("Remover a nota da posição 0:");
        notas.remove(0);
        System.out.print("\n");

        System.out.println("Remova as notas menores que 7: ");
        Iterator<Double> iterator1 = notas.iterator();

        while(iterator1.hasNext()) {
            Double valorAtual = iterator1.next();
//            if(valorAtual < 7) notas.remove(valorAtual);
            if(valorAtual < 7) iterator1.remove();
        }
        System.out.println(notas);
        System.out.print("\n");

        System.out.println("Remova toda lista:");
        notas.clear();
        System.out.println(notas);
        System.out.print("\n");

        System.out.println("Conferir se a lista está vazia: " + notas.isEmpty());

        System.out.println("------------------------");
        System.out.println("Desafios");
        System.out.print("\n");

        System.out.println("Cria uma list com linkedList e colocar todos os elementos de um lista, nessa nova: ");

        LinkedList<Double> notas2 = new LinkedList<Double>();
        notas2.addAll(Arrays.asList(4d, 8.9, 6.7, 8.1));

        System.out.println(notas2);
        System.out.print("\n");

        System.out.println("Mostra o primeiro valor sem excluir: " + notas2.getFirst());
        System.out.println(notas2);
        System.out.print("\n");

        System.out.println("Mostra o primeiro valor removendo o da lista: " + notas2.removeFirst());
        System.out.println(notas2);
        System.out.print("\n");


    }
}
