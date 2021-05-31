package view.ManageStatistics;

import controller.ManageStatistics.StatisticsController;

public interface StatisticsGUI {
    void show();
    void setObserver(StatisticsController observer );
}
