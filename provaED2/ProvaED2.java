public class ProvaED2 {
    public static void main(String[] args) {
    	
		ArvBin primeira = new ArvBin();
		ArvBin segunda = new ArvBin();
		ArvBin valor = new ArvBin();
		
		primeira.insert(10);
		primeira.insert(2);
		primeira.insert(3);
		primeira.insert(11);
		primeira.insert(15);

		segunda.insert(10);
		segunda.insert(2);
		segunda.insert(3);
		segunda.insert(11);
		segunda.insert(15);
		//segunda.insert(16);

		valor.insert(10);
		valor.insert(2);
		valor.insert(3);
		valor.insert(11);
		valor.insert(15);
	
		valor.print(); 

		System.out.println(primeira.isSimilar(segunda));
		System.out.println(segunda.isSimilar(primeira));

		System.out.println(" Maior valor: " + valor.max());
		System.out.println(" Menor valor: " + valor.small());
		System.out.println(" Média dos valores: " + valor.media());
		System.out.println(" A Soma dos valores Pares é: " + valor.par());

		
		
	}

 }
    
