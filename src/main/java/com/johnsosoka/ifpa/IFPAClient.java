package com.johnsosoka.ifpa;

import com.johnsosoka.ifpa.core.BaseApiClient;
import com.johnsosoka.ifpa.exception.IFPAException;
import com.johnsosoka.ifpa.model.*;
import com.johnsosoka.ifpa.core.PlayerSearchTerms;

import java.util.HashMap;
import java.util.Map;

import static com.johnsosoka.ifpa.constants.Constants.*;

public class IFPAClient extends BaseApiClient {

    public IFPAClient(String apiKey) {
        super(apiKey);
    }

    public PlayerProfileResponse getPlayerProfile(String playerId) throws IFPAException {
        String url = BASE_API_URL + PLAYER + PATH_SEPARATOR + playerId;
        return httpGET(url, PlayerProfileResponse.class);
    }

    public PlayerHistoryResponse getPlayerHistory(String playerId) throws IFPAException {
        String url = BASE_API_URL + PLAYER + PATH_SEPARATOR + playerId + HISTORY;
        return httpGET(url, PlayerHistoryResponse.class);
    }


    public PlayerSearchResponse playerSearch(PlayerSearchTerms playerSearchTerms) throws IFPAException {
        String url = BASE_API_URL + PLAYER + SEARCH;
        Map<String, String> params = new HashMap<>();

        // Default to using the email if available
        if (playerSearchTerms.getEmail() != null && !playerSearchTerms.getEmail().isEmpty()) {
            params.put("email", playerSearchTerms.getEmail());
        } else {
            // Use the full name if email is not available
            String fullName = playerSearchTerms.getFullName();
            if (!fullName.isEmpty()) {
                params.put("q", fullName);
            } else {
                throw new IFPAException("No search terms provided");
            }
        }
        return httpGET(url, PlayerSearchResponse.class, null, params);
    }

    public PlayerPvpResponse getPlayerPvp(String playerId) throws IFPAException {
        String url = BASE_API_URL + PLAYER + PATH_SEPARATOR + playerId + PVP;
        return httpGET(url, PlayerPvpResponse.class);
    }

    public CountryDirectorSearchResponse getCountryDirectors() throws IFPAException {
        String url = BASE_API_URL + PLAYER + COUNTRY_DIRECTORS;
        return httpGET(url, CountryDirectorSearchResponse.class);
    }

    public PlayerTournamentResponse getPlayerTournaments(String playerId) throws IFPAException {
        String url = BASE_API_URL + PLAYER + PATH_SEPARATOR + playerId + RESULTS;
        return httpGET(url, PlayerTournamentResponse.class);
    }

}
