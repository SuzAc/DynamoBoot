package com.org.dto;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * 
 * @author sujit.sahoo
 *
 */
@DynamoDBTable(tableName = "Movie")
public class Movie implements Serializable {

	private static final long serialVersionUID = 5012917233939974482L;

	@DynamoDBHashKey(attributeName = "year")
	private int year;

	@DynamoDBRangeKey(attributeName = "title")
	private String title;

	@DynamoDBAttribute(attributeName = "info")
	private Information info;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Movie [year=" + year + ", title=" + title + ", info=" + info + "]";
	}
}
