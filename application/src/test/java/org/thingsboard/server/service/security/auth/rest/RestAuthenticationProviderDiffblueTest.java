package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.thingsboard.server.service.security.auth.JwtAuthenticationToken;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class RestAuthenticationProviderDiffblueTest {
  @InjectMocks
  private RestAuthenticationProvider restAuthenticationProvider;

  /**
   * Test {@link RestAuthenticationProvider#authenticate(Authentication)}.
   * <p>
   * Method under test: {@link RestAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication RestAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticate() throws AuthenticationException {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    Class<Authentication> originalAuthentication = Authentication.class;

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> restAuthenticationProvider
        .authenticate(new RunAsUserToken("Key", "Principal", "Credentials", authorities, originalAuthentication)));
  }

  /**
   * Test {@link RestAuthenticationProvider#authenticate(Authentication)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link SecurityUser#getAuthorities()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication); given ArrayList(); then calls getAuthorities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication RestAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticate_givenArrayList_thenCallsGetAuthorities() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(BadCredentialsException.class,
        () -> restAuthenticationProvider.authenticate(new JwtAuthenticationToken(securityUser)));
    verify(securityUser).getAuthorities();
  }

  /**
   * Test {@link RestAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationProvider.supports(Class)"})
  void testSupports_thenReturnTrue() {
    // Arrange
    Class<UsernamePasswordAuthenticationToken> authentication = UsernamePasswordAuthenticationToken.class;

    // Act and Assert
    assertTrue(restAuthenticationProvider.supports(authentication));
  }

  /**
   * Test {@link RestAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationProvider.supports(Class)"})
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> authentication = Object.class;

    // Act and Assert
    assertFalse(restAuthenticationProvider.supports(authentication));
  }
}
