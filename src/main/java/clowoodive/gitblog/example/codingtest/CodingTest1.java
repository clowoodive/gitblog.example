package clowoodive.gitblog.example.codingtest;

import java.util.Arrays;

// Codlility 마지막 문제는 SQL
public class CodingTest1 {

    // 주어진 숫자의 각 자릿수 합과 같은 다음 숫자 찾기( 입력: 37 = 10, 출력 : 각 자리수 합이 10인 다음으로 큰 숫자)
    public int solution(int N) {
        String inputStrVal = String.valueOf(N);
        String[] inputStrArray = inputStrVal.split("");
        var sumVal = Arrays.stream(inputStrArray).mapToInt(s -> Integer.parseInt(s)).sum();

        int checkVal = N + 1;
        while (checkVal < 50000) {
            String checkStrVal = String.valueOf(checkVal);
            String[] checkStrArray = checkStrVal.split("");
            var checkSumVal = Arrays.stream(checkStrArray).mapToInt(s -> Integer.parseInt(s)).sum();
            if (checkSumVal == sumVal)
                return checkVal;
            checkVal++;
        }

        return 0;
    }

    // 주석 처리된 두 줄을 추가해서 버그 수정
    public boolean solution2(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
//        int oneIdx = (int)Arrays.stream(A).filter(f -> f == 0).count();
//        if (A[oneIdx] != 1 && A[n - 1] != K)
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }
}
