package practice.java8.section04;

public class OnlineClass {
    private Integer id;
    private String title;
    private final boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public Progress getProgress() {
        // progress가 null인 경우 처리 방법 1. 예외를 던진다 -> 스택트레이스를 찍어두기 때문에 비쌈
//        if (this.progress == null) {
//            throw new IllegalArgumentException();
//        }
        return progress; // progress가 null인 경우 처리 방법 2. null을 리턴한다. -> 클라이언트 코드에서 사용 시 주의해야 함
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
