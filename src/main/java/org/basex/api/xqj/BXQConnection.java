package org.basex.api.xqj;

import static org.basex.api.xqj.BXQText.*;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQMetaData;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQStaticContext;
import org.basex.util.Token;

/**
 * Java XQuery API - Connection.
 *
 * @author Workgroup DBIS, University of Konstanz 2005-10, ISC License
 * @author Christian Gruen
 */
final class BXQConnection extends BXQDataFactory implements XQConnection {
  /** Database meta data. */
  private final BXQMetaData meta = new BXQMetaData(this);

  public void commit() throws XQException {
    opened();
    throw new BXQException(TRANS);
  }

  public XQExpression createExpression() throws XQException {
    return createExpression(ctx);
  }

  public XQExpression createExpression(final XQStaticContext sc)
      throws XQException {
    opened();
    valid(sc, XQStaticContext.class);
    return new BXQExpression((BXQStaticContext) sc, this);
  }

  public boolean getAutoCommit() {
    return true;
  }

  public XQMetaData getMetaData() throws XQException {
    opened();
    return meta;
  }

  public XQStaticContext getStaticContext() throws XQException {
    opened();
    return ctx;
  }

  public XQPreparedExpression prepareExpression(final InputStream is,
      final XQStaticContext sc) throws XQException {
    return prepareExpression(Token.string(content(is)), sc);
  }

  public XQPreparedExpression prepareExpression(final InputStream is)
      throws XQException {
    return prepareExpression(is, ctx);
  }

  public XQPreparedExpression prepareExpression(final Reader r,
      final XQStaticContext sc) throws XQException {
    return prepareExpression(Token.string(content(r)), sc);
  }

  public XQPreparedExpression prepareExpression(final Reader r)
      throws XQException {
    return prepareExpression(r, ctx);
  }

  public XQPreparedExpression prepareExpression(final String query,
      final XQStaticContext sc) throws XQException {
    opened();
    valid(sc, XQStaticContext.class);
    valid(query, String.class);
    final BXQStaticContext bsc = (BXQStaticContext) sc;
    return new BXQPreparedExpression(query, bsc, this);
  }

  public XQPreparedExpression prepareExpression(final String query)
      throws XQException {
    return prepareExpression(query, ctx);
  }

  public void rollback() throws XQException {
    opened();
    throw new BXQException(TRANS);
  }

  public void setAutoCommit(final boolean ac) throws XQException {
    opened();
    if(!ac) throw new BXQException(TRANS);
  }

  public void setStaticContext(final XQStaticContext sc) throws XQException {
    opened();
    valid(sc, XQStaticContext.class);
    ctx = (BXQStaticContext) sc;
  }
}