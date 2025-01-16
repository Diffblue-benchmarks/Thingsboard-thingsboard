package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.LifecycleEvent.LifecycleEventBuilder;
import org.thingsboard.server.common.data.id.TenantId;

class LifecycleEventDiffblueTest {
  /**
   * Test {@link LifecycleEvent#equals(Object)}, and
   * {@link LifecycleEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#equals(Object)}
   *   <li>{@link LifecycleEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    LifecycleEvent.LifecycleEventBuilder builderResult2 = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult2 = builderResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult2 = errorResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}, and
   * {@link LifecycleEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#equals(Object)}
   *   <li>{@link LifecycleEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder lifecycleEventBuilder = mock(LifecycleEvent.LifecycleEventBuilder.class);
    when(lifecycleEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(LifecycleEvent.builder());
    LifecycleEvent.LifecycleEventBuilder errorResult = lifecycleEventBuilder
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult2 = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult2 = errorResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to LifecycleEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#setError(String)}
   *   <li>{@link LifecycleEvent#toString()}
   *   <li>{@link LifecycleEvent#getError()}
   *   <li>{@link LifecycleEvent#getLcEventType()}
   *   <li>{@link LifecycleEvent#getType()}
   *   <li>{@link LifecycleEvent#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEvent.LifecycleEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    buildResult.setError("An error occurred");
    String actualToStringResult = buildResult.toString();
    String actualError = buildResult.getError();
    String actualLcEventType = buildResult.getLcEventType();
    EventType actualType = buildResult.getType();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Lc Event Type", actualLcEventType);
    assertEquals("LifecycleEvent(lcEventType=Lc Event Type, success=true, error=An error occurred)",
        actualToStringResult);
    assertEquals(EventType.LC_EVENT, actualType);
    assertTrue(buildResult.isSuccess());
  }

  /**
   * Test LifecycleEventBuilder {@link LifecycleEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#build()}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#entityId(UUID)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#error(String)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#id(UUID)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#lcEventType(String)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#serviceId(String)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#success(boolean)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#tenantId(TenantId)}
   *   <li>{@link LifecycleEvent.LifecycleEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test LifecycleEventBuilder build()")
  void testLifecycleEventBuilderBuild() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    LifecycleEvent.LifecycleEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    LifecycleEvent actualBuildResult = errorResult.id(id)
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    UUID entityId2 = actualBuildResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualBuildResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Lc Event Type", actualBuildResult.getLcEventType());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.LC_EVENT, actualBuildResult.getType());
    assertTrue(actualBuildResult.isSuccess());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualBuildResult.getId().getId());
  }
}
