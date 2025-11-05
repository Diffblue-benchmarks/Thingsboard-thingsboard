package org.thingsboard.server.dao.device.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.CustomerId;

class ReclaimResultDiffblueTest {
  /**
   * Test {@link ReclaimResult#equals(Object)}, and {@link ReclaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReclaimResult#equals(Object)}
   *   <li>{@link ReclaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(new Customer());
    ReclaimResult reclaimResult2 = new ReclaimResult(new Customer());

    // Act and Assert
    assertEquals(reclaimResult, reclaimResult2);
    assertEquals(reclaimResult.hashCode(), reclaimResult2.hashCode());
  }

  /**
   * Test {@link ReclaimResult#equals(Object)}, and {@link ReclaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReclaimResult#equals(Object)}
   *   <li>{@link ReclaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(null);
    ReclaimResult reclaimResult2 = new ReclaimResult(null);

    // Act and Assert
    assertEquals(reclaimResult, reclaimResult2);
    assertEquals(reclaimResult.hashCode(), reclaimResult2.hashCode());
  }

  /**
   * Test {@link ReclaimResult#equals(Object)}, and {@link ReclaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReclaimResult#equals(Object)}
   *   <li>{@link ReclaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(new Customer());

    // Act and Assert
    assertEquals(reclaimResult, reclaimResult);
    int expectedHashCodeResult = reclaimResult.hashCode();
    assertEquals(expectedHashCodeResult, reclaimResult.hashCode());
  }

  /**
   * Test {@link ReclaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(null);

    // Act and Assert
    assertNotEquals(reclaimResult, new ReclaimResult(new Customer()));
  }

  /**
   * Test {@link ReclaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Customer unassignedCustomer = new Customer(id);
    ReclaimResult reclaimResult = new ReclaimResult(unassignedCustomer);

    // Act and Assert
    assertNotEquals(reclaimResult, new ReclaimResult(new Customer()));
  }

  /**
   * Test {@link ReclaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReclaimResult(new Customer()), null);
  }

  /**
   * Test {@link ReclaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReclaimResult.equals(Object)", "int ReclaimResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReclaimResult(new Customer()), "Different type to ReclaimResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReclaimResult#ReclaimResult(Customer)}
   *   <li>{@link ReclaimResult#setUnassignedCustomer(Customer)}
   *   <li>{@link ReclaimResult#toString()}
   *   <li>{@link ReclaimResult#getUnassignedCustomer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReclaimResult.<init>(Customer)",
    "Customer ReclaimResult.getUnassignedCustomer()",
    "void ReclaimResult.setUnassignedCustomer(Customer)",
    "String ReclaimResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ReclaimResult actualReclaimResult = new ReclaimResult(new Customer());
    Customer unassignedCustomer = new Customer();
    actualReclaimResult.setUnassignedCustomer(unassignedCustomer);
    String actualToStringResult = actualReclaimResult.toString();

    // Assert
    assertEquals(
        "ReclaimResult(unassignedCustomer=Customer [title=null, tenantId=null, additionalInfo=null, country=null,"
            + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
            + " id=null])",
        actualToStringResult);
    assertSame(unassignedCustomer, actualReclaimResult.getUnassignedCustomer());
  }
}
