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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class MobileAppDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileApp mobileApp2 = new MobileApp();

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setTenantId(TenantId.SYS_TENANT_ID);

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setPkgName("Pkg Name");

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setPkgName("Pkg Name");

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("App Secret");

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setAppSecret("App Secret");

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertEquals(mobileApp, mobileApp);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp.hashCode());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileApp());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertNotEquals(mobileApp, new MobileAppInfo());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileAppInfo mobileAppInfo = mock(MobileAppInfo.class);
    when(mobileAppInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileApp, mobileAppInfo);
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setPkgName("Pkg Name");

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("App Secret");

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setOauth2Enabled(true);

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileApp, mobileApp2);
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setPkgName("Pkg Name");

    // Act and Assert
    assertNotEquals(mobileApp, mobileApp2);
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setAppSecret("App Secret");

    // Act and Assert
    assertNotEquals(mobileApp, mobileApp2);
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileApp(), null);
  }

  /**
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileApp(), "Different type to MobileApp");
  }

  /**
   * Method under test: {@link MobileApp#MobileApp(MobileApp)}
   */
  @Test
  void testNewMobileApp() {
    // Arrange
    MobileApp mobile = new MobileApp();

    // Act and Assert
    assertEquals(mobile, new MobileApp(mobile));
  }
}
