/**
 * Created by Anna on 2015-02-23.
 */
/*
3. a) Skriv en metod som givet två strängar flätar samman dem så att metoden först tar en bokstav
från den ena strängen sedan en från den andra ända tills någon sträng tar slut. Resten i den
längre strängen läggs sist i resultatet. Att fläta samman strängen ”anna” med ”patrik” skall till
exempel ge resultatet ”apnantarik”.
b) Lös förra uppgiften med en rekursiv metod.
 */
public class uppg3 {
    public static void main(String[] args) {
        String a = "Anna";
        String b = "Patrik";
        System.out.println(recStringCombiner2( a, b));
    }
    public static String itStringCombiner(String a, String b){
        String ans = "";
        int i=0;
        while(i<a.length() && i<b.length()){
            ans += a.charAt(i);
            ans += b.charAt(i);
            i++;
        }
        if(i>=a.length()){
            ans += b.substring(i, b.length());
        }else if(i>=b.length()){
            ans += a.substring(i, a.length());
        }
        return ans;
    }
    public static String recStringCombiner2(String a, String b){
        if(a.length()==0){
            return b;
        }
        if(b.length()==0){
            return a;
        }
        return ""+a.charAt(0)+b.charAt(0)+recStringCombiner2(a.substring(1), b.substring(1));
    }
}
