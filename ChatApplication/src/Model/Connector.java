package Model;

/***********************************************************************
 * Module:  Connector.java
 * Author:  kieutanquoc
 * Purpose: Defines the Class Connector
 ***********************************************************************/

import java.util.*;

/** @pdOid b4dd3945-f1aa-4bd1-af8f-503a98fd0c42 */
public abstract class Connector {
   /** @pdOid fa52d132-bc04-4a0e-9f1d-b496f113e11b */
   private String dbtype;
   /** @pdOid 336f75cf-955a-4f7f-9282-f2f963fc283a */
   private String host;
   /** @pdOid 2c4a645c-d657-4763-9c8c-000fa2ced133 */
   private String port;
   /** @pdOid 51333033-4f08-4c4c-b97d-79fa5350483c */
   private String database;
   /** @pdOid 41a3352d-02d0-4c4d-a69c-58bdbd05c0be */
   private String user;
   /** @pdOid cd8e841c-2ea3-4448-b6ac-85927295f224 */
   private String passwd;
   
   /** @pdOid 47511168-af1c-45d0-a936-0efc371676cf */
   public int connection() {
      return 0;
   }
   
   /** @param sqlStr
    * @pdOid 1eac2eac-514a-4455-b8a3-ac1231d61f84 */
   public int insert(String sqlStr) {
      return 0;
   }
   
   /** @param sqlStr
    * @pdOid eb116037-6c7c-4bfd-9d4e-83b22e1a9928 */
   public int update(String sqlStr) {
      return 0;
   }
   
   /** @param sqlStr
    * @pdOid 9ab4c1b9-9a64-4337-ab1a-8760ef8b3600 */
   public int delete(String sqlStr) {
      return 0;
   }
   
   /** @param sqlStr
    * @pdOid c0608230-8f1d-4df7-929e-e3f72bd84d92 */
   public int select(String sqlStr) {
      return 0;
   }
   
   /** @pdOid 9ffc3b4d-f07a-40ae-9b8b-c6e2fc56c0c8 */
   public String getdbtype() {
      return dbtype;
   }
   
   /** @param newDbtype
    * @pdOid 7ccafd96-c75b-4119-9100-ae3bed37331c */
   public void setdbtype(String newDbtype) {
      dbtype = newDbtype;
   }
   
   /** @pdOid 5224804f-c2ef-44e6-8e36-ac96de0e798f */
   public String gethost() {
      return host;
   }
   
   /** @param newHost
    * @pdOid cb1c2792-ec68-4ca9-8ade-176f10b1a611 */
   public void sethost(String newHost) {
      host = newHost;
   }
   
   /** @pdOid a892b9cc-82c6-4932-b30b-6ca86a1f8d7d */
   public String getport() {
      return port;
   }
   
   /** @param newPort
    * @pdOid a23436d6-da7c-44a3-99fa-f65785d5c858 */
   public void setport(String newPort) {
      port = newPort;
   }
   
   /** @pdOid bb5d87c7-35e3-4f46-9e8c-5a5904324c61 */
   public String getdatabase() {
      return database;
   }
   
   /** @param newDatabase
    * @pdOid 00a5cc92-1402-4533-b65d-0dfe8fc33a3e */
   public void setdatabase(String newDatabase) {
      database = newDatabase;
   }
   
   /** @pdOid 112d5328-d1df-4b05-bdf0-55424229e6df */
   public String getuser() {
      return user;
   }
   
   /** @param newUser
    * @pdOid 27991d32-0f10-456c-9223-f1acc4db0291 */
   public void setuser(String newUser) {
      user = newUser;
   }
   
   /** @pdOid c19dad92-0a1e-4fb5-a7f9-909e845b3a0e */
   public String getpasswd() {
      return passwd;
   }
   
   /** @param newPasswd
    * @pdOid 7cd33e62-00c7-47e0-9e51-9b1820384cb4 */
   public void setpasswd(String newPasswd) {
      passwd = newPasswd;
   }

}