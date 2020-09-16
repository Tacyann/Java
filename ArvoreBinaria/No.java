package ArvoreBinaria;

public class No {

    //atributios
    public int valor;
    public No esquerdo;
    public No direito;

    ///Meu Constutor
    public No(int valor){
        this.valor = valor;
        this.direito = null;
        this.esquerdo = null;

    }

     ///Meu Constutor
     public No(int valor, No esquerdo, No direito){
        this.valor = valor;
        this.direito = esquerdo;
        this.esquerdo = direito;

    }
    
}
