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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QRCodeConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QRCodeConfig buildResult = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.badgePosition(Mockito.<BadgePosition>any())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder2 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder2.badgeEnabled(anyBoolean())).thenReturn(qrCodeConfigBuilder);
    QRCodeConfig buildResult = qrCodeConfigBuilder2.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(null)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.qrCodeLabel(Mockito.<String>any())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder2 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder2.badgePosition(Mockito.<BadgePosition>any())).thenReturn(qrCodeConfigBuilder);
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder3 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder3.badgeEnabled(anyBoolean())).thenReturn(qrCodeConfigBuilder2);
    QRCodeConfig buildResult = qrCodeConfigBuilder3.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(null)
        .qrCodeLabel(null)
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QRCodeConfig buildResult = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.badgeEnabled(anyBoolean())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig buildResult = qrCodeConfigBuilder.badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.badgeEnabled(anyBoolean())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig buildResult = qrCodeConfigBuilder.badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(false)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.badgeEnabled(anyBoolean())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig buildResult = qrCodeConfigBuilder.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.badgePosition(Mockito.<BadgePosition>any())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder2 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder2.badgeEnabled(anyBoolean())).thenReturn(qrCodeConfigBuilder);
    QRCodeConfig buildResult = qrCodeConfigBuilder2.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.badgePosition(Mockito.<BadgePosition>any())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder2 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder2.badgeEnabled(anyBoolean())).thenReturn(qrCodeConfigBuilder);
    QRCodeConfig buildResult = qrCodeConfigBuilder2.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(false)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.qrCodeLabel(Mockito.<String>any())).thenReturn(QRCodeConfig.builder());
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder2 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder2.badgePosition(Mockito.<BadgePosition>any())).thenReturn(qrCodeConfigBuilder);
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder3 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder3.badgeEnabled(anyBoolean())).thenReturn(qrCodeConfigBuilder2);
    QRCodeConfig buildResult = qrCodeConfigBuilder3.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(null)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QRCodeConfig.QRCodeConfigBuilder builderResult = QRCodeConfig.builder();
    builderResult.qrCodeLabel("Qr Code Label");
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder.qrCodeLabel(Mockito.<String>any())).thenReturn(builderResult);
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder2 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder2.badgePosition(Mockito.<BadgePosition>any())).thenReturn(qrCodeConfigBuilder);
    QRCodeConfig.QRCodeConfigBuilder qrCodeConfigBuilder3 = mock(QRCodeConfig.QRCodeConfigBuilder.class);
    when(qrCodeConfigBuilder3.badgeEnabled(anyBoolean())).thenReturn(qrCodeConfigBuilder2);
    QRCodeConfig buildResult = qrCodeConfigBuilder3.badgeEnabled(true)
        .badgePosition(BadgePosition.LEFT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    QRCodeConfig buildResult2 = QRCodeConfig.builder()
        .badgeEnabled(false)
        .badgePosition(null)
        .qrCodeLabel(null)
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    QRCodeConfig buildResult = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    QRCodeConfig buildResult = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to QRCodeConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#QRCodeConfig()}
   *   <li>{@link QRCodeConfig#setBadgeEnabled(boolean)}
   *   <li>{@link QRCodeConfig#setBadgePosition(BadgePosition)}
   *   <li>{@link QRCodeConfig#setQrCodeLabel(String)}
   *   <li>{@link QRCodeConfig#setQrCodeLabelEnabled(boolean)}
   *   <li>{@link QRCodeConfig#setShowOnHomePage(boolean)}
   *   <li>{@link QRCodeConfig#toString()}
   *   <li>{@link QRCodeConfig#getBadgePosition()}
   *   <li>{@link QRCodeConfig#getQrCodeLabel()}
   *   <li>{@link QRCodeConfig#isBadgeEnabled()}
   *   <li>{@link QRCodeConfig#isQrCodeLabelEnabled()}
   *   <li>{@link QRCodeConfig#isShowOnHomePage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    QRCodeConfig actualQrCodeConfig = new QRCodeConfig();
    actualQrCodeConfig.setBadgeEnabled(true);
    actualQrCodeConfig.setBadgePosition(BadgePosition.RIGHT);
    actualQrCodeConfig.setQrCodeLabel("Qr Code Label");
    actualQrCodeConfig.setQrCodeLabelEnabled(true);
    actualQrCodeConfig.setShowOnHomePage(true);
    String actualToStringResult = actualQrCodeConfig.toString();
    BadgePosition actualBadgePosition = actualQrCodeConfig.getBadgePosition();
    String actualQrCodeLabel = actualQrCodeConfig.getQrCodeLabel();
    boolean actualIsBadgeEnabledResult = actualQrCodeConfig.isBadgeEnabled();
    boolean actualIsQrCodeLabelEnabledResult = actualQrCodeConfig.isQrCodeLabelEnabled();

    // Assert that nothing has changed
    assertEquals("QRCodeConfig(showOnHomePage=true, badgeEnabled=true, qrCodeLabelEnabled=true, badgePosition=RIGHT,"
        + " qrCodeLabel=Qr Code Label)", actualToStringResult);
    assertEquals("Qr Code Label", actualQrCodeLabel);
    assertEquals(BadgePosition.RIGHT, actualBadgePosition);
    assertTrue(actualIsBadgeEnabledResult);
    assertTrue(actualIsQrCodeLabelEnabledResult);
    assertTrue(actualQrCodeConfig.isShowOnHomePage());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link QRCodeConfig#QRCodeConfig(boolean, boolean, boolean, BadgePosition, String)}
   *   <li>{@link QRCodeConfig#setBadgeEnabled(boolean)}
   *   <li>{@link QRCodeConfig#setBadgePosition(BadgePosition)}
   *   <li>{@link QRCodeConfig#setQrCodeLabel(String)}
   *   <li>{@link QRCodeConfig#setQrCodeLabelEnabled(boolean)}
   *   <li>{@link QRCodeConfig#setShowOnHomePage(boolean)}
   *   <li>{@link QRCodeConfig#toString()}
   *   <li>{@link QRCodeConfig#getBadgePosition()}
   *   <li>{@link QRCodeConfig#getQrCodeLabel()}
   *   <li>{@link QRCodeConfig#isBadgeEnabled()}
   *   <li>{@link QRCodeConfig#isQrCodeLabelEnabled()}
   *   <li>{@link QRCodeConfig#isShowOnHomePage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    QRCodeConfig actualQrCodeConfig = new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label");
    actualQrCodeConfig.setBadgeEnabled(true);
    actualQrCodeConfig.setBadgePosition(BadgePosition.RIGHT);
    actualQrCodeConfig.setQrCodeLabel("Qr Code Label");
    actualQrCodeConfig.setQrCodeLabelEnabled(true);
    actualQrCodeConfig.setShowOnHomePage(true);
    String actualToStringResult = actualQrCodeConfig.toString();
    BadgePosition actualBadgePosition = actualQrCodeConfig.getBadgePosition();
    String actualQrCodeLabel = actualQrCodeConfig.getQrCodeLabel();
    boolean actualIsBadgeEnabledResult = actualQrCodeConfig.isBadgeEnabled();
    boolean actualIsQrCodeLabelEnabledResult = actualQrCodeConfig.isQrCodeLabelEnabled();

    // Assert that nothing has changed
    assertEquals("QRCodeConfig(showOnHomePage=true, badgeEnabled=true, qrCodeLabelEnabled=true, badgePosition=RIGHT,"
        + " qrCodeLabel=Qr Code Label)", actualToStringResult);
    assertEquals("Qr Code Label", actualQrCodeLabel);
    assertEquals(BadgePosition.RIGHT, actualBadgePosition);
    assertTrue(actualIsBadgeEnabledResult);
    assertTrue(actualIsQrCodeLabelEnabledResult);
    assertTrue(actualQrCodeConfig.isShowOnHomePage());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig.QRCodeConfigBuilder#build()}
   *   <li>{@link QRCodeConfig.QRCodeConfigBuilder#badgeEnabled(boolean)}
   *   <li>{@link QRCodeConfig.QRCodeConfigBuilder#badgePosition(BadgePosition)}
   *   <li>{@link QRCodeConfig.QRCodeConfigBuilder#qrCodeLabel(String)}
   *   <li>{@link QRCodeConfig.QRCodeConfigBuilder#qrCodeLabelEnabled(boolean)}
   *   <li>{@link QRCodeConfig.QRCodeConfigBuilder#showOnHomePage(boolean)}
   * </ul>
   */
  @Test
  void testQRCodeConfigBuilderBuild() {
    // Arrange and Act
    QRCodeConfig actualBuildResult = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();

    // Assert
    assertEquals("Qr Code Label", actualBuildResult.getQrCodeLabel());
    assertEquals(BadgePosition.RIGHT, actualBuildResult.getBadgePosition());
    assertTrue(actualBuildResult.isBadgeEnabled());
    assertTrue(actualBuildResult.isQrCodeLabelEnabled());
    assertTrue(actualBuildResult.isShowOnHomePage());
  }
}
