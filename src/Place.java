

public class Place {
    private int placeId;
    private String placeName;
    Transition nextNode;
    private int inRadius;
    private int outRadius;
    private int token;

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }


    public Place(int placeId, String placeName, int inRadius, int outRadius, int token) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.inRadius = inRadius;
        this.outRadius = outRadius;
        this.token = token;
    }

    public Place(int placeId, int token) {
        this.placeId = placeId;
        this.token = token;
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

    public Place(int placeId, String placeName) {
        this.placeId = placeId;
        this.placeName = placeName;
    }

    public Place(int placeId) {
        this.placeId = placeId;
    }

    public Place(String placeName) {
        this.placeName = placeName;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Transition getNextNode() {
        return nextNode;
    }

    public void setNextNode(Transition nextNode) {
        this.nextNode = nextNode;
    }
}
