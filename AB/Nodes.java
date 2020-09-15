class Node{

    private String nome;
    private Node filhoEsq;
    private Node filhoDir;
    private Node pai;


    //Construtos principal, recebe o conteudo e o pai do nó.
    public Node( String n, Node noPai){
        this.nome = n;
        this.pai = noPai;
        this.filhoDir = null;
        this.filhoEsq = null;
    }

    //Constror para a raiz
    public  Node( String n){
        this(n.null);
    }

    public  boolean temFilhoEsq(){
        if(filhoEsq == null)
        return false;
        else
        return true;
    }

    public boolean temFilhoDir(){
        if(filhoDir == null)
        return false;
        else
        return true;
    }

    public boolean ehFolha() {
		return (filhoEsq == null) && (filhoDir == null);
	}



}