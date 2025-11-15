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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AssetTypeFilterDiffblueTest {
  /**
   * Method under test: {@link AssetTypeFilter#getAssetTypes()}
   */
  @Test
  void testGetAssetTypes() {
    // Arrange and Act
    List<String> actualAssetTypes = (new AssetTypeFilter()).getAssetTypes();

    // Assert
    assertEquals(1, actualAssetTypes.size());
    assertNull(actualAssetTypes.get(0));
  }

  /**
   * Method under test: {@link AssetTypeFilter#getAssetTypes()}
   */
  @Test
  void testGetAssetTypes2() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("foo");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(assetTypes);

    // Act
    List<String> actualAssetTypes = assetTypeFilter.getAssetTypes();

    // Assert
    assertEquals(1, actualAssetTypes.size());
    assertEquals("foo", actualAssetTypes.get(0));
    assertSame(assetTypes, actualAssetTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Asset Type");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(assetTypes);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter(null);
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter(null);
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType(null);
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType(null);
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter.hashCode());
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Type");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter(null);
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Name Filter");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType(null);
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Asset Name Filter");
    assetTypes.add("Asset Type");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(assetTypes);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, null);
  }

  /**
   * Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetTypeFilter, "Different type to AssetTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AssetTypeFilter}
   *   <li>{@link AssetTypeFilter#setAssetNameFilter(String)}
   *   <li>{@link AssetTypeFilter#setAssetType(String)}
   *   <li>{@link AssetTypeFilter#setAssetTypes(List)}
   *   <li>{@link AssetTypeFilter#toString()}
   *   <li>{@link AssetTypeFilter#getAssetNameFilter()}
   *   <li>{@link AssetTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AssetTypeFilter actualAssetTypeFilter = new AssetTypeFilter();
    actualAssetTypeFilter.setAssetNameFilter("Asset Name Filter");
    actualAssetTypeFilter.setAssetType("Asset Type");
    actualAssetTypeFilter.setAssetTypes(new ArrayList<>());
    String actualToStringResult = actualAssetTypeFilter.toString();
    String actualAssetNameFilter = actualAssetTypeFilter.getAssetNameFilter();

    // Assert that nothing has changed
    assertEquals("Asset Name Filter", actualAssetNameFilter);
    assertEquals("AssetTypeFilter(assetType=Asset Type, assetTypes=[Asset Type], assetNameFilter=Asset Name Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.ASSET_TYPE, actualAssetTypeFilter.getType());
  }
}
