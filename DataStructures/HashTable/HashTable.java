package DataStructures.HashTable;

import java.util.Random;
import DataStructures.CircularLinkedList.*;

public class HashTable {
    private int colisoes;
    private CircularLinkedList[] tabela;

    public HashTable(int n){
        this.colisoes = 0;
        this.tabela = new CircularLinkedList[n];

        Random rand = new Random();

        for(int i = 0; i < tabela.length * 0.9; i++){
            inserir(rand.nextInt(0, 1_000_001));
        }
    }

    public void inserir(int n){
        int hash = hash(n);

        if(tabela[hash] == null)
            tabela[hash] = new CircularLinkedList();
        else
            colisoes++;

        tabela[hash].inserirOrdenado(n);
    }

    private int hash(int n){
        return n % tabela.length;
    }

    public boolean buscar(int n){
        int hash = hash(n);

        if(tabela[hash] == null)
            return false;

        return tabela[hash].getNode(n) != null;
    }

    public int getColisoes(){ return colisoes; }

    public String toString(){
        StringBuilder strBuilder = new StringBuilder();

        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != null)
                strBuilder.append("" + i + " " + tabela[i] + "\n");
            else
                strBuilder.append("" + i + " []\n");
        }

        return strBuilder.toString();
    }
}
