package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Funcionario;

public class MainFuncionario {

	public static void main(String[] args) {
		
		/*
		 * Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
		 * N funcionários. Não deve haver repetição de id.
		 * Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
		 * Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
		 * mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
		 * conforme exemplos.
		 * Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
		 * ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
		 * aumento por porcentagem dada.
		 */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> lista = new ArrayList<>();
		
		System.out.println("Quantos funcionários serão registrados?");
		int n = sc.nextInt();
				
		for(int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Funcionário #" + i + ": ");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while(hasId(lista, id)) {
				System.out.println("ID não existente. Tente novamente");
				id = sc.nextInt();
			}
			
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			
			lista.add(new Funcionario(id, nome, salario));
		}
		
		System.out.println();
		System.out.print("Digite o ID do funcionário que terá aumento salarial:");
		int id = sc.nextInt();
		
		Funcionario func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(func == null) {
			System.out.println("Esse ID não existe!");
		}else {
			System.out.println("Entre com a porcentagem:");
			double porcentagem = sc.nextDouble();
			func.aumentaSalario(porcentagem);
		}
		
		System.out.println();
		System.out.println("Lista de Funcionários: ");
		for(Funcionario obj : lista) {
			System.out.println(obj);
		}
		
		
		sc.close();
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}
	
//	public static Integer position(List<Funcionario> list, int id) {
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getId() == id) {
//				return i;
//			}
//		}
//		return null;
//	}

}
