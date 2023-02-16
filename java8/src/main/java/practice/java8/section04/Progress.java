package practice.java8.section04;

import java.time.Duration;

public class Progress {
    private Duration studyDuration; // 학습 기간
    private boolean finished; // 수료 여부
    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
