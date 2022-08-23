import java.util.*;

public class Main
{
    private static ArrayList<Album> albums = new ArrayList<>();

    /*private static void input()
    {
        Song song = new Song();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Name of the song and duration ");

        song.duration=sc.nextInt();
        song.title=sc.nextLine();
    }*/

    public static void main(String[] args)
    {

        //input();

        Album album = new Album("Album1","Anirudh");

        album.addSong("Mass Maranam",4.56);
        album.addSong("Arabic Kuthu",4.50);
        album.addSong("Pathala Pathala",4.46);
        album.addSong("Petta Paraak",4.36);
        albums.add(album);

        album = new Album("Album2", "Thaman");

        album.addSong("Blockbuster",4.16);
        album.addSong("Akhanda",4.26);
        album.addSong("Kalavathi",4.30);
        album.addSong("Samajavaragamana",4.59);
        albums.add(album);

        album = new Album("Album3","DSP");

        album.addSong("Srivalli",4.23);
        album.addSong("Pakka Local",4.53);
        album.addSong("Swing Zara",4.33);
        album.addSong("Ratthaalu",4.43);
        albums.add(album);

        //LinkedList<Song> playlist1 = new LinkedList<Song>();
        LinkedList<Song> playlist1 = new LinkedList<>();

        LinkedList<Song> playlist2 = new LinkedList<>();


        albums.get(0).addToPlaylist(4,playlist1);
        albums.get(0).addToPlaylist("Arabic Kuthu",playlist1);
        albums.get(1).addToPlaylist(2,playlist1);
        albums.get(1).addToPlaylist("Kalavathi",playlist1);
        albums.get(2).addToPlaylist(4,playlist1);

        //album.printArrayList();

        play(playlist1);

        albums.get(2).addToPlaylist("Srivalli",playlist2);
        albums.get(0).addToPlaylist(1,playlist2);
        albums.get(1).addToPlaylist(3,playlist2);
        albums.get(2).addToPlaylist("Pakka Local",playlist2);
        albums.get(1).addToPlaylist(1,playlist2);

        //play(playlist2);
    }



    private static void menu()
    {
        System.out.println("Welcome to the Music Player");
        System.out.println("0 --> Quit");
        System.out.println("1 --> Play Next Song");
        System.out.println("2 --> Play Previous Song");
        System.out.println("3 --> Replay Current Song");
        System.out.println("4 --> List Of All Songs");
        System.out.println("5 --> Print All Available Options");
        System.out.println("6 --> Delete Current Song");

    }

    private static void printList(LinkedList<Song> playlist)
    {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("----------------------------------");

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------------");
    }

    private static void play(LinkedList<Song> playlist)
    {
        Scanner sc = new Scanner(System.in);

        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size() == 0)
        {
            System.out.println("This playlist has no song");
        }
        else
        {
            System.out.println("Now Playing "+listIterator.next().toString());
            menu();
        }

        while(!quit)
        {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action)
            {
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("Now Playing "+listIterator.next().toString());
                    else
                    {
                        System.out.println("No song available!!!! Reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now Playing "+listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing "+listIterator.previous().toString());
                            forward = false;
                        }
                        else
                        {
                            System.out.println("We are at the start of the playlist");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now Playing "+listIterator.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("We have reached to the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    menu();
                    break;
                case 6:
                    if(playlist.size() > 0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now Playing "+listIterator.next().toString());
                            //forward = true;
                        }
                        else
                        {
                            if(listIterator.hasPrevious())
                            {
                                System.out.println("Now Playing "+listIterator.previous().toString());
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Enter proper choice!!!");
                    break;
            }
        }
    }
}
