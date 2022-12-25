package outil;

import metier.Personne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Trie {
    public ArrayList<Personne> switchArray(ArrayList<Personne> list, int i, int j) {
        Personne tmp = new Personne();

        tmp.setNom(list.get(i).getNom());
        tmp.setPrenom(list.get(i).getPrenom());
        tmp.setPoids(list.get(i).getPoids());
        tmp.setDateDeNaissance(list.get(i).getDateDeNaissance());
        tmp.setParentNom(list.get(i).getParentNom());
        tmp.setParentPrenom(list.get(i).getParentPrenom());

        list.get(i).setNom(list.get(j).getNom());
        list.get(i).setPrenom(list.get(j).getPrenom());
        list.get(i).setPoids(list.get(j).getPoids());
        list.get(i).setDateDeNaissance(list.get(j).getDateDeNaissance());
        list.get(i).setParentNom(list.get(j).getParentNom());
        list.get(i).setParentPrenom(list.get(j).getParentPrenom());


        list.get(j).setNom(tmp.getNom());
        list.get(j).setPrenom(tmp.getPrenom());
        list.get(j).setPoids(tmp.getPoids());
        list.get(j).setDateDeNaissance(tmp.getDateDeNaissance());
        list.get(j).setParentNom(tmp.getParentNom());
        list.get(j).setParentPrenom(tmp.getParentPrenom());

        return list;
    }


    public ArrayList<Personne> orderByNomEtPrenom(ArrayList<Personne> list) {
        orderByNom(list);
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getNom().equals(list.get(j).getNom())) && (list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) < 0)) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }

    public ArrayList<Personne> orderByNom(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getNom().compareTo(list.get(j).getNom()) < 0)) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }

    public ArrayList<Personne> orderByAniv(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (Integer.parseInt(list.get(i).getDateDeNaissance().getAnnee()) == Integer.parseInt(list.get(j).getDateDeNaissance().getAnnee())) {
                    if (Integer.parseInt(list.get(i).getDateDeNaissance().getMois()) == Integer.parseInt(list.get(j).getDateDeNaissance().getMois())) {
                        if (Integer.parseInt(list.get(i).getDateDeNaissance().getJour()) > Integer.parseInt(list.get(j).getDateDeNaissance().getJour())) {
                            switchArray(list, i, j);
                        }
                    } else if (Integer.parseInt(list.get(i).getDateDeNaissance().getMois()) > Integer.parseInt(list.get(j).getDateDeNaissance().getMois())) {
                        switchArray(list, i, j);
                    }
                } else if (Integer.parseInt(list.get(i).getDateDeNaissance().getAnnee()) > Integer.parseInt(list.get(j).getDateDeNaissance().getAnnee())) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }

    public ArrayList<Personne> choix3(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (Integer.parseInt(list.get(i).getPoids()) == Integer.parseInt(list.get(j).getPoids())) {
                    System.out.println(list.get(i).getPrenom().compareTo(list.get(j).getPrenom()));
                    if ((list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) < 0)) {
                        if ((list.get(i).getNom().compareTo(list.get(j).getNom()) >= 0)) {
                            switchArray(list, i, j);
                        }
                    } else {
                        switchArray(list, i, j);
                    }
                } else if (Integer.parseInt(list.get(i).getPoids()) < Integer.parseInt(list.get(j).getPoids())) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }
}