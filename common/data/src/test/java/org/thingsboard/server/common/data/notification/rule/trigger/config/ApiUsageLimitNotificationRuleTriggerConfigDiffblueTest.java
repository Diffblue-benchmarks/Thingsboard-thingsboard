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
package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageStateValue;

class ApiUsageLimitNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder#apiFeatures(Set)}
   *   <li>
   * {@link ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  void testApiUsageLimitNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    HashSet<ApiFeature> apiFeatures = new HashSet<>();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult
        .apiFeatures(apiFeatures);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();

    // Act
    ApiUsageLimitNotificationRuleTriggerConfig actualBuildResult = apiFeaturesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT, actualBuildResult.getTriggerType());
    Set<ApiFeature> apiFeatures2 = actualBuildResult.getApiFeatures();
    assertTrue(apiFeatures2.isEmpty());
    Set<ApiUsageStateValue> notifyOn2 = actualBuildResult.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(apiFeatures, apiFeatures2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult2 = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 = builderResult2
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 = apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = apiUsageLimitNotificationRuleTriggerConfigBuilder
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder2 = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 = apiUsageLimitNotificationRuleTriggerConfigBuilder2
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 = apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = apiUsageLimitNotificationRuleTriggerConfigBuilder
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 = builderResult
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 = apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.notifyOn(Mockito.<Set<ApiUsageStateValue>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder2 = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder);
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = apiUsageLimitNotificationRuleTriggerConfigBuilder2
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder3 = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 = apiUsageLimitNotificationRuleTriggerConfigBuilder3
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 = apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder2 = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.notifyOn(Mockito.<Set<ApiUsageStateValue>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder);
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder3 = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder2);
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 = apiUsageLimitNotificationRuleTriggerConfigBuilder3
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 = apiFeaturesResult2.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiUsageLimitNotificationRuleTriggerConfigBuilder4 = mock(
        ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder4.apiFeatures(Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult3 = apiUsageLimitNotificationRuleTriggerConfigBuilder4
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult3 = apiFeaturesResult3.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test:
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult = apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ApiUsageLimitNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#ApiUsageLimitNotificationRuleTriggerConfig()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setApiFeatures(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#toString()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getApiFeatures()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageLimitNotificationRuleTriggerConfig actualApiUsageLimitNotificationRuleTriggerConfig = new ApiUsageLimitNotificationRuleTriggerConfig();
    HashSet<ApiFeature> apiFeatures = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setApiFeatures(apiFeatures);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualApiUsageLimitNotificationRuleTriggerConfig.toString();
    Set<ApiFeature> actualApiFeatures = actualApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures();
    Set<ApiUsageStateValue> actualNotifyOn = actualApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn();

    // Assert that nothing has changed
    assertEquals("ApiUsageLimitNotificationRuleTriggerConfig(apiFeatures=[], notifyOn=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT,
        actualApiUsageLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApiFeatures.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(apiFeatures, actualApiFeatures);
    assertSame(notifyOn, actualNotifyOn);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ApiUsageLimitNotificationRuleTriggerConfig#ApiUsageLimitNotificationRuleTriggerConfig(Set, Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setApiFeatures(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#toString()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getApiFeatures()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    HashSet<ApiFeature> apiFeatures = new HashSet<>();

    // Act
    ApiUsageLimitNotificationRuleTriggerConfig actualApiUsageLimitNotificationRuleTriggerConfig = new ApiUsageLimitNotificationRuleTriggerConfig(
        apiFeatures, new HashSet<>());
    HashSet<ApiFeature> apiFeatures2 = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setApiFeatures(apiFeatures2);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualApiUsageLimitNotificationRuleTriggerConfig.toString();
    Set<ApiFeature> actualApiFeatures = actualApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures();
    Set<ApiUsageStateValue> actualNotifyOn = actualApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn();

    // Assert that nothing has changed
    assertEquals("ApiUsageLimitNotificationRuleTriggerConfig(apiFeatures=[], notifyOn=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT,
        actualApiUsageLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApiFeatures.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(apiFeatures2, actualApiFeatures);
    assertSame(notifyOn, actualNotifyOn);
  }
}
