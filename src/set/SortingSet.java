package set;

import java.util.*;

public class SortingSet {

    public static void main(String[] args) {

        System.out.println("-- Ordem inserção --");
        Set<Serie> series = new LinkedHashSet<>(){{
            add(new Serie("got", "Fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        System.out.println(series);

        System.out.println("-- Ordem Natural --");
        Set<Serie> series2 = new TreeSet<>(series);
        System.out.println(series2);

        System.out.println("-- Ordem Nome/Genero/TempoEpisodio --");
        Set<Serie> series3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        series3.addAll(series2);
        System.out.println(series3);
    }

}

class Serie implements Comparable<Serie>{

    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempo = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if(tempo != 0) return tempo;
        return this.getGenero().compareToIgnoreCase(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie o1, Serie o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (nome != 0) return nome;

        int genero = o1.getGenero().compareToIgnoreCase(o2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
    }
}
