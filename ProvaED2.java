
public class ProvaED2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvBin valor = new ArvBin();

		valor.insert(10);
		valor.insert(2);
		valor.insert(3);
		valor.insert(11);
		valor.insert(15);
	
              
		valor.print();
                
	System.out.println(" 2 existe? " + valor.count(12));
	System.out.println(" Maior valor: " + valor.max());
        System.out.println(" Menor valor: " + valor.small());
        System.out.println(" Média dos valores: " + valor.media());
        System.out.println(" Numero de nós: " + valor.qtd_nodes());
        System.out.println(" Número de folhas: " + valor.qtd_leaves());
        System.out.println(" Altura da Árvore: " + valor.height());
		
                valor.remove(2);
		System.out.println(" Remova o node 02");
		valor.print();
                
		//valor.remove(14);
		// System.out.println("Remova o node  16);
		//valor.print();

	}
// TODO code application logic here
    }
    
