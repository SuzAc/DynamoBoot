package com.org.config;

import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.org.util.DynamoConstants;
/**
 * 
 * @author sujit.sahoo
 *
 */
@Component
public class AWSConfiguration {

	public DynamoDB getDynamoDB() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8004", "us-west-2")).build();

		return new DynamoDB(client);
	}

	public DynamoDBMapper getDynamoDBMapper() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(DynamoConstants.SECRET_KEY, DynamoConstants.PASSWORD);
		// This is for local
		/*
		 * AmazonDynamoDB client =
		 * AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration( new
		 * AwsClientBuilder.EndpointConfiguration("http://localhost:8004",
		 * "us-west-2")).build();
		 */

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(DynamoConstants.REGION)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		DynamoDBMapperConfig.Builder builder = new DynamoDBMapperConfig.Builder();
		builder.setConversionSchema(ConversionSchemas.V2);
		// builder.setTableNameOverride(new TableNameOverride("Movie"));
		return new DynamoDBMapper(client, builder.build());
	}

}
