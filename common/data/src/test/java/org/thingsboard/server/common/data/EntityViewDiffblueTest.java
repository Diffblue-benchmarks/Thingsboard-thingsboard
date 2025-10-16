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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link EntityView#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewId EntityView.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new EntityView().getExternalId());
  }

  /**
   * Test {@link EntityView#EntityView(EntityView)}.
   *
   * <p>Method under test: {@link EntityView#EntityView(EntityView)}
   */
  @Test
  @DisplayName("Test new EntityView(EntityView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String, String,
   * TelemetryEntityView, long, long, EntityViewId, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String,
   * String, TelemetryEntityView, long, long, EntityViewId, Long)}
   */
  @Test
  @DisplayName(
      "Test new EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long); when 'null'; then EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityView.<init>(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)"
  })
  void testNewEntityView_whenNull_thenEntityIdReturnTenantId() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TelemetryEntityView keys = new TelemetryEntityView();

    // Act
    EntityView actualEntityView =
        new EntityView(
            TenantId.SYS_TENANT_ID,
            TenantId.SYS_TENANT_ID,
            customerId,
            "Name",
            "Type",
            keys,
            1L,
            1L,
            null,
            1L);

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
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, entityId);
    assertSame(tenantId, actualEntityView.getTenantId());
  }

  /**
   * Test {@link EntityView#getId()}.
   *
   * <p>Method under test: {@link EntityView#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewId EntityView.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new EntityView().getId());
  }

  /**
   * Test {@link EntityView#getCreatedTime()}.
   *
   * <p>Method under test: {@link EntityView#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long EntityView.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new EntityView().getCreatedTime());
  }

  /**
   * Test {@link EntityView#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link EntityView#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.fasterxml.jackson.databind.JsonNode EntityView.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new EntityView().getAdditionalInfo());
  }

  /**
   * Test {@link EntityView#equals(Object)}, and {@link EntityView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityView entityView2 = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView2);
    assertEquals(entityView.hashCode(), entityView2.hashCode());
  }

  /**
   * Test {@link EntityView#equals(Object)}, and {@link EntityView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityView());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertNotEquals(entityView, new EntityViewInfo());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(1L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(1L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setEntityId(TenantId.SYS_TENANT_ID);
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setTenantId(TenantId.SYS_TENANT_ID);
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setCustomerId(new CustomerId(EntityId.NULL_UUID));
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setName("Name");
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setType("Type");
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setKeys(new TelemetryEntityView());
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setVersion(1L);
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn("foo");
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn("foo");
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(new CustomerId(EntityId.NULL_UUID));
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(new EntityViewId(EntityId.NULL_UUID));
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(new TelemetryEntityView());
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(1L);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setCustomerId(new CustomerId(EntityId.NULL_UUID));
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(new CustomerId(EntityId.NULL_UUID));
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setEntityId(TenantId.SYS_TENANT_ID);
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setTenantId(TenantId.SYS_TENANT_ID);
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setKeys(new TelemetryEntityView());
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(new TelemetryEntityView());
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(null);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setVersion(1L);
    entityViewInfo.setStartTimeMs(1L);

    EntityViewInfo entityViewInfo2 = mock(EntityViewInfo.class);
    when(entityViewInfo2.getName()).thenReturn(null);
    when(entityViewInfo2.getType()).thenReturn(null);
    when(entityViewInfo2.getCustomerId()).thenReturn(null);
    when(entityViewInfo2.getEntityId()).thenReturn(null);
    when(entityViewInfo2.getExternalId()).thenReturn(null);
    when(entityViewInfo2.getTenantId()).thenReturn(null);
    when(entityViewInfo2.getKeys()).thenReturn(null);
    when(entityViewInfo2.isCustomerIsPublic()).thenReturn(true);
    when(entityViewInfo2.getCustomerTitle()).thenReturn("Dr");
    when(entityViewInfo2.getVersion()).thenReturn(1L);
    when(entityViewInfo2.getEndTimeMs()).thenReturn(0L);
    when(entityViewInfo2.getStartTimeMs()).thenReturn(1L);
    when(entityViewInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), null);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityView.equals(Object)", "int EntityView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), "Different type to EntityView");
  }
}
