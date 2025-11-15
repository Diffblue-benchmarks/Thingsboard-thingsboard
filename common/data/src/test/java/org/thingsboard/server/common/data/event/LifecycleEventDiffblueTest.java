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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class LifecycleEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#equals(Object)}
   *   <li>{@link LifecycleEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifecycleEvent buildResult = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    LifecycleEvent buildResult2 = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#equals(Object)}
   *   <li>{@link LifecycleEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifecycleEvent buildResult = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifecycleEvent.LifecycleEventBuilder lifecycleEventBuilder = mock(LifecycleEvent.LifecycleEventBuilder.class);
    when(lifecycleEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(LifecycleEvent.builder());
    LifecycleEvent buildResult = lifecycleEventBuilder.entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    LifecycleEvent buildResult2 = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifecycleEvent buildResult = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifecycleEvent buildResult = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  void testGettersAndSetters() {
    // Arrange
    LifecycleEvent buildResult = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  void testLifecycleEventBuilderBuild() {
    // Arrange and Act
    LifecycleEvent actualBuildResult = LifecycleEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getEntityId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Lc Event Type", actualBuildResult.getLcEventType());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.LC_EVENT, actualBuildResult.getType());
    assertTrue(actualBuildResult.isSuccess());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
