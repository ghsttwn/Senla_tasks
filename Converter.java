import java.util.Scanner;

public class Converter {
    private static final double EUR_TO_USD = 0.92;
    private static final double RUB_TO_USD = 92.50;
    private static final double GBR_TO_USD = 0.79;
    private static final double JPY_TO_USD = 151.30;

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===Конвертер валют===");
        System.out.println("=Доступные валюты:=");
        System.out.println("1. USD (доллар США)");
        System.out.println("2. EUR (евро)");
        System.out.println("3. RUB (российский рубль)");
        System.out.println("4. GBR (британский фунт)");
        System.out.println("5. JPY (японская йена)");
        System.out.println();

        System.out.print("Введите номер исходной валюты (1-5):");
        int fromCurrency = scanner.nextInt();

        System.out.print("Введите сумму для конвертации:");
        double amount = scanner.nextDouble();

        System.out.println("\n---Результаты конвертации ---");

        switch (fromCurrency) {
            case 1: //USD
                System.out.printf("%.2f USD = %.2f EUR\n", amount, amount * EUR_TO_USD);
                System.out.printf("%.2f USD = %.2f RUB\n", amount, amount * RUB_TO_USD);
                System.out.printf("%.2f USD = %.2f GBR\n", amount, amount * GBR_TO_USD);
                System.out.printf("%.2f USD = %.2f JPY\n", amount, amount * JPY_TO_USD);
                break;
            case 2: //EUR
                double usdFromEur = amount / EUR_TO_USD;
                System.out.printf("%.2f EUR = %.2f USD\n", amount, usdFromEur);
                System.out.printf("%.2f EUR = %.2f RUB\n", amount, usdFromEur * RUB_TO_USD);
                System.out.printf("%.2f EUR = %.2f GBR\n", amount, usdFromEur * GBR_TO_USD);
                System.out.printf("%.2f EUR = %.2f JPY\n", amount, usdFromEur * JPY_TO_USD);
                break;
            case 3: //RUB
                double usdFromRub = amount / RUB_TO_USD;
                System.out.printf("%.2f RUB = %.2f USD\n", amount, usdFromRub);
                System.out.printf("%.2f RUB = %.2f EUR\n", amount, usdFromRub * EUR_TO_USD);
                System.out.printf("%.2f RUB = %.2f GBR\n", amount, usdFromRub * GBR_TO_USD);
                System.out.printf("%.2f RUB = %.2f JPY\n", amount, usdFromRub * JPY_TO_USD);
                break;
            case 4: // GBR
                double usdFromGbr = amount / GBR_TO_USD;
                System.out.printf("%.2f GBR = %.2f USD\n", amount, usdFromGbr);
                System.out.printf("%.2f GBR = %.2f EUR\n", amount, usdFromGbr * EUR_TO_USD);
                System.out.printf("%.2f GBR = %.2f RUB\n", amount, usdFromGbr * RUB_TO_USD);
                System.out.printf("%.2f GBR = %.2f JPY\n", amount, usdFromGbr * JPY_TO_USD);
                break;
            case 5: //JPY
                double usdFromJpy = amount / JPY_TO_USD;
                System.out.printf("%.2f JPY = %.2f USD\n", amount, usdFromJpy);
                System.out.printf("%.2f JPY = %.2f EUR\n", amount, usdFromJpy * EUR_TO_USD);
                System.out.printf("%.2f JPY = %.2f RUB\n", amount, usdFromJpy * RUB_TO_USD);
                System.out.printf("%.2f JPY = %.2f GBR\n", amount, usdFromJpy * GBR_TO_USD);
                break;
            default:
                System.out.println("Ошибка: неверный номер валюты!");
                break;
        }
        scanner.close();
    }
}
