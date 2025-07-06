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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(apiUsageStateFilter, apiUsageStateFilter2);
    int expectedHashCodeResult = apiUsageStateFilter.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateFilter2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}, and {@link ApiUsageStateFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateFilter#equals(Object)}
   *   <li>{@link ApiUsageStateFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(apiUsageStateFilter, apiUsageStateFilter);
    int expectedHashCodeResult = apiUsageStateFilter.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateFilter.hashCode());
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, apiUsageStateFilter2);
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(null);

    ApiUsageStateFilter apiUsageStateFilter2 = new ApiUsageStateFilter();
    apiUsageStateFilter2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, apiUsageStateFilter2);
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, null);
  }

  /**
   * Test {@link ApiUsageStateFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateFilter.equals(Object)",
    "int ApiUsageStateFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateFilter apiUsageStateFilter = new ApiUsageStateFilter();
    apiUsageStateFilter.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(apiUsageStateFilter, "Different type to ApiUsageStateFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @MethodsUnderTest({
    "void ApiUsageStateFilter.<init>()",
    "CustomerId ApiUsageStateFilter.getCustomerId()",
    "EntityFilterType ApiUsageStateFilter.getType()",
    "void ApiUsageStateFilter.setCustomerId(CustomerId)",
    "String ApiUsageStateFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageStateFilter actualApiUsageStateFilter = new ApiUsageStateFilter();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualApiUsageStateFilter.setCustomerId(customerId);
    String actualToStringResult = actualApiUsageStateFilter.toString();
    CustomerId actualCustomerId = actualApiUsageStateFilter.getCustomerId();

    // Assert
    assertEquals(
        "ApiUsageStateFilter(customerId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals(EntityFilterType.API_USAGE_STATE, actualApiUsageStateFilter.getType());
    assertSame(customerId, actualCustomerId);
  }
}
