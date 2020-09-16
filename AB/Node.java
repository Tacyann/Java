package AB;
public class Node{

    //Criei um atributo denominado valor do tipo inteiro e dois apontadores Direita e Esquerda.
    int valor;
    Node NodeEsquerda;
    Node NodeDireita;
    int maisAlto;

    //Criando um Construtor que irá receber o atributo valor.
    public Node(int valor) {
        this.valor = valor;
    }

    //-------ArvoreBinaria------------

    //Criando o apontador Raiz.
    public static Node raiz;

    //Esse método vai inserir o valor eu quero inserir na minha arvore( ou seja do usuário).
    public static void inserir(int valor) {
        inserir(raiz, valor);
    }

    //Eu vou começar a procurar sempre pela Raiz e aprtir dela é que eu vou inserir os elementos da minha árvore.
    public static void inserir(Node no, int valor) {
        if (no == null) { //Verifica se a árvore está vazia.
            System.out.println("Raiz " + valor);
            raiz = new Node(valor);//Ou seja o meu Construtuor lá em cima.
        } else {
            if (valor < no.valor) {//Se o valor que estamos avaliando for menor que p nó, colocamos a esquerda.
                if (no.NodeEsquerda != null) {
                    inserir(no.NodeEsquerda, valor);
                    //Inserindo com Recursividade.
                } else {
                    System.out.println("Inserindo " + valor + " a esquerda de " + no.valor);
                    no.NodeEsquerda = new Node(valor);
                }

            } else {
                if (no.NodeDireita != null) { 
                    //verificando se existe um filho criado.
                    inserir(no.NodeDireita, valor);
                } else {
                    System.out.println("Inserindo " + valor + " a direita de " + no.valor);
                    no.NodeDireita = new Node(valor);
                }
            }
        }
    }

    public static void preordem(Node no) {
        if (no != null) {
            System.out.print(no.valor + ", ");
            preordem(no.NodeEsquerda);
            preordem(no.NodeDireita);

        }
    }

    public static void posordem(Node no) {
        if (no != null) {

            posordem(no.NodeEsquerda);
            posordem(no.NodeDireita);
            System.out.print(no.valor + ", ");

        }

    }

    public static void ordem(Node no) {
        if (no != null) {
            ordem(no.NodeEsquerda);
            System.out.print(no.valor + ", ");
            ordem(no.NodeDireita);
        }
    }

    public boolean ehfolha() {
        return (NodeEsquerda == null) && (NodeDireita == null);
    }

    
    public static void main(String[] args) {

        inserir(10);
        inserir(4);
        inserir(15);
        inserir(5);
        inserir(2);

    }

}