package com.godmonth.crud.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.godmonth.crud.jpa.po.LongIdPo;

@Entity
@Table(name = "t_user")
public class User123 extends LongIdPo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("name", this.name)
				.append("id", this.getId()).toString();
	}

}
