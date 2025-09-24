import java.util.*;

public class HangMan {
    private static final List<String> WORDS = Arrays.asList(
        "эчпочмак","яблоко", "книга", "кот", "собака", "слон", "цветок", "сад", "дом", "лёд", "куртка", "лампа", "гора", "тетрадь", "океан", "карандаш", "королева", "река", "солнце", "дерево", "зонт", "скрипка", "вода", "ксилофон", "зебра", "воздух", "мяч", "часы", "дверь", "земля", "огонь", "стекло", "шляпа", "остров", "сок", "ключ", "свет", "зеркало", "ночь", "апельсин", "бумага", "дождь", "камень", "чай", "голос", "окно");
    private static final int Max_Lives = 6;
    private static final String[] Hangman_death = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while(true){
        String word = WORDS.get(random.nextInt(WORDS.size())).toLowerCase();
        Set<Character> Guessed_Letters = new HashSet<>();
        Set<Character> Wrong_Letters = new HashSet<>();
        int Lives = Max_Lives;

        System.out.println("Welcome to the game \"Hangman\"!");
        boolean gameWon = false;

        while (Lives > 0 && !IsWordGuessed(word,Guessed_Letters)){
            DisplayCurrentState(word,Guessed_Letters);
            System.out.println("Lives left: " + Lives);
            System.out.println(Hangman_death[Max_Lives - Lives]);
            System.out.println("Guessed letters: " + formatLetters(Guessed_Letters));
            System.out.println("Mistakes "+ formatLetters(Wrong_Letters));
            System.out.println("Enter the letter or a whole word!");
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.length()>1){
                if (input.equals(word)){
                    System.out.println("Amazing! You won!");
                    gameWon = true;
                    break;
                }else{
                    System.out.println("You lost((");
                    Lives =0;
                    break;
                }
            }
            if (input.length()!=1 || !Character.isLetter((input.charAt(0)))){
                System.out.println("Please, enter ONE russian letter or a whole word");
                continue;
            }
            char letter = input.charAt(0);

            if (Guessed_Letters.contains(letter) || Wrong_Letters.contains(letter)){
                System.out.println("You have already tried this letter");
                continue;
            }
            if (word.contains(String.valueOf(letter))){
                Guessed_Letters.add(letter);
                System.out.println("This is correct letter!");
            }else{
                Wrong_Letters.add(letter);
                Lives--;
                System.out.println("This is incorrect letter!");
            }
            System.out.println();
        }
        if (IsWordGuessed(word, Guessed_Letters)){
            System.out.println("Congrats! you guessed the word: " + word.toUpperCase());
        }else{
            System.out.println(Hangman_death[Max_Lives]);
            System.out.println("You lost (((( The correct word was :"+ word.toUpperCase());
        }
        while (true){
            System.out.println("\nDo you wanna play again? (y/n)");
            String answer = scanner.nextLine().toLowerCase().trim();
            if (answer.equals("y")){
                break;
            }else if (answer.equals("n")){
                System.out.println("Thanks for game! See you later!");
                scanner.close();
                return;
            }else{
                System.out.println("Please enter 'y' to continue or 'n' to exit");
            }
        }
    }}
    private static String formatLetters(Set<Character> letters){
        if (letters.isEmpty()){
            return "-";}
        List<Character> sorted = new ArrayList<>(letters);
        Collections.sort(sorted);
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< sorted.size(); i++){
            if (i>0) sb.append(", ");
            sb.append(sorted.get(i));
        }
        return sb.toString();
    }
    private static void DisplayCurrentState (String word, Set<Character> GuessedLetters){
        System.out.print("Word is: ");
        for (char c : word.toCharArray()){
            if (GuessedLetters.contains(c)){
                System.out.print(c + " ");
            } else{
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private static boolean IsWordGuessed(String word, Set<Character> GuessedLetters){
        for (char c : word.toCharArray()){
            if(!GuessedLetters.contains(c)){
                return false;
            }
        }
        return true;
    }
}
