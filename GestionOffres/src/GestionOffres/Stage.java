package GestionOffres;

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

    /**
     * 
     * @todo : Travailler les overrides
     */    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
