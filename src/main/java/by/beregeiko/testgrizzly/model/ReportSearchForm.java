package by.beregeiko.testgrizzly.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Form object for search.
 *
 * @author Think
 */

public class ReportSearchForm {
    private String[] periods = {"LAST_MONTH", "LAST_QTR", "LAST_YEAR",
            "CURRENT_MONTH_TO_DATE", "CURRENT_QTR_TO_DATE", "CURRENT_YEAR_TO_DATE"};

    @DateTimeFormat(pattern = "MMM d, yyyy")
    private Date startDate;

    @DateTimeFormat(pattern = "MMM d, yyyy")
    private Date endDate;

    private String performer;

    private String period;

    public ReportSearchForm() {
    }

    public ReportSearchForm(String period) {
        this.period = period;
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        switch (period) {
            case "LAST_MONTH":
                cal.set(Calendar.DATE, 1);
                cal.add(Calendar.DATE, -1);
                endDate = cal.getTime();
                cal.set(Calendar.DATE, 1);
                startDate = cal.getTime();
                break;
            case "LAST_QTR":
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) / 3 * 3);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                cal.add(Calendar.DATE, -1);
                endDate = cal.getTime();
                cal.add(Calendar.MONTH, -2);
                cal.set(Calendar.DATE, 1);
                startDate = cal.getTime();
                break;
            case "LAST_YEAR":
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, 0);
                cal.add(Calendar.DATE, -1);
                endDate = cal.getTime();
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, 0);
                startDate = cal.getTime();
                break;
            case "CURRENT_MONTH_TO_DATE":
                cal.set(Calendar.DATE, 1);
                startDate = cal.getTime();
                endDate = currentDate;
                break;
            case "CURRENT_QTR_TO_DATE":
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) / 3 * 3);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                startDate = cal.getTime();
                endDate = currentDate;
                break;
            case "CURRENT_YEAR_TO_DATE":
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, 0);
                startDate = cal.getTime();
                endDate = currentDate;
                break;
        }
    }

    /**
     * @return the minimal start date of report to search
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the maximum end date of report to search
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the performer to search reports
     */
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    /**
     * @return periods to search reports
     */
    public String[] getPeriods() {
        return periods;
    }
}
