package DataStructures.Queue;

import DataStructures.CircularLinkedList.*;

public class Queue {
    private CircularLinkedList dados;

    public Queue(){
        this.dados = new CircularLinkedList();
    }

    public boolean isEmpty(){
        return dados.isEmpty();
    }

    public void inserir(int n){
        dados.inserirUltimo(n);
    }

    public int remover(){
        if(!isEmpty()) {
            DoublyLinkedNode primeiro = dados.removerPrimeiro();

            if(primeiro != null)
                return primeiro.getValor();
        }

        return -1;
    }

    public int size(){
        return dados.size();
    }

    public String toString(){
        return dados.toString();
    }

    public int getPrimeiro(){
        DoublyLinkedNode primeiro = dados.getPrimeiro();

        if(primeiro != null)
            return primeiro.getValor();

        return -1;
    }
}
