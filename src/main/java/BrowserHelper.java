import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class BrowserHelper {

    public static void openURL(String url) {
        try {
            Desktop.getDesktop().browse(URI.create(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
