package DataStructures.LinkedList;

public class LinkedList {
    private Node primeiro;

    public LinkedList(){
        this.primeiro = null;
    }

    public boolean isEmpty(){ return primeiro == null; }

    public void inserirPrimeiro(int n){
        Node novo = new Node(n);
        novo.setProx(primeiro);
        primeiro = novo;
    }

    public void inserirUltimo(int n){
        if(isEmpty())
            inserirPrimeiro(n);
        else {
            Node tmp;

            for(tmp = primeiro; tmp.getProx() != null; tmp = tmp.getProx());

            tmp.setProx(new Node(n));
        }
    }

    public void inserirOrdenado(int n){
        if(isEmpty()){
            inserirPrimeiro(n);
        }else{
            Node anterior = null;
            Node tmp = primeiro;

            while (tmp != null && tmp.getValor() <= n) {
                anterior = tmp;
                tmp = tmp.getProx();
            }

            Node novo = new Node(n);
            novo.setProx(tmp);

            if(anterior == null)
                // Se o while-loop não executou, o novo valor é menor que o primeiro e deve se tornar o primeiro
                primeiro = novo;
            else
                anterior.setProx(novo);
        }
    }

    public void inserirDepois(Node node, int valor){
        if(node != null) {
            Node tmp = new Node(valor);

            tmp.setProx(node.getProx());
            node.setProx(tmp);
        }
    }

    public Node getNode(int valor){
        // Retorna nulo caso o valor não seja encontrado

        Node tmp = primeiro;

        while(tmp != null && tmp.getValor() != valor){
            tmp = tmp.getProx();
        }

        return tmp;
    }

    public Node removerPrimeiro(){
        Node removido = primeiro;

        if(!isEmpty())
            primeiro = primeiro.getProx();

        return removido;
    }

    public Node removerUltimo(){
        if(!isEmpty()) {
            Node anterior = null;
            Node tmp = primeiro;

            while(tmp.getProx() != null){
                anterior = tmp;
                tmp = tmp.getProx();
            }

            if(anterior != null)
                // primeiro não é o último
                anterior.setProx(null);
            else
                // primeiro é o ultimo
                primeiro = null;

            return tmp;
        }

        return null;
    }

    public Node remover(Node node){
        if(!isEmpty() && node != null) {
            Node anterior = null;
            Node tmp = primeiro;

            while (tmp != null && !node.equals(tmp)) {
                anterior = tmp;
                tmp = tmp.getProx();
            }

            if (anterior != null)
                anterior.setProx(node.getProx());
            else
                primeiro = node.getProx();

            return node;
        }

        return null;
    }

    public int size(){
        if(isEmpty())
            return 0;
        else{
            int i = 0;
            Node tmp = primeiro;

            while (tmp != null) {
                tmp = tmp.getProx();
                i++;
            }

            return i;
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[");

        for(Node tmp = primeiro; tmp != null; tmp = tmp.getProx()){
            str.append(tmp.getValor());
            str.append(", ");
        }

        if(!isEmpty())
            str.delete(str.length() - 2, str.length());

        str.append("]");

        return str.toString();
    }
}
