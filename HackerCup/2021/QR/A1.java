import java.io.*;
import java.util.*;
public class A1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t, result = 0;
    String s;
    t = Integer.parseInt(br.readLine());
    for(int i = 0; i < t; i++) {
      s = br.readLine();
      result = solve(s);
      System.out.printf("Case #%d: %d%n", i + 1, result);
    }
    br.close();
  }
  public static int solve(String s) {
    // The result is the max between the time we spend replacing vowels into consonants and viceversa
    int amountVowels, amountConsonants, maxRepeatedVowelFrequency, maxRepeatedConsonantFrequency, timeCase1, timeCase2;
    amountVowels = countVowels(s);
    amountConsonants = countConsonants(s);
    HashMap<String, Integer> letterCount = getLetterCount(s);
    ArrayList<Integer> amountSet = getSetCount(letterCount);
    // Case 1: Replacing Vowels into Consonants and Consonants into the Consonant that is most repeated
    maxRepeatedConsonantFrequency = getMaxRepeatedTypeConvenientLetterFrequency(letterCount, amountSet, false); 
    timeCase1 = amountVowels + 2 * (amountConsonants - maxRepeatedConsonantFrequency);
    // Case 2: Replacing Consonants into Vowels and Vowels into the Vowel that is most repeated
    maxRepeatedVowelFrequency = getMaxRepeatedTypeConvenientLetterFrequency(letterCount, amountSet, true);
    timeCase2 = amountConsonants + 2 * (amountVowels - maxRepeatedVowelFrequency);
    return Math.min(timeCase1, timeCase2);
  }
  public static int getMaxRepeatedTypeConvenientLetterFrequency(HashMap<String, Integer> letterCount, List<Integer> amountSet, boolean needVowel) {
    for(int i = amountSet.size() - 1; i >= 0; i--) {
      for(String l: letterCount.keySet()) {
        if(letterCount.get(l) == amountSet.get(i) && ((needVowel && isAVowel(l)) || (!needVowel && !isAVowel(l)))) {
          return letterCount.get(l);
        }
      }
    }
    return 0;
  }
  public static ArrayList<Integer> getSetCount(HashMap<String, Integer> letterCount) {
    ArrayList<Integer> amounts = new ArrayList<Integer>();
    for(String l: letterCount.keySet()) {
      amounts.add(letterCount.get(l));
    }
    ArrayList<Integer> amountSet = new ArrayList<Integer>();
    for(int amountItem: amounts) {
      if(!amountSet.contains(amountItem)) {
        amountSet.add(amountItem);
      }
    }
    return amountSet;
  }
  public static HashMap<String, Integer> getLetterCount(String s) {
    HashMap<String, Integer> letterCount = new HashMap<String, Integer>();
    String l;
    for(int i = 0; i < s.length(); i++) {
      l = s.substring(i, i + 1);
      if(!letterCount.containsKey(l)) {
        letterCount.put(l, 1);
      } else {
        letterCount.replace(l, letterCount.get(l) + 1);
      }
    }
    return letterCount;
  }
  public static int countConsonants(String s) {
    return s.length() - countVowels(s);
  }
  public static int countVowels(String s) {
    int counter = 0;
    for(int i = 0; i < s.length(); i++) {
      if(isAVowel(s.substring(i, i + 1))) {
        counter++;
      }
    }
    return counter;
  }
  public static boolean isAVowel(String s) {
    return s.toUpperCase().equals("A") || s.toUpperCase().equals("E") || s.toUpperCase().equals("I") || s.toUpperCase().equals("O") || s.toUpperCase().equals("U");
  }
}
