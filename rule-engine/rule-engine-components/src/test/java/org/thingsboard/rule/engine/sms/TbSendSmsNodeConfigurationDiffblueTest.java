package org.thingsboard.rule.engine.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.NodeConfiguration;
import org.thingsboard.server.common.data.sms.config.SmsProviderConfiguration;

class TbSendSmsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendSmsNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeConfiguration TbSendSmsNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    NodeConfiguration actualDefaultConfigurationResult =
        new TbSendSmsNodeConfiguration().defaultConfiguration();
    Object actualDefaultConfigurationResult2 =
        actualDefaultConfigurationResult.defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult2 instanceof TbSendSmsNodeConfiguration);
    assertTrue(actualDefaultConfigurationResult instanceof TbSendSmsNodeConfiguration);
    assertEquals(
        "${userPhone}",
        ((TbSendSmsNodeConfiguration) actualDefaultConfigurationResult).getNumbersToTemplate());
    assertEquals(
        "Device ${deviceName} has high temperature ${temp}",
        ((TbSendSmsNodeConfiguration) actualDefaultConfigurationResult).getSmsMessageTemplate());
    assertNull(
        ((TbSendSmsNodeConfiguration) actualDefaultConfigurationResult)
            .getSmsProviderConfiguration());
    assertTrue(
        ((TbSendSmsNodeConfiguration) actualDefaultConfigurationResult).isUseSystemSmsSettings());
    assertEquals(actualDefaultConfigurationResult, actualDefaultConfigurationResult2);
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}, and {@link
   * TbSendSmsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendSmsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendSmsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration2 = new TbSendSmsNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration2);
    assertEquals(tbSendSmsNodeConfiguration.hashCode(), tbSendSmsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}, and {@link
   * TbSendSmsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendSmsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendSmsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setNumbersToTemplate("42");

    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration2 = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration2.setNumbersToTemplate("42");

    // Act and Assert
    assertEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration2);
    assertEquals(tbSendSmsNodeConfiguration.hashCode(), tbSendSmsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}, and {@link
   * TbSendSmsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendSmsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendSmsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setSmsMessageTemplate("Sms Message Template");

    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration2 = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration2.setSmsMessageTemplate("Sms Message Template");

    // Act and Assert
    assertEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration2);
    assertEquals(tbSendSmsNodeConfiguration.hashCode(), tbSendSmsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}, and {@link
   * TbSendSmsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendSmsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendSmsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration);
    int expectedHashCodeResult = tbSendSmsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendSmsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendSmsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setNumbersToTemplate("42");

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, new TbSendSmsNodeConfiguration());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setSmsMessageTemplate("Sms Message Template");

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, new TbSendSmsNodeConfiguration());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setUseSystemSmsSettings(true);

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, new TbSendSmsNodeConfiguration());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setSmsProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, new TbSendSmsNodeConfiguration());
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();

    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration2 = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration2.setNumbersToTemplate("42");

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration2);
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();

    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration2 = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration2.setSmsMessageTemplate("Sms Message Template");

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration2);
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();

    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration2 = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration2.setSmsProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(tbSendSmsNodeConfiguration, tbSendSmsNodeConfiguration2);
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendSmsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendSmsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendSmsNodeConfiguration.equals(Object)",
    "int TbSendSmsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbSendSmsNodeConfiguration(), "Different type to TbSendSmsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSendSmsNodeConfiguration}
   *   <li>{@link TbSendSmsNodeConfiguration#setNumbersToTemplate(String)}
   *   <li>{@link TbSendSmsNodeConfiguration#setSmsMessageTemplate(String)}
   *   <li>{@link TbSendSmsNodeConfiguration#setSmsProviderConfiguration(SmsProviderConfiguration)}
   *   <li>{@link TbSendSmsNodeConfiguration#setUseSystemSmsSettings(boolean)}
   *   <li>{@link TbSendSmsNodeConfiguration#toString()}
   *   <li>{@link TbSendSmsNodeConfiguration#getNumbersToTemplate()}
   *   <li>{@link TbSendSmsNodeConfiguration#getSmsMessageTemplate()}
   *   <li>{@link TbSendSmsNodeConfiguration#getSmsProviderConfiguration()}
   *   <li>{@link TbSendSmsNodeConfiguration#isUseSystemSmsSettings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSendSmsNodeConfiguration.<init>()",
    "String TbSendSmsNodeConfiguration.getNumbersToTemplate()",
    "String TbSendSmsNodeConfiguration.getSmsMessageTemplate()",
    "SmsProviderConfiguration TbSendSmsNodeConfiguration.getSmsProviderConfiguration()",
    "boolean TbSendSmsNodeConfiguration.isUseSystemSmsSettings()",
    "void TbSendSmsNodeConfiguration.setNumbersToTemplate(String)",
    "void TbSendSmsNodeConfiguration.setSmsMessageTemplate(String)",
    "void TbSendSmsNodeConfiguration.setSmsProviderConfiguration(SmsProviderConfiguration)",
    "void TbSendSmsNodeConfiguration.setUseSystemSmsSettings(boolean)",
    "String TbSendSmsNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendSmsNodeConfiguration actualTbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    actualTbSendSmsNodeConfiguration.setNumbersToTemplate("42");
    actualTbSendSmsNodeConfiguration.setSmsMessageTemplate("Sms Message Template");
    SmsProviderConfiguration smsProviderConfiguration = mock(SmsProviderConfiguration.class);
    actualTbSendSmsNodeConfiguration.setSmsProviderConfiguration(smsProviderConfiguration);
    actualTbSendSmsNodeConfiguration.setUseSystemSmsSettings(true);
    actualTbSendSmsNodeConfiguration.toString();
    String actualNumbersToTemplate = actualTbSendSmsNodeConfiguration.getNumbersToTemplate();
    String actualSmsMessageTemplate = actualTbSendSmsNodeConfiguration.getSmsMessageTemplate();
    SmsProviderConfiguration actualSmsProviderConfiguration =
        actualTbSendSmsNodeConfiguration.getSmsProviderConfiguration();

    // Assert
    assertEquals("42", actualNumbersToTemplate);
    assertEquals("Sms Message Template", actualSmsMessageTemplate);
    assertTrue(actualTbSendSmsNodeConfiguration.isUseSystemSmsSettings());
    assertSame(smsProviderConfiguration, actualSmsProviderConfiguration);
  }
}
