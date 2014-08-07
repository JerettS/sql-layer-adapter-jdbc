/*-------------------------------------------------------------------------
*
* Copyright (c) 2005-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3g;

import java.sql.ParameterMetaData;

import com.foundationdb.sql.jdbc.core.BaseConnection;

public class Jdbc3gParameterMetaData extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3ParameterMetaData implements ParameterMetaData {

    public Jdbc3gParameterMetaData(BaseConnection connection, int oids[])
    {
        super(connection, oids);
    }

}

