package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgAttributesNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgAttributesNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgAttributesNodeConfiguration TbMsgAttributesNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgAttributesNodeConfiguration actualDefaultConfigurationResult = (new TbMsgAttributesNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("SERVER_SCOPE", actualDefaultConfigurationResult.getScope());
    assertFalse(actualDefaultConfigurationResult.isNotifyDevice());
    assertFalse(actualDefaultConfigurationResult.isSendAttributesUpdatedNotification());
    assertTrue(actualDefaultConfigurationResult.isUpdateAttributesOnlyOnValueChange());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration2 = new TbMsgAttributesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgAttributesNodeConfiguration, tbMsgAttributesNodeConfiguration2);
    int expectedHashCodeResult = tbMsgAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgAttributesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration.setScope("Scope");

    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration2 = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration2.setScope("Scope");

    // Act and Assert
    assertEquals(tbMsgAttributesNodeConfiguration, tbMsgAttributesNodeConfiguration2);
    int expectedHashCodeResult = tbMsgAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgAttributesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgAttributesNodeConfiguration, tbMsgAttributesNodeConfiguration);
    int expectedHashCodeResult = tbMsgAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgAttributesNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgAttributesNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration.setScope("Scope");

    // Act and Assert
    assertNotEquals(tbMsgAttributesNodeConfiguration, new TbMsgAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration.setNotifyDevice(true);

    // Act and Assert
    assertNotEquals(tbMsgAttributesNodeConfiguration, new TbMsgAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration.setSendAttributesUpdatedNotification(true);

    // Act and Assert
    assertNotEquals(tbMsgAttributesNodeConfiguration, new TbMsgAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration.setUpdateAttributesOnlyOnValueChange(true);

    // Act and Assert
    assertNotEquals(tbMsgAttributesNodeConfiguration, new TbMsgAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();

    TbMsgAttributesNodeConfiguration tbMsgAttributesNodeConfiguration2 = new TbMsgAttributesNodeConfiguration();
    tbMsgAttributesNodeConfiguration2.setScope("Scope");

    // Act and Assert
    assertNotEquals(tbMsgAttributesNodeConfiguration, tbMsgAttributesNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgAttributesNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgAttributesNodeConfiguration.equals(Object)",
      "int TbMsgAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgAttributesNodeConfiguration(), "Different type to TbMsgAttributesNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgAttributesNodeConfiguration}
   *   <li>{@link TbMsgAttributesNodeConfiguration#setNotifyDevice(boolean)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#setScope(String)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#setSendAttributesUpdatedNotification(boolean)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#setUpdateAttributesOnlyOnValueChange(boolean)}
   *   <li>{@link TbMsgAttributesNodeConfiguration#toString()}
   *   <li>{@link TbMsgAttributesNodeConfiguration#getScope()}
   *   <li>{@link TbMsgAttributesNodeConfiguration#isNotifyDevice()}
   *   <li>{@link TbMsgAttributesNodeConfiguration#isSendAttributesUpdatedNotification()}
   *   <li>{@link TbMsgAttributesNodeConfiguration#isUpdateAttributesOnlyOnValueChange()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgAttributesNodeConfiguration.<init>()",
      "String TbMsgAttributesNodeConfiguration.getScope()", "boolean TbMsgAttributesNodeConfiguration.isNotifyDevice()",
      "boolean TbMsgAttributesNodeConfiguration.isSendAttributesUpdatedNotification()",
      "boolean TbMsgAttributesNodeConfiguration.isUpdateAttributesOnlyOnValueChange()",
      "void TbMsgAttributesNodeConfiguration.setNotifyDevice(boolean)",
      "void TbMsgAttributesNodeConfiguration.setScope(String)",
      "void TbMsgAttributesNodeConfiguration.setSendAttributesUpdatedNotification(boolean)",
      "void TbMsgAttributesNodeConfiguration.setUpdateAttributesOnlyOnValueChange(boolean)",
      "String TbMsgAttributesNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgAttributesNodeConfiguration actualTbMsgAttributesNodeConfiguration = new TbMsgAttributesNodeConfiguration();
    actualTbMsgAttributesNodeConfiguration.setNotifyDevice(true);
    actualTbMsgAttributesNodeConfiguration.setScope("Scope");
    actualTbMsgAttributesNodeConfiguration.setSendAttributesUpdatedNotification(true);
    actualTbMsgAttributesNodeConfiguration.setUpdateAttributesOnlyOnValueChange(true);
    String actualToStringResult = actualTbMsgAttributesNodeConfiguration.toString();
    String actualScope = actualTbMsgAttributesNodeConfiguration.getScope();
    boolean actualIsNotifyDeviceResult = actualTbMsgAttributesNodeConfiguration.isNotifyDevice();
    boolean actualIsSendAttributesUpdatedNotificationResult = actualTbMsgAttributesNodeConfiguration
        .isSendAttributesUpdatedNotification();

    // Assert
    assertEquals("Scope", actualScope);
    assertEquals(
        "TbMsgAttributesNodeConfiguration(scope=Scope, notifyDevice=true, sendAttributesUpdatedNotification=true,"
            + " updateAttributesOnlyOnValueChange=true)",
        actualToStringResult);
    assertTrue(actualIsNotifyDeviceResult);
    assertTrue(actualIsSendAttributesUpdatedNotificationResult);
    assertTrue(actualTbMsgAttributesNodeConfiguration.isUpdateAttributesOnlyOnValueChange());
  }
}
