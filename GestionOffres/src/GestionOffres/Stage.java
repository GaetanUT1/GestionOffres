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
    
    public Stage(String inTitre, String inRegion, String inDateDeb, String inDateFin) {
    super(inTitre, inRegion, inDateDeb, inDateFin);
    }

    public float rechercheStage(String inRegion, ArrayList<String> inListeCompetence){
        float scoreOffre = 0 ;
        scoreOffre = this.scoreRegion(inRegion) + this.scoreCompetence(inListeCompetence) ;
        return scoreOffre ; 
    }
    /**
     * 
     * @todo : Travailler les overrides
     */    
    @Override
    public String toString() {
        return super.toString() + "}";
    }

    @Override
    public float scoreSalaire(float inSalaireMin, ArrayList<Emploi> inListeEmplois) {
        throw new UnsupportedOperationException("Les stages n'ont pas de notion de Salaire...");
    }
    
}
