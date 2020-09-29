package ArvoreBinaria;

public class No {

    //atributios
    public int valor;
    public No esquerdo;
    public No direito;
    public No pai; //Fundamental para que eu possa trabalhar com a profundidade da arvoré.

    ///Meu Constutor para parametrizar e iniciar as minhas váriaveís - Utilizei no metodo Profundidade.
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

    public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

    public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}
	public No getEsquerdo() {
		return esquerdo;
	}
	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}


    
}