package com.meeplehub;
import com.meeplehub.model.Game;
import com.meeplehub.model.GameCopy;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(1, "Catan", 3, 4);
        game.addGenre("Strategy");
        game.addGenre("Strategy");
        System.out.println(game.hasGenre("Strategy"));
        System.out.println(game.hasGenre("Party"));
        System.out.println(game.getGenres().size());
        GameCopy copy1 =new GameCopy(1, game);
        GameCopy copy2 = new GameCopy(2, game);
        System.out.println(copy1.getGame().getTitle());
        copy1.markRented();
        System.out.println(copy1.isAvailable());
        System.out.println(copy2.isAvailable());











    }
}