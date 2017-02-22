package com.cohap.collaborative.hadoop.ssh;

public class Commands {
	// Create a directory in HDFS at given path
	//Example: hadoop fs -mkdir /apple
	public static String makeDirectory(String path) {
		return "/usr/local/hadoop/bin/hadoop fs -mkdir " + path;
		
		
	}

	// Upload a file in HDFS from local file system
	//Example: hadoop fs -put apple /
	public static String uploadFile(String localSourcePath,
			String HDFSdestinationPath) {
		return "/usr/local/hadoop/bin/hadoop fs -put " + localSourcePath + " "
				+ HDFSdestinationPath;
	}

	// Copies/Downloads files from HDFS to the local file system
	//Example: hadoop fs -get /apple.txt ~/
	public static String downloadFile(String HDFSsourcePath,
			String localDestinationPath) {
		return "/usr/local/hadoop/bin/hadoop fs -get " + HDFSsourcePath + " "
				+ localDestinationPath;
	}

	// Move file from source to destination within HDFS.
	//Example: hadoop fs -mv /apple.txt /input
	public static String moveFile(String HDFSSourcePath,
			String HDFSdestinationPath) {
		return "/usr/local/hadoop/bin/hadoop fs -mv " + HDFSSourcePath + " "
				+ HDFSdestinationPath;
	}

	// Copy a file from source to destination within HDFS
	//Example: hadoop fs -cp /apple.txt /input
	public static String copyFile(String HDFSSourcePath,
			String HDFSdestinationPath) {
		return "/usr/local/hadoop/bin/hadoop fs -cp " + HDFSSourcePath + " "
				+ HDFSdestinationPath;
	}

	// Remove a file or directory in HDFS
	//Example: hadoop fs -rmr /apple
	public static String removeDirectory(String path) {
		return "/usr/local/hadoop/bin/hadoop fs -rmr " + path;
	}

}
