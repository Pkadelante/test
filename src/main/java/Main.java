import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
  public static void main(String[] args) {
    System.out.println("runed");
    ApiContextInitializer.init();

    TelegramBotsApi botsApi = new TelegramBotsApi();

    try {
      botsApi.registerBot(new MyAmazingBot());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}