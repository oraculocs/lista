package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Funcionario;

public class MainFuncionario {

	public static void main(String[] args) {
		
		/*
		 * Fazer um programa para ler um n�mero inteiro N e depois os dados (id, nome e salario) de
		 * N funcion�rios. N�o deve haver repeti��o de id.
		 * Em seguida, efetuar o aumento de X por cento no sal�rio de um determinado funcion�rio.
		 * Para isso, o programa deve ler um id e o valor X. Se o id informado n�o existir, mostrar uma
		 * mensagem e abortar a opera��o. Ao final, mostrar a listagem atualizada dos funcion�rios,
		 * conforme exemplos.
		 * Lembre-se de aplicar a t�cnica de encapsulamento para n�o permitir que o sal�rio possa
		 * ser mudado livremente. Um sal�rio s� pode ser aumentado com base em uma opera��o de
		 * aumento por porcentagem dada.
		 */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> lista = new ArrayList<>();
		
		System.out.println("Quantos funcion�rios ser�o registrados?");
		int n = sc.nextInt();
				
		for(int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Funcion�rio #" + i + ": ");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while(hasId(lista, id)) {
				System.out.println("ID n�o existente. Tente novamente");
				id = sc.nextInt();
			}
			
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Sal�rio: ");
			double salario = sc.nextDouble();
			
			lista.add(new Funcionario(id, nome, salario));
		}
		
		System.out.println();
		System.out.print("Digite o ID do funcion�rio que ter� aumento salarial:");
		int id = sc.nextInt();
		
		Funcionario func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(func == null) {
			System.out.println("Esse ID n�o existe!");
		}else {
			System.out.println("Entre com a porcentagem:");
			double porcentagem = sc.nextDouble();
			func.aumentaSalario(porcentagem);
		}
		
		System.out.println();
		System.out.println("Lista de Funcion�rios: ");
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
