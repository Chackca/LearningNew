package 设计模式.大话设计模式.observer;

/**
 * 具体主题或通知者
 * 
 * @author Chackca
 *
 */
public class ConcreteSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
	return subjectState;
    }

    public void setSubjectState(String subjectState) {
	this.subjectState = subjectState;
    }
}
