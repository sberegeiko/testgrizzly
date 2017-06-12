package by.beregeiko.testgrizzly.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Simple JavaBean domain object that represents a Report
 *
 * @author Think
 */

@Entity
@Table(name = "reports")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @DateTimeFormat(pattern = "MMM d, yyyy")
    @Column(name = "startdate")
    private Date startDate;

    @DateTimeFormat(pattern = "MMM d, yyyy")
    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "performer")
    private String performer;

    @Column(name = "activity")
    private String activity;

    public Report() {
    }

    public Report(Date startDate, Date endDate, String performer, String activity) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.performer = performer;
        this.activity = activity;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
