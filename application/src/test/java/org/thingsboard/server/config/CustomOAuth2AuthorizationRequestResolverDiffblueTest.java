package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
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

@ExtendWith(MockitoExtension.class)
class CustomOAuth2AuthorizationRequestResolverDiffblueTest {
  @Mock private ClientRegistrationRepository clientRegistrationRepository;

  @InjectMocks
  private CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver;

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with
   * {@code request}, {@code registrationId}.
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"
  })
  void testResolveWithRequestRegistrationId() {
    // Arrange
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customOAuth2AuthorizationRequestResolver.resolve(new MockHttpServletRequest(), "42"));
    verify(clientRegistrationRepository).findByRegistrationId("42");
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with
   * {@code request}, {@code registrationId}.
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"
  })
  void testResolveWithRequestRegistrationId2() {
    // Arrange
    Builder withRegistrationIdResult = ClientRegistration.withRegistrationId("42");

    Builder authorizationUriResult =
        withRegistrationIdResult
            .authorizationGrantType(new AuthorizationGrantType("42"))
            .authorizationUri("JaneDoe");

    Builder clientSecretResult =
        authorizationUriResult
            .clientAuthenticationMethod(new ClientAuthenticationMethod("42"))
            .clientId("42")
            .clientName("Dr Jane Doe")
            .clientSecret("Client Secret");

    Builder registrationIdResult =
        clientSecretResult
            .providerConfigurationMetadata(new HashMap<>())
            .jwkSetUri("Jwk Set Uri")
            .redirectUri("Redirect Uri")
            .registrationId("42");

    Builder tokenUriResult = registrationIdResult.scope(new ArrayList<>()).tokenUri("ABC123");
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any()))
        .thenReturn(
            tokenUriResult
                .userInfoAuthenticationMethod(new AuthenticationMethod("42"))
                .userInfoUri("User Info Uri")
                .userNameAttributeName("janedoe")
                .build());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("action", "Request");
    request.addParameter("pkg", "");
    request.addParameter("appToken", "");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customOAuth2AuthorizationRequestResolver.resolve(request, "42"));
    verify(clientRegistrationRepository).findByRegistrationId("42");
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with
   * {@code request}, {@code registrationId}.
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"
  })
  void testResolveWithRequestRegistrationId3() {
    // Arrange
    Builder withRegistrationIdResult = ClientRegistration.withRegistrationId("42");

    Builder authorizationUriResult =
        withRegistrationIdResult
            .authorizationGrantType(new AuthorizationGrantType("42"))
            .authorizationUri("JaneDoe");

    Builder clientSecretResult =
        authorizationUriResult
            .clientAuthenticationMethod(new ClientAuthenticationMethod("42"))
            .clientId("42")
            .clientName("Dr Jane Doe")
            .clientSecret("Client Secret");

    Builder registrationIdResult =
        clientSecretResult
            .providerConfigurationMetadata(new HashMap<>())
            .jwkSetUri("Jwk Set Uri")
            .redirectUri("Redirect Uri")
            .registrationId("42");

    Builder tokenUriResult = registrationIdResult.scope(new ArrayList<>()).tokenUri("ABC123");
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any()))
        .thenReturn(
            tokenUriResult
                .userInfoAuthenticationMethod(new AuthenticationMethod("42"))
                .userInfoUri("User Info Uri")
                .userNameAttributeName("janedoe")
                .build());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("pkg", "Request");
    request.addParameter("pkg", "");
    request.addParameter("appToken", "");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customOAuth2AuthorizationRequestResolver.resolve(request, "42"));
    verify(clientRegistrationRepository).findByRegistrationId("42");
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with
   * {@code request}, {@code registrationId}.
   *
   * <ul>
   *   <li>Given {@code authorize}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName(
      "Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; given 'authorize'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"
  })
  void testResolveWithRequestRegistrationId_givenAuthorize() {
    // Arrange
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("action", "authorize");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customOAuth2AuthorizationRequestResolver.resolve(request, "42"));
    verify(clientRegistrationRepository).findByRegistrationId("42");
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with
   * {@code request}, {@code registrationId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName(
      "Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"
  })
  void testResolveWithRequestRegistrationId_thenReturnNull() {
    // Arrange
    CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver =
        new CustomOAuth2AuthorizationRequestResolver();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("action", "Request");
    request.addParameter("pkg", "");
    request.addParameter("appToken", "");

    // Act and Assert
    assertNull(customOAuth2AuthorizationRequestResolver.resolve(request, null));
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)} with
   * {@code request}, {@code registrationId}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName(
      "Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; when MockHttpServletRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest, String)"
  })
  void testResolveWithRequestRegistrationId_whenMockHttpServletRequest() {
    // Arrange
    Builder withRegistrationIdResult = ClientRegistration.withRegistrationId("42");

    Builder authorizationUriResult =
        withRegistrationIdResult
            .authorizationGrantType(new AuthorizationGrantType("42"))
            .authorizationUri("JaneDoe");

    Builder clientSecretResult =
        authorizationUriResult
            .clientAuthenticationMethod(new ClientAuthenticationMethod("42"))
            .clientId("42")
            .clientName("Dr Jane Doe")
            .clientSecret("Client Secret");

    Builder registrationIdResult =
        clientSecretResult
            .providerConfigurationMetadata(new HashMap<>())
            .jwkSetUri("Jwk Set Uri")
            .redirectUri("Redirect Uri")
            .registrationId("42");

    Builder tokenUriResult = registrationIdResult.scope(new ArrayList<>()).tokenUri("ABC123");
    when(clientRegistrationRepository.findByRegistrationId(Mockito.<String>any()))
        .thenReturn(
            tokenUriResult
                .userInfoAuthenticationMethod(new AuthenticationMethod("42"))
                .userInfoUri("User Info Uri")
                .userNameAttributeName("janedoe")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customOAuth2AuthorizationRequestResolver.resolve(new MockHttpServletRequest(), "42"));
    verify(clientRegistrationRepository).findByRegistrationId("42");
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)} with {@code
   * request}.
   *
   * <ul>
   *   <li>Given {@code action}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest) with 'request'; given 'action'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest)"
  })
  void testResolveWithRequest_givenAction() {
    // Arrange
    CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver =
        new CustomOAuth2AuthorizationRequestResolver();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("action", "Request");
    request.addParameter("pkg", "");
    request.addParameter("appToken", "");

    // Act and Assert
    assertNull(customOAuth2AuthorizationRequestResolver.resolve(request));
  }

  /**
   * Test {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)} with {@code
   * request}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest) with 'request'; when MockHttpServletRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest CustomOAuth2AuthorizationRequestResolver.resolve(HttpServletRequest)"
  })
  void testResolveWithRequest_whenMockHttpServletRequest() {
    // Arrange
    CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver =
        new CustomOAuth2AuthorizationRequestResolver();

    // Act and Assert
    assertNull(customOAuth2AuthorizationRequestResolver.resolve(new MockHttpServletRequest()));
  }
}
