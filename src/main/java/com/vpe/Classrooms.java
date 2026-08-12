package com.vpe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/

public class Classrooms {

    public Classrooms() {}

    public int getRoomsCount(List<List<Integer>> schedules) {
        if (schedules.isEmpty()) {
            return 0;
        }

        var sorted = new ArrayList<>(schedules);
        sorted.sort(Comparator.comparingInt(s -> s.get(0)));

        var roomEndTimes = new PriorityQueue<Integer>();

        for (var schedule : sorted) {
            int start = schedule.get(0);
            int end = schedule.get(1);

            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= start) {
                roomEndTimes.poll();
            }

            roomEndTimes.offer(end);
        }

        return roomEndTimes.size();
    }
}