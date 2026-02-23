package patterns.behavioral.command;

/*
 * Pattern: Command
 * Amac: Bir istegi nesne olarak sarmalamak.
 * Neden/Ne zaman: Kuyruklama, undo/redo, zamanlama veya gonderen/alici ayrimi gerektiginde kullanilir.
 * Arti: Eylemler kolay genisler, gecmis takibi desteklenir.
 * Eksi: Cok sayida komut sinifi ekleyebilir.
 */
public class CommandExample {

    interface Command {
        void execute();
    }

    static class Light {
        void on() {
            System.out.println("Lamba ACIK");
        }

        void off() {
            System.out.println("Lamba KAPALI");
        }
    }

    static class LightOnCommand implements Command {
        private final Light light;

        LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.on();
        }
    }

    static class LightOffCommand implements Command {
        private final Light light;

        LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.off();
        }
    }

    static class RemoteControl {
        void submit(Command command) {
            command.execute();
        }
    }

    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.submit(new LightOnCommand(light));
        remote.submit(new LightOffCommand(light));
    }
}
