package onboarding;

import onboarding.problem4.NotWantedCharacter;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 1. 배열에 청개구리 사전 저장
        ArrayList<Character> upperDictionary = new ArrayList<>();
        ArrayList<Character> lowerDictionary = new ArrayList<>();


        for (int i = 0; i < 26; i++) {
            upperDictionary.add((char) ('Z'-i));
            lowerDictionary.add((char) ('z' - i));
        }

        //2.  주어진 word 청개구리 사전에 맞춰서 변환
        for (int i = 0; i < word.length(); i++) {

            char characterBeforeConversion = word.charAt(i);

            if(isUpperCase(characterBeforeConversion))
                answer += upperDictionary.get((int)(word.charAt(i)-'A'));
            else if(isLowerCase(characterBeforeConversion))
                answer+=lowerDictionary.get((int)(word.charAt(i)-'a'));
            else if(isBlank(characterBeforeConversion)){
                answer+=' ';
            }else{
                throw new NotWantedCharacter(characterBeforeConversion + "은 변환되지 않는 문자입니다.");
            }
        }

        return answer;
    }

    private static boolean isBlank(char characterBeforeConversion) {
        return characterBeforeConversion == ' ';
    }

    private static boolean isLowerCase(char characterBeforeConversion) {
        return Character.isLowerCase(characterBeforeConversion);
    }

    private static boolean isUpperCase(char characterBeforeConversion) {
        return Character.isUpperCase(characterBeforeConversion);
    }
}
