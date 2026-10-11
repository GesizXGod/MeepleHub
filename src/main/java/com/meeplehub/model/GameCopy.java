package com.meeplehub.model;

public class GameCopy {
    private final long id;
    private final Game game;
    private CopyStatus status;

    public GameCopy(long id, Game game) {
        this.id = id;
        this.game = game;
        this.status = CopyStatus.AVAILABLE;
    }

    public long getId() { return id; }
    public Game getGame() { return game; }
    public CopyStatus getStatus() { return status; }

    public boolean isAvailable() {
        return status == CopyStatus.AVAILABLE;
    }

    public void markRented() {
        this.status = CopyStatus.RENTED;
    }
}
