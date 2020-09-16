public static void main(String[] args) {

    ArvoreBinaria ab = new ArvoreBinaria(50); //Minha Raiz é 50.

    ab.inserirNo(new No(40), ab.getArvoreBinaria());
    ab.inserirNo(new No(45), ab.getArvoreBinaria());
    ab.inserirNo(new No(55), ab.getArvoreBinaria());
    ab.inserirNo(new No(47), ab.getArvoreBinaria());

    ab.verificarGrau(45);


    //ab.imprimirEmOrdem(ab.getArvoreBinaria())
    //ab.imprimirPreOrdem(ab.getArvoreBinaria())
    //ab.imprimirPosOrdem(ab.getArvoreBinaria())

    
}
