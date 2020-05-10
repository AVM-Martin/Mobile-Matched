package id.my.avmmartin.matched.factory;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import id.my.avmmartin.matched.data.network.firestore.model.Chat;
import id.my.avmmartin.matched.data.network.firestore.model.User;

public class ChatFactory {
    private List<User> chatGroups = new Vector<>();
    private List<Chat> chatDetails = new Vector<>();

    public static List<User> getAllChatGroups() {
        return instance.chatGroups;
    }

    public static List<Chat> getChatDetails() {
        return instance.chatDetails;
    }

    // creator

    private void createChatGroups() {
        chatGroups = new Vector<>();

        chatGroups.add(new User("ekeitaro", "taro"));
    }

    private void createChatDetails() {
        chatDetails = new Vector<>();

        Calendar calendarA = Calendar.getInstance();
        calendarA.set(Calendar.HOUR_OF_DAY, 13);
        calendarA.set(Calendar.MINUTE, 50);

        Calendar calendarB = Calendar.getInstance();
        calendarB.set(Calendar.HOUR_OF_DAY, 13);
        calendarB.set(Calendar.MINUTE, 57);

        Calendar calendarC = Calendar.getInstance();
        calendarC.set(Calendar.HOUR_OF_DAY, 14);
        calendarC.set(Calendar.MINUTE, 01);

        chatDetails.add(new Chat(
            calendarA,
            "What time do you want to meet up on June 6?",
            "ekeitaro",
            "avm_martin"
        ));

        chatDetails.add(new Chat(
            calendarB,
            createFreeSchedule(),
            "Bot",
            "avm_martin"
        ));

        chatDetails.add(new Chat(
            calendarC,
            "What about 15:00?",
            "avm_martin",
            "ekeitaro"
        ));
    }

    private String createFreeSchedule() {
        return (
            "Free schedule 1\n" + "00:00 - 07:00\n" + "\n"
                + "Free schedule 2\n" + "10:00 - 12:00\n" + "\n"
                + "Free schedule 3\n" + "14:00 - 17:00\n" + "\n"
                + "Free schedule 4\n" + "18:00 - 19:00\n" + "\n"
                + "Free schedule 5\n" + "21:00 - 23:59"
        );
    }

    // singleton

    private static ChatFactory instance = new ChatFactory();

    private ChatFactory() {
        createChatGroups();
        createChatDetails();
    }
}
