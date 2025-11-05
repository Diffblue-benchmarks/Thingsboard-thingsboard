package org.thingsboard.server.common.data.sms.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TwilioSmsProviderConfigurationDiffblueTest {
  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}, and {@link
   * TwilioSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    assertEquals(
        twilioSmsProviderConfiguration.hashCode(), twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}, and {@link
   * TwilioSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid(null);
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid(null);
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    assertEquals(
        twilioSmsProviderConfiguration.hashCode(), twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}, and {@link
   * TwilioSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken(null);
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken(null);
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    assertEquals(
        twilioSmsProviderConfiguration.hashCode(), twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}, and {@link
   * TwilioSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom(null);

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom(null);

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    assertEquals(
        twilioSmsProviderConfiguration.hashCode(), twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}, and {@link
   * TwilioSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration);
    int expectedHashCodeResult = twilioSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, twilioSmsProviderConfiguration.hashCode());
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("ABC123");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid(null);
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("3");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken(null);
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("jane.doe@example.org");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom(null);

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, null);
  }

  /**
   * Test {@link TwilioSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwilioSmsProviderConfiguration.equals(Object)",
    "int TwilioSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(
        twilioSmsProviderConfiguration, "Different type to TwilioSmsProviderConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TwilioSmsProviderConfiguration}
   *   <li>{@link TwilioSmsProviderConfiguration#setAccountSid(String)}
   *   <li>{@link TwilioSmsProviderConfiguration#setAccountToken(String)}
   *   <li>{@link TwilioSmsProviderConfiguration#setNumberFrom(String)}
   *   <li>{@link TwilioSmsProviderConfiguration#toString()}
   *   <li>{@link TwilioSmsProviderConfiguration#getAccountSid()}
   *   <li>{@link TwilioSmsProviderConfiguration#getAccountToken()}
   *   <li>{@link TwilioSmsProviderConfiguration#getNumberFrom()}
   *   <li>{@link TwilioSmsProviderConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwilioSmsProviderConfiguration.<init>()",
    "String TwilioSmsProviderConfiguration.getAccountSid()",
    "String TwilioSmsProviderConfiguration.getAccountToken()",
    "String TwilioSmsProviderConfiguration.getNumberFrom()",
    "SmsProviderType TwilioSmsProviderConfiguration.getType()",
    "void TwilioSmsProviderConfiguration.setAccountSid(String)",
    "void TwilioSmsProviderConfiguration.setAccountToken(String)",
    "void TwilioSmsProviderConfiguration.setNumberFrom(String)",
    "String TwilioSmsProviderConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TwilioSmsProviderConfiguration actualTwilioSmsProviderConfiguration =
        new TwilioSmsProviderConfiguration();
    actualTwilioSmsProviderConfiguration.setAccountSid("3");
    actualTwilioSmsProviderConfiguration.setAccountToken("ABC123");
    actualTwilioSmsProviderConfiguration.setNumberFrom("42");
    String actualToStringResult = actualTwilioSmsProviderConfiguration.toString();
    String actualAccountSid = actualTwilioSmsProviderConfiguration.getAccountSid();
    String actualAccountToken = actualTwilioSmsProviderConfiguration.getAccountToken();
    String actualNumberFrom = actualTwilioSmsProviderConfiguration.getNumberFrom();

    // Assert
    assertEquals("3", actualAccountSid);
    assertEquals("42", actualNumberFrom);
    assertEquals("ABC123", actualAccountToken);
    assertEquals(
        "TwilioSmsProviderConfiguration(accountSid=3, accountToken=ABC123, numberFrom=42)",
        actualToStringResult);
    assertEquals(SmsProviderType.TWILIO, actualTwilioSmsProviderConfiguration.getType());
  }
}
