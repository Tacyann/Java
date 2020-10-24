public class ProvaED2 {
    public static void main(String[] args) {
    	
		ArvBin primeira = new ArvBin();
		ArvBin segunda = new ArvBin();
		
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
		
		System.out.println(primeira.isSimilar(segunda));
		System.out.println(segunda.isSimilar(primeira));
		
		
	   
	}

 }
    
