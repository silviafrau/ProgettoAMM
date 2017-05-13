/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.*;

/**
 *
 * @author Utente
 */
public class Gruppi extends UtentiRegistrati{
    protected List<UtentiRegistrati> utentiGruppo;
    private int id;
    
    public Gruppi(){
        utentiGruppo= new ArrayList<>();
        id= 0;
    }
    
    public void add(UtentiRegistrati utente){
        utentiGruppo.add(utente);
    }
    
    public void remove(UtentiRegistrati utente){
        utentiGruppo.remove(utente);
    }
    
    public void printUsers(){
        utentiGruppo.forEach((utente) -> {
            System.out.print(utente.getNome());
        });
    }
    
}
