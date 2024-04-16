package de.danielsogl.plugins.installreferrer;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "InstallReferrer")
public class InstallReferrerPlugin extends Plugin {
    private InstallReferrer implementation = new InstallReferrer();

    @PluginMethod
    public void getReferrerDetails(PluginCall call) {
        call.setKeepAlive(true);

        try {
            JSObject resolveData = implementation.getReferrerDetails(getContext());
            call.resolve(resolveData);
            call.release(getBridge());
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }
}