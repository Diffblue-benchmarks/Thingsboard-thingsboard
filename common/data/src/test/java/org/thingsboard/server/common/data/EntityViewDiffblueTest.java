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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;

class EntityViewDiffblueTest {
  /**
   * Test {@link EntityView#getExternalId()}.
   * <p>
   * Method under test: {@link EntityView#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityViewId EntityView.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getExternalId());
  }

  /**
   * Test {@link EntityView#EntityView(EntityView)}.
   * <p>
   * Method under test: {@link EntityView#EntityView(EntityView)}
   */
  @Test
  @DisplayName("Test new EntityView(EntityView)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityView.<init>(EntityView)"})
  void testNewEntityView() {
    // Arrange and Act
    EntityView actualEntityView = new EntityView(new EntityView());

    // Assert
    assertTrue(actualEntityView.getAdditionalInfo() instanceof NullNode);
    assertNull(actualEntityView.getVersion());
    assertNull(actualEntityView.getName());
    assertNull(actualEntityView.getType());
    assertNull(actualEntityView.getUuidId());
    assertNull(actualEntityView.getCustomerId());
    assertNull(actualEntityView.getEntityId());
    assertNull(actualEntityView.getExternalId());
    assertNull(actualEntityView.getId());
    assertNull(actualEntityView.getTenantId());
    assertNull(actualEntityView.getKeys());
    assertEquals(0L, actualEntityView.getCreatedTime());
    assertEquals(0L, actualEntityView.getEndTimeMs());
    assertEquals(0L, actualEntityView.getStartTimeMs());
  }

  /**
   * Test {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)}
   */
  @Test
  @DisplayName("Test new EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long); when 'null'; then EntityId return TenantId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void EntityView.<init>(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)"})
  void testNewEntityView_whenNull_thenEntityIdReturnTenantId() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TelemetryEntityView keys = new TelemetryEntityView();

    // Act
    EntityView actualEntityView = new EntityView(TenantId.SYS_TENANT_ID, tenantId, customerId, "Name", "Type", keys, 1L,
        1L, null, 1L);

    // Assert
    EntityId entityId = actualEntityView.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("Name", actualEntityView.getName());
    assertEquals("Type", actualEntityView.getType());
    assertNull(actualEntityView.getAdditionalInfo());
    assertNull(actualEntityView.getUuidId());
    assertNull(actualEntityView.getExternalId());
    assertNull(actualEntityView.getId());
    assertEquals(0L, actualEntityView.getCreatedTime());
    assertEquals(1L, actualEntityView.getVersion().longValue());
    assertEquals(1L, actualEntityView.getEndTimeMs());
    assertEquals(1L, actualEntityView.getStartTimeMs());
    assertSame(customerId, actualEntityView.getCustomerId());
    assertSame(keys, actualEntityView.getKeys());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, entityId);
    assertSame(tenantId2, actualEntityView.getTenantId());
  }

  /**
   * Test {@link EntityView#getId()}.
   * <p>
   * Method under test: {@link EntityView#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityViewId EntityView.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getId());
  }

  /**
   * Test {@link EntityView#getCreatedTime()}.
   * <p>
   * Method under test: {@link EntityView#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityView.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EntityView()).getCreatedTime());
  }

  /**
   * Test {@link EntityView#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link EntityView#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.fasterxml.jackson.databind.JsonNode EntityView.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getAdditionalInfo());
  }

  /**
   * Test {@link EntityView#equals(Object)}, and {@link EntityView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityView entityView2 = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView2);
    int expectedHashCodeResult = entityView.hashCode();
    assertEquals(expectedHashCodeResult, entityView2.hashCode());
  }

  /**
   * Test {@link EntityView#equals(Object)}, and {@link EntityView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView);
    int expectedHashCodeResult = entityView.hashCode();
    assertEquals(expectedHashCodeResult, entityView.hashCode());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityView());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertNotEquals(entityView, new EntityViewInfo());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityViewInfo entityViewInfo = mock(EntityViewInfo.class);
    when(entityViewInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityView, entityViewInfo);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), null);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), "Different type to EntityView");
  }
}
