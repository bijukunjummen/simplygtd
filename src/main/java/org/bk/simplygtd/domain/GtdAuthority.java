package org.bk.simplygtd.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
public class GtdAuthority {
	
    @Enumerated(EnumType.STRING)
    private AuthorityNames name;



	public AuthorityNames getName() {
    	return name;
    }

	public void setName(AuthorityNames name) {
    	this.name = name;
    }

}
