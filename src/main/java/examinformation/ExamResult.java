package examinformation;

public class ExamResult {

    public int theory;
    public int practice;

    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }

    public int getTheory() {
        return theory;
    }

    public int getPractice() {
        return practice;
    }
}
