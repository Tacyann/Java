import java.io.Serializable;
import java.util.Comparator;


public class Fila<E> implements Serializable{
    private NoSimpEnc<E> inicio;
    private NoSimpEnc<E> fim;
    private NoSimpEnc<E> noCorrente;
    private int numElementos;

    public void insert(E obj){
        NoSimpEnc<E> novoNo = new NoSimpEnc<E>(obj);
        if (inicio == null){
            fim = novoNo;
            inicio = fim;
        }
        else {
            fim.setProx(novoNo);
            fim = novoNo;
        }
        numElementos++;
    }

    public E removeObj(E obj, Comparator<E> c){
        int co;
        E objAux = null;
        NoSimpEnc<E> p = inicio;
        NoSimpEnc<E> pAnt = null;
        while (p != null){
            co = c.compare(obj, p.getObj());
            if (co == 0) {
                if (p == inicio){
                    objAux = inicio.getObj();
                    inicio = inicio.getProx();
                }   
                else {
                    pAnt.setProx(p.getProx());
                    p = null;
                }
                numElementos--;
                return objAux;
            }
            else {
                pAnt = p;
                p = p.getProx();
            }
        }
        return null;
    }

    public E removeFirst() {
        if (inicio != null){
            E obj = inicio.getObj();
            inicio = inicio.getProx();
            numElementos--;
            return obj;
        }
        return null;
    }

    public boolean isEmpty(){
        return numElementos == 0;
    }

    public int lenght(){
        return numElementos;
    }

    public void clear(){
        inicio = null;
        fim = null;
        numElementos = 0;
    }

    public E getFirst(){
        noCorrente = inicio;
        if (noCorrente == null)
            return null;
        return noCorrente.getObj();
    }

    public E getNext(){
        noCorrente = noCorrente.getProx();
        if (noCorrente == null)
            return null;
        return noCorrente.getObj();
    }

    public NoSimpEnc<E> noInicio(){
        return inicio;
    }
}
