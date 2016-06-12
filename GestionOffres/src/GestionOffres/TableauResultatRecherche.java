package GestionOffres;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */

/**
 * Classe contenant les offres résultants de la recherche
 * @author gaetan
 */
public class TableauResultatRecherche{
    private ArrayList<Offre> rezRecherche ;
    
    /**
     * Constructeur de la structure d'accueil des offres sélectionnées
     * pour l'affichage
     */
    public TableauResultatRecherche(){
            this.rezRecherche = new ArrayList<>();
    }
    
    /**
     * Concernant le stage : Ajoute stage et score passés en paramètres
     * @param inStage
     * @param inScore
     */
    public void ajouteResultat(Stage inStage, float inScore){
            if (inScore > 0){
                inStage.setScore(inScore);
                this.rezRecherche.add(inStage) ;
            }
    }
     /**
     * Concernant l'emploi : Ajoute stage et score passés en paramètres
     * @param inEmploi 
     * @param inScore
     */
    public void ajouteResultat(Emploi inEmploi, float inScore){
            if (inScore > 0.0){
                inEmploi.setScore(inScore);
                this.rezRecherche.add(inEmploi) ;
            }
    }
    
    /**
     * Affiche le résultat de la recherche
     * Le résultat est trié par ordre décroissant
     * @return ArrayList\<Offre\>
     */
    public ArrayList<Offre> afficheResultatRecherche() {
        System.out.println("Nb trouvé : " + this.rezRecherche.size());
        
        /* Tri de la recherche par score du plus grand (en haut de liste)
           au plus petit (en bas de liste) */
        Collections.sort(rezRecherche,Collections.reverseOrder());
        
        return this.rezRecherche;    
    }
        
    @Override
    public String toString() {
        return "TableauResultatRecherche{" + "rezRecherche=" + rezRecherche + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.rezRecherche);
        return hash;
    }

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
        final TableauResultatRecherche other = (TableauResultatRecherche) obj;
        if (!Objects.equals(this.rezRecherche, other.rezRecherche)) {
            return false;
        }
        return true;
    }
    
    
    
}
