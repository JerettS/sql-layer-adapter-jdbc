/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3;


public class Jdbc3Clob extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Clob implements java.sql.Clob
{

    public Jdbc3Clob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws java.sql.SQLException
    {
        super(conn, oid);
    }

}
