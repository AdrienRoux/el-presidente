package World;

public enum Season {
    SPRING ("Printemps"),
    SUMMER ("Ete"),
    AUTUMN ("Automne"),
    WINTER ("Hiver");

    private final String name;

    Season(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
