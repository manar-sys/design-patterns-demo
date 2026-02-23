package patterns.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Pattern: Memento
 * Amac: Nesnenin ic durumunu disariya acmadan kaydetmek ve sonradan geri yuklemek.
 * Neden/Ne zaman: Geri al (undo) gibi durum gecmisi gerektiren senaryolarda kullanilir.
 * Arti: Kapsullemeyi bozmadan durum gecmisi yonetilir.
 * Eksi: Siklikla snapshot alinirse bellek maliyeti artabilir.
 */
public class MementoExample {

    static class Editor {
        private String text = "";

        void write(String value) {
            this.text = value;
            System.out.println("Metin guncellendi: " + text);
        }

        String getText() {
            return text;
        }

        EditorMemento save() {
            return new EditorMemento(text);
        }

        void restore(EditorMemento memento) {
            this.text = memento.getState();
            System.out.println("Metin geri yuklendi: " + text);
        }
    }

    static class EditorMemento {
        private final String state;

        EditorMemento(String state) {
            this.state = state;
        }

        String getState() {
            return state;
        }
    }

    static class History {
        private final Deque<EditorMemento> stack = new ArrayDeque<>();

        void push(EditorMemento memento) {
            stack.push(memento);
        }

        EditorMemento pop() {
            if (stack.isEmpty()) {
                return null;
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.write("Surum 1");
        history.push(editor.save());

        editor.write("Surum 2");
        history.push(editor.save());

        editor.write("Surum 3");

        EditorMemento previous = history.pop();
        if (previous != null) {
            editor.restore(previous);
        }

        previous = history.pop();
        if (previous != null) {
            editor.restore(previous);
        }

        System.out.println("Son metin: " + editor.getText());
    }
}
