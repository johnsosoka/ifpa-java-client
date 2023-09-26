package com.johnsosoka.ifpa;

import com.johnsosoka.ifpa.core.BaseApiClient;
import com.johnsosoka.ifpa.core.EventTerms;
import com.johnsosoka.ifpa.exception.IFPAException;
import com.johnsosoka.ifpa.core.PlayerSearchTerms;
import com.johnsosoka.ifpa.model.player.*;
import com.johnsosoka.ifpa.model.tournament.TournamentResponse;
import com.johnsosoka.ifpa.model.tournament.TournamentResultResponse;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
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

    public TournamentResponse getTournament(String tournamentId) throws IFPAException {
        String url = BASE_API_URL + TOURNAMENT + PATH_SEPARATOR + tournamentId;
        return httpGET(url, TournamentResponse.class);
    }


    public TournamentResultResponse getTournamentResults(String tournamentId) throws IFPAException {
        return getTournamentResults(tournamentId, null);
    }

    public TournamentResultResponse getTournamentResults(String tournamentId, EventTerms eventTerms) throws IFPAException {
        if (StringUtils.isEmpty(tournamentId)) {
            throw new IFPAException("Tournament ID cannot be null or empty");
        }

        String url = BASE_API_URL + TOURNAMENT + PATH_SEPARATOR + tournamentId + RESULTS;
        Map<String, String> params = new HashMap<>();

        // Check if eventTerms is not null
        if (eventTerms != null) {
            // Check if eventId is available
            if (eventTerms.getEventId() != null && !eventTerms.getEventId().isEmpty()) {
                params.put("event_id", eventTerms.getEventId());
            }

            // Check if tourDate is available
            if (eventTerms.getTourDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedTourDate = sdf.format(eventTerms.getTourDate());
                params.put("tour_date", formattedTourDate);
            }
        }

        return httpGET(url, TournamentResultResponse.class, null, params);
    }

}
