package edu.pdx.ekbotecetolafinalpi.account;

/**
 * A simple set of data for the user. This data is easily saved to the realtime database.
 */
public class CurrentUser {
    public static final String COLLECTION = CurrentUser.class.getSimpleName();
    public static final String USER_ID = "userId";
    public static final String FINGER_ID = "fingerId";
    int fingerId;
    String userId;

    public int getFingerId() {
        return fingerId;
    }

    public void setFingerId(int fingerId) {
        this.fingerId = fingerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
