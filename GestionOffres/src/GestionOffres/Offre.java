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
public abstract class Offre implements Comparable<Offre> {
    private String titre ;
    private String region ;
    private HashMap<String,String> specifCompetence ;
    private String dateDeb ;
    private String dateFin ;
    private float scoreOffre ;
    

    public Offre(String inTitre, String inRegion, String inDateDeb ,String inDateFin) {
        this.titre = inTitre;
        this.region = inRegion;
        this.dateDeb = inDateDeb ;
        this.dateFin = inDateFin ;
        this.specifCompetence = new HashMap<>() ;
        this.scoreOffre = 0 ;
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
    public double getScore(){
        return scoreOffre ;
    }
    
    public void setScore(float inScore){
        this.scoreOffre = inScore ;
    }

    public float recherche1(String inRegion, ArrayList<String> inListeCompetence) {
        if (this.region.equals(inRegion)){
            this.scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) ;
        }
        return scoreOffre ;        
    }
    
    public float recherche2(String inRegion, ArrayList<String> inListeCompetence,float inSalaireMin, ArrayList<Emploi> inListeEmplois) {
        if (this.region.equals(inRegion)){
            this.scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) + this.scoreSalaire(inSalaireMin, inListeEmplois) ;
        }
        return scoreOffre ;        
    }
    
    
    public String rechercheTypOffre(){
        if (this instanceof Stage) {
            return "stage" ;
        }
        else {
            return "emploi" ;
        }
    }

    public float scoreRegion(String inRegion){
        float score = 0 ;
        if (this.region.equals(inRegion)) {
            score = 10 ;
        }
        return score;
    }
    
    public float scoreCompetence(ArrayList<String> inListeCompetence){
        float score = 0 ;
        int nbCompetences = inListeCompetence.size() ;
        for (int i=0;i<nbCompetences;i++){
            if (specifCompetence.containsKey(inListeCompetence.get(i))){
                switch (specifCompetence.get(inListeCompetence.get(i))) {
                    case "o" :
                        score = score + 1 ;
                        break ;
                    case "s" :
                        /* Le "F" permet de réduire la précision de la précision 
                         * de la valeur flottante ecrite
                        */
                        score = score + 0.5F ;
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
    
    public abstract float scoreSalaire(float inSalaireMin, ArrayList<Emploi> inListeEmplois) ;


    /* Redéfinition de la méthode compareTo afin de pouvoir utiliser le tri
     * de l'ArrayList    
    */
    @Override
    public int compareTo(Offre inOffre){
        return new Double(scoreOffre).compareTo(inOffre.getScore()) ;
    }
    
/* redefinition de la méthode toString pour afficher en clair le texte */
    @Override
    public String toString() {
        return "Offre{" + "titre=" + titre + ", region=" + region + ", specifCompetence=" + specifCompetence + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", scoreOffre=" + scoreOffre;
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
        if (!Objects.equals(this.scoreOffre, other.scoreOffre)) {
            return false;
        }
        return true;
    }

}
