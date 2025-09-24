import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String UpperCase = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
    private static final String Digits = "0123456789";
    private static final String SpecialChars = "!@#$%();:,.<>^&*~`";

    private static final String AllChars = LowerCase+UpperCase+Digits+SpecialChars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Генератор паролей");
        System.out.println("Введите желаемую длину пароля (8-12):");

        int lenght;
        while(true){
            if (scanner.hasNextInt()){
                lenght = scanner.nextInt();
                if (lenght >=8 && lenght <=12){
                    break;
                }else{
                    System.out.println("Длина пароля должна быть от 8 до 12 символов, попробуйте еще раз !)");
                }
            }else {
                System.out.println("Некорректный ввод, введите число от 8 до 12: ");
                scanner.next();
            }
        }
        String password = generatePassword(lenght,random);
        System.out.println("Сгенерированный пароль: " + password);
        scanner.close();
    }
    private  static String generatePassword(int lenght, Random random){
        StringBuilder password = new StringBuilder();
        password.append(LowerCase.charAt(random.nextInt(LowerCase.length())));
        password.append(UpperCase.charAt(random.nextInt(UpperCase.length())));
        password.append(Digits.charAt(random.nextInt(Digits.length())));
        password.append(SpecialChars.charAt(random.nextInt(SpecialChars.length())));
        for (int i = 4; i<lenght;i++){
            password.append(AllChars.charAt(random.nextInt(AllChars.length())));
        }
        return shuffleString(password.toString(),random);
    }
    private static String shuffleString(String input, Random random){
        char[] chars= input.toCharArray();
        for (int i = chars.length -1; i>0;i--){
            int j = random.nextInt(i+1);
            char temp = chars[i];
            chars[i]=chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

}
