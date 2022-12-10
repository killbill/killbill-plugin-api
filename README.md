# killbill-plugin-api
![Maven Central](https://img.shields.io/maven-central/v/org.kill-bill.billing.plugin/killbill-plugin-api?color=blue&label=Maven%20Central)

Kill Bill plugin APIs.

## Kill Bill compatibility

| API version | Kill Bill version |
| ----------: | ----------------: |
| 0.18.y      | 0.16.z            |
| 0.23.y      | 0.18.z            |
| 0.24.y      | 0.19.z            |
| 0.25.y      | 0.20.z            |
| 0.26.y      | 0.22.z            |
| 0.27.y      | 0.24.z            |

## Usage

Add the relevant submodule(s) to a project:

```xml
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-catalog</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-control</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-currency</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-entitlement</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-invoice</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-notification</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-payment</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin</groupId>
    <artifactId>killbill-plugin-api-usage</artifactId>
    <version>... release version ...</version>
</dependency>
```

## About

Kill Bill is the leading Open-Source Subscription Billing & Payments Platform. For more information about the project, go to https://killbill.io/.
