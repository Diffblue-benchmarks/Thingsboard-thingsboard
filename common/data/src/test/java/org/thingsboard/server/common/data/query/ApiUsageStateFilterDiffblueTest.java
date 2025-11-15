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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class ApiUsageStateFilterDiffblueTest {
  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}, and {@link ApiUsageStateFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
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
   * Test {@link ApiUsageStateFilter#equals(Object)}, and {@link ApiUsageStateFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(null);

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(null);

    // Act and Assert
    assertEquals(apiUsageStateFilter, apiUsageStateFilter2);
    int expectedHashCodeResult = apiUsageStateFilter.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateFilter2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}, and {@link ApiUsageStateFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
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
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
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
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
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
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, null);
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageStateFilter.equals(Object)", "int ApiUsageStateFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, "Different type to ApiUsageStateFilter");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateFilter.<init>()", "CustomerId ApiUsageStateFilter.getCustomerId()",
      "EntityFilterType ApiUsageStateFilter.getType()", "void ApiUsageStateFilter.setCustomerId(CustomerId)",
      "String ApiUsageStateFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageStateFilter actualApiUsageStateFilter = new ApiUsageStateFilter();
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    actualApiUsageStateFilter.setCustomerId(customerId);
    String actualToStringResult = actualApiUsageStateFilter.toString();
    CustomerId actualCustomerId = actualApiUsageStateFilter.getCustomerId();

    // Assert
    assertEquals("ApiUsageStateFilter(customerId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(EntityFilterType.API_USAGE_STATE, actualApiUsageStateFilter.getType());
    assertSame(customerId, actualCustomerId);
  }
}
