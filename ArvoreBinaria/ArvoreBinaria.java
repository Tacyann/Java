package ArvoreBinaria;

import java.util.Stack;

public class ArvoreBinaria {
    No raiz;

    // Meu Construtor
    public ArvoreBinaria() {
        raiz = null;
    }

    // Meu Construtor
    public ArvoreBinaria(int valor) {
        raiz = new No(valor);
    }

    // Metodo para retornar minha Raiz.
    public No getArvoreBinaria() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    // Metodo para guardar o valor do Pai.
    public void getPai(int valor) {
        No no = busca(valor);
        if (no.pai != null) //Ele não é a Raiz.
            System.out.print("O pai do nó " + valor + "é: " + no.pai.valor);
        else
            System.out.print("O Nó " + valor + "é a raiz da Árvore.");
    }

    // Metodo Recursivo ou seja uma função dentro da outra(laço de Repetição).
    public void adicionarNo(No novoNo, No raiz) {
        // Quando o nó, é maior que a raiz analisada.
        if (novoNo.valor > raiz.valor) {
            // Se existir filho direito, não passa no if.
            if (raiz.direito != null) {
                adicionarNo(novoNo, raiz.direito);
            } else {
                raiz.direito = novoNo;
                raiz.direito.pai = raiz; // Como ele vai pecorrer dinamicamente, eu vou dizer que o pai desse nó direito
                                         // vai ser a Raiz.
            }
            // Se o nó é menor que a Raiz.
        } else {
            // Vai ser verdadeiro se existir um filho esquerdo.
            if (raiz.esquerdo != null) {
                adicionarNo(novoNo, raiz.esquerdo);
            } else {
                raiz.esquerdo = novoNo;
                raiz.esquerdo.pai = raiz; // Como ele vai pecorrer dinamicamente, eu vou dizer que o pai desse nó
                                          // esquerdo vai ser a Raiz.
            }
        }
    }

    /*
     * Metodo de Busca para passando o valor a ser pesquisado e a raiz da árvore.
     * public void busca (int valor){ busca(this.raiz, valor); }
     */

    // Metodo de Busca para pegar a minha Raiz e mandar o valor que eu tô procurando pro meu metodo Recursivo.
    public No busca(int valor) {
        return busca(this.raiz, valor);
    }

    /*
     * Metodo Recursivo public void busca (No no, int valor){
     * System.out.println("focando no nó"+ no.valor); //Primeira interação - Raiz
     * if(no.valor == valor){ System.out.println("O Nó"+valor+"foi encontrado.");
     * //vou pecorrer o lado esquerdo agora. }else if((valor <
     * no.valor)&&(no.esquerdo!= null)){ busca(no.esquerdo, valor); //vou pecorrer o
     * lado esquerdo agora. }else if((valor < no.valor)&&(no.direito!= null)){
     * busca(no.direito, valor); }else{
     * System.out.println("O Nó"+valor+" não foi encontrado."); } }
     */


    // Metodo Recursivo - ele vai receber a Raiz e o valor a ser buscado.
    public No busca(No no, int valor) {
        // O nó que eu estou setando no momento é o nó ....
        System.out.println("Focando no nó " + no.valor);

        // Primeira interação - Raiz - Verificando se a minha raiz.
        if (no.valor == valor) { // Tô verificando se o nó que eu tô setando, foi o que foi passado pelo parametro.
            System.out.println("O Nó " + valor + " foi encontrado.");
            return no;
            // vou pecorrer o lado esquerdo agora.
        } else if ((valor < no.valor) && (no.esquerdo != null)) { //Se o valor que eu tô buscando for menor que o valor setado e tenha alguem do lado esquerdo porque senão eu vou ter uma folha.
            return busca(no.esquerdo, valor);// aqui eu vou usar a recursividade
            // vou pecorrer o lado direito agora.
        } else if ((valor > no.valor) && (no.direito != null)) {//Se o valor que eu tô buscando for maior que o valor setado e tenha alguem do lado direito(Vai ter pelo menos um filho).
            return busca(no.direito, valor);// aqui eu vou usar a recursividade
        } else {//ultima condição a SubArvore é Nula.
            System.out.println("O Nó " + valor + " não foi encontrado.");
            return null; // não foi enocntrado nenhum nó.
        }
    }

    // Verificar o grau da Árvore
    public void verificargrau(int valor) {
        // buscar na minha Árvore o nó.
        No noEncontrado = busca(valor);

        if (noEncontrado == null) { //Quando ele me retornar Null.
            System.out.println("O valor informado, não existe na Árvore.");
        } else if ((noEncontrado.direito == null) && (noEncontrado.esquerdo == null)) { // Se é folha, o grau é 0.
            System.out.println("O grau do Nó " + valor + " é zero.");
        } else if ((noEncontrado.direito != null) && (noEncontrado.esquerdo != null)) { // é porque tem filho direito e filho esquerdo, logo o grau é 2.
            System.out.println("O grau do Nó " + valor + " é dois.");
        } else { // Quando só tem um filho, logo o grau é 1.
            System.out.println("O grau do Nó " + valor + " é um.");
        }
    }


    public void verificaAltura(int valor) {
        No noEncontrado = busca(valor); //Vou armazenar esse valor encontrado.
        System.out.println("O Altura do Nó " + valor + " é : " + verificaAltura(noEncontrado));
    }

    // Sobrecarga, são metodos com o mesmo nome porém com parametros diferentes.
    public int verificaAltura(No no) {
        if (no == null) {
            return -1; // Vai sempre me indicar que o nó não existe.
        } else if (no.direito == null && no.esquerdo == null) {// Se ele não tem nem filho direito e nem filho esquero
                                                               // então ele é Folha.
            return 0;
        } else if (no.direito == null) { // Se o nó que eu tô apontando,não tem filho direito uu vou incrementando a altura do filho esquerdo a medida que eu vou encontrando Nós, na minha Busca.
            return verificaAltura(no.esquerdo) + 1; // Aplicando a Recursividade ao utilizar o mesmo metodo.
        } else if (no.esquerdo == null) { // Se o nó que eu tô apontando,não tem filho esquerdo uu vou incrementando a altura do filho direito a medida que eu vou encontrando Nós, na minha Busca.
            return verificaAltura(no.direito) + 1;// Aplicando a Recursividade ao utilizar o mesmo metodo.
        } else {
            return Math.max(verificaAltura(no.esquerdo), verificaAltura(no.direito)) + 1;//Utilizei a classe Math do Java, passando dois parametros e incremetando em 1.
        }
    }

    public void verificarProfundidade(int valor) {
        No noEncontrado = busca(valor); // Armezenar esse nó na váriavel noEncontrado
        System.out.println("A Profundidade do Nó " + valor + " é : " + verificarProfundidade(noEncontrado));
    }

    // Através do Metodo de Recursividade, ele vai somando o valor.
    public int verificarProfundidade(No no) {
        if (no == null)//se ele for null.
            return -1; //Eu pecorri tudo o que eu queria.
        else //Retornar a chamada do proprio metodo.
            return verificarProfundidade(no.pai) + 1; //vou incrementar porque nesse caso vai funcionar como se fosse um contador, passando o pai.
    }

    /*
     * Tres condicoes: 1.Quando é folha, o nó removido não tem filhos. 2.Quando tem
     * somente um filho(esquerdo ou direito) 3.Quando tem 2 filhos, dai variamos
     * para Arvore Binaria de Busca e podemos Remover o nó.
     */
    // Criei um Metodo Remover onde eu passo o valor do nó como parametro.
    public void remover(int valor) {
        remover(raiz, valor);
    }

    public No remover(No no, int valor) {
        // Verificar se a raiz tem arvore.
        if (no != null) {
            if (valor < no.valor) { // Se o valor que eu passei como parametro for menor que a raiz que eu tô
                                    // apontando.
                no.esquerdo = remover(no.esquerdo, valor); // Se o valor for menor que o valor da raiz, ele vai receber
                                                           // como nó esquerdo um nova chamada.
            } else if (valor > no.valor) {
                no.direito = remover(no.direito, valor); // Agora a minha raiz, passa a ser o nó direito.
            } // Ele tem filho direito e esquerdo
            else if (no.esquerdo != null && no.direito != null) {
                System.out.println("O nó " + no.valor + " foi removido.");
                // Vou escolher um sub nó da arvoré direita e tem que ser o Menor. (Consultando
                // o Menor, porque todo os elemesntos do lado direito são maiores)
                no.valor = getMenor(no.direito).valor;
                // Agora eu vou remover esse nó.
                no.direito = removeMenor(no.direito);
                // Encontrei o menor filho da subArvore direita e troquei pelo nó que eu quero
                // remover.
            } else if (no.esquerdo == null) { // Se ele não tiver filho esquerdo.
                no = no.direito; // Logo o nó passa a ser o direito.
            } else if (no.direito == null) { // quando o direito é nulo.
                no = no.esquerdo;
            }
            // Se o valor for diferente da minha raiz.
            if (valor != this.raiz.valor) {
                return no;
            } else {
                System.out.println("A raiz foi Apagada.");
                // Se o nó a ser removido, for a minha raiz e ela não tiver nenhum filho.
                this.raiz.valor = 0;
                return no = null;
            }
        } else {
            System.out.println("O Nó não existe na Árvore!");
            return null;
        }

    }

    // Metodo para descobrir quem é o Menor.
    public No getMenor(No no) {
        // Verificar se ele existe.
        if (no != null) {
            // Enquanto existir um nó.
            while (no.esquerdo != null) {
                no = no.esquerdo; // Vou fazer só uma atribuição.
            }
        }
        return no;
    }

    public No removeMenor(No no) {
        // Verificar se ele existe.
        if (no == null) {
            System.out.println("Erro, o nó não existe!");
        } else if (no.esquerdo != null) { // Verificando que o nó esquerdo existe.
            no.esquerdo = removeMenor(no.esquerdo); // Vai retonar a chamado do metodo Recursivo ou seja uma nova
                                                    // chamada do nó esquerdo.
            return no; // Retorno esse nó.
        } else {
            return no.direito; // me retorna o nó direito.
        }
        return null; // Se for folha ele me retorna nulo.
    }

    // Criei um Metodo verificarNivel onde eu passo o valor do nó como parametro.
    public void verificarNivel(int valor) {
        No noEncontrado = busca(valor); // Armezenar esse nó na váriavel noEncontrado
        System.out.println("A Nível do Nó " + valor + " é : " + verificarNivel(noEncontrado));
    }

    // Metodo Recursivo
    public int verificarNivel(No no) {
        if (no == null)
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

    // Imprimir em Ordem.
    public void imprimirEmOrdem(No raiz) {
        if (raiz == null)
            return; // Parada
        imprimirEmOrdem(raiz.esquerdo);
        System.out.print(raiz.valor + "\t");// imprimo um do lado do outro.
        // System.out.print(raiz.valor + "\t");Desse jeito eu vou imprimir, um embaixo
        // do outro.
        imprimirEmOrdem(raiz.direito);

    }

    // Imprimir em Pre-Ordem.
    public void imprimirPreOrdem(No raiz) {
        if (raiz == null)
            return;
        System.out.print(raiz.valor + "\t");
        imprimirPreOrdem(raiz.esquerdo);
        imprimirPreOrdem(raiz.direito);
    }

    // Imprimir em Pos-Ordem.
    public void imprimirPosOrdem(No raiz) {
        if (raiz == null)
            return;
        imprimirPosOrdem(raiz.esquerdo);
        imprimirPosOrdem(raiz.direito);
        System.out.print(raiz.valor + "\t");
    }

}