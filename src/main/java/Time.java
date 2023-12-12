import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public String getTime(){
        Date d = new Date();
        SimpleDateFormat d1 = new SimpleDateFormat("HH_mm_ss");

        return d1.format(d);
    }
}