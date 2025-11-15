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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class ApiUsageStateFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(apiUsageStateFilter, apiUsageStateFilter2);
    int expectedHashCodeResult = apiUsageStateFilter.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(apiUsageStateFilter, apiUsageStateFilter);
    int expectedHashCodeResult = apiUsageStateFilter.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateFilter.hashCode());
  }

  /**
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(UUID.randomUUID()));

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, apiUsageStateFilter2);
  }

  /**
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(null);

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, apiUsageStateFilter2);
  }

  /**
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, null);
  }

  /**
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, "Different type to ApiUsageStateFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ApiUsageStateFilter}
   *   <li>{@link ApiUsageStateFilter#setCustomerId(CustomerId)}
   *   <li>{@link ApiUsageStateFilter#toString()}
   *   <li>{@link ApiUsageStateFilter#getCustomerId()}
   *   <li>{@link ApiUsageStateFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageStateFilter actualApiUsageStateFilter = new ApiUsageStateFilter();
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    actualApiUsageStateFilter.setCustomerId(customerId);
    String actualToStringResult = actualApiUsageStateFilter.toString();
    CustomerId actualCustomerId = actualApiUsageStateFilter.getCustomerId();

    // Assert that nothing has changed
    assertEquals("ApiUsageStateFilter(customerId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(EntityFilterType.API_USAGE_STATE, actualApiUsageStateFilter.getType());
    assertSame(customerId, actualCustomerId);
  }
}
