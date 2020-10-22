public class ArvoreBinComparator {

    //criei dois No para comparar.
    Node Noprimeira;
    Node Nosegunda;


    //Construtor, passando a raiz como vazia.
    public ArvoreBinComparator( Node Noprimeira, Node Nosegunda) {
        this.Noprimeira = Noprimeira;
        this.Nosegunda = Nosegunda;
   }


   //um método tipo "isSimilar" que retorna um boolean,
   //o qual vai varrer as 2 arvores e comparando os nós.
   public boolean isSimilar(){
       //Verificando se elas são vazias ou se elas não são vazias,
    if(((Noprimeira== null) && (Nosegunda!=null)) || (( Noprimeira!= null) && (Nosegunda==null)))
       return false;
       else if (((Noprimeira.esquerda == null) && (Nosegunda.esquerda!=null)) || (( Noprimeira.esquerda!= null) && (Nosegunda.esquerda==null))){
        return true;
       } else if (((Noprimeira.direita == null) && (Nosegunda.direita!=null)) || (( Noprimeira.direita!= null) && (Nosegunda.direita ==null))){
        return true;
       } else if (((Noprimeira.direita == Nosegunda.direita)) && (( Noprimeira.esquerda == Nosegunda.direita))){
        
        return true;
       }
       return false;
 } 
}
