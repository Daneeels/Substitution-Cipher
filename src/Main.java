import java.util.*;

public class Main {
    public static String alp = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String text, int key){
        String cText = "";
        text = text.toLowerCase();

        for (int i = 0;i < text.length();i++){
            int oIndex = alp.indexOf(text.charAt(i));
            int nIndex = (oIndex + key) % 26;
            char cChar = alp.charAt(nIndex);
            cText += cChar;
        }


        return cText;
    }

    public static String decrypt(String cText, int key){
        String text = "";
        cText = cText.toLowerCase();

        for (int i = 0;i < cText.length();i++){
            int oIndex = alp.indexOf(cText.charAt(i));
            int nIndex = (oIndex - key) % 26;
            if (nIndex < 0){
                nIndex = alp.length() + nIndex;
            }
            char pChar = alp.charAt(nIndex);
            text += pChar;
        }

        return text;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        System.out.print("Key: ");
        int key = in.nextInt();

        System.out.println("The encrypted text: " + encrypt(text,key));

        String cText = encrypt(text,key);
        System.out.println("The decrypted text: " + decrypt(cText,key));
    }
}