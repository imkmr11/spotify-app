import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String Artist;
    private List<song> songs;

    public Album(String name, String artist) {
        this.name = name;
        Artist = artist;
        songs=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public List<song> getSongs() {
        return songs;
    }

    public void setSongs(List<song> songs) {
        this.songs = songs;
    }
    public  boolean findsong(String title){
        for(song s: songs){
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }
    void addsongtoalbum(String title,double duration){
        song s= new song(title,duration);


        if(findsong(s.getTitle())==true){
            System.out.println("song already present in album");
        }
        else {
            songs.add(s);
            System.out.println("new song has been added");
        }
        return;
    }
    public void addtoplaylistfromalbum(String title, LinkedList<song> playlist){
        if(findsong(title)==true){
            for (song song: songs){
                if(song.getTitle().equals(title)){
                    playlist.add(song);
                    System.out.println("song has been added to playlist");
                    break;
                }
            }

        }
        else {
            System.out.println("song is not present in the album");
        }
    }
    public void addtoplaylistfromalbum(int trackno, LinkedList<song> playlist){
        int index=trackno-1;
        if(index>=0 && index< songs.size()){
            playlist.add(songs.get(index));
            System.out.println("song has been added to playlist");
        }
        else {
            System.out.println("Invalid track number");
        }
    }
}
