package com.capgemini.jpawithhibernatee.manyotone;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pencilbox")
public class PencilBox {

	@Id
	@Column
	private int boxid;
	@Column
	private String name;
	
	@OneToMany(mappedBy = "pencilbox")
	private List<Pencil> pencil;
	
	public List<Pencil> getPencil() {
		return pencil;
	}
	public void setPencil(List<Pencil> pencil) {
		this.pencil = pencil;
	}
	public int getBoxid() {
		return boxid;
	}
	public void setBoxid(int boxid) {
		this.boxid = boxid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
