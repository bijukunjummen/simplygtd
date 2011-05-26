package org.bk.simplygtd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="gtdcontexts")
public class GtdContext {

    @Size(min = 1, max = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name="gtduser_id")
    private GtdUser gtdUser;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    @JsonIgnore
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonIgnore
    public GtdUser getGtdUser() {
        return this.gtdUser;
    }
    
    public void setGtdUser(GtdUser gtdUser) {
        this.gtdUser = gtdUser;
    }

	@Override
	public String toString() {
		return "GtdContext [id=" + id + ", name=" + name + "]";
	}


}
