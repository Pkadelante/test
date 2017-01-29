import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

public class MyAmazingBot extends TelegramLongPollingBot {


  private static final String LOGTAG = "MyAmazingBot";

  @Override
  public void onUpdateReceived(Update update) {
    try {
      Message message = update.getMessage();
      if (message != null && message.hasText()) {
          handleIncomingMessage(message);
      }
    } catch (Exception e) {
      BotLogger.error(LOGTAG, e);
    }
  }

  private void handleIncomingMessage(Message message) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.setText("Я умею отвечать!!!");
    sendMessage.enableMarkdown(true);
    sendMessage.setChatId(message.getChatId());
    sendMessage.setReplyToMessageId(message.getMessageId());

    try {
      sendMessage(sendMessage);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

  public String getBotUsername() {
    return "noteSaveBot";
  }

  public String getBotToken() {
    return "247406665:AAHeIeuXuNSsCJ9vz9Km6S7NpvsDOIb5O70";
  }

  public void clearWebhook() throws TelegramApiRequestException {

  }
}
