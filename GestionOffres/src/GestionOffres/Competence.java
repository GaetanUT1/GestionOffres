package GestionOffres;

/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */

/**
 * Classe représentant les compétences utilisées dans la gestion des offres
 * @author gaetan
 */
public class Competence {
    String libelle ;
    
    /**
     * Méthode pour récupérer le libellé de la Compétence
     * Sera associé au caractère Obligatoire ou Souhaité de la Compétence
     * @return le libellé
     */
    public String getLibelle(){
        return this.libelle ;
    }
   
}
