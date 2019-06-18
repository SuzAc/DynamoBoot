package com.org.service;

import com.org.dto.Movie;
/**
 * 
 * @author sujit.sahoo
 *
 */
public interface MovieService {

	public Movie getItem(String year, String title);

	public void addItem(Movie movie);

	public void updateItem(Movie movie);

	public void deleteItem(String year, String title);

}
