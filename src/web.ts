import { WebPlugin } from '@capacitor/core';

import type {
  InstallReferrerPlugin,
  InstallReferrerPluginResult,
} from './definitions';

export class InstallReferrerWeb
  extends WebPlugin
  implements InstallReferrerPlugin
{
  public getReferrerDetails(): Promise<InstallReferrerPluginResult> {
    throw this.unimplemented('Not implemented on web');
  }
}
