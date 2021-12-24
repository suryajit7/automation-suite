package com.automation.framework.util.service;

import com.automation.framework.core.annotation.LazyService;
import org.springframework.beans.factory.annotation.Value;

@LazyService
public class PropertyDecryptService {

    @Value("${app.spotify.client-Id")
    private String spotifyClientId;

    @Value("${app.spotify.client-secret}")
    private String spotifyClientSecret;

    @Value("${app.spotify.key}")
    private String spotifyAccessToken;

    @Value("${app.spotify.refresh-token}")
    private String spotifyRefreshToken;

    @Value("${app.spotify.expired-key}")
    private String spotifyExpiredAccessToken;

    public String getSpotifyClientId() {
        return spotifyClientId;
    }

    public String getSpotifyClientSecret() {
        return spotifyClientSecret;
    }

    public String getSpotifyRefreshToken() {
        return spotifyRefreshToken;
    }

    public String getSpotifyAccessToken(Boolean expiredToken) {
        return expiredToken ? spotifyExpiredAccessToken : spotifyAccessToken;
    }


}
