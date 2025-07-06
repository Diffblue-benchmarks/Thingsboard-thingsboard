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
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.notification.rule.trigger.config.ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {ApiUsageLimitNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class ApiUsageLimitNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private ApiUsageLimitNotificationRuleTriggerConfigBuilder
      apiUsageLimitNotificationRuleTriggerConfigBuilder;

  /**
   * Test ApiUsageLimitNotificationRuleTriggerConfigBuilder {@link
   * ApiUsageLimitNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfigBuilder#apiFeatures(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test ApiUsageLimitNotificationRuleTriggerConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationRuleTriggerConfigBuilder.<init>()",
    "ApiUsageLimitNotificationRuleTriggerConfigBuilder ApiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(Set)",
    "ApiUsageLimitNotificationRuleTriggerConfig ApiUsageLimitNotificationRuleTriggerConfigBuilder.build()",
    "ApiUsageLimitNotificationRuleTriggerConfigBuilder ApiUsageLimitNotificationRuleTriggerConfigBuilder.notifyOn(Set)",
    "String ApiUsageLimitNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testApiUsageLimitNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    HashSet<ApiFeature> apiFeatures = new HashSet<>();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult.apiFeatures(apiFeatures);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();

    // Act
    ApiUsageLimitNotificationRuleTriggerConfig actualBuildResult =
        apiFeaturesResult.notifyOn(notifyOn).build();

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
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult2 =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        builderResult2.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder2 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        builderResult.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.notifyOn(
            Mockito.<Set<ApiUsageStateValue>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder2 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder);
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder3 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder2 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.notifyOn(
            Mockito.<Set<ApiUsageStateValue>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder);
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder3 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder2);
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder4 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder4.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult3 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder4.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult3 =
        apiFeaturesResult3.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig buildResult =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ApiUsageLimitNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       ApiUsageLimitNotificationRuleTriggerConfig#ApiUsageLimitNotificationRuleTriggerConfig()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setApiFeatures(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#toString()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getApiFeatures()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationRuleTriggerConfig.<init>()",
    "void ApiUsageLimitNotificationRuleTriggerConfig.<init>(Set, Set)",
    "Set ApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures()",
    "Set ApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType ApiUsageLimitNotificationRuleTriggerConfig.getTriggerType()",
    "void ApiUsageLimitNotificationRuleTriggerConfig.setApiFeatures(Set)",
    "void ApiUsageLimitNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String ApiUsageLimitNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageLimitNotificationRuleTriggerConfig actualApiUsageLimitNotificationRuleTriggerConfig =
        new ApiUsageLimitNotificationRuleTriggerConfig();
    HashSet<ApiFeature> apiFeatures = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setApiFeatures(apiFeatures);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualApiUsageLimitNotificationRuleTriggerConfig.toString();
    Set<ApiFeature> actualApiFeatures =
        actualApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures();
    Set<ApiUsageStateValue> actualNotifyOn =
        actualApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "ApiUsageLimitNotificationRuleTriggerConfig(apiFeatures=[], notifyOn=[])",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.API_USAGE_LIMIT,
        actualApiUsageLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApiFeatures.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(apiFeatures, actualApiFeatures);
    assertSame(notifyOn, actualNotifyOn);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       ApiUsageLimitNotificationRuleTriggerConfig#ApiUsageLimitNotificationRuleTriggerConfig(Set,
   *       Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setApiFeatures(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#toString()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getApiFeatures()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link ApiUsageLimitNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationRuleTriggerConfig.<init>()",
    "void ApiUsageLimitNotificationRuleTriggerConfig.<init>(Set, Set)",
    "Set ApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures()",
    "Set ApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType ApiUsageLimitNotificationRuleTriggerConfig.getTriggerType()",
    "void ApiUsageLimitNotificationRuleTriggerConfig.setApiFeatures(Set)",
    "void ApiUsageLimitNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String ApiUsageLimitNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<ApiFeature> apiFeatures = new HashSet<>();

    // Act
    ApiUsageLimitNotificationRuleTriggerConfig actualApiUsageLimitNotificationRuleTriggerConfig =
        new ApiUsageLimitNotificationRuleTriggerConfig(apiFeatures, new HashSet<>());
    HashSet<ApiFeature> apiFeatures2 = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setApiFeatures(apiFeatures2);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();
    actualApiUsageLimitNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualApiUsageLimitNotificationRuleTriggerConfig.toString();
    Set<ApiFeature> actualApiFeatures =
        actualApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures();
    Set<ApiUsageStateValue> actualNotifyOn =
        actualApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "ApiUsageLimitNotificationRuleTriggerConfig(apiFeatures=[], notifyOn=[])",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.API_USAGE_LIMIT,
        actualApiUsageLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualApiFeatures.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(apiFeatures2, actualApiFeatures);
    assertSame(notifyOn, actualNotifyOn);
  }
}
