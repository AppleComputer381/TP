package com.gestionnaireLivraisons;

import java.util.PriorityQueue;

// import static com.gestionnaireLivraisons.Livraison;

/**
 * La classe générique des files de priorité.
 *
 */
public class FilePrioriteLivraisons {
    // Les livraisons stockées dans une file de priorité
    // TODO : À compléter/modifier

    /**
     * Construit une file de priorité.
     */
    // TODO : À compléter/modifier
    PriorityQueue<Livraison> file;
    public FilePrioriteLivraisons(){
        file = new PriorityQueue<>();
    }
    /**
     * Retire et retourne l'élément le plus prioritaire de la file.
     *
     * @return L'élément le plus prioritaire.
     */
    public Livraison retirer() {
        // TODO : À compléter/modifier
        //System.err.println("Méthode FilePrioriteLivraisons::retirer() non implémentée");
        Livraison firstout = file.peek();
        file.remove();
        return firstout;
    }

    /**
     * Ajoute un élément à la file.
     *
     * @param element L'élément à ajouter à la file.
     */
    public void ajouter(Livraison element) {
        // TODO : À compléter/modifier
        //System.err.println("Méthode FilePrioriteLivraisons::ajouter non implémentée");
        file.add(element);
    }

    /**
     * Ajoute un ensemble d'éléments à la file.
     *
     * @param elements L'ensemble des éléments à ajouter à la file.
     */
    public void ajouterTout(Iterable<Livraison> elements) {
        
        for(Livraison element: elements){
            file.add(element);
        }
        // TODO : À compléter/modifier
        //System.err.println("Méthode FilePrioriteLivraisons::ajouterTout non implémentée");
    }

    /**
     * Indique si la file est vide.
     *
     * @return True si la file est vide. False sinon.
     */
    public boolean estVide() {
        // TODO : À compléter/modifier
        
        return file.isEmpty();
    }

    /**
     * Retourne le nombre d'éléments dans cette file de priorité.
     *
     * @return Le nombre d'éléments de la file.
     */
    public int taille() {
        // TODO : À compléter/modifier
        return file.size();
    }

    /**
     * Affiche les éléments contenus dans la file.
     *
     */
    public void afficher() {
        // TODO : À compléter/modifier
        //System.err.println("Méthode FilePrioriteLivraisons::afficher non implémentée");
        for (Livraison element: file){
            System.out.println(element);
        }
    }
}
