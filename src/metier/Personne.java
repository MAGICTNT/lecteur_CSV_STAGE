package metier;

public class Personne implements Comparable<Personne>{

    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String poids;
    private String parentNom;
    private String parentPrenom;

    public Personne(String nom, String prenom, String dateDeNaissance, String parentNom, String parentPrenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.parentNom = parentNom;
        this.parentPrenom = parentPrenom;
    }
    public Personne() {
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

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
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

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    @Override
    public int compareTo(Personne o) {
        return 0;
    }
}
