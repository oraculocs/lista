package list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) {
		
		/*
		 * Demonstração de funcionalidades para uma Lista
		 */
		
		List<String> list = new ArrayList<>();
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		list.add(2, "Marco");
		System.out.println(list.size());
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("---------------------");
		list.removeIf(x -> x.charAt(0) == 'M'); //Predicado para remover todos na Lista que comecem com a letra M
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("---------------------");
		System.out.println("Index of Bob: " + list.indexOf("Bob")); //Encontrar a posição de um elemento
		System.out.println("Index of Marco: " + list.indexOf("Marco")); //Retorna -1 pois o cara jão não existe mais na lista
		System.out.println("---------------------");
		
		//Devolve uma nova Lista somente com os elementos iniciados com A
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); 
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("---------------------");
		
		//Retorna o elemento com base no filtro que está sendo passado, caso não ache retorna null
		String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(name);
	}
}