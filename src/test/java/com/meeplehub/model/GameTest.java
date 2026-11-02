package com.meeplehub.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;



public class GameTest {
    @Test
void shouldAddTwoDifferentGenres(){
Game game = new Game(1, "Catan", 3, 4);
 game.addGenre("Strategy");
 game.addGenre("Economic");
 assertEquals(2, game.getGenres().size());

}
    @Test
    void shouldAddTwoDifferentGenre() {
        Game game = new Game(1, "Catan", 3, 4);
        game.addGenre("Strategy");
        assertFalse(game.hasGenre("Horror"));
    }
    @Test
    void shouldAddTwoDifferentGenr() {
        Game game = new Game(1, "Catan", 3, 4);
        game.addGenre("Strategy");
        game.addGenre("Strategy");
        assertEquals(1, game.getGenres().size());
    }
    @ParameterizedTest
    @ValueSource(strings = {"Strategy","Comedy", "Horror"})
    void shouldFindGenre(String genre){
        Game game = new Game(1, "Catan", 3, 4);
        game.addGenre("Strategy");
        game.addGenre("Comedy");
        game.addGenre("Horror");
        assertTrue(game.hasGenre(genre));
    }
    @ParameterizedTest
    @CsvSource({"Strategy, true","Horror, true","Romance, false"})
    void shouldFindGenre(String genre, boolean expected){
        Game game = new Game(1, "Catan", 3, 4);
        game.addGenre("Strategy");
        game.addGenre("Horror");
        assertEquals(expected, game.hasGenre(genre));
    }
    @ParameterizedTest
    @EnumSource(CopyStatus.class)
    void shouldHaveValidCopyStatus(CopyStatus status) {
        assertNotNull(status);
    }
}
