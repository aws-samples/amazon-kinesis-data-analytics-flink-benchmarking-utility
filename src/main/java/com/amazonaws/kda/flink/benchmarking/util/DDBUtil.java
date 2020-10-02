// Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazonaws.kda.flink.benchmarking.util;

import com.amazonaws.services.dynamodbv2.document.AttributeUpdate;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;

public class DDBUtil {

	/**
	 * This method updates an item in DynamoDB table using Primary Hash Key and Range Key
	 * @param dynamoDBClient
	 * @param dynamoDBTblName
	 * @param jobName
	 * @param jobId
	 * @param jobFinishTime
	 * @param jobStatus
	 * @return
	 */
	public static boolean updateChildJobStatus(DynamoDB dynamoDBClient, String dynamoDBTblName, String jobName,
			String jobId, String jobFinishTime, String jobStatus) {
		boolean itemUpdated = false;
		Table table = dynamoDBClient.getTable(dynamoDBTblName);

		AttributeUpdate attributeUpdate = new AttributeUpdate("strAttr").put("Completed");
		UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("job_name", jobName, "job_id", jobId)
				.withAttributeUpdate(attributeUpdate);
		UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
		int statusCode = outcome.getUpdateItemResult().getSdkHttpMetadata().getHttpStatusCode();
		if (statusCode == 200) {
			itemUpdated = true;
		}
		return itemUpdated;
	}
	
	/**
	 * This method inserts an item to DynamoDB Table
	 * @param dynamoDBClient
	 * @param dynamoDBTblName
	 * @param jobName
	 * @param jobId
	 * @param numInteractionsProcessed
	 * @param jobStartTime
	 * @param jobStatus
	 * @return
	 */
	public static boolean insertParentJobStatus(DynamoDB dynamoDBClient, String dynamoDBTblName, String jobName, String jobId,
			int numInteractionsProcessed, String jobStartTime, String jobStatus) {

		boolean itemInserted = false;
		Table table = dynamoDBClient.getTable(dynamoDBTblName);
		Item item = new Item().withPrimaryKey("job_name", jobName)
				.withString("job_id", jobId)
				.withString("job_status", jobStatus)
				.withNumber("number_of_interactions_processed", numInteractionsProcessed)
				.withString("job_starttime", jobStartTime);
		try {
			PutItemOutcome outcome = table.putItem(item);
			int statusCode = outcome.getPutItemResult().getSdkHttpMetadata().getHttpStatusCode();
			if (statusCode == 200) {
				itemInserted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Item could not be inserted to DynamoDB table.");
		}
		return itemInserted;
	}
	
	/**
	 * This method inserts an item to DynamoDB Table
	 * @param dynamoDBClient
	 * @param dynamoDBTblName
	 * @param jobName
	 * @param jobId
	 * @param parentJobId
	 * @param numInteractionsProcessed
	 * @param jobStartTime
	 * @param jobStatus
	 * @return
	 */
	public static boolean insertChildJobStatus(DynamoDB dynamoDBClient, String dynamoDBTblName, String jobName, String jobId, String parentJobId,
			int numInteractionsProcessed, String jobStartTime, String jobStatus) {

		boolean itemInserted = false;
		Table table = dynamoDBClient.getTable(dynamoDBTblName);
		Item item = new Item().withPrimaryKey("job_name", jobName)
				.withString("job_id", jobId)
				.withString("parent_job_id", parentJobId)
				.withString("job_status", jobStatus)
				.withNumber("number_of_interactions_processed", numInteractionsProcessed)
				.withString("job_starttime", jobStartTime);
		try {
			PutItemOutcome outcome = table.putItem(item);
			int statusCode = outcome.getPutItemResult().getSdkHttpMetadata().getHttpStatusCode();
			if (statusCode == 200) {
				itemInserted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Item could not be inserted to DynamoDB table.");
		}
		return itemInserted;
	}
	
	/**
	 * This method inserts an item to DynamoDB Table
	 * @param dynamoDBClient
	 * @param dynamoDBTblName
	 * @param jobName
	 * @param jobTriggeringId
	 * @param targetStream
	 * @param interactionId
	 * @param batchSize
	 * @param executionTime
	 * @return
	 */
	public static boolean insertChildJobDetailedStatus(DynamoDB dynamoDBClient, String dynamoDBTblName, String jobName,
			String jobTriggeringId, String targetStream, String interactionId, int batchSize, long executionTime) {

		boolean itemInserted = false;
		Table table = dynamoDBClient.getTable(dynamoDBTblName);
		Item item = new Item().withPrimaryKey("job_name", jobName).withString("job_run_id", jobTriggeringId + "-" + System.currentTimeMillis())
				.withString("interaction_id", interactionId).withString("interaction_id", interactionId)
				.withNumber("batch_size", batchSize).withString("stream_name", targetStream);
		try {
			PutItemOutcome outcome = table.putItem(item);
			int statusCode = outcome.getPutItemResult().getSdkHttpMetadata().getHttpStatusCode();
			if (statusCode == 200) {
				itemInserted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Item could not be inserted to DynamoDB table.");
		}
		return itemInserted;
	}

}
