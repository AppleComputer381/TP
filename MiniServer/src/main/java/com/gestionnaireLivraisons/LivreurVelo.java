package com.gestionnaireLivraisons;

/**
 * La classe de livreur à vélo
 */
public class LivreurVelo extends Livreur {

    // definition des constantes
    private static final int CAPACITE = 2;
    private static final double REVENU = 5.0;
    private static final String TRANSPORT = "VELO";

    public LivreurVelo(int id, String nom) {
        super(id, nom);

    }

    @Override
    public int capaciteLivraison() {
        return CAPACITE;
    }

    @Override
    public double calculerRevenu() {
        return REVENU * this.nbLivraisonsEffectuees();
    }

    @Override
    public String getTransport() {
        return TRANSPORT;
    }
}
