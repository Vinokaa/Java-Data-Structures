package DataStructures.Stack;

import DataStructures.CircularLinkedList.*;

public class Stack {
    private CircularLinkedList dados;

    public Stack(){
        this.dados = new CircularLinkedList();
    }

    public int topValue(){
        DoublyLinkedNode ultimo = dados.getUltimo();

        if(ultimo != null)
            return ultimo.getValor();

        return -1;
    }

    public boolean isEmpty(){
        return dados.isEmpty();
    }

    public void push(int n){
        dados.inserirUltimo(n);
    }

    public int pop(){
        DoublyLinkedNode removido = dados.removerUltimo();

        if(removido != null)
            return removido.getValor();

        return -1;
    }

    public String toString(){
        return dados.toString();
    }
}
