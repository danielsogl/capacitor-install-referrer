export interface InstallReferrerPlugin {
  getReferrerDetails(): Promise<InstallReferrerPluginResult>;
}

export interface InstallReferrerPluginResult {
  referrerUrl?: string;
  referrerClickTime?: number;
  appInstallTime?: number;
  instantExperienceLaunched?: boolean;
}
