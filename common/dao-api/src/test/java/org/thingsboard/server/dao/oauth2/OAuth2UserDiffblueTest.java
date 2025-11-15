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
package org.thingsboard.server.dao.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class OAuth2UserDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2User#equals(Object)}
   *   <li>{@link OAuth2User#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("Tenant Name");

    // Act and Assert
    assertEquals(oAuth2User, oAuth2User);
    int expectedHashCodeResult = oAuth2User.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2User.hashCode());
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(false);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(null);
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName(null);

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("org.thingsboard.server.dao.oauth2.OAuth2User");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, null);
  }

  /**
   * Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, "Different type to OAuth2User");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OAuth2User}
   *   <li>{@link OAuth2User#setAlwaysFullScreen(boolean)}
   *   <li>{@link OAuth2User#setCustomerId(CustomerId)}
   *   <li>{@link OAuth2User#setCustomerName(String)}
   *   <li>{@link OAuth2User#setDefaultDashboardName(String)}
   *   <li>{@link OAuth2User#setEmail(String)}
   *   <li>{@link OAuth2User#setFirstName(String)}
   *   <li>{@link OAuth2User#setLastName(String)}
   *   <li>{@link OAuth2User#setTenantId(TenantId)}
   *   <li>{@link OAuth2User#setTenantName(String)}
   *   <li>{@link OAuth2User#toString()}
   *   <li>{@link OAuth2User#getCustomerId()}
   *   <li>{@link OAuth2User#getCustomerName()}
   *   <li>{@link OAuth2User#getDefaultDashboardName()}
   *   <li>{@link OAuth2User#getEmail()}
   *   <li>{@link OAuth2User#getFirstName()}
   *   <li>{@link OAuth2User#getLastName()}
   *   <li>{@link OAuth2User#getTenantId()}
   *   <li>{@link OAuth2User#getTenantName()}
   *   <li>{@link OAuth2User#isAlwaysFullScreen()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2User actualOAuth2User = new OAuth2User();
    actualOAuth2User.setAlwaysFullScreen(true);
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    actualOAuth2User.setCustomerId(customerId);
    actualOAuth2User.setCustomerName("Customer Name");
    actualOAuth2User.setDefaultDashboardName("Default Dashboard Name");
    actualOAuth2User.setEmail("jane.doe@example.org");
    actualOAuth2User.setFirstName("Jane");
    actualOAuth2User.setLastName("Doe");
    TenantId tenantId = new TenantId(UUID.randomUUID());
    actualOAuth2User.setTenantId(tenantId);
    actualOAuth2User.setTenantName("Tenant Name");
    actualOAuth2User.toString();
    CustomerId actualCustomerId = actualOAuth2User.getCustomerId();
    String actualCustomerName = actualOAuth2User.getCustomerName();
    String actualDefaultDashboardName = actualOAuth2User.getDefaultDashboardName();
    String actualEmail = actualOAuth2User.getEmail();
    String actualFirstName = actualOAuth2User.getFirstName();
    String actualLastName = actualOAuth2User.getLastName();
    TenantId actualTenantId = actualOAuth2User.getTenantId();
    String actualTenantName = actualOAuth2User.getTenantName();

    // Assert that nothing has changed
    assertEquals("Customer Name", actualCustomerName);
    assertEquals("Default Dashboard Name", actualDefaultDashboardName);
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals("Tenant Name", actualTenantName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
    assertSame(customerId, actualCustomerId);
    assertSame(tenantId, actualTenantId);
  }
}
