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
public class Post {
    
    public enum Type{
        TEXT,IMAGE, LINK
    }
    
    protected int id;
    protected UtentiRegistrati user;
    private String content;
    private Type postType;
    
    public Post() {
        id = 0;
        user = null;
        content = "";
        postType = Type.TEXT;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public UtentiRegistrati getUser() {
        return user;
    }
    
    
    public void setUser (UtentiRegistrati user) {
        this.user = user;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Type getPostType() {
        return postType;
    }
    
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    

}
