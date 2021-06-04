package map;

import javax.net.ssl.ManagerFactoryParameters;
import java.util.*;

public class ExampleMap {

    public static void main(String[] args) {
//        Formas de criar maps
//        Map carros = new HashMap(); // antes do java 5
//        Map<String, Double> carros = new HashMap<>(); // generics and diamond
//        Map<String, Double> carros = Map.of("gol", 14.4, "uno", 15.6);

        System.out.println("Crie um dicionario de dados :");
        Map<String, Double> carros = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carros);
        System.out.print("\n");

        System.out.println("Substituir o consumo do gol para 15.2km/l:");
        carros.put("gol", 15.2);
        System.out.println(carros);
        System.out.print("\n");

        System.out.println("Confira se o modelo tucson está no dicionario: " + carros.containsKey("tucson"));
        System.out.print("\n");

        System.out.println("Exiba o consumo do uno: " + carros.get("uno"));
        System.out.print("\n");

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carros.keySet();
        System.out.println(modelos);
        System.out.print("\n");

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carros.values();
        System.out.println(consumos);
        System.out.print("\n");

        System.out.println("Exiba o modelo mais economico: ");
        Double consumoEficiente = Collections.max(carros.values());
        Set<Map.Entry<String, Double>> entries = carros.entrySet();
        String modeloMaisEficiente = "";


        for (var entry: entries) {
            if(entry.getValue().equals(consumoEficiente)) modeloMaisEficiente = entry.getKey() ;
        }
        System.out.println(modeloMaisEficiente);
        System.out.print("\n");

        System.out.println("Exiba o modelo menos economico: ");
        Double consumoMenosEficiente = Collections.min(carros.values());
        String modeloMenosEficiente = "";

        for (var entry: entries) {
            if(entry.getValue().equals(consumoMenosEficiente)) modeloMenosEficiente = entry.getKey() ;
        }
        System.out.println(modeloMenosEficiente);
        System.out.print("\n");

        System.out.println("Exiba a soma dos consumos:");
        Iterator<Double> iterator = carros.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);
        System.out.print("\n");

        System.out.println("Exiba a media dos consumos: " + (soma / carros.size()));
        System.out.print("\n");

        System.out.println(carros);
        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l:");
//        carros.values().removeIf(aDouble -> aDouble.equals(15.6));
        Iterator<Double> iterator1 = carros.values().iterator();
        while(iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carros);
        System.out.print("\n");

        System.out.println("Exiba os dados na ordem que foram informados");
        Map<String, Double> carros1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carros1);
        System.out.print("\n");

        System.out.println("Exiba os dados na ordem das chaves");
        Map<String, Double> carros2 = new TreeMap<>(carros1);

        System.out.println(carros2);
        System.out.print("\n");

        System.out.println("Apague o dicionario de carros");
        carros.clear();
        System.out.println(carros);

        System.out.println("Confira se o dicionario de carros está vazio: " + carros.isEmpty());

    }
}
