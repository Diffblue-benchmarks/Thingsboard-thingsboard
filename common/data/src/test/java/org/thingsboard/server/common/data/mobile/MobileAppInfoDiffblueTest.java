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
package org.thingsboard.server.common.data.mobile;

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

class MobileAppInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppInfo#equals(Object)}
   *   <li>{@link MobileAppInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    MobileAppInfo mobileAppInfo2 = new MobileAppInfo();

    // Act and Assert
    assertEquals(mobileAppInfo, mobileAppInfo2);
    int expectedHashCodeResult = mobileAppInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppInfo#equals(Object)}
   *   <li>{@link MobileAppInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileAppInfo mobileAppInfo = new MobileAppInfo(mobileApp, new ArrayList<>());
    MobileApp mobileApp2 = new MobileApp();
    MobileAppInfo mobileAppInfo2 = new MobileAppInfo(mobileApp2, new ArrayList<>());

    // Act and Assert
    assertEquals(mobileAppInfo, mobileAppInfo2);
    int expectedHashCodeResult = mobileAppInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppInfo#equals(Object)}
   *   <li>{@link MobileAppInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();

    // Act and Assert
    assertEquals(mobileAppInfo, mobileAppInfo);
    int expectedHashCodeResult = mobileAppInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppInfo.hashCode());
  }

  /**
   * Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileAppInfo mobileAppInfo = new MobileAppInfo(mobileApp, new ArrayList<>());

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileAppInfo());
  }

  /**
   * Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileAppInfo(mobileApp, new ArrayList<>()));
  }

  /**
   * Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppInfo(), mock(MobileApp.class));
  }

  /**
   * Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileAppInfo());
  }

  /**
   * Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppInfo(), null);
  }

  /**
   * Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppInfo(), "Different type to MobileAppInfo");
  }

  /**
   * Method under test: {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}
   */
  @Test
  void testNewMobileAppInfo() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();

    // Act
    MobileAppInfo actualMobileAppInfo = new MobileAppInfo(mobileApp, oauth2ClientInfos);

    // Assert
    assertNull(actualMobileAppInfo.getAppSecret());
    assertNull(actualMobileAppInfo.getName());
    assertNull(actualMobileAppInfo.getPkgName());
    assertNull(actualMobileAppInfo.getUuidId());
    assertNull(actualMobileAppInfo.getId());
    assertNull(actualMobileAppInfo.getTenantId());
    assertEquals(0L, actualMobileAppInfo.getCreatedTime());
    assertFalse(actualMobileAppInfo.isOauth2Enabled());
    List<OAuth2ClientInfo> oauth2ClientInfos2 = actualMobileAppInfo.getOauth2ClientInfos();
    assertTrue(oauth2ClientInfos2.isEmpty());
    assertSame(oauth2ClientInfos, oauth2ClientInfos2);
  }

  /**
   * Method under test: {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}
   */
  @Test
  void testNewMobileAppInfo2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());

    // Act
    MobileAppInfo actualMobileAppInfo = new MobileAppInfo(mobileApp, oauth2ClientInfos);

    // Assert
    assertNull(actualMobileAppInfo.getAppSecret());
    assertNull(actualMobileAppInfo.getName());
    assertNull(actualMobileAppInfo.getPkgName());
    assertNull(actualMobileAppInfo.getUuidId());
    assertNull(actualMobileAppInfo.getId());
    assertNull(actualMobileAppInfo.getTenantId());
    assertEquals(0L, actualMobileAppInfo.getCreatedTime());
    assertFalse(actualMobileAppInfo.isOauth2Enabled());
    assertSame(oauth2ClientInfos, actualMobileAppInfo.getOauth2ClientInfos());
  }

  /**
   * Method under test: {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}
   */
  @Test
  void testNewMobileAppInfo3() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());
    oauth2ClientInfos.add(new OAuth2ClientInfo());

    // Act
    MobileAppInfo actualMobileAppInfo = new MobileAppInfo(mobileApp, oauth2ClientInfos);

    // Assert
    assertNull(actualMobileAppInfo.getAppSecret());
    assertNull(actualMobileAppInfo.getName());
    assertNull(actualMobileAppInfo.getPkgName());
    assertNull(actualMobileAppInfo.getUuidId());
    assertNull(actualMobileAppInfo.getId());
    assertNull(actualMobileAppInfo.getTenantId());
    assertEquals(0L, actualMobileAppInfo.getCreatedTime());
    assertFalse(actualMobileAppInfo.isOauth2Enabled());
    assertSame(oauth2ClientInfos, actualMobileAppInfo.getOauth2ClientInfos());
  }
}
