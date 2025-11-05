package org.thingsboard.server.common.data.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;

class OAuth2ClientRegistrationTemplateDiffblueTest {
  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}, and {@link
   * OAuth2ClientRegistrationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplate#equals(Object)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();

    // Act and Assert
    assertEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
    assertEquals(
        oAuth2ClientRegistrationTemplate.hashCode(), oAuth2ClientRegistrationTemplate2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}, and {@link
   * OAuth2ClientRegistrationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplate#equals(Object)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    // Act and Assert
    assertEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate);
    int expectedHashCodeResult = oAuth2ClientRegistrationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientRegistrationTemplate.hashCode());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setProviderId("42");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("jane.doe@example.org")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    oAuth2ClientRegistrationTemplate.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setAuthorizationUri("JaneDoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setAccessTokenUri("ABC123");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setScope(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setUserInfoUri("User Info Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setUserNameAttributeName("janedoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setJwkSetUri("Jwk Set Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setClientAuthenticationMethod("Client Authentication Method");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setComment("Comment");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setLoginButtonIcon("Login Button Icon");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setLoginButtonLabel("Login Button Label");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setHelpLink("Help Link");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setProviderId("42");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();

    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("jane.doe@example.org")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    oAuth2ClientRegistrationTemplate2.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setAuthorizationUri("JaneDoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setAccessTokenUri("ABC123");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setScope(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setUserInfoUri("User Info Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setUserNameAttributeName("janedoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setJwkSetUri("Jwk Set Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setClientAuthenticationMethod("Client Authentication Method");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setComment("Comment");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setLoginButtonIcon("Login Button Icon");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setLoginButtonLabel("Login Button Label");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setHelpLink("Help Link");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientRegistrationTemplate(), null);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplate.equals(Object)",
    "int OAuth2ClientRegistrationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new OAuth2ClientRegistrationTemplate(),
        "Different type to OAuth2ClientRegistrationTemplate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setAccessTokenUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setAuthorizationUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setClientAuthenticationMethod(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setComment(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setHelpLink(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setJwkSetUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setLoginButtonIcon(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setLoginButtonLabel(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setMapperConfig(OAuth2MapperConfig)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setProviderId(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setScope(List)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setUserInfoUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setUserNameAttributeName(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#toString()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getAccessTokenUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getAuthorizationUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getClientAuthenticationMethod()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getComment()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getHelpLink()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getJwkSetUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getLoginButtonIcon()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getLoginButtonLabel()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getMapperConfig()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getName()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getProviderId()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getScope()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getUserInfoUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#getUserNameAttributeName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplate.<init>()",
    "String OAuth2ClientRegistrationTemplate.getAccessTokenUri()",
    "String OAuth2ClientRegistrationTemplate.getAuthorizationUri()",
    "String OAuth2ClientRegistrationTemplate.getClientAuthenticationMethod()",
    "String OAuth2ClientRegistrationTemplate.getComment()",
    "String OAuth2ClientRegistrationTemplate.getHelpLink()",
    "String OAuth2ClientRegistrationTemplate.getJwkSetUri()",
    "String OAuth2ClientRegistrationTemplate.getLoginButtonIcon()",
    "String OAuth2ClientRegistrationTemplate.getLoginButtonLabel()",
    "OAuth2MapperConfig OAuth2ClientRegistrationTemplate.getMapperConfig()",
    "String OAuth2ClientRegistrationTemplate.getName()",
    "String OAuth2ClientRegistrationTemplate.getProviderId()",
    "List OAuth2ClientRegistrationTemplate.getScope()",
    "String OAuth2ClientRegistrationTemplate.getUserInfoUri()",
    "String OAuth2ClientRegistrationTemplate.getUserNameAttributeName()",
    "void OAuth2ClientRegistrationTemplate.setAccessTokenUri(String)",
    "void OAuth2ClientRegistrationTemplate.setAuthorizationUri(String)",
    "void OAuth2ClientRegistrationTemplate.setClientAuthenticationMethod(String)",
    "void OAuth2ClientRegistrationTemplate.setComment(String)",
    "void OAuth2ClientRegistrationTemplate.setHelpLink(String)",
    "void OAuth2ClientRegistrationTemplate.setJwkSetUri(String)",
    "void OAuth2ClientRegistrationTemplate.setLoginButtonIcon(String)",
    "void OAuth2ClientRegistrationTemplate.setLoginButtonLabel(String)",
    "void OAuth2ClientRegistrationTemplate.setMapperConfig(OAuth2MapperConfig)",
    "void OAuth2ClientRegistrationTemplate.setProviderId(String)",
    "void OAuth2ClientRegistrationTemplate.setScope(List)",
    "void OAuth2ClientRegistrationTemplate.setUserInfoUri(String)",
    "void OAuth2ClientRegistrationTemplate.setUserNameAttributeName(String)",
    "String OAuth2ClientRegistrationTemplate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    actualOAuth2ClientRegistrationTemplate.setAccessTokenUri("ABC123");
    actualOAuth2ClientRegistrationTemplate.setAuthorizationUri("JaneDoe");
    actualOAuth2ClientRegistrationTemplate.setClientAuthenticationMethod(
        "Client Authentication Method");
    actualOAuth2ClientRegistrationTemplate.setComment("Comment");
    actualOAuth2ClientRegistrationTemplate.setHelpLink("Help Link");
    actualOAuth2ClientRegistrationTemplate.setJwkSetUri("Jwk Set Uri");
    actualOAuth2ClientRegistrationTemplate.setLoginButtonIcon("Login Button Icon");
    actualOAuth2ClientRegistrationTemplate.setLoginButtonLabel("Login Button Label");
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);
    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("jane.doe@example.org")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    OAuth2MapperConfig mapperConfig =
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build();
    actualOAuth2ClientRegistrationTemplate.setMapperConfig(mapperConfig);
    actualOAuth2ClientRegistrationTemplate.setProviderId("42");
    ArrayList<String> scope = new ArrayList<>();
    actualOAuth2ClientRegistrationTemplate.setScope(scope);
    actualOAuth2ClientRegistrationTemplate.setUserInfoUri("User Info Uri");
    actualOAuth2ClientRegistrationTemplate.setUserNameAttributeName("janedoe");
    String actualToStringResult = actualOAuth2ClientRegistrationTemplate.toString();
    String actualAccessTokenUri = actualOAuth2ClientRegistrationTemplate.getAccessTokenUri();
    String actualAuthorizationUri = actualOAuth2ClientRegistrationTemplate.getAuthorizationUri();
    String actualClientAuthenticationMethod =
        actualOAuth2ClientRegistrationTemplate.getClientAuthenticationMethod();
    String actualComment = actualOAuth2ClientRegistrationTemplate.getComment();
    String actualHelpLink = actualOAuth2ClientRegistrationTemplate.getHelpLink();
    String actualJwkSetUri = actualOAuth2ClientRegistrationTemplate.getJwkSetUri();
    String actualLoginButtonIcon = actualOAuth2ClientRegistrationTemplate.getLoginButtonIcon();
    String actualLoginButtonLabel = actualOAuth2ClientRegistrationTemplate.getLoginButtonLabel();
    OAuth2MapperConfig actualMapperConfig =
        actualOAuth2ClientRegistrationTemplate.getMapperConfig();
    String actualName = actualOAuth2ClientRegistrationTemplate.getName();
    String actualProviderId = actualOAuth2ClientRegistrationTemplate.getProviderId();
    List<String> actualScope = actualOAuth2ClientRegistrationTemplate.getScope();
    String actualUserInfoUri = actualOAuth2ClientRegistrationTemplate.getUserInfoUri();

    // Assert
    assertEquals("42", actualName);
    assertEquals("42", actualProviderId);
    assertEquals("ABC123", actualAccessTokenUri);
    assertEquals("Client Authentication Method", actualClientAuthenticationMethod);
    assertEquals("Comment", actualComment);
    assertEquals("Help Link", actualHelpLink);
    assertEquals("JaneDoe", actualAuthorizationUri);
    assertEquals("Jwk Set Uri", actualJwkSetUri);
    assertEquals("Login Button Icon", actualLoginButtonIcon);
    assertEquals("Login Button Label", actualLoginButtonLabel);
    assertEquals(
        "OAuth2ClientRegistrationTemplate(providerId=42, mapperConfig=OAuth2MapperConfig(allowUserCreation=true,"
            + " activateUser=true, type=BASIC, basic=OAuth2BasicMapperConfig(emailAttributeKey=jane.doe@example.org,"
            + " firstNameAttributeKey=Jane, lastNameAttributeKey=Doe, tenantNameStrategy=DOMAIN, tenantNamePattern=Tenant"
            + " Name Pattern, customerNamePattern=Customer Name Pattern, defaultDashboardName=Default Dashboard Name,"
            + " alwaysFullScreen=true), custom=OAuth2CustomMapperConfig(url=https://example.org/example, username=janedoe,"
            + " sendToken=true)), authorizationUri=JaneDoe, accessTokenUri=ABC123, scope=[], userInfoUri=User Info"
            + " Uri, userNameAttributeName=janedoe, jwkSetUri=Jwk Set Uri, clientAuthenticationMethod=Client"
            + " Authentication Method, comment=Comment, loginButtonIcon=Login Button Icon, loginButtonLabel=Login"
            + " Button Label, helpLink=Help Link)",
        actualToStringResult);
    assertEquals("User Info Uri", actualUserInfoUri);
    assertEquals("janedoe", actualOAuth2ClientRegistrationTemplate.getUserNameAttributeName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getId());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
    assertTrue(actualScope.isEmpty());
    assertSame(scope, actualScope);
    assertSame(mapperConfig, actualMapperConfig);
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplate.<init>(OAuth2ClientRegistrationTemplate)"
  })
  void testNewOAuth2ClientRegistrationTemplate() {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(
            new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate()));

    // Assert
    assertTrue(actualOAuth2ClientRegistrationTemplate.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOAuth2ClientRegistrationTemplate.getAccessTokenUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getAuthorizationUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getClientAuthenticationMethod());
    assertNull(actualOAuth2ClientRegistrationTemplate.getComment());
    assertNull(actualOAuth2ClientRegistrationTemplate.getHelpLink());
    assertNull(actualOAuth2ClientRegistrationTemplate.getJwkSetUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getLoginButtonIcon());
    assertNull(actualOAuth2ClientRegistrationTemplate.getLoginButtonLabel());
    assertNull(actualOAuth2ClientRegistrationTemplate.getName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getProviderId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUserInfoUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUserNameAttributeName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getScope());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUuidId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getMapperConfig());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplate.<init>(OAuth2ClientRegistrationTemplate)"
  })
  void testNewOAuth2ClientRegistrationTemplate2() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(
            new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate()));

    // Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(clientRegistrationTemplate);

    // Assert
    assertTrue(actualOAuth2ClientRegistrationTemplate.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOAuth2ClientRegistrationTemplate.getAccessTokenUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getAuthorizationUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getClientAuthenticationMethod());
    assertNull(actualOAuth2ClientRegistrationTemplate.getComment());
    assertNull(actualOAuth2ClientRegistrationTemplate.getHelpLink());
    assertNull(actualOAuth2ClientRegistrationTemplate.getJwkSetUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getLoginButtonIcon());
    assertNull(actualOAuth2ClientRegistrationTemplate.getLoginButtonLabel());
    assertNull(actualOAuth2ClientRegistrationTemplate.getName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getProviderId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUserInfoUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUserNameAttributeName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getScope());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUuidId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getMapperConfig());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>When {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate); when OAuth2ClientRegistrationTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplate.<init>(OAuth2ClientRegistrationTemplate)"
  })
  void testNewOAuth2ClientRegistrationTemplate_whenOAuth2ClientRegistrationTemplate() {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());

    // Assert
    assertTrue(actualOAuth2ClientRegistrationTemplate.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOAuth2ClientRegistrationTemplate.getAccessTokenUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getAuthorizationUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getClientAuthenticationMethod());
    assertNull(actualOAuth2ClientRegistrationTemplate.getComment());
    assertNull(actualOAuth2ClientRegistrationTemplate.getHelpLink());
    assertNull(actualOAuth2ClientRegistrationTemplate.getJwkSetUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getLoginButtonIcon());
    assertNull(actualOAuth2ClientRegistrationTemplate.getLoginButtonLabel());
    assertNull(actualOAuth2ClientRegistrationTemplate.getName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getProviderId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUserInfoUri());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUserNameAttributeName());
    assertNull(actualOAuth2ClientRegistrationTemplate.getScope());
    assertNull(actualOAuth2ClientRegistrationTemplate.getUuidId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getId());
    assertNull(actualOAuth2ClientRegistrationTemplate.getMapperConfig());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
  }
}
