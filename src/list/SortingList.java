package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingList {

    public static void main(String[] args) {
        List<Cat> gatos = new ArrayList<Cat>(){{
            add(new Cat("fulano", 10, "preto"));
            add(new Cat("ciclano", 5, "laranja"));
            add(new Cat("bixano", 7, "cinza"));
        }};

        System.out.println("-- \t Ordem de inserção  \t --");
        System.out.println(gatos);
        System.out.print("\n");

        System.out.println("-- \t Ordem aleatoria  \t --");
        Collections.shuffle(gatos);
        System.out.println(gatos);
        System.out.print("\n");

        System.out.println("-- \t Ordem natural  \t --");
        gatos.sort(Cat::compareTo);
        System.out.println(gatos);
        System.out.print("\n");
    }
}

class Cat implements Comparable<Cat>{

    private String nome;
    private Integer idade;
    private String cor;

    public Cat(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "\nCat{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                "}";
    }

    @Override
    public int compareTo(Cat gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}
