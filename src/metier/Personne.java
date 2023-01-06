package metier;

public class Personne implements Comparable<Personne>{

    private String nom;
    private String prenom;
    private Aniversaire dateDeNaissance;
    private String poids;
    private String parentNom;
    private String parentPrenom;
    private int nombreEnfant = 0;

    public Personne() {
    }

    public Personne(String nom, String prenom, Aniversaire dateDeNaissance, String poids, String parentNom, String parentPrenom, int nombreEnfant) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.poids = poids;
        this.parentNom = parentNom;
        this.parentPrenom = parentPrenom;
        this.nombreEnfant = nombreEnfant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Aniversaire getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getDateDeNaissanceToString(){
        return dateDeNaissance.getJour() + "/" + dateDeNaissance.getMois() + "/" + dateDeNaissance.getAnnee();
    }

    public void setDateDeNaissance(Aniversaire dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getParentNom() {
        return parentNom;
    }

    public void setParentNom(String parentNom) {
        this.parentNom = parentNom;
    }

    public String getParentPrenom() {
        return parentPrenom;
    }

    public void setParentPrenom(String parentPrenom) {
        this.parentPrenom = parentPrenom;
    }

    public int getNombreEnfant() {
        return nombreEnfant;
    }

    public void setNombreEnfant(int nombreEnfant) {
        this.nombreEnfant = nombreEnfant;
    }

    @Override
    public int compareTo(Personne o) {
        return 0;
    }
}
