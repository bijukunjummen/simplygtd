package org.bk.simplygtd.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class GtdAction {

    @Size(min = 1, max = 100)
    private String title;

    @ManyToOne
    private GtdProject project;

    @ManyToOne
    private GtdContext gtdContext;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date completedDate;

    private Boolean isDone;

    @Enumerated(EnumType.STRING)
    private GtdStatus status;
    
    @ManyToOne
    private GtdUser gtdUser;

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public GtdProject getProject() {
        return this.project;
    }
    
    public void setProject(GtdProject project) {
        this.project = project;
    }
    
    public GtdContext getContext() {
        return this.gtdContext;
    }
    
    public void setContext(GtdContext gtdContext) {
        this.gtdContext = gtdContext;
    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getCompletedDate() {
        return this.completedDate;
    }
    
    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
    
    public Boolean getIsDone() {
        return this.isDone;
    }
    
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
    
    public GtdStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(GtdStatus status) {
        this.status = status;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Version
    @Column(name = "version")
    private Integer version;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    public GtdUser getGtdUser() {
        return this.gtdUser;
    }
    
    public void setGtdUser(GtdUser gtdUser) {
        this.gtdUser = gtdUser;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Title: ").append(getTitle()).append(", ");
        sb.append("Project: ").append(getProject()).append(", ");
        sb.append("Context: ").append(getContext()).append(", ");
        sb.append("StartDate: ").append(getStartDate()).append(", ");
        sb.append("CompletedDate: ").append(getCompletedDate()).append(", ");
        sb.append("IsDone: ").append(getIsDone()).append(", ");
        sb.append("Status: ").append(getStatus()).append(", ");
        sb.append("GtdUser: ").append(getGtdUser());
        return sb.toString();
    }
    
}
