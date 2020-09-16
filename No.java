public class No {

    int valor;
    No NoEsquerda, NoDireita;
    int maisAlto;

    public No(int valor) {
        this.valor = valor;
    }
    public static No raiz;

    public static void inserir(int valor) {
        inserir(raiz, valor);
    }

    //Eu vou começar a procurar sempre pela Raiz.
    public static void inserir(No Node, int valor) {
        if (Node == null) { 
            //Verifica sé o Nó é diferente de null.
            System.out.println("Raiz " + valor);
            raiz = new No(valor);
        } else {
            if (valor < Node.valor) {
                if (Node.NoEsquerda != null) {
                    //Inserindo com Recursividade.
                    inserir(Node.NoEsquerda, valor);              
                } else {
                    System.out.println("Inserindo " + valor + " a esquerda de " + Node.valor);
                    Node.NoEsquerda = new No(valor);
                }

            } else {
                if (Node.NoDireita != null) { 
                    //verificando se existe um filho criado.
                    inserir(Node.NoDireita, valor);
                } else {
                    System.out.println("Inserindo " + valor + " a direita de " + Node.valor);
                    Node.NoDireita = new No(valor);
                }
            }
        }
    }

    public static void preordem(No Node) {
        if (Node != null) {
            System.out.print(Node.valor + ", ");
            preordem(Node.NoEsquerda);
            preordem(Node.NoDireita);

        }
    }

    public static void posordem(No Node) {
        if (Node != null) {

            posordem(Node.NoEsquerda);
            posordem(Node.NoDireita);
            System.out.print(Node.valor + ", ");

        }

    }

    public static void ordem(No Node) {
        if (Node != null) {
            ordem(Node.NoEsquerda);
            System.out.print(Node.valor + ", ");
            ordem(Node.NoDireita);

        }
    }

    
    public static void main(String[] args) {

        inserir(10);
        inserir(4);
        inserir(15);
        inserir(5);
        inserir(2);

    }

}