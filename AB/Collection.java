import java.util.Iterator;

public interface Collection<E> {
	int size();
	boolean isEmpty();
	boolean add(E objeto);
	boolean contains(E objeto);
	boolean remove(E objeto);
	E retrieve(E objeto);
	void clear();
	Iterator<E> iterator();
}
