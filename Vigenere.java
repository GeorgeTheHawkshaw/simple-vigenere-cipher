import java.util.Scanner;

public class Vigenere {

    private static char[] alphabetarr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //Character array for the alphabet in all caps.

    public static void main (String []args){

        //Ask the user for input
        Scanner input = new Scanner(System.in); //Instantiate a scanner to take input from console
        System.out.print("Enter the plaintext: "); //Ask for the original text
        String plaintext = input.nextLine().toUpperCase(); //Capitalize everything so we only need to work with one character array

        System.out.print("Enter the key: "); //Ask user for the keyword
        String key = input.nextLine().toUpperCase(); //Capitalize this too

        char[] plaintextarray = plaintext.toCharArray(); //Put the plaintext into a character array so it's easier to work with
        char[] keyArray = key.toCharArray(); //Put the keyword into another character array.
        char[] ciphertext = new char[plaintextarray.length]; //Create a character array for the ciphertext.


        int keypos = 0; //Creates a pointer for the keyword index and sets it = 0
        for(int pos = 0; pos < plaintextarray.length; pos++){ //Iterate through each character/letter of the plaintext

            if(index(plaintextarray[pos]) == -1) //Make sure that this character is a letter of the alphabet
                continue; //ignore special characters or numbers
            if(index(keyArray[keypos])==-1){ //Make sure the character of the keyword pointer is also a letter
                keypos++; //if not, then increment again.
            }
            ciphertext[pos] = encode(index(plaintextarray[pos]),index(keyArray[keypos])); //encode each letter with the keyword
            if(keypos+1 >= keyArray.length && pos < plaintextarray.length){ // make sure the keyword pointer doesn't go out of bounds
                keypos = 0;
            }else{
                keypos++;
            }
        }

        System.out.print("Cipher text is: "); //Output
        for(int iterateCipher = 0; iterateCipher < ciphertext.length; iterateCipher++){
            System.out.print(ciphertext[iterateCipher]);
        } //Output for the cipher text by iterating through the ciphertext array and printing out each letter.
    }
    public static int index(char c){ //Custom index method to return the position of a given character in the alphabet.
        for(int inde = 0; inde < alphabetarr.length; inde++){ //Iterate through the alphabet array and check for a match
            if(alphabetarr[inde] == c){
                return inde; //returns the position of this letter in the alphabet array
            }
        }
        //System.out.println("NO");
        return -1; //Returns -1 if the character doesn't exist
    }
    public static char encode(int original, int key){
        int sum = original+key; //Vignere cipher, position of the plaintext letter + position of the keyword letter
        if(sum > alphabetarr.length){ //if the sum is over 26
            return alphabetarr[sum-alphabetarr.length]; //take the difference and wrap around the alphabet
        }else{
            return alphabetarr[sum]; //if condition is false, then just return the letter of the sum normally.
        }
    }
}
