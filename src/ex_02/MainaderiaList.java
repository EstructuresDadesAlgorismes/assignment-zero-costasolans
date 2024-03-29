package ex_02;

import p0_material.*;
import java.util.*;

public class MainaderiaList implements Mainaderia {

    // Referencia a objecte de la classe List on "guardarem" les criatures...
    private List contingut;
    
    public MainaderiaList() {
        // crear la llista. Inicialment serè buida, clar...
        this.contingut = new ArrayList();
    }
 
   // afegeix una criatura. Excepció si ja hi ha una criatura igual
    public void matricular (Criatura c) throws IllegalArgumentException {
        if (this.contingut.contains(c))
            throw new IllegalArgumentException("matricular: criatura repetida");
        contingut.add(c);
    }
    
    // desmatricula la criatura de nom donat. Retorna la criatura que 
    // es desmatricula. Si no n'hi ha cap amb aquell nom retorna null
    public Criatura desMatricular(String nom) {
        Criatura target = new Criatura(nom, Criatura.MIN_EDAT, Criatura.NEN);
        int index = contingut.indexOf(target);
        if (index==-1) {
            return null;
        }
        else {
            return (Criatura)contingut.remove(index);
        }
    }
    
    // Retorna la criatura que té el nom especificat. Retorna null si no
    // n'hi ha cap
    public Criatura buscar(String nom) {
        Criatura target = new Criatura(nom, Criatura.MIN_EDAT, Criatura.NEN);
        int index = contingut.indexOf(target);
        if (index==-1) {
            return null;
        }
        else {
            return (Criatura)contingut.get(index);
        }
    }
    
    // retorna el n�mero de criatures matriculades
    public int numCriatures() {
        return contingut.size();
    }
    
    // retorna el n�mero de criatures del sexe especificat com a par�metre
    public int quantsSexe (int sexe) {
    	//TODO 1
    	  /* Exercici: a la versió mostrada a classe de la implementació
        d'aquest m�tode, la iteració sobre el contingut no es feia
        utilitzant l'iterador de la col·lecció.
        Torneu a escriure el codi d'aquest m�tode per� ara fent és
        de l'iterador proporcionat pel métode iterator.

        Desprès, podeu executar ProvaMainaderia per veure si el resultat
        que obteniu és el mateix que s'obtenia abans */
    	
        int count = 0;
        Iterator it;
        it = contingut.iterator();
        //while iterator has next we will check if its sex is like sexe(parameter)
        while ( it.hasNext() )
        {
            Criatura criatura = (Criatura) it.next();
            if(criatura.getSexe() == sexe)
                count++;
        }      
        return count;
    }
    
    // retorna la i-éssima criatura. Excepció si el par�metre està fora
    // dels límits actuals
    public Criatura get(int i) throws IndexOutOfBoundsException {
        return (Criatura)contingut.get(i);
        // NOTA: get ja llença IndexOutOfBoundsException si el paràmetre està
        // fora de limits
    }

}
