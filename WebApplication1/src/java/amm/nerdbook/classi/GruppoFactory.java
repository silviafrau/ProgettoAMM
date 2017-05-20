/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;
/**
 *
 * @author Silvia
 */
public class GruppoFactory {
    
    private static GruppoFactory singleton;
    
    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }
    
    private final ArrayList<Gruppi> listaGruppi = new ArrayList<>();
    
    private GruppoFactory() {
        //Creazione utenti

        //MarioGattini
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setId(0);
        gruppo1.setNome("Mariogattini");

        //Supernatural
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setId(1);
        gruppo2.setNome("Supernatural");
        
        //GymWorkOut
        Gruppi gruppo3 = new Gruppi();
        gruppo3.setId(2);
        gruppo3.setNome("GymWorkOut");

        //ChaoPovery
        Gruppi gruppo4 = new Gruppi();
        gruppo4.setId(3);
        gruppo4.setNome("ChaoPovery");

        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
        listaGruppi.add(gruppo4);
    }
    
    public Gruppi getGroupById(int id) {
        for (Gruppi gruppo : this.listaGruppi) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }
    
    public ArrayList getGruppoByNome(String nome){
        ArrayList<Gruppi> groupList = new ArrayList();
        for(Gruppi gruppo : listaGruppi){
            if((gruppo.getNomeGruppo()).equals(nome)){
                groupList.add(gruppo);
            }
        }
        return groupList;
    }
    
    public ArrayList getGruppoByMembro(UtentiRegistrati utente){
        ArrayList<Gruppi> gruppiUtente = new ArrayList<>();
        for(Gruppi gruppo : listaGruppi){
            for(UtentiRegistrati utente2 : gruppo.getUtentiGruppo()){
                if(utente2.equals(utente))
                    gruppiUtente.add(gruppo);
            }
        }
        return gruppiUtente;
    }
    
    public ArrayList<Gruppi> getGroupList(){
        return listaGruppi;
    }
    /*
    public void setConnectionString(String s){
        this.connectionString = s;
    }
    
    public String getConnectionString(){
        return this.connectionString;
    }
*/

    
}
