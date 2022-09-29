package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test
    public void shouldAddOneGame(){

        Game game = store.publishGame("Игра1", "Игра2");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddTwoGame(){
        Game game = store.publishGame("Игра1", "Игра2");
        Game game2 = store.publishGame("Игра3", "Игра4");
        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldNotContainsGame() {

        Game game = store.publishGame("Игра2", "Игра4");
        Game game2 = new Game("Игра1", "Игра2", store);
        Game game3 = store.publishGame("Игра3", "Игра5");

        assertFalse(store.containsGame(game2));
    }


}
