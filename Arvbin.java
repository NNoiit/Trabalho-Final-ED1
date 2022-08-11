/* Nessa implementa��o, os conceitos de "n�" e "�rvore" se misturam. */
public class Arvbin
{
	private char simbolo; /* S�mbolo armazenado no n�. */	
	private int frequencia; /* Frequ�ncia do s�mbolo armazenado no n�. */
	private Arvbin esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */
	
	/* Construtor de �rvore sem sub�rvores (dir = esq = null). S�o fornecidos
	 * apenas o s�mbolo e a frequ�ncia do n�. */
	public Arvbin(char simbolo, int frequencia)
	{
		this.simbolo = simbolo;
		this.frequencia = frequencia;
	}
	
	/* Construtor de �rvore com sub�rvores. Al�m de s�mbolo e frequ�ncia do n�,
	 * s�o fornecidas as sub�rvores, que devem ter sido constru�das previamente. */
	public Arvbin(char simbolo, int frequencia, Arvbin esq, Arvbin dir)
	{
		this.simbolo = simbolo;
		this.frequencia = frequencia;
		this.esq = esq;
		this.dir = dir;
	}
	
	/* Imprime o conte�do da �rvore em pr�-ordem. */
	public void mostra(){
			System.out.print("(");
			System.out.print(frequencia+" "+simbolo);
			if(esq != null){
				esq.mostra();
			}
			if(dir != null){
				dir.mostra();
			}
			System.out.print(")");
		
	}
	
	/* Novo m�todo para imprimir os c�digos de Huffman de cada s�mbolo na �rvore. */
	public void mostraCodigo(String seq)

	{
        if (this.getEsq() == null && this.getDir() == null) {

 
            System.out.println(this.getSimbolo() + ":" + seq);
 
            return;
        }
        this.esq.mostraCodigo(seq + "0");
        this.dir.mostraCodigo(seq + "1");
    }
	
	/* Caso necess�rio, o grupo pode definir novos m�todos. */

	public char getSimbolo() {
		return simbolo;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public Arvbin getEsq() {
		return esq;
	}

	public Arvbin getDir() {
		return dir;
	}
}