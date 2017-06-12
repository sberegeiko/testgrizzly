package by.beregeiko.testgrizzly.service;

import by.beregeiko.testgrizzly.model.Report;
import by.beregeiko.testgrizzly.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Implementation of {@link ReportService} interface.
 *
 * @author Think
 */

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Report> findAllReportsByCriteria(String performer, Date startDate, Date endDate) {
        return reportRepository.findAllByCriteria(performer, startDate, endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Report> findAllReports() {
        return reportRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllPerformers() {
        return reportRepository.findAllPerformers();
    }
}
