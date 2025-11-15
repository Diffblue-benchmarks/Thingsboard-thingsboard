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
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DashboardInfoDiffblueTest {
  /**
   * Method under test: {@link DashboardInfo#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new DashboardInfo()).getId());
  }

  /**
   * Method under test: {@link DashboardInfo#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DashboardInfo()).getCreatedTime());
  }

  /**
   * Method under test: {@link DashboardInfo#isAssignedToCustomer(CustomerId)}
   */
  @Test
  void testIsAssignedToCustomer() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertFalse(dashboardInfo.isAssignedToCustomer(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#isAssignedToCustomer(CustomerId)}
   */
  @Test
  void testIsAssignedToCustomer2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    assertFalse(dashboardInfo.isAssignedToCustomer(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#isAssignedToCustomer(CustomerId)}
   */
  @Test
  void testIsAssignedToCustomer3() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true));

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act and Assert
    assertTrue(dashboardInfo.isAssignedToCustomer(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  void testGetAssignedCustomerInfo() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertNull(dashboardInfo.getAssignedCustomerInfo(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  void testGetAssignedCustomerInfo2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    assertNull(dashboardInfo.getAssignedCustomerInfo(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  void testGetAssignedCustomerInfo3() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);

    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act and Assert
    assertSame(shortCustomerInfo, dashboardInfo.getAssignedCustomerInfo(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  void testGetAssignedCustomerInfo4() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true));

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act and Assert
    assertNull(dashboardInfo.getAssignedCustomerInfo(new CustomerId(EntityId.NULL_UUID)));
  }

  /**
   * Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  void testAddAssignedCustomer() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(null);

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(customer);

    // Assert
    assertEquals(1, dashboardInfo.getAssignedCustomers().size());
    assertTrue(actualAddAssignedCustomerResult);
  }

  /**
   * Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  void testAddAssignedCustomer2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(customer);

    // Assert
    Set<ShortCustomerInfo> assignedCustomers2 = dashboardInfo.getAssignedCustomers();
    assertEquals(1, assignedCustomers2.size());
    assertTrue(actualAddAssignedCustomerResult);
    assertSame(assignedCustomers, assignedCustomers2);
  }

  /**
   * Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  void testAddAssignedCustomer3() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true));

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(customer);

    // Assert
    Set<ShortCustomerInfo> assignedCustomers2 = dashboardInfo.getAssignedCustomers();
    assertEquals(1, assignedCustomers2.size());
    assertFalse(actualAddAssignedCustomerResult);
    assertSame(assignedCustomers, assignedCustomers2);
  }

  /**
   * Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  void testUpdateAssignedCustomer() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertFalse(dashboardInfo.updateAssignedCustomer(new Customer()));
  }

  /**
   * Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  void testUpdateAssignedCustomer2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertFalse(dashboardInfo.updateAssignedCustomer(customer));
  }

  /**
   * Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  void testUpdateAssignedCustomer3() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertFalse(dashboardInfo.updateAssignedCustomer(new Customer(new Customer())));
  }

  /**
   * Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  void testUpdateAssignedCustomer4() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true));

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertTrue(dashboardInfo.updateAssignedCustomer(customer));
  }

  /**
   * Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  void testRemoveAssignedCustomer() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    boolean actualRemoveAssignedCustomerResult = dashboardInfo.removeAssignedCustomer(new Customer());

    // Assert
    assertNull(dashboardInfo.getAssignedCustomers());
    assertFalse(actualRemoveAssignedCustomerResult);
  }

  /**
   * Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  void testRemoveAssignedCustomer2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertFalse(dashboardInfo.removeAssignedCustomer(customer));
    Set<ShortCustomerInfo> assignedCustomers2 = dashboardInfo.getAssignedCustomers();
    assertTrue(assignedCustomers2.isEmpty());
    assertSame(assignedCustomers, assignedCustomers2);
  }

  /**
   * Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  void testRemoveAssignedCustomer3() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    boolean actualRemoveAssignedCustomerResult = dashboardInfo.removeAssignedCustomer(new Customer(new Customer()));

    // Assert
    assertNull(dashboardInfo.getAssignedCustomers());
    assertFalse(actualRemoveAssignedCustomerResult);
  }

  /**
   * Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  void testRemoveAssignedCustomer4() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true));

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    Customer customer = new Customer();
    customer.setId(new CustomerId(EntityId.NULL_UUID));

    // Act
    boolean actualRemoveAssignedCustomerResult = dashboardInfo.removeAssignedCustomer(customer);

    // Assert
    Set<ShortCustomerInfo> assignedCustomers2 = dashboardInfo.getAssignedCustomers();
    assertTrue(assignedCustomers2.isEmpty());
    assertTrue(actualRemoveAssignedCustomerResult);
    assertSame(assignedCustomers, assignedCustomers2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardInfo#equals(Object)}
   *   <li>{@link DashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    DashboardInfo dashboardInfo2 = new DashboardInfo();

    // Act and Assert
    assertEquals(dashboardInfo, dashboardInfo2);
    int expectedHashCodeResult = dashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardInfo#equals(Object)}
   *   <li>{@link DashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertEquals(dashboardInfo, dashboardInfo);
    int expectedHashCodeResult = dashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfo.hashCode());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertNotEquals(dashboard, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardInfo(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setImage("Image");

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileHide(true);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileOrder(1);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardInfo(), null);
  }

  /**
   * Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardInfo(), "Different type to DashboardInfo");
  }

  /**
   * Method under test: {@link DashboardInfo#DashboardInfo(DashboardInfo)}
   */
  @Test
  void testNewDashboardInfo() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertEquals(dashboardInfo, new DashboardInfo(dashboardInfo));
  }

  /**
   * Method under test: {@link DashboardInfo#DashboardInfo(DashboardInfo)}
   */
  @Test
  void testNewDashboardInfo2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileHide(true);

    // Act and Assert
    assertEquals(dashboardInfo, new DashboardInfo(dashboardInfo));
  }
}
