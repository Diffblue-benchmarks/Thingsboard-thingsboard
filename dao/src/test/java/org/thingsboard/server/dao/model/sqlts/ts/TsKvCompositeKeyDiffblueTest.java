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
package org.thingsboard.server.dao.model.sqlts.ts;

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

public class TsKvCompositeKeyDiffblueTest {
  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and {@link TsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey();

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey2);
    assertEquals(tsKvCompositeKey.hashCode(), tsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and {@link TsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);
    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey2);
    assertEquals(tsKvCompositeKey.hashCode(), tsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and {@link TsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    tsKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    tsKvCompositeKey.setTs(1L);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();

    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey();
    tsKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, tsKvCompositeKey2);
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvCompositeKey(), null);
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvCompositeKey(), "Different type to TsKvCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#TsKvCompositeKey()}
   *   <li>{@link TsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvCompositeKey#setKey(int)}
   *   <li>{@link TsKvCompositeKey#setTs(long)}
   *   <li>{@link TsKvCompositeKey#toString()}
   *   <li>{@link TsKvCompositeKey#getEntityId()}
   *   <li>{@link TsKvCompositeKey#getKey()}
   *   <li>{@link TsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKvCompositeKey.<init>()",
    "void TsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TsKvCompositeKey.getEntityId()",
    "int TsKvCompositeKey.getKey()",
    "long TsKvCompositeKey.getTs()",
    "void TsKvCompositeKey.setEntityId(UUID)",
    "void TsKvCompositeKey.setKey(int)",
    "void TsKvCompositeKey.setTs(long)",
    "String TsKvCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TsKvCompositeKey actualTsKvCompositeKey = new TsKvCompositeKey();
    UUID entityId = ModelConstants.NULL_UUID;
    actualTsKvCompositeKey.setEntityId(entityId);
    actualTsKvCompositeKey.setKey(1);
    actualTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTsKvCompositeKey.toString();
    UUID actualEntityId = actualTsKvCompositeKey.getEntityId();
    int actualKey = actualTsKvCompositeKey.getKey();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "TsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTsKvCompositeKey.getTs());
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#TsKvCompositeKey(UUID, int, long)}
   *   <li>{@link TsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvCompositeKey#setKey(int)}
   *   <li>{@link TsKvCompositeKey#setTs(long)}
   *   <li>{@link TsKvCompositeKey#toString()}
   *   <li>{@link TsKvCompositeKey#getEntityId()}
   *   <li>{@link TsKvCompositeKey#getKey()}
   *   <li>{@link TsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKvCompositeKey.<init>()",
    "void TsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TsKvCompositeKey.getEntityId()",
    "int TsKvCompositeKey.getKey()",
    "long TsKvCompositeKey.getTs()",
    "void TsKvCompositeKey.setEntityId(UUID)",
    "void TsKvCompositeKey.setKey(int)",
    "void TsKvCompositeKey.setTs(long)",
    "String TsKvCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    TsKvCompositeKey actualTsKvCompositeKey = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);
    UUID entityId = ModelConstants.NULL_UUID;
    actualTsKvCompositeKey.setEntityId(entityId);
    actualTsKvCompositeKey.setKey(1);
    actualTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTsKvCompositeKey.toString();
    UUID actualEntityId = actualTsKvCompositeKey.getEntityId();
    int actualKey = actualTsKvCompositeKey.getKey();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "TsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTsKvCompositeKey.getTs());
    assertSame(entityId, actualEntityId);
  }
}
