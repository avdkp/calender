package org.example;

import org.example.entities.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarService {
    private static CalendarService calendarService;
    EventManager eventManager;
    UserManager userManager;

    private CalendarService() {
        // later these can be injected though constructor
        eventManager = new EventManagerImpl();
        userManager =  new UserManagerImpl();
    }

    public static CalendarService getCalendarService() {
        if(calendarService == null) {
            calendarService = new CalendarService();
        }
        return calendarService;
    }

    public int createEvent(List<Integer> userIds, LocalDateTime from, LocalDateTime to) {
        List<User> users = userIds.stream().map(userManager::getUser).collect(Collectors.toList());
        return eventManager.createEvent(users, from, to);
    }

    private LocalDateTime findFirstUnsuitableUser(List<User> users, LocalDateTime time, long duration) {
        boolean suitable = true;

        for(User user:users) {
            Event e = user.findLower(time, duration);
            if(e != null) {
                return e.getTo().plusSeconds(1);
            }
        }
        return null;
    }
    public LocalDateTime getSlot(List<Integer> userIds, long durationInSecond) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime newTime = LocalDateTime.now();
        List<User> users = userIds.stream().map(userManager::getUser).collect(Collectors.toList());
        while(newTime != null) {
            currentTime = newTime;
            newTime = findFirstUnsuitableUser(users, currentTime, durationInSecond);
        }
        return currentTime;
    }
}
