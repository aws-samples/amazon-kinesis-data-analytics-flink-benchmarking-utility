// Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazonaws.kda.flink.benchmarking.model;

import java.util.List;

/**
 * 
 * @author Ravi Itha, Amazon Web Services, Inc.
 *
 */
public class BenchmarkingSpecs {
	
	private String jobName;
	private int jobDurationInMinutes;
	private String jobId;
	private String region;
	private String jobStartTime;
	private int numberofChildJobs;
	private boolean isUsingDynamoDBLocal;
	private String dynamoDBLocalURI;
	private String parentJobSummaryDDBTableName;
	private String childJobSummaryDDBTableName;
	private List<ChildJob> childJobs;
	private List<String> targetKinesisStreams;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getJobDurationInMinutes() {
		return jobDurationInMinutes;
	}
	public void setJobDurationInMinutes(int jobDurationInMinutes) {
		this.jobDurationInMinutes = jobDurationInMinutes;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getJobStartTime() {
		return jobStartTime;
	}
	public void setJobStartTime(String jobStartTime) {
		this.jobStartTime = jobStartTime;
	}
	public int getNumberofChildJobs() {
		return numberofChildJobs;
	}
	public void setNumberofChildJobs(int numberofChildJobs) {
		this.numberofChildJobs = numberofChildJobs;
	}
	public boolean isUsingDynamoDBLocal() {
		return isUsingDynamoDBLocal;
	}
	public void setUsingDynamoDBLocal(boolean isUsingDynamoDBLocal) {
		this.isUsingDynamoDBLocal = isUsingDynamoDBLocal;
	}
	public String getDynamoDBLocalURI() {
		return dynamoDBLocalURI;
	}
	public void setDynamoDBLocalURI(String dynamoDBLocalURI) {
		this.dynamoDBLocalURI = dynamoDBLocalURI;
	}
	public String getParentJobSummaryDDBTableName() {
		return parentJobSummaryDDBTableName;
	}
	public void setParentJobSummaryDDBTableName(String parentJobSummaryDDBTableName) {
		this.parentJobSummaryDDBTableName = parentJobSummaryDDBTableName;
	}
	public String getChildJobSummaryDDBTableName() {
		return childJobSummaryDDBTableName;
	}
	public void setChildJobSummaryDDBTableName(String childJobSummaryDDBTableName) {
		this.childJobSummaryDDBTableName = childJobSummaryDDBTableName;
	}
	public List<ChildJob> getChildJobs() {
		return childJobs;
	}
	public void setChildJobs(List<ChildJob> childJobs) {
		this.childJobs = childJobs;
	}
	public List<String> getTargetKinesisStreams() {
		return targetKinesisStreams;
	}
	public void setTargetKinesisStreams(List<String> targetKinesisStreams) {
		this.targetKinesisStreams = targetKinesisStreams;
	}
	
	
	

}
