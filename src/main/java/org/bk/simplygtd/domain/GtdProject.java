package org.bk.simplygtd.domain;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="gtdprojects")
public class GtdProject{

    @Size(min = 1, max = 100)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss a")
    private Calendar startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss a")
    private Calendar completedDate;

    private Boolean isDone;

    @ManyToOne
    @JoinColumn(name="gtduser_id")
    private GtdUser gtdUser;
    
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

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Calendar getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
    
    public Calendar getCompletedDate() {
        return this.completedDate;
    }
    
    public void setCompletedDate(Calendar completedDate) {
        this.completedDate = completedDate;
    }
    
    public Boolean getIsDone() {
        return this.isDone;
    }
    
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
    
    @JsonIgnore
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
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("StartDate: ").append(getStartDate()).append(", ");
        sb.append("CompletedDate: ").append(getCompletedDate()).append(", ");
        sb.append("IsDone: ").append(getIsDone()).append(", ");
        sb.append("GtdUser: ").append(getGtdUser());
        return sb.toString();
    }
    
}
