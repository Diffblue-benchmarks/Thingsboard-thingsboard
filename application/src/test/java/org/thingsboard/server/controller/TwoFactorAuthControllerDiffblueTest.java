package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.controller.TwoFactorAuthController.TwoFaProviderInfo;
import org.thingsboard.server.controller.TwoFactorAuthController.TwoFaProviderInfo.TwoFaProviderInfoBuilder;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ContextConfiguration(classes = {TwoFaProviderInfoBuilder.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class TwoFactorAuthControllerDiffblueTest {
  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @Autowired private TwoFaProviderInfoBuilder twoFaProviderInfoBuilder;

  @InjectMocks private TwoFactorAuthController twoFactorAuthController;

  /**
   * Test {@link TwoFactorAuthController#requestTwoFaVerificationCode(TwoFaProviderType)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthController#requestTwoFaVerificationCode(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test requestTwoFaVerificationCode(TwoFaProviderType); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TwoFactorAuthController.requestTwoFaVerificationCode(TwoFaProviderType)"
  })
  void testRequestTwoFaVerificationCode_whenEmptyString() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/auth/2fa/verification/send").param("providerType", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthController#requestTwoFaVerificationCode(TwoFaProviderType)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthController#requestTwoFaVerificationCode(TwoFaProviderType)}
   */
  @Test
  @DisplayName(
      "Test requestTwoFaVerificationCode(TwoFaProviderType); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TwoFactorAuthController.requestTwoFaVerificationCode(TwoFaProviderType)"
  })
  void testRequestTwoFaVerificationCode_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/auth/2fa/verification/send")
            .param("providerType", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthController#checkTwoFaVerificationCode(TwoFaProviderType, String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthController#checkTwoFaVerificationCode(TwoFaProviderType, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test checkTwoFaVerificationCode(TwoFaProviderType, String, HttpServletRequest); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair TwoFactorAuthController.checkTwoFaVerificationCode(TwoFaProviderType, String, HttpServletRequest)"
  })
  void testCheckTwoFaVerificationCode_whenEmptyString() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/auth/2fa/verification/check")
            .param("providerType", "")
            .param("verificationCode", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthController#checkTwoFaVerificationCode(TwoFaProviderType, String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthController#checkTwoFaVerificationCode(TwoFaProviderType, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test checkTwoFaVerificationCode(TwoFaProviderType, String, HttpServletRequest); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair TwoFactorAuthController.checkTwoFaVerificationCode(TwoFaProviderType, String, HttpServletRequest)"
  })
  void testCheckTwoFaVerificationCode_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/auth/2fa/verification/check")
            .param("providerType", "https://example.org/example")
            .param("verificationCode", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult2 =
        TwoFaProviderInfo.builder()
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.contact(Mockito.<String>any()))
        .thenReturn(TwoFaProviderInfo.builder());
    TwoFaProviderInfo buildResult =
        twoFaProviderInfoBuilder
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(TwoFaProviderInfo.builder());
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.contact(Mockito.<String>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFaProviderInfo buildResult =
        twoFaProviderInfoBuilder2
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(TwoFaProviderInfo.builder());
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.contact(Mockito.<String>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFaProviderInfo buildResult =
        twoFaProviderInfoBuilder2
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(null)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder.type(Mockito.<TwoFaProviderType>any()))
        .thenReturn(TwoFaProviderInfo.builder());
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.contact(Mockito.<String>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFaProviderInfo buildResult =
        twoFaProviderInfoBuilder3
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult2 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(null)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    when(twoFaProviderInfoBuilder.build()).thenReturn(buildResult);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.type(Mockito.<TwoFaProviderType>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder4 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder4.contact(Mockito.<String>any()))
        .thenReturn(twoFaProviderInfoBuilder3);
    TwoFaProviderInfo buildResult2 =
        twoFaProviderInfoBuilder4
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult3 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(null)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
            .contact("42")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    when(twoFaProviderInfoBuilder.build()).thenReturn(buildResult);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.type(Mockito.<TwoFaProviderType>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder4 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder4.contact(Mockito.<String>any()))
        .thenReturn(twoFaProviderInfoBuilder3);
    TwoFaProviderInfo buildResult2 =
        twoFaProviderInfoBuilder4
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult3 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder = mock(TwoFaProviderInfoBuilder.class);
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
            .contact("42")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.SMS)
            .build();
    when(twoFaProviderInfoBuilder.build()).thenReturn(buildResult);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder2 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder2.type(Mockito.<TwoFaProviderType>any()))
        .thenReturn(twoFaProviderInfoBuilder);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder3 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder3.minVerificationCodeSendPeriod(Mockito.<Integer>any()))
        .thenReturn(twoFaProviderInfoBuilder2);
    TwoFaProviderInfoBuilder twoFaProviderInfoBuilder4 = mock(TwoFaProviderInfoBuilder.class);
    when(twoFaProviderInfoBuilder4.contact(Mockito.<String>any()))
        .thenReturn(twoFaProviderInfoBuilder3);
    TwoFaProviderInfo buildResult2 =
        twoFaProviderInfoBuilder4
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();
    TwoFaProviderInfo buildResult3 =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaProviderInfo.equals(Object)",
    "int TwoFaProviderInfo.hashCode()"
  })
  void testTwoFaProviderInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TwoFaProviderInfo buildResult =
        TwoFaProviderInfo.builder()
            .contact("Contact")
            .minVerificationCodeSendPeriod(3)
            .type(TwoFaProviderType.TOTP)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TwoFaProviderInfo");
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
    TwoFaProviderInfo actualBuildResult =
        TwoFaProviderInfo.builder()
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
