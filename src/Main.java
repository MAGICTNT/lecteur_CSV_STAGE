import metier.Personne;
import outil.Fichier;
import outil.Trie;
import vue.Affichage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner monScanner = new Scanner(System.in);
        ArrayList<Personne> listCsv = new ArrayList<>();
        String fichierCSV = "data.csv";
        Affichage affichage = new Affichage();
        Charset charset = StandardCharsets.UTF_8;
        Trie trie = new Trie();

        Fichier fichier = new Fichier(fichierCSV, charset);

        try {
            BufferedReader bf = new BufferedReader(new FileReader(fichierCSV));
            listCsv = fichier.lecture(bf);

            String choixPossibilite = "5";

            choixPossibilite = affichage.choix(monScanner, choixPossibilite);

            System.out.println("\n");

            affichage.retourChoix(listCsv, trie, choixPossibilite);
            affichage.showTableau(listCsv);
            affichage.questionEcriture(monScanner, listCsv, fichier);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fichier non trouver");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
