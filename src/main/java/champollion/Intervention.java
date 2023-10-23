package champollion;

import java.util.Date;

public class Intervention {
    private Salle salle;
    private UE ue;
    private Enseignant enseignant;
    private Date debut;
    private int duree;
    private boolean annuler = false;
    private TypeIntervention type;

    public Intervention(Salle salle, UE ue, Enseignant enseignant, Date deb, int d, TypeIntervention type){
        this.debut = deb;
        this.duree = duree;
        this.salle = salle;
        this.ue = ue;
        this.enseignant = enseignant;
        this.type = type;

    }
    public void annuler(){
        this.annuler = true;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annuler;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annuler) {
        this.annuler = annuler;
    }

    public TypeIntervention getType() {
        return type;
    }

}