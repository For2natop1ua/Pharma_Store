package factory;

public enum DriverType {
    CHROME("CHROME"),
    FIREFOX("FIREFOX"),
    IE("IE");

    private final String type;

    DriverType(String type) {
        this.type = type;
    }

    public static DriverType fromValue(String value) {
        return DriverType.valueOf(value);
    }

}
