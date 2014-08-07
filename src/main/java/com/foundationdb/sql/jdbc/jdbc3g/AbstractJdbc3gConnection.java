/*-------------------------------------------------------------------------
*
* Copyright (c) 2008-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3g;

import java.sql.SQLException;
import java.util.Properties;

import com.foundationdb.sql.jdbc.core.Oid;
import com.foundationdb.sql.jdbc.core.TypeInfo;
import com.foundationdb.sql.jdbc.util.HostSpec;

public abstract class AbstractJdbc3gConnection extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Connection
{

    public AbstractJdbc3gConnection(HostSpec[] hostSpecs, String user, String database, Properties info, String url) throws SQLException {
        super(hostSpecs, user, database, info, url);

        TypeInfo types = getTypeInfo();
        if (haveMinimumServerVersion("8.3")) {
            types.addCoreType("uuid", Oid.UUID, java.sql.Types.OTHER, "java.util.UUID", Oid.UUID_ARRAY);
        }
    }

}

