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
 *
 * @author gaetan
 */
public class TableauResultatRecherche{
    private ArrayList<Offre> rezRecherche ;
    
    public TableauResultatRecherche(){
            this.rezRecherche = new ArrayList<>();
    }
    
    public void ajouteResultat(Stage inStage, float inScore){
            if (inScore > 0){
                inStage.setScore(inScore);
                this.rezRecherche.add(inStage) ;
            }
    }
    public void ajouteResultat(Emploi inEmploi, float inScore){
            if (inScore > 0.0){
                inEmploi.setScore(inScore);
                this.rezRecherche.add(inEmploi) ;
            }
    }
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
