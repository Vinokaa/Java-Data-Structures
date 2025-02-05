package DataStructures.LinkedList;

public class Node {
    private Integer valor;
    private Node prox;

    public Node(int n){
        this.valor = n;
        this.prox = null;
    }

    public Integer getValor(){ return this.valor; }

    public Node getProx(){ return this.prox; }

    public void setProx(Node prox){ this.prox = prox; }
}
