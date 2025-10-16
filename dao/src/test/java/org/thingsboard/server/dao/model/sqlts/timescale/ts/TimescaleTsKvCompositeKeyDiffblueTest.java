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
package org.thingsboard.server.dao.model.sqlts.timescale.ts;

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

public class TimescaleTsKvCompositeKeyDiffblueTest {
  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and {@link
   * TimescaleTsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey();

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
    assertEquals(timescaleTsKvCompositeKey.hashCode(), timescaleTsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and {@link
   * TimescaleTsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey =
        new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 =
        new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
    assertEquals(timescaleTsKvCompositeKey.hashCode(), timescaleTsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and {@link
   * TimescaleTsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey =
        new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey.setTs(1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();

    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimescaleTsKvCompositeKey(), null);
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimescaleTsKvCompositeKey(), "Different type to TimescaleTsKvCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#TimescaleTsKvCompositeKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TimescaleTsKvCompositeKey#setKey(int)}
   *   <li>{@link TimescaleTsKvCompositeKey#setTs(long)}
   *   <li>{@link TimescaleTsKvCompositeKey#toString()}
   *   <li>{@link TimescaleTsKvCompositeKey#getEntityId()}
   *   <li>{@link TimescaleTsKvCompositeKey#getKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvCompositeKey.<init>()",
    "void TimescaleTsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TimescaleTsKvCompositeKey.getEntityId()",
    "int TimescaleTsKvCompositeKey.getKey()",
    "long TimescaleTsKvCompositeKey.getTs()",
    "void TimescaleTsKvCompositeKey.setEntityId(UUID)",
    "void TimescaleTsKvCompositeKey.setKey(int)",
    "void TimescaleTsKvCompositeKey.setTs(long)",
    "String TimescaleTsKvCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TimescaleTsKvCompositeKey actualTimescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    UUID entityId = ModelConstants.NULL_UUID;
    actualTimescaleTsKvCompositeKey.setEntityId(entityId);
    actualTimescaleTsKvCompositeKey.setKey(1);
    actualTimescaleTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTimescaleTsKvCompositeKey.toString();
    UUID actualEntityId = actualTimescaleTsKvCompositeKey.getEntityId();
    int actualKey = actualTimescaleTsKvCompositeKey.getKey();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "TimescaleTsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTimescaleTsKvCompositeKey.getTs());
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
   *   <li>{@link TimescaleTsKvCompositeKey#TimescaleTsKvCompositeKey(UUID, int, long)}
   *   <li>{@link TimescaleTsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TimescaleTsKvCompositeKey#setKey(int)}
   *   <li>{@link TimescaleTsKvCompositeKey#setTs(long)}
   *   <li>{@link TimescaleTsKvCompositeKey#toString()}
   *   <li>{@link TimescaleTsKvCompositeKey#getEntityId()}
   *   <li>{@link TimescaleTsKvCompositeKey#getKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvCompositeKey.<init>()",
    "void TimescaleTsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TimescaleTsKvCompositeKey.getEntityId()",
    "int TimescaleTsKvCompositeKey.getKey()",
    "long TimescaleTsKvCompositeKey.getTs()",
    "void TimescaleTsKvCompositeKey.setEntityId(UUID)",
    "void TimescaleTsKvCompositeKey.setKey(int)",
    "void TimescaleTsKvCompositeKey.setTs(long)",
    "String TimescaleTsKvCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    TimescaleTsKvCompositeKey actualTimescaleTsKvCompositeKey =
        new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);
    UUID entityId = ModelConstants.NULL_UUID;
    actualTimescaleTsKvCompositeKey.setEntityId(entityId);
    actualTimescaleTsKvCompositeKey.setKey(1);
    actualTimescaleTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTimescaleTsKvCompositeKey.toString();
    UUID actualEntityId = actualTimescaleTsKvCompositeKey.getEntityId();
    int actualKey = actualTimescaleTsKvCompositeKey.getKey();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "TimescaleTsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTimescaleTsKvCompositeKey.getTs());
    assertSame(entityId, actualEntityId);
  }
}
