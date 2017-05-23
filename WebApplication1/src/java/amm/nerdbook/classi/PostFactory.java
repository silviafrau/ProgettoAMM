/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.List;
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
public class PostFactory {

    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<>();
    private String connectionString;

    private PostFactory() {
        
        UtenteFactory utente = UtenteFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Giovane di modesta prestanza fisica e dall'aspetto insignificante, che compensa la scarsa avvenenza e le frustrazioni che ne derivano con una passione ossessiva e una notevole inclinazione per le nuove tecnologie!");
        post1.setId(1);
        post1.setUser(utente.getUserById(1));

        Post post2 = new Post();
        post2.setImage("download.jpg");
        post2.setId(2);
        post2.setContent("Non vedo l'ora di giocare a tekken!!!!!!!");
        post2.setUser(utente.getUserById(2));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setUrl("https://www.google.it/search?q=nerd&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiczNDu2OTSAhXCvxQKHanjDjwQ_AUICCgB&biw=1366&bih=662#tbm=isch&q=gattini&*&imgrc=LKZjnAkGIJpnpM:");
        post3.setId(3);
        post3.setContent("Gattini coccolini. Guardateeeee!!!");
        post3.setUser(utente.getUserById(2));
        post3.setPostType(Post.Type.LINK);
        
        Post post4 = new Post();
        post4.setContent("Oggi fa proprio caldo per stare in giro :( ");
        post4.setId(3);
        post4.setUser(utente.getUserById(3));
        post4.setPostType(Post.Type.TEXT);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtentiRegistrati utente) {

        List<Post> listaPost = new ArrayList<>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(utente)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    
    public ArrayList<Post> getPostByAutore(UtentiRegistrati usr){
        ArrayList<Post> listaPost = new ArrayList<>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "silvia_frau", "amm");
            
            String query = 
                      "select * from posts "
                    + "join postType on posts.type = idT"
                    + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("idG"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("name")));

                //imposto l'autore del post
                current.setUser(usr);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        
        return Post.Type.TEXT;
    }
    
      public void addPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "silvia_frau", "amm");
            
            String query = 
                      "insert into posts (idG, contenuto, type, author) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContent());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
      
    private int postTypeFromEnum(Post.Type type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.Type.TEXT)
                return 1;
            else
                return 2;
    }
    
    public void setConnectionString(String s){
        this.connectionString = s;
    }
    
    public String getConnectionString(){
        return this.connectionString;
    }
 
}
