package com.gestionnaireLivraisons;

public class ListeChaineeLivreurs implements IListeChaineeLivreurs {
    private Noeud tete;
    private Noeud dernier;
    private int nbreElements;

    /**
     * Constructeur
     */
    // TODO : À compléter/modifier
    public ListeChaineeLivreurs() {
        this.tete = null;
        this.dernier = null;
        this.nbreElements = 0;
    }

    /**
     * Ajoute un objet Livreur à la fin de la liste
     *
     * @param unLivreur Le livreur à ajouter.
     * @throws ListeChaineeException Si le livreur est déjà dans la liste.
     */
    @Override
    public void ajouter(Livreur unLivreur) throws ListeChaineeException {
        if (this.rechercher(unLivreur.getId()) != null) {
            throw new ListeChaineeException("Le livreur est déjà dans la liste");
        } else {
            if (this.tete == null) {
                this.tete = new Noeud(unLivreur);
                this.dernier = this.tete;
            } else {
                this.dernier.suivant = new Noeud(unLivreur);
                this.dernier = this.dernier.suivant;
            }
            this.nbreElements++;
        }

    }

    /**
     * Supprime un livreur à partir de son identifiant.
     *
     * @param idLivreur identifiant du livreur à supprimer.
     * @throws ListeChaineeException si le livreur n'existe pas dans la liste.
     */
    @Override
    public void supprimer(int idLivreur) throws ListeChaineeException {

        if (this.tete == null) {
            throw new ListeChaineeException("La liste est vide");
        }
        if (this.tete.livreur.getId() == idLivreur) {
            this.tete = this.tete.suivant;
            this.nbreElements--;
            return;
        } else {
            Noeud precedent = this.tete;
            Noeud temp = this.tete.suivant;
            while (temp != null) {
                if (temp.livreur.getId() == idLivreur) {
                    precedent.suivant = temp.suivant;
                    this.nbreElements--;
                    return;
                } else {
                    precedent = temp;
                    temp = temp.suivant;
                }
            }

            throw new ListeChaineeException("Livreur non présent dans la liste.");
        }

    }

    /**
     * Recherche un livreur par son id et le retourne.
     *
     * @param idLivreur identifiant du livreur à retrouver.
     * @return Le livreur ou null si non trouvé.
     */
    @Override
    public Livreur rechercher(int idLivreur) {
        if (this.tete == null) {
            return null;
            // si il n'y a qu'un seul element
        } else if (this.tete == this.dernier) {
            if (this.tete.livreur.getId() == idLivreur) {
                return this.tete.livreur;
            } else {
                return null;
            }
        } else {
            Noeud temp = this.tete;
            while (temp != null) {
                if (temp.livreur.getId() == idLivreur) {
                    return temp.livreur;
                } else {
                    temp = temp.suivant;
                }
            }
        }

        return null;
    }

    /**
     * Retourne le nombre d'éléments se trouvant dans la liste chaînée.
     *
     * @return Le nombre d'éléments.
     */
    @Override
    public int taille() {
        return nbreElements;
    }

    /**
     * Crée et retourne un tableau de livreurs pour cette liste chaînée de livreurs.
     *
     * @return Le tableau de livreurs.
     */
    public Livreur[] toArray() {
        Livreur[] tab = new Livreur[this.nbreElements];
        int i = 0;
        Noeud temp = this.tete;
        while (i < this.nbreElements) {
            tab[i] = temp.livreur;
            i++;
            temp = temp.suivant;
        }
        return tab;
    }

    /**
     * Implémente un neoud de la liste chainée
     *
     */
    private static class Noeud {
        private final Livreur livreur;
        private Noeud suivant;

        Noeud(Livreur livreur) {
            this.livreur = livreur;
            this.suivant = null;
        }
    }
}
