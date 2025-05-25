package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgDeleteAttributesNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgDeleteAttributesNodeConfiguration TbMsgDeleteAttributesNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgDeleteAttributesNodeConfiguration actualDefaultConfigurationResult = (new TbMsgDeleteAttributesNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("SERVER_SCOPE", actualDefaultConfigurationResult.getScope());
    assertFalse(actualDefaultConfigurationResult.isNotifyDevice());
    assertFalse(actualDefaultConfigurationResult.isSendAttributesDeletedNotification());
    assertTrue(actualDefaultConfigurationResult.getKeys().isEmpty());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration2 = new TbMsgDeleteAttributesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgDeleteAttributesNodeConfiguration, tbMsgDeleteAttributesNodeConfiguration2);
    int expectedHashCodeResult = tbMsgDeleteAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDeleteAttributesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration.setScope("Scope");

    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration2 = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration2.setScope("Scope");

    // Act and Assert
    assertEquals(tbMsgDeleteAttributesNodeConfiguration, tbMsgDeleteAttributesNodeConfiguration2);
    int expectedHashCodeResult = tbMsgDeleteAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDeleteAttributesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration.setKeys(new ArrayList<>());

    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration2 = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration2.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(tbMsgDeleteAttributesNodeConfiguration, tbMsgDeleteAttributesNodeConfiguration2);
    int expectedHashCodeResult = tbMsgDeleteAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDeleteAttributesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}, and {@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgDeleteAttributesNodeConfiguration, tbMsgDeleteAttributesNodeConfiguration);
    int expectedHashCodeResult = tbMsgDeleteAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDeleteAttributesNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDeleteAttributesNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration.setScope("Scope");

    // Act and Assert
    assertNotEquals(tbMsgDeleteAttributesNodeConfiguration, new TbMsgDeleteAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbMsgDeleteAttributesNodeConfiguration, new TbMsgDeleteAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration.setSendAttributesDeletedNotification(true);

    // Act and Assert
    assertNotEquals(tbMsgDeleteAttributesNodeConfiguration, new TbMsgDeleteAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration.setNotifyDevice(true);

    // Act and Assert
    assertNotEquals(tbMsgDeleteAttributesNodeConfiguration, new TbMsgDeleteAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();

    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration2 = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration2.setScope("Scope");

    // Act and Assert
    assertNotEquals(tbMsgDeleteAttributesNodeConfiguration, tbMsgDeleteAttributesNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();

    TbMsgDeleteAttributesNodeConfiguration tbMsgDeleteAttributesNodeConfiguration2 = new TbMsgDeleteAttributesNodeConfiguration();
    tbMsgDeleteAttributesNodeConfiguration2.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbMsgDeleteAttributesNodeConfiguration, tbMsgDeleteAttributesNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDeleteAttributesNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeleteAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgDeleteAttributesNodeConfiguration.equals(Object)",
      "int TbMsgDeleteAttributesNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDeleteAttributesNodeConfiguration(),
        "Different type to TbMsgDeleteAttributesNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgDeleteAttributesNodeConfiguration}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#setKeys(List)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#setNotifyDevice(boolean)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#setScope(String)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#setSendAttributesDeletedNotification(boolean)}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#toString()}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#getKeys()}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#getScope()}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#isNotifyDevice()}
   *   <li>{@link TbMsgDeleteAttributesNodeConfiguration#isSendAttributesDeletedNotification()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgDeleteAttributesNodeConfiguration.<init>()",
      "List TbMsgDeleteAttributesNodeConfiguration.getKeys()",
      "String TbMsgDeleteAttributesNodeConfiguration.getScope()",
      "boolean TbMsgDeleteAttributesNodeConfiguration.isNotifyDevice()",
      "boolean TbMsgDeleteAttributesNodeConfiguration.isSendAttributesDeletedNotification()",
      "void TbMsgDeleteAttributesNodeConfiguration.setKeys(List)",
      "void TbMsgDeleteAttributesNodeConfiguration.setNotifyDevice(boolean)",
      "void TbMsgDeleteAttributesNodeConfiguration.setScope(String)",
      "void TbMsgDeleteAttributesNodeConfiguration.setSendAttributesDeletedNotification(boolean)",
      "String TbMsgDeleteAttributesNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgDeleteAttributesNodeConfiguration actualTbMsgDeleteAttributesNodeConfiguration = new TbMsgDeleteAttributesNodeConfiguration();
    ArrayList<String> keys = new ArrayList<>();
    actualTbMsgDeleteAttributesNodeConfiguration.setKeys(keys);
    actualTbMsgDeleteAttributesNodeConfiguration.setNotifyDevice(true);
    actualTbMsgDeleteAttributesNodeConfiguration.setScope("Scope");
    actualTbMsgDeleteAttributesNodeConfiguration.setSendAttributesDeletedNotification(true);
    String actualToStringResult = actualTbMsgDeleteAttributesNodeConfiguration.toString();
    List<String> actualKeys = actualTbMsgDeleteAttributesNodeConfiguration.getKeys();
    String actualScope = actualTbMsgDeleteAttributesNodeConfiguration.getScope();
    boolean actualIsNotifyDeviceResult = actualTbMsgDeleteAttributesNodeConfiguration.isNotifyDevice();
    boolean actualIsSendAttributesDeletedNotificationResult = actualTbMsgDeleteAttributesNodeConfiguration
        .isSendAttributesDeletedNotification();

    // Assert
    assertEquals("Scope", actualScope);
    assertEquals("TbMsgDeleteAttributesNodeConfiguration(scope=Scope, keys=[], sendAttributesDeletedNotification=true,"
        + " notifyDevice=true)", actualToStringResult);
    assertTrue(actualKeys.isEmpty());
    assertTrue(actualIsNotifyDeviceResult);
    assertTrue(actualIsSendAttributesDeletedNotificationResult);
    assertSame(keys, actualKeys);
  }
}
