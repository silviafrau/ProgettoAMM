/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private String connectionString;
    
    private GruppoFactory() {
        //Creazione utenti

        //MarioGattini
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setId(1);
        gruppo1.setNome("Mariogattini");

        //Supernatural
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setId(2);
        gruppo2.setNome("Supernatural");
        
        //GymWorkOut
        Gruppi gruppo3 = new Gruppi();
        gruppo3.setId(3);
        gruppo3.setNome("GymWorkOut");

        //ChaoPovery
        Gruppi gruppo4 = new Gruppi();
        gruppo4.setId(4);
        gruppo4.setNome("ChaoPovery");

        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
        listaGruppi.add(gruppo4);
    }
    /*
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
    
    /*public ArrayList getGruppoByMembro(UtentiRegistrati utente){
        ArrayList<Gruppi> gruppiUtente = new ArrayList<>();
        for(Gruppi gruppo : listaGruppi){
            for(UtentiRegistrati utente2 : gruppo.getUtentiGruppo()){
                if(utente2.equals(utente))
                    gruppiUtente.add(gruppo);
            }
        }
        return gruppiUtente;
    }
    */
    public ArrayList<Gruppi> getGroupList(){
        return listaGruppi;
    }
    
    public void setConnectionString(String s){
        this.connectionString = s;
    }
    
    public String getConnectionString(){
        return this.connectionString;
    }

    public ArrayList getGruppoByMembro(UtentiRegistrati utente){
        ArrayList<Gruppi> listaGruppi = new ArrayList();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "silvia_frau","amm");
           /* String query = "select * from gruppi "+
                    "join gruppi on membri.id_gruppo = gruppi.gruppo_id "
                    +"join utenti on membri.id_utente = utenti.utente_id "
                    +"where utente_id = ?";*/
           String query = "select gruppi.* from gruppi, membri, utenti "+
                            "where gruppi.idG = membri.idG " +
                            "and membri.idU = utente.idU " +
                            "and utente.idU= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,utente.getId()); //il primo punto di domanda viene sostituito con id
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                Gruppi current = new Gruppi();
                current.setId(res.getInt("idG"));
                current.setNome(res.getString("nome"));
                //current.setUrlFoto(res.getString("urlFotoProfilo"));

                listaGruppi.add(current);
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaGruppi;
    }

    
}
