package DataStructures.BinaryTree;

public class BinaryTree {
    private Node raiz;

    public BinaryTree(){
        this.raiz = null;
    }

    public void inserir(int n){
        if(raiz == null){
            raiz = new Node(n);
        }else{
            Node ante = raiz;
            Node post;

            if(n >= ante.getValor()){
                post = ante.getDir();
            }else{
                post = ante.getEsq();
            }

            while(post != null){
                ante = post;

                if(n >= ante.getValor()){
                    post = post.getDir();
                }else{
                    post = post.getEsq();
                }
            }

            if(n >= ante.getValor()){
                ante.setDir(new Node(n));
            }else{
                ante.setEsq(new Node(n));
            }

            balancear(raiz, raiz, ante);
        }
    }

    public String pre_ordem(){
        if(raiz != null) {
            StringBuilder str = new StringBuilder("[");

            pre_ordem_rec(str, raiz);

            str.delete(str.length() - 2, str.length());
            str.append("]");

            return str.toString();
        }

        return "[]";
    }

    public void pre_ordem_rec(StringBuilder str, Node node){
        if(node != null){
            str.append(node.getValor() + ", ");
            pre_ordem_rec(str, node.getEsq());
            pre_ordem_rec(str, node.getDir());
        }
    }

    public String in_ordem(){
        if(raiz != null) {
            StringBuilder str = new StringBuilder("[");

            in_ordem_rec(str, raiz);

            str.delete(str.length() - 2, str.length());
            str.append("]");

            return str.toString();
        }

        return "[]";
    }

    public void in_ordem_rec(StringBuilder str, Node node){
        if(node != null){
            in_ordem_rec(str, node.getEsq());
            str.append(node.getValor() + ", ");
            in_ordem_rec(str, node.getDir());
        }
    }

    public String pos_ordem(){
        if(raiz != null) {
            StringBuilder str = new StringBuilder("[");

            pos_ordem_rec(str, raiz);

            str.delete(str.length() - 2, str.length());
            str.append("]");

            return str.toString();
        }

        return "[]";
    }

    public void pos_ordem_rec(StringBuilder str, Node node){
        if(node != null){
            pos_ordem_rec(str, node.getEsq());
            pos_ordem_rec(str, node.getDir());
            str.append(node.getValor() + ", ");
        }
    }

    public void remover_menor(){
        if(raiz != null){
            if(raiz.getEsq() == null){
                raiz = raiz.getDir();
            }else{
                Node ante = raiz;
                Node post = raiz.getEsq();

                while(post.getEsq() != null){
                    ante = post;
                    post = post.getEsq();
                }

                ante.setEsq(null);
            }
        }
    }

    public void remover_maior(){
        if(raiz != null){
            if(raiz.getDir() == null){
                raiz = raiz.getEsq();
            }else{
                Node ante = raiz;
                Node post = raiz.getDir();

                while(post.getDir() != null){
                    ante = post;
                    post = post.getDir();
                }

                ante.setDir(null);
            }
        }
    }

    public void remover(int n){
        Node node = raiz;
        Node ante = raiz;

        while(node != null && node.getValor() != n){
            ante = node;

            if(n >= node.getValor()){
                node = node.getDir();
            }else{
                node = node.getEsq();
            }
        }

        if(node != null){
            Node replace = null;
            Node anteReplace = ante;

            if(node.getDir() != null){
                replace = node.getDir();
                anteReplace = node;

                while(replace.getEsq() != null){
                    anteReplace = replace;
                    replace = replace.getEsq();
                }

                if(!replace.equals(node.getDir())){
                    anteReplace.setEsq(replace.getDir());
                }else{
                    anteReplace.setDir(replace.getDir());
                }

                if(node.equals(raiz)){
                    raiz = replace;
                }else{
                    if (node.getValor() >= ante.getValor())
                        ante.setDir(replace);
                    else
                        ante.setEsq(replace);
                }

                if(!replace.equals(node.getEsq()))
                    replace.setEsq(node.getEsq());

                if(!replace.equals(node.getDir()))
                    replace.setDir(node.getDir());
            }else if(node.getEsq() != null){
                replace = node.getEsq();
                anteReplace = node;

                while(replace.getDir() != null){
                    anteReplace = replace;
                    replace = replace.getDir();
                }

                if(!replace.equals(node.getEsq())){
                    anteReplace.setDir(replace.getEsq());
                }else{
                    anteReplace.setEsq(replace.getEsq());
                }

                if(node.equals(raiz)){
                    raiz = replace;
                }else{
                    if (node.getValor() >= ante.getValor())
                        ante.setDir(replace);
                    else
                        ante.setEsq(replace);
                }

                if(!replace.equals(node.getEsq()))
                    replace.setEsq(node.getEsq());

                if(!replace.equals(node.getDir()))
                    replace.setDir(node.getDir());
            }else{
                if(node.equals(raiz)){
                    raiz = null;
                }else{
                    if (node.getValor() >= ante.getValor()) {
                        ante.setDir(null);
                    } else {
                        ante.setEsq(null);
                    }
                }
            }

            if(node.equals(anteReplace)){
                balancear(raiz, raiz, replace);
            }else {
                balancear(raiz, raiz, anteReplace);
            }
        }
    }

    boolean buscar(int n){
        Node tmp = raiz;

        while(tmp != null && tmp.getValor() != n){
            if(n >= tmp.getValor()){
                tmp = tmp.getDir();
            }else{
                tmp = tmp.getEsq();
            }
        }

        return tmp != null;
    }

    int altura(Node node){
        if(node == null)
            return -1;

        int esq = altura(node.getEsq());
        int dir = altura(node.getDir());

        if(esq > dir)
            return esq + 1;

        return dir + 1;
    }

    void rotDireita(Node node, Node ante){
        Node novaRaiz = node.getEsq();
        Node temp = novaRaiz.getDir();
        novaRaiz.setDir(node);
        node.setEsq(temp);

        if(!node.equals(raiz)){
            if(novaRaiz.getValor() >= ante.getValor())
                ante.setDir(novaRaiz);
            else
                ante.setEsq(novaRaiz);
        }else{
           raiz = novaRaiz;
        }
    }

    void rotEsquerda(Node node, Node ante){
        Node novaRaiz = node.getDir();
        Node temp = novaRaiz.getEsq();
        novaRaiz.setEsq(node);
        node.setDir(temp);

        if(!node.equals(raiz)){
            if(novaRaiz.getValor() >= ante.getValor())
                ante.setDir(novaRaiz);
            else
                ante.setEsq(novaRaiz);
        }else{
            raiz = novaRaiz;
        }
    }

    void balancear(Node node, Node ante, Node chegada){
        if(node != chegada){
            if(chegada.getValor() >= node.getValor())
                balancear(node.getDir(), node, chegada);
            else
                balancear(node.getEsq(), node, chegada);
        }

        int fb = fb(node);

        if(fb > 1){
            if(node.getEsq() != null && fb(node.getEsq()) == -1) {
                rotEsquerda(node.getEsq(), node);
            }else if(node.getDir() != null && fb(node.getDir()) == -1) {
                rotEsquerda(node.getDir(), node);
            }

            rotDireita(node, ante);
        }else if(fb < -1){
            if(node.getEsq() != null && fb(node.getEsq()) == 1) {
                rotDireita(node.getEsq(), node);
            }else if(node.getDir() != null  && fb(node.getDir()) == 1) {
                rotDireita(node.getDir(), node);
            }

            rotEsquerda(node, ante);
        }
    }

    int fb(Node node){ return altura(node.getEsq()) - altura(node.getDir()); }
}
