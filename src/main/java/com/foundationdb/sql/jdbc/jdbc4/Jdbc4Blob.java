/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;


import java.sql.*;

public class Jdbc4Blob extends AbstractJdbc4Blob implements java.sql.Blob
{

    public Jdbc4Blob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws SQLException
    {
        super(conn, oid);
    }

}
