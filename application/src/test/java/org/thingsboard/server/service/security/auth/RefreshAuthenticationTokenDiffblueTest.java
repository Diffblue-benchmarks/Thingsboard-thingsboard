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

class RefreshAuthenticationTokenDiffblueTest {
  /**
   * Test {@link RefreshAuthenticationToken#RefreshAuthenticationToken(RawAccessJwtToken)}.
   * <p>
   * Method under test: {@link RefreshAuthenticationToken#RefreshAuthenticationToken(RawAccessJwtToken)}
   */
  @Test
  @DisplayName("Test new RefreshAuthenticationToken(RawAccessJwtToken)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RefreshAuthenticationToken.<init>(RawAccessJwtToken)"})
  void testNewRefreshAuthenticationToken() {
    // Arrange
    RawAccessJwtToken unsafeToken = new RawAccessJwtToken("ABC123");

    // Act
    RefreshAuthenticationToken actualRefreshAuthenticationToken = new RefreshAuthenticationToken(unsafeToken);

    // Assert
    Collection<GrantedAuthority> authorities = actualRefreshAuthenticationToken.getAuthorities();
    assertTrue(authorities instanceof List);
    Object credentials = actualRefreshAuthenticationToken.getCredentials();
    assertTrue(credentials instanceof RawAccessJwtToken);
    assertEquals("", actualRefreshAuthenticationToken.getName());
    assertEquals("ABC123", ((RawAccessJwtToken) credentials).getToken());
    assertNull(actualRefreshAuthenticationToken.getDetails());
    assertNull(actualRefreshAuthenticationToken.getPrincipal());
    assertFalse(actualRefreshAuthenticationToken.isAuthenticated());
    assertTrue(authorities.isEmpty());
    assertSame(unsafeToken, credentials);
  }

  /**
   * Test {@link RefreshAuthenticationToken#RefreshAuthenticationToken(SecurityUser)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then Authorities return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshAuthenticationToken#RefreshAuthenticationToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test new RefreshAuthenticationToken(SecurityUser); given ArrayList(); then Authorities return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RefreshAuthenticationToken.<init>(SecurityUser)"})
  void testNewRefreshAuthenticationToken_givenArrayList_thenAuthoritiesReturnList() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    RefreshAuthenticationToken actualRefreshAuthenticationToken = new RefreshAuthenticationToken(securityUser);

    // Assert
    verify(securityUser).getAuthorities();
    Collection<GrantedAuthority> authorities = actualRefreshAuthenticationToken.getAuthorities();
    assertTrue(authorities instanceof List);
    assertNull(actualRefreshAuthenticationToken.getDetails());
    assertNull(actualRefreshAuthenticationToken.getCredentials());
    assertTrue(authorities.isEmpty());
    assertTrue(actualRefreshAuthenticationToken.isAuthenticated());
    assertSame(securityUser, actualRefreshAuthenticationToken.getPrincipal());
  }
}
