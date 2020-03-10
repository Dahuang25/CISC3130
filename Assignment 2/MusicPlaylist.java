/*
  Author: Da Huang
  Class: CISC 3130(TY2) - Data Structures
  Instructor: Katherine Chuang
  Due Date: 3/7/2020
*/

/*
  Assignment 2: Music Playlist
  The objectives of this assignment is to read multiple file and build a playlist.
  Also, sort all the song track into alphabetical order
*/

import java.util.*;
import java.io.*;

public class MusicPlaylist {
  public static void main(String[] args) throws Exception {
    // store files into array
    String [] arr2 = {"week1.csv", "week2.csv"};
    // using for loop to read files from array
    for(int i = 0; i < arr2.length; i++){
    Scanner scan = new Scanner(new File(arr2[i]));
    int col = 5;
    ArrayList<Playlist> lists = new ArrayList<>();
    // read file using scanner
    // read if there are more lines available
    while(scan.hasNextLine()) {
      boolean found = false;
      String line = scan.nextLine();
      String [] arr = line.split(",");  //using string.split to split the comma in the file 
      // checking for duplicates
      for(int x = 0; x <lists.size(); x++) {
        lists.get(x);
      }
      for(Playlist a : lists) {
        if(a.getSong().equals(arr[1].replace("\"", ""))) {
            //increase track
            a.setTrackNo(a.getTrack() + 1);
            found = true;
            break;
        }
      }
      // if artist is not in the arraylist then it will add the artists name to the list 
      // it will also remove the quotation mark around the artists name
      if(!found) {
        Playlist a = new Playlist(arr[1].replace("\"", ""), 1);
        lists.add(a);
      } 
    }

    // sort the artist name alphabetical using ArrayList
    for(int j = 0; j < lists.size(); j++){
      for(int k = j+1; k < lists.size(); k++){
        if(lists.get(j).getSong().compareToIgnoreCase(lists.get(k).getSong()) > 0){
          Playlist temp = lists.get(j);
          lists.set(j, lists.get(k));
          lists.set(k, temp);
        }
      }
    }
    // print out the artists name and count how many times the artists name appear in the file
    for(Playlist a : lists) {
      System.out.println(a.getSong());
    }
  }
}
}

// create a class Playlist to set and get Artist name and count them
class Playlist {

  // set name and trackNo as private
  private String song;
  private int trackNo;
  
  // create constructor
  public Playlist(String n, int t) {
    song = n;
    trackNo = t;
  }
  
  // create accessor to access the private variable name
  public String getSong() {
    return song;
  }

  // create accessor to access the private variable trackNo
  public int getTrack(){
    return trackNo;
  }

  // create mutator to update value name 
  public void setSong(String n){
    this.song = n;
  }

  // create mutator to update value trackNo
  public void setTrackNo(int t){
    this.trackNo = t;
  }
}
   
