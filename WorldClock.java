/** 
 * Title: Assignment 3 
 * Semester: COP3337 – Fall 2019
 * @author Megan Jane Thompson
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 * 
 * This program extends the Clock class and accepts a time offset.
 */
public class WorldClock extends Clock {
  Integer offset = 0;
  
  /**
   * constructs WorldClock and sets offset amount.
   * @param offsetAmount is the offset amount from current time zone.
  */
  public WorldClock(int offsetAmount) {
    offset = offsetAmount;
  }
  
  
  /**
   * gets offset hours
   * @return offset hours from current time in string
  */
  public String getHours(){
    char h1 = currentTime.charAt(11);      //extracts first digit of hour
    char h2 = currentTime.charAt(12);      //extracts second digit of hour
    String currentHour = "" + h1 + h2;     //provides 2 digit String of hour
    Integer currentIntHour = (Integer.parseInt(currentHour) + offset) % 24;  //adds offset amount and keeps time format
    String newCurrentHour = Integer.toString(currentIntHour); //changes hour from Integer to String
      
    return newCurrentHour;
  }
}
