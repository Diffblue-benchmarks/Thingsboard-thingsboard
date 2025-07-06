package org.thingsboard.rule.engine.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgToEmailNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgToEmailNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsgToEmailNodeConfiguration TbMsgToEmailNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgToEmailNodeConfiguration actualDefaultConfigurationResult =
        new TbMsgToEmailNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("${userEmail}", actualDefaultConfigurationResult.getToTemplate());
    assertEquals(
        "Device ${deviceName} has high temperature $[temperature]",
        actualDefaultConfigurationResult.getBodyTemplate());
    assertEquals(
        "Device ${deviceType} temperature high",
        actualDefaultConfigurationResult.getSubjectTemplate());
    assertEquals("info@testmail.org", actualDefaultConfigurationResult.getFromTemplate());
    assertNull(actualDefaultConfigurationResult.getBccTemplate());
    assertNull(actualDefaultConfigurationResult.getCcTemplate());
    assertNull(actualDefaultConfigurationResult.getIsHtmlTemplate());
    String expectedMailBodyType = Boolean.FALSE.toString();
    assertEquals(expectedMailBodyType, actualDefaultConfigurationResult.getMailBodyType());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setFromTemplate("jane.doe@example.org");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setFromTemplate("jane.doe@example.org");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setToTemplate("To Template");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setToTemplate("To Template");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setCcTemplate("Cc Template");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setCcTemplate("Cc Template");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setBccTemplate("mary.somerville@example.org");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setBccTemplate("mary.somerville@example.org");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setSubjectTemplate("Hello from the Dreaming Spires");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setSubjectTemplate("Hello from the Dreaming Spires");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setBodyTemplate("Not all who wander are lost");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setBodyTemplate("Not all who wander are lost");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setIsHtmlTemplate("Is Html Template");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setIsHtmlTemplate("Is Html Template");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setMailBodyType("Not all who wander are lost");

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setMailBodyType("Not all who wander are lost");

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}, and {@link
   * TbMsgToEmailNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgToEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration);
    int expectedHashCodeResult = tbMsgToEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgToEmailNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgToEmailNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setFromTemplate("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setToTemplate("To Template");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setCcTemplate("Cc Template");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setBccTemplate("mary.somerville@example.org");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setSubjectTemplate("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setBodyTemplate("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setIsHtmlTemplate("Is Html Template");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration.setMailBodyType("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, new TbMsgToEmailNodeConfiguration());
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setFromTemplate("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setToTemplate("To Template");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setCcTemplate("Cc Template");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setBccTemplate("mary.somerville@example.org");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setSubjectTemplate("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setBodyTemplate("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setIsHtmlTemplate("Is Html Template");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();

    TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration2 =
        new TbMsgToEmailNodeConfiguration();
    tbMsgToEmailNodeConfiguration2.setMailBodyType("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(tbMsgToEmailNodeConfiguration, tbMsgToEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgToEmailNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgToEmailNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgToEmailNodeConfiguration.equals(Object)",
    "int TbMsgToEmailNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMsgToEmailNodeConfiguration(), "Different type to TbMsgToEmailNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgToEmailNodeConfiguration}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setBccTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setBodyTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setCcTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setFromTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setIsHtmlTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setMailBodyType(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setSubjectTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#setToTemplate(String)}
   *   <li>{@link TbMsgToEmailNodeConfiguration#toString()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getBccTemplate()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getBodyTemplate()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getCcTemplate()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getFromTemplate()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getIsHtmlTemplate()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getMailBodyType()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getSubjectTemplate()}
   *   <li>{@link TbMsgToEmailNodeConfiguration#getToTemplate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMsgToEmailNodeConfiguration.<init>()",
    "String TbMsgToEmailNodeConfiguration.getBccTemplate()",
    "String TbMsgToEmailNodeConfiguration.getBodyTemplate()",
    "String TbMsgToEmailNodeConfiguration.getCcTemplate()",
    "String TbMsgToEmailNodeConfiguration.getFromTemplate()",
    "String TbMsgToEmailNodeConfiguration.getIsHtmlTemplate()",
    "String TbMsgToEmailNodeConfiguration.getMailBodyType()",
    "String TbMsgToEmailNodeConfiguration.getSubjectTemplate()",
    "String TbMsgToEmailNodeConfiguration.getToTemplate()",
    "void TbMsgToEmailNodeConfiguration.setBccTemplate(String)",
    "void TbMsgToEmailNodeConfiguration.setBodyTemplate(String)",
    "void TbMsgToEmailNodeConfiguration.setCcTemplate(String)",
    "void TbMsgToEmailNodeConfiguration.setFromTemplate(String)",
    "void TbMsgToEmailNodeConfiguration.setIsHtmlTemplate(String)",
    "void TbMsgToEmailNodeConfiguration.setMailBodyType(String)",
    "void TbMsgToEmailNodeConfiguration.setSubjectTemplate(String)",
    "void TbMsgToEmailNodeConfiguration.setToTemplate(String)",
    "String TbMsgToEmailNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgToEmailNodeConfiguration actualTbMsgToEmailNodeConfiguration =
        new TbMsgToEmailNodeConfiguration();
    actualTbMsgToEmailNodeConfiguration.setBccTemplate("mary.somerville@example.org");
    actualTbMsgToEmailNodeConfiguration.setBodyTemplate("Not all who wander are lost");
    actualTbMsgToEmailNodeConfiguration.setCcTemplate("Cc Template");
    actualTbMsgToEmailNodeConfiguration.setFromTemplate("jane.doe@example.org");
    actualTbMsgToEmailNodeConfiguration.setIsHtmlTemplate("Is Html Template");
    actualTbMsgToEmailNodeConfiguration.setMailBodyType("Not all who wander are lost");
    actualTbMsgToEmailNodeConfiguration.setSubjectTemplate("Hello from the Dreaming Spires");
    actualTbMsgToEmailNodeConfiguration.setToTemplate("To Template");
    String actualToStringResult = actualTbMsgToEmailNodeConfiguration.toString();
    String actualBccTemplate = actualTbMsgToEmailNodeConfiguration.getBccTemplate();
    String actualBodyTemplate = actualTbMsgToEmailNodeConfiguration.getBodyTemplate();
    String actualCcTemplate = actualTbMsgToEmailNodeConfiguration.getCcTemplate();
    String actualFromTemplate = actualTbMsgToEmailNodeConfiguration.getFromTemplate();
    String actualIsHtmlTemplate = actualTbMsgToEmailNodeConfiguration.getIsHtmlTemplate();
    String actualMailBodyType = actualTbMsgToEmailNodeConfiguration.getMailBodyType();
    String actualSubjectTemplate = actualTbMsgToEmailNodeConfiguration.getSubjectTemplate();

    // Assert
    assertEquals("Cc Template", actualCcTemplate);
    assertEquals("Hello from the Dreaming Spires", actualSubjectTemplate);
    assertEquals("Is Html Template", actualIsHtmlTemplate);
    assertEquals("Not all who wander are lost", actualBodyTemplate);
    assertEquals("Not all who wander are lost", actualMailBodyType);
    assertEquals(
        "TbMsgToEmailNodeConfiguration(fromTemplate=jane.doe@example.org, toTemplate=To Template, ccTemplate=Cc"
            + " Template, bccTemplate=mary.somerville@example.org, subjectTemplate=Hello from the Dreaming Spires,"
            + " bodyTemplate=Not all who wander are lost, isHtmlTemplate=Is Html Template, mailBodyType=Not all who"
            + " wander are lost)",
        actualToStringResult);
    assertEquals("To Template", actualTbMsgToEmailNodeConfiguration.getToTemplate());
    assertEquals("jane.doe@example.org", actualFromTemplate);
    assertEquals("mary.somerville@example.org", actualBccTemplate);
  }
}
