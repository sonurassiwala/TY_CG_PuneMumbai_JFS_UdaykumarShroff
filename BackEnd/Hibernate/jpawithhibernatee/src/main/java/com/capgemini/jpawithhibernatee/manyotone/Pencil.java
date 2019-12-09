package com.capgemini.jpawithhibernatee.manyotone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pencil")
public class Pencil {

	@Id
	@Column
	private int pid;
	@Column
	private String color;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "boxid", nullable = false)
	PencilBox pencilbox = new PencilBox();

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public PencilBox getPencilbox() {
		return pencilbox;
	}

	public void setPencilbox(PencilBox pencilbox) {
		this.pencilbox = pencilbox;
	}
	
	
	
	
}
