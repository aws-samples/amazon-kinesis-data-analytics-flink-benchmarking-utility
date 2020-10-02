// Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazonaws.kda.benchmarking.util;

import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class GetSampleData {

	public static void main(String[] args) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-east-1")).build();

		// String tableName = "kda_flink_perf_benchmarking_with_s3";
		// String tableName = "kda_flink_perf_benchmarking_without_s3";
		// String tableName = "kda_flink_perf_benchmarking_child_job_summary";
		String tableName = "kda_flink_perf_benchmarking_parent_job_summary";
		
		try {
			ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
			ScanResult result = client.scan(scanRequest);

			for (Map<String, AttributeValue> item : result.getItems()) {
				Map<String, AttributeValue> attributeList = item;
				for (Map.Entry<String, AttributeValue> item1 : attributeList.entrySet()) {
					String attributeName = item1.getKey();
					AttributeValue value = item1.getValue();
					
					// if(Optional.ofNullable(value.getN()).isPresent())
						
						
					
					System.out.print(attributeName + ": " + (value.getS() == null ? "N=[" + value.getN() + "] " : "S=[" + value.getS() + "] "));
				}
				// Move to next line
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println("Unable to create table: ");
			System.err.println(e.getMessage());
		}

	}

}
