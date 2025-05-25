package org.thingsboard.server.cache.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class CustomerCacheKeyDiffblueTest {
  /**
   * Test {@link CustomerCacheKey#equals(Object)}, and {@link CustomerCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerCacheKey#equals(Object)}
   *   <li>{@link CustomerCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");
    CustomerCacheKey customerCacheKey2 = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    // Act and Assert
    assertEquals(customerCacheKey, customerCacheKey2);
    int expectedHashCodeResult = customerCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, customerCacheKey2.hashCode());
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}, and {@link CustomerCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerCacheKey#equals(Object)}
   *   <li>{@link CustomerCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    // Act and Assert
    assertEquals(customerCacheKey, customerCacheKey);
    int expectedHashCodeResult = customerCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, customerCacheKey.hashCode());
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    // Act and Assert
    assertNotEquals(customerCacheKey,
        new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"));
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Mr");

    // Act and Assert
    assertNotEquals(customerCacheKey,
        new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"));
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        null);
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        "Different type to CustomerCacheKey");
  }

  /**
   * Test {@link CustomerCacheKey#CustomerCacheKey(TenantId, String)}.
   * <ul>
   *   <li>Then return not canEqual {@code Other}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCacheKey#CustomerCacheKey(TenantId, String)}
   */
  @Test
  @DisplayName("Test new CustomerCacheKey(TenantId, String); then return not canEqual 'Other'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerCacheKey.<init>(TenantId, String)"})
  void testNewCustomerCacheKey_thenReturnNotCanEqualOther() {
    // Arrange, Act and Assert
    assertFalse((new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"))
        .canEqual("Other"));
  }

  /**
   * Test {@link CustomerCacheKey#toString()}.
   * <p>
   * Method under test: {@link CustomerCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CustomerCacheKey.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9_Dr",
        (new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr")).toString());
  }
}
