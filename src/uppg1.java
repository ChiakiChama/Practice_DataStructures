/**
 * Created by Anna on 2015-02-23.
 */
 /*
 1. Skriv en metod som givet ett argument av typen int[], ett heltal samt ett index placerar in
heltalet på den position som ges av indexet samt flyttar alla element i fältet med samma eller
högre index ett steg ”uppåt". Det sista elementet i fältet försvinner ur fältet om antalet tal i fältet
skulle bli för stort. För att kunna testa metoden kan det vara bra att använda Arrays.toString(int[] a) i util-paketet.
  */
public class uppg1 {

    public static void main(String[] args) {
        int[] anArray = {
                1,2,3,4,5,6,7
        };
        int[] modifiedArray= addInArray(anArray,90,0);

        for(int i= 0; i<modifiedArray.length; i++){
            System.out.println(modifiedArray[i]);
        }
    }
    public static int[] addInArray(int[] arr, int nmbr, int index){
        for(int i = arr.length-2; i>=index && i>=0; i-- ){
            arr[i+1]=arr[i];
        }
        arr[index]=nmbr;
        return arr;
    }
}
