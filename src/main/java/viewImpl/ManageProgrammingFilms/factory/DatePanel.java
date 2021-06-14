package viewImpl.ManageProgrammingFilms.factory;

import static javax.swing.BorderFactory.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.text.DateFormatSymbols;
import java.time.LocalDate;

public class DatePanel extends JPanel  {
	private static final long serialVersionUID = 1L;
	private final JComboBox monthNamesComboBox;
	private final JTextField dayTextField;
	private final JTextField yearTextField;
	
	private static final int topEmptyBorder = 10;
	private static final int leftEmptyBorder = 10;
	private static final int bottomEmptyBorder = 10;
	private static final int rightEmptyBorder = 10;
	private static final int topPanelBorder = 0;
	private static final int leftPanelBorder = 5;
	private static final int bottomPanelBorder = 0;
	private static final int rightPanelBorder = 0;
	private static final int rowsGrid = 2;
	private static final int colsGrid = 0;
	private static final int hGapGrid = 5;
	private static final int vGapGrid = 5;
	
	
	DatePanel()
	{
	    setLayout(new BorderLayout());
	    setBorder(createCompoundBorder
	            (createTitledBorder("Enter Date"),
						createEmptyBorder(topEmptyBorder,leftEmptyBorder,bottomEmptyBorder,rightEmptyBorder)));
												
		final JPanel monthPanel = new JPanel(new GridLayout(rowsGrid,colsGrid,hGapGrid,vGapGrid));
		final DateFormatSymbols dateFormatter = DateFormatSymbols.getInstance(); // to retrieve months name
		final String months [] = dateFormatter.getMonths();
		monthNamesComboBox = new JComboBox(months);
		monthNamesComboBox.removeItemAt(12);
		monthPanel.add(new JLabel("Month",JLabel.CENTER));
		monthPanel.add(monthNamesComboBox);
		
		JPanel dayYearPanel = new JPanel(new GridLayout(rowsGrid,colsGrid,hGapGrid,vGapGrid));
		dayYearPanel.setBorder(createEmptyBorder(topPanelBorder,leftPanelBorder,bottomPanelBorder,rightPanelBorder));
		dayTextField = 	new JTextField();
		dayTextField.setHorizontalAlignment(JTextField.RIGHT);
		yearTextField = new JTextField();
		yearTextField.setHorizontalAlignment(JTextField.RIGHT);
		
		//set date values
		LocalDate todayDate = LocalDate.now();
		
		monthNamesComboBox.setSelectedIndex(todayDate.getMonthValue()-1);
		dayTextField.setText(Integer.toString(todayDate.getDayOfMonth()));
		yearTextField.setText(Integer.toString(todayDate.getYear()));
		
		dayYearPanel.add(new JLabel("Day",JLabel.RIGHT));
		dayYearPanel.add(new JLabel("Year",JLabel.RIGHT));
		dayYearPanel.add(dayTextField);
		dayYearPanel.add(yearTextField);
		
		add(monthPanel,BorderLayout.WEST);
		add(dayYearPanel,BorderLayout.EAST);
		
	}
	
	
	public LocalDate getDate() throws NumberFormatException, IllegalArgumentException
	{
		if (yearTextField.getText().length() != 4)
		{
			throw new NumberFormatException
					("You must enter a 4-digit year number!");
		}
		
		//parseInt may throw a NumberFormatException (i.e. run time exception)
		int year = Integer.parseInt(yearTextField.getText());
		int day = Integer.parseInt(dayTextField.getText());
				
		int month = monthNamesComboBox.getSelectedIndex()+1;
		LocalDate requestedDate = LocalDate.of(year, month, day);
		/*requestedDate.set(year,month,1,0,0,0);
		requestedDate.set(Calendar.MILLISECOND,0);*/
		//validate date
		
		final LocalDate start = requestedDate.withDayOfMonth(1);
		final LocalDate lastDayOfMonth = start.withDayOfMonth(start.lengthOfMonth());
		
		final int max = lastDayOfMonth.getDayOfMonth(); // get day of this specific month and year
		if (day < 1 || day > max){
			throw new NumberFormatException
				("Day must be between 1 and " + max +"!");
		}
		
		if (requestedDate.isBefore(LocalDate.now())) {
		    throw new IllegalArgumentException("You cannot schedule in the past. Please change date");
		}

		return requestedDate;
	}
	
	public void setDate(LocalDate date)
	{
		/*monthNamesComboBox.setSelectedIndex(date.get(Calendar.MONTH));
		dayTextField.setText("" + date.get(Calendar.DAY_OF_MONTH));
		yearTextField.setText("" + date.get(Calendar.YEAR));
		*/
	    monthNamesComboBox.setSelectedIndex(date.getMonthValue()-1);
	    dayTextField.setText(""+date.getDayOfMonth());
	    yearTextField.setText(""+date.getYear());
	}
	
	public void reset() {
	    this.setDate(LocalDate.now());
	}
	

}

