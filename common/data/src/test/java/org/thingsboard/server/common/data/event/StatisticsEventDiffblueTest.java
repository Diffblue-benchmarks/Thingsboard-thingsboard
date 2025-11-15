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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.StatisticsEvent.StatisticsEventBuilder;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {StatisticsEventBuilder.class})
@ExtendWith(SpringExtension.class)
class StatisticsEventDiffblueTest {
  @Autowired
  private StatisticsEventBuilder statisticsEventBuilder;

  /**
   * Test {@link StatisticsEvent#equals(Object)}, and {@link StatisticsEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
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
   * Test {@link StatisticsEvent#equals(Object)}, and {@link StatisticsEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
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
   * Test {@link StatisticsEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEventBuilder statisticsEventBuilder = mock(StatisticsEventBuilder.class);
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
   * Test {@link StatisticsEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
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
   * Test {@link StatisticsEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#toString()}
   *   <li>{@link StatisticsEvent#getErrorsOccurred()}
   *   <li>{@link StatisticsEvent#getMessagesProcessed()}
   *   <li>{@link StatisticsEvent#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long StatisticsEvent.getErrorsOccurred()", "long StatisticsEvent.getMessagesProcessed()",
      "EventType StatisticsEvent.getType()", "String StatisticsEvent.toString()"})
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
   * Test StatisticsEventBuilder {@link StatisticsEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventBuilder#build()}
   *   <li>{@link StatisticsEventBuilder#entityId(UUID)}
   *   <li>{@link StatisticsEventBuilder#errorsOccurred(long)}
   *   <li>{@link StatisticsEventBuilder#id(UUID)}
   *   <li>{@link StatisticsEventBuilder#messagesProcessed(long)}
   *   <li>{@link StatisticsEventBuilder#serviceId(String)}
   *   <li>{@link StatisticsEventBuilder#tenantId(TenantId)}
   *   <li>{@link StatisticsEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test StatisticsEventBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatisticsEventBuilder.<init>()", "StatisticsEvent StatisticsEventBuilder.build()",
      "StatisticsEventBuilder StatisticsEventBuilder.entityId(UUID)",
      "StatisticsEventBuilder StatisticsEventBuilder.errorsOccurred(long)",
      "StatisticsEventBuilder StatisticsEventBuilder.id(UUID)",
      "StatisticsEventBuilder StatisticsEventBuilder.messagesProcessed(long)",
      "StatisticsEventBuilder StatisticsEventBuilder.serviceId(String)",
      "StatisticsEventBuilder StatisticsEventBuilder.tenantId(TenantId)", "String StatisticsEventBuilder.toString()",
      "StatisticsEventBuilder StatisticsEventBuilder.ts(long)"})
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
