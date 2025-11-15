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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {RateLimitsNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class RateLimitsNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder;

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}.
   * <ul>
   *   <li>Given builder apis {@link HashSet#HashSet()} build.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); given builder apis HashSet() build; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RateLimitsNotificationRuleTriggerConfig.getDeduplicationKey()"})
  void testGetDeduplicationKey_givenBuilderApisHashSetBuild_thenReturnEmptyString() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertEquals("", buildResult.getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}.
   * <ul>
   *   <li>Then return {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); then return '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RateLimitsNotificationRuleTriggerConfig.getDeduplicationKey()"})
  void testGetDeduplicationKey_thenReturnNumberSign() {
    // Arrange, Act and Assert
    assertEquals("#", (new RateLimitsNotificationRuleTriggerConfig()).getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}, and {@link RateLimitsNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult2 = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult2 = builderResult2.apis(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}, and {@link RateLimitsNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder = mock(
        RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult = rateLimitsNotificationRuleTriggerConfigBuilder
        .apis(new HashSet<>())
        .build();
    RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder2 = mock(
        RateLimitsNotificationRuleTriggerConfigBuilder.class);
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
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}, and {@link RateLimitsNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder = mock(
        RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult = rateLimitsNotificationRuleTriggerConfigBuilder
        .apis(new HashSet<>())
        .build();
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult2 = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder = mock(
        RateLimitsNotificationRuleTriggerConfigBuilder.class);
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();
    when(rateLimitsNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder2 = mock(
        RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder2.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(rateLimitsNotificationRuleTriggerConfigBuilder);
    RateLimitsNotificationRuleTriggerConfig buildResult2 = rateLimitsNotificationRuleTriggerConfigBuilder2
        .apis(new HashSet<>())
        .build();
    RateLimitsNotificationRuleTriggerConfigBuilder rateLimitsNotificationRuleTriggerConfigBuilder3 = mock(
        RateLimitsNotificationRuleTriggerConfigBuilder.class);
    when(rateLimitsNotificationRuleTriggerConfigBuilder3.apis(Mockito.<Set<LimitedApi>>any()))
        .thenReturn(RateLimitsNotificationRuleTriggerConfig.builder());
    RateLimitsNotificationRuleTriggerConfig buildResult3 = rateLimitsNotificationRuleTriggerConfigBuilder3
        .apis(new HashSet<>())
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsNotificationRuleTriggerConfig.equals(Object)",
      "int RateLimitsNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RateLimitsNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#RateLimitsNotificationRuleTriggerConfig()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#setApis(Set)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#toString()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getApis()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RateLimitsNotificationRuleTriggerConfig.<init>()",
      "void RateLimitsNotificationRuleTriggerConfig.<init>(Set)",
      "Set RateLimitsNotificationRuleTriggerConfig.getApis()",
      "NotificationRuleTriggerType RateLimitsNotificationRuleTriggerConfig.getTriggerType()",
      "void RateLimitsNotificationRuleTriggerConfig.setApis(Set)",
      "String RateLimitsNotificationRuleTriggerConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    RateLimitsNotificationRuleTriggerConfig actualRateLimitsNotificationRuleTriggerConfig = new RateLimitsNotificationRuleTriggerConfig();
    HashSet<LimitedApi> apis = new HashSet<>();
    actualRateLimitsNotificationRuleTriggerConfig.setApis(apis);
    String actualToStringResult = actualRateLimitsNotificationRuleTriggerConfig.toString();
    Set<LimitedApi> actualApis = actualRateLimitsNotificationRuleTriggerConfig.getApis();

    // Assert
    assertEquals("RateLimitsNotificationRuleTriggerConfig(apis=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS,
        actualRateLimitsNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApis.isEmpty());
    assertSame(apis, actualApis);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#RateLimitsNotificationRuleTriggerConfig(Set)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#setApis(Set)}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#toString()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getApis()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RateLimitsNotificationRuleTriggerConfig.<init>()",
      "void RateLimitsNotificationRuleTriggerConfig.<init>(Set)",
      "Set RateLimitsNotificationRuleTriggerConfig.getApis()",
      "NotificationRuleTriggerType RateLimitsNotificationRuleTriggerConfig.getTriggerType()",
      "void RateLimitsNotificationRuleTriggerConfig.setApis(Set)",
      "String RateLimitsNotificationRuleTriggerConfig.toString()"})
  void testGettersAndSetters_whenHashSet() {
    // Arrange and Act
    RateLimitsNotificationRuleTriggerConfig actualRateLimitsNotificationRuleTriggerConfig = new RateLimitsNotificationRuleTriggerConfig(
        new HashSet<>());
    HashSet<LimitedApi> apis = new HashSet<>();
    actualRateLimitsNotificationRuleTriggerConfig.setApis(apis);
    String actualToStringResult = actualRateLimitsNotificationRuleTriggerConfig.toString();
    Set<LimitedApi> actualApis = actualRateLimitsNotificationRuleTriggerConfig.getApis();

    // Assert
    assertEquals("RateLimitsNotificationRuleTriggerConfig(apis=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS,
        actualRateLimitsNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApis.isEmpty());
    assertSame(apis, actualApis);
  }

  /**
   * Test RateLimitsNotificationRuleTriggerConfigBuilder {@link RateLimitsNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link RateLimitsNotificationRuleTriggerConfigBuilder#apis(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test RateLimitsNotificationRuleTriggerConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RateLimitsNotificationRuleTriggerConfigBuilder.<init>()",
      "RateLimitsNotificationRuleTriggerConfigBuilder RateLimitsNotificationRuleTriggerConfigBuilder.apis(Set)",
      "RateLimitsNotificationRuleTriggerConfig RateLimitsNotificationRuleTriggerConfigBuilder.build()",
      "String RateLimitsNotificationRuleTriggerConfigBuilder.toString()"})
  void testRateLimitsNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig.builder();
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
