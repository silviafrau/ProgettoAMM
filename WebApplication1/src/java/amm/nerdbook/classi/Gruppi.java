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
    private List<Post> PostsGroup;
    private String nomeGruppo;
    
    private int id;
    
    public Gruppi(){
        utentiGruppo= new ArrayList<>();
        id= 0;
        nomeGruppo="";
        PostsGroup= new ArrayList<>();
    }
    
    
    public void setNomeGruppo( String nome){
        this.nomeGruppo= nome;
    }
    
    public String getNomeGruppo(){
        return this.nomeGruppo;
    }
    
    public void add(UtentiRegistrati utente){
        utentiGruppo.add(utente);
    }
    
    public void add(Post post){
        PostsGroup.add(post);
    }
    
    public void remove(UtentiRegistrati utente){
        utentiGruppo.remove(utente);
    }
    
    public void remove(Post post){
        PostsGroup.remove(post);
    }
    
    public void printUsers(){
        utentiGruppo.forEach((utente) -> {
            System.out.print(utente.getNome());
        });
    }
    
    public void printPosts(){
        for(Post post : PostsGroup){
            System.out.print(post.getUser().getUsername());
            if(post.getUser().getUrlFotoProfilo()!=null)
                System.out.print(post.getUser().getUrlFotoProfilo());
            System.out.print(post.getContent());
        }
    }
    
}
