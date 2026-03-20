package com.gestionnaireLivraisons;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

/**
 * La classe qui modélise une livraison.
 */
public class Livraison implements Comparable<Livraison> {
    // Les données membres statiques
    private int MAX_TENTATIVES = 3;

    // Les attributs d'instance
    private int id;
    private Priorite priorite;
    private int tentative = 0;
    private int lot;
    private Statut statut = Statut.EN_ATTENTE;
    private static int compteurID = 1;

    /**
     * Constructeur d'une livraison.
     *
     * @param priorite La priorité de la nouvelle livraison.
     * @param lot      Le lot auquel cette livraison appartient.
     */
    public Livraison(Priorite priorite, int lot) {
        this.priorite = priorite;
        this.lot = lot;
        this.id = prochainID();

    }

    /**
     * Produit un nouvel ID pour la Livraison
     */
    private static int prochainID() {
        compteurID++;
        return compteurID;
    }

    /**
     * Retourne l'identifiant de cette livraison.
     *
     * @return L'id de cette livraison.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne la priorité de cette livraison.
     *
     * @return La priorite de cette livraison.
     */
    public Priorite getPriorite() {
        return this.priorite;
    }

    /**
     * Retourne la tentative pour cette livraison.
     *
     * @return La tentative de cette livraison.
     */
    public int getTentative() {
        return this.tentative;
    }

    /**
     * Retourne le lot auquel appartient cette livraison.
     *
     * @return Le lot de cette livraison.
     */
    public int getLot() {
        return this.lot;
    }

    /**
     * Mutateur pour le statut de la livraison.
     *
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /**
     * Ajoute UN au numéro de tentative pour cette livraison.
     *
     */
    public boolean nouvelleTentative() {
        if (MAX_TENTATIVES == 0) {
            return false;

        } else {
            tentative++;
            MAX_TENTATIVES--;
            return true;
        }

        // System.err.println("Méthode Livraison::nouvelleTentative non implémentée");
    }

    /**
     * Vérifie s'il reste des tentatives ou non pour cette livraison.
     *
     * @return true s'il reste des tentatives, false sinon.
     */
    public boolean resteTentatives() {
        return this.MAX_TENTATIVES > 0;
    }

    /**
     * Construit et retourne une chaîne de caractères équivalente à cette livraison.
     *
     * @return String La chaîne qui représente cette livraison.
     */
    @Override
    public String toString() {
        return this.id + " " + this.lot + " " + this.priorite + " " + this.tentative;
    }

    /**
     * Compare cette livraison avec une autre livraison.
     *
     * @param autreLivraison La seconde livraison à comparer avec cette livraison.
     * @return Le résultat de la comparaison au sens de l'interface Comparable<T>.
     */
    public int compareTo(Livraison autreLivraison) {
        if (this.lot < autreLivraison.lot) {
            return -1;
        } else if (this.lot > autreLivraison.lot) {
            return 1;
        } else {
            if (this.priorite == Priorite.URGENTE && autreLivraison.priorite == Priorite.NORMALE) {
                return -1;
            } else if (this.priorite == Priorite.NORMALE && autreLivraison.priorite == Priorite.URGENTE) {
                return 1;
            } else {
                if (this.tentative > autreLivraison.tentative) {
                    return -1;
                } else if (this.tentative < autreLivraison.tentative) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

}
