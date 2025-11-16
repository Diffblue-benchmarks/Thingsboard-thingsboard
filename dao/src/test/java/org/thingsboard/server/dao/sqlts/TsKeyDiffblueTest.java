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
package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKeyDiffblueTest {
  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 1);
    TsKey tsKey2 = new TsKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey2);
    assertEquals(tsKey.hashCode(), tsKey2.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKey tsKey = new TsKey(null, 1);
    TsKey tsKey2 = new TsKey(null, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey2);
    assertEquals(tsKey.hashCode(), tsKey2.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKey tsKey = new TsKey(UUID.randomUUID(), 1);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(ModelConstants.NULL_UUID, 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKey tsKey = new TsKey(null, 1);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(ModelConstants.NULL_UUID, 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 3);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(ModelConstants.NULL_UUID, 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKey(ModelConstants.NULL_UUID, 1), null);
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKey(ModelConstants.NULL_UUID, 1), "Different type to TsKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKey#TsKey(UUID, int)}
   *   <li>{@link TsKey#toString()}
   *   <li>{@link TsKey#getEntityId()}
   *   <li>{@link TsKey#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKey.<init>(UUID, int)",
    "UUID TsKey.getEntityId()",
    "int TsKey.getKey()",
    "String TsKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    TsKey actualTsKey = new TsKey(entityId, 1);
    String actualToStringResult = actualTsKey.toString();
    UUID actualEntityId = actualTsKey.getEntityId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "TsKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1)", actualToStringResult);
    assertEquals(1, actualTsKey.getKey());
    assertSame(entityId, actualEntityId);
  }
}
