package outil;

import metier.Aniversaire;
import metier.Personne;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Fichier {

    private String nomFichier;

    private Charset charset;

    public Fichier(String nomFichier, Charset charset) {
        this.nomFichier = nomFichier;
        this.charset = charset;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public ArrayList<Personne> lecture(BufferedReader bf) throws IOException {
        String ligne = "";
        Personne personne;
        int boucle = 0;
        ArrayList<Personne> listPersonne = new ArrayList<>();
        while ((ligne = bf.readLine()) != null) {
            personne = new Personne();

            ligne = ligne.replace(",,", ",null,");

            List<String> list = List.of(ligne.split(","));

            personne.setNom(list.get(0) + "");
            personne.setPrenom(list.get(1) + "");
            String[] splitAniv = list.get(2).split("/");
            Aniversaire newAniversaire = new Aniversaire();
            System.out.println(splitAniv[0]);
            newAniversaire.setJour(splitAniv[0]);
            if (splitAniv.length > 1) {
                newAniversaire.setMois(splitAniv[1]);
                newAniversaire.setAnnee(splitAniv[2]);
            }
            personne.setDateDeNaissance(newAniversaire);
            personne.setPoids(list.get(3) + "");
            personne.setParentNom((list.size() == 6) ? list.get(4) + "" : "");
            personne.setParentPrenom((list.size() == 6) ? list.get(5) + "" : "");
            listPersonne.add(boucle, personne);

            boucle++;
        }
        return listPersonne;
    }

    public void ecrire(ArrayList<Personne> lignes) {

        try (PrintWriter printwriter = new PrintWriter(
                new FileWriter(nomFichier, charset))) {

            for (Personne ligne : lignes)
                printwriter.println(ligne.getNom() + "," + ligne.getPrenom() + "," + ligne.getDateDeNaissanceToString() + "," + ligne.getPoids() + "," + ligne.getParentNom() + "," + ligne.getParentPrenom());

        } catch (IOException exception) {
            System.out.println(
                    "Erreur lors de l'écriture : " + exception.getMessage());
        }
    }
}
