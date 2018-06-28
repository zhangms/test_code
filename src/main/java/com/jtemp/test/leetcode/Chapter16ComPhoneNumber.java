package com.jtemp.test.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * <pre>
 *
 *     1(*)     2(abc)     3(def)
 *     4(ghi)   5(jkl)     5(mno)
 *     7(pqrs)  8(tuv)     9(wxyz)
 *              0(&)
 *
 * </pre>
 */
public class Chapter16ComPhoneNumber {

    public static Map<Integer, Character[]> digitMapping = new HashMap<>();

    public static void main(String[] args) {
        initDigitMapping();
        int digit = 23;
        List<String> ret = comb(digit);
        System.out.println(ret);
    }

    private static void initDigitMapping() {
        digitMapping.put(0, new Character[]{'&'});
        digitMapping.put(1, new Character[]{'*'});
        digitMapping.put(2, new Character[]{'a', 'b', 'c'});
        digitMapping.put(3, new Character[]{'d', 'e', 'f'});
        digitMapping.put(4, new Character[]{'g', 'h', 'i'});
        digitMapping.put(5, new Character[]{'j', 'k', 'l'});
        digitMapping.put(6, new Character[]{'m', 'n', 'o'});
        digitMapping.put(7, new Character[]{'p', 'q', 'r', 's'});
        digitMapping.put(8, new Character[]{'t', 'u', 'v'});
        digitMapping.put(9, new Character[]{'w', 'x', 'y', 'z'});
    }

    private static List<String> comb(int digit) {
        if (digit == 0) {
            return Stream.of(digitMapping.get(digit)).map(Object::toString).collect(Collectors.toList());
        }
        List<String> ret = new ArrayList<>();
        while (digit != 0) {
            int mod = digit % 10;
            digit = digit / 10;
            Character[] chars = digitMapping.get(mod);
            if (ret.isEmpty()) {
                ret.addAll(Stream.of(chars).map(Object::toString).collect(Collectors.toList()));
                continue;
            }
            Object[] array = ret.toArray();
            ret.clear();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    ret.add(chars[j] + "" + array[i]);
                }
            }
        }
        return ret;
    }

}
