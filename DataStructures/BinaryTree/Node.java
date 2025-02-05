package DataStructures.BinaryTree;

public class Node {
    private int valor;
    private Node esq;
    private Node dir;

    public Node(int valor){
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public int getValor() {
        return valor;
    }

    public Node getEsq() {
        return esq;
    }

    public Node getDir() {
        return dir;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }
}
