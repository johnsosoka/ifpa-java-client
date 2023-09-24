# ifpa-java-client

A Java client for the [IFPA API](https://www.ifpapinball.com/api/documentation/). The API makes most
of the data available on the IFPA website available via a REST API. This client is a wrapper around said API.
It is worth noting that the IFPA API Docs are not always up-to-date. This client has been tested against the API
and may have some fields that are not documented.

## Usage

Before using the client, you'll need to request an API key from the IFPA. Once you have your API key, you can
initialize the client.

### Initializing the client

```java
IFPAClient client = new IFPAClient("<api_key>");
```

### Getting Player Information

```java
PlayerProfileResponse playerProfileResponse = client.getPlayerProfile("50104");
```
