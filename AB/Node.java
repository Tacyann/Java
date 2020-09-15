import java.io.Serializable;

public class Node<E> implements Serializable{
	
	private E obj;
	private Node<E> esq;
	private Node<E> dir;

	public Node(E obj) {
		this.obj = obj;
		this.esq = null;
		this.dir = null;
	}

	public Node(E obj, Node<E> esq, Node<E> dir) {
		this.obj = obj;
		this.esq = esq;
		this.dir = dir;
	}

	public E getObj() {
		return obj;
	}

	public Node<E> getEsq() {
		return esq;
	}

	public Node<E> getDir() {
		return dir;
	}

	public boolean ehFolha() {
		return (esq == null) && (dir == null);
	}

	public void setObj(E obj) {
		this.obj = obj;
	}

	public void setEsq Node<E> esq) {
		this.esq = esq;
	}

	public void setDir Node<E> dir) {
		this.dir = dir;
	}

	public Node<E> getFilho(int direcao) {
		if (direcao < 0)
			return esq;
		else
			return dir;
	}

	public void setFilho(int direcao, Node<E> filho) {
		if (direcao < 0)
			esq = filho;
		else
			dir = filho;
	}

}
