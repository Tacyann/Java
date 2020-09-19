package ArvoreBinaria;

public class Main {

    public static void main(String[] args) {
        
        ArvoreBinaria ab = new ArvoreBinaria(50); //Minha Raiz é 50.

        ab.adicionarNo(new No(30), ab.getArvoreBinaria());
        ab.adicionarNo(new No(60), ab.getArvoreBinaria());
        ab.adicionarNo(new No(25), ab.getArvoreBinaria());
        ab.adicionarNo(new No(65), ab.getArvoreBinaria());

        //ab.imprimirEmOrdem(ab.getArvoreBinaria());
        //ab.imprimirPreOrdem(ab.getArvoreBinaria());
        //ab.imprimirPosOrdem(ab.getArvoreBinaria());

         ab.verificargrau(30);
    }

    
}
