package Validate;

import java.util.*;

public class PolishIDValidator implements Validator {

    private static final Map<Character,Integer> LETTER_TO_VALUE;
    private static final String ID_REGEX = "[A-Z]{3}\\d{6}";


    static{
        Hashtable<Character,Integer> tmp = new Hashtable<>();
        tmp.put('A', 10);
        tmp.put('B', 11);
        tmp.put('C', 12);
        tmp.put('D', 13);
        tmp.put('E', 14);
        tmp.put('F', 15);
        tmp.put('G', 16);
        tmp.put('H', 17);
        tmp.put('I', 18);
        tmp.put('J', 19);
        tmp.put('K', 20);
        tmp.put('L', 21);
        tmp.put('M', 22);
        tmp.put('N', 23);
        tmp.put('O', 24);
        tmp.put('P', 25);
        tmp.put('Q', 26);
        tmp.put('R', 27);
        tmp.put('S', 28);
        tmp.put('T', 29);
        tmp.put('U', 30);
        tmp.put('V', 31);
        tmp.put('W', 32);
        tmp.put('X', 33);
        tmp.put('Y', 34);
        tmp.put('Z', 35);
        tmp.put('0', 0);
        tmp.put('1', 1);
        tmp.put('2', 2);
        tmp.put('3', 3);
        tmp.put('4', 4);
        tmp.put('5', 5);
        tmp.put('6', 6);
        tmp.put('7', 7);
        tmp.put('8', 8);
        tmp.put('9', 9);

        LETTER_TO_VALUE = Collections.unmodifiableMap(tmp);
    }

    private static final Integer[] WEIGHTS = {7, 3, 1, 9, 7, 3, 1, 7, 3};

    @Override
    public Boolean validate(String id) {
        if(!id.matches(ID_REGEX)) {
            return false;
        }
        List<Integer> intValues = new ArrayList<>();


        int total = 0;

        for (int i =0; i< id.length(); i++){
            total += LETTER_TO_VALUE.get(id.charAt(i))* WEIGHTS[i];
        }

//        for(char c:id.toCharArray()) {
//            intValues.add(LETTER_TO_VALUE.get(c));
//        }
//
//        int total = 0;
//
//        for (int i =0; i< WEIGHTS.length; i++){
//            total += WEIGHTS[i]* intValues.get(i);
//        }
        return total% 10 == 0;
    }
}