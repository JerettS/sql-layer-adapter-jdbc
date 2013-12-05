# FoundationDB SQL Layer JDBC driver

This [JDBC](http://www.oracle.com/technetwork/java/overview-141217.html) driver provides connectivity between the Java programming language and the [SQL Layer](https://foundationdb.com/layers/sql/index.html).

## 1. Getting the driver

This driver is installed by default with the SQL Layer. If you need to install this driver separately, use Maven Central. You can also compile it yourself.

### Getting the driver from Maven Central

If you've got access to Maven Central, simply add the following to your project's pom.xml:

```
<dependency>
  <groupId>com.foundationdb.Driver</groupId>
  <artifactId>fdb-sql-layer-jdbc</artifactId>
  <version>9.4.0</version>
</dependency>
```

### Compiling the driver

Alternatively, to compile you will need to have a Java 6 or newer [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and will need to have
[Ant](http://ant.apache.org/index.html) installed. Then, simply run ant in the top level directory.
This will compile the correct driver for your JVM, and build a .jar file (Java ARchive)
called fdb-sql-layer-jdbc.jar.

*REMEMBER*: Once you have compiled the driver, it will work on ALL platforms
that support that version of the API. You don't need to build it for each
platform.

## 2. Installing the driver

To install the driver, the fdb-sql-layer-jdbc.jar file has to be in the classpath.

i.e. under LINUX/SOLARIS (the example here is my linux box):

	export CLASSPATH=.:/usr/local/foundationdb/sql/client/fdb-sql-layer-jdbc.jar

## 3. Using the driver

To use the driver, you must introduce it to JDBC. There's two ways
of doing this:

- Hardcoded

   This method hardcodes your driver into your application. You
   introduce the driver using the following snippet of code:

```java
try {
  Class.forName("com.foundationdb.Driver");
} catch(Exception e) {
  // your error handling code goes here
}
```

   Remember, this method restricts your code to just the FoundationDB SQL Layer.
   However, this is how most people load the driver.

- Parameters

   This method specifies the driver from the command line. When running the
   application, you specify the driver using the option:

    `-Djdbc.drivers=com.foundationdb.Driver`

   eg: This is an example of running a sample app with with the driver:

    `java -Djdbc.drivers=com.foundationdb.Driver com.foundationdb.sample.Main`

   note: This method only works with Applications (not for Applets).
	 However, the application is not tied to one driver, so if you needed
	 to switch databases (why I don't know ;-) ), you don't need to
	 recompile the application (as long as you havent hardcoded the url's).

### JDBC URL syntax

The driver recognizes JDBC URLs of the form:

    jdbc:fdbsql:database

    jdbc:fdbsql://host/database

    jdbc:fdbsql://host:port/database

Also, you can supply both username and passwords as arguments, by appending
them to the URL. e.g.:

    jdbc:fdbsql:database?user=me
    jdbc:fdbsql:database?user=me&password=mypass

Notes:

- If you are connecting to localhost or 127.0.0.1 you can leave it out of the
   URL. i.e.: `jdbc:fdbsql://localhost/mydb` can be replaced with `jdbc:fdbsql:mydb`

- The port defaults to 15432 if it's left out.

## 4. More Information ##
For a full guide of how to use JDBC, refer to [Oracle's website](http://www.oracle.com/technetwork/java/javase/jdbc/) and the [JDBC tutorial](http://docs.oracle.com/javase/tutorial/jdbc/).

For support, visit our community site at http://community.foundationdb.com or hop on the `#foundationdb` IRC channel on irc.freenode.net