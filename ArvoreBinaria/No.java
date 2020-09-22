package ArvoreBinaria;

public class No {

    //atributios
    public int valor;
    public No esquerdo;
    public No direito;
    public No pai; //Fundamental para que eu possa trabalhar com a profundidade da arvoré.

    ///Meu Constutor para parametrizar e iniciar as minhas váriaveís.
    public No (int valor){
        this.valor = valor;
        this.direito = null;
        this.esquerdo = null;
        this.pai = null;

    }

     ///Meu Constutor
     public No (int valor, No esquerdo, No direito){
        this.valor = valor;
        this.direito = direito;
        this.esquerdo = esquerdo;

    }
    
}
