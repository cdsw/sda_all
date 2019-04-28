/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieListerApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author clementichen
 */
public class MovieLister_Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("configuration.xml");
        MovieFinder tabDelimFinder = ctx.getBean("tabDelimFinder", MovieFinder.class);
        MovieFinder databaseFinder = ctx.getBean("databaseFinder", MovieFinder.class);
        MovieLister movieLister = ctx.getBean("movieLister", MovieLister.class);
        
    }
}
