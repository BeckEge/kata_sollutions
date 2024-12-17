import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KataMain {

    public static void main(String[] args) {

        System.out.println(textModifier());

    }

    public static String textModifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текстовое сообщение");
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();

        List<Character> list = new ArrayList<>();
        for (Character ch : charArray) {
            list.add(ch);
        }
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '-') {
                char before = 0;
                char after = 0;
                before = list.get(i - 1);
                after = list.get(i + 1);
                list.set(i + 1, before);
                list.set(i - 1, after);
                list.remove(i);
            }
            if (list.get(i) == '+')
                list.set(i, '!');
            if (list.get(i) == ' ' && list.get(i + 1) == ' ') {
                list.remove(i);
                i--;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (Character.isDigit(list.get(i))) {
                String temp = String.valueOf(list.get(i));
                sum += Integer.parseInt(temp);
                list.remove(i);
            }
        }

        if (sum > 0) {
            char forDigit = Integer.toString(sum).charAt(0);
            list.add(' ');
            list.add(forDigit);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : list) {
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }
}
