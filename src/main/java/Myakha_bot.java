import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Myakha_bot extends TelegramWebhookBot {
    String TOKEN = "1760937974:AAFLT8WSCu7PyCPVHHafQMF0Sg7HJPYDDPA";
    String USERNAME = "gas_test_0001_bot";
    String botPath;

    public Myakha_bot(DefaultBotOptions options) {
        super(options);
    }



    /*@Override
    public void onUpdateReceived(Update update) {
        // обрабатывает команды, которые пришли в чате

    }*/

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        // обрабатывает команды, которые пришли в чате (WebHook)
        if (update.getMessage()!=null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            try {
                execute(new SendMessage(String.valueOf(chat_id), "Hi " + update.getMessage().getText()));
            } catch (TelegramApiException exc) {
                exc.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
