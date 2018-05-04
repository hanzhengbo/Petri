

public class Transition {
    private int transitionId;
    private String transitionName;
    private int inRadius;
    private int outRadius;
    Place nextNode;


    public Transition(int transitionId, String transitionName, int inRadius, int outRadius) {
        this.transitionId = transitionId;
        this.transitionName = transitionName;
        this.inRadius = inRadius;
        this.outRadius = outRadius;
    }

    public int getInRadius() {
        return inRadius;
    }

    public void setInRadius(int inRadius) {
        this.inRadius = inRadius;
    }

    public int getOutRadius() {
        return outRadius;
    }

    public void setOutRadius(int outRadius) {
        this.outRadius = outRadius;
    }

    public Transition(int transitionId, String transitionName) {
        this.transitionId = transitionId;
        this.transitionName = transitionName;
    }

    public Transition(int transitionId) {
        this.transitionId = transitionId;
    }

    public Transition(String transitionName) {
        this.transitionName = transitionName;
    }

    public int getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(int transitionId) {
        this.transitionId = transitionId;
    }

    public String getTransitionName() {
        return transitionName;
    }

    public void setTransitionName(String transitionName) {
        this.transitionName = transitionName;
    }

    public Place getNextNode() {
        return nextNode;
    }

    public void setNextNode(Place nextNode) {
        this.nextNode = nextNode;
    }
}
