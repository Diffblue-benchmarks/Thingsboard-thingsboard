package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.controller.TwoFactorAuthController.TwoFaProviderInfo;
import org.thingsboard.server.controller.TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder;

class TwoFactorAuthControllerDiffblueTest {
  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and
   * {@link TwoFaProviderInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object), and hashCode(); when other is equal; then return equal")
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}, and
   * {@link TwoFaProviderInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object), and hashCode(); when other is same; then return equal")
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.contact(Mockito.<String>any()))
        .thenReturn(TwoFactorAuthController.TwoFaProviderInfo.builder());
    TwoFactorAuthController.TwoFaProviderInfo buildResult = twoFaProviderInfoBuilder.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(TwoFactorAuthController.TwoFaProviderInfo.builder());
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.contact(Mockito.<String>any())).thenReturn(twoFaProviderInfoBuilder);
    TwoFactorAuthController.TwoFaProviderInfo buildResult = twoFaProviderInfoBuilder2.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(TwoFactorAuthController.TwoFaProviderInfo.builder());
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.contact(Mockito.<String>any())).thenReturn(twoFaProviderInfoBuilder);
    TwoFactorAuthController.TwoFaProviderInfo buildResult = twoFaProviderInfoBuilder2.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(null)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.type(Mockito.<TwoFaProviderType>any()))
        .thenReturn(TwoFactorAuthController.TwoFaProviderInfo.builder());
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.contact(Mockito.<String>any())).thenReturn(twoFaProviderInfoBuilder2);
    TwoFactorAuthController.TwoFaProviderInfo buildResult = twoFaProviderInfoBuilder3.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(null)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    when(twoFaProviderInfoBuilder.build()).thenReturn(buildResult);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.type(Mockito.<TwoFaProviderType>any())).thenReturn(twoFaProviderInfoBuilder);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder4 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder4.contact(Mockito.<String>any())).thenReturn(twoFaProviderInfoBuilder3);
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = twoFaProviderInfoBuilder4.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult3 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(null)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("42")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    when(twoFaProviderInfoBuilder.build()).thenReturn(buildResult);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.type(Mockito.<TwoFaProviderType>any())).thenReturn(twoFaProviderInfoBuilder);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder4 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder4.contact(Mockito.<String>any())).thenReturn(twoFaProviderInfoBuilder3);
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = twoFaProviderInfoBuilder4.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult3 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is different; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("42")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.SMS)
        .build();
    when(twoFaProviderInfoBuilder.build()).thenReturn(buildResult);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.type(Mockito.<TwoFaProviderType>any())).thenReturn(twoFaProviderInfoBuilder);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder twoFaProviderInfoBuilder4 = mock(
        TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder4.contact(Mockito.<String>any())).thenReturn(twoFaProviderInfoBuilder3);
    TwoFactorAuthController.TwoFaProviderInfo buildResult2 = twoFaProviderInfoBuilder4.contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();
    TwoFactorAuthController.TwoFaProviderInfo buildResult3 = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is 'null'; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test TwoFaProviderInfo {@link TwoFaProviderInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthController.TwoFaProviderInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo equals(Object); when other is wrong type; then return not equal")
  void testTwoFaProviderInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TwoFactorAuthController.TwoFaProviderInfo buildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TwoFaProviderInfo");
  }

  /**
   * Test TwoFaProviderInfo getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo#TwoFaProviderInfo(TwoFaProviderType, boolean, String, Integer)}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#setContact(String)}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#setDefault(boolean)}
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo#setMinVerificationCodeSendPeriod(Integer)}
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo#setType(TwoFaProviderType)}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#toString()}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#getContact()}
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo#getMinVerificationCodeSendPeriod()}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#getType()}
   *   <li>{@link TwoFactorAuthController.TwoFaProviderInfo#isDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo getters and setters")
  void testTwoFaProviderInfoGettersAndSetters() {
    // Arrange and Act
    TwoFactorAuthController.TwoFaProviderInfo actualTwoFaProviderInfo = new TwoFactorAuthController.TwoFaProviderInfo(
        TwoFaProviderType.TOTP, true, "Contact", 3);
    actualTwoFaProviderInfo.setContact("Contact");
    actualTwoFaProviderInfo.setDefault(true);
    actualTwoFaProviderInfo.setMinVerificationCodeSendPeriod(3);
    actualTwoFaProviderInfo.setType(TwoFaProviderType.TOTP);
    String actualToStringResult = actualTwoFaProviderInfo.toString();
    String actualContact = actualTwoFaProviderInfo.getContact();
    Integer actualMinVerificationCodeSendPeriod = actualTwoFaProviderInfo.getMinVerificationCodeSendPeriod();
    TwoFaProviderType actualType = actualTwoFaProviderInfo.getType();
    boolean actualIsDefaultResult = actualTwoFaProviderInfo.isDefault();

    // Assert that nothing has changed
    assertEquals("Contact", actualContact);
    assertEquals("TwoFactorAuthController.TwoFaProviderInfo(type=TOTP, isDefault=true, contact=Contact, minVerificatio"
        + "nCodeSendPeriod=3)", actualToStringResult);
    assertEquals(3, actualMinVerificationCodeSendPeriod.intValue());
    assertEquals(TwoFaProviderType.TOTP, actualType);
    assertTrue(actualIsDefaultResult);
  }

  /**
   * Test TwoFaProviderInfo_TwoFaProviderInfoBuilder
   * {@link TwoFaProviderInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder#build()}
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder#contact(String)}
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder#minVerificationCodeSendPeriod(Integer)}
   *   <li>
   * {@link TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder#type(TwoFaProviderType)}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaProviderInfo_TwoFaProviderInfoBuilder build()")
  void testTwoFaProviderInfo_TwoFaProviderInfoBuilderBuild() {
    // Arrange and Act
    TwoFactorAuthController.TwoFaProviderInfo actualBuildResult = TwoFactorAuthController.TwoFaProviderInfo.builder()
        .contact("Contact")
        .minVerificationCodeSendPeriod(3)
        .type(TwoFaProviderType.TOTP)
        .build();

    // Assert
    assertEquals("Contact", actualBuildResult.getContact());
    assertEquals(3, actualBuildResult.getMinVerificationCodeSendPeriod().intValue());
    assertEquals(TwoFaProviderType.TOTP, actualBuildResult.getType());
    assertFalse(actualBuildResult.isDefault());
  }
}
