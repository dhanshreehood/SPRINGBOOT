package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="complaint")
public class ComplaintBean {


		@Id
		@GeneratedValue
		private int complaintId;
		
		@Column
		private String complaintDiscription;
				
		@Column
		private String complaintStatus = "PENDING";
		
		@ManyToOne
		@JoinColumn(name="userComplaintId")
		private RegistrationBean userComplaint;		
		
		@ManyToOne
		@JoinColumn(name="eventNameId")
		private EventBean eventNameId;

		@ManyToOne
		@JoinColumn(name="eventOrganizerId")
		private RegistrationBean eventOrganizer;
		
		public RegistrationBean getUserComplaint() {
			return userComplaint;
		}

		public void setUserComplaint(RegistrationBean userComplaint) {
			this.userComplaint = userComplaint;
		}

		public EventBean getEventNameId() {
			return eventNameId;
		}

		public void setEventNameId(EventBean eventNameId) {
			this.eventNameId = eventNameId;
		}

		public int getComplaintId() {
			return complaintId;
		}

		public void setComplaintId(int complaintId) {
			this.complaintId = complaintId;
		}

		public String getComplaintDiscription() {
			return complaintDiscription;
		}

		public void setComplaintDiscription(String complaintDiscription) {
			this.complaintDiscription = complaintDiscription;
		}

		public String getComplaintStatus() {
			return complaintStatus;
		}

		public void setComplaintStatus(String complaintStatus) {
			this.complaintStatus = complaintStatus;
		}

		public RegistrationBean getEventOrganizer() {
			return eventOrganizer;
		}

		public void setEventOrganizer(RegistrationBean eventOrganizer) {
			this.eventOrganizer = eventOrganizer;
		}

		@Override
		public String toString() {
			return "ComplaintBean [complaintId=" + complaintId + ", complaintDiscription=" + complaintDiscription
					+ ", complaintStatus=" + complaintStatus + ", userComplaint=" + userComplaint + ", eventNameId="
					+ eventNameId + ", eventOrganizer=" + eventOrganizer + "]";
		}

		
}
