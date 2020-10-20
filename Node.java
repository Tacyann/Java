
public class Node
{
        public long valor;
	public Node direita, esquerda, pai;

	public Node(long valor) {
		this.valor = valor;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Node getDireita() {
		return direita;
	}

	public void setDireita(Node direita) {
		this.direita = direita;
	}
	public Node getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

}

