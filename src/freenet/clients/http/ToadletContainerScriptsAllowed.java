/* This code is part of Freenet. It is distributed under the GNU General
 *  * Public License, version 2 (or at your option any later version). See
 *   * http://www.gnu.org/ for further details of the GPL. */
package freenet.clients.http;

import java.io.File;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

import freenet.clients.http.FProxyFetchInProgress.REFILTER_POLICY;
import freenet.clients.http.PageMaker.THEME;
import freenet.pluginmanager.FredPluginL10n;
import freenet.support.HTMLNode;
import freenet.support.api.BucketFactory;

/** Interface for toadlet containers scripts allowed. Toadlets that supports the FProxyScriptsAllowed attribute should register here. */
public interface ToadletContainerScriptsAllowed extends  ToadletContainer{
	
        public boolean isFProxyScriptsAllowed();

}

