package com.planforme.jamot.planforme.entity;

import org.threeten.bp.LocalTime;

import java.io.Serializable;

public class TravelEvent extends ScheduleEvent implements Serializable {

	private LocalTime timeStart;

	public LocalTime getTimeStart() {
		return this.timeStart;
	}

	/**
	 * 
	 * @param timeStart
	 */
	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}


}