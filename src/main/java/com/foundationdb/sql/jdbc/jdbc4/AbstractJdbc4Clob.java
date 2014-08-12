/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;

import java.io.Reader;
import java.sql.SQLException;

public abstract class AbstractJdbc4Clob extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Clob
{

    public AbstractJdbc4Clob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws SQLException
    {
        super(conn, oid);
    }

    public synchronized Reader getCharacterStream(long pos, long length) throws SQLException
    {
        checkFreed();
        throw com.foundationdb.sql.jdbc.Driver.notImplemented(this.getClass(), "getCharacterStream(long, long)");
    }

}
