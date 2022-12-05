import java.util.Scanner ;
public class HangmanGame {

    public static boolean check(String word, char ch) {
        for (int i = 0; i < word.length(); i++) { //With this loop,
            // I check the letters of the entered word one by one.

            if (ch == word.charAt(i)) { //And if the entered character and the letter of the word match,
                // the check method returns true
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a word to start playing game : ");
        String word = input.nextLine();
        char ch = ' ';
        String hiddenWord = "";

        for (int i = 0; i < word.length(); i++) { //This loop is for printing "-" as long as the length of the word.
            hiddenWord += "-";
        }
        System.out.print("The hidden word : " + hiddenWord);

        System.out.println();

        boolean checkStatus = true;
        while (checkStatus) {

            System.out.print("Please enter a character to guess the word : ");
            String chr = input.nextLine(); //Since we can't get the character directly from the user in java,
            //I'm getting a string from the user.

            ch = chr.charAt(0); //With the equality here, I get the first letter of the string.
            //So I get a character from the user.

            if (check(word, ch) == true) {
                for (int j = 0; j < word.length(); j++) { //With this loop,
                    // I check the letters of the entered word one by one.

                    if (ch == word.charAt(j)) { //If the entered character and the letters of the word match,

                        hiddenWord = hiddenWord.substring(0, j) + ch + hiddenWord.substring(j + 1);
                        //Here,I update the hidden word using the substring method.
                    }
                }
            }
            System.out.println("The hidden word : " + hiddenWord);

            if (hiddenWord.equals(word)) { //Here, I end the while loop if the entered word matches with the hidden word.
                checkStatus = false;
            }
        }
    }
}
