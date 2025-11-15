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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EntitySearchQueryFilterDiffblueTest {
  /**
   * Method under test: {@link EntitySearchQueryFilter#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new AssetSearchQueryFilter()).canEqual("Other"));
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act and Assert
    assertTrue(assetSearchQueryFilter.canEqual(new AssetSearchQueryFilter()));
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    AssetSearchQueryFilter assetSearchQueryFilter2 = new AssetSearchQueryFilter();

    // Act and Assert
    assertEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
    int expectedHashCodeResult = assetSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQueryFilter2.hashCode());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act and Assert
    assertEquals(assetSearchQueryFilter, assetSearchQueryFilter);
    int expectedHashCodeResult = assetSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQueryFilter.hashCode());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, deviceSearchQueryFilter);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(true);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(3);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(TenantId.SYS_TENANT_ID);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(true);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(TenantId.SYS_TENANT_ID);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(TenantId.SYS_TENANT_ID);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(true);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(TenantId.SYS_TENANT_ID);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(null);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(TenantId.SYS_TENANT_ID);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn(null);
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(null);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setRootEntity(new AlarmId(EntityId.NULL_UUID));
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(TenantId.SYS_TENANT_ID);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setRelationType("Relation Type");
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(null);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setRelationType("org.thingsboard.server.common.data.query.EntitySearchQueryFilter");
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn("Relation Type");
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(null);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn(null);
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(null);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setDirection(EntitySearchDirection.TO);
    AssetSearchQueryFilter assetSearchQueryFilter2 = mock(AssetSearchQueryFilter.class);
    when(assetSearchQueryFilter2.isFetchLastLevelOnly()).thenReturn(false);
    when(assetSearchQueryFilter2.getMaxLevel()).thenReturn(0);
    when(assetSearchQueryFilter2.getRelationType()).thenReturn(null);
    when(assetSearchQueryFilter2.getAssetTypes()).thenReturn(new ArrayList<>());
    when(assetSearchQueryFilter2.getRootEntity()).thenReturn(null);
    when(assetSearchQueryFilter2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(assetSearchQueryFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQueryFilter(), null);
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQueryFilter(), "Different type to EntitySearchQueryFilter");
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#getDirection()}
   */
  @Test
  void testGetDirection() {
    // Arrange, Act and Assert
    assertNull((new AssetSearchQueryFilter()).getDirection());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#getMaxLevel()}
   */
  @Test
  void testGetMaxLevel() {
    // Arrange, Act and Assert
    assertEquals(0, (new AssetSearchQueryFilter()).getMaxLevel());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#getRelationType()}
   */
  @Test
  void testGetRelationType() {
    // Arrange, Act and Assert
    assertNull((new AssetSearchQueryFilter()).getRelationType());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#getRootEntity()}
   */
  @Test
  void testGetRootEntity() {
    // Arrange, Act and Assert
    assertNull((new AssetSearchQueryFilter()).getRootEntity());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#isFetchLastLevelOnly()}
   */
  @Test
  void testIsFetchLastLevelOnly() {
    // Arrange, Act and Assert
    assertFalse((new AssetSearchQueryFilter()).isFetchLastLevelOnly());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#isFetchLastLevelOnly()}
   */
  @Test
  void testIsFetchLastLevelOnly2() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setFetchLastLevelOnly(true);

    // Act and Assert
    assertTrue(assetSearchQueryFilter.isFetchLastLevelOnly());
  }

  /**
   * Method under test:
   * {@link EntitySearchQueryFilter#setDirection(EntitySearchDirection)}
   */
  @Test
  void testSetDirection() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);

    // Assert
    assertEquals(EntitySearchDirection.FROM, assetSearchQueryFilter.getDirection());
  }

  /**
   * Method under test:
   * {@link EntitySearchQueryFilter#setFetchLastLevelOnly(boolean)}
   */
  @Test
  void testSetFetchLastLevelOnly() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setFetchLastLevelOnly(true);

    // Assert
    assertTrue(assetSearchQueryFilter.isFetchLastLevelOnly());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#setMaxLevel(int)}
   */
  @Test
  void testSetMaxLevel() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setMaxLevel(3);

    // Assert
    assertEquals(3, assetSearchQueryFilter.getMaxLevel());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#setRelationType(String)}
   */
  @Test
  void testSetRelationType() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setRelationType("Relation Type");

    // Assert
    assertEquals("Relation Type", assetSearchQueryFilter.getRelationType());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#setRootEntity(EntityId)}
   */
  @Test
  void testSetRootEntity() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    TenantId rootEntity = TenantId.SYS_TENANT_ID;

    // Act
    assetSearchQueryFilter.setRootEntity(rootEntity);

    // Assert
    TenantId expectedRootEntity = rootEntity.SYS_TENANT_ID;
    assertSame(expectedRootEntity, assetSearchQueryFilter.getRootEntity());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AssetSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), assetTypes=null)",
        (new AssetSearchQueryFilter()).toString());
  }

  /**
   * Method under test: {@link EntitySearchQueryFilter#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setFetchLastLevelOnly(true);

    // Act and Assert
    assertEquals(
        "AssetSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=true), assetTypes=null)",
        assetSearchQueryFilter.toString());
  }
}
