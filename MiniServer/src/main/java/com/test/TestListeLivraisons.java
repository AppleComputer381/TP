package com.test;

import com.gestionnaireLivraisons.*;

public class TestListeLivraisons {
    /**
     * Test de la méthode ajouter.
     */
    private static void testAjouter() {
        System.out.print("Test ajouter : ");
        ListeLivraisons liste = new ListeLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENTE, 2);

        liste.ajouter(FirstLivraison);
        liste.ajouter(SecondLivraison);
        liste.ajouter(TreeLivraison);
        liste.ajouter(ForLivraison);
        if (liste.taille() == 4) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode supprimer.
     */
    private static void testSupprimer() {
        System.out.print("Test supprimer : ");
        ListeLivraisons liste = new ListeLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENTE, 2);

        liste.ajouter(FirstLivraison);
        liste.ajouter(SecondLivraison);
        liste.ajouter(TreeLivraison);
        liste.ajouter(ForLivraison);
        liste.supprimer(FirstLivraison.getId());
        if (liste.taille() == 3) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode rechercher.
     */
    private static void testRechercher() {
        System.out.print("Test rechercher : ");
        ListeLivraisons liste = new ListeLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENTE, 2);

        liste.ajouter(FirstLivraison);
        liste.ajouter(SecondLivraison);
        liste.ajouter(TreeLivraison);
        liste.ajouter(ForLivraison);
        if (liste.rechercher(ForLivraison.getId()) == ForLivraison) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode vider.
     */
    private static void testVider() {
        System.out.print("Test vider : ");
        ListeLivraisons liste = new ListeLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENTE, 2);

        liste.ajouter(FirstLivraison);
        liste.ajouter(SecondLivraison);
        liste.ajouter(TreeLivraison);
        liste.ajouter(ForLivraison);
        liste.vider();
        if (liste.taille() == 0) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode estVide.
     */
    private static void testEstVide() {
        System.out.print("Test estVide : ");
        ListeLivraisons liste = new ListeLivraisons();
        if (liste.estVide()) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode taille.
     */
    private static void testTaille() {
        System.out.print("Test taille : ");
        ListeLivraisons liste = new ListeLivraisons();
        Livraison firstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison secondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison treeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison fourLivraison = new Livraison(Priorite.URGENTE, 2);

        liste.ajouter(firstLivraison);
        liste.ajouter(secondLivraison);
        liste.ajouter(treeLivraison);
        liste.ajouter(fourLivraison);
        if (liste.taille() == 4) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    private static void testRechercherNonExistant() {
        System.out.print("Test rechercher inexistante : ");
        ListeLivraisons liste = new ListeLivraisons();
        Livraison firstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison secondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison threeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison fourLivraison = new Livraison(Priorite.URGENTE, 2);

        liste.ajouter(firstLivraison);
        liste.ajouter(secondLivraison);
        liste.ajouter(threeLivraison);
        liste.ajouter(fourLivraison);
        if (liste.rechercher(5) == null) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Lancements des tests pour la classe ListeChaineeLivreurs.
     */
    public static void tests() {
        System.out.println("----- TEST ListeLivraisons -----");

        TestListeLivraisons.testAjouter();
        TestListeLivraisons.testSupprimer();
        TestListeLivraisons.testRechercher();
        TestListeLivraisons.testRechercherNonExistant();
        TestListeLivraisons.testVider();
        TestListeLivraisons.testEstVide();
        TestListeLivraisons.testTaille();
    }
}
