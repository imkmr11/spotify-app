import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {


        Album album1=new Album("Moosa","siddhu moosewala");
        album1.addsongtoalbum("295",4.05);
        album1.addsongtoalbum("lastride",5.5);
        album1.addsongtoalbum("sohigh",5.0);

        Album album2=new Album("arjit songs","arjit singh");
        album2.addsongtoalbum("kesariya",5.0);
        album2.addsongtoalbum("jeena",4.5);
        album2.addsongtoalbum("gerua",6.0);

        albums.add(album2);
        albums.add(album1);

        System.out.println(album2.findsong("295"));
        LinkedList<song> myplaylist=new LinkedList<>();
        album1.addtoplaylistfromalbum("295",myplaylist);
        album2.addtoplaylistfromalbum(2,myplaylist);
        album2.addtoplaylistfromalbum("sohigh",myplaylist);
        album1.addtoplaylistfromalbum("jeena",myplaylist);

        play(myplaylist);


    }
    public static void play(LinkedList<song> playlist){
        ListIterator<song> itr=playlist.listIterator();
        Scanner sc=new Scanner(System.in);
        boolean isforward=false;
        if(playlist.size()>0){
            System.out.println("currently playing: ");
            System.out.println(itr.next());
        }
        else {
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("enter your choice");
        printmenu();
        boolean quit=false;
        while (!quit){
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(isforward==false){
                        itr.next();
                        isforward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else {
                        System.out.println("you have reached end of the playlist");
                    }
                    break;
                case 2:
                    if(isforward==true){
                        itr.previous();
                        isforward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else {
                        System.out.println("you are at the beginning of the playlist");
                    }
                    break;
                case 3:
                    if(isforward==true){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isforward=false;
                        }

                    }
                    else {
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isforward=true;
                        }

                    }

                    break;
                case 4:
                    printmenu();
                case 5:
                    break;
                case 6:
                    printsongs(playlist);
                case 7:
                    quit=true;
                    break;
            }
        }

    }
    public static void printsongs(LinkedList<song> playlist){
        for(song song:playlist)
            System.out.println(song);

        return;
    }
    public static void printmenu(){

        System.out.println("1-playnext song");
        System.out.println("2-play previous song");
        System.out.println("3-repeat song");
        System.out.println("4-show menu again");
        System.out.println("5-delete the current song");
        System.out.println("6-print all the songs in playlist");
        System.out.println("7-exit");
    }
}