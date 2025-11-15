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
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageRecordState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {ApiUsageLimitTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class ApiUsageLimitTriggerDiffblueTest {
  @Autowired
  private ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder;

  /**
   * Test ApiUsageLimitTriggerBuilder {@link ApiUsageLimitTriggerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTriggerBuilder#build()}
   *   <li>{@link ApiUsageLimitTriggerBuilder#state(ApiUsageRecordState)}
   *   <li>{@link ApiUsageLimitTriggerBuilder#status(ApiUsageStateValue)}
   *   <li>{@link ApiUsageLimitTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test ApiUsageLimitTriggerBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageLimitTriggerBuilder.<init>()",
      "ApiUsageLimitTrigger ApiUsageLimitTriggerBuilder.build()",
      "ApiUsageLimitTriggerBuilder ApiUsageLimitTriggerBuilder.state(ApiUsageRecordState)",
      "ApiUsageLimitTriggerBuilder ApiUsageLimitTriggerBuilder.status(ApiUsageStateValue)",
      "ApiUsageLimitTriggerBuilder ApiUsageLimitTriggerBuilder.tenantId(TenantId)",
      "String ApiUsageLimitTriggerBuilder.toString()"})
  void testApiUsageLimitTriggerBuilderBuild() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageRecordState state = new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L,
        42L);

    // Act
    ApiUsageLimitTrigger actualBuildResult = builderResult.state(state)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    EntityId originatorEntityId = actualBuildResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("API_USAGE_LIMIT:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualBuildResult.getDeduplicationKey());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(ApiUsageStateValue.ENABLED, actualBuildResult.getStatus());
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT, actualBuildResult.getType());
    assertFalse(actualBuildResult.deduplicate());
    assertSame(state, actualBuildResult.getState());
    assertSame(originatorEntityId, actualBuildResult.getTenantId());
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and {@link ApiUsageLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger#equals(Object)}
   *   <li>{@link ApiUsageLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder builderResult2 = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult2 = builderResult2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and {@link ApiUsageLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger#equals(Object)}
   *   <li>{@link ApiUsageLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and {@link ApiUsageLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger#equals(Object)}
   *   <li>{@link ApiUsageLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder3);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder4
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and {@link ApiUsageLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger#equals(Object)}
   *   <li>{@link ApiUsageLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder2);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder3
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder5 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder5.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder4);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder6 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder6.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder5);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder6
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and {@link ApiUsageLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger#equals(Object)}
   *   <li>{@link ApiUsageLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult2 = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(null)
        .build();
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult2 = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder3
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder3);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder5 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder5.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder4);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder5
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    builderResult.state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder2);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder3
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder5 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder5.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder4);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder6 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder6.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder5);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder6
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    builderResult.status(ApiUsageStateValue.ENABLED);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder2);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder3
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder5 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder5.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitTriggerBuilder4);
    ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder6 = mock(ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder6.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder5);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder6
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ApiUsageLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitTrigger.equals(Object)", "int ApiUsageLimitTrigger.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ApiUsageLimitTrigger");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger#ApiUsageLimitTrigger(TenantId, ApiUsageRecordState, ApiUsageStateValue)}
   *   <li>{@link ApiUsageLimitTrigger#toString()}
   *   <li>{@link ApiUsageLimitTrigger#getOriginatorEntityId()}
   *   <li>{@link ApiUsageLimitTrigger#getState()}
   *   <li>{@link ApiUsageLimitTrigger#getStatus()}
   *   <li>{@link ApiUsageLimitTrigger#getTenantId()}
   *   <li>{@link ApiUsageLimitTrigger#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageLimitTrigger.<init>(TenantId, ApiUsageRecordState, ApiUsageStateValue)",
      "EntityId ApiUsageLimitTrigger.getOriginatorEntityId()", "ApiUsageRecordState ApiUsageLimitTrigger.getState()",
      "ApiUsageStateValue ApiUsageLimitTrigger.getStatus()", "TenantId ApiUsageLimitTrigger.getTenantId()",
      "NotificationRuleTriggerType ApiUsageLimitTrigger.getType()", "String ApiUsageLimitTrigger.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ApiUsageRecordState state = new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L,
        42L);

    // Act
    ApiUsageLimitTrigger actualApiUsageLimitTrigger = new ApiUsageLimitTrigger(TenantId.SYS_TENANT_ID, state,
        ApiUsageStateValue.ENABLED);
    String actualToStringResult = actualApiUsageLimitTrigger.toString();
    EntityId actualOriginatorEntityId = actualApiUsageLimitTrigger.getOriginatorEntityId();
    ApiUsageRecordState actualState = actualApiUsageLimitTrigger.getState();
    ApiUsageStateValue actualStatus = actualApiUsageLimitTrigger.getStatus();
    TenantId actualTenantId = actualApiUsageLimitTrigger.getTenantId();

    // Assert
    assertEquals(
        "ApiUsageLimitTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, state=ApiUsageRecordState(apiFeature"
            + "=TRANSPORT, key=TRANSPORT_MSG_COUNT, threshold=1, value=42), status=ENABLED)",
        actualToStringResult);
    assertEquals(ApiUsageStateValue.ENABLED, actualStatus);
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT, actualApiUsageLimitTrigger.getType());
    assertSame(state, actualState);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
