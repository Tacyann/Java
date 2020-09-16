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
    
    public boolean insere (Node noPai, String info, char tipoFilho){
        Node aux;
        boolean Ok = false;
        //To inserindo o nó raiz.
        if(noPai == null){
            aux = new Node(info);
            raiz = aux;
            Ok = true;

        }else{
            if(tipoFilho =='E')&& (noPai.temFilhoEsq()){
                System.out.printl("***ERRO: Já possui filho esquerdo!");
                Ok = false;

                if((tipoFilho =='D')&&(noPai.temFilhoDir())){
                    System.out.printl("***ERRO: Já possui filho direito!");
                    Ok = false;
                    return false;  
                }
                aux = new Node(info.noPai);

                if(tipoFilho =='E')
                noPai.insFilhoEsq(aux);
                else
                noPai.insFilhoDir(aux);
                Ok=true;
            }
            return Ok;
        }
    }

}

public static void mani(String [] args){
 insere(10);
 insere(4);
 insere(15);
 insere(5);
    
}