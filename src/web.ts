import { WebPlugin } from '@capacitor/core';

import type { InstallReferrerPlugin } from './definitions';

export class InstallReferrerWeb
  extends WebPlugin
  implements InstallReferrerPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
