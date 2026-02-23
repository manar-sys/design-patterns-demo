package patterns.behavioral.state;

/*
 * Pattern: State
 * Amac: Nesnenin davranisini ic durumuna gore degistirmek.
 * Neden/Ne zaman: Duruma bagli cok sayida if-else oldugunda ve davranis durum bazli degisiyorsa kullanilir.
 * Arti: Durum mantigini ayri siniflara boler, kodu sade ve genisletilebilir yapar.
 * Eksi: Durum sayisi arttikca sinif sayisi da artar.
 */
public class StateExample {

    interface PlayerState {
        void play(MusicPlayer player);

        void pause(MusicPlayer player);

        void stop(MusicPlayer player);

        String name();
    }

    static class MusicPlayer {
        private PlayerState state = new StoppedState();

        void setState(PlayerState state) {
            this.state = state;
        }

        void pressPlay() {
            state.play(this);
        }

        void pressPause() {
            state.pause(this);
        }

        void pressStop() {
            state.stop(this);
        }

        void showState() {
            System.out.println("Guncel durum: " + state.name());
        }
    }

    static class StoppedState implements PlayerState {
        @Override
        public void play(MusicPlayer player) {
            System.out.println("Muzik oynatilmaya basladi.");
            player.setState(new PlayingState());
        }

        @Override
        public void pause(MusicPlayer player) {
            System.out.println("Zaten durmus durumda, pause uygulanmadi.");
        }

        @Override
        public void stop(MusicPlayer player) {
            System.out.println("Zaten durmus durumda.");
        }

        @Override
        public String name() {
            return "Durduruldu";
        }
    }

    static class PlayingState implements PlayerState {
        @Override
        public void play(MusicPlayer player) {
            System.out.println("Muzik zaten oynuyor.");
        }

        @Override
        public void pause(MusicPlayer player) {
            System.out.println("Muzik duraklatildi.");
            player.setState(new PausedState());
        }

        @Override
        public void stop(MusicPlayer player) {
            System.out.println("Muzik durduruldu.");
            player.setState(new StoppedState());
        }

        @Override
        public String name() {
            return "Oynatiyor";
        }
    }

    static class PausedState implements PlayerState {
        @Override
        public void play(MusicPlayer player) {
            System.out.println("Duraklatilan muzik devam ediyor.");
            player.setState(new PlayingState());
        }

        @Override
        public void pause(MusicPlayer player) {
            System.out.println("Muzik zaten duraklatildi.");
        }

        @Override
        public void stop(MusicPlayer player) {
            System.out.println("Duraklatilan muzik durduruldu.");
            player.setState(new StoppedState());
        }

        @Override
        public String name() {
            return "Duraklatildi";
        }
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.showState();
        player.pressPlay();
        player.showState();

        player.pressPause();
        player.showState();

        player.pressPlay();
        player.showState();

        player.pressStop();
        player.showState();
    }
}
