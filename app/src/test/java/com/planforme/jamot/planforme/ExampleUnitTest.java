package com.planforme.jamot.planforme;

import com.planforme.jamot.planforme.control.ManageEvent;
import com.planforme.jamot.planforme.entity.Event;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void eventEqualsMethod() {
        Event testEvent = new Event("test", 333);
        Event testEvent2 = new Event("test", 333);

        assertEquals(testEvent, testEvent2);

        //should not be equal now
        testEvent.setEventName("eventNameHere");
        assertEquals(false, testEvent.equals(testEvent2));
    }

    /**
     * tests if deep cloning an Event object works
     */
    @Test
    public void cloneEventObject() {
        Event event = new Event("test", 10, 11, 12);
        Event eventClone = event.clone();

        event.setEventName("This have been a test");
        event.setDurationHrs(5);
        event.setLongitude(6);
        event.setLatitude(7);

        //original object is updated
        assertEquals(event.getEventName(), "This have been a test");
        assertEquals(event.getDurationHrs(), 5, 0.01);
        assertEquals(event.getLongitude(), 6, 0.01);
        assertEquals(event.getLatitude(), 7, 0.01);

        //cloned object same values as original object
        assertEquals(eventClone.getEventName(), "test");
        assertEquals(eventClone.getDurationHrs(), 10, 0.01);
        assertEquals(eventClone.getLongitude(), 11, 0.01);
        assertEquals(eventClone.getLatitude(), 12, 0.01);

    }

    /**
     * makes sure that clones events have different ID's
     */
    @Test
    public void clonedEventID() {
        Event event = new Event("test", 10, 11, 12);
        Event eventClone = event.clone();

        assertEquals(false, event.getEventID() == eventClone.getEventID());
    }

    @Test
    public void duplicateEventByIndex() {
        List<Event> eventList = new ArrayList<>();
        ManageEvent me = new ManageEvent(eventList);
        Event testEvent = new Event("test", 333);

        eventList.add(new Event("first", 1));
        eventList.add(new Event("second", 2));
        eventList.add(testEvent);

        me.duplicateEvent(eventList.size() - 1);

        assertEquals(testEvent, eventList.get(eventList.size() - 1));
        assertEquals(testEvent, eventList.get(eventList.size() - 2));
    }

    @Test
    public void duplicateEventByObject() {
        List<Event> eventList = new ArrayList<>();
        ManageEvent me = new ManageEvent(eventList);
        Event testEvent = new Event("test", 333);

        eventList.add(new Event("first", 1));
        eventList.add(new Event("second", 2));
        eventList.add(testEvent);

        me.duplicateEvent(testEvent);

        assertEquals(testEvent, eventList.get(eventList.size() - 1));
        assertEquals(testEvent, eventList.get(eventList.size() - 2));
    }

    @Test
    public void deleteEvent() {
        List<Event> eventList = new ArrayList<>();
        ManageEvent me = new ManageEvent(eventList);
        Event testEvent = new Event("test", 1);
        Event testEvent2 = new Event("test2", 22);
        Event testEvent3 = new Event("test3", 333);

        eventList.add(testEvent);
        eventList.add(testEvent2);
        eventList.add(testEvent3);

        assertEquals(eventList.size(), 3);

        me.deleteEvent(testEvent);
        me.deleteEvent(testEvent3);

        assertEquals(1, eventList.size());
        assertEquals(true, eventList.contains(testEvent2));
    }

    @Test
    public void changeIndexOfEvent() {
        List<Event> eventList = new ArrayList<>();
        ManageEvent me = new ManageEvent(eventList);
        Event testEvent = new Event("test", 1);
        Event testEvent2 = new Event("test2", 22);
        Event testEvent3 = new Event("test3", 333);

        eventList.add(testEvent);
        eventList.add(testEvent2);
        eventList.add(testEvent3);

        //move the first one to the last position
        me.changeEventIndex(testEvent, eventList.size() - 1);
        assertEquals(testEvent, eventList.get(eventList.size() - 1));
    }

    @Test
    public void changeIndexOfClonedEvent() {
        List<Event> eventList = new ArrayList<>();
        ManageEvent me = new ManageEvent(eventList);
        Event testEvent = new Event("test", 1);
        Event testEventClone = testEvent.clone();
        Event testEvent2 = new Event("test2", 22);
        Event testEvent3 = new Event("test3", 333);

        eventList.add(testEvent);
        eventList.add(testEvent2);
        eventList.add(testEvent3);

        //move the first one to the last position
        me.changeEventIndex(testEventClone, eventList.size() - 1);
        assertEquals(testEvent, eventList.get(eventList.size() - 1));
    }
}