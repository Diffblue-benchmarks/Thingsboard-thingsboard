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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseTsKvQuery#BaseTsKvQuery(int, String, long, long)}.
   *
   * <p>Method under test: {@link BaseTsKvQuery#BaseTsKvQuery(int, String, long, long)}
   */
  @Test
  @DisplayName("Test new BaseTsKvQuery(int, String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseTsKvQuery.<init>(int, String, long, long)"})
  void testNewBaseTsKvQuery() {
    // Arrange and Act
    BaseTsKvQuery actualBaseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 1L);

    // Assert
    assertEquals("Key", actualBaseTsKvQuery.getKey());
    assertEquals(1, actualBaseTsKvQuery.getId());
    assertEquals(1L, actualBaseTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseTsKvQuery.getStartTs());
  }

  /**
   * Test {@link BaseTsKvQuery#BaseTsKvQuery(String, long, long)}.
   *
   * <p>Method under test: {@link BaseTsKvQuery#BaseTsKvQuery(String, long, long)}
   */
  @Test
  @DisplayName("Test new BaseTsKvQuery(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseTsKvQuery.<init>(String, long, long)"})
  void testNewBaseTsKvQuery2() {
    // Arrange and Act
    BaseTsKvQuery actualBaseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Assert
    assertEquals("Key", actualBaseTsKvQuery.getKey());
    assertEquals(1L, actualBaseTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseTsKvQuery.getStartTs());
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}, and {@link BaseTsKvQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTsKvQuery#equals(Object)}
   *   <li>{@link BaseTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 1L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTsKvQuery, baseDeleteTsKvQuery);
    assertNotEquals(baseTsKvQuery.hashCode(), baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}, and {@link BaseTsKvQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTsKvQuery#equals(Object)}
   *   <li>{@link BaseTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, null, 1L, 1L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn(null);
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTsKvQuery, baseDeleteTsKvQuery);
    assertNotEquals(baseTsKvQuery.hashCode(), baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}, and {@link BaseTsKvQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTsKvQuery#equals(Object)}
   *   <li>{@link BaseTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseTsKvQuery, baseTsKvQuery);
    int expectedHashCodeResult = baseTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, new BaseTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, new BaseDeleteTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 1L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn(null);
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 0L, 1L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn(null);
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 0L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn(null);
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, null, 1L, 1L);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTsKvQuery.equals(Object)", "int BaseTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTsKvQuery("Key", 1L, 1L), "Different type to BaseTsKvQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTsKvQuery#toString()}
   *   <li>{@link BaseTsKvQuery#getEndTs()}
   *   <li>{@link BaseTsKvQuery#getId()}
   *   <li>{@link BaseTsKvQuery#getKey()}
   *   <li>{@link BaseTsKvQuery#getStartTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseTsKvQuery.getEndTs()",
    "int BaseTsKvQuery.getId()",
    "String BaseTsKvQuery.getKey()",
    "long BaseTsKvQuery.getStartTs()",
    "String BaseTsKvQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act
    baseTsKvQuery.toString();
    long actualEndTs = baseTsKvQuery.getEndTs();
    baseTsKvQuery.getId();
    String actualKey = baseTsKvQuery.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, baseTsKvQuery.getStartTs());
  }
}
