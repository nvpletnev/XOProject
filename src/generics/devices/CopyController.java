package generics.devices;

/**
 * Created by nikolaypletnev on 14.06.18.
 */
public class CopyController {

    public static <T extends IPrinter & IScanner>void copy(T device) {
        device.print(device.scan());
    }

}
