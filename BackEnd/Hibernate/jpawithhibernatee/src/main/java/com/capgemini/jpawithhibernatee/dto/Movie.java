package com.capgemini.jpawithhibernatee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie 
{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)	//autoincrement to like like srno.
	private int id;
	@Column(name = "name")
	private String mname;
	@Column
	private String rating;

	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getMname()
	{
		return mname;
	}
	public void setMname(String mname) 
	{
		this.mname = mname;
	}
	public String getRating() 
	{
		return rating;
	}
	public void setRating(String rating) 
	{
		this.rating = rating;
	}

}
