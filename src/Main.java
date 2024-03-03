import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Одномерный массив с названиями фирм часов
        String[] firms = {"Rolex", "Casio", "Omega"};

        // Двумерный массив для связи списка фирм с названиями марок
        String[][] watches = {{"Submariner", "Datejust", "Daytona"},
                {"G-Shock", "Edifice", "Pro Trek"},
                {"Seamaster", "Speedmaster", "Constellation"}};

        // Создаем список покупателей и их заказов с помощью ArrayList
        ArrayList<Purchase> purchases = new ArrayList<>();

        // Вводим данные покупателей и их заказов с клавиатуры
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные покупателя " + (i + 1) + ":");
            System.out.print("ФИО: ");
            String fullName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Номер телефона: ");
            String phoneNumber = scanner.nextLine();
            //вывод доступных позиций
            System.out.println("Список доступных позиций: ");
            for (int j = 0; j < firms.length; j++) {
                for (int k = 0; k < watches[j].length; k++) {
                    System.out.println(j + 1 + "." + (k + 1) + " - " + watches[j][k] + " (" + firms[j] + ")");
                }
            }
            System.out.print("Выберите номер позиции: ");
            int firmIndex = scanner.nextInt() - 1; // начало с 0 поэтому -1
            int watchIndex = scanner.nextInt() - 1;

            System.out.print("Количество: ");
            int quantity = scanner.nextInt();

            String firm = firms[firmIndex];
            String watch = watches[firmIndex][watchIndex];

            purchases.add(new Purchase(fullName, email, phoneNumber, firm, watch, quantity));
            scanner.nextLine(); // переход
        }

        // Выводим данные покупателей и их заказов
        for (Purchase purchase : purchases) {
            System.out.println("Заказчик: " + purchase.getFullName());
            System.out.println("Email: " + purchase.getEmail());
            System.out.println("Номер телефона: " + purchase.getPhoneNumber());
            System.out.println("Позиция товара: " + purchase.getFirm() + " - " + purchase.getWatch());
            System.out.println("Количество: " + purchase.getquantity());
            System.out.println();
        }
    }

    // Класс Purchase для хранения данных о покупателях и их заказах
    static class Purchase {
        private final String fullName;
        private final String email;
        private final String phoneNumber;
        private final String firm;
        private final String watch;
        private final int quantity;


        // конструктор
        public Purchase(String fullName, String email, String phoneNumber, String firm, String watch, int quantity) {
            this.fullName = fullName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.firm = firm;
            this.watch = watch;
            this.quantity = quantity;
        }


        // функции для вызова аргументов
        public String getFullName() {
            return fullName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getFirm() {
            return firm;
        }

        public String getWatch() {
            return watch;
        }

        public int getquantity() {
            return quantity;
        }
    }
}