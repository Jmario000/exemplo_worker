package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	// atributos básicos
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	// associações/composição de objetos
	private Department department;
	// não colocar a lista no construtor,declarar o objeto como lista vazia
	private List<HourContract> contracts = new ArrayList<HourContract>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public WorkerLevel getLevel() {
		return this.level;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Double getBaseSalary() {
		return this.baseSalary;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return this.department;
	}

	/*
	 * não é preciso o set para a lista, pois há métodos especifícos para tratar a
	 * lista public void setContracts(List<HourContract> contracts) { this.contracts
	 * = contracts; }
	 */

	public List<HourContract> getContracts() {
		return this.contracts;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}

	// soma do salário base + os valores dos contratos
	/*public Double income(Integer year, Integer month) {
		double sum = getBaseSalary();
		for (HourContract c : this.contracts) {
			if (c.getDate().getYear() == year && c.getDate().getMonth()+1 == month) { 
				sum += c.totalValue();
			}
		}
		return sum;
	}*/

	public Double income(Integer year, Integer month) {
		double sum = getBaseSalary();
		Calendar cal = Calendar.getInstance();
		for (HourContract c : this.contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (c_year == year && c_month == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

}
