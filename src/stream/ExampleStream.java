package stream;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;

public class ExampleStream {

    public static void main(String[] args) {
        Map<Integer, Contato> contatos = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(2, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        contatos.forEach((key, contato) -> System.out.println((key + " " + contato.getNumero())));
        System.out.println();

        System.out.println("Ordem numero de telefone com classe anônima: ");
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            }
        });
        set.addAll(contatos.entrySet());
        set.forEach(System.out::println);
        System.out.print("\n");

        System.out.println("Ordem numero de telefone function interface: ");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));
        set1.addAll(contatos.entrySet());
        set1.forEach(System.out::println);
        System.out.print("\n");

        System.out.println("Ordem numero de telefone com lambda: ");
        Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(
                (cont) -> cont.getValue().getNumero()));
        set2.addAll(contatos.entrySet());
        set2.forEach(System.out::println);
        System.out.print("\n");
    }
}

class Contato {

    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(numero, contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}