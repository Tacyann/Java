import java.util.Stack;

public class ArvBin {
    
         private Node root;
         public int num;
	

	    // Metodo para retornar minha Raiz.
		public Node getRoot() {
			return root;
		}


	public void insert(int valor) {
		Node newNode = new Node(valor);
		if (this.root == null) {
                    this.root = newNode;
			return;
		} else {
		Node pai = root;
		Node paiAtual;
                    while (true) {
                    paiAtual = pai;
                    if (newNode.getValor() < paiAtual.getValor()) {
                     pai = paiAtual.getEsquerda();
                     if (pai == null) {
                     paiAtual.setEsquerda(newNode);
                      newNode.setPai(paiAtual);
                      return;
			}
                    } else if (newNode.getValor() > paiAtual.getValor()) {
			pai = paiAtual.getDireita();
			if (pai == null) {
			paiAtual.setDireita(newNode);
			newNode.setPai(paiAtual);
			return;
				}
				} else {
			pai = paiAtual.getDireita();
			if (pai == null) {
			paiAtual.setDireita(newNode);
			newNode.setPai(paiAtual);
			return;
				} else {
				if (newNode.getValor() < paiAtual.getValor()) {
				pai = paiAtual.getEsquerda();
				if (pai == null) {
				paiAtual.setEsquerda(newNode);
				newNode.setPai(paiAtual);
				return;
						}
                                } else if (newNode.getValor() > paiAtual.getValor()) {
                                pai = paiAtual.getDireita();
				if (pai == null) {
				paiAtual.setDireita(newNode);
				newNode.setPai(paiAtual);
				return;
		}
		}
                 }
	}
	}
		}

	}

	//Imprimir
	public void print() {
                System.out.println("Pré Ordem: ");
		preOrdem(this.root);
                    System.out.println("");
                System.out.println("Pós-Ordem: ");
		posOrdem(this.root);
                    System.out.println("");
		System.out.println("In-Ordem: ");
		inOrdem(this.root);
               System.out.println("");
		
	}

            private void inOrdem(Node node) {
		if (node != null) {
			inOrdem(node.getEsquerda());
			System.out.print(node.getValor() + " ");
			inOrdem(node.getDireita());
		}
	}

            private void preOrdem(Node node) {
		if (node != null) {
			System.out.print(node.getValor() + " ");
			preOrdem(node.getEsquerda());
			preOrdem(node.getDireita());
		}
	}

            private void posOrdem(Node node) {
		if (node != null) {
			posOrdem(node.getEsquerda());
			posOrdem(node.getDireita());
			System.out.print(node.getValor() + " ");
		}
	}

	public boolean remove(int valor) {
		Node pai = root;
		Node node = root;
		boolean paiEsquerda = true;

		while (node.getValor() != valor) {
			pai = node;
			if ((valor < node.getValor())) {
				paiEsquerda = true;
				node = node.getEsquerda();
			} else {
				paiEsquerda = false;
				node = node.getDireita();
			}
			if ( node == null) {
				return false;
			}
		}


		if (grauNode(node ) == 0) {
			if (node == root) {
				root = null;
			} else if (paiEsquerda) {
				pai.setEsquerda(null);
			} else {
				pai.setDireita(null);
			}
		} else if (grauNode(node) == 1) {
			if (node.getDireita() == null) {
				if (node == root) {
					root = node.getEsquerda();
				} else if (paiEsquerda) {
					pai.setEsquerda(node.getEsquerda());
				} else {
					pai.setDireita(node.getEsquerda());
				}
			} else if (node.getEsquerda() == null) {
				if (node == root) {
					root = node.getDireita();
				} else if (paiEsquerda) {
					pai.setEsquerda(node.getDireita());
				} else {
					pai.setDireita(node.getDireita());
				}
			}
		} else if (grauNode(node) == 2) {
			Node sucessor = getSucessor(node);
			if (node == root) {
				root = sucessor;
			} else if (paiEsquerda) {
				pai.setEsquerda(sucessor);
			} else {
				pai.setDireita(sucessor);
			}
			sucessor.setEsquerda(node.getEsquerda());
		}
		return true;
	}

	//metodo para guardar o proximo
	private Node getSucessor(Node node) {
		Node sucessor = node;
		Node sucessorPai = node;
		Node atual = node.getDireita();

		while (atual != null) {
			sucessorPai = sucessor;
			sucessor = atual;
			atual = atual.getEsquerda();
		}
		if (sucessor != node.getDireita()) {
			sucessorPai.setEsquerda(sucessor.getDireita());
			sucessor.setDireita(node.getDireita());
		}
		return sucessor;
	}

	//verificar o Grau do No
	private int grauNode(Node node) {
		int cont = 0;
		if (node == null) {
			return 0;
		} else {
			if (node.getEsquerda() != null) {
				cont++;
			}
			if (node.getDireita() != null) {
				cont++;
			}
			return cont;
		}
	}
	//metofdo para me retornar a altura
	public int height() {
		return heightAux(this.root) + 1;
	}

	//metodo para buscar a altura
	private int heightAux(Node node) {
		if (node == null)
			return -1;

		int esquerda = heightAux(node.getEsquerda());
		esquerda++;
		int direita = heightAux(node.getDireita());
		direita++;
		int max = Math.max(esquerda, direita);

		return max;
	}

	//media
	public double media() {
		return Soma(this.root) / qtd_nodes();
	}

	//metodo para calcular a soma
	private double Soma(Node node) {
		if (node == null)//verificar se o nó é nulo
			return 0;//caso seja vai me retornar vazio.
		else {
			int soma = 0; //inicializei a variavel soma com 0.
			soma += Soma(node.getEsquerda()); //vou incrementar o nó esquerdo.
			soma += Soma(node.getDireita()); //vou incrementar o nó diretito.
			soma += (long) node.getValor(); //juntar
			return soma; //retornar o valor;
		}
	}

	
	//metodo de busca
        public Node busca(int valor) {
		Node node = this.root;
		while (!(node.getValor() == valor)) {
			if (valor < node.getValor()) {
				node = node.getEsquerda();
			} else if (valor > node.getValor()) {
				node = node.getDireita();
			}
			if (node == null) {
				System.out.println(" valor nao existe na arvores");
                                break;
			}
		}
		return node;
	}
		
	//Contador
	public boolean count(int valor) {
		Node resultado = busca(valor);
		if (resultado != null) {
			return true;
		} else {
			return false;
		}
	}

	//Metodo me retorna o maior valor
	public long max() {
		return max(root).getValor();
	}

	//metodo para buscar o maior valor.
	private Node max(Node node) {
		if (node.getDireita() == null) { //verificando se no direito é igual a zero.
			return node;//retornar o no.
		} else {
			return max(node.getDireita()); //que o meu no dá direita vai ser o maior.
		}
	}

	//Metodo me retorna o menor valor
	public long small() {
		return small(this.root).getValor();
	}


	//metodo para buscar o menor valor.
	private Node small (Node node) {
		if (node.getEsquerda() == null) {//verificando se no esquerdo é igual a zero.
			return node; //retornar o no.
		} else {
			return small(node.getEsquerda()); //que o meu no dá esquerda vai ser o menor.
		}
	}

		//Metodo que vai me retornar um inteiro.
        public int qtd_nodes() {
		Node node = root; //Criar a variavel do tipo No passando a raiz.
		int qtd = 0; // criar uma váriavel e inicializei com 0.
		Stack<Node> pilha = new Stack<>(); //Criei uma pilha do tipo No.
		 //Enquanto a pilha for != 0 ou o nó for != vazio
        //Emptyretorna verdadeiro se a pilha tem elementos se não retorna falso.
		while (!pilha.isEmpty() || node != null) {
			if (node != null) { //verifico se o no é diferente de vazio.
			pilha.push(node);//Utilizar o método push para colocar o elemnto na pilha.
			node = node.getEsquerda();//vai guardar no nó esquerdo.
			} else {
			qtd++;//incrementar a quantidade.
			node= pilha.pop();// eu utilizar o metodo pop, para remover e retornar o elemento superior da pilha.
			node = node.getDireita();//e guarda-lo no nó direito.
			}
		}
		return qtd;
	}
		//metodo para me retornar a quantidade de folhas.
        public int qtd_leaves() {
		return leaves(this.root);
	}

	//metodo para encontrar a quantidade de folhas.	
	private int leaves(Node node) {
		if (node == null) //verifico se o no é vazio.
			return 0; //se for vai me retornar 0;
		if (node.getEsquerda() == null && node.getDireita() == null)
			return 1;
		return leaves (node.getEsquerda()) + leaves(node.getDireita());
	}
	
	
	//metodo de compara��o de 2 arvores
	public boolean isSimilar(ArvBin segunda) {
		return comparator(root, segunda.getRoot() );
	}

	private boolean comparator(Node primeira, Node segunda) {
		if (primeira == segunda)
			return true;
		if (primeira == null || segunda == null)
			return false;
		return ((primeira.getValor() == segunda.getValor())
				&& (comparator(primeira.getEsquerda(), segunda.getEsquerda()))
				&& (comparator(primeira.getDireita(), segunda.getDireita())));
	}



}


