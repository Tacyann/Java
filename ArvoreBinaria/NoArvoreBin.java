import java.io.Serializable;

public class NoArvoreBin<E> implements Serializable{
	
	private E obj;
	private NoArvoreBin<E> esq;
	private NoArvoreBin<E> dir;

	public NoArvoreBin(E obj) {
		this.obj = obj;
		this.esq = null;
		this.dir = null;
	}

	public NoArvoreBin(E obj, NoArvoreBin<E> esq, NoArvoreBin<E> dir) {
		this.obj = obj;
		this.esq = esq;
		this.dir = dir;
	}

	public E getObj() {
		return obj;
	}

	public NoArvoreBin<E> getEsq() {
		return esq;
	}

	public NoArvoreBin<E> getDir() {
		return dir;
	}

	public boolean ehFolha() {
		return (esq == null) && (dir == null);
	}

	public void setObj(E obj) {
		this.obj = obj;
	}

	public void setEsq(NoArvoreBin<E> esq) {
		this.esq = esq;
	}

	public void setDir(NoArvoreBin<E> dir) {
		this.dir = dir;
	}

	public NoArvoreBin<E> getFilho(int direcao) {
		if (direcao < 0)
			return esq;
		else
			return dir;
	}

	public void setFilho(int direcao, NoArvoreBin<E> filho) {
		if (direcao < 0)
			esq = filho;
		else
			dir = filho;
	}

}
