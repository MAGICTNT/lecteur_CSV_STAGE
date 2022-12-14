package vue;

import metier.Personne;
import outil.Fichier;
import outil.Trie;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Affichage {

    public void showTableau(ArrayList<Personne> list) {
        int flag = 0;
        for (Personne value : list) {
            if (flag == 0) {
                System.out.println(value.getNom() + "," + value.getPrenom() + "," + value.getDateDeNaissance().getJour() + "," + value.getPoids() + "," + value.getParentNom() + "," + value.getParentPrenom() + "/" + value.getNombreEnfant());
                flag++;
            } else {
                System.out.println(value.getNom() + "," + value.getPrenom() + "," + value.getDateDeNaissanceToString() + "," + value.getPoids() + "," + value.getParentNom() + "," + value.getParentPrenom() + "/" + value.getNombreEnfant());
            }
        }
    }

    public void questionEcriture(Scanner monScanner, ArrayList<Personne> arrayList, Fichier fichier) {
        System.out.println("\n");
        questionEcriture("Voulez-vous réécrire le fichier ?", "O/N : ");
        String response;
        response = monScanner.nextLine();

        while (!response.matches("[y|Y|o|O|n|N]")) {
            System.out.println("Réponse non prise en charge");
            questionEcriture("Voulez-vous réécrire le fichier ?", "O/N : ");
            response = monScanner.nextLine();
        }

        if (response.matches("[y|Y|o|O]")) {
            fichier.ecrire(arrayList);
            System.out.println("Fichier modifier");
        } else if (response.matches("[n|N]")) {
            System.out.println("Fichier non modifier");
        }
    }

    private static void questionEcriture(String x, String s) {
        System.out.println(x);
        System.out.print(s);
    }

    public String choix(Scanner monScanner) {
        String choixPossible = "null";
        while (!choixPossible.matches("[0-4]")) {
            System.out.println("Qu'elle trie, voulez vous faire ?");
            System.out.println("Triée par Date de Naissance                             -> 1");
            System.out.println("Triée par nom et prénom                                 -> 2");
            System.out.println("Triée par poids, nom et prénom                          -> 3");
            System.out.println("Triée par nombre d'enfants, age, prénom et nom          -> 4");
            System.out.println("Qu'elle est votre choix ?\n ");
            choixPossible = monScanner.nextLine();
            if (!choixPossible.matches("[0-4]")) {
                System.out.println("Choix non prix en charge");
            }
        }
        return choixPossible;
    }

    public void retourChoix(ArrayList<Personne> testArray, Trie trie, String order) throws ParseException {
        switch (Integer.parseInt(order)) {
            case 1:
                System.out.println("Ordre par Date Naissance");
                System.out.println("------------------------\n");
                trie.orderByAniv(testArray);
                break;
            case 2:
                System.out.println("Ordre par prénom et nom");
                System.out.println("------------------------\n");
                trie.orderByNomEtPrenom(testArray);
                break;
            case 3:
                System.out.println("Ordre par poids, prénom et nom");
                System.out.println("------------------------------\n");
                trie.orderByPoidsNomPrenom(testArray);
                break;
            case 4:
                System.out.println("Ordre par nombre d'enfants, age, prénom et nom");
                trie.orderByEnfantAgePrenomNom(testArray);
                break;
        }
    }
}
