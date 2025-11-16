/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rest.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.thingsboard.server.common.data.Customer;

class RestClientDiffblueTest {
  /**
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestClient.<init>(RestTemplate, String)"})
  void testNewRestClient() {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getRequestFactory()).thenThrow(new HttpClientErrorException(HttpStatus.OK));

    // Act and Assert
    assertThrows(
        HttpClientErrorException.class,
        () -> new RestClient(restTemplate, "https://example.org/example"));
    verify(restTemplate).getRequestFactory();
  }

  /**
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestClient.<init>(RestTemplate, String)"})
  void testNewRestClient3() {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getInterceptors()).thenThrow(new HttpClientErrorException(HttpStatus.OK));
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));

    // Act and Assert
    assertThrows(
        HttpClientErrorException.class,
        () -> new RestClient(restTemplate, "https://example.org/example"));
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
  }

  /**
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestClient.<init>(RestTemplate, String)"})
  void testNewRestClient4() {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getRequestFactory()).thenThrow(new HttpClientErrorException(HttpStatus.OK));

    // Act and Assert
    assertThrows(
        HttpClientErrorException.class,
        () -> new RestClient(restTemplate, "https://example.org/example"));
    verify(restTemplate).getRequestFactory();
  }

  /**
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestClient.<init>(RestTemplate, String)"})
  void testNewRestClient5() {
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
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   *
   * <p>Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestClient.<init>(RestTemplate, String)"})
  void testNewRestClient6() {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getInterceptors()).thenThrow(new HttpClientErrorException(HttpStatus.OK));
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));

    // Act and Assert
    assertThrows(
        HttpClientErrorException.class,
        () -> new RestClient(restTemplate, "https://example.org/example"));
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
  }

  /**
   * Test {@link RestClient#createCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestClient#createCustomer(Customer)}
   */
  @Test
  @DisplayName("Test createCustomer(Customer) with 'customer'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer RestClient.createCustomer(Customer)"})
  void testCreateCustomerWithCustomer_thenReturnNull()
      throws UnknownHostException, RestClientException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      RestTemplate restTemplate = mock(RestTemplate.class);
      when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
      when(restTemplate.postForEntity(
              Mockito.<String>any(),
              Mockito.<Object>any(),
              Mockito.<Class<Customer>>any(),
              isA(Object[].class)))
          .thenReturn(new ResponseEntity<>(HttpStatus.OK));
      when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));
      RestClient restClient = new RestClient(restTemplate, "https://example.org/example");

      // Act
      Customer actualCreateCustomerResult = restClient.createCustomer(new Customer());

      // Assert
      verify(restTemplate).getInterceptors();
      verify(restTemplate).getRequestFactory();
      verify(restTemplate)
          .postForEntity(
              eq("https://example.org/example/api/customer"),
              isA(Object.class),
              isA(Class.class),
              isA(Object[].class));
      assertNull(actualCreateCustomerResult);
    }
  }
}
