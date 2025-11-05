package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.mobile.QRCodeConfig.QRCodeConfigBuilder;

@ContextConfiguration(classes = {QRCodeConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class QRCodeConfigDiffblueTest {
  @Autowired private QRCodeConfigBuilder qRCodeConfigBuilder;

  /**
   * Test {@link QRCodeConfig#equals(Object)}, and {@link QRCodeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();
    QRCodeConfig qrCodeConfig2 =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertEquals(qrCodeConfig, qrCodeConfig2);
    assertEquals(qrCodeConfig.hashCode(), qrCodeConfig2.hashCode());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}, and {@link QRCodeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(null)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();
    QRCodeConfig qrCodeConfig2 =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(null)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertEquals(qrCodeConfig, qrCodeConfig2);
    assertEquals(qrCodeConfig.hashCode(), qrCodeConfig2.hashCode());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}, and {@link QRCodeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel(null)
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();
    QRCodeConfig qrCodeConfig2 =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel(null)
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertEquals(qrCodeConfig, qrCodeConfig2);
    assertEquals(qrCodeConfig.hashCode(), qrCodeConfig2.hashCode());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}, and {@link QRCodeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QRCodeConfig#equals(Object)}
   *   <li>{@link QRCodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertEquals(qrCodeConfig, qrCodeConfig);
    int expectedHashCodeResult = qrCodeConfig.hashCode();
    assertEquals(expectedHashCodeResult, qrCodeConfig.hashCode());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(false)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(null)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.LEFT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel(null)
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("42")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(false)
            .showOnHomePage(true)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QRCodeConfig qrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(false)
            .build();

    // Act and Assert
    assertNotEquals(
        qrCodeConfig,
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build());
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build(),
        null);
  }

  /**
   * Test {@link QRCodeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QRCodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QRCodeConfig.equals(Object)", "int QRCodeConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build(),
        "Different type to QRCodeConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QRCodeConfig.<init>()",
    "void QRCodeConfig.<init>(boolean, boolean, boolean, BadgePosition, String)",
    "BadgePosition QRCodeConfig.getBadgePosition()",
    "String QRCodeConfig.getQrCodeLabel()",
    "boolean QRCodeConfig.isBadgeEnabled()",
    "boolean QRCodeConfig.isQrCodeLabelEnabled()",
    "boolean QRCodeConfig.isShowOnHomePage()",
    "void QRCodeConfig.setBadgeEnabled(boolean)",
    "void QRCodeConfig.setBadgePosition(BadgePosition)",
    "void QRCodeConfig.setQrCodeLabel(String)",
    "void QRCodeConfig.setQrCodeLabelEnabled(boolean)",
    "void QRCodeConfig.setShowOnHomePage(boolean)",
    "String QRCodeConfig.toString()"
  })
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

    // Assert
    assertEquals(
        "QRCodeConfig(showOnHomePage=true, badgeEnabled=true, qrCodeLabelEnabled=true, badgePosition=RIGHT,"
            + " qrCodeLabel=Qr Code Label)",
        actualToStringResult);
    assertEquals("Qr Code Label", actualQrCodeLabel);
    assertEquals(BadgePosition.RIGHT, actualBadgePosition);
    assertTrue(actualIsBadgeEnabledResult);
    assertTrue(actualIsQrCodeLabelEnabledResult);
    assertTrue(actualQrCodeConfig.isShowOnHomePage());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QRCodeConfig#QRCodeConfig(boolean, boolean, boolean, BadgePosition, String)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QRCodeConfig.<init>()",
    "void QRCodeConfig.<init>(boolean, boolean, boolean, BadgePosition, String)",
    "BadgePosition QRCodeConfig.getBadgePosition()",
    "String QRCodeConfig.getQrCodeLabel()",
    "boolean QRCodeConfig.isBadgeEnabled()",
    "boolean QRCodeConfig.isQrCodeLabelEnabled()",
    "boolean QRCodeConfig.isShowOnHomePage()",
    "void QRCodeConfig.setBadgeEnabled(boolean)",
    "void QRCodeConfig.setBadgePosition(BadgePosition)",
    "void QRCodeConfig.setQrCodeLabel(String)",
    "void QRCodeConfig.setQrCodeLabelEnabled(boolean)",
    "void QRCodeConfig.setShowOnHomePage(boolean)",
    "String QRCodeConfig.toString()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    QRCodeConfig actualQrCodeConfig =
        new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label");
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

    // Assert
    assertEquals(
        "QRCodeConfig(showOnHomePage=true, badgeEnabled=true, qrCodeLabelEnabled=true, badgePosition=RIGHT,"
            + " qrCodeLabel=Qr Code Label)",
        actualToStringResult);
    assertEquals("Qr Code Label", actualQrCodeLabel);
    assertEquals(BadgePosition.RIGHT, actualBadgePosition);
    assertTrue(actualIsBadgeEnabledResult);
    assertTrue(actualIsQrCodeLabelEnabledResult);
    assertTrue(actualQrCodeConfig.isShowOnHomePage());
  }

  /**
   * Test QRCodeConfigBuilder {@link QRCodeConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QRCodeConfigBuilder#build()}
   *   <li>{@link QRCodeConfigBuilder#badgeEnabled(boolean)}
   *   <li>{@link QRCodeConfigBuilder#badgePosition(BadgePosition)}
   *   <li>{@link QRCodeConfigBuilder#qrCodeLabel(String)}
   *   <li>{@link QRCodeConfigBuilder#qrCodeLabelEnabled(boolean)}
   *   <li>{@link QRCodeConfigBuilder#showOnHomePage(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test QRCodeConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QRCodeConfigBuilder.<init>()",
    "QRCodeConfigBuilder QRCodeConfigBuilder.badgeEnabled(boolean)",
    "QRCodeConfigBuilder QRCodeConfigBuilder.badgePosition(BadgePosition)",
    "QRCodeConfig QRCodeConfigBuilder.build()",
    "QRCodeConfigBuilder QRCodeConfigBuilder.qrCodeLabel(String)",
    "QRCodeConfigBuilder QRCodeConfigBuilder.qrCodeLabelEnabled(boolean)",
    "QRCodeConfigBuilder QRCodeConfigBuilder.showOnHomePage(boolean)",
    "String QRCodeConfigBuilder.toString()"
  })
  void testQRCodeConfigBuilderBuild() {
    // Arrange and Act
    QRCodeConfig actualQrCodeConfig =
        QRCodeConfig.builder()
            .badgeEnabled(true)
            .badgePosition(BadgePosition.RIGHT)
            .qrCodeLabel("Qr Code Label")
            .qrCodeLabelEnabled(true)
            .showOnHomePage(true)
            .build();

    // Assert
    assertEquals("Qr Code Label", actualQrCodeConfig.getQrCodeLabel());
    assertEquals(BadgePosition.RIGHT, actualQrCodeConfig.getBadgePosition());
    assertTrue(actualQrCodeConfig.isBadgeEnabled());
    assertTrue(actualQrCodeConfig.isQrCodeLabelEnabled());
    assertTrue(actualQrCodeConfig.isShowOnHomePage());
  }
}
