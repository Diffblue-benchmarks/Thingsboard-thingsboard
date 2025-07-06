package org.thingsboard.rest.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

class RestClientDiffblueTest {
  /**
   * Test {@link RestClient#RestClient(String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(String)}
   */
  @Test
  @DisplayName("Test new RestClient(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestClient.<init>(String)"})
  void testNewRestClient() {
    // Arrange and Act
    RestClient actualRestClient = new RestClient("https://example.org/example");

    // Assert
    RestTemplate restTemplate = actualRestClient.getRestTemplate();
    assertTrue(restTemplate.getRequestFactory() instanceof InterceptingClientHttpRequestFactory);
    RestTemplate restTemplate2 = actualRestClient.loginRestTemplate;
    assertTrue(restTemplate2.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
    assertTrue(restTemplate.getErrorHandler() instanceof DefaultResponseErrorHandler);
    assertTrue(restTemplate2.getErrorHandler() instanceof DefaultResponseErrorHandler);
    assertTrue(restTemplate.getUriTemplateHandler() instanceof DefaultUriBuilderFactory);
    assertTrue(restTemplate2.getUriTemplateHandler() instanceof DefaultUriBuilderFactory);
    assertEquals("https://example.org/example", actualRestClient.baseURL);
    assertNull(actualRestClient.getRefreshToken());
    assertNull(actualRestClient.getToken());
    assertNull(restTemplate.getObservationConvention());
    assertNull(restTemplate2.getObservationConvention());
    assertEquals(1, restTemplate.getInterceptors().size());
    assertEquals(5, restTemplate.getMessageConverters().size());
    assertEquals(5, restTemplate2.getMessageConverters().size());
    assertTrue(restTemplate.getClientHttpRequestInitializers().isEmpty());
    assertTrue(restTemplate2.getClientHttpRequestInitializers().isEmpty());
    assertTrue(restTemplate2.getInterceptors().isEmpty());
  }

  /**
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestClient.<init>(RestTemplate, String)"})
  void testNewRestClient2() {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));

    // Act
    RestClient actualRestClient = new RestClient(restTemplate, "https://example.org/example");

    // Assert
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
    RestTemplate restTemplate2 = actualRestClient.loginRestTemplate;
    assertTrue(restTemplate2.getErrorHandler() instanceof DefaultResponseErrorHandler);
    assertTrue(restTemplate2.getUriTemplateHandler() instanceof DefaultUriBuilderFactory);
    assertEquals("https://example.org/example", actualRestClient.baseURL);
    assertNull(actualRestClient.getMaxDatapointsLimit());
    assertNull(actualRestClient.getServerTime());
    assertNull(actualRestClient.getRefreshToken());
    assertNull(actualRestClient.getToken());
    assertNull(restTemplate2.getObservationConvention());
    assertEquals(5, restTemplate2.getMessageConverters().size());
    assertTrue(restTemplate2.getClientHttpRequestInitializers().isEmpty());
    assertTrue(restTemplate2.getInterceptors().isEmpty());
    assertSame(restTemplate, actualRestClient.getRestTemplate());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RestClient#getRefreshToken()}
   *   <li>{@link RestClient#getRestTemplate()}
   *   <li>{@link RestClient#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String RestClient.getRefreshToken()",
    "RestTemplate RestClient.getRestTemplate()",
    "String RestClient.getToken()"
  })
  void testGettersAndSetters() {
    // Arrange
    RestClient restClient = new RestClient("https://example.org/example");

    // Act
    String actualRefreshToken = restClient.getRefreshToken();
    RestTemplate actualRestTemplate = restClient.getRestTemplate();

    // Assert
    assertNull(actualRefreshToken);
    assertNull(restClient.getToken());
    assertSame(restClient.restTemplate, actualRestTemplate);
  }
}
