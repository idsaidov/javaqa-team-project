package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test // Добавления одной игры
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test // Добавления двух игры
    public void shouldReturnFalseAddGames() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Страйк", "Файты", store);

        assertFalse(store.containsGame(game2));
    }

    @Test // проверку, покажет ли store игру, которая не была добавлена через метод publishGame
    public void shouldReturnFalseContainsGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Страйк", "Файты");
        Game game3 = new Game("Квейк", "Стрелялки", store);

        assertFalse(store.containsGame(game2));
    }

    @Test // Кто больше всего играл часов
    public void shouldGetMostPlayer() {

        store.addPlayTime("Player1", 30);
        store.addPlayTime("Player2", 59);
        store.addPlayTime("Player3", 16);


        String actual = store.getMostPlayer();
        String expected = "Player2";
        assertEquals(expected, actual);
    }

    @Test // Если игроков нет, то возвращется null
    public void shouldGetMostPlayerReturnNull() {

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Player4", -6);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test // Добавить время воспроизведения
    public void shouldRegisteredAddPlayTime() {

        store.addPlayTime("Player5", 0);
        store.addPlayTime("Player6", 2);


        String actual = store.getMostPlayer();
        String expected = "Player6";
        assertEquals(expected, actual);
    }

    @Test // Добавление времени
    public void shouldGetMostPlayerEquallyOne() {

        store.addPlayTime("Player7", 9);
        store.addPlayTime("Player8", 4);

        String actual = store.getMostPlayer();
        String expected = "Player7";
        assertEquals(expected, actual);
    }
    @Test // Добавление времени
    public void shouldGetMostPlayerEqualsZero() {

        Game game = store.publishGame("Дота 2", "Моба");

        store.addPlayTime("Player9", 1);

        String actual = store.getMostPlayer();
        String expected = "Player9";
        assertEquals(expected, actual);
    }
    @Test // Получиться сумма сыгранного времени
    public void shouldGetSumPlayedTime() {

        store.addPlayTime("Player10", 8);
        store.addPlayTime("Player11", 3);
        store.addPlayTime("Player12", 1);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test // Вернуть ноль и получить сумму сыгранного времени
    public void shouldReturnZeroGetSumPlayedTime() {

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test // Должно получиться нулевое игровое время
    public void shouldGetSumZeroPlayedTime() {

        store.addPlayTime("Player13", 0);
        store.addPlayTime("Player14", 0);
        store.addPlayTime("Player15", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test // Добавить время
    public void shouldGetSumOnePlayedTime() {

        store.addPlayTime("Player16", 1);
        store.addPlayTime("Player17", 0);
        store.addPlayTime("Player18", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);

    }
}