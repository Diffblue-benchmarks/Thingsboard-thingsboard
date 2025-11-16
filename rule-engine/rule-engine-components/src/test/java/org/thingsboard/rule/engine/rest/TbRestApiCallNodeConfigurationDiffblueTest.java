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
package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.credentials.AnonymousCredentials;
import org.thingsboard.rule.engine.credentials.ClientCredentials;
import org.thingsboard.rule.engine.credentials.CredentialsType;

class TbRestApiCallNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbRestApiCallNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbRestApiCallNodeConfiguration TbRestApiCallNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbRestApiCallNodeConfiguration actualDefaultConfigurationResult =
        new TbRestApiCallNodeConfiguration().defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult.getCredentials() instanceof AnonymousCredentials);
    assertEquals("POST", actualDefaultConfigurationResult.getRequestMethod());
    assertEquals(
        "http://localhost/api", actualDefaultConfigurationResult.getRestEndpointUrlPattern());
    assertNull(actualDefaultConfigurationResult.getProxyHost());
    assertNull(actualDefaultConfigurationResult.getProxyPassword());
    assertNull(actualDefaultConfigurationResult.getProxyScheme());
    assertNull(actualDefaultConfigurationResult.getProxyUser());
    assertEquals(0, actualDefaultConfigurationResult.getMaxParallelRequestsCount());
    assertEquals(0, actualDefaultConfigurationResult.getProxyPort());
    assertEquals(0, actualDefaultConfigurationResult.getReadTimeoutMs());
    Map<String, String> headers = actualDefaultConfigurationResult.getHeaders();
    assertEquals(1, headers.size());
    assertEquals(256, actualDefaultConfigurationResult.getMaxInMemoryBufferSizeInKb());
    assertFalse(actualDefaultConfigurationResult.isEnableProxy());
    assertFalse(actualDefaultConfigurationResult.isIgnoreRequestBody());
    assertFalse(actualDefaultConfigurationResult.isParseToPlainText());
    assertFalse(actualDefaultConfigurationResult.isUseSimpleClientHttpFactory());
    assertFalse(actualDefaultConfigurationResult.isUseSystemProxyProperties());
    assertTrue(headers.containsKey("Content-Type"));
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#getCredentials()}.
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientCredentials TbRestApiCallNodeConfiguration.getCredentials()"})
  void testGetCredentials() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(mock(ClientCredentials.class));

    // Act
    tbRestApiCallNodeConfiguration.getCredentials();

    // Assert that nothing has changed
    assertEquals(0, tbRestApiCallNodeConfiguration.getMaxInMemoryBufferSizeInKb());
    assertEquals(0, tbRestApiCallNodeConfiguration.getMaxParallelRequestsCount());
    assertEquals(0, tbRestApiCallNodeConfiguration.getProxyPort());
    assertEquals(0, tbRestApiCallNodeConfiguration.getReadTimeoutMs());
    assertFalse(tbRestApiCallNodeConfiguration.isEnableProxy());
    assertFalse(tbRestApiCallNodeConfiguration.isIgnoreRequestBody());
    assertFalse(tbRestApiCallNodeConfiguration.isParseToPlainText());
    assertFalse(tbRestApiCallNodeConfiguration.isUseSimpleClientHttpFactory());
    assertFalse(tbRestApiCallNodeConfiguration.isUseSystemProxyProperties());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#getCredentials()}.
   *
   * <ul>
   *   <li>Then return {@link AnonymousCredentials}.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#getCredentials()}
   */
  @Test
  @DisplayName("Test getCredentials(); then return AnonymousCredentials")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientCredentials TbRestApiCallNodeConfiguration.getCredentials()"})
  void testGetCredentials_thenReturnAnonymousCredentials() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    // Act
    ClientCredentials actualCredentials = tbRestApiCallNodeConfiguration.getCredentials();
    CredentialsType actualType = actualCredentials.getType();

    // Assert
    assertTrue(actualCredentials instanceof AnonymousCredentials);
    assertNull(tbRestApiCallNodeConfiguration.getProxyHost());
    assertNull(tbRestApiCallNodeConfiguration.getProxyPassword());
    assertNull(tbRestApiCallNodeConfiguration.getProxyScheme());
    assertNull(tbRestApiCallNodeConfiguration.getProxyUser());
    assertNull(tbRestApiCallNodeConfiguration.getRequestMethod());
    assertNull(tbRestApiCallNodeConfiguration.getRestEndpointUrlPattern());
    assertNull(tbRestApiCallNodeConfiguration.getHeaders());
    assertEquals(0, tbRestApiCallNodeConfiguration.getMaxInMemoryBufferSizeInKb());
    assertEquals(0, tbRestApiCallNodeConfiguration.getMaxParallelRequestsCount());
    assertEquals(0, tbRestApiCallNodeConfiguration.getProxyPort());
    assertEquals(0, tbRestApiCallNodeConfiguration.getReadTimeoutMs());
    assertEquals(CredentialsType.ANONYMOUS, actualCredentials.getType());
    assertEquals(CredentialsType.ANONYMOUS, actualType);
    assertFalse(tbRestApiCallNodeConfiguration.isEnableProxy());
    assertFalse(tbRestApiCallNodeConfiguration.isIgnoreRequestBody());
    assertFalse(tbRestApiCallNodeConfiguration.isParseToPlainText());
    assertFalse(tbRestApiCallNodeConfiguration.isUseSimpleClientHttpFactory());
    assertFalse(tbRestApiCallNodeConfiguration.isUseSystemProxyProperties());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}, and {@link
   * TbRestApiCallNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRestApiCallNodeConfiguration#equals(Object)}
   *   <li>{@link TbRestApiCallNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    // Act and Assert
    assertEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration);
    int notExpectedHashCodeResult = tbRestApiCallNodeConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbRestApiCallNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRestEndpointUrlPattern(
        "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRequestMethod("Request Method");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setHeaders(headers);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setUseSimpleClientHttpFactory(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setReadTimeoutMs(10);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setMaxParallelRequestsCount(3);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setParseToPlainText(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setEnableProxy(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setUseSystemProxyProperties(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyPort(8080);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyScheme("Proxy Scheme");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setCredentials(mock(ClientCredentials.class));

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setIgnoreRequestBody(true);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setMaxInMemoryBufferSizeInKb(3);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, new TbRestApiCallNodeConfiguration());
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRestEndpointUrlPattern(
        "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRequestMethod("Request Method");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setHeaders(headers);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyScheme("Proxy Scheme");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRestEndpointUrlPattern(
        "https://config.us-east-2.amazonaws.com");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRestEndpointUrlPattern(
        "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setRequestMethod("Request Method");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setRequestMethod("Request Method");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setHeaders(headers);

    HashMap<String, String> headers2 = new HashMap<>();
    headers2.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setHeaders(headers2);

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyHost("localhost");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyUser("Proxy User");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyPassword("iloveyou");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration.setProxyScheme("Proxy Scheme");

    TbRestApiCallNodeConfiguration tbRestApiCallNodeConfiguration2 =
        new TbRestApiCallNodeConfiguration();
    tbRestApiCallNodeConfiguration2.setProxyScheme("Proxy Scheme");

    // Act and Assert
    assertNotEquals(tbRestApiCallNodeConfiguration, tbRestApiCallNodeConfiguration2);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRestApiCallNodeConfiguration(), null);
  }

  /**
   * Test {@link TbRestApiCallNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRestApiCallNodeConfiguration.equals(Object)",
    "int TbRestApiCallNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbRestApiCallNodeConfiguration(), "Different type to TbRestApiCallNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRestApiCallNodeConfiguration}
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
   *   <li>{@link TbRestApiCallNodeConfiguration#setUseSimpleClientHttpFactory(boolean)}
   *   <li>{@link TbRestApiCallNodeConfiguration#setUseSystemProxyProperties(boolean)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbRestApiCallNodeConfiguration.<init>()",
    "Map TbRestApiCallNodeConfiguration.getHeaders()",
    "int TbRestApiCallNodeConfiguration.getMaxInMemoryBufferSizeInKb()",
    "int TbRestApiCallNodeConfiguration.getMaxParallelRequestsCount()",
    "String TbRestApiCallNodeConfiguration.getProxyHost()",
    "String TbRestApiCallNodeConfiguration.getProxyPassword()",
    "int TbRestApiCallNodeConfiguration.getProxyPort()",
    "String TbRestApiCallNodeConfiguration.getProxyScheme()",
    "String TbRestApiCallNodeConfiguration.getProxyUser()",
    "int TbRestApiCallNodeConfiguration.getReadTimeoutMs()",
    "String TbRestApiCallNodeConfiguration.getRequestMethod()",
    "String TbRestApiCallNodeConfiguration.getRestEndpointUrlPattern()",
    "boolean TbRestApiCallNodeConfiguration.isEnableProxy()",
    "boolean TbRestApiCallNodeConfiguration.isIgnoreRequestBody()",
    "boolean TbRestApiCallNodeConfiguration.isParseToPlainText()",
    "boolean TbRestApiCallNodeConfiguration.isUseSimpleClientHttpFactory()",
    "boolean TbRestApiCallNodeConfiguration.isUseSystemProxyProperties()",
    "void TbRestApiCallNodeConfiguration.setCredentials(ClientCredentials)",
    "void TbRestApiCallNodeConfiguration.setEnableProxy(boolean)",
    "void TbRestApiCallNodeConfiguration.setHeaders(Map)",
    "void TbRestApiCallNodeConfiguration.setIgnoreRequestBody(boolean)",
    "void TbRestApiCallNodeConfiguration.setMaxInMemoryBufferSizeInKb(int)",
    "void TbRestApiCallNodeConfiguration.setMaxParallelRequestsCount(int)",
    "void TbRestApiCallNodeConfiguration.setParseToPlainText(boolean)",
    "void TbRestApiCallNodeConfiguration.setProxyHost(String)",
    "void TbRestApiCallNodeConfiguration.setProxyPassword(String)",
    "void TbRestApiCallNodeConfiguration.setProxyPort(int)",
    "void TbRestApiCallNodeConfiguration.setProxyScheme(String)",
    "void TbRestApiCallNodeConfiguration.setProxyUser(String)",
    "void TbRestApiCallNodeConfiguration.setReadTimeoutMs(int)",
    "void TbRestApiCallNodeConfiguration.setRequestMethod(String)",
    "void TbRestApiCallNodeConfiguration.setRestEndpointUrlPattern(String)",
    "void TbRestApiCallNodeConfiguration.setUseSimpleClientHttpFactory(boolean)",
    "void TbRestApiCallNodeConfiguration.setUseSystemProxyProperties(boolean)",
    "String TbRestApiCallNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRestApiCallNodeConfiguration actualTbRestApiCallNodeConfiguration =
        new TbRestApiCallNodeConfiguration();
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
    actualTbRestApiCallNodeConfiguration.setRestEndpointUrlPattern(
        "https://config.us-east-2.amazonaws.com");
    actualTbRestApiCallNodeConfiguration.setUseSimpleClientHttpFactory(true);
    actualTbRestApiCallNodeConfiguration.setUseSystemProxyProperties(true);
    actualTbRestApiCallNodeConfiguration.toString();
    Map<String, String> actualHeaders = actualTbRestApiCallNodeConfiguration.getHeaders();
    int actualMaxInMemoryBufferSizeInKb =
        actualTbRestApiCallNodeConfiguration.getMaxInMemoryBufferSizeInKb();
    int actualMaxParallelRequestsCount =
        actualTbRestApiCallNodeConfiguration.getMaxParallelRequestsCount();
    String actualProxyHost = actualTbRestApiCallNodeConfiguration.getProxyHost();
    String actualProxyPassword = actualTbRestApiCallNodeConfiguration.getProxyPassword();
    int actualProxyPort = actualTbRestApiCallNodeConfiguration.getProxyPort();
    String actualProxyScheme = actualTbRestApiCallNodeConfiguration.getProxyScheme();
    String actualProxyUser = actualTbRestApiCallNodeConfiguration.getProxyUser();
    int actualReadTimeoutMs = actualTbRestApiCallNodeConfiguration.getReadTimeoutMs();
    String actualRequestMethod = actualTbRestApiCallNodeConfiguration.getRequestMethod();
    String actualRestEndpointUrlPattern =
        actualTbRestApiCallNodeConfiguration.getRestEndpointUrlPattern();
    boolean actualIsEnableProxyResult = actualTbRestApiCallNodeConfiguration.isEnableProxy();
    boolean actualIsIgnoreRequestBodyResult =
        actualTbRestApiCallNodeConfiguration.isIgnoreRequestBody();
    boolean actualIsParseToPlainTextResult =
        actualTbRestApiCallNodeConfiguration.isParseToPlainText();
    boolean actualIsUseSimpleClientHttpFactoryResult =
        actualTbRestApiCallNodeConfiguration.isUseSimpleClientHttpFactory();

    // Assert
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
    assertTrue(actualTbRestApiCallNodeConfiguration.isUseSystemProxyProperties());
    assertSame(headers, actualHeaders);
  }
}
