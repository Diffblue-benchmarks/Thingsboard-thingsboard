package org.thingsboard.server.service.security.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.security.model.SecurityUser;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AbstractJwtAuthenticationTokenDiffblueTest {
  @Autowired
  private AbstractJwtAuthenticationToken abstractJwtAuthenticationToken;

  @MockBean
  private JwtAuthenticationToken jwtAuthenticationToken;

  /**
   * Test {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}.
   * <ul>
   *   <li>Then not
   * {@link JwtAuthenticationToken#JwtAuthenticationToken(SecurityUser)} with
   * {@link SecurityUser} Authenticated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}
   */
  @Test
  @DisplayName("Test setAuthenticated(boolean); then not JwtAuthenticationToken(SecurityUser) with SecurityUser Authenticated")
  void testSetAuthenticated_thenNotJwtAuthenticationTokenWithSecurityUserAuthenticated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractJwtAuthenticationToken#setAuthenticated(boolean)}
   */
  @Test
  @DisplayName("Test setAuthenticated(boolean); then throw IllegalArgumentException")
  void testSetAuthenticated_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link SecurityUser} {@link SecurityUser#getAuthorities()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJwtAuthenticationToken#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials(); given SecurityUser getAuthorities() return ArrayList(); then return 'null'")
  void testGetCredentials_givenSecurityUserGetAuthoritiesReturnArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  void testGetPrincipal_thenCallsGetAuthorities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  void testEraseCredentials() {
    // Arrange
    doNothing().when(jwtAuthenticationToken).eraseCredentials();

    // Act
    abstractJwtAuthenticationToken.eraseCredentials();

    // Assert that nothing has changed
    verify(jwtAuthenticationToken).eraseCredentials();
  }
}
