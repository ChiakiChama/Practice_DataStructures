import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anna on 2015-02-23.
 */
/*
 2. Skriv ett program som kan läsa en text från en fil och göra frekvensanalys på de bokstäver (även
'å', 'ä' och 'ö') som förekommer. För att lagra information, får ni inte använda någon datastruktur
i util-paketet, utan endast använda variabler och fält. Utdata skall ges i form av en tabell:
boks antal frekv
a 112 9.33
b 15 1.25
. ... ...
och så vidare.
Frekvensen anges i % och endast bokstäver som förekommer minst 1 gång tas med.
Texter på olika språk har en karaktäristisk frekvensfördelning (som jag inte kommer ihåg). Se
om ni kan se någon skillnad på engelsk respektive svensk text genom att testa med någon lite
större lämplig text på vardera språket.
 */
public class uppg2 {
    public static void main(String[] args) {
        ReadFromTxt();
    }

    public static void ReadFromTxt(){
        Reader in = null;
        int[][] letters = new int[30][3];
        try {
            in = new BufferedReader(new FileReader("text1.txt"));
            try{
                int input;
                int totalCharacters= 0;
                while ((input =in.read()) != -1) {
                    //here is all the input and where we process the data
                    char c = (char)input;
                    int i=0;
                    while(i<letters.length-1 && letters[i][0]!=0 && letters[i][0]!= c){
                        i++;
                    }

                    if(letters[i][0]== c){
                        letters[i][1]++;
                    }else{
                        letters[i][0]=c;
                        letters[i][1]=1;
                    }
                    totalCharacters++;
                }
                for(int i= 0; i<letters.length && letters[i][1]!=0 ; i++){
                    System.out.println((char)letters[i][0] + " " + letters[i][1]+ " " + (((double)letters[i][1])/(float)totalCharacters)*100);
                }

            }finally{
                in.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     public static void ReadFromTxtWithScanner(){
         Scanner in=null;
         try {
             in = new Scanner(new FileReader("text1.txt"));
             while (in.hasNext()) {
                 System.out.println(in.next());
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }finally {
             in.close();
         }
     }


}
