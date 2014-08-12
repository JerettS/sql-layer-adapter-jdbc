/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;

import com.foundationdb.sql.jdbc.core.*;

public class Jdbc4ResultSetMetaData extends AbstractJdbc4ResultSetMetaData implements java.sql.ResultSetMetaData
{

    public Jdbc4ResultSetMetaData(BaseConnection connection, Field[] fields)
    {
        super(connection, fields);
    }

}

