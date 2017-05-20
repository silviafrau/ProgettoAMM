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
public class UtentiRegistrati {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String urlFotoProfilo;
    private String frasePresentazione;
    private String username;
    
    private List<Gruppi> gruppiUtente;
    private List<Post> postUtente;
    
    public UtentiRegistrati() {
        id = 0;
        nome = "";
        cognome="";
        email = "";
        password = "";
        urlFotoProfilo="";
        username="";
        postUtente = new ArrayList<>();
        gruppiUtente= new ArrayList<>();
    }
    
    public void addGroup(Gruppi gruppo){
        gruppiUtente.add(gruppo);
    }
    
    public void removeGroup(Gruppi gruppo){
        gruppiUtente.remove(gruppo);
    }
    
    public void printListGroup(){
        for(Gruppi gruppo : gruppiUtente){
            System.out.print(gruppo.getNomeGruppo());
        }
    }
    
    public void addPost(Post post){
        postUtente.add(post);
    }
    
    public void removePost(Post post){
        postUtente.remove(post);
    }
    
    public void printPost(){
        for(Post post : postUtente){
            System.out.print(post.getUser().getUsername());
            if(post.getUser().getUrlFotoProfilo()!=null)
                System.out.print(post.getUser().getUrlFotoProfilo());
            System.out.print(post.getContent());
        }
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
    
    public String getUsername() {
        return username;
    }
    
   
     
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getCognome() {
        return cognome;
    }
     
    public void setCognome(String cognome) {
        this.cognome = cognome;
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
    
    public String getPresentation() {
        return frasePresentazione;
    }
    
    public void setPresentation(String frase) {
        this.frasePresentazione = frase;
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
