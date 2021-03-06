package ba.unsa.etf.si.utility.javafx;

import ba.unsa.etf.si.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.util.Optional;

import static ba.unsa.etf.si.App.primaryStage;

public class NotificationUtils {

    private NotificationUtils() {
    }

    private static Notifications build(Pos pos, String title, String text, int duration) {
        return Notifications.create().position(pos).owner(primaryStage).title(title).text(text).hideCloseButton().hideAfter(Duration.seconds(duration));
    }

    private static Notifications build(Pos pos, String title, String text, int duration, EventHandler<ActionEvent> eventHandler) {
        return build(pos, title, text, duration).onAction(eventHandler);
    }

    public static Optional<ButtonType> showAlert(String title, String header, Alert.AlertType alertType, ButtonType... buttonTypes) {
        Alert alert = new Alert(alertType, "", buttonTypes);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.getDialogPane().getStylesheets().add(App.class.getResource("css/alert.css").toExternalForm());
        alert.getDialogPane().getStyleClass().add("dialog-pane");
        return alert.showAndWait();
    }

    public static void showInformation(Pos pos, String title, String text, int duration) {
        build(pos, title, text, duration).showInformation();
    }

    public static void showInformation(Pos pos, String title, String text, int duration, EventHandler<ActionEvent> eventHandler) {
        build(pos, title, text, duration, eventHandler).showInformation();
    }

}
