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

    public ArrayList<Personne> orderByAniv(ArrayList<Personne> list) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((dateFormat.parse(list.get(i).getDateDeNaissance()).before(dateFormat.parse(list.get(j).getDateDeNaissance()))))
                    switchArray(list, i, j);
            }
        }
        return list;
    }

    public  ArrayList<Personne> orderByPoids(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if (Integer.parseInt(list.get(i).getPoids()) > Integer.parseInt(list.get(j).getPoids())) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }

    public  ArrayList<Personne> orderByPrenom(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getPrenom().compareTo(list.get(j).getPrenom()) < 0)) {
                    switchArray(list, i, j);

                }
            }
        }
        return list;
    }

    public ArrayList<Personne> orderByPoidsNomPrenom(ArrayList<Personne> list) {
        orderByNom(list);
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getNom().equals(list.get(j).getNom())) && (Integer.parseInt(list.get(i).getPoids()) > Integer.parseInt(list.get(j).getPoids()))) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }


    public  ArrayList<Personne> orderByNomEtPrenom(ArrayList<Personne> list) {
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

    public  ArrayList<Personne> orderByNom(ArrayList<Personne> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                if ((list.get(i).getNom().compareTo(list.get(j).getNom()) < 0)) {
                    switchArray(list, i, j);
                }
            }
        }
        return list;
    }
}
