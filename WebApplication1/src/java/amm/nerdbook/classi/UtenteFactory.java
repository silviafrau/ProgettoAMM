/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import amm.nerdbook.classi.*;
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

    private  ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<>();
    private String connectionString;

    private UtenteFactory() {
        //Creazione utenti

        //Gigi Palla
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.setNome("Gigi");
        utente1.setCognome("Palla");
        utente1.setUsername("Gigino");
        utente1.setEmail("Pallino@gmail.com");
        utente1.setPassword("123");
        utente1.setUrlFotoProfilo("FotoProfilo.jpg");
        utente1.setPresentation("Ciao raga, sono un fotomodelo al gusto di nutelo!!!");

        //Tonio Cartonio
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(1);
        utente2.setNome("Tonio");
        utente2.setCognome("Cartonio");
        utente2.setUsername("Tonnio");
        utente2.setEmail("BALORDO@gmail.com");
        utente2.setPassword("miao");
        utente2.setUrlFotoProfilo("img.jpg");
        utente2.setPresentation("Aggiusto computer for free, se mi volete contattare ;) ");

        //Anna Pannocchia
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(2);
        utente3.setNome("Anna");
        utente3.setCognome("Pannocchia");
        utente3.setUsername("Pannocchietta99");
        utente3.setEmail("SonoIncintaMarioo@gmail.com");
        utente3.setPassword("123");
        utente3.setUrlFotoProfilo("gat.jpg");
        utente3.setPresentation("Mariotiamoooooo");
        
        //Mario Ciccioni
        UtentiRegistrati utente4 = new UtentiRegistrati();
        utente4.setId(3);
        utente4.setNome("Mario");
        utente4.setCognome(null);
        utente4.setUsername("Mariottide");
        utente4.setEmail("Hofame@gmail.com");
        utente4.setPassword("biscotto");
        utente4.setUrlFotoProfilo(null);
        utente4.setPresentation(null);
        

        
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
        
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
            if(utente.getUsername().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
    
    public ArrayList<UtentiRegistrati> getUserList(){
        return listaUtenti;
    }
    
    public void setConnectionString(String s){
        this.connectionString = s;
    }
    
    public String getConnectionString(){
        return this.connectionString;
    }
}
