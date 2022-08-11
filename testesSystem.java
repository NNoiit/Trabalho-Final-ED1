import java.util.Scanner;

public class testesSystem{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
		/* */
		System.out.println("Quantos simbolos?");
		int n = scanner.nextInt();
		// heap.carregaDados();
		// heap.imprime();
		// heap.aplicaHuffman();
		// heap.imprime();

		MinBinaryHeap heap = new MinBinaryHeap(n);
		heap.testTempo();
		System.out.println("");
		heap.imprime();
		System.out.println("");
		heap.aplicaHuffman();
		System.out.println("");
		heap.mostraCodigo();
		System.out.println("");
		heap.mostra();

		//////////////////// test ////////////////////////
        heap.testTempo();
		scanner.close();
    }

}
