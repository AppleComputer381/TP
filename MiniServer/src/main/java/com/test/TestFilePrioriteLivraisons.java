package com.test;

import com.gestionnaireLivraisons.FilePrioriteLivraisons;
import com.gestionnaireLivraisons.Livraison;
// TODO : À compléter/modifier

import java.util.Arrays;
import java.util.Random;

public class TestFilePrioriteLivraisons {
    /**
     * Test de la méthode estVide.
     */
    private static void testEstVide() {
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        System.out.print("Test estVide : ");
        if(file.estVide()){
            System.out.println("OK");
        }else{
            System.out.println("NOK");
        }

        // TODO : À compléter/modifier
        //em.err.println("Méthode TestFilePrioriteLivraisons::testEstVide() non implémentée");
    }

    /**
     * Test de la méthode ajouter.
     */
    private static void testAjouter() {
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        file.ajouter(FirstLivraison);
        if(file.estVide()){
            result = "NOK";
        }else{
            result = "OK";
        }
        System.out.println("Test ajouter : " + result);
    }

    /**
     * Test de la méthode ajouterTout.
     */
    private static void testAjouterTout() {
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENT, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENT, 2);
        file.ajouterTout(Arrays.asList(FirstLivraison, SecondLivraison, TreeLivraison, ForLivraison));
        
        if(file.taille() == 4){
            result = "OK";
        }else{
            result = "NOK";
        }
        System.out.print("Test ajouterTout : " + result);
    }

    /**
     * Test de la méthode taille.
     */
    private static void testTaille() {
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENT, 1);
        if(file.taille() == 0){
            result = "OK";
        }else{
            result = "NOK";
        }
        System.out.print("Test taille : " + result);
    }

    /**
     * Test de la méthode retirer.
     */
    private static void testRetirer() {
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENT, 1);
        file.ajouterTout(Arrays.asList(FirstLivraison, SecondLivraison));
        file.retirer();
        if(file.taille() == 1){
            result = "OK";
        }else{
            result = "NOK";
        }
        System.out.print("Test retirer : " + result);

        // TODO : À compléter/modifier
        //System.err.println("Méthode TestFilePrioriteLivraisons::testRetirer() non implémentée");
    }

    /**
     * Lancements des tests pour la classe FilePrioriteLivraisons.
     */
    public static void tests() {
        System.out.println("----- TEST FilePrioriteLivraisons -----");

        TestFilePrioriteLivraisons.testEstVide();
        TestFilePrioriteLivraisons.testAjouter();
        TestFilePrioriteLivraisons.testAjouterTout();
        TestFilePrioriteLivraisons.testTaille();
        TestFilePrioriteLivraisons.testRetirer();
    }
}
