package by.beregeiko.testgrizzly.controller;

import by.beregeiko.testgrizzly.model.Report;
import by.beregeiko.testgrizzly.model.ReportSearchForm;
import by.beregeiko.testgrizzly.service.ReportService;
import by.beregeiko.testgrizzly.validator.ReportValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Controller for {@link Report}'s pages.
 *
 * @author Think
 */

@Controller
@RequestMapping("/reports")
public class ReportController {
    private final Logger logger = LoggerFactory.getLogger(ReportController.class);

    private ReportService reportService;

    private ReportValidator reportValidator;

    @ModelAttribute("allPerformers")
    public List<String> loadAllPerformers() {
        return reportService.findAllPerformers();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * Shows the search form
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showReportForm(Model model) {
        ReportSearchForm form = new ReportSearchForm();
        model.addAttribute("reportForm", form);
        logger.info("Report form created");
        return "reports/criteria";
    }

    /**
     * Shows the search form with the automatically filled start and end dates by selected period
     *
     * @param period period (e.g. "LAST_MONTH", "LAST_QTR", "LAST_YEAR") for start and end dates
     */
    @RequestMapping(value = {"/{period}"}, method = RequestMethod.GET)
    public String showReportForm(@PathVariable("period") String period, Model model) {
        ReportSearchForm form = new ReportSearchForm(period);
        model.addAttribute("reportForm", form);
        logger.info("Report form with period created");
        return "reports/criteria";
    }

    /**
     * Handles reports search form and shows the search form along with the list of found reports.
     */
    @RequestMapping(value = {"/", "/{period}"}, method = RequestMethod.POST)
    public String showReports(@ModelAttribute("reportForm") ReportSearchForm form,
                              BindingResult bindingResult, Model model) {
        reportValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.info("BindingResult error detected");
            return "reports/criteria";
        }

        List<Report> reports = reportService.findAllReportsByCriteria(form.getPerformer(), form.getStartDate(),
                form.getEndDate());
        model.addAttribute("reports", reports);
        logger.info("Listing reports");
        return "reports/criteria";
    }

    @Autowired
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @Autowired
    public void setReportValidator(ReportValidator reportValidator) {
        this.reportValidator = reportValidator;
    }
}
