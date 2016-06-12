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
 * Classe Offre : mère des classes Emploi, Stage
 * @author gaetan
 */
public abstract class Offre implements Comparable<Offre> {
    private String titre ;
    private String region ;
    private HashMap<String,String> specifCompetence ;
    private String dateDeb ;
    private String dateFin ;
    private float scoreOffre ;
    
    /**
     * Constructeur de la classe, n'étant appelé que depuis les classes filles
     * Emploi et Stage
     * @param inTitre
     * @param inRegion
     * @param inDateDeb
     * @param inDateFin
     */
    public Offre(String inTitre, String inRegion, String inDateDeb ,String inDateFin) {
        this.titre = inTitre;
        this.region = inRegion;
        this.dateDeb = inDateDeb ;
        this.dateFin = inDateFin ;
        this.specifCompetence = new HashMap<>() ;
        this.scoreOffre = 0 ;
    }
    
    /**
     * Permet d'ajouter une competence si besoin est
     * @param inCompetence est le libellé de la compétence
     * @param inCaractere est le caractère (obligatoire ou souhaité) de la compétence
     */
    public void setCompetence(String inCompetence, String inCaractere){
        specifCompetence.putIfAbsent(inCompetence, inCaractere) ;
    }
    
    /**
     * Permet de récupérer le titre de l'Offre
     * @return String représenant le titre de l'Offre
     */
    public String getTitre() {
        return this.titre ;
    }

    /**
     * Permet de récupérer la région de l'Offre
     * @return String réprésentant la région de l'Offre
     */
    public String getRegion(){
        return this.region ;
    }

    /**
     * Permet de récupérer les compétences de l'Offre
     * @return HashMap\<String,String\> Compétence & Caractère
     */
    public HashMap<String,String> getCompetence(){
        return this.specifCompetence ;
    }

    /**
     * Permet de récupérer la date de début de l'Offre
     * @return une date sous forme de String
     */
    public String getDateDeb() {
        return dateDeb;
    }
    
    /**
     * Permet de récupérer la date de fin de l'Offre
     * @return sous forme de String
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * Permet de récupérer le score d'une Offre
     * @return
     */
    public double getScore(){
        return scoreOffre ;
    }
    
    /**
     * Permet d'attribuer, après plusieurs calculs, un score à une Offre
     * @param inScore
     */
    public void setScore(float inScore){
        this.scoreOffre = inScore ;
    }

    /**
     * Premier cas de recherche : par région et compétences
     * Le retour est le score de l'Offre en fonction des critères donnés
     * Fait appel aux calculs de scrore de la Région et des Compétences
     * @param inRegion
     * @param inListeCompetence
     * @return
     */
    public float recherche1(String inRegion, ArrayList<String> inListeCompetence) {
        if (this.region.equals(inRegion)){
            this.scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) ;
        }
        return scoreOffre ;        
    }
    
    /**
     * Cas de recherche d'un Emploi : même principe que pour la méthode recherche1
     * avec en plus la notion de salaire
     * @param inRegion
     * @param inListeCompetence
     * @param inSalaireMin
     * @param inListeEmplois
     * @return
     */
    public float recherche2(String inRegion, ArrayList<String> inListeCompetence,float inSalaireMin, ArrayList<Emploi> inListeEmplois) {
        if (this.region.equals(inRegion)){
            this.scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) + this.scoreSalaire(inSalaireMin, inListeEmplois) ;
        }
        return scoreOffre ;        
    }
    
    /**
     * Permet de savoir si l'offre en question est un Stage ou un Emploi
     * @return String "emploi" ou "stage"
     */
    public String rechercheTypOffre(){
        if (this instanceof Stage) {
            return "stage" ;
        }
        else {
            return "emploi" ;
        }
    }

    /**
     * Compare la région passée en recherche et la région de l'Offre testée
     * et renvoie le score en fonction du résultat de la comparaison
     * @param inRegion
     * @return float représentant le score de la région pour l'Offre testée
     */
    public float scoreRegion(String inRegion){
        float score = 0 ;
        if (this.region.equals(inRegion)) {
            score = 10 ;
        }
        return score;
    }
    /**
     * Compare les compétences passées en recherche 
     * et les compétences de l'Offre testée
     * et renvoie le score en fonction du résultat de la comparaison
     * @param inListeCompetence 
     * @return float représentant le score des compétences pour l'Offre testée
     */   
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
    
    /**
     * Méthode abstraite qui ne sera implémentée que dans le cas d'un Emploi
     * Compare le salaire passé en recherche et le salaire de l'Offre testée
     * @param inSalaireMin
     * @param inListeEmplois
     * @return
     */
    public abstract float scoreSalaire(float inSalaireMin, ArrayList<Emploi> inListeEmplois);


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
