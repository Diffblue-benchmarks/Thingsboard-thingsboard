package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder;

class RateLimitsNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}.
   * <ul>
   *   <li>Given builder apis {@link HashSet#HashSet()} build.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); given builder apis HashSet() build; then return empty string")
  void testGetDeduplicationKey_givenBuilderApisHashSetBuild_thenReturnEmptyString() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
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
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); then return '#'")
  void testGetDeduplicationKey_thenReturnNumberSign() {
    // Arrange, Act and Assert
    assertEquals("#", (new RateLimitsNotificationRuleTriggerConfig()).getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link RateLimitsNotificationRuleTriggerConfig#hashCode()}.
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
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link RateLimitsNotificationRuleTriggerConfig#hashCode()}.
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
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link RateLimitsNotificationRuleTriggerConfig#hashCode()}.
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
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
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
   * Method under test:
   * {@link RateLimitsNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig buildResult = builderResult.apis(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RateLimitsNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when HashSet()")
  void testGettersAndSetters_whenHashSet() {
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
   * Test RateLimitsNotificationRuleTriggerConfigBuilder
   * {@link RateLimitsNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder#apis(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test RateLimitsNotificationRuleTriggerConfigBuilder build()")
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
