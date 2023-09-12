import java.io.*;
import java.net.*;

public class Server {

  public static void main(String[] args) throws IOException {
  
    ServerSocket server = new ServerSocket(5000);

    while (true) {
    
      Socket socket = server.accept();
    
      // обработка запроса клиента

      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      //выбор логики в зависимости от задачи
      int n = Integer.parseInt(in.readLine());

      double x;
      double y;

      switch(n){

        // первая задача
        case 1:
          x = Double.parseDouble(in.readLine()); 
          y = Double.parseDouble(in.readLine());
          double result = calculate1(x, y);
          
          out.println(result);
          break;

        // вторая задача
        case 2:
          x = Double.parseDouble(in.readLine());
          result = calculate2(x);
          out.println(result);
          break;

        // третья задача
        case 3:
          String str =  in.readLine();

          System.out.println("Строка на вход: " + str);
          
          result = calculate3(str);
          out.println(result);
          break;

        // четвертая задача
        case 4:
          x = Double.parseDouble(in.readLine());
          y = Double.parseDouble(in.readLine());
          result = calculate4(x, y);
          out.println(result);
          break;

        // пятая задача
        case 5:
          int N = Integer.parseInt(in.readLine());
          String resultStr = "";
          for (int i = 1; i <= N; i++) {
            if (isDivisibleByDigits(i)) {
              resultStr += i + " ";
            }
          }
          out.println(resultStr);
          break;

        // если значение n не соответствует ни одному из вариантов
        default:
            System.out.println("Ошибка: некорректный номер задачи!");
            break;
    }
    
      socket.close();
    
    }
    
  }

  public static double calculate1(double x, double y) {
    return (2*Math.pow(x,3) - 4*Math.pow(x,2) + x + 1) / (9*Math.pow(y,3) + y + 4) + 3*Math.pow(y,2) + 5*y;
  }

  public static double calculate2(double x) {
    return x * 100;
  }

  public static int calculate3(String binary) {
    int result = 0;
    
    
    for(int i = 0; i < binary.length(); i++) {
      if(binary.charAt(i) == '1') {
        result = (int) (result + Math.pow(2, binary.length() - i - 1)); 
      }
    }
    
    return result;
  }

  public static double calculate4(double x, double y) {
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }

  public static boolean isDivisibleByDigits(int n) {
    String str = Integer.toString(n);
    for (int i = 0; i < str.length(); i++) {
      int digit = Character.getNumericValue(str.charAt(i));
      if (digit == 0 || n % digit != 0) {
        return false;
      }
    }
    return true;
  }

}
