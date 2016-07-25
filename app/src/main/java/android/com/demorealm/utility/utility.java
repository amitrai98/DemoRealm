package android.com.demorealm.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by amitrai on 25/7/16.
 */
public class utility {

    public static String getTodaysDate(){
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        return formattedDate;
    }
}
