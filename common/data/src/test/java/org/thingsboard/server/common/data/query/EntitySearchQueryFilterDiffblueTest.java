package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EntitySearchQueryFilterDiffblueTest {
  /**
   * Test {@link EntitySearchQueryFilter#canEqual(Object)}.
   * <ul>
   *   <li>When {@link AssetSearchQueryFilter} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when AssetSearchQueryFilter (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.canEqual(Object)"})
  void testCanEqual_whenAssetSearchQueryFilter_thenReturnTrue() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act and Assert
    assertTrue(assetSearchQueryFilter.canEqual(new AssetSearchQueryFilter()));
  }

  /**
   * Test {@link EntitySearchQueryFilter#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AssetSearchQueryFilter()).canEqual("Other"));
  }

  /**
   * Test {@link EntitySearchQueryFilter#equals(Object)}, and {@link EntitySearchQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}, and {@link EntitySearchQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act and Assert
    assertEquals(assetSearchQueryFilter, assetSearchQueryFilter);
    int expectedHashCodeResult = assetSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQueryFilter.hashCode());
  }

  /**
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setRootEntity(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
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
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQueryFilter(), null);
  }

  /**
   * Test {@link EntitySearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.equals(Object)", "int EntitySearchQueryFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQueryFilter(), "Different type to EntitySearchQueryFilter");
  }

  /**
   * Test {@link EntitySearchQueryFilter#getDirection()}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntitySearchDirection EntitySearchQueryFilter.getDirection()"})
  void testGetDirection() {
    // Arrange, Act and Assert
    assertNull((new AssetSearchQueryFilter()).getDirection());
  }

  /**
   * Test {@link EntitySearchQueryFilter#getMaxLevel()}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#getMaxLevel()}
   */
  @Test
  @DisplayName("Test getMaxLevel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int EntitySearchQueryFilter.getMaxLevel()"})
  void testGetMaxLevel() {
    // Arrange, Act and Assert
    assertEquals(0, (new AssetSearchQueryFilter()).getMaxLevel());
  }

  /**
   * Test {@link EntitySearchQueryFilter#getRelationType()}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#getRelationType()}
   */
  @Test
  @DisplayName("Test getRelationType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntitySearchQueryFilter.getRelationType()"})
  void testGetRelationType() {
    // Arrange, Act and Assert
    assertNull((new AssetSearchQueryFilter()).getRelationType());
  }

  /**
   * Test {@link EntitySearchQueryFilter#getRootEntity()}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#getRootEntity()}
   */
  @Test
  @DisplayName("Test getRootEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId EntitySearchQueryFilter.getRootEntity()"})
  void testGetRootEntity() {
    // Arrange, Act and Assert
    assertNull((new AssetSearchQueryFilter()).getRootEntity());
  }

  /**
   * Test {@link EntitySearchQueryFilter#isFetchLastLevelOnly()}.
   * <ul>
   *   <li>Given {@link AssetSearchQueryFilter} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#isFetchLastLevelOnly()}
   */
  @Test
  @DisplayName("Test isFetchLastLevelOnly(); given AssetSearchQueryFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.isFetchLastLevelOnly()"})
  void testIsFetchLastLevelOnly_givenAssetSearchQueryFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AssetSearchQueryFilter()).isFetchLastLevelOnly());
  }

  /**
   * Test {@link EntitySearchQueryFilter#isFetchLastLevelOnly()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#isFetchLastLevelOnly()}
   */
  @Test
  @DisplayName("Test isFetchLastLevelOnly(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySearchQueryFilter.isFetchLastLevelOnly()"})
  void testIsFetchLastLevelOnly_thenReturnTrue() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setFetchLastLevelOnly(true);

    // Act and Assert
    assertTrue(assetSearchQueryFilter.isFetchLastLevelOnly());
  }

  /**
   * Test {@link EntitySearchQueryFilter#setDirection(EntitySearchDirection)}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#setDirection(EntitySearchDirection)}
   */
  @Test
  @DisplayName("Test setDirection(EntitySearchDirection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySearchQueryFilter.setDirection(EntitySearchDirection)"})
  void testSetDirection() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);

    // Assert
    assertEquals(EntitySearchDirection.FROM, assetSearchQueryFilter.getDirection());
  }

  /**
   * Test {@link EntitySearchQueryFilter#setFetchLastLevelOnly(boolean)}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#setFetchLastLevelOnly(boolean)}
   */
  @Test
  @DisplayName("Test setFetchLastLevelOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySearchQueryFilter.setFetchLastLevelOnly(boolean)"})
  void testSetFetchLastLevelOnly() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setFetchLastLevelOnly(true);

    // Assert
    assertTrue(assetSearchQueryFilter.isFetchLastLevelOnly());
  }

  /**
   * Test {@link EntitySearchQueryFilter#setMaxLevel(int)}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#setMaxLevel(int)}
   */
  @Test
  @DisplayName("Test setMaxLevel(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySearchQueryFilter.setMaxLevel(int)"})
  void testSetMaxLevel() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setMaxLevel(3);

    // Assert
    assertEquals(3, assetSearchQueryFilter.getMaxLevel());
  }

  /**
   * Test {@link EntitySearchQueryFilter#setRelationType(String)}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#setRelationType(String)}
   */
  @Test
  @DisplayName("Test setRelationType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySearchQueryFilter.setRelationType(String)"})
  void testSetRelationType() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();

    // Act
    assetSearchQueryFilter.setRelationType("Relation Type");

    // Assert
    assertEquals("Relation Type", assetSearchQueryFilter.getRelationType());
  }

  /**
   * Test {@link EntitySearchQueryFilter#setRootEntity(EntityId)}.
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#setRootEntity(EntityId)}
   */
  @Test
  @DisplayName("Test setRootEntity(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySearchQueryFilter.setRootEntity(EntityId)"})
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
   * Test {@link EntitySearchQueryFilter#toString()}.
   * <ul>
   *   <li>Given {@link AssetSearchQueryFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#toString()}
   */
  @Test
  @DisplayName("Test toString(); given AssetSearchQueryFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntitySearchQueryFilter.toString()"})
  void testToString_givenAssetSearchQueryFilter() {
    // Arrange, Act and Assert
    assertEquals(
        "AssetSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), assetTypes=null)",
        (new AssetSearchQueryFilter()).toString());
  }

  /**
   * Test {@link EntitySearchQueryFilter#toString()}.
   * <ul>
   *   <li>Given {@link AssetSearchQueryFilter} (default constructor) FetchLastLevelOnly is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySearchQueryFilter#toString()}
   */
  @Test
  @DisplayName("Test toString(); given AssetSearchQueryFilter (default constructor) FetchLastLevelOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntitySearchQueryFilter.toString()"})
  void testToString_givenAssetSearchQueryFilterFetchLastLevelOnlyIsTrue() {
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
