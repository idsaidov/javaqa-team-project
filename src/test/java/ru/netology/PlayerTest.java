package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
import org.junit.jupiter.api.Test;


    public class PlayerTest {
        @Test // Тест добавления нового игрока
        public void shouldInstallPlayer() {
            Player player = new Player("Serg");

            String actual = "Serg";
            String expected = player.getName();

            assertEquals(actual, expected);
        }


        @Test // тест  который принимает жанр игры  и считает время проигранное во все игры этого жанра этим игроком
        public void shouldSumGenreIfOneGame() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Assasins Creed", "Экшн");

            Player player = new Player("Serg");
            player.installGame(game);
            player.play(game, 5);

            int expected = 5;
            int actual = player.sumGenre(game.getGenre());
            assertEquals(expected, actual);
        }

        @Test
        // тест  который принимает жанр игры  и считает время проигранное во все игры этого жанра этим игроком(времени проигранного 0)
        public void shouldSumGenreIfOneGameNull() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Assasins Creed", "Экшн");

            Player player = new Player("Serg");
            player.installGame(game);
            player.play(game, 0);

            int expected = 0;
            int actual = player.sumGenre(game.getGenre());
            assertEquals(expected, actual);
        }

        @Test
        public void shouldSumGenreIfOneGameAction() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Assasins Creed", "Экшн");

            Player player = new Player("Serg");
            player.installGame(game);
            player.play(game, 3);

            int expected = 0;
            int actual = player.sumGenre("РПГ");
            assertEquals(expected, actual);
        }


        @Test // // тест RuntimeException в методе play
        public void shouldPlayRuntimeException() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Assasins Creed", "Экшн");

            Player player = new Player("Serg");

            assertThrows(RuntimeException.class, () -> {
                player.play(game, 2);
            });

        }


        @Test  /* тест метода, который принимает жанр и возвращает игру этого жанра, в которую играли больше всего
     Если в игры этого жанра не играли, возвращается null */
        public void shouldMostPlayerByGenre() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

            Player player = new Player("Name1");
            player.installGame(game);
            player.play(game, 3);

            Game expected = game;
            Game actual = player.mostPlayerByGenre("Аркады");
            assertEquals(expected, actual);
        }

        @Test /* тест метода, который принимает жанр и возвращает игру этого жанра, в которую играли больше всего
     Если в игры этого жанра не играли, возвращается null(Со значением 0) */
        public void shouldMostPlayerByGenreNull() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

            Player player = new Player("Name1");
            player.installGame(game);
            player.play(game, 0);

            Game expected = null;
            Game actual = player.mostPlayerByGenre("Аркады");
            assertEquals(expected, actual);

        }

        public class PlayerTest {

        }
