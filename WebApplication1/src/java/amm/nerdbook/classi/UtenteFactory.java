/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;

/**
 *
 * @author Utente
 */
public class UtenteFactory {
    
    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    private final ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<>();

    private UtenteFactory() {
        //Creazione utenti

        //Djanni
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.setNome("Djanni");
        utente1.setEmail("djannigatto@gmail.com");
        utente1.setPassword("123");
        utente1.setUrlFotoProfilo("img/djanniprofilo.jpg");

        //HeavyBreathing
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(1);
        utente2.setNome("HeavyBreathing");
        utente2.setEmail("cholansia@gmail.com");
        utente2.setPassword("123");
        utente2.setUrlFotoProfilo("img/user1.gif");

        //GymWorkOut
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(2);
        utente3.setNome("GymWorkOut");
        utente3.setEmail("doIt@gmail.com");
        utente3.setPassword("123");
        utente3.setUrlFotoProfilo("img/user2.jpg");

        
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);

        
    }
    
    public UtentiRegistrati getUserById(int id) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(UtentiRegistrati utente : this.listaUtenti){
            if(utente.getNome().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
}
