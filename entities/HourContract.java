package entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double valuePerHour;
	private Integer hours;

	public HourContract() {
	}

	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Double getValuePerHour() {
		return this.valuePerHour;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getHours() {
		return this.hours;
	}

	public double totalValue() {
		return getValuePerHour() * getHours();
	}
}
