package GestionOffres;

import java.util.ArrayList;

/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */

/**
 *
 * @author gaetan
 */
public class Stage extends Offre{
    
    /**
     * Constructeur d'un Stage avec tout l'attendu concerant un Stage
     * @param inTitre
     * @param inRegion
     * @param inDateDeb
     * @param inDateFin
     */
    public Stage(String inTitre, String inRegion, String inDateDeb, String inDateFin) {
    super(inTitre, inRegion, inDateDeb, inDateFin);
    }

    /**
     * Calcul final du score d'un stage
     * Utilisation du calcul du score Région et Compétences
     * @param inRegion
     * @param inListeCompetence
     * @return
     */
    public float rechercheStage(String inRegion, ArrayList<String> inListeCompetence){
        float scoreOffre ;
        scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) ;
        return scoreOffre ; 
    }
    /**
     * Pour finir de compléter la ligne démarrée dans la classe Offre
     * Comme un Emploi peut contenir des données supplémentaires, le toString
     * de la classe Offre ne ferme pas la ligne proprement, c'est cela qui le
     * fait.
     * @todo : Travailler les overrides
     * @return
     */    
    @Override
    public String toString() {
        return super.toString() + "}";
    }

    /**
     * La méthose scoreSalaire est abstraite
     * Elle ne s'applique pas aux offres de Stages qui n'ont pas de notion de
     *  salaire
     * @param inSalaireMin
     * @param inListeEmplois
     * @return
     */
    @Override
    public float scoreSalaire(float inSalaireMin, ArrayList<Emploi> inListeEmplois) {
        throw new UnsupportedOperationException("Les stages n'ont pas de notion de Salaire...");
    }
    
}
