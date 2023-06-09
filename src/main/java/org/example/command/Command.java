package org.example.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.example.CalendarService;

import java.util.List;

public enum Command implements CommandI {
    CREATE_EVENT {
        @Override
        public void execute(String[] args) {
            try {
//                String str = "2016-09-12T13:15:17.309Z";
                String fromStr = args[1];
                String toStr = args[2];
                LocalDateTime from = LocalDateTime.parse(fromStr, DateTimeFormatter.ISO_DATE_TIME);
                LocalDateTime to = LocalDateTime.parse(toStr, DateTimeFormatter.ISO_DATE_TIME);
                List<Integer> userIds = new ArrayList<>();
                for (int i = 3; i < args.length; ++i) {
                    userIds.add(Integer.parseInt(args[i]));
                }
                CalendarService calendar = CalendarService.getCalendarService();
                Integer eventId = calendar.createEvent(userIds, from, to);
                System.out.println("Event Created " + eventId);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    },

    FAVOURABLE_SLOT {
        @Override
        public void execute(String[] args) {
            try {
//                String str = "2016-09-12T13:15:17.309Z";
                long durationInSecond = Long.parseLong(args[1]);
                List<Integer> userIds = new ArrayList<>();
                for (int i = 3; i < args.length; ++i) {
                    userIds.add(Integer.parseInt(args[i]));
                }
                CalendarService calendar = CalendarService.getCalendarService();
                LocalDateTime favourableTime = calendar.getSlot(userIds, durationInSecond);
                System.out.println("Slot Found " + favourableTime);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
