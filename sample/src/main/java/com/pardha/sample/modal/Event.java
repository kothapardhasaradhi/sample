/**
 * 
 */
package com.pardha.sample.modal;

import java.util.Date;
import java.util.Set;

/**
 * @author PA391763
 *
 */
public class Event {
	
	private int id;
	private String name;
	private Date startDate;
	private Location location;
	private Set<Speakar> speakarsList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Set<Speakar> getSpeakarsList() {
		return speakarsList;
	}
	public void setSpeakarsList(Set<Speakar> speakarsList) {
		this.speakarsList = speakarsList;
	}
	
	
	
	

}
