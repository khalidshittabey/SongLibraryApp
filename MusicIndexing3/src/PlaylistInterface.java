
import java.util.ArrayList;

public interface PlaylistInterface {

    public void add(Song s);

    public Song removeLast();

    public ArrayList<Song> getPlaylist();

}
