package Model;
/***********************************************************************
 * Module:  SQLServer.java
 * Author:  kieut
 * Purpose: Defines the Class SQLServer
 ***********************************************************************/

import View.Register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** @pdOid ff6bbadf-9e89-467c-9b8a-1da0125eb145 */
public class SQLServer extends Connector {
	Connection conn = null;
	private String dbtype = "SQL Server";
	private String host;
	private String port = "1433";
	private String database = "Register";
	private String user = "sa";
	private String passwd = "88888888";
	Register gui = new Register();
	@Override
	public int connection() {
		return 0;
	}
	
	public int insert(String sqlStr) {
		return 0;
	}
	
	public int update(String sqlStr) {
		return 0;
	}
	
	public int delete(String sqlStr) {
		return 0;
	}
	
	public int select(String sqlStr) {
		return 0;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}