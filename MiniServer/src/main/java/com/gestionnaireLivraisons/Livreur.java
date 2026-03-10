package com.gestionnaireLivraisons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * La classe qui modélise un livreur.
 */
public abstract class Livreur {
    // Les attrbuts d'un livreur
    // TODO : À compléter/modifier

    /**
     * Construit un nouveau livreur.
     *
     * @param id  L'id du nouveau livreur.
     * @param nom Le nom du nouveau livreur.
     */
    // TODO : À compléter/modifier

    /**
     * L'accesseur pour l'id du livreur.
     *
     * @return L'id de ce livreur.
     */
    public int getId() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::getId non implémentée");
        return 0;
    }

    /**
     * Getter pour le livreur.
     *
     * @return Le nom de ce livreur.
     */
    public String getNom() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::getNom non implémentée");
        return null;
    }

    /**
     * Vérifie si un livreur a des livraisons en cours.
     *
     * @return true si oui, false sinon.
     */
    public boolean aDesLivraisonsEnCours() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::aDesLivraisonsEnCours non implémentée");
        return false;
    }

    /**
     * Ajoute une livraison aux livraisons en cours.
     *
     * @param livraison La livraison à ajouter.
     */
    public void ajouterLivraisonEnCours(Livraison livraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::ajouterLivraisonEnCours non implémentée");
    }

    /**
     * Ajoute une livraison aux livraisons effectuées.
     *
     * @param livraison La livraison à ajouter.
     */
    public void ajouterLivraisonEffectuee(Livraison livraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::ajouterLivraisonEffectuee non implémentée");
    }

    /**
     * Supprimer une livraison des livraisons en cours.
     *
     * @param idLivraison L'i de la livraison à supprimer.
     * @return La livraison supprimée ou null si non trouvée.
     */
    public Livraison supprimerLivraisonEnCours(int idLivraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::supprimerLivraisonEnCours non implémentée");
        return null;
    }

    /**
     * Supprime et retourne toutes les livraisons en cours pour ce livreur.
     *
     * @return La liste des livraisons en cours avant suppressions.
     */
    public IListeLivraisons supprimerToutesLesLivraisons() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::supprimerToutesLesLivraisons non implémentée");
        return null;
    }

    /**
     * Retourne une livraison d'après son id.
     *
     * @param idLivraison L'id de la livraison à trouver.
     * @return La livraison si trouvée, null sinon.
     */
    public Livraison rechercherLivraisonEnCours(int idLivraison) {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::rechercherLivraisonEnCours non implémentée");
        return null;
    }

    /**
     * Calcule et retourne les revenus générés par ce livreur.
     *
     * @return Le revenu calculé.
     */
    public abstract double calculerRevenu();

    /**
     * Retourne la capacité de livraison pour ce livreur.
     *
     * @return La capacité du livreur.
     */
    public abstract int capaciteLivraison();

    /**
     * Retourne le nombre de livraisons en cours pour ce livreur.
     *
     * @return Le nombre de livraisons en cours.
     */
    public int nbLivraisonsEnCours() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::nbLivraisonsEnCours non implémentée");
        return 0;
    }


    /**
     * Retourne un itérateur sur les livraisons en cours de ce livreur.
     *
     * @return L'itérateur.
     */
    public Iterator<Livraison> donneIterateurLivraisonsEnCours() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::donneIterateurLivraisonsEnCours non implémentée");
        return null;
    }

    /**
     * Retourne le nombre de livraisons que ce livreur a effectué
     *
     * @return Le nombre de livraisons.
     */
    public int nbLivraisonsEffectuees() {
        // TODO : À compléter/modifier
        System.err.println("Méthode Livreur::nbLivraisonsEffectuees non implémentée");
        return 0;
    }
}
