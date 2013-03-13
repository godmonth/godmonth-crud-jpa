package com.godmonth.crud.test;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.godmonth.crud.jpa.po.LongIdPo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "t_car")
public class Car extends LongIdPo {
	private User123 user123;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "name123_id")
	public User123 getUser123() {
		return user123;
	}

	public void setUser123(User123 user123) {
		this.user123 = user123;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendSuper(super.toString())
				.append("user123", this.user123).toString();
	}

}
