package org.howard.edu.lsp.midterm.question5;

public class Music implements Streamable {
    private String title;

    public Music(String title) {
        this.title = title;
    }
    //play,pause, and stops each song
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    //specific behavior
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}
