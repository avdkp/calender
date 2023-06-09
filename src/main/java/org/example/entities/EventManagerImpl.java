package org.example.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventManagerImpl implements EventManager {

    //TODO remove this
    Map<User, Event> allEvents = new HashMap<>();
    private static int nextId = 0;

    public int createEvent(List<User> users, LocalDateTime from, LocalDateTime to) {
        Event event = new Event(nextId++, from, to, users);
        for(User user:users) {
            user.addEvent(event);
            this.allEvents.put(user, event);
        }
        return event.getId();
    }
}
