package com.gestionnaireLivraisons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * La classe qui modélise un livreur.
 */
public abstract class Livreur {
    // Les attrbuts d'un livreur
    private int id;
    private String nom;
    private ListeLivraisons livraisonsEnCours;
    private ListeLivraisons livraisonsEffectuees;

    /**
     * Construit un nouveau livreur.
     *
     * @param id  L'id du nouveau livreur.
     * @param nom Le nom du nouveau livreur.
     */
    public Livreur(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.livraisonsEnCours = new ListeLivraisons();
        this.livraisonsEffectuees = new ListeLivraisons();
    }

    /**
     * L'accesseur pour l'id du livreur.
     *
     * @return L'id de ce livreur.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter pour le livreur.
     *
     * @return Le nom de ce livreur.
     */
    public String getNom() {
        return this.nom;
    }

    public abstract String getTransport();

    /**
     * Vérifie si un livreur a des livraisons en cours.
     *
     * @return true si oui, false sinon.
     */
    public boolean aDesLivraisonsEnCours() {
        return !this.livraisonsEnCours.estVide();
    }

    /**
     * Ajoute une livraison aux livraisons en cours.
     *
     * @param livraison La livraison à ajouter.
     */
    public void ajouterLivraisonEnCours(Livraison livraison) {
        this.livraisonsEnCours.ajouter(livraison);
    }

    /**
     * Ajoute une livraison aux livraisons effectuées.
     *
     * @param livraison La livraison à ajouter.
     */
    public void ajouterLivraisonEffectuee(Livraison livraison) {
        this.livraisonsEffectuees.ajouter(livraison);
    }

    /**
     * Supprimer une livraison des livraisons en cours.
     *
     * @param idLivraison L'i de la livraison à supprimer.
     * @return La livraison supprimée ou null si non trouvée.
     */
    public Livraison supprimerLivraisonEnCours(int idLivraison) {

        return this.livraisonsEnCours.supprimer(idLivraison);
    }

    /**
     * Supprime et retourne toutes les livraisons en cours pour ce livreur.
     *
     * @return La liste des livraisons en cours avant suppressions.
     */
    public IListeLivraisons supprimerToutesLesLivraisons() {
        ListeLivraisons listecopie = this.livraisonsEnCours;
        this.livraisonsEnCours = new ListeLivraisons();
        return listecopie;
    }

    /**
     * Retourne une livraison d'après son id.
     *
     * @param idLivraison L'id de la livraison à trouver.
     * @return La livraison si trouvée, null sinon.
     */
    public Livraison rechercherLivraisonEnCours(int idLivraison) {
        return this.livraisonsEnCours.rechercher(idLivraison);
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
        return this.livraisonsEnCours.taille();
    }

    /**
     * Retourne un itérateur sur les livraisons en cours de ce livreur.
     *
     * @return L'itérateur.
     */
    public Iterator<Livraison> donneIterateurLivraisonsEnCours() {
        return this.livraisonsEnCours.iterator();
    }

    /**
     * Retourne le nombre de livraisons que ce livreur a effectué
     *
     * @return Le nombre de livraisons.
     */
    public int nbLivraisonsEffectuees() {
        return this.livraisonsEffectuees.taille();
    }

    public String toString() {
        return this.getId() + " " + this.getTransport() + " " + this.getNom();
    }
}
