package HW_4_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {
    @FXML
    public TextArea inputArea;

    @FXML
    public WebView browser = new WebView();

    @FXML
    private ColorPicker pickerMakeColor;

    @FXML
    public MenuItem buttonClose;

    private static StringBuffer html = new StringBuffer();

    private static Settings settings = new Settings();

    public Controller() {
        MainClass.param.loadFromXml();
    }

    private void ShowMessage(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private static ArrayList<String> messages = new ArrayList<String>();

    private void showInBrowser() {
        browser.getEngine().setUserStyleSheetLocation(getClass().getResource("style.css").toString());
        html.delete(0, html.length())
                .append("<!DOCTYPE html>")
                .append("<html lang=\"ru\">")
                .append("<head>")
                .append("<meta charset=\"UTF-8\">")
                .append("</head>")
                .append("<body>");
        for (String line : messages) {
            html.append("<p>")
                    .append(line)
                    .append("</p>");
        }
        html.append("</body>");
        browser.getEngine().loadContent(html.toString());
        browser.getEngine().reload();
    }

    private void getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        stringBuilder.append("<font color=\"grey\">[" + calendar.getTime().toString() + "]</font>&nbsp;")
                .append("<font color=\"blue\">[" + MainClass.param.getUserName() + "]</font>&nbsp;::&nbsp;")
                .append(inputArea.getText());
        messages.add(stringBuilder.toString());
    }

    private void sendMessage() {
        getMessage();
        showInBrowser();
        // todo Send to network
        /**
         * ...code...
         *
         * */
        //
        inputArea.clear();
    }

    public void onButtonSendMessageClick(ActionEvent actionEvent) {
        sendMessage();
    }

    public void onCtrlEnterSendMessage(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.getCode().equals(KeyCode.ENTER)) sendMessage();
        if (keyEvent.getCode().equals(KeyCode.ENTER)) sendMessage();
    }

    private String teggingText(String teg, TextArea a, String color) {
        StringBuilder str = new StringBuilder();
        str.append(a.getText().substring(0, a.getSelection().getStart()));
        if (teg == "font") {
            str.append("<" + teg + " color=" + color + ">");
        } else {
            str.append("<" + teg + ">");
        }
        str.append(a.getText().substring(a.getSelection().getStart(), a.getSelection().getEnd()))
                .append("</" + teg + ">")
                .append(a.getText().substring(a.getSelection().getEnd(), a.getLength()));
        return str.toString();
    }

    public void onMakeTextBold(ActionEvent actionEvent) {
        inputArea.setText(teggingText("b", inputArea, null));
    }

    public void onMakeTextItalic(ActionEvent actionEvent) {
        inputArea.setText(teggingText("i", inputArea, null));
    }

    public void onMakeTextUnderline(ActionEvent actionEvent) {
        inputArea.setText(teggingText("u", inputArea, null));
    }

    public void onMakeTextColor(ActionEvent actionEvent) {
        String color = "#" + pickerMakeColor.getValue().toString().substring(2, 8);
        inputArea.setText(teggingText("font", inputArea, color));
    }

    public void onButtonSaveAs(ActionEvent actionEvent) {
        FileChooser saver = new FileChooser();
        saver.setTitle("Save file as...");
        saver.setInitialFileName("history.html");
        File file = saver.showSaveDialog(MainClass.mainStage);
        if (file != null) {
            try {
                FileWriter out = new FileWriter(file);
                out.write(html.toString());
                out.close();
                ShowMessage("Information", "", "Upload unloaded.");
            } catch (IOException ex) {
                ShowMessage("Information", "IOException", ex.toString());
            }
        }
    }

    public void onButtonSettings(ActionEvent actionEvent) {
        settings.show();
    }

    public void onClose(){
        System.exit(0);
    }
}
