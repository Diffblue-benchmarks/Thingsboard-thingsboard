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
package org.thingsboard.server.common.data.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class DomainDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Domain domain = new Domain();
    Domain domain2 = new Domain();

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Domain domain = new Domain();
    domain.setTenantId(TenantId.SYS_TENANT_ID);

    Domain domain2 = new Domain();
    domain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Domain domain = new Domain();
    domain.setName("Name");

    Domain domain2 = new Domain();
    domain2.setName("Name");

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Domain domain = new Domain();

    // Act and Assert
    assertEquals(domain, domain);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain.hashCode());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();

    // Act and Assert
    assertNotEquals(domainInfo, new Domain());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Domain domain = new Domain();

    // Act and Assert
    assertNotEquals(domain, new DomainInfo());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Domain domain = new Domain();
    DomainInfo domainInfo = mock(DomainInfo.class);
    when(domainInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domain, domainInfo);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Domain domain = new Domain();
    domain.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(domain, new Domain());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Domain domain = new Domain();
    domain.setName("Name");

    // Act and Assert
    assertNotEquals(domain, new Domain());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Domain domain = new Domain();
    domain.setOauth2Enabled(true);

    // Act and Assert
    assertNotEquals(domain, new Domain());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Domain domain = new Domain();
    domain.setPropagateToEdge(true);

    // Act and Assert
    assertNotEquals(domain, new Domain());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Domain domain = new Domain();

    Domain domain2 = new Domain();
    domain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(domain, domain2);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Domain domain = new Domain();

    Domain domain2 = new Domain();
    domain2.setName("Name");

    // Act and Assert
    assertNotEquals(domain, domain2);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Domain(), null);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Domain(), "Different type to Domain");
  }

  /**
   * Method under test: {@link Domain#Domain(Domain)}
   */
  @Test
  void testNewDomain() {
    // Arrange
    Domain domain = new Domain();

    // Act and Assert
    assertEquals(domain, new Domain(domain));
  }
}
