package generics;

/**
 * Created by nikolaypletnev on 11.06.18.
 */
public class Woman implements Human {
    private final String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public Sex getSex() {
        return Sex.F;
    }

    @Override
    public String getName() {
        return name;
    }
}
