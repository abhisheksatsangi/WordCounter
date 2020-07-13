import java.util.HashMap;
import java.util.Map;

public class WordCounter implements Countable {

    private Map<String, Integer> wordsMap = new HashMap();
    private Translator translator = new Translator();

    public void addWord(String word) {
        if(this.validateString(word)) {
            Integer count = new Integer(0);
            String translatedWord = translator.translate(word);
            if (!wordsMap.containsKey(translatedWord)) {
                wordsMap.put(translatedWord, ++count);
            } else {
                for (Map.Entry wordElement : wordsMap.entrySet()) {
                    String key = (String) wordElement.getKey();
                    if (key.equals(translatedWord)) {
                        wordsMap.put(translatedWord, (Integer) wordElement.getValue() + 1);
                    }
                }
            }
        }
        else {
            System.out.println("Word does not contain alphanumeric characters");
        }
    }

    public int countWords(String word) {
        if(validateString(word)) {
            String translatedWord = translator.translate(word);
            for (Map.Entry mapElement : wordsMap.entrySet()) {
                String key = (String) mapElement.getKey();
                if (key.equals(translatedWord)) {
                    return wordsMap.get(translatedWord).intValue();
                }
            }
         }
        else {
            System.out.println("Word does not contain alphanumeric characters");
        }
        return 0;
    }

    private boolean validateString(String str) {
      return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }

   public static void main (String args[]) {
        WordCounter wc = new WordCounter();
        wc.addWord("flower");
        wc.addWord("flor");
        wc.addWord("blume");
        wc.addWord("abcdef");
        wc.addWord("abcdefg");
        wc.addWord("abcdefgh");
        wc.addWord("abcdef");
        wc.addWord("abc1def");
        System.out.println(wc.countWords("flower"));
        System.out.println(wc.countWords("flor"));
        System.out.println(wc.countWords("blume"));
        System.out.println(wc.countWords("abcdefg"));
        System.out.println(wc.countWords("abcdefgh"));
        System.out.println(wc.countWords("abcdef"));
        System.out.println(wc.countWords("abc1def"));
    }
}




