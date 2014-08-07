/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc2;

import java.sql.SQLException;

import com.foundationdb.sql.jdbc.core.BaseConnection;

public abstract class AbstractJdbc2Blob extends AbstractJdbc2BlobClob
{

    public AbstractJdbc2Blob(BaseConnection conn, long oid) throws SQLException
    {
        super(conn, oid);
    }

}
