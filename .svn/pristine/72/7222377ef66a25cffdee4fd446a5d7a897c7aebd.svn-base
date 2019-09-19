package com.planforme.jamot.planforme.entity;

import java.io.Serializable;
import org.threeten.bp.LocalTime;

public class Routine implements Serializable {

	private boolean daysAffected[] = new boolean[7]; //TODO: implement getter and setter
	private LocalTime timeStart;
	private LocalTime timeEnd;
	private String routineName;

	public LocalTime getTimeStart() {
		return this.timeStart;
	}

	public Routine(String routineName, boolean[] daysAffected, LocalTime timeStart, LocalTime timeEnd){
		this.routineName = routineName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		for (int i =0; i<daysAffected.length; i++) {
			this.daysAffected[i] = daysAffected[i];
		}
	}

	/**
	 * 
	 * @param timeStart
	 */
	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}

	public LocalTime getTimeEnd() {
		return this.timeEnd;
	}

	/**
	 * 
	 * @param timeEnd
	 */
	public void setTimeEnd(LocalTime timeEnd) {
		this.timeEnd = timeEnd;
	}


	/**
	 * 
	 * @param routineName
	 */
	public void setRoutineName(String routineName) {
		this.routineName = routineName;
	}

	public String getRoutineName() {
		return routineName;
	}
}