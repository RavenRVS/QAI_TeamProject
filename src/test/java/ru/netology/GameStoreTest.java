package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }


    @Test
    public void addPlayTime() {

        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 8);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Сергей", 8);


        assertTrue(expected.equals(store.getPlayedTime()));

    }

    @Test
    public void addPlayTimeWithSumHours() {

        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 8);
        store.addPlayTime("Сергей", 4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Сергей", 12);

        Assertions.assertTrue(expected.equals(store.getPlayedTime()));

    }

    @Test
    public void addPlayTimeWithTwoPlayers() {

        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 8);
        store.addPlayTime("Дмитрий", 4);
        store.addPlayTime("Дмитрий", 6);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Сергей", 8);
        expected.put("Дмитрий", 10);

        Assertions.assertTrue(expected.equals(store.getPlayedTime()));

    }

    @Test
    public void getMostPlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 6);
        store.addPlayTime("Дмитрий", 8);

        String expected = "Дмитрий";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerWithoutPlayers() {
        GameStore store = new GameStore();

        String actual = store.getMostPlayer();

        Assertions.assertEquals(null, actual);
    }

    @Test
    public void getSumPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 6);
        store.addPlayTime("Дмитрий", 8);

        int expected = 14;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

}