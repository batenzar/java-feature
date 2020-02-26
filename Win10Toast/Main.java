import java.awt.*;
import java.awt.TrayIcon.MessageType;

/**
 * Sample Code for displaying notification on Windows 10.
 * 
 * We cannot display notification directly. To display notification, We have to
 * create icon on Taskbar first. Then, use taskbar icon to display notification.
 */
public class Main {

    public static void main(String[] args) throws AWTException {
        if (SystemTray.isSupported()) {
            Main td = new Main();
            td.displayTray("Hello, World", "notification demo");
            // Need this line to end process after display notification
            // Why?
            System.exit(0);

        } else {
            System.err.println("System tray not supported!");
        }

    }

    public void displayTray(String title, String message) throws AWTException {
        // Get an icon as Image for tray icon.
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        // For icon on the classpath:
        // Image image =
        // Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon tooltip");

        // Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();
        tray.add(trayIcon);

        // Display the notification as Info
        trayIcon.displayMessage(title, message, MessageType.INFO);

    }
}
