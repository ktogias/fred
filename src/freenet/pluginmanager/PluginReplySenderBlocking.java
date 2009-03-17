package freenet.pluginmanager;

import freenet.pluginmanager.PluginTalker.Result;
import freenet.support.Logger;
import freenet.support.SimpleFieldSet;
import freenet.support.api.Bucket;

public class PluginReplySenderBlocking extends PluginReplySender {

	protected volatile PluginTalker.Result mResult;

	public PluginReplySenderBlocking(String myPluginName, String myConnectionIdentifier) {
		super(myPluginName, myConnectionIdentifier);
	}

	@Override
	public synchronized void send(SimpleFieldSet params, Bucket bucket) {
		if(mResult == null) {
			mResult = new Result(params, bucket);
			notifyAll();
		} else {
			Logger.error(this, "PluginTalker.sendBlocking() is being used with a FCP call which results in more than 1 reply");
		}
	}

	public Result getResult() {
		while(mResult == null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		return mResult;
	}

}