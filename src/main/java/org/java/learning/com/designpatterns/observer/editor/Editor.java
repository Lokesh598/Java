package org.java.learning.com.designpatterns.observer.editor;

import org.java.learning.com.designpatterns.observer.publisher.EventManager;

import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("Open", "Save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("Open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null)
            events.notify("Save", file);
        else
            throw new Exception("Please open file first.");
    }
}
