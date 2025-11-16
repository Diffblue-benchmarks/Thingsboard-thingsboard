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
package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssetTypeFilterDiffblueTest {
  /**
   * Test {@link AssetTypeFilter#equals(Object)}, and {@link AssetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    assertEquals(assetTypeFilter.hashCode(), assetTypeFilter2.hashCode());
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}, and {@link AssetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType(null);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType(null);

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    assertEquals(assetTypeFilter.hashCode(), assetTypeFilter2.hashCode());
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}, and {@link AssetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter.hashCode());
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Relation Type");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(assetTypes);
    assetTypeFilter.setRelationType("Relation Type");

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType(null);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("org.thingsboard.server.dao.asset.AssetTypeFilter");

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, null);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, "Different type to AssetTypeFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AssetTypeFilter}
   *   <li>{@link AssetTypeFilter#setAssetTypes(List)}
   *   <li>{@link AssetTypeFilter#setRelationType(String)}
   *   <li>{@link AssetTypeFilter#toString()}
   *   <li>{@link AssetTypeFilter#getAssetTypes()}
   *   <li>{@link AssetTypeFilter#getRelationType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetTypeFilter.<init>()",
    "List AssetTypeFilter.getAssetTypes()",
    "String AssetTypeFilter.getRelationType()",
    "void AssetTypeFilter.setAssetTypes(List)",
    "void AssetTypeFilter.setRelationType(String)",
    "String AssetTypeFilter.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetTypeFilter actualAssetTypeFilter = new AssetTypeFilter();
    ArrayList<String> assetTypes = new ArrayList<>();
    actualAssetTypeFilter.setAssetTypes(assetTypes);
    actualAssetTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualAssetTypeFilter.toString();
    List<String> actualAssetTypes = actualAssetTypeFilter.getAssetTypes();

    // Assert
    assertEquals(
        "AssetTypeFilter(relationType=Relation Type, assetTypes=[])", actualToStringResult);
    assertEquals("Relation Type", actualAssetTypeFilter.getRelationType());
    assertTrue(actualAssetTypes.isEmpty());
    assertSame(assetTypes, actualAssetTypes);
  }
}
