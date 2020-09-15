import java.io.Serializable;
import java.util.Iterator;


public class ArvoreBinaria<E> implements Collection<E>, Serializable {

    protected Node<E> raiz;
    private int numElementos;

    private class ArvoreIterator<E> implements Iterator<E>{

        private Fila<E> fila;
        private NoSimpEnc<E> corrente;

        public ArvoreIterator(){
            fila = new Fila<E>();
            emOrdem((Node<E>) raiz);
            corrente = fila.noInicio();
        }

        public void emOrdem(Node<E> no){
            if (no != null){
                emOrdem(no.getEsq());
                fila.insert(no.getObj());
                emOrdem(no.getDir());
            }
        }

        public boolean hasNext() {
            if (size() == 0)
                return false;
            if (corrente == fila.noInicio())
                return true;
            if (corrente == null)
                return false;
            return true;
        }


        public E next() {
            if (corrente == null)
                corrente = fila.noInicio();
            E obj = corrente.getObj();
            corrente = corrente.getProx();
            return obj;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    public ArvoreBinaria() {
        numElementos = 0;
        raiz = null;
    }
    
	//tamanho
    public int size() {
        return numElementos;
    }

	//esta cheia
    public boolean isEmpty() {
        return (numElementos == 0);
    }

	//adicionando um Nó.
    public boolean add(E objeto) {
        int direcao = -1;
		Node<E> pai, p;
		p = raiz;
		pai = null;
		if (raiz != null) {
			while (true) {
                int c = ((Comparable<E>)objeto).compareTo(p.getObj());
				if (c == 0)
					return false;
				if (c < 0) {
					if (p.getEsq() == null) {
						pai = p;
						direcao = -1;
						break;
					}
					else
						p = p.getEsq();
				}
				else {
					if (p.getDir() == null) {
						pai = p;
						direcao = 1;
						break;
					}
					else
						p = p.getDir();
				}
			}
		}
		insert(objeto, pai, direcao);
        numElementos++;
		return true;
    }

	//inserir
    private Node<E> insert(E objeto, Node<E> noPai, int direcao) {
		Node<E> novoNo = new Node<E>(objeto);
		if (raiz == null) {
			raiz = novoNo;
			return novoNo;
		}
		if (noPai.getFilho(direcao) != null)
			return null;
		noPai.setFilho(direcao, novoNo);
		return novoNo;
	}

    //Buscando um No.
    public boolean contains(E objeto) {
        Node<E> no = raiz;
		while (no != null) {
            int c = ((Comparable<E>)objeto).compareTo(no.getObj());
			if (c == 0)
				return true;
			else
				if (c < 0)
					no = no.getEsq();
				else
					no = no.getDir();
		}
		return false;
    }

    //Removendo um No.
    public boolean remove(E objeto) {
        Node<E> pai, p;
		int direcao = -1;
		pai = null;
		p = raiz;
		while (p != null) {
            int c = ((Comparable<E>)objeto).compareTo(p.getObj());
			if (c == 0)
				break;
			pai = p;
			if (c < 0) {
				p = p.getEsq();
				direcao = -1;
			}
			else {
				p = p.getDir();
				direcao = 1;
			}
		}
		if (p == null)
			return false;
		if ((p.getDir() != null) && (p.getEsq() != null)) {
			Node<E> pTemp;
			pai = p;
			pTemp = p.getEsq();
			direcao = -1;
			while (pTemp.getDir() != null) {
				pai = pTemp;
				pTemp = pTemp.getDir();
				direcao = 1;
			}
			p.setObj(pTemp.getObj());
		}
		delete(pai, direcao);
        numElementos--;
		return true;
    }

    //Apagar
    private boolean delete(Node<E> pai, int direcao) {
		Node<E> filho;
		if (pai == null) {
			if ((raiz.getEsq() != null) && (raiz.getDir() != null))
				return false;
			if (raiz.getEsq() != null)
				raiz = raiz.getEsq();
			else
				raiz = raiz.getDir();
			return true;
		}
		else {
			filho = pai.getFilho(direcao);
			if (filho == null)
				return true;
			if ((filho.getEsq() != null) && (filho.getDir() != null))
				return false;
			if (filho.getEsq() != null)
				pai.setFilho(direcao, filho.getEsq());
			else
				pai.setFilho(direcao, filho.getDir());
			return true;
		}
	}

    public E retrieve(E objeto) {
        Node<E> no = raiz;
		while (no != null) {
            int c = ((Comparable<E>)objeto).compareTo(no.getObj());
			if (c == 0)
				return no.getObj();
			else
				if (c < 0)
					no = no.getEsq();
				else
					no = no.getDir();
		}
		return null;
    }

    public void clear() {
        raiz = null;
        numElementos = 0;
    }

    public Iterator<E> iterator() {
        return new ArvoreIterator<E>();
    }



}

