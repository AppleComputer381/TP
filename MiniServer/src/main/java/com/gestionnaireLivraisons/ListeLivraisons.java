package com.gestionnaireLivraisons;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * La classe qui liste des livraisons.
 */
public class ListeLivraisons implements IListeLivraisons {
    // Les livraisons stockées dans une ArrayList
    // TODO : À compléter/modifier
    private ArrayList<Livraison> listeLivraisons;

    public ListeLivraisons() {
        this.listeLivraisons = new ArrayList<Livraison>();

    };

    /**
     * Ajout d'une livraison à la liste de livraisons.
     *
     * @param livraison La livraison à ajouter.
     */
    public void ajouter(Livraison livraison) {
        this.listeLivraisons.add(livraison);
    }

    /**
     * Supprime une livraison par son id.
     *
     * @param idLivraison L'id de la livraison à supprimer.
     * @return La livraison supprimée ou null si non trouvée.
     */
    public Livraison supprimer(int idLivraison) {
        for (Livraison livraison : listeLivraisons) {
            if (livraison.getId() == idLivraison) {
                listeLivraisons.remove(livraison);
                return livraison;
            }
        }
        return null;
    }

    /**
     * Recherche une livraison par son id et la retourne.
     *
     * @param idLivraison L'id de la livraison à chercher.
     * @return La livraison trouvée ou null si non trouvée.
     */
    public Livraison rechercher(int idLivraison) {
        for (Livraison livraison : listeLivraisons) {
            if (livraison.getId() == idLivraison) {
                return livraison;
            }
        }

        return null;
    }

    /**
     * Supprime toutes les livraisons en cours pour ce livreur.
     *
     */
    public void vider() {
        this.listeLivraisons.clear();
    }

    /**
     * Teste si la liste est vide.
     *
     * @return true si la liste est vide, false sinon.
     */
    public boolean estVide() {
        return this.listeLivraisons.isEmpty();
    }

    /**
     * Retourne le nombre de livraisons présentes dans cette liste.
     *
     * @return Le nombre de livraisons.
     */
    public int taille() {
        return this.listeLivraisons.size();
    }

    /**
     * Retourne un itérateur pour cette liste.
     *
     * @return Un itérateur pour cette liste.
     */
    @Override
    public ListIterator<Livraison> iterator() {
        return this.listeLivraisons.listIterator();
    }

    /**
     * Méthode privée pour chercher l'indice d'une livraison.
     *
     * @param idLivraison L'id de la livraison à chercher.
     * @return L'indice de la livraison trouvée ou -1 si non trouvée.
     */
    private int chercher(int idLivraison) {
        for (int i = 0; i < this.taille(); i++) {
            if (this.listeLivraisons.get(i).getId() == idLivraison) {
                return i;
            }
        }
        return -1;
    }
}
