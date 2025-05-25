package org.thingsboard.server.service.security.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.token.RawAccessJwtToken;

class JwtAuthenticationTokenDiffblueTest {
  /**
   * Test {@link JwtAuthenticationToken#JwtAuthenticationToken(RawAccessJwtToken)}.
   * <p>
   * Method under test: {@link JwtAuthenticationToken#JwtAuthenticationToken(RawAccessJwtToken)}
   */
  @Test
  @DisplayName("Test new JwtAuthenticationToken(RawAccessJwtToken)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JwtAuthenticationToken.<init>(RawAccessJwtToken)"})
  void testNewJwtAuthenticationToken() {
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
   * Test {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then Authorities return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test new JwtAuthenticationToken(SecurityUser); given ArrayList(); then Authorities return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JwtAuthenticationToken.<init>(SecurityUser)"})
  void testNewJwtAuthenticationToken_givenArrayList_thenAuthoritiesReturnList() {
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
}
