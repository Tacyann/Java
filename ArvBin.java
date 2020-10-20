
import java.util.Stack;

public class ArvBin {
    
        private  Node root;
         public int num;
	
	public ArvBin() {
		 root = null;
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
	
	public int height() {
		return heightAux(this.root) + 1;
	}

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

	
	public double media() {
		return Soma(this.root) / qtd_nodes();
	}

	private double Soma(Node node) {
		if (node == null)
			return 0;
		else {
			int soma = 0;
			soma += Soma(node.getEsquerda());
			soma += Soma(node.getDireita());
			soma += (long) node.getValor();
			return soma;
		}
	}

	
	

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
        
	public boolean count(int valor) {
		Node resultado = busca(valor);
		if (resultado != null) {
			return true;
		} else {
			return false;
		}
	}

	public long max() {
		return max(root).getValor();
	}

	private Node max(Node node) {
		if (node.getDireita() == null) {
			return node;
		} else {
			return max(node.getDireita());
		}
	}

	
	public long small() {
		return small(this.root).getValor();
	}

	private Node small (Node node) {
		if (node.getEsquerda() == null) {
			return node;
		} else {
			return small(node.getEsquerda());
		}
	}

        public int qtd_nodes() {
		Node node = root;
		int qtd = 0;
		Stack<Node> pilha = new Stack<>();
		while (!pilha.isEmpty() || node != null) {
			if (node != null) {
			pilha.push(node);
			node = node.getEsquerda();
			} else {
			qtd++;
			node= pilha.pop();
			node = node.getDireita();
			}
		}
		return qtd;
	}
        public int qtd_leaves() {
		return leaves(this.root);
	}

	private int leaves(Node node) {
		if (node == null)
			return 0;
		if (node.getEsquerda() == null && node.getDireita() == null)
			return 1;
		return leaves (node.getEsquerda()) + leaves(node.getDireita());
	}
       

}

