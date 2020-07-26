import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


/** 
 * Title: Assignment 3 
 * Semester: COP3337 – Fall 2019
 * @author Megan Jane Thompson
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 * 
 * This program sets an alarm, provided the current time, gets the 
 * time and checks for the alarm, gets the hour, and gets the minutes.
*/
public class Clock {
  private Integer alarmHour = null;      //alarms starts as null
  private Integer alarmMinutes = null;
  String currentTime = currentTime();    //String for current date and time when program is ran
  
   /**
    * Sets the alarm.
    * @param hours hours for alarm
    * @param minutes minutes for alarm
   */
   public void setAlarm(int hours, int minutes)
   {
      alarmHour = hours;                 //sets alarm clock
      alarmMinutes = minutes;
   }

   
   /**
    * gets current time composed of hours and minutes
    * @return time in string;
   */
   public String getTime() {
	 //String for current time, just hours and minutes
     String theTime = "" + getHours() + ":" + getMinutes();   
     
     if (alarmHour != null) {          //checks to see if alarm is set
       String strAlarmHour = Integer.toString(alarmHour);   //changes alarm hour from Integer to String
       String strAlarmMin = Integer.toString(alarmMinutes); //changes alarm minutes from Integer to String
       String alarmTime = "" + strAlarmHour + ":" + strAlarmMin; //String for alarm, just hours and minutes
     
       if(theTime.compareTo(alarmTime) >= 0){ //compares alarm time to current time
         alarmHour = null;                    //sets alarm back to null once >= alarm time
         alarmMinutes = null;
         return theTime + " Alarm";           //returns time and alarm if >= alarm time
       }
       else {
         return theTime;                      //returns time if not >= alarm time
       }
     }
     else { 
       return theTime;                        //returns time if not >= alarm time
     }
   }

   
   /**
    * gets hours
    * @return hours of current time in string
   */
   public String getHours(){
      char h1 = currentTime.charAt(11);       //extracts first digit of hour
      char h2 = currentTime.charAt(12);       //extracts second digit of hour
      String currentHour = "" + h1 + h2;      //provides 2 digit String of hour
      
      return currentHour;
   }

   
   /**
    * gets minutes
    * @return hours of current time in string
   */
   public String getMinutes(){
     char m1 = currentTime.charAt(14);     //extracts first digit of minute
     char m2 = currentTime.charAt(15);     //extracts second digit of minute
     String currentMinutes = "" + m1 + m2; //provides 2 digit String of minute
     
     return currentMinutes;
   }

   
   /**
    * Returns the current Date and Time as a String.
   */
   private String currentTime(){                                            
      return LocalDateTime.ofInstant(Instant.now(), //provides String of current date and time
         ZoneId.systemDefault()).toString();
   }
}
