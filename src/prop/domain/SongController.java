package prop.domain;

import prop.data.DataController;

import java.io.IOException;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * Song Controller
 * @author  joaquim.motger
 * @see     Song
 * @see     SongSet
 */

public class SongController {

    SongSet songSet;

    private final static String delimiter = "\n\n";

    /**
     * Song Controller constructor
     */
    public SongController() {
        songSet = new SongSet();
    }

    /**
     * Add a new <b>song</b> to the set
     * @param title     song title
     * @param artist    song artist
     * @param album     song album
     * @param year      year of release
     * @param genre     song genre
     * @param subgenre  song subgenre
     * @param duration  song duration in seconds
     * @return          true if the song was added; false if the song was present and not added
     */
    public void addSong(String title, String artist, String album, int year, Genre genre, Genre subgenre, int duration) throws Exception {
        Song song = new Song(title, artist, album, year, genre, subgenre, duration);
        songSet.addSong(song);
    }

    /**
     * Remove a <b>song</b> of the set
     * @param title     song title
     * @param artist    song artist
     */
    public void removeSong(String title, String artist) throws Exception {
        songSet.removeSong(title, artist);
    }

    /**
     * Edit an attribute of a song
     * @param title     song title
     * @param artist    song artist
     * @param pair      a pair defining attribute and new value
     */
    public void editSong(String title, String artist, Pair<String, String> pair) {
        Song song = songSet.getSong(title, artist);
        if (song != null) {
            switch(pair.first) {
                case "title":
                    song.setTitle(pair.second);
                    break;
                case "artist":
                    song.setArtist(pair.second);
                    break;
                case "album":
                    song.setAlbum(pair.second);
                    break;
                case "year":
                    song.setYear(Integer.parseInt(pair.second));
                    break;
                case "genre":
                    song.setGenre(Genre.getGenreByName(pair.second));
                    break;
                case "subgenre":
                    song.setSubgenre(Genre.getGenreByName(pair.second));
                    break;
                case "duration":
                    song.setDuration(Integer.parseInt(pair.second));
                    break;
            }
        }
    }
    /**
     * Get the songSet in String
     * @return  string with all songs in songSet
     */
    public String getSongSetString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Song> songs = songSet.getSongSet();
        for (Song song : songs) {
            sb.append(song.toString()+delimiter);
        }
        return sb.toString();
    }

    /**
     * Get a song
     * @param title     song title
     * @param artist    song artist
     * @return          song with title and artist required
     */
    public Song getSong(String title, String artist) {
        return songSet.getSong(title, artist);
    }

    /**
     * Search songs with the defined values for specified attributes
     * @param l     list with pairs of attributes and value to define search
     * @return      string with all the songs that match the search
     */
    public String searchSongs(ArrayList< Pair<String, String> > l) throws Exception {
        ArrayList<Song> songs = songSet.searchSongs(l);
        String s = "";
        for (Song song : songs) {
            s += song.toString() + "\n";
        }
        return s;
    }

    /**
     * Save the songSet in the specified path
     * @param path      path to save the songSet
     */
    public void save(String path) {
        try {
            DataController.save(getSongSetString(), path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Load the songSet in the specified path
     * @param path      path to load the songSet
     */
    public void load(String path) {
        String s;
        try {
            s = DataController.load(path);
            this.songSet = SongSet.valueOf(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



