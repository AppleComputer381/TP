package com.gestionnaireLivraisons;

import com.atoudeft.commun.evenement.Arguments;
import com.atoudeft.commun.evenement.Evenement;
import com.atoudeft.commun.evenement.GestionnaireEvenement;
import com.atoudeft.commun.net.Connexion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * La classe pour gérer les erreurs d'identification des clients
 */
class AuthenticationException extends Exception {
}

/**
 * La classe qui permet de gérer des livraisons selon des évènements envoyés par
 * un livreur (client).
 */
public class GestionnaireLivraisons implements GestionnaireEvenement {
    // Emplacement du fichier contenant la liste des livreurs enregistrés.
    final private static String fichierLivreurs = "MiniServer/src/main/livreurs.txt";

    // Attributs d'ínstance pour un GestionnaireLivraisons
    final private IListeChaineeLivreurs livreursEnregistres;
    final private Hashtable<Connexion, Livreur> livreursAuthentifies;
    final private FilePrioriteLivraisons livraisonsAEffectuer;
    final private IListeLivraisons livraisonsEchouees;

    final private ArrayList<String> messagesId;

    /**
     * Construit un gestionnaire de livraisons.
     *
     */
    public GestionnaireLivraisons() {
        this.livreursEnregistres = new ListeChaineeLivreurs();
        this.lireFichierLivreurs();

        this.livreursAuthentifies = new Hashtable<>();
        this.livraisonsAEffectuer = LivraisonFactory.populateFileLivraisons();
        this.livraisonsEchouees = new ListeLivraisons();

        this.messagesId = new ArrayList<>();
    }

    /**
     * Lit le fichier des livreurs enregistrés.
     */
    private void lireFichierLivreurs() {
        try {
            List<String> lignes = Files.readAllLines(Path.of(GestionnaireLivraisons.fichierLivreurs),
                    StandardCharsets.UTF_8);

            for (String ligne : lignes) {
                ligne = ligne.trim();
                if (!ligne.isEmpty() && ligne.charAt(0) != '#') { // ignorer les commentaires et lignes vides.
                    Arguments args = new Arguments(new Evenement(null, null, ligne));
                    int idLivreur = Integer.parseInt(args.extraireArgumentSuivant());
                    String typeLivreur = args.extraireArgumentSuivant().toUpperCase();
                    String nomLivreur = args.lire();
                    Livreur livreur;

                    // Créer le livreur avec le constructeur approprié
                    switch (typeLivreur) {
                        case "VELO":
                            livreur = new LivreurVelo(idLivreur, nomLivreur);
                            break;
                        case "CAMION":
                            livreur = new LivreurCamion(idLivreur, nomLivreur);
                            break;
                        case "VOITURE":
                            livreur = new LivreurAuto(idLivreur, nomLivreur);
                            break;
                        default:
                            throw new IOException();
                    }
                    try {
                        this.livreursEnregistres.ajouter(livreur);
                    } catch (ListeChaineeException e) {
                        System.err.println("ERREUR dans l'ajout du livreur " + livreur.getNom() + " au fichier.");
                        System.exit(-1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("ERREUR dans la lecture du fichier de livreurs.");
            System.exit(-1);
        }
    }

    /**
     * Écrit le fichier des livreurs enregistrés.
     */
    private void ecrireFichierLivreurs() {
        try {
            StringBuilder contenu = new StringBuilder();

            for (Livreur livreur : this.livreursEnregistres.toArray()) {
                contenu.insert(0, livreur + "\n");
            }
            contenu.insert(0, "#  structure <id livreur> <type livreur> <nom livreur>\n");

            Files.writeString(Path.of(GestionnaireLivraisons.fichierLivreurs), contenu.toString(),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("ERREUR dans l'écriture du fichier de livreurs.");
            System.exit(-1);
        }
    }

    /**
     * Lance la sauvegarde des livreurs enregistrés avant de quitter le serveur.
     *
     */
    public void quitter() {
        this.ecrireFichierLivreurs();
    }

    /**
     * Affiche l'ensemble des livraisons à effectuer.
     *
     */
    public void afficherLivraisonsAEffectuer() {
        System.out.println("Liste des livraisons à effectuer :");
        System.out.println("(id, lot, priorité, tentative)");
        this.livraisonsAEffectuer.afficher();
    }

    /**
     * Affiche des statistiques concernant les livraisons.
     *
     */
    public void afficherStatistiques() {
        System.out.println("Statistiques des livraisons :");
        System.out.println("Nombre total de livraisons a effectuer : " + this.livraisonsAEffectuer.taille());
        System.out.println("Nombre de livreurs connectes : " + this.livreursAuthentifies.size());
        System.out.println("Nombre de livreurs enregistres : " + this.livreursEnregistres.taille());
    }

    /**
     * Applique la commande EXIT envoyée par un client.
     *
     * @param evenement L'évènement reçu.
     * @return La chaîne à renvoyer au client.
     */
    private String traiterEXIT(Evenement evenement) {
        Livreur livreur = this.livreursAuthentifies.get(evenement.getSource());
        if (livreur != null) {
            Iterator<Livraison> livreurLivraisonsEnCours = livreur.donneIterateurLivraisonsEnCours();
            while (livreurLivraisonsEnCours.hasNext()) {
                Livraison livraison = livreurLivraisonsEnCours.next();
                livraison.setStatut(Statut.EN_ATTENTE);
                this.livraisonsAEffectuer.ajouter(livraison);
                livreurLivraisonsEnCours.remove();
            }
            this.livreursAuthentifies.remove(evenement.getSource());
            return "END";
        } else {
            return "AUTHENTICATION_ERROR";
        }
    }

    /**
     * Applique la commande ID envoyée par un client.
     *
     * @param evenement L'évènement reçu.
     * @return La chaîne à renvoyer au client.
     */
    private String traiterID(Evenement evenement) {
        Arguments arguments = new Arguments(evenement);
        String argID = arguments.extraireArgumentSuivant();
        try {
            Livreur livreur = this.livreursEnregistres.rechercher(Integer.parseInt(argID));

            if (livreur != null) {
                if (!this.livreursAuthentifies.containsKey(evenement.getSource())) { // on verifie qu'il c'est pas deja
                                                                                     // connecte avec ce client
                    if (!this.livreursAuthentifies.containsValue(livreur)) { // on verifie qu'il n'est pas deja connecte
                                                                             // avec un autre client
                        this.livreursAuthentifies.put((Connexion) evenement.getSource(), livreur);
                        return "AUTHORIZED " + livreur.getId() + " " + livreur.getNom();
                    } else {
                        return "TOO_MANY_CONNECTIONS_ERROR";
                    }
                } else {
                    return "ALREADY_AUTHENTIFIED_ERROR";
                }

            } else {
                return "AUTHENTICATION_ERROR";
            }
        } catch (NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }

    }

    /**
     * Applique la commande REGISTER envoyée par le client.
     *
     * @param evenement L'évènement reçu.
     * @return La chaîne à renvoyer au client.
     */
    private String traiterREGISTER(Evenement evenement) {
        Arguments arguments = new Arguments(evenement);
        String argId = arguments.extraireArgumentSuivant();
        System.out.println("argId : " + argId);
        String argMode = arguments.extraireArgumentSuivant();
        System.out.println("argMode : " + argMode);
        String argNom = arguments.extraireArgumentSuivant();
        System.out.println("argNom : " + argNom);
        if (argId == null || argMode == null || argNom == null) {
            return "BAD_ARGUMENT_ERROR";
        }

        try {
            Livreur livreur = this.livreursEnregistres.rechercher(Integer.parseInt(argId));
            if (livreur != null) {
                return "ALREADY_REGISTERED_ERROR";
            } else {
                if (argMode.equals("VELO")) {
                    livreur = new LivreurVelo(Integer.parseInt(argId), argNom);

                } else if (argMode.equals("VOITURE")) {
                    livreur = new LivreurAuto(Integer.parseInt(argId), argNom);
                } else if (argMode.equals("CAMION")) {
                    livreur = new LivreurCamion(Integer.parseInt(argId), argNom);
                } else {
                    return "BAD_ARGUMENT_ERROR";
                }
                try {
                    this.livreursEnregistres.ajouter(livreur);
                } catch (ListeChaineeException e) {
                    return "BAD_ARGUMENT_ERROR";
                }
                return "REGISTERED " + livreur.getId() + " " + livreur.getNom();
            }

        } catch (NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }

    }

    /**
     * Applique la commande GET envoyée par un client.
     *
     * @param evenement L'évènement reçu.
     * @return La chaîne à renvoyer au client.
     */
    private String traiterGET(Evenement evenement) {
        Livreur livreur = this.livreursAuthentifies.get(evenement.getSource());
        if (livreur != null) {
            int capaciteLivraison = livreur.capaciteLivraison();
            int nbLivraisonsEnCours = livreur.nbLivraisonsEnCours();
            if (nbLivraisonsEnCours < capaciteLivraison) {
                while (nbLivraisonsEnCours < capaciteLivraison && !this.livraisonsAEffectuer.estVide()) {
                    Livraison livraison = this.livraisonsAEffectuer.retirer();
                    livraison.setStatut(Statut.EN_COURS);
                    livraison.nouvelleTentative();
                    livreur.ajouterLivraisonEnCours(livraison);
                    nbLivraisonsEnCours++;
                }
            }
            if (livreur.nbLivraisonsEnCours() == 0) {
                return "EMPTY";
            }
            String reponse = "";
            Iterator<Livraison> it = livreur.donneIterateurLivraisonsEnCours();
            while (it.hasNext()) {
                Livraison livraison = it.next();
                reponse += livraison.getId() + " " + livraison.getLot() + " " + livraison.getPriorite() + " "
                        + livraison.getTentative() + " ";
            }
            return "DELIVERIES " + String.valueOf(livreur.nbLivraisonsEnCours()) + " " + reponse;
        } else {
            return "AUTHENTICATION_ERROR";
        }

    }

    /**
     * Applique la commande DELIVERED envoyée par un client.
     *
     * @param evenement L'évènement reçu.
     * @return La chaîne à renvoyer au client.
     */
    private String traiterDELIVERED(Evenement evenement) {
        Livreur livreur = this.livreursAuthentifies.get(evenement.getSource());
        if (livreur != null) {
            Arguments arguments = new Arguments(evenement);
            String argId = arguments.extraireArgumentSuivant();
            try {
                int idLivraison = Integer.parseInt(argId);
                Livraison livraison = livreur.rechercherLivraisonEnCours(idLivraison);
                if (livraison != null) {
                    livraison.setStatut(Statut.LIVREE);
                    livreur.supprimerLivraisonEnCours(idLivraison);
                    livreur.ajouterLivraisonEffectuee(livraison);
                    return "DELIVERED_OK " + String.valueOf(idLivraison);
                } else {
                    return "BAD_DELIVERY_ERROR";
                }
            } catch (NumberFormatException e) {
                return "BAD_ARGUMENT_ERROR";
            }

        } else {
            return "AUTHENTICATION_ERROR";
        }

    }

    /**
     * Applique la commande FAILED envoyée par un client.
     *
     * @param evenement L'évènement reçu.
     * @return La chaîne à renvoyer au client.
     */
    private String traiterFAILED(Evenement evenement) {
        Livreur livreur = this.livreursAuthentifies.get(evenement.getSource());
        if (livreur != null) {
            Arguments arguments = new Arguments(evenement);
            String argId = arguments.extraireArgumentSuivant();
            try {
                int idLivraison = Integer.parseInt(argId);
                Livraison livraison = livreur.rechercherLivraisonEnCours(idLivraison);
                if (livraison != null) {

                    livreur.supprimerLivraisonEnCours(idLivraison);
                    boolean possible = livraison.nouvelleTentative();
                    if (possible) {
                        livraison.setStatut(Statut.EN_ATTENTE);
                        this.livraisonsAEffectuer.ajouter(livraison);
                        return "FAILED_CONTINUE " + String.valueOf(idLivraison);
                    } else {
                        this.livraisonsEchouees.ajouter(livraison);
                        livraison.setStatut(Statut.ECHOUEE);
                        return "FAILED_ABORT " + String.valueOf(idLivraison);
                    }
                } else {
                    return "BAD_DELIVERY_ERROR";
                }
            } catch (NumberFormatException e) {
                return "BAD_ARGUMENT_ERROR";
            }
        } else {
            return "AUTHENTICATION_ERROR";
        }
    }

    /**
     * Calcule et retourne le revenu produit par un livreur.
     *
     * @param evenement L'évènement reçu.
     */
    private String traiterINCOME(Evenement evenement) {
        Livreur livreur = this.livreursAuthentifies.get(evenement.getSource());
        if (livreur != null) {
            return "REVENU " + String.valueOf(livreur.calculerRevenu()) + " "
                    + String.valueOf(livreur.nbLivraisonsEffectuees());
        } else {
            return "AUTHENTICATION_ERROR";
        }
    }

    /**
     * Retourne toutes les livraisons en cours pour le livreur concerné.
     *
     * @param evenement Événement de type INFO à traiter.
     * @return La chaine constituant la réponse à retourner au client.
     */
    private String traiterINFO(Evenement evenement) {
        Livreur livreur = this.livreursAuthentifies.get(evenement.getSource());
        if (livreur == null) {
            return "AUTHENTICATION_ERROR";
        }

        Arguments arg = new Arguments(evenement);
        String strIdLivraison = arg.extraireArgumentSuivant();
        if (strIdLivraison != null) {
            try {
                int idLivraison = Integer.parseInt(strIdLivraison);
                Livraison livraison = livreur.rechercherLivraisonEnCours(idLivraison);
                if (livraison != null) {
                    return "DELIVERIES_INFO 1" + " " + livraison.getId() + " " + livraison.getLot() + " "
                            + livraison.getPriorite() + " " + livraison.getTentative();
                } else {
                    return "BAD_DELIVERY_ERROR";
                }
            } catch (NumberFormatException e) {
                return "BAD_ARGUMENT_ERROR";
            }
        } else {
            if (livreur.nbLivraisonsEnCours() == 0) {
                return "NO_DELIVERY_ERROR";
            } else {
                String reponse = "";
                Iterator<Livraison> it = livreur.donneIterateurLivraisonsEnCours();
                while (it.hasNext()) {
                    Livraison l = it.next();
                    reponse += l.getId() + " " + l.getLot() + " " + l.getPriorite() + " " + l.getTentative() + " ";
                }
                return "DELIVERIES_INFO " + String.valueOf(livreur.nbLivraisonsEnCours()) + " " + reponse;
            }
        }
    }

    /**
     * Le client envoie un message à un autre ou à d'autres livreurs.
     *
     * @param evenement Événement de type INFO à traiter.
     * @return La chaine constituant la réponse à retourner au client.
     */
    private String traiterSEND(Evenement evenement) {

        Livreur expediteur = this.livreursAuthentifies.get(evenement.getSource());

        if (expediteur == null) {
            return "AUTHENTICATION_ERROR";
        }
        Arguments args = new Arguments(evenement);
        String argId = args.extraireArgumentSuivant();
        String destinataire = args.extraireArgumentSuivant();
        String argMessage = args.lire();
        if (argId == null || destinataire == null || argMessage == null) {
            return "BAD_ARGUMENT_ERROR";
        }
        if (this.messagesId.contains(argId)) {
            return "ACK " + argId;
        }

        if (destinataire.equals("*")) {
            for (Connexion connexion : this.livreursAuthentifies.keySet()) {
                if (connexion != evenement.getSource()) {
                    connexion.envoyer("MSG " + expediteur.getId() + " " + argMessage);
                }
            }
            this.messagesId.add(argId);
            return "ACK " + argId;
        } else {
            for (Connexion cnx : this.livreursAuthentifies.keySet()) {
                Livreur livreurDest = this.livreursAuthentifies.get(cnx);
                try {
                    if (livreurDest.getId() == Integer.parseInt(destinataire)) {
                        cnx.envoyer("MSG " + expediteur.getId() + " " + argMessage);
                        this.messagesId.add(argId);
                        return "ACK " + argId;
                    }
                } catch (NumberFormatException e) {
                    return "BAD_ARGUMENT_ERROR";
                }
            }
            return "BAD_ARGUMENT_ERROR";

        }

    }

    /**
     * Renvoie un message d'erreur au client pour cause d'évènement inconnu.
     *
     * @return La chaîne à renvoyer au client.
     */
    private String traiterCOMMAND_ERROR() {
        String reponse;

        reponse = "COMMAND_ERROR";

        return reponse;
    }

    /**
     * Gère un évènement reçu en paramètre.
     *
     * @param evenement L'événement a géré.
     */
    @Override
    public void traiter(Evenement evenement) {
        Object source = evenement.getSource();

        if (source instanceof Connexion) {
            Connexion cnx = (Connexion) source;
            System.out.println("GEST. LIV. a reçu : " + evenement.getType() + " " + evenement.getArgument());

            String reponse = "";
            switch (evenement.getType().toUpperCase()) {
                case "EXIT": // Le client se déconnecte.
                    reponse = this.traiterEXIT(evenement);
                    break;
                case "REGISTER": // Le client s'enregistre comme nouveau livreur.
                    reponse = this.traiterREGISTER(evenement);
                    break;
                case "ID": // Le client s'identifie.
                    reponse = this.traiterID(evenement);
                    break;
                case "GET": // Le client a demandé des livraisons à effectuer.
                    reponse = this.traiterGET(evenement);
                    break;
                case "DELIVERED": // Le client informe qu'une livraison a été effectuée.
                    reponse = this.traiterDELIVERED(evenement);
                    break;
                case "FAILED": // Le client informe qu'une livraison n'a pas pu être effectuée.
                    reponse = this.traiterFAILED(evenement);
                    break;
                case "INCOME":
                    reponse = this.traiterINCOME(evenement);
                    break;
                case "INFO":
                    reponse = this.traiterINFO(evenement);
                    break;
                case "SEND":
                    reponse = this.traiterSEND(evenement);
                    break;
                default: // La commande envoyée par le client n'a pas été reconnue.
                    reponse = this.traiterCOMMAND_ERROR();
            }

            cnx.envoyer(reponse);
        }
    }
}
