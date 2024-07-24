package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		try {
			Department department = new Department(JOptionPane.showInputDialog("Enter deparment's name:"));
			JOptionPane.showMessageDialog(null, "Enter worker's data:");
			String workerName = JOptionPane.showInputDialog("Name:");
			WorkerLevel level = WorkerLevel.valueOf(JOptionPane.showInputDialog("Level:"));
			double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Base salary:"));
			Worker worker = new Worker(workerName, level, baseSalary, department);

			int qntdContracts = Integer.parseInt(JOptionPane.showInputDialog("How many contracts to this worker"));

			for (int i = 0; i < qntdContracts; i++) {
				JOptionPane.showMessageDialog(null, "Enter contract #" + (i + 1) + " data:");
				Date date = sdf1.parse(JOptionPane.showInputDialog("Date (DD/MM/YYYY)"));
				double valuePerHour = Double.parseDouble(JOptionPane.showInputDialog("Value per hour:"));
				int duration = Integer.parseInt(JOptionPane.showInputDialog("Duration (hours):"));

				HourContract contract = new HourContract(date, valuePerHour, duration);
				worker.addContract(contract);
			}
			Date date2 = sdf2.parse(JOptionPane.showInputDialog("Enter month and year to calculate income (MM/YYYY)"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);
			JOptionPane.showMessageDialog(null, "Name: " + worker.getName() + "\nDepartment: "
					+ worker.getDepartment().getName() + "\nIncome for " + sdf2.format(date2) + ": $"
					+ String.format("%.2f", worker.income(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1)));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

}
