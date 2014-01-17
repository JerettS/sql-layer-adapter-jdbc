# FoundationDB SQL Layer JDBC Driver

This [JDBC](http://www.oracle.com/technetwork/java/overview-141217.html) driver
provides connectivity between the Java programming language and the
[SQL Layer](https://foundationdb.com/layers/sql/).


## Getting the Driver

There are two versions of the driver built for every release. These implement
the JDBC 4.0 and 4.1 APIs for use with Java 6 and Java 7, respectively. Both
the driver and JDBC versions are included in the name of the driver for
clarity.

The latest release is 1.9-3 with versions named `1.9-3-jdbc4` and
`1.9-3-jdbc41`.


### SQL Layer

This JDBC 4.1 version is included with the installation of the SQL Layer.
The jar file can be found in the following system-dependent locations:

- Linux
    - `/usr/share/foundationdb/sql/client/fdb-sql-layer-jdbc-*.jar`
- Mac OS X
    - `/usr/local/foundationdb/sql/client/fdb-sql-layer-jdbc-*.jar`
- Windows
    - `C:\Program Files\foundationdb\sql\lib\client\fdb-sql-layer-jdbc-*.jar`


### Maven Central

Both versions of the driver are deployed to standard Central repository for
use with Maven based projects. To get started, simply include the following
in the `<dependencies>` section of your project's `pom.xml` file:

```xml
<dependency>
  <groupId>com.foundationdb</groupId>
  <artifactId>fdb-sql-layer-jdbc</artifactId>
  <version>1.9-3-jdbc41</version>
</dependency>
```


### Direct Download

For convenience, direct links to the `jar` files of the latest release are below:

- [1.9-3 - Java 6 / JDBC 4.0](http://search.maven.org/remotecontent?filepath=com/foundationdb/fdb-sql-layer-jdbc/1.9-3-jdbc4/fdb-sql-layer-jdbc-1.9-3-jdbc4.jar)
- [1.9-3 - Java 7 / JDBC 4.1](http://search.maven.org/remotecontent?filepath=com/foundationdb/fdb-sql-layer-jdbc/1.9-3-jdbc41/fdb-sql-layer-jdbc-1.9-3-jdbc41.jar)


### Building

Compiling the driver from scratch requires
[JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
(>= 6) and the [Apache Ant](http://ant.apache.org/index.html) build tool.

1. Clone
    - `git clone git@github.com:FoundationDB/sql-layer-jdbc.git`
2. Build
    - `ant clean maven-jar`
    - The `jars/` directory will contain `fdb-sql-layer-jdbc-x.y-b.jar`

If you would like to build a Java 6 compatible driver when using JDK7, pass the
`java.target` parameter:

`ant clean maven-jar -Djava.target=1.6`

*Note*: Once the driver has been built, it will work on ALL platforms that
support that version of the API. You *do not* need to build it for each
platform.


## Using the Driver

### JDBC URL Syntax

The driver recognizes JDBC URLs of the form:

    # Default localhost and port
    jdbc:fdbsql:schema

    # Default port
    jdbc:fdbsql://host/schema

    # Fully specified
    jdbc:fdbsql://host:port/schema

The default host and port, if omitted, are `localhost` and `15432`.

The username and password can also be supplied as arguments appended to the URL:

    jdbc:fdbsql:schema?user=me
    jdbc:fdbsql:schema?user=me&password=mypass


### Classpath

To use the driver, the jar file must be in the `classpath`. Note that projects
using a build tool (e.g. Maven) can generally skip this section.

On Linix based systems, the simplest way is to `export` it into the current
environment. For example, to use the SQL Layer bundled jar file on Linux:

```
$ export CLASSPATH=".:/usr/share/foundationdb/sql/client/fdb-sql-layer-jdbc-1.9-3-jdbc41.jar"
$ javac MyClass.java
$ java MyClass
```

Consult the [PATH and CLASSPATH Tutorial](http://docs.oracle.com/javase/tutorial/essential/environment/paths.html)
for more details.


### Code

1. Automatic (Recommended Method)

    As of Java 6, any driver in the classpath can be used directly via the
    URL. The JVM handles all class lookup and loading automatically. For
    example, to open a connection to the `test` schema on `localhost`:

    ```java
    try {
        Connection conn = DriverManager.getConnection("jdbc:fdbsql:test");
    } catch(SQLException e) {
        // Driver not found
    }
    ```

    As the catch clause above indicates, `getConnection()` will throw a
    SQLException if the driver corresponding to the URL isn't in the classpath.

2. Manual

    Alternatively, the driver can be manually loaded before any connection
    attempt is made. As mentioned above, *this is not required*.

    ```java
    try {
        Class.forName("com.foundationdb.sql.jdbc.Driver");
    } catch(ClassNotFoundException e) {
        // Driver not found
    }
    ```

   Remember, this method restricts your program to just this driver.

3. Parameters

   Lastly, the JVM supports specifiying the driver from the command line via
   the `jdbc.drivers` system property. For example, to run the class `Main`
   with this driver:

    `$ java -Djdbc.drivers=com.foundationdb.sql.jdbc.Driver Main`

   Note that JVM *will still start* if the driver could not be found and your
   first `getConnection()` attempt will throw an exception.


## More Information

For a full guide on how to use JDBC, refer to the official
[documentation](http://www.oracle.com/technetwork/java/javase/jdbc/)
and [tutorial](http://docs.oracle.com/javase/tutorial/jdbc/).


## Contributing

1. Fork
2. Branch
3. Commit
4. Pull Request

Thanks! Please make sure any changes come with new tests.


## Contact

* Community: http://community.foundationdb.com
* IRC: #FoundationDB on irc.freenode.net


## License

BSD 3-Clause License  
Copyright (c) 2013-2014 FoundationDB, LLC
It is free software and may be redistributed under the terms specified
in the LICENSE file.

