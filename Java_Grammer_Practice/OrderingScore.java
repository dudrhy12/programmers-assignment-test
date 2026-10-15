import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = List.of("kim", "lee", "park");
        List<Integer> scores = List.of(85, 95, 75);

        List<String> result = sortScores(names, scores);

        System.out.println(result);
    }

    public static List<String> sortScores(
            List<String> names,
            List<Integer> scores) {

        List<String> result = new ArrayList<>();
        List<String> sortedNames = new ArrayList<>(names);
        List<Integer> sortedScores = new ArrayList<>(scores);

        for (int i = 0; i < sortedScores.size(); i++) {
            for (int j = 0; j < sortedScores.size() - 1; j++) {

                if (sortedScores.get(j) < sortedScores.get(j + 1)) {

                    // 점수 위치 바꾸기
                    int tempScore = sortedScores.get(j);
                    sortedScores.set(j, sortedScores.get(j + 1));
                    sortedScores.set(j + 1, tempScore);

                    // 이름 위치도 바꾸기
                    String tempName = sortedNames.get(j);
                    sortedNames.set(j, sortedNames.get(j + 1));
                    sortedNames.set(j + 1, tempName);
                }
            }
        }

        for (int i = 0; i < sortedNames.size(); i++) {
            result.add(
                    sortedNames.get(i) + ":" + sortedScores.get(i)
            );
        }

        return result;
    }
}