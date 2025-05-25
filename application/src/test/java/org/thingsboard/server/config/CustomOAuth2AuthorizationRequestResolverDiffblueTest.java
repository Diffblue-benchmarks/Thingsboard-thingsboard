package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistration.Builder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

@ExtendWith(MockitoExtension.class)
class CustomOAuth2AuthorizationRequestResolverDiffblueTest {
  @Mock
  private ClientRegistrationRepository clientRegistrationRepository;

  @InjectMocks
  private CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver;

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with {@code request}, {@code registrationId}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; given empty string; then calls getParameter(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"})
  void testResolveWithRequestRegistrationId_givenEmptyString_thenCallsGetParameter() {
    // Arrange
    Builder withRegistrationIdResult = ClientRegistration.withRegistrationId("42");
    Builder authorizationUriResult = withRegistrationIdResult.authorizationGrantType(new AuthorizationGrantType("42"))
        .authorizationUri("JaneDoe");
    Builder clientSecretResult = authorizationUriResult.clientAuthenticationMethod(new ClientAuthenticationMethod("42"))
        .clientId("42")
        .clientName("Dr Jane Doe")
        .clientSecret("Client Secret");
    Builder registrationIdResult = clientSecretResult.providerConfigurationMetadata(new HashMap<>())
        .jwkSetUri("Jwk Set Uri")
        .redirectUri("Redirect Uri")
        .registrationId("42");
    Builder tokenUriResult = registrationIdResult.scope(new ArrayList<>()).tokenUri("ABC123");
    ClientRegistration buildResult = tokenUriResult.userInfoAuthenticationMethod(new AuthenticationMethod("42"))
        .userInfoUri("User Info Uri")
        .userNameAttributeName("janedoe")
        .build();
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any())).thenReturn(buildResult);
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customOAuth2AuthorizationRequestResolver.resolve(request, "42"));
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(clientRegistrationRepository).findByRegistrationId(eq("42"));
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with {@code request}, {@code registrationId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"})
  void testResolveWithRequestRegistrationId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(customOAuth2AuthorizationRequestResolver.resolve(mock(HttpServletRequestWrapper.class), null));
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with {@code request}, {@code registrationId}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; when MockHttpServletRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"})
  void testResolveWithRequestRegistrationId_whenMockHttpServletRequest() {
    // Arrange
    Builder withRegistrationIdResult = ClientRegistration.withRegistrationId("42");
    Builder authorizationUriResult = withRegistrationIdResult.authorizationGrantType(new AuthorizationGrantType("42"))
        .authorizationUri("JaneDoe");
    Builder clientSecretResult = authorizationUriResult.clientAuthenticationMethod(new ClientAuthenticationMethod("42"))
        .clientId("42")
        .clientName("Dr Jane Doe")
        .clientSecret("Client Secret");
    Builder registrationIdResult = clientSecretResult.providerConfigurationMetadata(new HashMap<>())
        .jwkSetUri("Jwk Set Uri")
        .redirectUri("Redirect Uri")
        .registrationId("42");
    Builder tokenUriResult = registrationIdResult.scope(new ArrayList<>()).tokenUri("ABC123");
    ClientRegistration buildResult = tokenUriResult.userInfoAuthenticationMethod(new AuthenticationMethod("42"))
        .userInfoUri("User Info Uri")
        .userNameAttributeName("janedoe")
        .build();
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any())).thenReturn(buildResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customOAuth2AuthorizationRequestResolver.resolve(new MockHttpServletRequest(), "42"));
    verify(clientRegistrationRepository).findByRegistrationId(eq("42"));
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)} with {@code request}.
   * <ul>
   *   <li>Given {@code Parameter}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest) with 'request'; given 'Parameter'; then calls getParameter(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest)"})
  void testResolveWithRequest_givenParameter_thenCallsGetParameter() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    when(request.getPathInfo()).thenReturn("https://example.org/example");
    when(request.getServletPath()).thenReturn("https://example.org/example");

    // Act
    OAuth2AuthorizationRequest actualResolveResult = customOAuth2AuthorizationRequestResolver.resolve(request);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(request).getPathInfo();
    verify(request).getServletPath();
    assertNull(actualResolveResult);
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)} with {@code request}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest) with 'request'; when MockHttpServletRequest(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest)"})
  void testResolveWithRequest_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(customOAuth2AuthorizationRequestResolver.resolve(new MockHttpServletRequest()));
  }
}
