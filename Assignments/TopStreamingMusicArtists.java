/*
  Author: Da Huang
  Class: CISC 3130(TY2) - Data Structures
  Instructor: Katherine Chuang
  Due Date: 2/20/2020
*/

/*
  Assignment: Top Streaming Music Artists
  The goal of the assignment is to read data from the file
  Sort the artists name in alphabetical order
  Count how many time the music artists appeared in the list
*/

import java.util.*;
import java.io.*;

public class TopStreamingMusicArtists {
  public static void main(String[] args) throws Exception {
    // create Scanner to open up file
    Scanner scan = new Scanner(new File("regional-global-weekly-2020-01-17--2020-01-24.csv"));
    int col = 5;
    ArrayList<Artist> artists = new ArrayList<>();
    // read file using scanner
    // read if there are more lines available
    while(scan.hasNextLine()) {
      boolean found = false;
      String line = scan.nextLine();
      String [] arr = line.split(",");  //using string.split to split the comma in the file 
      // checking for duplicates
      for(int x = 0; x <artists.size(); x++) {
        artists.get(x);
      }
      for(Artist a : artists) {
        if(a.getName().equals(arr[2].replace("\"", ""))) {
            //increase track
            a.setTrackNo(a.getTrack() + 1);
            found = true;
            break;
        }
      }
      // if artist is not in the arraylist then it will add the artists name to the list 
      // it will also remove the quotation mark around the artists name
      if(!found) {
        Artist a = new Artist(arr[2].replace("\"", ""), 1);
        artists.add(a);
      } 
    }

    // sort the artist name alphabetical using ArrayList
    for(int j = 0; j < artists.size(); j++){
      for(int k = j+1; k < artists.size(); k++){
        if(artists.get(j).getName().compareToIgnoreCase(artists.get(k).getName()) > 0){
          Artist temp = artists.get(j);
          artists.set(j, artists.get(k));
          artists.set(k, temp);
        }
      }
    }
    // print out the artists name and count how many times the artists name appear in the file
    for(Artist a : artists) {
      System.out.println(a.getName() + " " + a.getTrack());
    }
  }
}

// create a class Artist to set and get Artist name and count them
class Artist {

  // set name and trackNo as private
  private String name;
  private int trackNo;
  
  // create constructor
  public Artist(String n, int t) {
    name = n;
    trackNo = t;
  }
  
  // create accessor to access the private variable name
  public String getName() {
    return name;
  }

  // create accessor to access the private variable trackNo
  public int getTrack(){
    return trackNo;
  }

  // create mutator to updata value name 
  public void setName(String n){
    this.name = n;
  }

  // create mutator to updata value trackNo
  public void setTrackNo(int t){
    this.trackNo = t;
  }
}
