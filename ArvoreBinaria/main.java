package ArvoreBinaria;

public class Main {

    public static void main(String[] args) {
        
        ArvoreBinaria ab = new ArvoreBinaria(40); //Minha Raiz é 50.

        ab.adicionarNo(new No(30), ab.getArvoreBinaria());
        ab.adicionarNo(new No(70), ab.getArvoreBinaria());
        ab.adicionarNo(new No(35), ab.getArvoreBinaria());
        ab.adicionarNo(new No(80), ab.getArvoreBinaria());
        ab.adicionarNo(new No(75), ab.getArvoreBinaria());

        //ab.imprimirEmOrdem(ab.getArvoreBinaria());
        //ab.imprimirPreOrdem(ab.getArvoreBinaria());
        //ab.imprimirPosOrdem(ab.getArvoreBinaria());

        //ab.verificargrau(30);
         ab.verificaAltura(70);
    }

    
}
