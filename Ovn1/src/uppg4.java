/**
 * Created by Anna on 2015-02-23.
 */
/* 4. Gör en definition av en klass som är lämplig för att kunna representera ett datum på 2000-talet
och en veckodag. Ge också en metod som givet ett datum returnerar dess veckodag.
Tips: Den 1 jan 2000 var en lördag.
(Räkna med skottår vart 4:e år, men strunta i övriga småvariationer. )
*/
public class uppg4 {
    public static void main(String[] args) {
        uppg4 date = new uppg4(2015,2,23);
        System.out.println(date.dateToWeekday());
    }
    private int year;
    private int month;
    private int day;
    private int weekday;
    private boolean leapYear;

    public uppg4(int year, int month, int day){
        if(dateIsValid(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
            setLeapYear();
        }
    }
    private void setLeapYear(){
        this.leapYear=true;
    }
    private boolean dateIsValid(int year, int month, int day){
        if(year<2000 || month<1 || month>12 || day<1) {
            return false;
        }
        if(month==2) {
            if (leapYear && day > 29) return false;
            if(day>28) return false;
        }
        if(month==1 ||month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12){
            if(day>31) return false;
        }else{
            if(day>30) return false;
        }
        return true;
    }

    public String dateToWeekday(){
        int i=2000;
        int daysSinceBegining=0;
        while(year>i){
            if(i%4==0){
                daysSinceBegining++;
            }
            daysSinceBegining+=365;
            i++;
        }
        i=1;
        while(month>i){
            if(i==2) {
                if (leapYear) {
                    daysSinceBegining++;
                }
                daysSinceBegining += 28;
            }
            if(i==1 ||i==3 ||i==5 ||i==7 ||i==8 ||i==10 ||i==12){
                daysSinceBegining+=31;
            }else{
                daysSinceBegining+=30;
            }
            i++;
        }
        daysSinceBegining+=day;
        System.out.println(daysSinceBegining);
        daysSinceBegining+=5;
        switch (daysSinceBegining%7){
            case(1): return "Måndag";
            case(2): return "Tisdag";
            case(3): return "Onsdag";
            case(4): return "Torsdag";
            case(5): return "Fredag";
            case(6): return "Lördag";
            case(0): return "Söndag";
            default: return "Okänd";
        }
    }
}
