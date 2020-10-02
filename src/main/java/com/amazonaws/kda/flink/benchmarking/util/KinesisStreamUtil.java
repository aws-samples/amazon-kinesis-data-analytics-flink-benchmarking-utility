// Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazonaws.kda.flink.benchmarking.util;

import java.util.List;
import java.util.Optional;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.ListShardsRequest;
import com.amazonaws.services.kinesis.model.ListShardsResult;
import com.amazonaws.services.kinesis.model.Shard;
import com.google.common.collect.Lists;

/**
 * <p>
 * This is a utility class with methods to fetch details about a Kinesis Stream.
 * The shard details include the following: shard id, starting Hash Key, and
 * ending Hash Key.
 * <p>
 * 
 * @author Ravi Itha, Amazon Web Service, Inc.
 *
 */
public class KinesisStreamUtil {

	/**
	 * This method describes a Kinesis Data Stream, fetches starting Hash Key for
	 * all the active shards, and creates a list based on those keys.
	 * 
	 * @param streamName
	 * @param region
	 * @return List<String>
	 */
	public static List<String> getHashKeysForOpenShards(AmazonKinesis kinesis, String streamName) {
		String nextToken = null;
		List<String> hashKeyList = Lists.newArrayList();
		// prepare ListShardsRequest
		ListShardsRequest listShardsRequest = new ListShardsRequest();
		listShardsRequest.setStreamName(streamName);
		// get shards
		ListShardsResult listShardResult = kinesis.listShards(listShardsRequest);
		List<Shard> shardList = listShardResult.getShards();
		for (Shard s : shardList) {
			if (s.getSequenceNumberRange().getEndingSequenceNumber() == null) {
				hashKeyList.add(s.getHashKeyRange().getStartingHashKey());
			}
		}
		// get 'next token' from ListShardsResult and check its value. 
		// if it is not null, call listShards until you get a null.
		// hint: paginating all shards.
		nextToken = listShardResult.getNextToken();
		if (Optional.ofNullable(nextToken).isPresent()) {
			do {
				// creating a new ListShardsRequest using next token alone.
				listShardsRequest = new ListShardsRequest();
				listShardsRequest.setNextToken(nextToken);
				listShardResult = kinesis.listShards(listShardsRequest);
				shardList = listShardResult.getShards();
				for (Shard s : shardList) {
					if (s.getSequenceNumberRange().getEndingSequenceNumber() == null) {
						hashKeyList.add(s.getHashKeyRange().getStartingHashKey());
					}
				}
				nextToken = listShardResult.getNextToken();
			} while (Optional.ofNullable(nextToken).isPresent());
		}
		return hashKeyList;
	}


}
