package outil;

import metier.Personne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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

    public void ajoutEnfant(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!Objects.equals(list.get(i).getParentNom(), "")) {
                for (int j = 1; j < list.size(); j++) {
                    if (list.get(j).getNom().equals(list.get(i).getParentNom()) && list.get(j).getPrenom().equals(list.get(i).getParentPrenom())) {
                        list.get(j).setNombreEnfant(list.get(j).getNombreEnfant() + 1);
                    }
                }
            }
        }
    }


    public ArrayList<Personne> orderByNomEtPrenom(ArrayList<Personne> list) {
        orderByNom(list);
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getNom().compareTo(list.get(j).getNom()) < 0) && (list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) < 0)) {
                    Collections.swap(list, i, j);
                }
            }
        }
        return list;
    }

    public ArrayList<Personne> orderByNom(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getNom().compareTo(list.get(j).getNom()) < 0)) {
                    Collections.swap(list, i, j);
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
                            Collections.swap(list, i, j);
                        }
                    } else if (Integer.parseInt(list.get(i).getDateDeNaissance().getMois()) > Integer.parseInt(list.get(j).getDateDeNaissance().getMois())) {
                        Collections.swap(list, i, j);
                    }
                } else if (Integer.parseInt(list.get(i).getDateDeNaissance().getAnnee()) > Integer.parseInt(list.get(j).getDateDeNaissance().getAnnee())) {
                    Collections.swap(list, i, j);
                }
            }
        }
        return list;
    }


    private LocalDate age(int annee, int mois, int jour) {
        return LocalDate.of(annee, mois, jour);
    }

    public ArrayList<Personne> orderByPoidsNomPrenom(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (Integer.parseInt(list.get(i).getPoids()) == Integer.parseInt(list.get(j).getPoids())) {
                    if ((list.get(i).getNom().compareTo(list.get(j).getNom()) < 0)) {
                        if ((list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) > 0)) {
                            Collections.swap(list, i, j);
                        }
                    } else {
                        Collections.swap(list, i, j);
                    }
                } else if (Integer.parseInt(list.get(i).getPoids()) < Integer.parseInt(list.get(j).getPoids())) {
                    Collections.swap(list, i, j);
                }
            }
        }
        return list;
    }

    public ArrayList<Personne> orderByEnfantAgePrenomNom(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j).getNombreEnfant() < list.get(i).getNombreEnfant()) {
                    Collections.swap(list, i, j);
                } else if (list.get(j).getNombreEnfant() == list.get(i).getNombreEnfant()) {
                    if (Integer.parseInt(list.get(j).getDateDeNaissance().getAnnee()) > Integer.parseInt(list.get(i).getDateDeNaissance().getAnnee())) {
                        Collections.swap(list, i, j);
                    } else if (Integer.parseInt(list.get(j).getDateDeNaissance().getAnnee()) == Integer.parseInt(list.get(i).getDateDeNaissance().getAnnee())) {
                        if ((list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) < 0)) {
                            Collections.swap(list, i, j);
                        } else if ((list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) == 0)) {
                            if ((list.get(i).getNom().compareTo(list.get(j).getNom()) < 0)) {
                                Collections.swap(list, i, j);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

}