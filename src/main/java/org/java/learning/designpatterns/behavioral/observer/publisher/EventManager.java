package org.java.learning.designpatterns.behavioral.observer.publisher;

import org.java.learning.designpatterns.behavioral.observer.listeners.EventListener;

import java.io.File;
import java.util.*;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation: operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(eventListener);
    }

    public void unsubscribe(String eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(eventListener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener: users) {
            listener.update(eventType, file);
        }
    }
}
