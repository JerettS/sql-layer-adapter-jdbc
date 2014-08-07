/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;


import java.sql.*;

public abstract class AbstractJdbc4Blob extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Blob
{

    public AbstractJdbc4Blob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws SQLException
    {
        super(conn, oid);
    }

    public synchronized java.io.InputStream getBinaryStream(long pos, long length) throws SQLException
    {
        checkFreed();
        throw org.postgresql.Driver.notImplemented(this.getClass(), "getBinaryStream(long, long)");
    }

}

