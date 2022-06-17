package com.sohail;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1", "Arijit");

        album.addSong("Desh mere", 5.1);
        album.addSong("Agar tum sath ho", 4.5);
        album.addSong("Tu hi yaar mera", 4.2);
        album.addSong("Khairiyat", 3.7);
        album.addSong("Phir mohabbat", 5.2);        // nice song
        // this is a comment
        albums.add(album);

        album = new Album("Album2", "Eminem");

        album.addSong("Rap god", 4.1);
        album.addSong("Not afraid", 3.5);
        album.addSong("Lose yourself", 3.2);
        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();

        albums.get(0).addToPlaylist("Desh mere", playlist_1);
        albums.get(0).addToPlaylist("Agar tum sath ho", playlist_1);
        albums.get(1).addToPlaylist("Rap god", playlist_1);
        albums.get(1).addToPlaylist("Not afraid", playlist_1);

        play(playlist_1);
    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size()==0){
            System.out.println("This playlist has no song!");
        }
        else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else{
                        System.out.println("No more songs in the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the first song");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }

            }
        }

    }

    private static void printMenu(){
        System.out.println("Available options\nPress");
        System.out.println("0 -> to quit\n" +
                "1 -> to play next song\n" +
                "2 -> to play previous song\n" +
                "3 -> to replay the current song\n" +
                "4 -> to print the list of all the songs\n" +
                "5 -> to print all available options\n" +
                "6 -> to delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("----------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------------");


    }

}
