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

public class KeyDictionaryCompositeKeyDiffblueTest {
  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}, and {@link
   * KeyDictionaryCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#equals(Object)}
   *   <li>{@link KeyDictionaryCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey("Key");
    KeyDictionaryCompositeKey keyDictionaryCompositeKey2 = new KeyDictionaryCompositeKey("Key");

    // Act and Assert
    assertEquals(keyDictionaryCompositeKey, keyDictionaryCompositeKey2);
    assertEquals(keyDictionaryCompositeKey.hashCode(), keyDictionaryCompositeKey2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}, and {@link
   * KeyDictionaryCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#equals(Object)}
   *   <li>{@link KeyDictionaryCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey(null);
    KeyDictionaryCompositeKey keyDictionaryCompositeKey2 = new KeyDictionaryCompositeKey(null);

    // Act and Assert
    assertEquals(keyDictionaryCompositeKey, keyDictionaryCompositeKey2);
    assertEquals(keyDictionaryCompositeKey.hashCode(), keyDictionaryCompositeKey2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}, and {@link
   * KeyDictionaryCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#equals(Object)}
   *   <li>{@link KeyDictionaryCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey("Key");

    // Act and Assert
    assertEquals(keyDictionaryCompositeKey, keyDictionaryCompositeKey);
    int expectedHashCodeResult = keyDictionaryCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryCompositeKey.hashCode());
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey(null);

    // Act and Assert
    assertNotEquals(keyDictionaryCompositeKey, new KeyDictionaryCompositeKey("Key"));
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey =
        new KeyDictionaryCompositeKey(
            "org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryCompositeKey");

    // Act and Assert
    assertNotEquals(keyDictionaryCompositeKey, new KeyDictionaryCompositeKey("Key"));
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeyDictionaryCompositeKey("Key"), null);
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new KeyDictionaryCompositeKey("Key"), "Different type to KeyDictionaryCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#KeyDictionaryCompositeKey()}
   *   <li>{@link KeyDictionaryCompositeKey#setKey(String)}
   *   <li>{@link KeyDictionaryCompositeKey#toString()}
   *   <li>{@link KeyDictionaryCompositeKey#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyDictionaryCompositeKey.<init>()",
    "void KeyDictionaryCompositeKey.<init>(String)",
    "String KeyDictionaryCompositeKey.getKey()",
    "void KeyDictionaryCompositeKey.setKey(String)",
    "String KeyDictionaryCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KeyDictionaryCompositeKey actualKeyDictionaryCompositeKey = new KeyDictionaryCompositeKey();
    actualKeyDictionaryCompositeKey.setKey("Key");
    String actualToStringResult = actualKeyDictionaryCompositeKey.toString();

    // Assert
    assertEquals("Key", actualKeyDictionaryCompositeKey.getKey());
    assertEquals("KeyDictionaryCompositeKey(key=Key)", actualToStringResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#KeyDictionaryCompositeKey(String)}
   *   <li>{@link KeyDictionaryCompositeKey#setKey(String)}
   *   <li>{@link KeyDictionaryCompositeKey#toString()}
   *   <li>{@link KeyDictionaryCompositeKey#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyDictionaryCompositeKey.<init>()",
    "void KeyDictionaryCompositeKey.<init>(String)",
    "String KeyDictionaryCompositeKey.getKey()",
    "void KeyDictionaryCompositeKey.setKey(String)",
    "String KeyDictionaryCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenKey() {
    // Arrange and Act
    KeyDictionaryCompositeKey actualKeyDictionaryCompositeKey =
        new KeyDictionaryCompositeKey("Key");
    actualKeyDictionaryCompositeKey.setKey("Key");
    String actualToStringResult = actualKeyDictionaryCompositeKey.toString();

    // Assert
    assertEquals("Key", actualKeyDictionaryCompositeKey.getKey());
    assertEquals("KeyDictionaryCompositeKey(key=Key)", actualToStringResult);
  }
}
