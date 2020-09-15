import java.io.Serializable;
import java.util.Comparator;

public class SortedArrayList<E> extends ArrayList<E> implements Serializable{
	private Comparator<E> comparador;

	public SortedArrayList(Comparator<E> comparador) {
		super();
		this.comparador = comparador;
	}
	
	public SortedArrayList(){
		super();
		comparador = null;
	}
	
	private int findPositionInsert(E objeto){
		int inicio, fim, meio, c;
		
		inicio = 0;
		fim    = size() - 1;
		
		while (inicio <= fim){
			meio = (inicio + fim)/2;
			if (comparador != null)
				c = comparador.compare(objeto, super.lista[meio]);
			else
				c = ((Comparable<E>)objeto).compareTo(super.lista[meio]);
			if (c > 0)
				inicio = meio + 1;
			else
				fim = meio - 1;
		}
		
		return inicio;				
	}
	
	@Override
	protected int indexOf(E objeto){
		int inicio, fim, meio, c;
		
		inicio = 0;
		fim    = size() - 1;
		
		while (inicio <= fim){
			meio = (inicio + fim)/2;
			if (comparador != null)
				c = comparador.compare(objeto, super.lista[meio]);
			else
				c = ((Comparable<E>)objeto).compareTo(super.lista[meio]);
			if (c == 0)
				return meio;
			if (c > 0)
				inicio = meio + 1;
			else
				fim = meio - 1;
		}
		
		return -1;		
	}
	
	private boolean add(int index, E objeto) {
		if (index < 0 || index > numItens)
			return false;
		redimensione();
		for (int j = numItens - 1; j >= index; j--)
			lista[j + 1] = lista[j];

		lista[index] = objeto;
		numItens++;
		return true;
	}
	
	@Override
	public boolean add(E objeto) {
		int posicao = findPositionInsert(objeto);
		return add(posicao, objeto);
	}
	
}
