package com.meeplehub;

import com.meeplehub.model.Customer;
import com.meeplehub.model.Game;
import com.meeplehub.model.GameCopy;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // --- Game и жанры (Set) ---
        Game game = new Game(1, "Catan", 3, 4);
        game.addGenre("Strategy");
        game.addGenre("Strategy");
        System.out.println(game.hasGenre("Strategy"));   // true
        System.out.println(game.hasGenre("Party"));      // false
        System.out.println(game.getGenres().size());     // 1

        // --- GameCopy ---
        GameCopy copy1 = new GameCopy(1, game);
        GameCopy copy2 = new GameCopy(2, game);
        System.out.println(copy1.getGame().getTitle());  // Catan
        copy1.markRented();
        System.out.println(copy1.isAvailable());         // false
        System.out.println(copy2.isAvailable());         // true

        // --- Customer (equals и hashCode) ---
        Customer a = new Customer(1, "Anna", false);
        Customer b = new Customer(1, "Anna", false);
        System.out.println(a == b);                      // false
        System.out.println(a.equals(b));                 // true

        Set<Customer> customers = new HashSet<>();
        customers.add(a);
        customers.add(b);
        System.out.println(customers.size());            // 1
    }
}