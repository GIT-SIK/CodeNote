package programmers.LV1.S;
import java.util.Arrays;
import java.util.stream.*;

public class Stream4 {
    public static void main(String[] args) {
        Stream4 st7 = new Stream4();

        System.out.println(st7.solution("String Test Code"));
        System.out.println(st7.solution2("String Test Code"));
        System.out.println("\"" + st7.solution3("St r ing  Test Code  ") + "\"");

    }

    public String solution(String s) {
        /* 이상한 문자 만들기 */
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
         * 문자열을 읽어 영어 A을 인덱스 0, B를 인덱스 1 ...로 봤을때 짝수번째 인덱스는 대문자 그러지않으면 소문자로 바꾸고 출력하시오.
         * "AB DCF E" -> "Ab dCf E" / "ABCDEF" -> "AbCdEf"
         */
       return  (s.toUpperCase()).chars().mapToObj(c -> {
                if(c%2 == 0) {
                    return Character.toLowerCase((char) c);
                } else {
                    return (char) c;
                }
        }).map(Object::toString).collect(Collectors.joining());
    }

    public String solution2(String s) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * 문자열을 읽어 공백을 포함한 짝수번째 위치는 대문자, 홀수번째 위치는 소문자로 바꾼다. 0을 짝수로 본다.
        *  "ABCDEF" -> "AbCdEf" / "BG KER R" -> "Bg kEr r"
        */
        int[] count = {-1};
        return (s.toUpperCase()).chars().mapToObj(c -> {
            count[0]++;
            if(count[0]%2 != 0) {
                return Character.toLowerCase((char) c);
            }
            return (char) c;
        }).map(Object::toString).collect(Collectors.joining());
    }

    public String solution3(String s) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
         * 문자열을 읽어 공백을 기준으로 나누어 각각 문자열에 대해 짝수번째 위치는 대문자, 홀수번째 위치는 소문자로 바꾼다. 0을 짝수로 본다.
         *  "ABCDEF" -> "AbCdEf" / "BG KER R" -> "Bg KeR R"
         */
        int[] n = {-1};
        return Arrays.stream(s.toUpperCase().split(" ", -1)).map(t -> {
            n[0] = -1;
            return t.chars().mapToObj(c -> {
                n[0]++;
                if(n[0]%2 == 1) {
                    return Character.toLowerCase((char) c);
                }
                return (char) c;
            }).map(Object :: toString).collect(Collectors.joining());
        }).collect(Collectors.joining(" "));
    }
}
