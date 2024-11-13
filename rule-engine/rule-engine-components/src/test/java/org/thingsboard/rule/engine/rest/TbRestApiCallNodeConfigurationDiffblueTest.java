package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.credentials.AnonymousCredentials;
import org.thingsboard.rule.engine.credentials.ClientCredentials;
import org.thingsboard.rule.engine.credentials.CredentialsType;

class TbRestApiCallNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbRestApiCallNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbRestApiCallNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(mock(ClientCredentials.class));

    // Act
    TbRestApiCallNodeConfiguration actualDefaultConfigurationResult = tbRestApiCallNodeConfiguration
        .defaultConfiguration();

    // Assert
    ClientCredentials credentials = actualDefaultConfigurationResult.getCredentials();
    assertTrue(credentials instanceof AnonymousCredentials);
    assertEquals("POST", actualDefaultConfigurationResult.getRequestMethod());
    Map<String, String> headers = actualDefaultConfigurationResult.getHeaders();
    assertEquals(1, headers.size());
    assertEquals("application/json", headers.get("Content-Type"));
    assertEquals("http://localhost/api", actualDefaultConfigurationResult.getRestEndpointUrlPattern());
    assertNull(actualDefaultConfigurationResult.getProxyHost());
    assertNull(actualDefaultConfigurationResult.getProxyPassword());
    assertNull(actualDefaultConfigurationResult.getProxyScheme());
    assertNull(actualDefaultConfigurationResult.getProxyUser());
    assertEquals(0, actualDefaultConfigurationResult.getMaxParallelRequestsCount());
    assertEquals(0, actualDefaultConfigurationResult.getProxyPort());
    assertEquals(0, actualDefaultConfigurationResult.getReadTimeoutMs());
    assertEquals(256, actualDefaultConfigurationResult.getMaxInMemoryBufferSizeInKb());
    assertEquals(CredentialsType.ANONYMOUS, credentials.getType());
    assertFalse(actualDefaultConfigurationResult.isEnableProxy());
    assertFalse(actualDefaultConfigurationResult.isIgnoreRequestBody());
    assertFalse(actualDefaultConfigurationResult.isParseToPlainText());
    assertFalse(actualDefaultConfigurationResult.isUseSimpleClientHttpFactory());
    assertFalse(actualDefaultConfigurationResult.isUseSystemProxyProperties());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link TbRestApiCallNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRestApiCallNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given TbRestApiCallNodeConfiguration (default constructor)")
  void testDefaultConfiguration_givenTbRestApiCallNodeConfiguration() {
    // Arrange and Act
    TbRestApiCallNodeConfiguration actualDefaultConfigurationResult = (new TbRestApiCallNodeConfiguration())
        .defaultConfiguration();

    // Assert
    ClientCredentials credentials = actualDefaultConfigurationResult.getCredentials();
    assertTrue(credentials instanceof AnonymousCredentials);
    assertEquals("POST", actualDefaultConfigurationResult.getRequestMethod());
    Map<String, String> headers = actualDefaultConfigurationResult.getHeaders();
    assertEquals(1, headers.size());
    assertEquals("application/json", headers.get("Content-Type"));
    assertEquals("http://localhost/api", actualDefaultConfigurationResult.getRestEndpointUrlPattern());
    assertNull(actualDefaultConfigurationResult.getProxyHost());
    assertNull(actualDefaultConfigurationResult.getProxyPassword());
    assertNull(actualDefaultConfigurationResult.getProxyScheme());
    assertNull(actualDefaultConfigurationResult.getProxyUser());
    assertEquals(0, actualDefaultConfigurationResult.getMaxParallelRequestsCount());
    assertEquals(0, actualDefaultConfigurationResult.getProxyPort());
    assertEquals(0, actualDefaultConfigurationResult.getReadTimeoutMs());
    assertEquals(256, actualDefaultConfigurationResult.getMaxInMemoryBufferSizeInKb());
    assertEquals(CredentialsType.ANONYMOUS, credentials.getType());
    assertFalse(actualDefaultConfigurationResult.isEnableProxy());
    assertFalse(actualDefaultConfigurationResult.isIgnoreRequestBody());
    assertFalse(actualDefaultConfigurationResult.isParseToPlainText());
    assertFalse(actualDefaultConfigurationResult.isUseSimpleClientHttpFactory());
    assertFalse(actualDefaultConfigurationResult.isUseSystemProxyProperties());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#getCredentials()}.
   * <ul>
   *   <li>Given {@link ClientCredentials} {@link ClientCredentials#getType()}
   * return {@code ANONYMOUS}.</li>
   *   <li>Then calls {@link ClientCredentials#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials(); given ClientCredentials getType() return 'ANONYMOUS'; then calls getType()")
  void testGetCredentials_givenClientCredentialsGetTypeReturnAnonymous_thenCallsGetType() {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(credentials);

    // Act
    CredentialsType actualType = tbRestApiCallNodeConfiguration.getCredentials().getType();

    // Assert
    verify(credentials).getType();
    assertEquals(CredentialsType.ANONYMOUS, actualType);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#getCredentials()}.
   * <ul>
   *   <li>Given {@link TbRestApiCallNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials(); given TbRestApiCallNodeConfiguration (default constructor)")
  void testGetCredentials_givenTbRestApiCallNodeConfiguration() {
    // Arrange and Act
    ClientCredentials actualCredentials = (new TbRestApiCallNodeConfiguration()).getCredentials();
    CredentialsType actualType = actualCredentials.getType();

    // Assert
    assertTrue(actualCredentials instanceof AnonymousCredentials);
    assertEquals(CredentialsType.ANONYMOUS, actualCredentials.getType());
    assertEquals(CredentialsType.ANONYMOUS, actualType);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#getCredentials()}.
   * <ul>
   *   <li>Given {@link TbRestApiCallNodeConfiguration} (default constructor)
   * Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials(); given TbRestApiCallNodeConfiguration (default constructor) Credentials is 'null'")
  void testGetCredentials_givenTbRestApiCallNodeConfigurationCredentialsIsNull() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(null);

    // Act
    ClientCredentials actualCredentials = tbRestApiCallNodeConfiguration.getCredentials();
    CredentialsType actualType = actualCredentials.getType();

    // Assert
    assertTrue(actualCredentials instanceof AnonymousCredentials);
    assertEquals(CredentialsType.ANONYMOUS, actualCredentials.getType());
    assertEquals(CredentialsType.ANONYMOUS, actualType);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}, and
   * {@link TbRestApiCallNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRestApiCallNodeConfiguration#equals(Object)}
   *   <li>{@link TbRestApiCallNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    // Act and Assert
    assertEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration);
    int notExpectedHashCodeResult = tbRestApiCallNodeConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbRestApiCallNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(mock(ClientCredentials.class));

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, 1);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRequestMethod("Request Method");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setHeaders(headers);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setUseSimpleClientHttpFactory(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setReadTimeoutMs(10);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setMaxParallelRequestsCount(3);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setParseToPlainText(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setEnableProxy(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setUseSystemProxyProperties(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyPort(8080);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyScheme("Proxy Scheme");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(mock(ClientCredentials.class));

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setIgnoreRequestBody(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setMaxInMemoryBufferSizeInKb(3);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRequestMethod("Request Method");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setHeaders(headers);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyScheme("Proxy Scheme");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRequestMethod("Request Method");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRequestMethod("Request Method");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setHeaders(headers);

    HashMap<String, String> headers2 = new HashMap<>();
    headers2.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setHeaders(headers2);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyHost("localhost");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyUser("Proxy User");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyPassword("iloveyou");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyScheme("Proxy Scheme");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 = new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyScheme("Proxy Scheme");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRestApiCallNodeConfiguration(), null);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRestApiCallNodeConfiguration(), "Different type to TbRestApiCallNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbRestApiCallNodeConfiguration}
   *   <li>{@link TbRestApiCallNodeConfiguration#setCredentials(ClientCredentials)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setEnableProxy(boolean)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setHeaders(Map)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setIgnoreRequestBody(boolean)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setMaxInMemoryBufferSizeInKb(int)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setMaxParallelRequestsCount(int)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setParseToPlainText(boolean)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setProxyHost(String)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setProxyPassword(String)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setProxyPort(int)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setProxyScheme(String)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setProxyUser(String)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setReadTimeoutMs(int)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setRequestMethod(String)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setRestEndpointUrlPattern(String)}
   *   <li>
   * {@link TbRestApiCallNodeConfiguration#setUseSimpleClientHttpFactory(boolean)}
   *   <li>
   * {@link TbRestApiCallNodeConfiguration#setUseSystemProxyProperties(boolean)}
   *   <li>{@link TbRestApiCallNodeConfiguration#toString()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getHeaders()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getMaxInMemoryBufferSizeInKb()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getMaxParallelRequestsCount()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getProxyHost()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getProxyPassword()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getProxyPort()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getProxyScheme()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getProxyUser()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getReadTimeoutMs()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getRequestMethod()}
   *   <li>{@link TbRestApiCallNodeConfiguration#getRestEndpointUrlPattern()}
   *   <li>{@link TbRestApiCallNodeConfiguration#isEnableProxy()}
   *   <li>{@link TbRestApiCallNodeConfiguration#isIgnoreRequestBody()}
   *   <li>{@link TbRestApiCallNodeConfiguration#isParseToPlainText()}
   *   <li>{@link TbRestApiCallNodeConfiguration#isUseSimpleClientHttpFactory()}
   *   <li>{@link TbRestApiCallNodeConfiguration#isUseSystemProxyProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbRestApiCallNodeConfiguration actualTbRestApiCallNodeConfiguration = new TbRestApiCallNodeConfiguration();
    actualTbRestApiCallNodeConfiguration.setCredentials(mock(ClientCredentials.class));
    actualTbRestApiCallNodeConfiguration.setEnableProxy(true);
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");
    actualTbRestApiCallNodeConfiguration.setHeaders(headers);
    actualTbRestApiCallNodeConfiguration.setIgnoreRequestBody(true);
    actualTbRestApiCallNodeConfiguration.setMaxInMemoryBufferSizeInKb(3);
    actualTbRestApiCallNodeConfiguration.setMaxParallelRequestsCount(3);
    actualTbRestApiCallNodeConfiguration.setParseToPlainText(true);
    actualTbRestApiCallNodeConfiguration.setProxyHost("localhost");
    actualTbRestApiCallNodeConfiguration.setProxyPassword("iloveyou");
    actualTbRestApiCallNodeConfiguration.setProxyPort(8080);
    actualTbRestApiCallNodeConfiguration.setProxyScheme("Proxy Scheme");
    actualTbRestApiCallNodeConfiguration.setProxyUser("Proxy User");
    actualTbRestApiCallNodeConfiguration.setReadTimeoutMs(10);
    actualTbRestApiCallNodeConfiguration.setRequestMethod("Request Method");
    actualTbRestApiCallNodeConfiguration.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    actualTbRestApiCallNodeConfiguration.setUseSimpleClientHttpFactory(true);
    actualTbRestApiCallNodeConfiguration.setUseSystemProxyProperties(true);
    actualTbRestApiCallNodeConfiguration.toString();
    Map<String, String> actualHeaders = actualTbRestApiCallNodeConfiguration.getHeaders();
    int actualMaxInMemoryBufferSizeInKb = actualTbRestApiCallNodeConfiguration.getMaxInMemoryBufferSizeInKb();
    int actualMaxParallelRequestsCount = actualTbRestApiCallNodeConfiguration.getMaxParallelRequestsCount();
    String actualProxyHost = actualTbRestApiCallNodeConfiguration.getProxyHost();
    String actualProxyPassword = actualTbRestApiCallNodeConfiguration.getProxyPassword();
    int actualProxyPort = actualTbRestApiCallNodeConfiguration.getProxyPort();
    String actualProxyScheme = actualTbRestApiCallNodeConfiguration.getProxyScheme();
    String actualProxyUser = actualTbRestApiCallNodeConfiguration.getProxyUser();
    int actualReadTimeoutMs = actualTbRestApiCallNodeConfiguration.getReadTimeoutMs();
    String actualRequestMethod = actualTbRestApiCallNodeConfiguration.getRequestMethod();
    String actualRestEndpointUrlPattern = actualTbRestApiCallNodeConfiguration.getRestEndpointUrlPattern();
    boolean actualIsEnableProxyResult = actualTbRestApiCallNodeConfiguration.isEnableProxy();
    boolean actualIsIgnoreRequestBodyResult = actualTbRestApiCallNodeConfiguration.isIgnoreRequestBody();
    boolean actualIsParseToPlainTextResult = actualTbRestApiCallNodeConfiguration.isParseToPlainText();
    boolean actualIsUseSimpleClientHttpFactoryResult = actualTbRestApiCallNodeConfiguration
        .isUseSimpleClientHttpFactory();
    boolean actualIsUseSystemProxyPropertiesResult = actualTbRestApiCallNodeConfiguration.isUseSystemProxyProperties();

    // Assert that nothing has changed
    assertEquals("Proxy Scheme", actualProxyScheme);
    assertEquals("Proxy User", actualProxyUser);
    assertEquals("Request Method", actualRequestMethod);
    assertEquals(1, actualHeaders.size());
    assertEquals("alice.liddell@example.org", actualHeaders.get("Delivered-To"));
    assertEquals("https://config.us-east-2.amazonaws.com", actualRestEndpointUrlPattern);
    assertEquals("iloveyou", actualProxyPassword);
    assertEquals("localhost", actualProxyHost);
    assertEquals(10, actualReadTimeoutMs);
    assertEquals(3, actualMaxInMemoryBufferSizeInKb);
    assertEquals(3, actualMaxParallelRequestsCount);
    assertEquals(8080, actualProxyPort);
    assertTrue(actualIsEnableProxyResult);
    assertTrue(actualIsIgnoreRequestBodyResult);
    assertTrue(actualIsParseToPlainTextResult);
    assertTrue(actualIsUseSimpleClientHttpFactoryResult);
    assertTrue(actualIsUseSystemProxyPropertiesResult);
    assertSame(headers, actualHeaders);
  }
}
