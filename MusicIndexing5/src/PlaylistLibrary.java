
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
        topPanel.add(playlistCB);
        topPanel.add(new JLabel("Playlist to Move: "));
        topPanel.add(playlistCB2);
        add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(songsTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(moveButton);
        add(bottomPanel, BorderLayout.SOUTH);

        playlistCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPlaylist = (String) playlistCB.getSelectedItem();
                if (selectedPlaylist != null) {
                    displaySongs(selectedPlaylist);
                }
            }
        });

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectedRow = songsTable.getSelectedRow();
                Song song = likedPlaylist.removeLast();
                String selectedPlaylist = playlistCB2.getSelectedItem().toString();
                addSongToPlaylist(song, selectedPlaylist);
                displaySongs("Liked Playlist");
            }
        });
    }

    private void initComponents() {
        playlistCB = new JComboBox<>();
        playlistCB2 = new JComboBox<>();
        playlistCB.addItem("Liked Playlist");
        playlistCB.addItem("Rock");
        playlistCB.addItem("Pop");
        playlistCB2.addItem("Rock");
        playlistCB2.addItem("Pop");
        songsTable = new JTable();
        tableModel = new DefaultTableModel(new String[]{"Title", "Artist", "Duration", "Genre"}, 0);
        songsTable.setModel(tableModel);
        moveButton = new JButton("Move Song");
    }

    private void initPlaylistData() {
        Song[] songs = new Song[10];
        songs[0] = new Song("Bohemian Rhapsody", "Queen", 354, "Rock");
        songs[1] = new Song("Hotel California", "Eagles", 391, "Pop");
        songs[2] = new Song("Imagine", "John Lennon", 187, "Pop");
        songs[3] = new Song("Stairway to Heaven", "Led Zeppelin", 482, "Rock");
        songs[4] = new Song("Smells Like Teen Spirit", "Nirvana", 301, "Pop");
        songs[5] = new Song("Hey Jude", "The Beatles", 431, "Rock");
        songs[6] = new Song("Like a Rolling Stone", "Bob Dylan", 367, "Rock");
        songs[7] = new Song("Yesterday", "The Beatles", 156, "Rock");
        songs[8] = new Song("Wish You Were Here", "Pink Floyd", 334, "Pop");
        songs[9] = new Song("Hurt", "Johnny Cash", 213, "Pop");

        for (Song song : songs) {
            likedPlaylist.add(song);
        }
    }

    private void displaySongs(String playlistName) {
        tableModel.setRowCount(0);
        ArrayList<Song> songs = new ArrayList<>();
        if(playlistName.equals("Liked Playlist")){
            songs = likedPlaylist.getPlaylist();
        }
        else if(playlistName.equals("Rock")){
            songs = rock.getPlaylist();
        }
        else if(playlistName.equals("Pop")){
            songs = pop.getPlaylist();
        }
        
        
    }

    
}
