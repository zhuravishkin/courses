package com.zhuravishkin.courses.design.design_patterns.structural.facade;

// Client: Клиентский код
public class FacadeDemo {
    public static void main(String[] args) {
        // Создание подсистемы
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        // Создание фасада
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem);

        // Использование фасада
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}

// Subsystem classes: Классы, представляющие компоненты домашнего кинотеатра
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping DVD Player");
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void off() {
        System.out.println("Projector is OFF");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound System is ON");
    }

    public void setVolume(int level) {
        System.out.println("Sound System volume set to: " + level);
    }

    public void off() {
        System.out.println("Sound System is OFF");
    }
}

// Facade: Упрощённый интерфейс для управления домашним кинотеатром
class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer;
    private final Projector projector;
    private final SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Setting up the Home Theater...");
        projector.on();
        projector.setInput("DVD Player");
        soundSystem.on();
        soundSystem.setVolume(50);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        System.out.println("Enjoy the movie!");
    }

    public void endMovie() {
        System.out.println("Shutting down the Home Theater...");
        dvdPlayer.stop();
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
    }
}
