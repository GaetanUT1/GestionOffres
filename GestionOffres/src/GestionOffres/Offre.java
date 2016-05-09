package GestionOffres;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */

/**
 *
 * @author gaetan
 */
public abstract class Offre {
    private String titre ;
    private String region ;
    private HashMap<String,String> specifCompetence ;
    private String dateDeb ;
    private String dateFin ;
    

    public Offre(String inTitre, String inRegion, String inDateDeb ,String inDateFin) {
        this.titre = inTitre;
        this.region = inRegion;
        this.dateDeb = inDateDeb ;
        this.dateFin = inDateFin ;
        this.specifCompetence = new HashMap<>() ;
    }
    
    public void setCompetence(String inCompetence, String inCaractere){
        specifCompetence.putIfAbsent(inCompetence, inCaractere) ;
    }
    public String getTitre() {
        return this.titre ;
    }
    public String getRegion(){
        return this.region ;
    }
    public HashMap<String,String> getCompetence(){
        return this.specifCompetence ;
    }
    public String getDateDeb() {
        return dateDeb;
    }
    public String getDateFin() {
        return dateFin;
    }

    public Double Recherche1(String inRegion, ArrayList<String> inListeCompetence) {
        Double scoreOffre = 0.0 ;
        if (this.region.equals(inRegion)){
            scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) ;
        }
        return scoreOffre ;        
    }
    public Double scoreRegion(String inRegion){
        Double score = 0.0 ;
        if (this.region == inRegion) {
            score = 10.0 ;
        }
        return score;
    }
    public Double scoreCompetence(ArrayList<String> inListeCompetence){
        Double score = 0.0 ;
        int nbCompetences = inListeCompetence.size() ;
        for (int i=0;i<nbCompetences;i++){
            //System.out.println("Offre.scoreCompetence(I;COMPETENCE) : "+ i + " ; " + inListeCompetence.get(i));
            //System.out.println("Offre.scoreCompetence(INTERRO COMPETENCE) : " + specifCompetence.get(inListeCompetence.get(i)));
            if (specifCompetence.containsKey(inListeCompetence.get(i))){
                switch (specifCompetence.get(inListeCompetence.get(i))) {
                    case "o" :
                        score = score + 1.0 ;
                        // System.out.println("Offre.scoreCompetence(O)" + score);
                        break ;
                    case "s" :
                        score = score + 0.5 ;
                        // System.out.println("Offre.scoreCompetence(S)" + score);
                        break ;
                    default : break ;
                }
            }
        }
        if (score > 0.0) {
            score = score / nbCompetences ;
        }
        return score ;
    }
    
    
/* redefinition de la méthode toString pour afficher en clair le texte */
    @Override
    public String toString() {
        return "Offre{" + "titre=" + titre + ", region=" + region + ", specifCompetence=" + specifCompetence + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + '}';
    }

/* redefinition de la méthode hashcode pour pouvoir tester des égalités */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titre);
        hash = 37 * hash + Objects.hashCode(this.region);
        hash = 37 * hash + Objects.hashCode(this.specifCompetence);
        hash = 37 * hash + Objects.hashCode(this.dateDeb);
        hash = 37 * hash + Objects.hashCode(this.dateFin);
        return hash;
    }
    
/* redefinition de la méthode equals pour pouvoir tester l'égalité sémantique de 2 objets */
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        if (!Objects.equals(this.dateDeb, other.dateDeb)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.specifCompetence, other.specifCompetence)) {
            return false;
        }
        return true;
    }
}
