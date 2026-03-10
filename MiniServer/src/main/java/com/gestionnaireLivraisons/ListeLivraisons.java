package com.gestionnaireLivraisons;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * La classe qui liste des livraisons.
 */
public class ListeLivraisons implements IListeLivraisons {
    // Les livraisons stockées dans une ArrayList
    // TODO : À compléter/modifier

    /**
     * Ajout d'une livraison à la liste de livraisons.
     *
     * @param livraison La livraison à ajouter.
     */
    public void ajouter(Livraison livraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::ajouter non implémentée");
    }

    /**
     * Supprime une livraison par son id.
     *
     * @param idLivraison L'id de la livraison à supprimer.
     * @return La livraison supprimée ou null si non trouvée.
     */
    public Livraison supprimer(int idLivraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::supprimer non implémentée");
        return null;
    }

    /**
     * Recherche une livraison par son id et la retourne.
     *
     * @param idLivraison L'id de la livraison à chercher.
     * @return La livraison trouvée ou null si non trouvée.
     */
    public Livraison rechercher(int idLivraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::rechercher non implémentée");
        return null;
    }

    /**
     * Supprime toutes les livraisons en cours pour ce livreur.
     *
     */
    public void vider() {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::vider non implémentée");
    }

    /**
     * Teste si la liste est vide.
     *
     * @return true si la liste est vide, false sinon.
     */
    public boolean estVide() {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::estVide non implémentée");
        return false;
    }

    /**
     * Retourne le nombre de livraisons présentes dans cette liste.
     *
     * @return Le nombre de livraisons.
     */
    public int taille() {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::taille non implémentée");
        return 0;
    }

    /**
     * Retourne un itérateur pour cette liste.
     *
     * @return Un itérateur pour cette liste.
     */
    @Override
    public ListIterator<Livraison> iterator() {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::iterator non implémentée");
        return null;
    }

    /**
     * Méthode privée pour chercher l'indice d'une livraison.
     *
     * @param idLivraison L'id de la livraison à chercher.
     * @return L'indice de la livraison trouvée ou -1 si non trouvée.
     */
    private int chercher(int idLivraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode ListeLivraisons::chercher non implémentée");
        return 0;
    }
}
