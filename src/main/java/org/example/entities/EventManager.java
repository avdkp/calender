package org.example.entities;

import java.time.LocalDateTime;
import java.util.List;

public interface EventManager {
    int createEvent(List<User> users, LocalDateTime from, LocalDateTime to);
}
