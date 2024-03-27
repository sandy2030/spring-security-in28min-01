package com.learning.learnspringsecurity.basic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;

public class MyCustomCsrfTokenRepository implements CsrfTokenRepository {
    /**
     * Generates a {@link CsrfToken}
     *
     * @param request the {@link HttpServletRequest} to use
     * @return the {@link CsrfToken} that was generated. Cannot be null.
     */
    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        return null;
    }

    /**
     * Saves the {@link CsrfToken} using the {@link HttpServletRequest} and
     * {@link HttpServletResponse}. If the {@link CsrfToken} is null, it is the same as
     * deleting it.
     *
     * @param token    the {@link CsrfToken} to save or null to delete
     * @param request  the {@link HttpServletRequest} to use
     * @param response the {@link HttpServletResponse} to use
     */
    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * Loads the expected {@link CsrfToken} from the {@link HttpServletRequest}
     *
     * @param request the {@link HttpServletRequest} to use
     * @return the {@link CsrfToken} or null if none exists
     */
    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        return null;
    }
}
