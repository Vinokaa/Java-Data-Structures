package DataStructures.CircularLinkedList;

public class CircularLinkedList {
    private DoublyLinkedNode primeiro;

    public CircularLinkedList(){
        this.primeiro = null;
    }

    public boolean isEmpty(){ return primeiro == null; }

    public boolean hasOneNode(){ return primeiro.getProx().equals(primeiro); }

    public void inserirPrimeiro(int n){
        DoublyLinkedNode novo = new DoublyLinkedNode(n);

        if(isEmpty()) {
            novo.setAnte(novo);
            novo.setProx(novo);
        }else{
            primeiro.getAnte().setProx(novo);
            novo.setAnte(primeiro.getAnte());
            primeiro.setAnte(novo);
            novo.setProx(primeiro);
        }

        primeiro = novo;
    }

    public void inserirUltimo(int n){
        if(isEmpty())
            inserirPrimeiro(n);
        else {
            DoublyLinkedNode novo = new DoublyLinkedNode(n);

            novo.setAnte(primeiro.getAnte());
            primeiro.getAnte().setProx(novo);
            primeiro.setAnte(novo);
            novo.setProx(primeiro);
        }
    }

    public void inserirOrdenado(int n){
        if(isEmpty()){
            inserirPrimeiro(n);
        }else{
            DoublyLinkedNode tmp = primeiro;
            boolean percorreu = false;

            if(tmp.getValor() <= n) {
                tmp = tmp.getProx();
                percorreu = true;
            }

            // tmp para antes do maior ou no ultimo nó
            while (!tmp.equals(primeiro) && tmp.getValor() <= n) {
                tmp = tmp.getProx();
            }

            if(tmp.equals(primeiro)){
                if(percorreu)
                    inserirUltimo(n);
                else
                    inserirPrimeiro(n);
            }else{
                DoublyLinkedNode novo = new DoublyLinkedNode(n);

                novo.setAnte(tmp.getAnte());
                novo.setProx(tmp);
                novo.getAnte().setProx(novo);
                novo.getProx().setAnte(novo);
            }


        }
    }

    public void inserirDepois(DoublyLinkedNode node, int n){
        if(node != null) {
            if(node.equals(primeiro.getAnte()))
                inserirUltimo(n);
            else {
                DoublyLinkedNode novo = new DoublyLinkedNode(n);

                novo.setAnte(node);
                novo.setProx(node.getProx());
                node.setProx(novo);
                novo.getProx().setAnte(novo);
            }
        }
    }

    public DoublyLinkedNode getNode(int valor){
        DoublyLinkedNode tmp = primeiro;
        boolean percorreu = false;

        if(!isEmpty()) {
            if (tmp.getValor() != valor) {
                tmp = tmp.getProx();
                percorreu = true;
            }

            while (!tmp.equals(primeiro) && tmp.getValor() != valor) {
                tmp = tmp.getProx();
            }

            if (tmp.equals(primeiro) && percorreu)
                return null;

            return tmp;
        }

        return null;
    }

    public DoublyLinkedNode getPrimeiro(){
        return primeiro;
    }

    public DoublyLinkedNode getUltimo(){
        if(!isEmpty())
            return primeiro.getAnte();

        return null;
    }

    public DoublyLinkedNode removerPrimeiro(){
        DoublyLinkedNode removido = primeiro;

        if(!isEmpty()) {
            if(hasOneNode())
                primeiro = null;
            else {
                primeiro.getProx().setAnte(primeiro.getAnte());
                primeiro.getAnte().setProx(primeiro.getProx());

                primeiro = primeiro.getProx();
            }
        }

        return removido;
    }

    public DoublyLinkedNode removerUltimo(){
        if(!isEmpty()) {
            DoublyLinkedNode ultimo = primeiro.getAnte();

            if(hasOneNode())
                primeiro = null;
            else {
                primeiro.setAnte(ultimo.getAnte());
                ultimo.getAnte().setProx(primeiro);
            }

            return ultimo;
        }

        return null;
    }

    public DoublyLinkedNode remover(DoublyLinkedNode node){
        if(!isEmpty() && node != null) {
            if(node.equals(primeiro))
                removerPrimeiro();
            else if(node.equals(primeiro.getAnte()))
                removerUltimo();
            else{
                node.getAnte().setProx(node.getProx());
                node.getProx().setAnte(node.getAnte());
            }

            return node;
        }

        return null;
    }

    public int size(){
        if(isEmpty())
            return 0;
        else{
            int i = 1;
            DoublyLinkedNode tmp = primeiro;

            tmp = tmp.getProx();

            while (!tmp.equals(primeiro)) {
                tmp = tmp.getProx();
                i++;
            }

            return i;
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[");
        DoublyLinkedNode tmp = primeiro;

        if(!isEmpty()) {
            str.append(tmp.getValor());
            str.append(", ");
            tmp = tmp.getProx();
        }

        for(;tmp != null && !tmp.equals(primeiro); tmp = tmp.getProx()){
            str.append(tmp.getValor());
            str.append(", ");
        }

        if(!isEmpty())
            str.delete(str.length() - 2, str.length());

        str.append("]");

        return str.toString();
    }
}