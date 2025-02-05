package DataStructures.DoublyLinkedList;

public class DoublyLinkedNode {
    private Integer valor;
    private DoublyLinkedNode ante;
    private DoublyLinkedNode prox;

    public DoublyLinkedNode(int n){
        this.valor = n;
        this.ante = null;
        this.prox = null;
    }

    public Integer getValor(){ return this.valor; }

    public DoublyLinkedNode getAnte(){ return this.ante; }

    public DoublyLinkedNode getProx(){ return this.prox; }

    public void setAnte(DoublyLinkedNode ante){ this.ante = ante; }

    public void setProx(DoublyLinkedNode prox){ this.prox = prox; }
}
