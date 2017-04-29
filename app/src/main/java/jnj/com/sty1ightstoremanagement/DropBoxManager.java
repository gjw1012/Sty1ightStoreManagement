package jnj.com.sty1ightstoremanagement;

import android.app.Activity;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

/**
 * Created by gjw on 2017-04-29.
 */

public class DropBoxManager extends Activity
{
    final static private String APP_KEY = "3ypfwo7vtnfd7t5";
    final static private String APP_SECRET = "xhugpau3102bdlj";

    // In the class declaration section:
    private DropboxAPI<AndroidAuthSession> mDBApi;

    public void DropboxInit()
    {
        // And later in some initialization function:
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);
        mDBApi.getSession().startOAuth2Authentication(DropBoxManager.this);
    }
}
