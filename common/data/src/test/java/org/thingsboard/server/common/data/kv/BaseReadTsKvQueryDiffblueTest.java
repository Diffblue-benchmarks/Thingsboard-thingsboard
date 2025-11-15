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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseReadTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}.
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(ReadTsKvQuery, long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseReadTsKvQuery.<init>(ReadTsKvQuery, long, long)"})
  void testNewBaseReadTsKvQuery() {
    // Arrange
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(query, new BaseReadTsKvQuery(query, 1L, 1L));
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}, and {@link BaseReadTsKvQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#equals(Object)}
   *   <li>{@link BaseReadTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseReadTsKvQuery.equals(Object)", "int BaseReadTsKvQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseReadTsKvQuery, baseReadTsKvQuery);
    int expectedHashCodeResult = baseReadTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseReadTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseReadTsKvQuery.equals(Object)", "int BaseReadTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseReadTsKvQuery, new BaseReadTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseReadTsKvQuery.equals(Object)", "int BaseReadTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseReadTsKvQuery.equals(Object)", "int BaseReadTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), "Different type to BaseReadTsKvQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#toString()}
   *   <li>{@link BaseReadTsKvQuery#getAggParameters()}
   *   <li>{@link BaseReadTsKvQuery#getLimit()}
   *   <li>{@link BaseReadTsKvQuery#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams BaseReadTsKvQuery.getAggParameters()", "int BaseReadTsKvQuery.getLimit()",
      "java.lang.String BaseReadTsKvQuery.getOrder()", "java.lang.String BaseReadTsKvQuery.toString()"})
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
}
