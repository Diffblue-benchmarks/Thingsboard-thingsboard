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
package org.thingsboard.server.cache.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class CustomerCacheKeyDiffblueTest {
  /**
   * Test {@link CustomerCacheKey#equals(Object)}, and {@link CustomerCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerCacheKey#equals(Object)}
   *   <li>{@link CustomerCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(null), "Dr");
    CustomerCacheKey customerCacheKey2 = new CustomerCacheKey(new TenantId(null), "Dr");

    // Act and Assert
    assertEquals(customerCacheKey, customerCacheKey2);
    assertEquals(customerCacheKey.hashCode(), customerCacheKey2.hashCode());
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}, and {@link CustomerCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerCacheKey#equals(Object)}
   *   <li>{@link CustomerCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(null), null);
    CustomerCacheKey customerCacheKey2 = new CustomerCacheKey(new TenantId(null), null);

    // Act and Assert
    assertEquals(customerCacheKey, customerCacheKey2);
    assertEquals(customerCacheKey.hashCode(), customerCacheKey2.hashCode());
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}, and {@link CustomerCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerCacheKey#equals(Object)}
   *   <li>{@link CustomerCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    // Act and Assert
    assertEquals(customerCacheKey, customerCacheKey);
    int expectedHashCodeResult = customerCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, customerCacheKey.hashCode());
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    // Act and Assert
    assertNotEquals(customerCacheKey, new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"));
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(null), "Mr");

    // Act and Assert
    assertNotEquals(customerCacheKey, new CustomerCacheKey(new TenantId(null), "Dr"));
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(null), null);

    // Act and Assert
    assertNotEquals(customerCacheKey, new CustomerCacheKey(new TenantId(null), "Dr"));
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"), null);
  }

  /**
   * Test {@link CustomerCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerCacheKey.equals(Object)", "int CustomerCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"),
        "Different type to CustomerCacheKey");
  }

  /**
   * Test {@link CustomerCacheKey#CustomerCacheKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return not canEqual {@code Other}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerCacheKey#CustomerCacheKey(TenantId, String)}
   */
  @Test
  @DisplayName("Test new CustomerCacheKey(TenantId, String); then return not canEqual 'Other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerCacheKey.<init>(TenantId, String)"})
  void testNewCustomerCacheKey_thenReturnNotCanEqualOther() {
    // Arrange, Act and Assert
    assertFalse(new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr").canEqual("Other"));
  }
}
