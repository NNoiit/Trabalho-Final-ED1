import java.util.Random;
import java.util.Scanner;

public class MinBinaryHeap
{
	private int n;               /* Numero de elementos no heap. */   
	private int tam;             /* Tamanho m�ximo do heap. */
	private Arvbin[] vetor;          /* Vetor com elementos. */
	private Arvbin noHuffman =  null;

	
	/* Constr�i heap vazio. */
	public MinBinaryHeap(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new Arvbin[tamanho+1];
		
	}

	/* Constr�i heap a partir de vetor v. */
	public MinBinaryHeap(int tamanho, Arvbin[] v)
	{
		tam = tamanho;
		vetor = new Arvbin[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}
	
	/* Testa se a fila de prioridade est� logicamente vazia.
	   Retorna true se vazia, false, caso contr�rio. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		System.out.println("Conte�do da heap: ");
		
		for(int i = 1; i <= n; i++)
			System.out.println(vetor[i].getSimbolo() + " : " + vetor[i].getFrequencia());

		System.out.println();
	}

	/* Busca o menor item na fila de prioridades.
	   Retorna o menor item em itemMin e true, ou falso se a heap estiver vazia. */
	public int min()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		return vetor[1].getFrequencia();
	}

	/* Remove o menor item da lista de prioridades e coloca ele em itemMin. */
	public Arvbin removeMin()
	{
		Arvbin itemMin;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return null;
		}

		itemMin = vetor[1];
		vetor[1] = vetor[n];
		n--; 
		refaz(1);
		
		return itemMin;
	}

	/* M�todo auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitr�rio dos itens. */
	private void constroiHeap()
	{
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* M�todo auxiliar para restaurar a propriedade de heap que
	 * n�o est� sendo respeitada pelo n� i. */
	private void refaz(int i)
	{
		Arvbin x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, menorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o menor filho � o da esquerda. */
			menorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se � menor que o filho esquerdo. */
				if(vetor[ filhoDir ].getFrequencia() < vetor[ filhoEsq ].getFrequencia())
					menorFilho = filhoDir;
			}

			/* Compara o valor do menor dos filhos com x. */
			if(vetor[ menorFilho ].getFrequencia() < x.getFrequencia())
				vetor [ i ] = vetor[ menorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posi��o "i" desceu para o n�vel de baixo, a pr�xima
			 * itera��o vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posi��o "menorFilho") com um de seus novos filhos. */
			i = menorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * S�o permitidas duplicatas. */

	
	public void insere(Arvbin x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento � inicialmente inserido na primeira posi��o dispon�vel
		 * na �rvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do n� raiz (de �ndice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x.getFrequencia() < vetor[pos/2].getFrequencia())
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	public void carregaDados(){
		try (Scanner entrada = new Scanner(System.in)) {
			for(int x = 0;x<tam;x++){

				System.out.println("indique o Caractere");

				String caractere = entrada.next();

				System.out.println("indique a frequencia");

				int freq = entrada.nextInt();

				Arvbin letra = new Arvbin(caractere.charAt(0),freq);

				this.insere(letra);

			}
		}


	}

	long tempoIniNano = System.nanoTime();
	public void aplicaHuffman(){
		
		while(n>1){
			Arvbin x = this.removeMin();

			Arvbin y = this.removeMin();

			Arvbin soma = new Arvbin(' ', x.getFrequencia() + y.getFrequencia(),x,y);

			this.insere(soma);

			this.noHuffman = soma;
		}
	}
	long tempoFimNano = System.nanoTime();

	public void mostraCodigo(){
		System.out.println("Código de cada simbolo");
		noHuffman.mostraCodigo(" ");
	}

	
	public void mostra(){
		System.out.println("Conteúdo em pré-ordem");
		noHuffman.mostra();
	}
	


	///////////////////////// test //////////////////////////
	public void testTempo(){
		for(int x = 0;x<tam;x++){

			Random gerador = new Random();
			
			char caractereGerado = (char) (gerador.nextInt(26) + 'a');
			//String caractere = caractereGerado;

			int numero = gerador.nextInt(1000);
			int freq = numero;

			Arvbin letra = new Arvbin(caractereGerado,freq);

			this.insere(letra);

		}
	}
	
	public void mostraTempo(){

		System.out.println("\n\nTamanho da entrada: "+ tam);
		System.out.println("Tempo de execução ini: "+ tempoIniNano + " ns");
		System.out.println("Tempo de execução final: "+ tempoFimNano + " ns");
		System.out.println("Tempo de execução: "+ (tempoFimNano - tempoIniNano) + "ns");
	}
}