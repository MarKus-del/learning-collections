package stream;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReferenceMethod {

    public static void main(String[] args) {
        List<String> numeros = Arrays.asList("1","0", "4", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima a lista:");
        numeros.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Pegue os 5 primeiros numeros e ponha dentro de um set:");
        numeros.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("tranforme a lista em uma lista de inteiros");
        numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("pegue os numeros pares e maiores que 2 e coloque em uma lista:");
        numeros.stream()
            .map(Integer::parseInt)
            .filter(value -> value % 2 == 0 && value > 2)
            .collect(Collectors.toList())
            .forEach(System.out::println);
        System.out.println();

        System.out.println("Mostre a média dos números:");
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        System.out.println("Remova os valores impares");
        var listaNumerica = numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        listaNumerica.removeIf(i -> i % 2 != 0);
        System.out.println(listaNumerica);

        List<Character> consoantesMeuNome = Arrays.asList('c', 'm', 'l', 'c', 'v', 'l', 'c', 'n', 't');
        System.out.println(consoantesMeuNome);
    }
}
