package org.java.learning.designpatterns.behavioral.observer;

import org.java.learning.designpatterns.behavioral.observer.editor.Editor;
import org.java.learning.designpatterns.behavioral.observer.listeners.EmailNotificationListener;
import org.java.learning.designpatterns.behavioral.observer.listeners.LogOpenListener;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("Open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("Save", new EmailNotificationListener("lokesh@gmail.com"));
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
