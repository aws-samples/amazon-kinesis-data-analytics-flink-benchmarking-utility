// Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazonaws.kda.flink.benchmarking.model;

/**
 * 
 * @author Ravi Itha, Amazon Web Services, Inc.
 *
 */
public class ChildJob {
	
	private String jobName;
	private String jobId;
	private String parentJobId;
	private int numberofInteractions;
	private int batchSize;
	private int batchCadence;
	private int numberofBatches;
	private String batchStartTime;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getNumberofInteractions() {
		return numberofInteractions;
	}
	public void setNumberofInteractions(int numberofInteractions) {
		this.numberofInteractions = numberofInteractions;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public int getBatchCadence() {
		return batchCadence;
	}
	public void setBatchCadence(int batchCadence) {
		this.batchCadence = batchCadence;
	}
	public int getNumberofBatches() {
		return numberofBatches;
	}
	public void setNumberofBatches(int numberofBatches) {
		this.numberofBatches = numberofBatches;
	}
	public String getBatchStartTime() {
		return batchStartTime;
	}
	public void setBatchStartTime(String batchStartTime) {
		this.batchStartTime = batchStartTime;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getParentJobId() {
		return parentJobId;
	}
	public void setParentJobId(String parentJobId) {
		this.parentJobId = parentJobId;
	}

}
