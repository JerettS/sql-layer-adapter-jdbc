/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3;


import java.sql.*;

public class Jdbc3Blob extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Blob implements java.sql.Blob
{

    public Jdbc3Blob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws SQLException
    {
        super(conn, oid);
    }

}
