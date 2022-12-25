package metier;

public class Aniversaire implements Comparable<Aniversaire>{
    private String jour;
    private String mois;
    private String annee;

    public Aniversaire() {
    }

    public Aniversaire(String jour, String mois, String annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public int compareTo(Aniversaire o) {
        return 0;
    }
}
