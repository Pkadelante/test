import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class Main {

  private static final String LOGTAG = "MAIN";

  public static void main(String[] args) {
    ApiContextInitializer.init();
    BotLogger.info(LOGTAG, "inited");

    TelegramBotsApi botsApi = new TelegramBotsApi();

    try {
      botsApi.registerBot(new MyAmazingBot());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
    BotLogger.info(LOGTAG, "done");
  }
}