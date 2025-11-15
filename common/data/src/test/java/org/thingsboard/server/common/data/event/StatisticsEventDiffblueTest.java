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

class StatisticsEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEvent buildResult = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    StatisticsEvent buildResult2 = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
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
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEvent buildResult = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
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
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder statisticsEventBuilder = mock(StatisticsEvent.StatisticsEventBuilder.class);
    when(statisticsEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(StatisticsEvent.builder());
    StatisticsEvent buildResult = statisticsEventBuilder.entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    StatisticsEvent buildResult2 = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEvent buildResult = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEvent buildResult = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to StatisticsEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#toString()}
   *   <li>{@link StatisticsEvent#getErrorsOccurred()}
   *   <li>{@link StatisticsEvent#getMessagesProcessed()}
   *   <li>{@link StatisticsEvent#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    StatisticsEvent buildResult = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    long actualErrorsOccurred = buildResult.getErrorsOccurred();
    long actualMessagesProcessed = buildResult.getMessagesProcessed();

    // Assert
    assertEquals("StatisticsEvent(messagesProcessed=1, errorsOccurred=-1)", actualToStringResult);
    assertEquals(-1L, actualErrorsOccurred);
    assertEquals(1L, actualMessagesProcessed);
    assertEquals(EventType.STATS, buildResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#build()}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#entityId(UUID)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#errorsOccurred(long)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#id(UUID)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#messagesProcessed(long)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#serviceId(String)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#tenantId(TenantId)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  void testStatisticsEventBuilderBuild() {
    // Arrange and Act
    StatisticsEvent actualBuildResult = StatisticsEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .errorsOccurred(-1L)
        .id(EntityId.NULL_UUID)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getEntityId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    assertEquals(-1L, actualBuildResult.getErrorsOccurred());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(1L, actualBuildResult.getMessagesProcessed());
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.STATS, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
