package com.cohap.collaborative.hadoop.ssh;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSH {
	static String ipaddress, username, password, command;
	static Connection connection;
	static Session session;

	// Constructor
	public SSH(String ipaddress, String username, String password) {
		SSH.ipaddress = ipaddress;
		SSH.username = username;
		SSH.password = password;
	}

	public void makeConnection() {
		System.out.println("Establishing Connection to " + username + "@"
				+ ipaddress);

		try {
			connection = new Connection(SSH.ipaddress);
			connection.connect();
			boolean isauthenticated = connection.authenticateWithPassword(
					SSH.username, SSH.password);

			if (isauthenticated == false) {
				System.out.println("Authentication failed");
				System.exit(1);

			}
			System.out.println("Connection established successfully.");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void executeCommand(String command) {
		System.out.println("Executing the command: " + command);
		SSH.command = command;
		try {
			session = connection.openSession();
			session.execCommand(SSH.command);
			InputStream stdout = new StreamGobbler(session.getStdout());
			BufferedReader br = new BufferedReader(
					new InputStreamReader(stdout));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//try{Thread.sleep(1000);}catch(Exception ee){}
	}

	public void close() {
		System.out.println("Closing Connection");
		session.close();

		connection.close();
	}
}
