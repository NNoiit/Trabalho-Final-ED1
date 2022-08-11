import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int n;
		/* */
		System.out.println("Quantos simbolos?");
		n = scanner.nextInt();
		// heap.carregaDados();
		// heap.imprime();
		// heap.aplicaHuffman();
		// heap.imprime();

		MinBinaryHeap heap = new MinBinaryHeap(n);
		heap.carregaDados();
		System.out.println("");
		heap.imprime();
		System.out.println("");
		heap.aplicaHuffman();
		System.out.println("");
		heap.mostraCodigo();
		System.out.println("");
		heap.mostra();
		
		
		scanner.close();
	}
}