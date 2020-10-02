#!/bin/bash

#This script runs Kinesis Data Analytics Flink Benchmarking Utility

export TZ='America/Chicago'
echo 'Running Kinesis Data Generator Application' @ $(date)
java -jar /home/ec2-user/kda-flink-benchmarking-utility/amazon-kinesis-data-analytics-flink-benchmarking-utility-0.1.jar \
	/home/ec2-user/kda-flink-benchmarking-utility/benchmarking_specs.json >> /home/ec2-user/kda-flink-benchmarking-utility/logs_new/kdg_log_$(date '+%Y-%m-%d-%H-%M-%S').log