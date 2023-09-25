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

### Searching for Player

**Searching by Email**
```java
PlayerSearchTerms playerSearchTerms = new PlayerSearchTerms();

playerSearchTerms.setEmail("john.sosoka@gmail.com");
PlayerSearchResponse searchResult = client.playerSearch(playerSearchTerms);
```

**Searching by Name**

```java
PlayerSearchTerms playerSearchTerms = new PlayerSearchTerms();

playerSearchTerms.setFullName("John Sosoka");
PlayerSearchResponse searchResult = client.playerSearch(playerSearchTerms);
```

### Player PVP Results

```java
PlayerPvpResponse pvpResult = client.getPlayerPvp("50104");
```

### Player Tournament Results

```java
PlayerTournamentResponse tournamentResponse = client.getPlayerTournaments("50104");
```

### Country Directors

```java
CountryDirectorSearchResponse countryDirectors = client.getCountryDirectors();
```

### Player History

```java
PlayerHistoryResponse playerHistory = client.getPlayerHistory("50104");
```