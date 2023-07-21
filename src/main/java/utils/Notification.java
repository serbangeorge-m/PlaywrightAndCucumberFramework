package utils;

public enum Notification {
    Email("E-pasts"),
    Mail("Pasts");

    private final String stringValue;

    // Constructor to set the string value for each enum constant
    private Notification(String stringValue) {
        this.stringValue = stringValue;
    }

    // Getter method to access the string value of the enum constant
    public String getStringValue() {
        return stringValue;
    }
}
