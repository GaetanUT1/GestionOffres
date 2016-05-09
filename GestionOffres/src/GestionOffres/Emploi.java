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
public class Emploi extends Offre {
    private int experience;
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
    
    public int getExperience() {
        return this.experience;
    }

    public float getSalaireMin() {
        return salaireMin;
    }

    public float getSalaireMax() {
        return salaireMax;
    }
    
    
/**
 * 
     * @return 
 * @todo : Travailler les overrides
 */    

    @Override
    public String toString() {
        return super.toString();
    }
}
