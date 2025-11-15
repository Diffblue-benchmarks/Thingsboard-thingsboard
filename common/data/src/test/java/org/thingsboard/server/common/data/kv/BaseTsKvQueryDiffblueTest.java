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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseTsKvQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseTsKvQuery#equals(Object)}
   *   <li>{@link BaseTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTsKvQuery, baseDeleteTsKvQuery);
    int notExpectedHashCodeResult = baseTsKvQuery.hashCode();
    assertNotEquals(notExpectedHashCodeResult, baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseTsKvQuery#equals(Object)}
   *   <li>{@link BaseTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, null, 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn(null);
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTsKvQuery, baseDeleteTsKvQuery);
    int notExpectedHashCodeResult = baseTsKvQuery.hashCode();
    assertNotEquals(notExpectedHashCodeResult, baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseTsKvQuery#equals(Object)}
   *   <li>{@link BaseTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseTsKvQuery, baseTsKvQuery);
    int expectedHashCodeResult = baseTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseTsKvQuery.hashCode());
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, new BaseTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, new BaseDeleteTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery("Key", 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, null, 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "java.lang.Integer", 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 0L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BaseTsKvQuery baseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 0L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");
    when(baseDeleteTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.getId()).thenReturn(1);
    when(baseDeleteTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseDeleteTsKvQuery.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTsKvQuery, baseDeleteTsKvQuery);
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Method under test: {@link BaseTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTsKvQuery("Key", 1L, 1L), "Different type to BaseTsKvQuery");
  }

  /**
   * Method under test:
   * {@link BaseTsKvQuery#BaseTsKvQuery(int, String, long, long)}
   */
  @Test
  void testNewBaseTsKvQuery() {
    // Arrange and Act
    BaseTsKvQuery actualBaseTsKvQuery = new BaseTsKvQuery(1, "Key", 1L, 1L);

    // Assert
    assertEquals("Key", actualBaseTsKvQuery.getKey());
    assertEquals(1, actualBaseTsKvQuery.getId());
    assertEquals(1L, actualBaseTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseTsKvQuery.getStartTs());
  }
}
