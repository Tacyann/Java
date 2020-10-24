
public class principal {

    public static void main(String[] args) {
        
        ArvoreBinaria ab = new ArvoreBinaria(50);	

        ab.adicionarNo(new No(45), ab.getArvoreBinaria());
        ab.adicionarNo(new No(55), ab.getArvoreBinaria());
        ab.adicionarNo(new No(40), ab.getArvoreBinaria());
        ab.adicionarNo(new No(48), ab.getArvoreBinaria());
        ab.adicionarNo(new No(53), ab.getArvoreBinaria());
        ab.adicionarNo(new No(60), ab.getArvoreBinaria());
        ab.adicionarNo(new No(36), ab.getArvoreBinaria());
        ab.adicionarNo(new No(49), ab.getArvoreBinaria());
    

        //ab.remover(53);

        //System.out.println(" Numero de nós: " + ab.qtd_no());
        
        ab.imprimirEmOrdem(ab.getArvoreBinaria());
        //ab.imprimirPreOrdem(ab.getArvoreBinaria());
        //ab.imprimirPosOrdem(ab.getArvoreBinaria());
        //ab.reverterOrdem(ab.getArvoreBinaria());


        //ab.busca(60);
        //ab.verificargrau(36);
        //ab.verificaAltura(40);
       // ab.verificarProfundidade(60);
        //ab.verificarNivel(49);
        
        
    }  
}
