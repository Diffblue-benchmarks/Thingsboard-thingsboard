package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbServiceBusSettingsDiffblueTest {
  /**
   * Test {@link TbServiceBusSettings#equals(Object)}, and {@link TbServiceBusSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusSettings#equals(Object)}
   *   <li>{@link TbServiceBusSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();

    // Act and Assert
    assertEquals(tbServiceBusSettings, tbServiceBusSettings2);
    assertEquals(tbServiceBusSettings.hashCode(), tbServiceBusSettings2.hashCode());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}, and {@link TbServiceBusSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusSettings#equals(Object)}
   *   <li>{@link TbServiceBusSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setNamespaceName("Namespace Name");

    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();
    tbServiceBusSettings2.setNamespaceName("Namespace Name");

    // Act and Assert
    assertEquals(tbServiceBusSettings, tbServiceBusSettings2);
    assertEquals(tbServiceBusSettings.hashCode(), tbServiceBusSettings2.hashCode());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}, and {@link TbServiceBusSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusSettings#equals(Object)}
   *   <li>{@link TbServiceBusSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setSasKeyName("Sas Key Name");

    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();
    tbServiceBusSettings2.setSasKeyName("Sas Key Name");

    // Act and Assert
    assertEquals(tbServiceBusSettings, tbServiceBusSettings2);
    assertEquals(tbServiceBusSettings.hashCode(), tbServiceBusSettings2.hashCode());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}, and {@link TbServiceBusSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusSettings#equals(Object)}
   *   <li>{@link TbServiceBusSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setSasKey("Sas Key");

    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();
    tbServiceBusSettings2.setSasKey("Sas Key");

    // Act and Assert
    assertEquals(tbServiceBusSettings, tbServiceBusSettings2);
    assertEquals(tbServiceBusSettings.hashCode(), tbServiceBusSettings2.hashCode());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}, and {@link TbServiceBusSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusSettings#equals(Object)}
   *   <li>{@link TbServiceBusSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();

    // Act and Assert
    assertEquals(tbServiceBusSettings, tbServiceBusSettings);
    int expectedHashCodeResult = tbServiceBusSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbServiceBusSettings.hashCode());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbServiceBusSettings(), 1);
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setNamespaceName("Namespace Name");

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, new TbServiceBusSettings());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setSasKeyName("Sas Key Name");

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, new TbServiceBusSettings());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setSasKey("Sas Key");

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, new TbServiceBusSettings());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();
    tbServiceBusSettings.setMaxMessages(3);

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, new TbServiceBusSettings());
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();

    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();
    tbServiceBusSettings2.setNamespaceName("Namespace Name");

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, tbServiceBusSettings2);
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();

    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();
    tbServiceBusSettings2.setSasKeyName("Sas Key Name");

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, tbServiceBusSettings2);
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();

    TbServiceBusSettings tbServiceBusSettings2 = new TbServiceBusSettings();
    tbServiceBusSettings2.setSasKey("Sas Key");

    // Act and Assert
    assertNotEquals(tbServiceBusSettings, tbServiceBusSettings2);
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbServiceBusSettings(), null);
  }

  /**
   * Test {@link TbServiceBusSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbServiceBusSettings.equals(Object)",
    "int TbServiceBusSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbServiceBusSettings(), "Different type to TbServiceBusSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusSettings#setMaxMessages(int)}
   *   <li>{@link TbServiceBusSettings#setNamespaceName(String)}
   *   <li>{@link TbServiceBusSettings#setSasKey(String)}
   *   <li>{@link TbServiceBusSettings#setSasKeyName(String)}
   *   <li>{@link TbServiceBusSettings#toString()}
   *   <li>{@link TbServiceBusSettings#getMaxMessages()}
   *   <li>{@link TbServiceBusSettings#getNamespaceName()}
   *   <li>{@link TbServiceBusSettings#getSasKey()}
   *   <li>{@link TbServiceBusSettings#getSasKeyName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TbServiceBusSettings.getMaxMessages()",
    "String TbServiceBusSettings.getNamespaceName()",
    "String TbServiceBusSettings.getSasKey()",
    "String TbServiceBusSettings.getSasKeyName()",
    "void TbServiceBusSettings.setMaxMessages(int)",
    "void TbServiceBusSettings.setNamespaceName(String)",
    "void TbServiceBusSettings.setSasKey(String)",
    "void TbServiceBusSettings.setSasKeyName(String)",
    "String TbServiceBusSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbServiceBusSettings tbServiceBusSettings = new TbServiceBusSettings();

    // Act
    tbServiceBusSettings.setMaxMessages(3);
    tbServiceBusSettings.setNamespaceName("Namespace Name");
    tbServiceBusSettings.setSasKey("Sas Key");
    tbServiceBusSettings.setSasKeyName("Sas Key Name");
    String actualToStringResult = tbServiceBusSettings.toString();
    int actualMaxMessages = tbServiceBusSettings.getMaxMessages();
    String actualNamespaceName = tbServiceBusSettings.getNamespaceName();
    String actualSasKey = tbServiceBusSettings.getSasKey();

    // Assert
    assertEquals("Namespace Name", actualNamespaceName);
    assertEquals("Sas Key Name", tbServiceBusSettings.getSasKeyName());
    assertEquals("Sas Key", actualSasKey);
    assertEquals(
        "TbServiceBusSettings(namespaceName=Namespace Name, sasKeyName=Sas Key Name, sasKey=Sas Key,"
            + " maxMessages=3)",
        actualToStringResult);
    assertEquals(3, actualMaxMessages);
  }
}
