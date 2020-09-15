import java.io.Serializable;
import java.util.Iterator;

public class ArrayList<E> implements Collection<E>, Serializable {
	
	private class ArrayListIterador implements Iterator<E> {

		private int corrente;
		
		public ArrayListIterador(){
			corrente = -1;
		}
		
		@Override
		public boolean hasNext() {
			if (corrente+1 == size())
				return false;
			else
				return true;
		}

		@Override
		public E next() {
			corrente++;
			return lista[corrente];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	private static final int DEFAULT_CAPACITY = 10;
	protected E[] lista;
	protected int incremento, capacidadeInicial;
	protected int numItens;
	
	public ArrayList() {
		lista = (E[]) new Object[DEFAULT_CAPACITY];
		incremento = 10;
		capacidadeInicial = DEFAULT_CAPACITY;
	}

	public ArrayList(int capacidadeInicial) {
		lista = (E[]) new Object[capacidadeInicial];
		this.incremento = 10;
		this.capacidadeInicial = capacidadeInicial;
	}

	public ArrayList(int capacidadeInicial, int incremento) {
		lista = (E[]) new Object[capacidadeInicial];
		this.incremento = incremento;
		this.capacidadeInicial = capacidadeInicial;
	}
	
	protected void redimensione() {
		if (size() == lista.length) {
			E[] novoVetor = (E[]) new Object[size() + incremento];
			System.arraycopy(lista, 0, novoVetor, 0, size());
			lista = novoVetor;
		}
	}

	protected int indexOf(E objeto) {
		for (int i = 0; i < numItens; i++) {
			if (objeto.equals(lista[i]))
				return i;
		}
		return -1;
	}

	private E remove(int index) {
		if (index < 0 || index > numItens - 1)
			return null;
		E temp = lista[index];

		while (index < numItens - 1) {
			lista[index] = lista[index + 1];
			index++;
		}

		lista[--numItens] = null;
		return temp;
	}

	@Override
	public boolean add(E objeto) {
		redimensione();
		lista[numItens++] = objeto;
		return true;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size(); i++) {
			lista[i] = null;
		}
		lista = (E[]) new Object[capacidadeInicial];
		numItens = 0;
	}

	@Override
	public boolean contains(E objeto) {
		return indexOf(objeto) != -1;
	}

	@Override
	public boolean isEmpty() {
		return (numItens == 0);
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterador();
	}

	@Override
	public boolean remove(E objeto) {
		int pos = indexOf(objeto);
		if (pos == -1)
			return false;
		remove(pos);
		return true;
	}

	@Override
	public int size() {
		return numItens;
	}

	@Override
	public E retrieve(E objeto) {
		int indice = indexOf(objeto);
		if (indice == -1)
			return null;
		return lista[indice];
	}

}
