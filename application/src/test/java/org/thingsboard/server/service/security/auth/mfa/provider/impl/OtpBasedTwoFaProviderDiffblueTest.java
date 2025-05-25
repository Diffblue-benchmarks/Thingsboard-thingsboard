package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.account.EmailTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.OtpBasedTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.SmsTwoFaAccountConfig;
import org.thingsboard.server.service.security.auth.mfa.provider.impl.OtpBasedTwoFaProvider.Otp;

class OtpBasedTwoFaProviderDiffblueTest {
  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Otp#equals(Object)}
   *   <li>{@link Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Otp otp = new Otp(10L, "42", new EmailTwoFaAccountConfig());
    Otp otp2 = new Otp(10L, "42", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertEquals(otp, otp2);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp2.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Otp#equals(Object)}
   *   <li>{@link Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Otp otp = new Otp(10L, null, new EmailTwoFaAccountConfig());
    Otp otp2 = new Otp(10L, null, new EmailTwoFaAccountConfig());

    // Act and Assert
    assertEquals(otp, otp2);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp2.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Otp#equals(Object)}
   *   <li>{@link Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Otp otp = new Otp(10L, "42", null);
    Otp otp2 = new Otp(10L, "42", null);

    // Act and Assert
    assertEquals(otp, otp2);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp2.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Otp#equals(Object)}
   *   <li>{@link Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Otp otp = new Otp(10L, "42", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertEquals(otp, otp);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Otp otp = new Otp(1L, "42", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertNotEquals(otp, new Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Otp otp = new Otp(10L, "Value", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertNotEquals(otp, new Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Otp otp = new Otp(10L, null, new EmailTwoFaAccountConfig());

    // Act and Assert
    assertNotEquals(otp, new Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SmsTwoFaAccountConfig accountConfig = new SmsTwoFaAccountConfig();
    accountConfig.setPhoneNumber("6625550144");
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);
    Otp otp = new Otp(10L, "42", accountConfig);

    // Act and Assert
    assertNotEquals(otp, new Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Otp otp = new Otp(10L, "42", null);

    // Act and Assert
    assertNotEquals(otp, new Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Otp(10L, "42", new EmailTwoFaAccountConfig()), null);
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Otp.equals(Object)", "int Otp.hashCode()"})
  void testOtpEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Otp(10L, "42", new EmailTwoFaAccountConfig()), "Different type to Otp");
  }

  /**
   * Test Otp getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Otp#toString()}
   *   <li>{@link Otp#getAccountConfig()}
   *   <li>{@link Otp#getTimestamp()}
   *   <li>{@link Otp#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtpBasedTwoFaAccountConfig Otp.getAccountConfig()", "long Otp.getTimestamp()",
      "String Otp.getValue()", "String Otp.toString()"})
  void testOtpGettersAndSetters() {
    // Arrange
    EmailTwoFaAccountConfig accountConfig = new EmailTwoFaAccountConfig();
    Otp otp = new Otp(10L, "42", accountConfig);

    // Act
    String actualToStringResult = otp.toString();
    OtpBasedTwoFaAccountConfig actualAccountConfig = otp.getAccountConfig();
    long actualTimestamp = otp.getTimestamp();

    // Assert
    assertEquals("42", otp.getValue());
    assertEquals("OtpBasedTwoFaProvider.Otp(timestamp=10, value=42, accountConfig=EmailTwoFaAccountConfig(email=null))",
        actualToStringResult);
    assertEquals(10L, actualTimestamp);
    assertSame(accountConfig, actualAccountConfig);
  }

  /**
   * Test Otp {@link Otp#Otp(long, String, OtpBasedTwoFaAccountConfig)}.
   * <p>
   * Method under test: {@link Otp#Otp(long, String, OtpBasedTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test Otp new Otp(long, String, OtpBasedTwoFaAccountConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Otp.<init>(long, String, OtpBasedTwoFaAccountConfig)"})
  void testOtpNewOtp() {
    // Arrange
    EmailTwoFaAccountConfig accountConfig = new EmailTwoFaAccountConfig();

    // Act
    Otp actualOtp = new Otp(10L, "42", accountConfig);

    // Assert
    assertEquals("42", actualOtp.getValue());
    assertEquals(10L, actualOtp.getTimestamp());
    assertSame(accountConfig, actualOtp.getAccountConfig());
  }
}
