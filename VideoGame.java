/*
 * Author:      Brian Klein
 * Date:        11/13/17
 * Program:     VideoGame.java
 * Description: Two private data members: playerName and score, Constructors,
                Getters and setters, and toString method. The objects of 
                VideoGame must be Comparable objects. It implements Comparable 
                interface. It provides the method definition for compareTo 
                method. The playerName field should be compared.
 */

public class VideoGame implements Comparable<VideoGame> {

    private String playerName;
    private String score;

    public VideoGame() {
    }

    public VideoGame(String playerName, String score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int compareTo(VideoGame other) {
        if (this.getPlayerName().compareToIgnoreCase(other.getPlayerName()) == 0) {
            return 0;
        } else if (this.getPlayerName().compareToIgnoreCase(other.getPlayerName()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "\nPlayer Name: " + playerName + "\nScore: " + score;
    }

}
