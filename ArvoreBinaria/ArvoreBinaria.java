public class ArvoreBinaria {
    No raiz;

    //Meu Construtor
    public ArvoreBinaria(int valor){
        raiz = new No(valor);
    }

    //Metodo para retornar minha Raiz.
    public No getArvoreBinaria(){
        return raiz;
    }

    //Metodo Recursivo ou seja uma função dentro da outra(laço de Repetição).
    public void inserirNo( No novoNo, No raiz){
        //Quando o nó, é maior que a raiz analisada.
        if(novoNo.valor > raiz.valor){
            //Se existir filho direito, não passa no if.
            if(raiz.direito!= null)
            inserirNo(novoNo, raiz.direito);
            else raiz.direito = novoNo;
            //Se o nó é menor que a Raiz.
        } else {
            //é porque existe filho esquerde por isso é verdadeiro.
            if(raiz.esquerdo != null)
            inserirNo(novoNo, raiz.esquerdo);
            else raiz.esquerdo = novoNo;
        }
    }


    //Metodo de Busca para pegar a minha Raiz e o valor passado como parametro.
    public No busca (int valor){
        return busca(this.raiz, valor);
    }


    //Metodo Recursivo
    public No busca (No no, int valor){
        System.out.println("focando no nó"+ no.valor);

        //Primeira interação - Raiz
        if(no.valor == valor){
            System.out.println("O Nó"+valor+"foi encontrado.");
            return no;
            //vou pecorrer o lado esquerdo agora.
        }else if((valor < no.valor)&&(no.esquerdo!= null)){
            return busca(no.esquerdo, valor);
            //vou pecorrer o lado esquerdo agora.
        }else if((valor < no.valor)&&(no.direito!= null)){
            return busca(no.direito, valor);
        }else{
            System.out.println("O Nó"+valor+" não foi encontrado.");
            return null; //não foi enocntrado nenhum nó.
        }
    }

    //Verificar o grau da Árvore
    public void verificargrau(int valor){
        //buscar na minha Árvore o nó.
        No noEncontrado = busca(valor);

        if(noEncontrado == null){
            System.out.println("O valor informado, não existe na Árvore.");
        }else if((noEncontrado.direito == null) && (noEncontrado.esquerdo == null)){ //Se é folha, o grau é 0.
            System.out.println("O grau do Nó "+ valor +"é zero.");
        }else if((noEncontrado.direito != null) && (noEncontrado.esquerdo != null)){ // é porque tem filho direito e filho esquerdo, logo o grau é 2.
            System.out.println("O grau do Nó "+ valor +"é dois.");
        }else{// Quando só tem um filho, logo o grau é 1.
            System.out.println("O grau do Nó "+ valor +"é um.");
        }
    }

    //Imprimir em Ordem.
    public void imprimirEmOrdem(No raiz){
        if(raiz == null) return; //Parada
    }

    
}
