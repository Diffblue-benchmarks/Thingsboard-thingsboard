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
package org.thingsboard.monitoring.data.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;

class LatestValueCmdDiffblueTest {
  /**
   * Test {@link LatestValueCmd#equals(Object)}, and {@link LatestValueCmd#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LatestValueCmd#equals(Object)}
   *   <li>{@link LatestValueCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatestValueCmd.equals(Object)", "int LatestValueCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    LatestValueCmd latestValueCmd2 = new LatestValueCmd();
    latestValueCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(latestValueCmd, latestValueCmd2);
    assertEquals(latestValueCmd.hashCode(), latestValueCmd2.hashCode());
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}, and {@link LatestValueCmd#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LatestValueCmd#equals(Object)}
   *   <li>{@link LatestValueCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatestValueCmd.equals(Object)", "int LatestValueCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(latestValueCmd, latestValueCmd);
    int expectedHashCodeResult = latestValueCmd.hashCode();
    assertEquals(expectedHashCodeResult, latestValueCmd.hashCode());
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatestValueCmd.equals(Object)", "int LatestValueCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<EntityKey> keys = new ArrayList<>();
    keys.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(keys);

    LatestValueCmd latestValueCmd2 = new LatestValueCmd();
    latestValueCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, latestValueCmd2);
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatestValueCmd.equals(Object)", "int LatestValueCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, null);
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatestValueCmd.equals(Object)", "int LatestValueCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, "Different type to LatestValueCmd");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LatestValueCmd}
   *   <li>{@link LatestValueCmd#setKeys(List)}
   *   <li>{@link LatestValueCmd#toString()}
   *   <li>{@link LatestValueCmd#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LatestValueCmd.<init>()",
    "List LatestValueCmd.getKeys()",
    "void LatestValueCmd.setKeys(List)",
    "String LatestValueCmd.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LatestValueCmd actualLatestValueCmd = new LatestValueCmd();
    ArrayList<EntityKey> keys = new ArrayList<>();
    actualLatestValueCmd.setKeys(keys);
    String actualToStringResult = actualLatestValueCmd.toString();
    List<EntityKey> actualKeys = actualLatestValueCmd.getKeys();

    // Assert
    assertEquals("LatestValueCmd(keys=[])", actualToStringResult);
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
