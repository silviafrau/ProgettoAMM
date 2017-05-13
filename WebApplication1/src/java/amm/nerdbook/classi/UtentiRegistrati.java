/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

/**
 *
 * @author Utente
 */
public class UtentiRegistrati {
    private int id;
    private String nome;
    private String email;
    private String password;
    private String urlFotoProfilo;
    
    public UtentiRegistrati() {
        id = 0;
        nome = "";
        email = "";
        password = "";
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
     public String getNome() {
        return nome;
    }
     
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof UtentiRegistrati)
            if (this.getId() == ((UtentiRegistrati)altroUtente).getId()) return true;
        return false;
    }
    
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }
    
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }
}
