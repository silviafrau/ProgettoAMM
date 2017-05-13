/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.List;
import java.util.ArrayList;
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

    private PostFactory() {
        
        UtenteFactory utente = UtenteFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Giovane di modesta prestanza fisica e dall'aspetto insignificante, che compensa la scarsa avvenenza e le frustrazioni che ne derivano con una passione ossessiva e una notevole inclinazione per le nuove tecnologie!");
        post1.setId(0);
        post1.setUser(utente.getUserById(0));

        Post post2 = new Post();
        post2.setContent("download.jpg.jpg");
        post2.setId(1);
        post2.setUser(utente.getUserById(1));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContent("https://www.google.it/search?q=nerd&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiczNDu2OTSAhXCvxQKHanjDjwQ_AUICCgB&biw=1366&bih=662#tbm=isch&q=gattini&*&imgrc=LKZjnAkGIJpnpM:");
        post3.setId(2);
        post3.setUser(utente.getUserById(2));
        post3.setPostType(Post.Type.IMAGE);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
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

}
