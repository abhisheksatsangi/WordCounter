public class Translator {

    // Dummy implementation.
    public String translate(String word) {
        if("flor".equals(word) || "blume".equals(word)) {
            return "flower";
        }
        return word;
    }
}
