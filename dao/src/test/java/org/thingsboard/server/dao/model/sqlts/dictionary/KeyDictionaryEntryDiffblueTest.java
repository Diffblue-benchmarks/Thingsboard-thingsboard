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
package org.thingsboard.server.dao.model.sqlts.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KeyDictionaryEntryDiffblueTest {
  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}, and {@link KeyDictionaryEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryEntry#equals(Object)}
   *   <li>{@link KeyDictionaryEntry#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertEquals(keyDictionaryEntry, keyDictionaryEntry2);
    assertEquals(keyDictionaryEntry.hashCode(), keyDictionaryEntry2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}, and {@link KeyDictionaryEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryEntry#equals(Object)}
   *   <li>{@link KeyDictionaryEntry#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey(null);
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey(null);
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertEquals(keyDictionaryEntry, keyDictionaryEntry2);
    assertEquals(keyDictionaryEntry.hashCode(), keyDictionaryEntry2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}, and {@link KeyDictionaryEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryEntry#equals(Object)}
   *   <li>{@link KeyDictionaryEntry#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    // Act and Assert
    assertEquals(keyDictionaryEntry, keyDictionaryEntry);
    int expectedHashCodeResult = keyDictionaryEntry.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryEntry.hashCode());
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey(null);
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, keyDictionaryEntry2);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey(
        "org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryEntry");
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, keyDictionaryEntry2);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(2);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, keyDictionaryEntry2);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, null);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryEntry.equals(Object)",
    "int KeyDictionaryEntry.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, "Different type to KeyDictionaryEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KeyDictionaryEntry}
   *   <li>{@link KeyDictionaryEntry#setKey(String)}
   *   <li>{@link KeyDictionaryEntry#setKeyId(int)}
   *   <li>{@link KeyDictionaryEntry#toString()}
   *   <li>{@link KeyDictionaryEntry#getKey()}
   *   <li>{@link KeyDictionaryEntry#getKeyId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyDictionaryEntry.<init>()",
    "String KeyDictionaryEntry.getKey()",
    "int KeyDictionaryEntry.getKeyId()",
    "void KeyDictionaryEntry.setKey(String)",
    "void KeyDictionaryEntry.setKeyId(int)",
    "String KeyDictionaryEntry.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KeyDictionaryEntry actualKeyDictionaryEntry = new KeyDictionaryEntry();
    actualKeyDictionaryEntry.setKey("Key");
    actualKeyDictionaryEntry.setKeyId(1);
    String actualToStringResult = actualKeyDictionaryEntry.toString();
    String actualKey = actualKeyDictionaryEntry.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("KeyDictionaryEntry(key=Key, keyId=1)", actualToStringResult);
    assertEquals(1, actualKeyDictionaryEntry.getKeyId());
  }
}
