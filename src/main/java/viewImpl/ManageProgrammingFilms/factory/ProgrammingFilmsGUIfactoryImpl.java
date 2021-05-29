package viewImpl.ManageProgrammingFilms.factory;

import java.awt.LayoutManager;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.mindfusion.common.ChangeListener;
import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.ThemeType;

import view.ManageProgrammingFilms.Factory.ProgrammingFilmsGUIfactory;

public class ProgrammingFilmsGUIfactoryImpl implements ProgrammingFilmsGUIfactory {


    @Override
    public JPanel createPanel(final LayoutManager layout) {
        return new JPanel(layout);
    }

    @Override
    public JButton createButton(final String text) {
        return new JButton(text);
    }

    @Override
    public Calendar createCalendar() {
        Calendar calendar = new Calendar();
        calendar.setCurrentTime(DateTime.now());
        calendar.setDate(DateTime.today());//year ,month, day
        
        // Calendar initialization start
        calendar.beginInit();
        calendar.setCurrentView(CalendarView.SingleMonth);
        calendar.setTheme(ThemeType.Silver);
        calendar.getMonthRangeSettings().setMonthsPerRow(1);
        calendar.getMonthRangeSettings().setNumberOfMonths(1);
        //calendar.getMonthRangeSettings().setScrollInterval(1);
        calendar.getSelection().setAllowMultiple(false);
        calendar.getMonthSettings().getDaySettings().setHeaderSize(0);
        calendar.endInit();
        // Calendar initialization end
        
        return null;
    }

    @Override
    public JScrollPane createScrollableTable(final String[] columnNames, final Object[][] data) {
        
        final DefaultTableModel model = new DefaultTableModel(data, columnNames.length);
        final JTable table = new JTable(model) {
                private static final long serialVersionUID = 1L;
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
        };
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return new JScrollPane(table);
    }

}
