package p0_material;

public class Criatura implements Comparable{
    
    public static final int NEN = 10;
    public static final int NENA = 20;
    
    public static final int MIN_EDAT=0;
    public static final int MAX_EDAT=3;
    
    private String nom;
    private int edat;
    private int sexe;
    
    public Criatura(String nom, int edat, int sexe) {
        if (edat<MIN_EDAT || edat>MAX_EDAT)
            throw new IllegalArgumentException("edat no v?lida: "+edat);
        if (sexe!=NEN && sexe!=NENA)
            throw new IllegalArgumentException("sexe no v?lid: "+sexe);
        
        this.nom = nom;
        this.edat = edat;
        this.sexe = sexe;
    }
    
    public String getNom() {return this.nom;}
    public int getEdat() {return this.edat;}
    public int getSexe() {return this.sexe;}
    
    // redefinici? del m?tode toString heretat d'Object'
    public String toString () {
        String resultat;
        resultat = "Criatura de nom: "+nom+", t? "+edat+" anys. ";
        if (sexe==NEN) resultat = resultat+"Sexe: nen";
        else resultat = resultat +"Sexe: nena";
        return resultat;
    }
    
    // implementaci? de la interf?cie Comparable
    public int compareTo(Object o) {
        // comparaci? basada en l'ordre lexicogr?fic sense distingir maj?sucules 
        // de min?scules.
        Criatura altra = (Criatura)o;
        return this.nom.compareToIgnoreCase(altra.nom);
    }
    
    // redefinici? del m?tode equals heretat d'object.
    public boolean equals (Object o) {
        // redefinici? compatible amb compareTo
        try {
            return this.compareTo(o)==0;
        }
        catch(ClassCastException e) {
            return false;
        }
    }
    
}
