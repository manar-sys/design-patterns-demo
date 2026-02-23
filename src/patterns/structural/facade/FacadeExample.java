package patterns.structural.facade;

/*
 * Pattern: Facade
 * Amac: Karmasik bir alt sistem ustune tek ve basit bir API sunmak.
 * Neden/Ne zaman: Istemci cok sayida dusuk seviye sinifa bagimli olmamaliysa kullanilir.
 * Arti: Kullanimi basitlestirir, bagimliligi azaltir.
 * Eksi: Asiri buyurse facade sinifi god-object'e donusebilir.
 */
public class FacadeExample {

    static class VideoDecoder {
        String decode(String file) {
            return file + " dosyasi cozuldu";
        }
    }

    static class AudioMixer {
        String mix(String audioTrack) {
            return audioTrack + " sesi karistirildi";
        }
    }

    static class MediaConverterFacade {
        private final VideoDecoder decoder = new VideoDecoder();
        private final AudioMixer mixer = new AudioMixer();

        String convertToMp4(String input) {
            String video = decoder.decode(input);
            String audio = mixer.mix("varsayilan-ses");
            return video + " + " + audio + " -> cikti.mp4";
        }
    }

    public static void main(String[] args) {
        MediaConverterFacade converter = new MediaConverterFacade();
        System.out.println(converter.convertToMp4("movie.mkv"));
    }
}
