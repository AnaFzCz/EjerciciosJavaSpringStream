import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ejercicio 1");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Lista: [1, 2, 3, 4, 5, 6], imprime números pares: ");
        numeros.stream().
                filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("Ejercicio 2");
        System.out.println("Lista: [java, stream, lambda], imprime mayúsculas: ");
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        System.out.println("Ejercicio 3");
        List<Integer> numerosTodos = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numeroImNovo = numerosTodos.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Lista de números: [1, 2, 3, 4, 5, 6], tomar impares, multiplicarlos por 2 y guardarlos en otra lista:  ");
        System.out.println(numeroImNovo);

        System.out.println("Ejercicio 4");

        System.out.println("Lista de duplicados:[apple,banana,apple,orange,banana], eliminar duplicados y listar");

        List<String> listaFrutasDuplicadas = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        listaFrutasDuplicadas.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Ejercicio 5");

        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );
        List<Integer> listaDeNumerosNuevos = listaDeNumeros.stream()
                .flatMap(List::stream)
                .filter(n -> n % 2 == 1)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Listas: [1,2,3,4] [5,6,7,8] [9,10,11,12]");
        System.out.println("Lista Filtrando e ordenando números primos " + listaDeNumerosNuevos);

        System.out.println("Ejercicio 6");

        System.out.println("Filtrar personas mayores de 18 años");
        List<Persona> personas = Arrays.asList(
                new Persona("Alice", 22),
                new Persona("Bob", 17),
                new Persona("Charlie", 19)
        );

        personas.stream()
                .filter(persona -> persona.getIdade() > 18)
                .map(Persona::getNome)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Ejercicio 7");

        List<Producto> produtos = Arrays.asList(
                new Producto("Smartphone", 800.0, "Eletrônicos"),
                new Producto("Notebook", 1500.0, "Eletrônicos"),
                new Producto("Teclado", 200.0, "Eletrônicos"),
                new Producto("Cadeira", 300.0, "Móveis"),
                new Producto("Monitor", 900.0, "Eletrônicos"),
                new Producto("Mesa", 700.0, "Móveis")
        );

        List<Producto> productosNuevos = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() < 1000)
                .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .collect(Collectors.toList());

        System.out.println("Lista de productos" + productosNuevos);

        System.out.println("Ejercicio 8");

        List<Producto> productosNuevosEj8 = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() < 1000)
                .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Lista de productos más baratos" + productosNuevosEj8);
    }
}