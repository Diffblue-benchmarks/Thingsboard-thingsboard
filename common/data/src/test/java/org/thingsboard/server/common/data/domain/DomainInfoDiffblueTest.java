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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientInfo;

class DomainInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DomainInfo#equals(Object)}
   *   <li>{@link DomainInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    DomainInfo domainInfo2 = new DomainInfo();

    // Act and Assert
    assertEquals(domainInfo, domainInfo2);
    int expectedHashCodeResult = domainInfo.hashCode();
    assertEquals(expectedHashCodeResult, domainInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DomainInfo#equals(Object)}
   *   <li>{@link DomainInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Domain domain = new Domain();
    DomainInfo domainInfo = new DomainInfo(domain, new ArrayList<>());
    Domain domain2 = new Domain();
    DomainInfo domainInfo2 = new DomainInfo(domain2, new ArrayList<>());

    // Act and Assert
    assertEquals(domainInfo, domainInfo2);
    int expectedHashCodeResult = domainInfo.hashCode();
    assertEquals(expectedHashCodeResult, domainInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DomainInfo#equals(Object)}
   *   <li>{@link DomainInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();

    // Act and Assert
    assertEquals(domainInfo, domainInfo);
    int expectedHashCodeResult = domainInfo.hashCode();
    assertEquals(expectedHashCodeResult, domainInfo.hashCode());
  }

  /**
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Domain domain = new Domain();
    DomainInfo domainInfo = new DomainInfo(domain, new ArrayList<>());

    // Act and Assert
    assertNotEquals(domainInfo, new DomainInfo());
  }

  /**
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    Domain domain = new Domain();

    // Act and Assert
    assertNotEquals(domainInfo, new DomainInfo(domain, new ArrayList<>()));
  }

  /**
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainInfo(), mock(Domain.class));
  }

  /**
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(domainInfo, new DomainInfo());
  }

  /**
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainInfo(), null);
  }

  /**
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainInfo(), "Different type to DomainInfo");
  }

  /**
   * Method under test: {@link DomainInfo#DomainInfo(Domain, List)}
   */
  @Test
  void testNewDomainInfo() {
    // Arrange
    Domain domain = new Domain();
    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();

    // Act
    DomainInfo actualDomainInfo = new DomainInfo(domain, oauth2ClientInfos);

    // Assert
    assertNull(actualDomainInfo.getName());
    assertNull(actualDomainInfo.getUuidId());
    assertNull(actualDomainInfo.getId());
    assertNull(actualDomainInfo.getTenantId());
    assertEquals(0L, actualDomainInfo.getCreatedTime());
    assertFalse(actualDomainInfo.isOauth2Enabled());
    assertFalse(actualDomainInfo.isPropagateToEdge());
    List<OAuth2ClientInfo> oauth2ClientInfos2 = actualDomainInfo.getOauth2ClientInfos();
    assertTrue(oauth2ClientInfos2.isEmpty());
    assertSame(oauth2ClientInfos, oauth2ClientInfos2);
  }

  /**
   * Method under test: {@link DomainInfo#DomainInfo(Domain, List)}
   */
  @Test
  void testNewDomainInfo2() {
    // Arrange
    Domain domain = new Domain();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());

    // Act
    DomainInfo actualDomainInfo = new DomainInfo(domain, oauth2ClientInfos);

    // Assert
    assertNull(actualDomainInfo.getName());
    assertNull(actualDomainInfo.getUuidId());
    assertNull(actualDomainInfo.getId());
    assertNull(actualDomainInfo.getTenantId());
    assertEquals(0L, actualDomainInfo.getCreatedTime());
    assertFalse(actualDomainInfo.isOauth2Enabled());
    assertFalse(actualDomainInfo.isPropagateToEdge());
    assertSame(oauth2ClientInfos, actualDomainInfo.getOauth2ClientInfos());
  }

  /**
   * Method under test: {@link DomainInfo#DomainInfo(Domain, List)}
   */
  @Test
  void testNewDomainInfo3() {
    // Arrange
    Domain domain = new Domain();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());
    oauth2ClientInfos.add(new OAuth2ClientInfo());

    // Act
    DomainInfo actualDomainInfo = new DomainInfo(domain, oauth2ClientInfos);

    // Assert
    assertNull(actualDomainInfo.getName());
    assertNull(actualDomainInfo.getUuidId());
    assertNull(actualDomainInfo.getId());
    assertNull(actualDomainInfo.getTenantId());
    assertEquals(0L, actualDomainInfo.getCreatedTime());
    assertFalse(actualDomainInfo.isOauth2Enabled());
    assertFalse(actualDomainInfo.isPropagateToEdge());
    assertSame(oauth2ClientInfos, actualDomainInfo.getOauth2ClientInfos());
  }
}
