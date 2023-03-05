package studentmangementsystem;

public enum Gender {
    Male, Female;

    @Override
    public String toString() {
        return switch (this) {
            case Male ->
                "Male";
            case Female ->
                "Female";
            default ->
                "Unknown";
        };
    }

}
