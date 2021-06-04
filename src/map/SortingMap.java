package map;

import java.util.*;

public class SortingMap {

    public static void main(String[] args) {
        Map<String, Book> livros = new HashMap<>(){{
            put("Hawking, Stephen", new Book("Uma breve historia do tempo", 256));
            put("Duhigg, Charles", new Book("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Book("21 lições para o século 21", 432));
        }};

        for (var entry : livros.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Ordem Inserção");
        Map<String, Book> livros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Book("Uma breve historia do tempo", 256));
            put("Duhigg, Charles", new Book("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Book("21 lições para o século 21", 432));
        }};

        for (var entry : livros1.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Ordem alfabetica autores");
        Map<String, Book> livros2 = new TreeMap<>(livros1);

        for (var entry : livros2.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Ordem alfabetica dos livros");
        Set<Map.Entry<String, Book>> meusLivrosOrdenados = new TreeSet<>(new ComparatorNome());
        meusLivrosOrdenados.addAll(livros2.entrySet());
        for (var entry : meusLivrosOrdenados) {
            System.out.println(entry);
        }

        System.out.println("Ordem numero de páginas");
        Set<Map.Entry<String, Book>> meusLivrosOrdenadosPorPagina = new TreeSet<>(new ComparatorPaginas());
        meusLivrosOrdenadosPorPagina.addAll(livros2.entrySet());
        for (var entry : meusLivrosOrdenadosPorPagina) {
            System.out.println(entry);
        }

    }
}

class Book {

    private String nome;
    private Integer paginas;

    public Book(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return nome.equals(book.nome) && paginas.equals(book.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                "}\n";
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Book>> {

    @Override
    public int compare(Map.Entry<String, Book> o1, Map.Entry<String, Book> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Book>> {

    @Override
    public int compare(Map.Entry<String, Book> o1, Map.Entry<String, Book> o2) {
        return Integer.compare(o1.getValue().getPaginas(), o2.getValue().getPaginas());
    }
}