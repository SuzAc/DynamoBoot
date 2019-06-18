package com.org.dto;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * 
 * @author sujit.sahoo
 *
 */
@DynamoDBDocument
public class Information implements Serializable {

	private static final long serialVersionUID = 3236408026670751249L;

	@DynamoDBAttribute(attributeName = "directors")
	private List<String> directors;

	@DynamoDBAttribute(attributeName = "release_date")
	private String release_date;

	@DynamoDBAttribute(attributeName = "rating")
	private int rating;

	@DynamoDBAttribute(attributeName = "genres")
	private List<String> genres;

	@DynamoDBAttribute(attributeName = "image_url")
	private String image_url;

	@DynamoDBAttribute(attributeName = "plot")
	private String plot;

	@DynamoDBAttribute(attributeName = "rank")
	private int rank;

	@DynamoDBAttribute(attributeName = "running_time_secs")
	private int running_time_secs;

	@DynamoDBAttribute(attributeName = "actors")
	private List<String> actors;

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRunning_time_secs() {
		return running_time_secs;
	}

	public void setRunning_time_secs(int running_time_secs) {
		this.running_time_secs = running_time_secs;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Information [directors=" + directors + ", release_date=" + release_date + ", rating=" + rating
				+ ", genres=" + genres + ", image_url=" + image_url + ", plot=" + plot + ", rank=" + rank
				+ ", running_time_secs=" + running_time_secs + ", actors=" + actors + "]";
	}
}
