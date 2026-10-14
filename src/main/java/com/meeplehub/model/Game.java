package com.meeplehub.model;

import java.util.HashSet;
import java.util.Set;

public class Game implements HasId {
    private final long id;
    private String title;
    private int minPlayers;
    private int maxPlayers;
    private final Set<String> genres = new HashSet<>();
    private final Set<String> tags = new HashSet<>();

    public Game(long id, String title, int minPlayers, int maxPlayers) {
        this.id = id;
        this.title = title;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }

    public boolean hasGenre(String genre) {
        return genres.contains(genre);
    }

    @Override
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Set<String> getTags() {
        return tags;
    }
}