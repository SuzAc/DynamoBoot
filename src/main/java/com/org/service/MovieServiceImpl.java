package com.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.org.config.AWSConfiguration;
import com.org.dto.Movie;
/**
 * 
 * @author sujit.sahoo
 *
 */
@Component
public class MovieServiceImpl implements MovieService {
	@Autowired
	AWSConfiguration aWSConfiguration;

	public void createTable(DynamoDBMapper dynamoDBMapper) {
		List<KeySchemaElement> keySchemaList = new ArrayList<KeySchemaElement>();
		keySchemaList.add(new KeySchemaElement("year", KeyType.HASH));
		keySchemaList.add(new KeySchemaElement("title", KeyType.RANGE));

		List<AttributeDefinition> attributeDefinationList = new ArrayList<AttributeDefinition>();
		attributeDefinationList.add(new AttributeDefinition("year", ScalarAttributeType.N));
		attributeDefinationList.add(new AttributeDefinition("title", ScalarAttributeType.S));
		dynamoDBMapper.generateCreateTableRequest(Movie.class);
//		Table table = dynamoDBMapper.createTable(Movie.class.getSimpleName(), keySchemaList, attributeDefinationList, new ProvisionedThroughput(10L, 10L));
//		try {
//			table.waitForActive();
//			System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void addItem(Movie movie) {
		aWSConfiguration.getDynamoDBMapper().save(movie);

	}

	public Movie getItem(String year, String title) {
		return aWSConfiguration.getDynamoDBMapper().load(Movie.class, Integer.parseInt(year), title);

	}

	public void updateItem(Movie movie) {
		Movie movieLoad = aWSConfiguration.getDynamoDBMapper().load(Movie.class, movie.getYear(), movie.getTitle());
		if (null != movieLoad)
			aWSConfiguration.getDynamoDBMapper().save(movie);

	}

	public void deleteItem(String year, String title) {
		Movie movie = aWSConfiguration.getDynamoDBMapper().load(Movie.class, Integer.parseInt(year), title);
		aWSConfiguration.getDynamoDBMapper().delete(movie);
	}

}
