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

class ErrorEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent#equals(Object)}
   *   <li>{@link ErrorEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    ErrorEvent buildResult2 = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
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
   *   <li>{@link ErrorEvent#equals(Object)}
   *   <li>{@link ErrorEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEvent.ErrorEventBuilder errorEventBuilder = mock(ErrorEvent.ErrorEventBuilder.class);
    when(errorEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(ErrorEvent.builder());
    ErrorEvent buildResult = errorEventBuilder.entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    ErrorEvent buildResult2 = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ErrorEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent.ErrorEventBuilder#build()}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#entityId(UUID)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#error(String)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#id(UUID)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#method(String)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#serviceId(String)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#tenantId(TenantId)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  void testErrorEventBuilderBuild() {
    // Arrange and Act
    ErrorEvent actualBuildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getEntityId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Method", actualBuildResult.getMethod());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.ERROR, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent#setError(String)}
   *   <li>{@link ErrorEvent#setMethod(String)}
   *   <li>{@link ErrorEvent#toString()}
   *   <li>{@link ErrorEvent#getError()}
   *   <li>{@link ErrorEvent#getMethod()}
   *   <li>{@link ErrorEvent#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    buildResult.setError("An error occurred");
    buildResult.setMethod("Method");
    String actualToStringResult = buildResult.toString();
    String actualError = buildResult.getError();
    String actualMethod = buildResult.getMethod();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("ErrorEvent(method=Method, error=An error occurred)", actualToStringResult);
    assertEquals("Method", actualMethod);
    assertEquals(EventType.ERROR, buildResult.getType());
  }
}
