package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.controller.TwoFactorAuthController.TwoFaProviderInfo;
import org.thingsboard.server.controller.TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.service.security.auth.mfa.TwoFactorAuthService;
import org.thingsboard.server.service.security.auth.mfa.config.TwoFaConfigManager;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.system.SystemSecurityService;

@ContextConfiguration(classes = {TwoFaProviderInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class TwoFactorAuthControllerDiffblueTest {
  @Autowired private TwoFaProviderInfoBuilder twoFaProviderInfoBuilder;

  /**
   * Test {@link TwoFactorAuthController#requestTwoFaVerificationCode(TwoFaProviderType)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthController#requestTwoFaVerificationCode(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test requestTwoFaVerificationCode(TwoFaProviderType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwoFactorAuthController.requestTwoFaVerificationCode(TwoFaProviderType)"
  })
  void testRequestTwoFaVerificationCode() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TwoFactorAuthController twoFactorAuthController =
        new TwoFactorAuthController(
            mock(TwoFactorAuthService.class),
            mock(TwoFaConfigManager.class),
            mock(JwtTokenFactory.class),
            mock(SystemSecurityService.class),
            mock(UserService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> twoFactorAuthController.requestTwoFaVerificationCode(TwoFaProviderType.TOTP));
  }

  /**
   * Test {@link TwoFactorAuthController#checkTwoFaVerificationCode(TwoFaProviderType, String,
   * HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthController#checkTwoFaVerificationCode(TwoFaProviderType, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName("Test checkTwoFaVerificationCode(TwoFaProviderType, String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair TwoFactorAuthController.checkTwoFaVerificationCode(TwoFaProviderType, String, HttpServletRequest)"
  })
  void testCheckTwoFaVerificationCode() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TwoFactorAuthController twoFactorAuthController =
        new TwoFactorAuthController(
            mock(TwoFactorAuthService.class),
            mock(TwoFaConfigManager.class),
            mock(JwtTokenFactory.class),
            mock(SystemSecurityService.class),
            mock(UserService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            twoFactorAuthController.checkTwoFaVerificationCode(
                TwoFaProviderType.TOTP, "Verification Code", new MockHttpServletRequest()));
  }

  /**
   * Test {@link TwoFactorAuthController#getAvailableTwoFaProviders()}.
   *
   * <p>Method under test: {@link TwoFactorAuthController#getAvailableTwoFaProviders()}
   */
  @Test
  @DisplayName("Test getAvailableTwoFaProviders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TwoFactorAuthController.getAvailableTwoFaProviders()"})
  void testGetAvailableTwoFaProviders() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TwoFactorAuthController twoFactorAuthController =
        new TwoFactorAuthController(
            mock(TwoFactorAuthService.class),
            mock(TwoFaConfigManager.class),
            mock(JwtTokenFactory.class),
            mock(SystemSecurityService.class),
            mock(UserService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> twoFactorAuthController.getAvailableTwoFaProviders());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and {@link
   * TwoFaProviderInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo twoFaProviderInfo2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertEquals(twoFaProviderInfo, twoFaProviderInfo2);
    assertEquals(twoFaProviderInfo.hashCode(), twoFaProviderInfo2.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and {@link
   * TwoFaProviderInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact(null)
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo twoFaProviderInfo2 =
        TwoFaProviderInfo.builder()
            .contact(null)
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertEquals(twoFaProviderInfo, twoFaProviderInfo2);
    assertEquals(twoFaProviderInfo.hashCode(), twoFaProviderInfo2.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and {@link
   * TwoFaProviderInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(null)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo twoFaProviderInfo2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(null)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertEquals(twoFaProviderInfo, twoFaProviderInfo2);
    assertEquals(twoFaProviderInfo.hashCode(), twoFaProviderInfo2.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and {@link
   * TwoFaProviderInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(null)
            .build();
    TwoFaProviderInfo twoFaProviderInfo2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(null)
            .build();

    // Act and Assert
    assertEquals(twoFaProviderInfo, twoFaProviderInfo2);
    assertEquals(twoFaProviderInfo.hashCode(), twoFaProviderInfo2.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and {@link
   * TwoFaProviderInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertEquals(twoFaProviderInfo, twoFaProviderInfo);
    int expectedHashCodeResult = twoFaProviderInfo.hashCode();
    assertEquals(expectedHashCodeResult, twoFaProviderInfo.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact(null)
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(
        twoFaProviderInfo,
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("42")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(
        twoFaProviderInfo,
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(1)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(
        twoFaProviderInfo,
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(null)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(
        twoFaProviderInfo,
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(null)
            .build();

    // Act and Assert
    assertNotEquals(
        twoFaProviderInfo,
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TwoFaProviderInfo twoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.SMS)
            .build();

    // Act and Assert
    assertNotEquals(
        twoFaProviderInfo,
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build(),
        null);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaProviderInfo equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build(),
        "Different type to TwoFaProviderInfo");
  }

  /**
   * Test TwoFaProviderInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo#TwoFaProviderInfo(TwoFaProviderType, boolean, String, Integer)}
   *   <li>{@link TwoFaProviderInfo#setContact(String)}
   *   <li>{@link TwoFaProviderInfo#setDefault(boolean)}
   *   <li>{@link TwoFaProviderInfo#setMinVerificationCodeSendPeriod(Integer)}
   *   <li>{@link TwoFaProviderInfo#setType(TwoFaProviderType)}
   *   <li>{@link TwoFaProviderInfo#toString()}
   *   <li>{@link TwoFaProviderInfo#getContact()}
   *   <li>{@link TwoFaProviderInfo#getMinVerificationCodeSendPeriod()}
   *   <li>{@link TwoFaProviderInfo#getType()}
   *   <li>{@link TwoFaProviderInfo#isDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwoFaProviderInfo.<init>(TwoFaProviderType, boolean, String, Integer)",
    "String TwoFaProviderInfo.getContact()",
    "Integer TwoFaProviderInfo.getMinVerificationCodeSendPeriod()",
    "TwoFaProviderType TwoFaProviderInfo.getType()",
    "boolean TwoFaProviderInfo.isDefault()",
    "void TwoFaProviderInfo.setContact(String)",
    "void TwoFaProviderInfo.setDefault(boolean)",
    "void TwoFaProviderInfo.setMinVerificationCodeSendPeriod(Integer)",
    "void TwoFaProviderInfo.setType(TwoFaProviderType)",
    "String TwoFaProviderInfo.toString()"
  })
  void testTwoFaProviderInfoGettersAndSetters() {
    // Arrange and Act
    TwoFaProviderInfo actualTwoFaProviderInfo =
        new TwoFaProviderInfo(TwoFaProviderType.TOTP, true, "Contact", 3);
    actualTwoFaProviderInfo.setContact("Contact");
    actualTwoFaProviderInfo.setDefault(true);
    actualTwoFaProviderInfo.setMinVerificationCodeSendPeriod(3);
    actualTwoFaProviderInfo.setType(TwoFaProviderType.TOTP);
    String actualToStringResult = actualTwoFaProviderInfo.toString();
    String actualContact = actualTwoFaProviderInfo.getContact();
    Integer actualMinVerificationCodeSendPeriod =
        actualTwoFaProviderInfo.getMinVerificationCodeSendPeriod();
    TwoFaProviderType actualType = actualTwoFaProviderInfo.getType();
    boolean actualIsDefaultResult = actualTwoFaProviderInfo.isDefault();

    // Assert
    assertEquals("Contact", actualContact);
    assertEquals(
        "TwoFactorAuthController.TwoFaProviderInfo(type=TOTP, isDefault=true, contact=Contact, minVerificatio"
            + "nCodeSendPeriod=3)",
        actualToStringResult);
    assertEquals(3, actualMinVerificationCodeSendPeriod.intValue());
    assertEquals(TwoFaProviderType.TOTP, actualType);
    assertTrue(actualIsDefaultResult);
  }

  /**
   * Test TwoFaProviderInfo_TwoFaProviderInfoBuilder {@link
   * TwoFaProviderInfo.TwoFaProviderInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaProviderInfo.TwoFaProviderInfoBuilder#build()}
   *   <li>{@link TwoFaProviderInfo.TwoFaProviderInfoBuilder#contact(String)}
   *   <li>{@link TwoFaProviderInfo.TwoFaProviderInfoBuilder#minVerificationCodeSendPeriod(Integer)}
   *   <li>{@link TwoFaProviderInfo.TwoFaProviderInfoBuilder#type(TwoFaProviderType)}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo_TwoFaProviderInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwoFaProviderInfo.TwoFaProviderInfoBuilder.<init>()",
    "TwoFaProviderInfo TwoFaProviderInfo.TwoFaProviderInfoBuilder.build()",
    "TwoFaProviderInfo.TwoFaProviderInfoBuilder TwoFaProviderInfo.TwoFaProviderInfoBuilder.contact(String)",
    "TwoFaProviderInfo.TwoFaProviderInfoBuilder TwoFaProviderInfo.TwoFaProviderInfoBuilder.isDefault(boolean)",
    "TwoFaProviderInfo.TwoFaProviderInfoBuilder TwoFaProviderInfo.TwoFaProviderInfoBuilder.minVerificationCodeSendPeriod(Integer)",
    "String TwoFaProviderInfo.TwoFaProviderInfoBuilder.toString()",
    "TwoFaProviderInfo.TwoFaProviderInfoBuilder TwoFaProviderInfo.TwoFaProviderInfoBuilder.type(TwoFaProviderType)"
  })
  void testTwoFaProviderInfo_TwoFaProviderInfoBuilderBuild() {
    // Arrange and Act
    TwoFaProviderInfo actualTwoFaProviderInfo =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Assert
    assertEquals("Contact", actualTwoFaProviderInfo.getContact());
    assertEquals(3, actualTwoFaProviderInfo.getMinVerificationCodeSendPeriod().intValue());
    assertEquals(TwoFaProviderType.TOTP, actualTwoFaProviderInfo.getType());
    assertFalse(actualTwoFaProviderInfo.isDefault());
  }
}
