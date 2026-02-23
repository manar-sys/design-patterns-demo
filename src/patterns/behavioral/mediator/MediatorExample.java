package patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern: Mediator
 * Amac: Nesneler arasi iletisimi merkezi bir araci (mediator) uzerinden yonetmek.
 * Neden/Ne zaman: Cok sayida nesne birbirine dogrudan baglanip karmasik bagimlilik olusturuyorsa kullanilir.
 * Arti: Nesneler arasi bagimliligi azaltir, iletisim kurallarini merkezilesitirir.
 * Eksi: Mediator sinifi zamanla fazla sorumluluk alip buyuyebilir.
 */
public class MediatorExample {

    interface ChatMediator {
        void sendMessage(String message, User sender);

        void addUser(User user);
    }

    static class GroupChatMediator implements ChatMediator {
        private final List<User> users = new ArrayList<>();

        @Override
        public void sendMessage(String message, User sender) {
            for (User user : users) {
                if (user != sender) {
                    user.receive(message, sender.getName());
                }
            }
        }

        @Override
        public void addUser(User user) {
            users.add(user);
        }
    }

    static abstract class User {
        protected final ChatMediator mediator;
        protected final String name;

        User(ChatMediator mediator, String name) {
            this.mediator = mediator;
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract void send(String message);

        abstract void receive(String message, String from);
    }

    static class ChatUser extends User {
        ChatUser(ChatMediator mediator, String name) {
            super(mediator, name);
        }

        @Override
        void send(String message) {
            System.out.println(name + " gonderdi: " + message);
            mediator.sendMessage(message, this);
        }

        @Override
        void receive(String message, String from) {
            System.out.println(name + " aldi (" + from + " ->): " + message);
        }
    }

    public static void main(String[] args) {
        ChatMediator mediator = new GroupChatMediator();

        User ali = new ChatUser(mediator, "Ali");
        User sara = new ChatUser(mediator, "Sara");
        User can = new ChatUser(mediator, "Can");

        mediator.addUser(ali);
        mediator.addUser(sara);
        mediator.addUser(can);

        ali.send("Merhaba ekip!");
        sara.send("Selam, toplanti basliyor.");
    }
}
