package de.danielsogl.plugins.installreferrer;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.getcapacitor.JSObject;

public class InstallReferrer {

    private InstallReferrerClient referrerClient;

    public JSObject getReferrerDetails(Context context) throws RemoteException {
        JSObject resolveData = new JSObject();
        referrerClient = InstallReferrerClient.newBuilder(context).build();
        referrerClient.startConnection(
            new InstallReferrerStateListener() {
                @Override
                public void onInstallReferrerSetupFinished(int responseCode) {
                    Log.i("InstallReferrerResponse", String.valueOf(responseCode));
                    switch (responseCode) {
                        case InstallReferrerClient.InstallReferrerResponse.OK:
                            // Connection established.
                            try {
                                ReferrerDetails response = referrerClient.getInstallReferrer();
                                String referrerUrl = response.getInstallReferrer();
                                long referrerClickTime = response.getReferrerClickTimestampSeconds();
                                long appInstallTime = response.getInstallBeginTimestampSeconds();
                                boolean instantExperienceLaunched = response.getGooglePlayInstantParam();
                                resolveData.put("referrerUrl", referrerUrl);
                                resolveData.put("referrerClickTime", referrerClickTime);
                                resolveData.put("appInstallTime", appInstallTime);
                                resolveData.put("instantExperienceLaunched", instantExperienceLaunched);
                            } catch (RemoteException e) {
                                Log.e("InstallReferrerError", "Cannot get ReferrerDetails", e);
                            }
                            break;
                        case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                            // API not available on the current Play Store app.
                            Log.e("InstallReferrerError", "Cannot get ReferrerDetails: FEATURE_NOT_SUPPORTED");
                            break;
                        case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                            // Connection couldn't be established.
                            Log.e("InstallReferrerError", "Cannot get ReferrerDetails: SERVICE_UNAVAILABLE");
                            break;
                    }
                    referrerClient.endConnection();
                }

                @Override
                public void onInstallReferrerServiceDisconnected() {
                    // Try to restart the connection on the next request to
                    // Google Play by calling the startConnection() method.
                }
            }
        );
        return resolveData;
    }
}
