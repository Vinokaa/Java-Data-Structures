package DataStructures.DoublyLinkedList;

public class DoublyLinkedList {
    private DoublyLinkedNode primeiro;

    public DoublyLinkedList(){
        this.primeiro = null;
    }

    public boolean isEmpty(){ return primeiro == null; }

    public void inserirPrimeiro(int n){
        DoublyLinkedNode novo = new DoublyLinkedNode(n);
        novo.setProx(primeiro);
        primeiro = novo;
    }

    public void inserirUltimo(int n){
        if(isEmpty())
            inserirPrimeiro(n);
        else {
            DoublyLinkedNode tmp;

            for(tmp = primeiro; tmp.getProx() != null; tmp = tmp.getProx());

            DoublyLinkedNode novo = new DoublyLinkedNode(n);
            tmp.setProx(novo);
            novo.setAnte(tmp);
        }
    }

    public void inserirOrdenado(int n){
        if(isEmpty()){
            inserirPrimeiro(n);
        }else{
            DoublyLinkedNode anterior = null;
            DoublyLinkedNode tmp = primeiro;

            // tmp para antes do maior ou no ultimo nó
            while (tmp != null && tmp.getValor() <= n) {
                anterior = tmp;
                tmp = tmp.getProx();
            }

            if(anterior != null){
                DoublyLinkedNode novo = new DoublyLinkedNode(n);

                anterior.setProx(novo);
                novo.setAnte(anterior);
                novo.setProx(tmp);

                if(tmp != null)
                    tmp.setAnte(novo);
            }else{
                inserirPrimeiro(n);
            }


        }
    }

    public void inserirDepois(DoublyLinkedNode node, int n){
        if(node != null) {
            DoublyLinkedNode novo = new DoublyLinkedNode(n);

            DoublyLinkedNode proximo = node.getProx();

            node.setProx(novo);
            novo.setAnte(node);
            novo.setProx(proximo);

            if(proximo != null)
                proximo.setAnte(novo);
        }
    }

    public DoublyLinkedNode getNode(int valor){
        DoublyLinkedNode tmp = primeiro;

        while(tmp != null && tmp.getValor() != valor){
            tmp = tmp.getProx();
        }

        return tmp;
    }

    public DoublyLinkedNode removerPrimeiro(){
        DoublyLinkedNode removido = primeiro;

        if(!isEmpty()) {
            primeiro = primeiro.getProx();

            if(primeiro != null)
                primeiro.setAnte(null);
        }

        return removido;
    }

    public DoublyLinkedNode removerUltimo(){
        if(!isEmpty()) {
            DoublyLinkedNode tmp = primeiro;

            while(tmp.getProx() != null){
                tmp = tmp.getProx();
            }

            if(!tmp.equals(primeiro))
                // primeiro != ultimo
                tmp.getAnte().setProx(null);
            else
                // primeiro == ultimo
                primeiro = null;

            return tmp;
        }

        return null;
    }

    public DoublyLinkedNode remover(DoublyLinkedNode node){
        if(!isEmpty() && node != null) {
            DoublyLinkedNode tmp = primeiro;

            while (tmp != null && !node.equals(tmp)) {
                tmp = tmp.getProx();
            }

            if (!tmp.equals(primeiro)) {
                tmp.getAnte().setProx(tmp.getProx());
                tmp.getProx().setAnte(tmp.getAnte());
            } else {
                primeiro = node.getProx();
                primeiro.setAnte(null);
            }

            return node;
        }

        return null;
    }

    public int size(){
        if(isEmpty())
            return 0;
        else{
            int i = 0;
            DoublyLinkedNode tmp = primeiro;

            while (tmp != null) {
                tmp = tmp.getProx();
                i++;
            }

            return i;
        }
    }


    public String toString(){
        StringBuilder str = new StringBuilder("[");

        for(DoublyLinkedNode tmp = primeiro; tmp != null; tmp = tmp.getProx()){
            str.append(tmp.getValor());
            str.append(", ");
        }

        if(!isEmpty())
            str.delete(str.length() - 2, str.length());

        str.append("]");

        return str.toString();
    }
}