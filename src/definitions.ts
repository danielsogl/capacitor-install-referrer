export interface InstallReferrerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
