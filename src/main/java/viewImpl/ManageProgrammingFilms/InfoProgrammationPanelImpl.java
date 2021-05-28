package viewImpl.ManageProgrammingFilms;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class InfoProgrammationPanelImpl extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String defaultStringPrice = "3.4 e.g. (euro)";
	private static final int topEmptyBorder = 10;
	private static final int leftEmptyBorder = 10;
	private static final int bottomEmptyBorder = 10;
	private static final int rightEmptyBorder = 10;
	private static final int rowsGrid = 4;
	private static final int colsGrid = 0;
	private static final int hGapGrid = 5;
	private static final int vGapGrid = 5;
	
	final private JTextField price;
	final private JComboBox halls;

	public InfoProgrammationPanelImpl(final List <Integer> hallsNumber) {
		
		halls = new JComboBox(hallsNumber.toArray());
		price = new JTextField(defaultStringPrice);
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Info"),
						BorderFactory.createEmptyBorder(topEmptyBorder, leftEmptyBorder, bottomEmptyBorder, rightEmptyBorder))
		); 
		add(getLabelsPanel(), BorderLayout.WEST);
		add(getTextFieldPanel(), BorderLayout.CENTER);
		
		price.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (defaultStringPrice.equals(price.getText())) { 
                    price.setText("");
                }
				
			}

			@Override
			public void focusLost(FocusEvent e) {
								
			}		
			
		});
		
	}
	
	public String getPrice() {
		return price.getText();
	}


	public void setPrice(final String priceValue) {
		price.setText(priceValue);
		price.setFocusable(true);
		price.selectAll();
	}
	
	public String getHall() {
		return (String) halls.getSelectedItem();
	}


	private JPanel getLabelsPanel() {
		JPanel labelPanel = new JPanel(new GridLayout(rowsGrid, colsGrid, hGapGrid, vGapGrid)); //int rows, int cols, int hgap, int vgap)
		labelPanel.add(new JLabel("Price"));
		labelPanel.add(new JLabel("Hall"));
		return labelPanel;
	}

	private JPanel getTextFieldPanel() {
		JPanel textFieldPanel = new JPanel(new GridLayout(rowsGrid, colsGrid, hGapGrid, vGapGrid));
		textFieldPanel.add(price);
		textFieldPanel.add(halls);
		return textFieldPanel;
	}

}
