package patterns.behavioral.templatemethod;

/*
 * Pattern: Template Method
 * Amac: Bir algoritmanin iskeletini ust sinifta tanimlayip, bazi adimlari alt siniflara birakmak.
 * Neden/Ne zaman: Is akisinda ortak bir sira sabitken, bazi adimlar farkli uygulanacaksa kullanilir.
 * Arti: Kod tekrarini azaltir, akisi standardize eder.
 * Eksi: Kalitim bagimliligi artar; cok fazla varyasyon olursa sinif sayisi buyur.
 */
public class TemplateMethodExample {

    static abstract class DataExporter {

        public final void export() {
            openFile();
            readData();
            transformData();
            writeData();
            closeFile();
        }

        protected void openFile() {
            System.out.println("Dosya acildi.");
        }

        protected abstract void readData();

        protected abstract void transformData();

        protected abstract void writeData();

        protected void closeFile() {
            System.out.println("Dosya kapatildi.");
        }
    }

    static class CsvExporter extends DataExporter {
        @Override
        protected void readData() {
            System.out.println("CSV verisi okundu.");
        }

        @Override
        protected void transformData() {
            System.out.println("CSV verisi duzenlendi.");
        }

        @Override
        protected void writeData() {
            System.out.println("CSV cikti yazildi.");
        }
    }

    static class JsonExporter extends DataExporter {
        @Override
        protected void readData() {
            System.out.println("JSON verisi okundu.");
        }

        @Override
        protected void transformData() {
            System.out.println("JSON verisi duzenlendi.");
        }

        @Override
        protected void writeData() {
            System.out.println("JSON cikti yazildi.");
        }
    }

    public static void main(String[] args) {
        System.out.println("CSV disa aktarma akisi:");
        DataExporter csvExporter = new CsvExporter();
        csvExporter.export();

        System.out.println("---");

        System.out.println("JSON disa aktarma akisi:");
        DataExporter jsonExporter = new JsonExporter();
        jsonExporter.export();
    }
}
