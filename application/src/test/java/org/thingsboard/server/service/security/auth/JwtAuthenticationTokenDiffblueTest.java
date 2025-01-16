package org.thingsboard.server.service.security.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.token.RawAccessJwtToken;

class JwtAuthenticationTokenDiffblueTest {
  /**
   * Test {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then Authorities return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test new JwtAuthenticationToken(SecurityUser); given ArrayList(); then Authorities return List")
  void testNewJwtAuthenticationToken_givenArrayList_thenAuthoritiesReturnList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    JwtAuthenticationToken actualJwtAuthenticationToken = new JwtAuthenticationToken(securityUser);

    // Assert
    verify(securityUser).getAuthorities();
    Collection<GrantedAuthority> authorities = actualJwtAuthenticationToken.getAuthorities();
    assertTrue(authorities instanceof List);
    assertNull(actualJwtAuthenticationToken.getDetails());
    assertNull(actualJwtAuthenticationToken.getCredentials());
    assertTrue(authorities.isEmpty());
    assertTrue(actualJwtAuthenticationToken.isAuthenticated());
    assertSame(securityUser, actualJwtAuthenticationToken.getPrincipal());
  }

  /**
   * Test
   * {@link JwtAuthenticationToken#JwtAuthenticationToken(RawAccessJwtToken)}.
   * <ul>
   *   <li>Then Credentials return {@link RawAccessJwtToken}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtAuthenticationToken#JwtAuthenticationToken(RawAccessJwtToken)}
   */
  @Test
  @DisplayName("Test new JwtAuthenticationToken(RawAccessJwtToken); then Credentials return RawAccessJwtToken")
  void testNewJwtAuthenticationToken_thenCredentialsReturnRawAccessJwtToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RawAccessJwtToken unsafeToken = new RawAccessJwtToken("ABC123");

    // Act
    JwtAuthenticationToken actualJwtAuthenticationToken = new JwtAuthenticationToken(unsafeToken);

    // Assert
    Collection<GrantedAuthority> authorities = actualJwtAuthenticationToken.getAuthorities();
    assertTrue(authorities instanceof List);
    Object credentials = actualJwtAuthenticationToken.getCredentials();
    assertTrue(credentials instanceof RawAccessJwtToken);
    assertEquals("", actualJwtAuthenticationToken.getName());
    assertEquals("ABC123", ((RawAccessJwtToken) credentials).getToken());
    assertNull(actualJwtAuthenticationToken.getDetails());
    assertNull(actualJwtAuthenticationToken.getPrincipal());
    assertFalse(actualJwtAuthenticationToken.isAuthenticated());
    assertTrue(authorities.isEmpty());
    assertSame(unsafeToken, credentials);
  }

  /**
   * Test
   * {@link JwtAuthenticationToken#JwtAuthenticationToken(RawAccessJwtToken)}.
   * <ul>
   *   <li>Then return Credentials is {@link RawAccessJwtToken}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtAuthenticationToken#JwtAuthenticationToken(RawAccessJwtToken)}
   */
  @Test
  @DisplayName("Test new JwtAuthenticationToken(RawAccessJwtToken); then return Credentials is RawAccessJwtToken")
  void testNewJwtAuthenticationToken_thenReturnCredentialsIsRawAccessJwtToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RawAccessJwtToken unsafeToken = mock(RawAccessJwtToken.class);

    // Act
    JwtAuthenticationToken actualJwtAuthenticationToken = new JwtAuthenticationToken(unsafeToken);

    // Assert
    Collection<GrantedAuthority> authorities = actualJwtAuthenticationToken.getAuthorities();
    assertTrue(authorities instanceof List);
    assertEquals("", actualJwtAuthenticationToken.getName());
    assertNull(actualJwtAuthenticationToken.getDetails());
    assertNull(actualJwtAuthenticationToken.getPrincipal());
    assertFalse(actualJwtAuthenticationToken.isAuthenticated());
    assertTrue(authorities.isEmpty());
    assertSame(unsafeToken, actualJwtAuthenticationToken.getCredentials());
  }
}
