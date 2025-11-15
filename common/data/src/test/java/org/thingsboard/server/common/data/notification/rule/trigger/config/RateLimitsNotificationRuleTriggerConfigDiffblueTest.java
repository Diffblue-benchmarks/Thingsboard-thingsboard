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
import org.thingsboard.server.common.data.limit.LimitedApi;

class RateLimitsNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("#", (new RateLimitsNotificationRuleTriggerConfig()).getDeduplicationKey());
  }

  /**
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  void testGetDeduplicationKey2() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertEquals("", buildResult.getDeduplicationKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult2 = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult2 = builderResult2.apis(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder = mock(
        RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult = rateLimitsNotificationRuleTriggerConfigBuilder
        .apis(new HashSet<>())
        .build();
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder2 = mock(
        RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder2.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult2 = rateLimitsNotificationRuleTriggerConfigBuilder2
        .apis(new HashSet<>())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder = mock(
        RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult = rateLimitsNotificationRuleTriggerConfigBuilder
        .apis(new HashSet<>())
        .build();
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult2 = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder = mock(
        RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder.class);
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();
    when(rateLimitsNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder2 = mock(
        RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder2.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(rateLimitsNotificationRuleTriggerConfigBuilder);
    RateLimitsNotificationRuleTriggerConfig buildResult2 = rateLimitsNotificationRuleTriggerConfigBuilder2
        .apis(new HashSet<>())
        .build();
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder3 = mock(
        RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder3.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult3 = rateLimitsNotificationRuleTriggerConfigBuilder3
        .apis(new HashSet<>())
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RateLimitsNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsNotificationRuleTriggerConfig#RateLimitsNotificationRuleTriggerConfig()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#setApis(Set)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#toString()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getApis()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RateLimitsNotificationRuleTriggerConfig actualRateLimitsNotificationRuleTriggerConfig = new RateLimitsNotificationRuleTriggerConfig();
    HashSet<LimitedApi> apis = new HashSet<>();
    actualRateLimitsNotificationRuleTriggerConfig.setApis(apis);
    String actualToStringResult = actualRateLimitsNotificationRuleTriggerConfig.toString();
    Set<LimitedApi> actualApis = actualRateLimitsNotificationRuleTriggerConfig.getApis();

    // Assert that nothing has changed
    assertEquals("RateLimitsNotificationRuleTriggerConfig(apis=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS,
        actualRateLimitsNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApis.isEmpty());
    assertSame(apis, actualApis);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsNotificationRuleTriggerConfig#RateLimitsNotificationRuleTriggerConfig(Set)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#setApis(Set)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#toString()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getApis()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    RateLimitsNotificationRuleTriggerConfig actualRateLimitsNotificationRuleTriggerConfig = new RateLimitsNotificationRuleTriggerConfig(
        new HashSet<>());
    HashSet<LimitedApi> apis = new HashSet<>();
    actualRateLimitsNotificationRuleTriggerConfig.setApis(apis);
    String actualToStringResult = actualRateLimitsNotificationRuleTriggerConfig.toString();
    Set<LimitedApi> actualApis = actualRateLimitsNotificationRuleTriggerConfig.getApis();

    // Assert that nothing has changed
    assertEquals("RateLimitsNotificationRuleTriggerConfig(apis=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS,
        actualRateLimitsNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApis.isEmpty());
    assertSame(apis, actualApis);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder#apis(Set)}
   * </ul>
   */
  @Test
  void testRateLimitsNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    HashSet<LimitedApi> apis = new HashSet<>();

    // Act
    RateLimitsNotificationRuleTriggerConfig actualBuildResult = builderResult.apis(apis).build();

    // Assert
    assertEquals("", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS, actualBuildResult.getTriggerType());
    Set<LimitedApi> apis2 = actualBuildResult.getApis();
    assertTrue(apis2.isEmpty());
    assertSame(apis, apis2);
  }
}
