package viewImpl.ManageProgrammingFilms;

import java.awt.GridLayout;
import java.time.LocalTime;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int topEmptyBorder = 10;
	private static final int leftEmptyBorder = 10;
	private static final int bottomEmptyBorder = 10;
	private static final int rightEmptyBorder = 10;
	
	private static final int rowsGrid = 2;
	private static final int colsGrid = 0;
	private static final int hGapGrid = 5;
	private static final int vGapGrid = 5;
	
	
	private final JTextField hourTextField;
	private final JTextField minTextField;
	private final JLabel hourLabel;
	private final JLabel minLabel;
	
	public TimePanel() {
		
		final LocalTime localTime = LocalTime.now();
		
		setLayout(new GridLayout(rowsGrid, colsGrid, hGapGrid, vGapGrid));
		setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Enter Time"),
						BorderFactory.createEmptyBorder(topEmptyBorder, leftEmptyBorder, bottomEmptyBorder, rightEmptyBorder)));
		hourTextField = new JTextField("" + localTime.getHour());
		hourTextField.setHorizontalAlignment(JTextField.RIGHT);
		minTextField = new JTextField("" + localTime.getMinute());
		minTextField.setHorizontalAlignment(JTextField.RIGHT);
		
		hourLabel = new JLabel("Hour", JLabel.RIGHT);
		minLabel = new JLabel("MIN", JLabel.RIGHT);
	
		add(hourLabel);
		add(minLabel);
		add(hourTextField);
		add(minTextField);
	}

	public int getHourOfDay() throws IllegalArgumentException {
		int hour;
		try {
			hour = Integer.parseInt(hourTextField.getText());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Hour must be number!");
		}

		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException
				("Hours must be between 0 to 23!");
		return hour;
	}

	public int getMinutes() throws IllegalArgumentException {
		int min = 0;
		try {
			min = Integer.parseInt(minTextField.getText());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Minutes must be number!");
		}

		if (min < 0 || min > 59) {
			throw new IllegalArgumentException(
					"Minutes must be between 0 and 59!");
		}
		return min;
	}

	public void setHourTextField(int hour) throws IllegalArgumentException {
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException	
				("Hours must be between 0 to 23!");

		hourTextField.setText("" + hour);
	}

	public void setMinTextField(int min) throws IllegalArgumentException {
		if (min < 0 || min > 59) {
			throw new IllegalArgumentException(
					"Minutes must be between 0 and 59!");
		}
		minTextField.setText("" + min);
	}

	public void setTime(int hour, int min) {
		setHourTextField(hour);
		setMinTextField(min);
	}
}
