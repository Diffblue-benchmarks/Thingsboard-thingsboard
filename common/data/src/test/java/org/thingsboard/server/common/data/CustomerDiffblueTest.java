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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class CustomerDiffblueTest {
  /**
   * Test {@link Customer#equals(Object)}, and {@link Customer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Customer customer = new Customer();
    Customer customer2 = new Customer();

    // Act and Assert
    assertEquals(customer, customer2);
    assertEquals(customer.hashCode(), customer2.hashCode());
  }

  /**
   * Test {@link Customer#equals(Object)}, and {@link Customer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(TenantId.SYS_TENANT_ID);

    Customer customer2 = new Customer();
    customer2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(customer, customer2);
    assertEquals(customer.hashCode(), customer2.hashCode());
  }

  /**
   * Test {@link Customer#equals(Object)}, and {@link Customer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("Dr");

    Customer customer2 = new Customer();
    customer2.setTitle("Dr");

    // Act and Assert
    assertEquals(customer, customer2);
    assertEquals(customer.hashCode(), customer2.hashCode());
  }

  /**
   * Test {@link Customer#equals(Object)}, and {@link Customer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Customer customer = new Customer();
    customer.setExternalId(new CustomerId(EntityId.NULL_UUID));

    Customer customer2 = new Customer();
    customer2.setExternalId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(customer, customer2);
    assertEquals(customer.hashCode(), customer2.hashCode());
  }

  /**
   * Test {@link Customer#equals(Object)}, and {@link Customer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Customer customer = new Customer();
    customer.setVersion(1L);

    Customer customer2 = new Customer();
    customer2.setVersion(1L);

    // Act and Assert
    assertEquals(customer, customer2);
    assertEquals(customer.hashCode(), customer2.hashCode());
  }

  /**
   * Test {@link Customer#equals(Object)}, and {@link Customer#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Customer customer = new Customer();

    // Act and Assert
    assertEquals(customer, customer);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer.hashCode());
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Customer customer = new Customer(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("Dr");

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Customer customer = new Customer();
    customer.setExternalId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Customer customer = new Customer();
    customer.setVersion(1L);

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setExternalId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setVersion(1L);

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Customer(), null);
  }

  /**
   * Test {@link Customer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Customer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.equals(Object)", "int Customer.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Customer(), "Different type to Customer");
  }

  /**
   * Test {@link Customer#getExternalId()}.
   *
   * <p>Method under test: {@link Customer#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerId Customer.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new Customer().getExternalId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@link CustomerId#CustomerId(UUID)} with id is {@link
   *       EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#Customer(CustomerId)}
   *   <li>{@link Customer#setExternalId(CustomerId)}
   *   <li>{@link Customer#setTenantId(TenantId)}
   *   <li>{@link Customer#setTitle(String)}
   *   <li>{@link Customer#setVersion(Long)}
   *   <li>{@link Customer#toString()}
   *   <li>{@link Customer#getName()}
   *   <li>{@link Customer#getTenantId()}
   *   <li>{@link Customer#getTitle()}
   *   <li>{@link Customer#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is CustomerId(UUID) with id is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Customer.<init>()",
    "void Customer.<init>(CustomerId)",
    "String Customer.getName()",
    "TenantId Customer.getTenantId()",
    "String Customer.getTitle()",
    "Long Customer.getVersion()",
    "void Customer.setExternalId(CustomerId)",
    "void Customer.setTenantId(TenantId)",
    "void Customer.setTitle(String)",
    "void Customer.setVersion(Long)",
    "String Customer.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsCustomerIdWithIdIsNull_uuid() {
    // Arrange
    CustomerId id = new CustomerId(EntityId.NULL_UUID);

    // Act
    Customer actualCustomer = new Customer(id);
    CustomerId externalId = new CustomerId(EntityId.NULL_UUID);
    actualCustomer.setExternalId(externalId);
    actualCustomer.setTenantId(TenantId.SYS_TENANT_ID);
    actualCustomer.setTitle("Dr");
    actualCustomer.setVersion(1L);
    String actualToStringResult = actualCustomer.toString();
    String actualName = actualCustomer.getName();
    TenantId actualTenantId = actualCustomer.getTenantId();
    String actualTitle = actualCustomer.getTitle();

    // Assert
    assertEquals(
        "Customer [title=Dr, tenantId=13814000-1dd2-11b2-8080-808080808080, additionalInfo=null, country=null,"
            + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
            + " id=13814000-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals(1L, actualCustomer.getVersion().longValue());
    assertSame(externalId, actualCustomer.getExternalId());
    assertSame(id, actualCustomer.getId());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#Customer()}
   *   <li>{@link Customer#setExternalId(CustomerId)}
   *   <li>{@link Customer#setTenantId(TenantId)}
   *   <li>{@link Customer#setTitle(String)}
   *   <li>{@link Customer#setVersion(Long)}
   *   <li>{@link Customer#toString()}
   *   <li>{@link Customer#getName()}
   *   <li>{@link Customer#getTenantId()}
   *   <li>{@link Customer#getTitle()}
   *   <li>{@link Customer#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Customer.<init>()",
    "void Customer.<init>(CustomerId)",
    "String Customer.getName()",
    "TenantId Customer.getTenantId()",
    "String Customer.getTitle()",
    "Long Customer.getVersion()",
    "void Customer.setExternalId(CustomerId)",
    "void Customer.setTenantId(TenantId)",
    "void Customer.setTitle(String)",
    "void Customer.setVersion(Long)",
    "String Customer.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    Customer actualCustomer = new Customer();
    CustomerId externalId = new CustomerId(EntityId.NULL_UUID);
    actualCustomer.setExternalId(externalId);
    actualCustomer.setTenantId(TenantId.SYS_TENANT_ID);
    actualCustomer.setTitle("Dr");
    actualCustomer.setVersion(1L);
    String actualToStringResult = actualCustomer.toString();
    String actualName = actualCustomer.getName();
    TenantId actualTenantId = actualCustomer.getTenantId();
    String actualTitle = actualCustomer.getTitle();
    Long actualVersion = actualCustomer.getVersion();

    // Assert
    assertEquals(
        "Customer [title=Dr, tenantId=13814000-1dd2-11b2-8080-808080808080, additionalInfo=null, country=null,"
            + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
            + " id=null]",
        actualToStringResult);
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertNull(actualCustomer.getId());
    assertEquals(1L, actualVersion.longValue());
    assertSame(externalId, actualCustomer.getExternalId());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link Customer#Customer(Customer)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#Customer(Customer)}
   */
  @Test
  @DisplayName("Test new Customer(Customer); when Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Customer.<init>(Customer)"})
  void testNewCustomer_whenCustomer() {
    // Arrange and Act
    Customer actualCustomer = new Customer(new Customer());

    // Assert
    assertTrue(actualCustomer.getAdditionalInfo() instanceof NullNode);
    assertNull(actualCustomer.getVersion());
    assertNull(actualCustomer.getAddress());
    assertNull(actualCustomer.getAddress2());
    assertNull(actualCustomer.getCity());
    assertNull(actualCustomer.getCountry());
    assertNull(actualCustomer.getEmail());
    assertNull(actualCustomer.getName());
    assertNull(actualCustomer.getPhone());
    assertNull(actualCustomer.getState());
    assertNull(actualCustomer.getTitle());
    assertNull(actualCustomer.getZip());
    assertNull(actualCustomer.address);
    assertNull(actualCustomer.address2);
    assertNull(actualCustomer.city);
    assertNull(actualCustomer.country);
    assertNull(actualCustomer.email);
    assertNull(actualCustomer.phone);
    assertNull(actualCustomer.state);
    assertNull(actualCustomer.zip);
    assertNull(actualCustomer.getUuidId());
    assertNull(actualCustomer.getExternalId());
    assertNull(actualCustomer.getId());
    assertNull(actualCustomer.getTenantId());
    assertEquals(0L, actualCustomer.getCreatedTime());
    assertEquals(0L, actualCustomer.createdTime);
  }

  /**
   * Test {@link Customer#Customer(Customer)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#Customer(Customer)}
   */
  @Test
  @DisplayName("Test new Customer(Customer); when Customer(Customer) with customer is Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Customer.<init>(Customer)"})
  void testNewCustomer_whenCustomerWithCustomerIsCustomer() {
    // Arrange and Act
    Customer actualCustomer = new Customer(new Customer(new Customer()));

    // Assert
    assertTrue(actualCustomer.getAdditionalInfo() instanceof NullNode);
    assertNull(actualCustomer.getVersion());
    assertNull(actualCustomer.getAddress());
    assertNull(actualCustomer.getAddress2());
    assertNull(actualCustomer.getCity());
    assertNull(actualCustomer.getCountry());
    assertNull(actualCustomer.getEmail());
    assertNull(actualCustomer.getName());
    assertNull(actualCustomer.getPhone());
    assertNull(actualCustomer.getState());
    assertNull(actualCustomer.getTitle());
    assertNull(actualCustomer.getZip());
    assertNull(actualCustomer.address);
    assertNull(actualCustomer.address2);
    assertNull(actualCustomer.city);
    assertNull(actualCustomer.country);
    assertNull(actualCustomer.email);
    assertNull(actualCustomer.phone);
    assertNull(actualCustomer.state);
    assertNull(actualCustomer.zip);
    assertNull(actualCustomer.getUuidId());
    assertNull(actualCustomer.getExternalId());
    assertNull(actualCustomer.getId());
    assertNull(actualCustomer.getTenantId());
    assertEquals(0L, actualCustomer.getCreatedTime());
    assertEquals(0L, actualCustomer.createdTime);
  }

  /**
   * Test {@link Customer#Customer(Customer)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer(Customer)} with customer is {@link
   *       Customer#Customer(Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#Customer(Customer)}
   */
  @Test
  @DisplayName(
      "Test new Customer(Customer); when Customer(Customer) with customer is Customer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Customer.<init>(Customer)"})
  void testNewCustomer_whenCustomerWithCustomerIsCustomer2() {
    // Arrange
    Customer customer = new Customer(new Customer(new Customer()));

    // Act
    Customer actualCustomer = new Customer(customer);

    // Assert
    assertTrue(actualCustomer.getAdditionalInfo() instanceof NullNode);
    assertNull(actualCustomer.getVersion());
    assertNull(actualCustomer.getAddress());
    assertNull(actualCustomer.getAddress2());
    assertNull(actualCustomer.getCity());
    assertNull(actualCustomer.getCountry());
    assertNull(actualCustomer.getEmail());
    assertNull(actualCustomer.getName());
    assertNull(actualCustomer.getPhone());
    assertNull(actualCustomer.getState());
    assertNull(actualCustomer.getTitle());
    assertNull(actualCustomer.getZip());
    assertNull(actualCustomer.address);
    assertNull(actualCustomer.address2);
    assertNull(actualCustomer.city);
    assertNull(actualCustomer.country);
    assertNull(actualCustomer.email);
    assertNull(actualCustomer.phone);
    assertNull(actualCustomer.state);
    assertNull(actualCustomer.zip);
    assertNull(actualCustomer.getUuidId());
    assertNull(actualCustomer.getExternalId());
    assertNull(actualCustomer.getId());
    assertNull(actualCustomer.getTenantId());
    assertEquals(0L, actualCustomer.getCreatedTime());
    assertEquals(0L, actualCustomer.createdTime);
  }

  /**
   * Test {@link Customer#getId()}.
   *
   * <p>Method under test: {@link Customer#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerId Customer.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new Customer().getId());
  }

  /**
   * Test {@link Customer#getCreatedTime()}.
   *
   * <p>Method under test: {@link Customer#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Customer.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new Customer().getCreatedTime());
  }

  /**
   * Test {@link Customer#getCountry()}.
   *
   * <p>Method under test: {@link Customer#getCountry()}
   */
  @Test
  @DisplayName("Test getCountry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getCountry()"})
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull(new Customer().getCountry());
  }

  /**
   * Test {@link Customer#getState()}.
   *
   * <p>Method under test: {@link Customer#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getState()"})
  void testGetState() {
    // Arrange, Act and Assert
    assertNull(new Customer().getState());
  }

  /**
   * Test {@link Customer#getCity()}.
   *
   * <p>Method under test: {@link Customer#getCity()}
   */
  @Test
  @DisplayName("Test getCity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getCity()"})
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull(new Customer().getCity());
  }

  /**
   * Test {@link Customer#getAddress()}.
   *
   * <p>Method under test: {@link Customer#getAddress()}
   */
  @Test
  @DisplayName("Test getAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getAddress()"})
  void testGetAddress() {
    // Arrange, Act and Assert
    assertNull(new Customer().getAddress());
  }

  /**
   * Test {@link Customer#getAddress2()}.
   *
   * <p>Method under test: {@link Customer#getAddress2()}
   */
  @Test
  @DisplayName("Test getAddress2()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getAddress2()"})
  void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull(new Customer().getAddress2());
  }

  /**
   * Test {@link Customer#getZip()}.
   *
   * <p>Method under test: {@link Customer#getZip()}
   */
  @Test
  @DisplayName("Test getZip()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getZip()"})
  void testGetZip() {
    // Arrange, Act and Assert
    assertNull(new Customer().getZip());
  }

  /**
   * Test {@link Customer#getPhone()}.
   *
   * <p>Method under test: {@link Customer#getPhone()}
   */
  @Test
  @DisplayName("Test getPhone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getPhone()"})
  void testGetPhone() {
    // Arrange, Act and Assert
    assertNull(new Customer().getPhone());
  }

  /**
   * Test {@link Customer#getEmail()}.
   *
   * <p>Method under test: {@link Customer#getEmail()}
   */
  @Test
  @DisplayName("Test getEmail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Customer.getEmail()"})
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull(new Customer().getEmail());
  }

  /**
   * Test {@link Customer#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Customer(Customer) with customer is Customer(); then return instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode Customer.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenCustomerWithCustomerIsCustomer_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Customer(new Customer()).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Customer#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link
   *       Customer#Customer(Customer)}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Customer(Customer) with customer is Customer(Customer); then return instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode Customer.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenCustomerWithCustomerIsCustomer_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Customer(new Customer(new Customer())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Customer#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Customer(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode Customer.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenCustomer_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Customer().getAdditionalInfo());
  }

  /**
   * Test {@link Customer#isPublic()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#isPublic()}
   */
  @Test
  @DisplayName("Test isPublic(); given Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.isPublic()"})
  void testIsPublic_givenCustomer() {
    // Arrange, Act and Assert
    assertFalse(new Customer().isPublic());
  }

  /**
   * Test {@link Customer#isPublic()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#isPublic()}
   */
  @Test
  @DisplayName("Test isPublic(); given Customer(Customer) with customer is Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.isPublic()"})
  void testIsPublic_givenCustomerWithCustomerIsCustomer() {
    // Arrange, Act and Assert
    assertFalse(new Customer(new Customer()).isPublic());
  }

  /**
   * Test {@link Customer#isPublic()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link
   *       Customer#Customer(Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#isPublic()}
   */
  @Test
  @DisplayName("Test isPublic(); given Customer(Customer) with customer is Customer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Customer.isPublic()"})
  void testIsPublic_givenCustomerWithCustomerIsCustomer2() {
    // Arrange, Act and Assert
    assertFalse(new Customer(new Customer(new Customer())).isPublic());
  }

  /**
   * Test {@link Customer#toShortCustomerInfo()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#toShortCustomerInfo()}
   */
  @Test
  @DisplayName("Test toShortCustomerInfo(); given Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo Customer.toShortCustomerInfo()"})
  void testToShortCustomerInfo_givenCustomer() {
    // Arrange and Act
    ShortCustomerInfo actualToShortCustomerInfoResult = new Customer().toShortCustomerInfo();

    // Assert
    assertNull(actualToShortCustomerInfoResult.getTitle());
    assertNull(actualToShortCustomerInfoResult.getCustomerId());
    assertFalse(actualToShortCustomerInfoResult.isPublic());
  }

  /**
   * Test {@link Customer#toShortCustomerInfo()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#toShortCustomerInfo()}
   */
  @Test
  @DisplayName("Test toShortCustomerInfo(); given Customer(Customer) with customer is Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo Customer.toShortCustomerInfo()"})
  void testToShortCustomerInfo_givenCustomerWithCustomerIsCustomer() {
    // Arrange and Act
    ShortCustomerInfo actualToShortCustomerInfoResult =
        new Customer(new Customer()).toShortCustomerInfo();

    // Assert
    assertNull(actualToShortCustomerInfoResult.getTitle());
    assertNull(actualToShortCustomerInfoResult.getCustomerId());
    assertFalse(actualToShortCustomerInfoResult.isPublic());
  }

  /**
   * Test {@link Customer#toShortCustomerInfo()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link
   *       Customer#Customer(Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link Customer#toShortCustomerInfo()}
   */
  @Test
  @DisplayName(
      "Test toShortCustomerInfo(); given Customer(Customer) with customer is Customer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo Customer.toShortCustomerInfo()"})
  void testToShortCustomerInfo_givenCustomerWithCustomerIsCustomer2() {
    // Arrange and Act
    ShortCustomerInfo actualToShortCustomerInfoResult =
        new Customer(new Customer(new Customer())).toShortCustomerInfo();

    // Assert
    assertNull(actualToShortCustomerInfoResult.getTitle());
    assertNull(actualToShortCustomerInfoResult.getCustomerId());
    assertFalse(actualToShortCustomerInfoResult.isPublic());
  }
}
