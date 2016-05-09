package GestionOffres;


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
public class TableauResultatRecherche {
    private HashMap<Offre,Double> rezRecherche ;
    
    public TableauResultatRecherche(){
            this.rezRecherche = new HashMap<>() ;
        }
    
    public void ajouteResultat(Stage inStage, Double inScore){
            if (inScore > 0.0){
                this.rezRecherche.put(inStage, inScore) ;
            }
    }
    public void ajouteResultat(Emploi inEmploi, Double inScore){
            if (inScore > 0.0){
                this.rezRecherche.put(inEmploi, inScore) ;
            }
    }
    public HashMap<Offre,Double> afficheResultatRecherche() {
        System.out.println("Nb trouvé : " + this.rezRecherche.size());
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
