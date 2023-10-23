package champollion;
import java.util.ArrayList;
import java.util.LinkedList;
public class Enseignant extends Personne {
    ArrayList<ServicePrevu> serviceprevu = new ArrayList<>();
    LinkedList<Intervention> interventions = new LinkedList<>();


    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    public float heuresPrevues() {
        int equivalentTD = 0;
        for (ServicePrevu servicep : serviceprevu){
            equivalentTD += 1.5 * servicep.getVolumeCM();
            equivalentTD += servicep.getVolumeTD();
            equivalentTD += 0.75 * servicep.getVolumeTP();
        }
        return Math.round(equivalentTD);
    }

    public int heuresPrevuesPourUE(UE ue) {
        int equivalentTD = 0;

        for (ServicePrevu servicep : serviceprevu){
            if (servicep.getUe() == ue){
                equivalentTD += 1.5 * servicep.getVolumeCM();
                equivalentTD += servicep.getVolumeTD();
                equivalentTD += 0.75 * servicep.getVolumeTP();
            }
        }
        return Math.round(equivalentTD);
    }


    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu servicep = new ServicePrevu (volumeCM, volumeTD, volumeTP, ue, this);
        serviceprevu.add(servicep);
    }
    public boolean sousService () {

        if (this.heuresPrevues () < 192) {
            return true ;
        }
        else return false ;
    }
    public void ajouteInterventions(Intervention e){
        interventions.add(e);

    }


    public int resteAPlanifier(UE ue, TypeIntervention type)
    {
        int result = 0;
        if(type == TypeIntervention.TD)
        {
            result = 192 - ue.getHeuresTD();
        }
        if(type == TypeIntervention.CM)
        {
            result = 192 - ue.getHeuresCM();
        }
        if(type == TypeIntervention.TP)
        {
            result = 192 - ue.getHeuresTP();
        }
        if(result < 0)
        {
            result = 0;
        }
        return result;
    }



}
