
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaylistLibrary extends JFrame {

    private JComboBox<String> playlistCB;
    private JComboBox<String> playlistCB2;
    private JTable songsTable;
    private DefaultTableModel tableModel;
    private JButton moveButton;

    private Playlist likedPlaylist;
    private Playlist rock;
    private Playlist pop;

    public PlaylistLibrary() {
        setTitle("Likes Songs Playlist");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        likedPlaylist = new Playlist();
        rock = new Playlist();
        pop = new Playlist();
        initComponents();
        initPlaylistData();

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Select Playlist: "));
       
            }

    }

    


    
}
