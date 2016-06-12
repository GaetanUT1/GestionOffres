package GestionOffres;

import java.util.ArrayList;

/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */

/**
 * Classe fille de la super classe Offre
 * Elle représente un Emploi.
 * Spécificités : 
 * - la notion d'expérience (en années)
 * - les notions de salaire (min et max)
 * @author gaetan
 */
public class Emploi extends Offre {
    private final int experience;
    private float salaireMin = 0 ;
    private float salaireMax = 0 ; 
    
    /**
     * Constructeur de la Classe.
     * S'appui sur le constructeur de la superclasse.
     * Ajoute les 3 attributs spécifiques suivants : inExpe inSalaireMin inSalaireMax
     * @param inTitre
     * @param inRegion
     * @param inDateDeb
     * @param inDateFin
     * @param inExpe est l'attribut spécifique représentant les années d'expérience sous la forme d'un nombre entier
     * @param inSalaireMin est l'attribut spécifique représentant le salaire minimum sous la forme d'un float
     * @param inSalaireMax est l'attribut spécifique représentant le salaire maximum sous la forme d'un float
     */
    public Emploi(String inTitre, String inRegion, int inExpe, float inSalaireMin, float inSalaireMax, String inDateDeb, String inDateFin) {
        super(inTitre, inRegion, inDateDeb, inDateFin);
        this.experience = inExpe ;
        this.salaireMin = inSalaireMin ;
        this.salaireMax = inSalaireMax ;
    }
    
    /**
     * Pour récupérer les années d'expériences requises pour l'Emploi
     * @return un integer donnant le nombre d'années d'expérience de l'Emploi
     */
    public int getExperience() {
        return this.experience;
    }

    /**
     * Pour récupérer le salaire minimum offert par l'Emploi
     * @return float salaire minimum
     */
    public float getSalaireMin() {
        return salaireMin;
    }

    /**
     * Pour récupérer le salaire maximum offert par l'Emploi
     * @return float salaire maximum
     */
    public float getSalaireMax() {
        return salaireMax;
    }

    /**
     * Sert à calculer le score d'un stage, mais tant qu'on n'est pas passé
     * par cette méthode on ne sait pas si l'Offre est un Stage ou un Emploi.
     * @param inRegion
     * @param inListeCompetence
     */
    public void rechercheStage(String inRegion, ArrayList<String> inListeCompetence){
        System.out.println("Pas un Stage !");
    }
    
    /**
     * Spécifique à Emploi : la notion de salaire
     * Méthode servant à attribuer un score sur la notion de salaire
     * Algo :
     * Recherche du salaire maxi dans la liste des offres d'emploi
     * SI le salaire en entrée > salaire maxi trouvé
     *  ALORS score = 5-(inSalaireMin - Max du salaire des offres) / 1000
     *  SINON score = 5
     * FINSI
     * @param inSalaireMin est le salaire en entrée
     * @param inListeEmplois est la liste des Emplois sélectionnés pour comparer
     * @return
     */
    @Override
    public float scoreSalaire(float inSalaireMin, ArrayList<Emploi> inListeEmplois){
        System.out.println("==========================");
        System.out.println("CALCUL du Score du salaire");
        
        float score ;
        float salaireMaxTrouve = 0 ;
        
        // Recherche du salaire maxi dans la liste des offres d'emploi
        for (int i=0;i<inListeEmplois.size();i++){
            if(inListeEmplois.get(i).getSalaireMax() > salaireMaxTrouve){
                salaireMaxTrouve = inListeEmplois.get(i).getSalaireMax() ;
            }
        }
        System.out.println("Salaire maxi du tableau (attendu = 20000) : " + salaireMaxTrouve );
        System.out.println("Salaire min comparé (attendu = 35000) : " + inSalaireMin);
        
        if(inSalaireMin > salaireMaxTrouve){
            score = 5-((inSalaireMin - salaireMaxTrouve)/1000) ; }
        else {
            score = 5 ; }
        
        System.out.println("Score calculé : " + score);
        
        /* SI inSalaireMin > Max
         * ALORS score = 5-(inSalaireMin - Max du salaire des offres) / 1000
         * SINON score = 5
        */
        System.out.println("CALCUL du Score du salaire");
        System.out.println("==========================");
        
        return score ;
    }

 
    
/**
 * 
     * @return 
 * @todo : Travailler les overrides
 */    
   @Override
    public String toString() {
        return super.toString() + " // Spé Emploi : " + "experience=" + experience + ", salaireMin=" + salaireMin + ", salaireMax=" + salaireMax + '}';
    }


}
