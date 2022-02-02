package examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ExamService {

    private Map<String, ExamResult> results = new TreeMap<>();
    private int theoryMax;
    private int practiceMax;
    private static final int LIMIT_PERCENT = 51;

    public void readFromFIle(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            parseMax(br.readLine());
            while ((line = br.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void parseMax(String line) {
        String[] temp = line.split(" ");
        theoryMax = Integer.parseInt(temp[0]);
        practiceMax = Integer.parseInt(temp[1]);
    }

    private void parseLine(String line) {
        String[] temp = line.split(";");
        String[] exams = temp[1].split(" ");

        results.put(temp[0], new ExamResult(Integer.parseInt(exams[0]), Integer.parseInt(exams[1])));


    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public Map<String, ExamResult> getResults() {
        return results;
    }

    public List<String> findPeopleFailed() {
        return results.entrySet().stream()
                .filter(f -> f.getValue().getTheory() < getTheoryMax() * LIMIT_PERCENT * .01
                        || f.getValue().getPractice() < getPracticeMax() * LIMIT_PERCENT * .01)
                .map(m -> m.getKey()).toList();
    }

    public String findBestPerson() {

        StringBuilder sb = new StringBuilder();

        int maxPoints = 0;
        // results.entrySet().forEach(entry ->
        for (Map.Entry<String, ExamResult> entry : results.entrySet()) {
            if (isLimited(entry.getValue())) {
                if (maxPoints < entry.getValue().getTheory() + entry.getValue().getPractice()) {
                    sb = new StringBuilder();
                    sb.append(entry.getKey());
                } else if (maxPoints == entry.getValue().getTheory() + entry.getValue().getPractice()) {
                    maxPoints = entry.getValue().getTheory() + entry.getValue().getPractice();
                }
            }
        }
        ;

        return sb.toString();
    }

    private boolean isLimited(ExamResult r) {
        return r.getTheory() >= getTheoryMax() * LIMIT_PERCENT * .01
                && r.getPractice() >= getPracticeMax() * LIMIT_PERCENT * .01;
    }
}
