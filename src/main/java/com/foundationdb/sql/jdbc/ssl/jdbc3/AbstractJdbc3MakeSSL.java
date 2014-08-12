/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.ssl.jdbc3;

import java.util.Properties;
import java.io.IOException;
import java.net.Socket;
import java.lang.reflect.Constructor;

import javax.net.ssl.SSLSocketFactory;

import com.foundationdb.sql.jdbc.core.Logger;
import com.foundationdb.sql.jdbc.core.PGStream;
import com.foundationdb.sql.jdbc.util.GT;
import com.foundationdb.sql.jdbc.util.PSQLException;
import com.foundationdb.sql.jdbc.util.PSQLState;

public class AbstractJdbc3MakeSSL {
    public static void convert(PGStream stream, Properties info, Logger logger) throws IOException, PSQLException {
        logger.debug("converting regular socket connection to ssl");

        SSLSocketFactory factory;

        // Use the default factory if no specific factory is requested
        //
        String classname = info.getProperty("sslfactory");
        if (classname == null)
        {
            factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        }
        else
        {
            Object[] args = {info.getProperty("sslfactoryarg")};
            Constructor ctor;
            Class factoryClass;

            try
            {
                factoryClass = Class.forName(classname);
                try
                {
                    ctor = factoryClass.getConstructor(new Class[]{String.class});
                }
                catch (NoSuchMethodException nsme)
                {
                    ctor = factoryClass.getConstructor((Class[])null);
                    args = null;
                }
                factory = (SSLSocketFactory)ctor.newInstance(args);
            }
            catch (Exception e)
            {
                throw new PSQLException(GT.tr("The SSLSocketFactory class provided {0} could not be instantiated.", classname), PSQLState.CONNECTION_FAILURE, e);
            }
        }

        Socket newConnection = factory.createSocket(stream.getSocket(), stream.getHostSpec().getHost(), stream.getHostSpec().getPort(), true);
        stream.changeSocket(newConnection);
    }

}


