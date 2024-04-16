# @danielsogl/capacitor-install-referrer

Use the Google Play Store's Install Referrer API to securely retrieve referral content from Google Play

## Install

```bash
npm install @danielsogl/capacitor-install-referrer
npx cap sync
```

## API

<docgen-index>

* [`getReferrerDetails()`](#getreferrerdetails)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getReferrerDetails()

```typescript
getReferrerDetails() => Promise<InstallReferrerPluginResult>
```

**Returns:** <code>Promise&lt;<a href="#installreferrerpluginresult">InstallReferrerPluginResult</a>&gt;</code>

--------------------


### Interfaces


#### InstallReferrerPluginResult

| Prop                            | Type                 |
| ------------------------------- | -------------------- |
| **`referrerUrl`**               | <code>string</code>  |
| **`referrerClickTime`**         | <code>number</code>  |
| **`appInstallTime`**            | <code>number</code>  |
| **`instantExperienceLaunched`** | <code>boolean</code> |

</docgen-api>
