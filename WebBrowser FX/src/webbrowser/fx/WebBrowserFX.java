package webbrowser.fx;

import javafx.application.Platform;
import javax.swing.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class WebBrowserFX extends JFrame implements Runnable {

    /**
     * @param args the command line arguments
     */
    private JFXPanel panel;

    public void run() {
        setBounds(0, 0, 1950, 1050);
        setTitle("My Browser");
        setVisible(true);

        panel = new JFXPanel();
        add(panel);

        Platform.runLater(() -> {
            WebView view = new WebView();
            view.getEngine().load("http://www.google.com");

            panel.setScene(new Scene(view));
        });
    }

    public static void main(String[] args) {
        // TODO code application logic here

        SwingUtilities.invokeLater(new WebBrowserFX());
    }

}
