package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.mobile.QRCodeConfig.QRCodeConfigBuilder;

class QRCodeConfigDiffblueTest {
  /**
   * Test {@link QRCodeConfig#equals(Object)}, and
   * {@link QRCodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link QRCodeConfig#equals(Object)}, and
   * {@link QRCodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link QRCodeConfig#equals(Object)}, and
   * {@link QRCodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link QRCodeConfig#equals(Object)}, and
   * {@link QRCodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link QRCodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when 'true'")
  void testGettersAndSetters_whenTrue() {
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
   * Test QRCodeConfigBuilder {@link QRCodeConfigBuilder#build()}.
   * <p>
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
  @DisplayName("Test QRCodeConfigBuilder build()")
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
