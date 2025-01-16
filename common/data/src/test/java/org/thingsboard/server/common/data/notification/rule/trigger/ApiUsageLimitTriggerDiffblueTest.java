package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageRecordState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class ApiUsageLimitTriggerDiffblueTest {
  /**
   * Test ApiUsageLimitTriggerBuilder {@link ApiUsageLimitTriggerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder#build()}
   *   <li>
   * {@link ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder#state(ApiUsageRecordState)}
   *   <li>
   * {@link ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder#status(ApiUsageStateValue)}
   *   <li>
   * {@link ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test ApiUsageLimitTriggerBuilder build()")
  void testApiUsageLimitTriggerBuilderBuild() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and
   * {@link ApiUsageLimitTrigger#hashCode()}.
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
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger buildResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult2 = ApiUsageLimitTrigger.builder();
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
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and
   * {@link ApiUsageLimitTrigger#hashCode()}.
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
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
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
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and
   * {@link ApiUsageLimitTrigger#hashCode()}.
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
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
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
   * Test {@link ApiUsageLimitTrigger#equals(Object)}, and
   * {@link ApiUsageLimitTrigger#hashCode()}.
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
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder statusResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED);
    ApiUsageLimitTrigger buildResult = statusResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(null)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    builderResult.state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any())).thenReturn(builderResult);
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder3);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder4
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    builderResult.status(ApiUsageStateValue.ENABLED);
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder.status(Mockito.<ApiUsageStateValue>any())).thenReturn(builderResult);
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder2 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder2.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder);
    ApiUsageLimitTrigger buildResult = apiUsageLimitTriggerBuilder2
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder3 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder3.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitTrigger.builder());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder apiUsageLimitTriggerBuilder4 = mock(
        ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder.class);
    when(apiUsageLimitTriggerBuilder4.state(Mockito.<ApiUsageRecordState>any()))
        .thenReturn(apiUsageLimitTriggerBuilder3);
    ApiUsageLimitTrigger buildResult2 = apiUsageLimitTriggerBuilder4
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
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
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
   *   <li>
   * {@link ApiUsageLimitTrigger#ApiUsageLimitTrigger(TenantId, ApiUsageRecordState, ApiUsageStateValue)}
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
