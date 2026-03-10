package com.gestionnaireLivraisons;


public class ListeChaineeLivreurs implements IListeChaineeLivreurs {
    private Noeud tete;
    private Noeud dernier;
    private int nbreElements;

    /**
     * Constructeur
     */
    // TODO : À compléter/modifier

    /**
     * Ajoute un objet Livreur à la fin de la liste
     *
     * @param unLivreur Le livreur à ajouter.
     * @throws ListeChaineeException Si le livreur est déjà dans la liste.
     */
    @Override
    public void ajouter(Livreur unLivreur) throws ListeChaineeException {
        // TODO : À compléter/modifier
    }

    /**
     * Supprime un livreur à partir de son identifiant.
     *
     * @param idLivreur identifiant du livreur à supprimer.
     * @throws ListeChaineeException si le livreur n'existe pas dans la liste.
     */
    @Override
    public void supprimer(int idLivreur) throws ListeChaineeException {
        // TODO : À compléter/modifier
    }

    /**
     * Recherche un livreur par son id et le retourne.
     *
     * @param idLivreur identifiant du livreur à retrouver.
     * @return Le livreur ou null si non trouvé.
     */
    @Override
    public Livreur rechercher(int idLivreur) {
        // TODO : À compléter/modifier
        return null;
    }

    /**
     * Retourne le nombre d'éléments se trouvant dans la liste chaînée.
     *
     * @return Le nombre d'éléments.
     */
    @Override
    public int taille() {
        // TODO : À compléter/modifier
        return 0;
    }

    /**
     * Crée et retourne un tableau de livreurs pour cette liste chaînée de livreurs.
     *
     * @return Le tableau de livreurs.
     */
    public Livreur[] toArray() {
        // TODO : À compléter/modifier
        return null;
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
