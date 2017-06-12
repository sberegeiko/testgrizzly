package by.beregeiko.testgrizzly.service;

import by.beregeiko.testgrizzly.model.Report;

import java.util.Date;
import java.util.List;

/**
 * Service class for {@link Report)
 *
 * @author Think
 */
public interface ReportService {

    /**
     * Returns all reports by criteria.
     *
     * @param performer the performer for which to return reports.
     * @param startDate the minimal {@code startDate} of report for which to find
     *                  reports (inclusive).
     * @param endDate   the maximum {@code endDate} of report for which to find
     *                  reports (inclusive).
     * @return the list of reports by criteria.
     */
    List<Report> findAllReportsByCriteria(String performer, Date startDate, Date endDate);

    /**
     * Returns the list of all reports.
     *
     * @return the list of all reports
     */
    List<Report> findAllReports();

    /**
     * Returns the list of all performers of all reports.
     *
     * @return the list of all unique performers
     */
    List<String> findAllPerformers();
}
