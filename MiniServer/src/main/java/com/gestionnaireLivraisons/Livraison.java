package com.gestionnaireLivraisons;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

/**
 * La classe qui modélise une livraison.
 */
public class Livraison implements Comparable<Livraison>
// TODO : À compléter/modifier
{
    // Les données membres statiques
    // TODO : À compléter/modifier
    private int MAX_TENTATIVES = 3;

    // Les attributs d'instance
    // TODO : À compléter/modifier
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
    // TODO : À compléter/modifier
    public Livraison(Priorite priorite, int lot) {
        this.priorite = priorite;
        this.lot = lot;
        this.id = prochainID();

    }

    /**
     * Produit un nouvel ID pour la Livraison
     */
    private static int prochainID() {
        // TODO : À compléter/modifier
        compteurID++;

        // System.err.println("Méthode Livraison::prochainID non implémentée");
        return compteurID;
    }

    /**
     * Retourne l'identifiant de cette livraison.
     *
     * @return L'id de cette livraison.
     */
    public int getId() {
        // TODO : À compléter/modifier
        return this.id;
    }

    /**
     * Retourne la priorité de cette livraison.
     *
     * @return La priorite de cette livraison.
     */
    // TODO : À compléter/modifier
    public Priorite getPriorite() {
        return this.priorite;
    }

    /**
     * Retourne la tentative pour cette livraison.
     *
     * @return La tentative de cette livraison.
     */
    public int getTentative() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livraison::getTentative non implémentée");
        return 0;
    }

    /**
     * Retourne le lot auquel appartient cette livraison.
     *
     * @return Le lot de cette livraison.
     */
    public int getLot() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livraison::getLot non implémentée");
        return 0;
    }

    /**
     * Mutateur pour le statut de la livraison.
     *
     */
    public void setStatut(Statut statut) {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livraison::setStatut non implémentée");
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
        // TODO : À compléter/modifier
        System.err.println("Méthode Livraison::resteTentatives non implémentée");
        return false;
    }

    /**
     * Construit et retourne une chaîne de caractères équivalente à cette livraison.
     *
     * @return String La chaîne qui représente cette livraison.
     */
    @Override
    public String toString() {
        // TODO : À compléter/modifier
        System.out.println("la livraison d'identifiant: " + this.id + " appartenant au lot: " + this.lot
                + " de priorité: "
                + this.priorite + " avec le statut: " + this.statut + " a été tenté d'etre livré: " + this.tentative);
        // System.err.println("Méthode Livraison::toString non implémentée");
        return null;
    }

    /**
     * Compare cette livraison avec une autre livraison.
     *
     * @param autreLivraison La seconde livraison à comparer avec cette livraison.
     * @return Le résultat de la comparaison au sens de l'interface Comparable<T>.
     */
    // TODO : À compléter/modifier
    public int compareTo(Livraison autreLivraison) {
        if (this.lot < autreLivraison.lot) {
            return -1;
        } else if (this.lot > autreLivraison.lot) {
            return 1;
        } else {
            if (this.priorite == Priorite.URGENT && autreLivraison.priorite == Priorite.NORMALE) {
                return -1;
            } else if (this.priorite == Priorite.NORMALE && autreLivraison.priorite == Priorite.URGENT) {
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
