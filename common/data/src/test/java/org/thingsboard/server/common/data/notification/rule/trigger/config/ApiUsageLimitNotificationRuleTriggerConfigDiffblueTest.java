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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationRuleTriggerConfigBuilder.<init>()",
    "ApiUsageLimitNotificationRuleTriggerConfigBuilder ApiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(Set)",
    "ApiUsageLimitNotificationRuleTriggerConfig ApiUsageLimitNotificationRuleTriggerConfigBuilder.build()",
    "ApiUsageLimitNotificationRuleTriggerConfigBuilder ApiUsageLimitNotificationRuleTriggerConfigBuilder.notifyOn(Set)",
    "String ApiUsageLimitNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testApiUsageLimitNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    ApiUsageLimitNotificationRuleTriggerConfigBuilder actualBuilderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    HashSet<ApiFeature> apiFeatures = new HashSet<>();
    ApiUsageLimitNotificationRuleTriggerConfigBuilder actualApiFeaturesResult =
        actualBuilderResult.apiFeatures(apiFeatures);
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();
    ApiUsageLimitNotificationRuleTriggerConfig actualApiUsageLimitNotificationRuleTriggerConfig =
        actualApiFeaturesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualApiUsageLimitNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.API_USAGE_LIMIT,
        actualApiUsageLimitNotificationRuleTriggerConfig.getTriggerType());
    Set<ApiFeature> apiFeatures2 =
        actualApiUsageLimitNotificationRuleTriggerConfig.getApiFeatures();
    assertTrue(apiFeatures2.isEmpty());
    Set<ApiUsageStateValue> notifyOn2 =
        actualApiUsageLimitNotificationRuleTriggerConfig.getNotifyOn();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult2 =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        builderResult2.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig, apiUsageLimitNotificationRuleTriggerConfig2);
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig.hashCode(),
        apiUsageLimitNotificationRuleTriggerConfig2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder2 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder2.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig, apiUsageLimitNotificationRuleTriggerConfig2);
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig.hashCode(),
        apiUsageLimitNotificationRuleTriggerConfig2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder3 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder3.notifyOn(
            Mockito.<Set<ApiUsageStateValue>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());

    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder4 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder4.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(apiUsageLimitNotificationRuleTriggerConfigBuilder3);

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder4.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig2 =
        apiFeaturesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig, apiUsageLimitNotificationRuleTriggerConfig2);
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig.hashCode(),
        apiUsageLimitNotificationRuleTriggerConfig2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        apiUsageLimitNotificationRuleTriggerConfig, apiUsageLimitNotificationRuleTriggerConfig);
    int expectedHashCodeResult = apiUsageLimitNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageLimitNotificationRuleTriggerConfig.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<ApiFeature> apiFeatures = new HashSet<>();
    apiFeatures.add(ApiFeature.TRANSPORT);

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder().apiFeatures(apiFeatures);
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        builderResult.apiFeatures(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationRuleTriggerConfig,
        apiFeaturesResult2.notifyOn(new HashSet<>()).build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<ApiUsageStateValue> notifyOn = new HashSet<>();
    notifyOn.add(ApiUsageStateValue.ENABLED);

    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        builderResult.apiFeatures(new HashSet<>()).notifyOn(notifyOn).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult2 =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        builderResult2.apiFeatures(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationRuleTriggerConfig,
        apiFeaturesResult.notifyOn(new HashSet<>()).build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult =
        apiUsageLimitNotificationRuleTriggerConfigBuilder.apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult =
        ApiUsageLimitNotificationRuleTriggerConfig.builder();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        builderResult.apiFeatures(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationRuleTriggerConfig,
        apiFeaturesResult2.notifyOn(new HashSet<>()).build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationRuleTriggerConfig.equals(Object)",
    "int ApiUsageLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
    ApiUsageLimitNotificationRuleTriggerConfig apiUsageLimitNotificationRuleTriggerConfig =
        apiFeaturesResult.notifyOn(new HashSet<>()).build();

    ApiUsageLimitNotificationRuleTriggerConfigBuilder
        apiUsageLimitNotificationRuleTriggerConfigBuilder3 =
            mock(ApiUsageLimitNotificationRuleTriggerConfigBuilder.class);
    when(apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(
            Mockito.<Set<ApiFeature>>any()))
        .thenReturn(ApiUsageLimitNotificationRuleTriggerConfig.builder());

    ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult2 =
        apiUsageLimitNotificationRuleTriggerConfigBuilder3.apiFeatures(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationRuleTriggerConfig,
        apiFeaturesResult2.notifyOn(new HashSet<>()).build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    // Act and Assert
    assertNotEquals(apiFeaturesResult.notifyOn(new HashSet<>()).build(), null);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    // Act and Assert
    assertNotEquals(
        apiFeaturesResult.notifyOn(new HashSet<>()).build(),
        "Different type to ApiUsageLimitNotificationRuleTriggerConfig");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
