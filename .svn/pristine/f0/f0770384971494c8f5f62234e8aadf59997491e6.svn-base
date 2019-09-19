package com.planforme.jamot.planforme.control;

import com.planforme.jamot.planforme.entity.Event;

import java.util.List;

/**
 * Will be able to edit, delete, duplicate, and change the order of events in the list
 */
public class ManageEvent {
    private List<Event> eventList;

    public ManageEvent(List<Event> list) {
        eventList = list;
    }

    /**
     * Deletes item from the list
     *
     * @param toDelete the event to be deleted
     * @return weather item was deleted or not
     */
    public boolean deleteEvent(Event toDelete) {
        return eventList.remove(toDelete);
    }

    /**
     * duplicates event at index and adds it to the next index
     *
     * @param index
     */
    public boolean duplicateEvent(int index) {
        Event event = eventList.get(index);
        Event clonedEvent = event.clone();

        eventList.add(index + 1, clonedEvent);
        return eventList.contains(clonedEvent);
    }

    /**
     * Will duplicate event in list
     *
     * @param event event to duplicate
     * @return weather the event could be cloned
     */
    public boolean duplicateEvent(Event event) {
        if (!eventList.contains(event))
            return false;

        Event clonedEvent = event.clone();

        eventList.add(eventList.indexOf(event) + 1, clonedEvent);
        return eventList.contains(clonedEvent);
    }

    /**
     * Moves the event to the new index
     *
     * @param event event to move
     * @param index index to move to
     * @return returns if event was successfully moved
     */
    public boolean changeEventIndex(Event event, int index) {
        if (!eventList.contains(event))
            return false;
        if (index < 0 || index > eventList.size())
            return false;

        //This is required so the object from the list is retrieved to they will have the same ID
        //If just using the one passed in then you may end up with a different eventID
        Event eventFromList = eventList.get(eventList.indexOf(event));

        eventList.remove(eventFromList);
        eventList.add(index, eventFromList);
        return eventList.contains(eventFromList);
    }
}
