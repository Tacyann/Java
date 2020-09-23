package ArvoreBinaria;

import java.util.Stack;

public class ArvoreBinaria {
    No raiz;

    //Meu Construtor
    public ArvoreBinaria() {
        raiz = null;
   }


    //Meu Construtor
    public ArvoreBinaria(int valor){
        raiz = new No(valor);
    }

    //Metodo para retornar minha Raiz.
    public No getArvoreBinaria(){
        return raiz;
    }

    //Metodo para guardar o valor do Pai.
    public void getPai(int valor){
        No no = busca(valor);
        if(no.pai != null)
        System.out.print("O pai do nó " + valor + "é: "+ no.pai.valor);
        else
        System.out.print("O Nó " + valor + "é a raiz da Árvore.");
    }

    //Metodo Recursivo ou seja uma função dentro da outra(laço de Repetição).
    public void adicionarNo( No novoNo, No raiz){
        //Quando o nó, é maior que a raiz analisada.
        if(novoNo.valor > raiz.valor){
            //Se existir filho direito, não passa no if.
            if(raiz.direito!= null){
            adicionarNo(novoNo, raiz.direito);
            }else{
                raiz.direito = novoNo;
                raiz.direito.pai = raiz; //Como ele vai pecorrer dinamicamente, eu vou dizer que o pai desse nó direito vai ser a Raiz.
            } 
            //Se o nó é menor que a Raiz.
        } else {
            //Vai ser verdadeiro se existir um filho esquerdo.
            if(raiz.esquerdo != null){
            adicionarNo(novoNo, raiz.esquerdo);
            }else {
                raiz.esquerdo = novoNo;
                raiz.esquerdo.pai = raiz; //Como ele vai pecorrer dinamicamente, eu vou dizer que o pai desse nó esquerdo vai ser a Raiz.
            }
        }
    }

    /*Metodo de Busca para passando o valor a ser pesquisado e a raiz da árvore.
    public void busca (int valor){
        busca(this.raiz, valor);
    }*/


    //Metodo de Busca para pegar a minha Raiz e o valor passado como parametro.
    public No busca (int valor){
        return busca(this.raiz, valor);
    }


     /*Metodo Recursivo
     public void busca (No no, int valor){
        System.out.println("focando no nó"+ no.valor);

        //Primeira interação - Raiz
        if(no.valor == valor){
            System.out.println("O Nó"+valor+"foi encontrado.");
            //vou pecorrer o lado esquerdo agora.
        }else if((valor < no.valor)&&(no.esquerdo!= null)){
             busca(no.esquerdo, valor);
            //vou pecorrer o lado esquerdo agora.
        }else if((valor < no.valor)&&(no.direito!= null)){
           busca(no.direito, valor);
        }else{
            System.out.println("O Nó"+valor+" não foi encontrado.");
        }
    }*/

    //Metodo Recursivo
    public No busca (No no, int valor){
        System.out.println("Focando no nó "+ no.valor);

        //Primeira interação - Raiz
        if(no.valor == valor){
            System.out.println("O Nó "+valor+" foi encontrado.");
            return no;
            //vou pecorrer o lado esquerdo agora.
        }else if((valor < no.valor)&&(no.esquerdo!= null)){
            return busca(no.esquerdo, valor);
            //vou pecorrer o lado esquerdo agora.
        }else if((valor > no.valor)&&(no.direito!= null)){
            return busca(no.direito, valor);
        }else{
            System.out.println("O Nó "+valor+" não foi encontrado.");
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
            System.out.println("O grau do Nó "+ valor +" é zero.");
        }else if((noEncontrado.direito != null) && (noEncontrado.esquerdo != null)){ // é porque tem filho direito e filho esquerdo, logo o grau é 2.
            System.out.println("O grau do Nó "+ valor +" é dois.");
        }else{// Quando só tem um filho, logo o grau é 1.
            System.out.println("O grau do Nó "+ valor +" é um.");
        }
    }
    
    

    public void verificaAltura(int valor){
        No noEncontrado = busca(valor);
        System.out.println("O Altura do Nó "+ valor + " é : " + verificaAltura(noEncontrado));
    }


    //Sobrecarga, são metodos com o mesmo nome porém com parametros diferentes.
    public int verificaAltura(No no){
        if(no == null){
            return -1; //Vai sempre me indicar que o nó não existe.
        }else if(no.direito == null && no.esquerdo == null){//Se ele não tem nem filho direito e nem filho esquero então ele é Folha.
            return 0;
        }else if(no.direito == null){ // Eu vou incrementando a medida que eu vou encontrando Nós, na minha Busca.
            return verificaAltura(no.esquerdo) + 1; //Aplicando a Recursividade ao utilizar o mesmo metodo.
        }else if (no.esquerdo == null){
            return verificaAltura(no.direito) + 1;
        }else{
            return Math.max(verificaAltura(no.esquerdo), verificaAltura(no.direito)) + 1;
        }
    }

    public void verificarProfundidade(int valor){
        No noEncontrado = busca(valor); //Armezenar esse nó na váriavel noEncontrado
        System.out.println("A Profundidade do Nó "+ valor + " é : " + verificarProfundidade(noEncontrado));
    }

    //Através do Metodo de Recursividade, ele vai somando o valor.
    public int verificarProfundidade(No no){
        if(no == null)
        return -1;
        else
        return verificarProfundidade(no.pai) + 1;
    } 

    /*Tres condicoes:
    1.Quando é folha, o nó removido não tem filhos.
    2.Quando tem somente um filho(esquerdo ou direito)
    3.Quando tem 2 filhos, dai variamos para Arvore Binaria de Busca e podemos Remover o nó.
    */
    
    public void verificarNivel(int valor){
        No noEncontrado = busca(valor); //Armezenar esse nó na váriavel noEncontrado
        System.out.println("A Nível do Nó "+ valor + " é : " + verificarNivel(noEncontrado));
    }

    //Metodo Recursivo    
    public int verificarNivel( No no){
        if( no == null)
        return -1;
        else
        return verificarNivel(no.pai) + 1;

    }

    public double media() {
		return Soma(this.raiz) / qtd_no();
	}

	private double Soma(No no) {
		if (no == null)
			return 0;
		else {
			int soma = 0;
			soma += Soma(no.getEsquerdo());
			soma += Soma(no.getDireito());
			soma += (long) no.getValor();
			return soma;
		}
    }
    
    public int qtd_no() {
		No no = raiz;
		int qtd = 0;
		Stack<No> pilha = new Stack<>();
		while (!pilha.isEmpty() || no != null) {
			if (no != null) {
			pilha.push(no);
			no = no.getEsquerdo();
			} else {
			qtd++;
			no = pilha.pop();
			no = no.getDireito();
			}
		}
		return qtd;
	}

    
    //Imprimir em Ordem.
    public void imprimirEmOrdem(No raiz){
        if(raiz == null) return; //Parada
        imprimirEmOrdem(raiz.esquerdo);
        System.out.print(raiz.valor + "\t");// imprimo um do lado do outro.
        //System.out.print(raiz.valor + "\t");Desse jeito eu vou imprimir, um embaixo do outro.
        imprimirEmOrdem(raiz.direito);

    }

    //Imprimir em Pre-Ordem.
    public void imprimirPreOrdem(No raiz){
        if(raiz == null) return;
        System.out.print(raiz.valor + "\t");
        imprimirPreOrdem(raiz.esquerdo);
        imprimirPreOrdem(raiz.direito);
    }

    //Imprimir em Pos-Ordem.
    public void imprimirPosOrdem(No raiz){
        if(raiz == null) return;
        imprimirPosOrdem(raiz.esquerdo);
        imprimirPosOrdem(raiz.direito);
        System.out.print(raiz.valor + "\t");
    }



        
}
