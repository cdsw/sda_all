/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.util.Iterator;

/**
 *
 * @author alok
 */
public class Test {
    public static void main(String[] args) {
        DuckFactory duckFactory1 = new DuckFactory();
        CountingDuckFactory duckFactory2 = new CountingDuckFactory();
        
        Flock flock = new Flock();
        Flock miniFlock = new Flock();
        
        miniFlock.add(duckFactory1.createRubberDuck());
        miniFlock.add(duckFactory1.createRedHeadDuck());
        
        flock.add(duckFactory2.createDuckCall());
        flock.add(duckFactory2.createDuckCall());
        flock.add(duckFactory2.createMallardDuck());
        flock.add(duckFactory1.createRubberDuck());
        flock.add(miniFlock);
        flock.quack();
        System.out.println(QuackCounter.getQuacks());
        
        Iterator iterator = flock.getIterator();
        while(iterator.hasNext()){
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
        System.out.println(QuackCounter.getQuacks());
        
        Quackologist q = new Quackologist();
        Quackable quacker = duckFactory2.createDuckCall();
        quacker.registerObserver(q);
        quacker.quack();
        System.out.println(QuackCounter.getQuacks());
    }
}
