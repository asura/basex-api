package org.basex.http.rest;

import static org.basex.util.Token.*;

import org.basex.core.*;

/**
 * This class assembles texts which are used in the HTTP classes.
 *
 * @author BaseX Team 2005-12, BSD License
 * @author Christian Gruen
 */
public interface RESTText {
  /** REST string.  */
  byte[] REST = token("rest");
  /** REST URI. */
  byte[] RESTURI = concat(token(Text.URL), SLASH, REST);

  /** Element. */
  byte[] DATABASES = concat(REST, COLON, token("databases"));
  /** Element. */
  byte[] DATABASE = concat(REST, COLON, token("database"));
  /** Element. */
  byte[] RESOURCE = concat(REST, COLON, token("resource"));
  /** Attribute. */
  byte[] RESOURCES = token("resources");

  /** Command operation. */
  String COMMAND = "command";
  /** Run operation. */
  String RUN = "run";
  /** Query operation. */
  String QUERY = "query";

  /** Wrap parameter. */
  String WRAP = "wrap";
  /** Initial context. */
  String CONTEXT = "context";
}
