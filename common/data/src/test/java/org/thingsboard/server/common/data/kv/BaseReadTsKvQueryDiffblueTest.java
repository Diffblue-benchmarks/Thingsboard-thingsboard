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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class BaseReadTsKvQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#equals(Object)}
   *   <li>{@link BaseReadTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseReadTsKvQuery, baseReadTsKvQuery);
    int expectedHashCodeResult = baseReadTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseReadTsKvQuery.hashCode());
  }

  /**
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseReadTsKvQuery, new BaseReadTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), mock(BaseDeleteTsKvQuery.class));
  }

  /**
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), "Different type to BaseReadTsKvQuery");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#toString()}
   *   <li>{@link BaseReadTsKvQuery#getAggParameters()}
   *   <li>{@link BaseReadTsKvQuery#getLimit()}
   *   <li>{@link BaseReadTsKvQuery#getOrder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act
    baseReadTsKvQuery.toString();
    AggregationParams actualAggParameters = baseReadTsKvQuery.getAggParameters();
    int actualLimit = baseReadTsKvQuery.getLimit();

    // Assert
    assertEquals("DESC", baseReadTsKvQuery.getOrder());
    assertNull(actualAggParameters.getTzId());
    assertEquals(0L, actualAggParameters.getInterval());
    assertEquals(1, actualLimit);
    assertEquals(Aggregation.AVG, actualAggParameters.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualAggParameters.getIntervalType());
  }

  /**
   * Method under test:
   * {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}
   */
  @Test
  void testNewBaseReadTsKvQuery() {
    // Arrange
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(query, new BaseReadTsKvQuery(query, 1L, 1L));
  }
}
