import java.io.Serializable;


public class NoSimpEnc<E> implements Serializable{
    E obj;
    NoSimpEnc<E> prox;

    public NoSimpEnc(E obj, NoSimpEnc<E> prox) {
        this.obj = obj;
        this.prox = prox;
    }

    public NoSimpEnc(E obj) {
        this.obj = obj;
        this.prox = null;
    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public NoSimpEnc<E> getProx() {
        return prox;
    }

    public void setProx(NoSimpEnc<E> prox) {
        this.prox = prox;
    }

}
