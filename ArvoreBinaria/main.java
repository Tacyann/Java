package ArvoreBinaria;

public class Main {

    public static void main(String[] args) {
        
        ArvoreBinaria ab = new ArvoreBinaria(100); 

        ab.adicionarNo(new No(50), ab.getArvoreBinaria());
        ab.adicionarNo(new No(110), ab.getArvoreBinaria());
        ab.adicionarNo(new No(25), ab.getArvoreBinaria());
        ab.adicionarNo(new No(105), ab.getArvoreBinaria());
        ab.adicionarNo(new No(120), ab.getArvoreBinaria());
        ab.adicionarNo(new No(103), ab.getArvoreBinaria());

        //ab.imprimirEmOrdem(ab.getArvoreBinaria());
        //ab.imprimirPreOrdem(ab.getArvoreBinaria());
        //ab.imprimirPosOrdem(ab.getArvoreBinaria());

        //ab.verificargrau(30);
        //ab.verificaAltura(40);
        //ab.verificarProfundidade(100);
        //ab.verificarNivel(103);
        ab.contarNo(110);
        
    }  
}
