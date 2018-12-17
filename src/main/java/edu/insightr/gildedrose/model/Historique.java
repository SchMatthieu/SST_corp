package edu.insightr.gildedrose.model;

import java.util.ArrayList;
import java.util.List;

public class Historique {
    private List<List<Item>> historiqueVente;
    private List<List<Item>> historiqueAchat;

    public Historique(List<List<Item>> historiqueVente, List<List<Item>> historiqueAchat) {
        this.historiqueVente = historiqueVente;
        this.historiqueAchat = historiqueAchat;
    }

    public Historique(){
        this.historiqueVente = new ArrayList<>();
        this.historiqueAchat = new ArrayList<>();
    }

    public List<List<Item>> getHistoriqueVente() {
        return historiqueVente;
    }

    public void setHistoriqueVente(List<List<Item>> historiqueVente) {
        this.historiqueVente = historiqueVente;
    }

    public List<List<Item>> getHistoriqueAchat() {
        return historiqueAchat;
    }

    public void setHistoriqueAchat(List<List<Item>> historiqueAchat) {
        this.historiqueAchat = historiqueAchat;
    }

    public void addDay(){
        List<Item> innerList = new ArrayList<>();
        historiqueVente.add(innerList);
        historiqueAchat.add(innerList);
    }

    public void soldItem(Item item){
        if(historiqueVente.isEmpty())
        {
            List<Item> innerList = new ArrayList<>();
            innerList.add(item);
            historiqueVente.add(innerList);
        }
        else
        {
            historiqueVente.get(historiqueVente.size() - 1).add(item);
        }
    }
    public void boughtItem(Item item){
        if(historiqueAchat.isEmpty())
        {
            List<Item> innerList = new ArrayList<>();
            innerList.add(item);
            historiqueAchat.add(innerList);
        }
        else
        {
            historiqueAchat.get(historiqueAchat.size() - 1).add(item);
        }
    }
}

