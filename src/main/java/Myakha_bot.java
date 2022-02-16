import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Myakha_bot extends TelegramLongPollingBot {
    private static final String TOKEN = "1760937974:AAFLT8WSCu7PyCPVHHafQMF0Sg7HJPYDDPA";
    private static final String USERNAME = "gas_test_0001_bot";

    public Myakha_bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // обрабатывает команды, которые пришли в чате
        if (update.getMessage()!=null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            try {
                execute(new SendMessage(String.valueOf(chat_id), "Hi " + update.getMessage().getText()));
            } catch (TelegramApiException exc) {
                exc.printStackTrace();
            }
        }
    }
}
