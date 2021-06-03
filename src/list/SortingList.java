package list;

import java.util.*;

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
//        Collections.sort(gatos);
        gatos.sort(Cat::compareTo);
        System.out.println(gatos);
        System.out.print("\n");

        System.out.println("-- \t Ordem  Idade \t --");
        Collections.sort(gatos, new ComparatorIdade());
        System.out.println(gatos);
        System.out.print("\n");

        System.out.println("-- \t Ordem  Cor \t --");
        Collections.sort(gatos, new ComparatorCor());
        System.out.println(gatos);
        System.out.print("\n");

        System.out.println("-- \t Ordem Nome/Cor/idade \t --");
        Collections.sort(gatos, new ComparatorNomeCorIdade());
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

class ComparatorIdade implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        return Integer.compare(c1.getIdade(), c2.getIdade());
    }
}
class ComparatorCor implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        int nome = c1.getNome().compareToIgnoreCase(c2.getNome());
        if (nome != 0) return nome;

        int cor = c1.getCor().compareToIgnoreCase(c2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(c1.getIdade(), c2.getIdade());
    }
}