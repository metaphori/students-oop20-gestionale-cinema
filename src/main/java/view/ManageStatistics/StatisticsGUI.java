package view.ManageStatistics;

import controller.ManageStatistics.StatisticsController;

public interface StatisticsGUI {
    
    /**
     * Show a statistics view
     */
    void show();
    
    /**
     * Set Statistics controller observer
     * @param observer
     */
    void setObserver(StatisticsController observer);
    
    /**
     * Update view
     */
    void update();
}
