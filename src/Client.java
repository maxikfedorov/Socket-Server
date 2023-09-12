import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws IOException {
    try {
      Socket socket = new Socket("localhost", 5000);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      Scanner scanner = new Scanner(System.in);
      System.out.println("Успешное подключение к сокету !");
      
      System.out.print("Введите номер задачи: ");
      while (!scanner.hasNextInt()) {
        System.out.println("Ошибка: введите число!");
        scanner.next();
      }

      int n = scanner.nextInt();

      out.println(n);

      System.out.println("");

      switch(n){
        case 1:
          System.out.println("Задача 1.");

          System.out.print("Введите X: ");
            while (!scanner.hasNextDouble()) {
              System.out.println("Ошибка: введите число!");
              scanner.next();
            }
            double x = scanner.nextDouble();

          System.out.print("Введите Y: ");
            while (!scanner.hasNextDouble()) {
              System.out.println("Ошибка: введите число!");
              scanner.next();
            }
            double y = scanner.nextDouble();

          out.println(x);
          out.println(y);

          break;

        case 2:
          System.out.println("Задача 2.");

          System.out.print("Введите X: ");

          while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите число!");
            scanner.next();
          }

          x = scanner.nextDouble();

          out.println(x);

          break;

        case 3:
          System.out.println("Задача 3.");

          System.out.print("Введите двоичное число (на конце 0): ");

          String str = scanner.next();
          
          out.println(str);

          break;

        case 4:
          System.out.println("Задача 4.");

          System.out.print("Введите первый катет: ");
          while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите число!");
            scanner.next();
          }
          double a = scanner.nextDouble();

          System.out.print("Введите второй катет: ");
          while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите число!");
            scanner.next();
          }
          double b = scanner.nextDouble();

          out.println(a);
          out.println(b);

          break;

        case 5:
          System.out.println("Задача 5.");

          System.out.print("Введите число N: ");
          while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите число!");
            scanner.next();
          }
          int N = scanner.nextInt();

          out.println(N);

          break;

        default:
          System.out.println("Ошибка: некорректный номер задачи!");
          break;
      }

      String result = in.readLine();

      System.out.println("Результат: " + result);
      socket.close();
    } catch (UnknownHostException e) {
      System.err.println("Не удалось подключиться к указанному хосту.");
    } catch (IOException e) {
      System.err.println("Ошибка при работе с сокетом: " + e.getMessage());  
    }      
  }
}
