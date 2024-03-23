
import java.util.ArrayList;


public class Playlist implements PlaylistInterface {
    
    private ArrayList<Song> playlist;
    public Playlist(){
        playlist = new ArrayList<>();
        
    }
    
    public void add(Song s){
        if(!playlist.contains(s)){
            playlist.add(s);
        }
    }
    
    public Song removeLast(){
        if(!playlist.isEmpty()){
            return playlist.remove(playlist.size()-1);
        }
        return null;
    }
    
    public ArrayList<Song> getPlaylist(){
        return playlist;
    }
    
}
