package ExamPreparationSecond_2023;

import java.util.*;
import java.util.function.Function;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        ArrayDeque<Character> consonants = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(s->s.charAt(0))
                .forEach(vowels::offer);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(s->s.charAt(0))
                .forEach(consonants::push);

        Map<String,List<Character>> wordsMap = new LinkedHashMap<>();
        addingToMap("pear",wordsMap);
        addingToMap("flour",wordsMap);
        addingToMap("pork",wordsMap);
        addingToMap("olive",wordsMap);

        while (!vowels.isEmpty() && !consonants.isEmpty()){
            char vowel = vowels.poll();
            char consonant = consonants.pop();
            checkMapWords(vowel,consonant,wordsMap);

            vowels.offer(vowel);
        }
        System.out.println("Words found: " + calculatingWordsCount(wordsMap));
        wordsMap.forEach((key, value) -> {
            if (value.size() == 0) {
                System.out.println(key);
            }
        });
    }

    private static int calculatingWordsCount(Map<String, List<Character>> wordsMap) {
        int count = 0;
        for (Map.Entry<String, List<Character>> word : wordsMap.entrySet()) {
            if(word.getValue().size()==0){
                count++;
            }
        }
        return count;
    }

    private static void checkMapWords(char vowel, char consonant, Map<String, List<Character>> wordsMap) {
        for (Map.Entry<String, List<Character>> word : wordsMap.entrySet()) {
            for (int index = 0; index < word.getValue().size(); index++) {
                if(word.getValue().get(index)==vowel){
                    word.getValue().remove(word.getValue().get(index));
                    index--;
                }else if(word.getValue().get(index)==consonant){
                    word.getValue().remove(word.getValue().get(index));
                    index--;
                }
            }
        }
    }

    private static void addingToMap(String word,Map<String, List<Character>> wordsMap){
        wordsMap.put(word,new ArrayList<>());
        Function<String,List<Character>> wordAsCharList = input->{
            List<Character> characterList = new ArrayList<>();
            for (char symbol : input.toCharArray()) {
                characterList.add(symbol);
            }
            return characterList;
        };
        wordsMap.get(word).addAll(wordAsCharList.apply(word));
    }
}
