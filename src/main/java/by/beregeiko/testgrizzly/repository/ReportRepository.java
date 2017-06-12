package by.beregeiko.testgrizzly.repository;

import by.beregeiko.testgrizzly.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Repository class for {@link Report)
 *
 * @author Think
 */

public interface ReportRepository extends JpaRepository<Report, Long> {
    /**
     * Returns all reports by criteria.
     *
     * @return all reports by criteria
     */
    @Query("SELECT DISTINCT r FROM Report r WHERE r.performer = ?1 AND r.startDate >= ?2 AND r.endDate <= ?3")
    List<Report> findAllByCriteria(String performer, Date startDate, Date endDate);

    /**
     * Returns all performers of all reports.
     *
     * @return all unique performers
     */
    @Query("SELECT DISTINCT r.performer FROM Report r ORDER BY r.performer")
    List<String> findAllPerformers();
}
