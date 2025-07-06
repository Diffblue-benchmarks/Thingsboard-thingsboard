package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.controller.TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TwoFactorAuthConfigControllerDiffblueTest {
  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @InjectMocks private TwoFactorAuthConfigController twoFactorAuthConfigController;

  /**
   * Test {@link TwoFactorAuthConfigController#generateTwoFaAccountConfig(TwoFaProviderType)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#generateTwoFaAccountConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateTwoFaAccountConfig(TwoFaProviderType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TwoFaAccountConfig TwoFactorAuthConfigController.generateTwoFaAccountConfig(TwoFaProviderType)"
  })
  void testGenerateTwoFaAccountConfig() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/2fa/account/config/generate")
            .param("providerType", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test submitTwoFaAccountConfig(TwoFaAccountConfig); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TwoFactorAuthConfigController.submitTwoFaAccountConfig(TwoFaAccountConfig)"
  })
  void testSubmitTwoFaAccountConfig_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config/submit")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}
   */
  @Test
  @DisplayName(
      "Test submitTwoFaAccountConfig(TwoFaAccountConfig); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TwoFactorAuthConfigController.submitTwoFaAccountConfig(TwoFaAccountConfig)"
  })
  void testSubmitTwoFaAccountConfig_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config/submit");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}.
   *
   * <ul>
   *   <li>When {@code Uri Variables}.
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}
   */
  @Test
  @DisplayName(
      "Test submitTwoFaAccountConfig(TwoFaAccountConfig); when 'Uri Variables'; then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TwoFactorAuthConfigController.submitTwoFaAccountConfig(TwoFaAccountConfig)"
  })
  void testSubmitTwoFaAccountConfig_whenUriVariables_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config/submit", "Uri Variables")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)},
   * and {@link TwoFaAccountConfigUpdateRequest#hashCode()}.
   *
   * <ul>
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaAccountConfigUpdateRequest equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest);
    int expectedHashCodeResult = twoFaAccountConfigUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, twoFaAccountConfigUpdateRequest.hashCode());
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)},
   * and {@link TwoFaAccountConfigUpdateRequest#hashCode()}.
   *
   * <ul>
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaAccountConfigUpdateRequest equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest2 =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest2.setUseByDefault(true);

    // Act and Assert
    assertEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest2);
    int expectedHashCodeResult = twoFaAccountConfigUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, twoFaAccountConfigUpdateRequest2.hashCode());
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEquals_thenReturnNotEqual() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(
        twoFaAccountConfigUpdateRequest, "Different type to TwoFaAccountConfigUpdateRequest");
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEquals_thenReturnNotEqual2() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(false);

    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest2 =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest2);
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaAccountConfigUpdateRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, null);
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TwoFaAccountConfigUpdateRequest}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#setUseByDefault(boolean)}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#toString()}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#isUseByDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TwoFaAccountConfigUpdateRequest.<init>()",
    "boolean TwoFaAccountConfigUpdateRequest.isUseByDefault()",
    "void TwoFaAccountConfigUpdateRequest.setUseByDefault(boolean)",
    "String TwoFaAccountConfigUpdateRequest.toString()"
  })
  void testTwoFaAccountConfigUpdateRequestGettersAndSetters() {
    // Arrange and Act
    TwoFaAccountConfigUpdateRequest actualTwoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    actualTwoFaAccountConfigUpdateRequest.setUseByDefault(true);
    String actualToStringResult = actualTwoFaAccountConfigUpdateRequest.toString();

    // Assert
    assertEquals(
        "TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest(useByDefault=true)",
        actualToStringResult);
    assertTrue(actualTwoFaAccountConfigUpdateRequest.isUseByDefault());
  }

  /**
   * Test {@link TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig,
   * String)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)"
  })
  void testVerifyAndSaveTwoFaAccountConfig_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig,
   * String)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)"
  })
  void testVerifyAndSaveTwoFaAccountConfig_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#updateTwoFaAccountConfig(TwoFaProviderType,
   * TwoFaAccountConfigUpdateRequest)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#updateTwoFaAccountConfig(TwoFaProviderType,
   * TwoFaAccountConfigUpdateRequest)}
   */
  @Test
  @DisplayName("Test updateTwoFaAccountConfig(TwoFaProviderType, TwoFaAccountConfigUpdateRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.updateTwoFaAccountConfig(TwoFaProviderType, TwoFaAccountConfigUpdateRequest)"
  })
  void testUpdateTwoFaAccountConfig() throws Exception {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);
    String content = new ObjectMapper().writeValueAsString(twoFaAccountConfigUpdateRequest);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/api/2fa/account/config")
            .param("providerType", "https://example.org/example")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#deleteTwoFaAccountConfig(TwoFaProviderType)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#deleteTwoFaAccountConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TwoFaProviderType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.deleteTwoFaAccountConfig(TwoFaProviderType)"
  })
  void testDeleteTwoFaAccountConfig() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/2fa/account/config")
            .param("providerType", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
