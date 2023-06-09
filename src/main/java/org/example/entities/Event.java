package org.example.entities;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Event implements Comparable {
    Integer id;
    LocalDateTime from, to;
    Set<User> user;

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public Event(Integer id, LocalDateTime from, LocalDateTime to, List<User> users) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.user = new HashSet<>(users);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        Event other = (Event) o;
        return this.from.compareTo(other.from);
    }
}
