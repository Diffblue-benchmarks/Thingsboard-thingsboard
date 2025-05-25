package org.thingsboard.server.service.security.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.service.security.model.SecurityUser;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class AbstractJwtAuthenticationTokenDiffblueTest {
  /**
   * Test {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}.
   * <ul>
   *   <li>Then not {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)} with {@link SecurityUser} Authenticated.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}
   */
  @Test
  @DisplayName("Test setAuthenticated(boolean); then not JwtAuthenticationToken(SecurityUser) with SecurityUser Authenticated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractJwtAuthenticationToken.setAuthenticated(boolean)"})
  void testSetAuthenticated_thenNotJwtAuthenticationTokenWithSecurityUserAuthenticated() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());
    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(securityUser);

    // Act
    jwtAuthenticationToken.setAuthenticated(false);

    // Assert
    verify(securityUser).getAuthorities();
    assertFalse(jwtAuthenticationToken.isAuthenticated());
  }

  /**
   * Test {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}
   */
  @Test
  @DisplayName("Test setAuthenticated(boolean); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractJwtAuthenticationToken.setAuthenticated(boolean)"})
  void testSetAuthenticated_thenThrowIllegalArgumentException() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new JwtAuthenticationToken(securityUser)).setAuthenticated(true));
    verify(securityUser).getAuthorities();
  }

  /**
   * Test {@link AbstractJwtAuthenticationToken#getCredentials()}.
   * <ul>
   *   <li>Given {@link SecurityUser} {@link SecurityUser#getAuthorities()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials(); given SecurityUser getAuthorities() return ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AbstractJwtAuthenticationToken.getCredentials()"})
  void testGetCredentials_givenSecurityUserGetAuthoritiesReturnArrayList_thenReturnNull() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    Object actualCredentials = (new JwtAuthenticationToken(securityUser)).getCredentials();

    // Assert
    verify(securityUser).getAuthorities();
    assertNull(actualCredentials);
  }

  /**
   * Test {@link AbstractJwtAuthenticationToken#getPrincipal()}.
   * <ul>
   *   <li>Then calls {@link SecurityUser#getAuthorities()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#getPrincipal()}
   */
  @Test
  @DisplayName("Test getPrincipal(); then calls getAuthorities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AbstractJwtAuthenticationToken.getPrincipal()"})
  void testGetPrincipal_thenCallsGetAuthorities() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    (new JwtAuthenticationToken(securityUser)).getPrincipal();

    // Assert
    verify(securityUser).getAuthorities();
  }

  /**
   * Test {@link AbstractJwtAuthenticationToken#eraseCredentials()}.
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#eraseCredentials()}
   */
  @Test
  @DisplayName("Test eraseCredentials()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractJwtAuthenticationToken.eraseCredentials()"})
  void testEraseCredentials() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());
    SecurityUser securityUser2 = mock(SecurityUser.class);
    when(securityUser2.getAuthorities()).thenReturn(new ArrayList<>());
    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(securityUser2);

    JwtAuthenticationToken jwtAuthenticationToken2 = new JwtAuthenticationToken(securityUser);
    jwtAuthenticationToken2.setDetails(jwtAuthenticationToken);

    // Act
    jwtAuthenticationToken2.eraseCredentials();

    // Assert
    verify(securityUser).getAuthorities();
    verify(securityUser2).getAuthorities();
  }

  /**
   * Test {@link AbstractJwtAuthenticationToken#eraseCredentials()}.
   * <ul>
   *   <li>Given {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)} with {@link SecurityUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#eraseCredentials()}
   */
  @Test
  @DisplayName("Test eraseCredentials(); given JwtAuthenticationToken(SecurityUser) with SecurityUser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractJwtAuthenticationToken.eraseCredentials()"})
  void testEraseCredentials_givenJwtAuthenticationTokenWithSecurityUser() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    (new JwtAuthenticationToken(securityUser)).eraseCredentials();

    // Assert
    verify(securityUser).getAuthorities();
  }
}
