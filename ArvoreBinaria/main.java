package ArvoreBinaria;

public class Main {

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

        ab.remover(80);

        //System.out.println(" Numero de nós: " + ab.qtd_no());

        ab.imprimirEmOrdem(ab.getArvoreBinaria());
        //ab.imprimirPreOrdem(ab.getArvoreBinaria());
        //ab.imprimirPosOrdem(ab.getArvoreBinaria());

        //ab.verificargrau(50);
        //ab.verificaAltura(105);
        //ab.verificarProfundidade(100);
        //ab.verificarNivel(103);
        
        
    }  
}
