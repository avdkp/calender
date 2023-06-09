package org.example.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class User {
    Integer id;
    Set<Event> allEvents = new TreeSet<>();

    public User(Integer id) {
        this.id = id;
    }

    public void addEvent(Event event) {
        allEvents.add(event);
    }

    public Event findLower(LocalDateTime localDateTime, long durationInSecond) {
        for(Event event:allEvents) {
            if(event.from.compareTo(localDateTime)<=0 && localDateTime.plusSeconds(durationInSecond).isAfter(event.to)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
