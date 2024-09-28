package org.java.learning.com.designpatterns.observer.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
