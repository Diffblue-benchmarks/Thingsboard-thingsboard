package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class CustomerUsersFilterDiffblueTest {
  /**
   * Test {@link CustomerUsersFilter#equals(Object)}, and {@link CustomerUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerUsersFilter#equals(Object)}
   *   <li>{@link CustomerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(customerUsersFilter, customerUsersFilter2);
    int expectedHashCodeResult = customerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, customerUsersFilter2.hashCode());
  }

  /**
   * Test {@link CustomerUsersFilter#equals(Object)}, and {@link CustomerUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerUsersFilter#equals(Object)}
   *   <li>{@link CustomerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(null);

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(null);

    // Act and Assert
    assertEquals(customerUsersFilter, customerUsersFilter2);
    int expectedHashCodeResult = customerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, customerUsersFilter2.hashCode());
  }

  /**
   * Test {@link CustomerUsersFilter#equals(Object)}, and {@link CustomerUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerUsersFilter#equals(Object)}
   *   <li>{@link CustomerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(customerUsersFilter, customerUsersFilter);
    int expectedHashCodeResult = customerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, customerUsersFilter.hashCode());
  }

  /**
   * Test {@link CustomerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(EntityId.NULL_UUID);

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(customerUsersFilter, customerUsersFilter2);
  }

  /**
   * Test {@link CustomerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(null);

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(customerUsersFilter, customerUsersFilter2);
  }

  /**
   * Test {@link CustomerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(customerUsersFilter, null);
  }

  /**
   * Test {@link CustomerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerUsersFilter.equals(Object)", "int CustomerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(customerUsersFilter, "Different type to CustomerUsersFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerUsersFilter}
   *   <li>{@link CustomerUsersFilter#setCustomerId(UUID)}
   *   <li>{@link CustomerUsersFilter#toString()}
   *   <li>{@link CustomerUsersFilter#getCustomerId()}
   *   <li>{@link CustomerUsersFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerUsersFilter.<init>()", "UUID CustomerUsersFilter.getCustomerId()",
      "UsersFilterType CustomerUsersFilter.getType()", "void CustomerUsersFilter.setCustomerId(UUID)",
      "String CustomerUsersFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CustomerUsersFilter actualCustomerUsersFilter = new CustomerUsersFilter();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualCustomerUsersFilter.setCustomerId(customerId);
    String actualToStringResult = actualCustomerUsersFilter.toString();
    UUID actualCustomerId = actualCustomerUsersFilter.getCustomerId();
    UsersFilterType actualType = actualCustomerUsersFilter.getType();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualCustomerId.toString());
    assertEquals("CustomerUsersFilter(customerId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertEquals(UsersFilterType.CUSTOMER_USERS, actualType);
    assertSame(customerId, actualCustomerId);
  }
}
