package viewImpl.ManageProgrammingFilms;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.ManageProgrammingFilms.ScheduleFilmsGUI;

public class ScheduleFilmGUIimpl implements ScheduleFilmsGUI {

	private static final long serialVersionUID = 1L;
	private DatePanelImpl dateSelector;
	private InfoProgrammationPanelImpl infoProgrammation;
	private TimePanelImpl timeSelector;
	private JFrame frame = new JFrame();
	private Container container = frame.getContentPane();

	public ScheduleFilmGUIimpl() {
		//this.mainGUI = mainGUI;
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		ArrayList <Integer> arr = new ArrayList<>();
		arr.add(new Integer(1));
		arr.add(new Integer(2));
		arr.add(new Integer(3));
		arr.add(new Integer(4));
		
		infoProgrammation = new InfoProgrammationPanelImpl(arr);
		mainPanel.add(infoProgrammation,BorderLayout.CENTER);
		mainPanel.add(getBottomPanel(), BorderLayout.SOUTH);
		mainPanel.add(getDateAndTimePanel(),BorderLayout.NORTH);
		
		container.add(mainPanel);
		
		frame.setTitle("Schedule a film");
		frame.pack();
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	private JPanel getBottomPanel() { // must be pass a local date
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		JButton scheduleButton = new JButton("Schedule");
		scheduleButton.setMnemonic('S');
		scheduleButton.addActionListener(new ScheduleButtonListener());
		buttonPanel.add(scheduleButton);
		panel.add(buttonPanel, scheduleButton);
		return panel;
	}

	private JPanel getDateAndTimePanel() {
		// date and time panel selection
		JPanel datePanel = new JPanel(new BorderLayout());
		datePanel.setBorder(BorderFactory.createCompoundBorder(
								BorderFactory.createTitledBorder("Date and start time"),
									BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		dateSelector = new DatePanelImpl(LocalDate.of(2021,1,5)); // year, month , day
		timeSelector = new TimePanelImpl();
		datePanel.add(dateSelector, BorderLayout.WEST);
		datePanel.add(timeSelector, BorderLayout.EAST);
		return datePanel;
	}


	private class ScheduleButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {

				// check if all required fields have been entered
				if (infoProgrammation.getPrice().equals("") ) {
					JOptionPane.showMessageDialog(frame,
							"You must enter all fields",
							"Invalid Data", JOptionPane.ERROR_MESSAGE);
				} else {
					Calendar date = dateSelector.getDate();
					date.set(Calendar.HOUR_OF_DAY, timeSelector.getHourOfDay());
					date.set(Calendar.MINUTE, timeSelector.getMinutes());
					JOptionPane.showMessageDialog(frame,"Film has been scheduled.");
				}

			} catch (Exception e) {

				JOptionPane.showMessageDialog(frame,e.getMessage(), "Invalid Data",JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	
	public static void main(String []args) {
		ScheduleFilmGUIimpl scheduleForm = new ScheduleFilmGUIimpl();
	}
}
