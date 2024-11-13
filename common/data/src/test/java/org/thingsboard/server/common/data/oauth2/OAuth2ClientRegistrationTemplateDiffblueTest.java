package org.thingsboard.server.common.data.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OAuth2ClientRegistrationTemplateDiffblueTest {
  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}, and
   * {@link OAuth2ClientRegistrationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplate#equals(Object)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();

    // Act and Assert
    assertEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
    int expectedHashCodeResult = oAuth2ClientRegistrationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientRegistrationTemplate2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}, and
   * {@link OAuth2ClientRegistrationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplate#equals(Object)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    // Act and Assert
    assertEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate);
    int expectedHashCodeResult = oAuth2ClientRegistrationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientRegistrationTemplate.hashCode());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate(
        new OAuth2ClientRegistrationTemplate());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientRegistrationTemplate(), mock(OAuth2Client.class));
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setProviderId("42");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    oAuth2ClientRegistrationTemplate.setMapperConfig(mapperConfig);

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setAuthorizationUri("JaneDoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setAccessTokenUri("ABC123");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setScope(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setUserInfoUri("User Info Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setUserNameAttributeName("janedoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setJwkSetUri("Jwk Set Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setClientAuthenticationMethod("Client Authentication Method");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setComment("Comment");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setLoginButtonIcon("Login Button Icon");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setLoginButtonLabel("Login Button Label");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setHelpLink("Help Link");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, new OAuth2ClientRegistrationTemplate());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setProviderId("42");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    oAuth2ClientRegistrationTemplate2.setMapperConfig(mapperConfig);

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setAuthorizationUri("JaneDoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setAccessTokenUri("ABC123");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setScope(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setUserInfoUri("User Info Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setUserNameAttributeName("janedoe");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setJwkSetUri("Jwk Set Uri");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setClientAuthenticationMethod("Client Authentication Method");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setComment("Comment");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setLoginButtonIcon("Login Button Icon");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setLoginButtonLabel("Login Button Label");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate2 = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate2.setHelpLink("Help Link");

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplate, oAuth2ClientRegistrationTemplate2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientRegistrationTemplate(), null);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientRegistrationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientRegistrationTemplate(), "Different type to OAuth2ClientRegistrationTemplate");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setAccessTokenUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setAuthorizationUri(String)}
   *   <li>
   * {@link OAuth2ClientRegistrationTemplate#setClientAuthenticationMethod(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setComment(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setHelpLink(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setJwkSetUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setLoginButtonIcon(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplate#setLoginButtonLabel(String)}
   *   <li>
   * {@link OAuth2ClientRegistrationTemplate#setMapperConfig(OAuth2MapperConfig)}
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
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    actualOAuth2ClientRegistrationTemplate.setAccessTokenUri("ABC123");
    actualOAuth2ClientRegistrationTemplate.setAuthorizationUri("JaneDoe");
    actualOAuth2ClientRegistrationTemplate.setClientAuthenticationMethod("Client Authentication Method");
    actualOAuth2ClientRegistrationTemplate.setComment("Comment");
    actualOAuth2ClientRegistrationTemplate.setHelpLink("Help Link");
    actualOAuth2ClientRegistrationTemplate.setJwkSetUri("Jwk Set Uri");
    actualOAuth2ClientRegistrationTemplate.setLoginButtonIcon("Login Button Icon");
    actualOAuth2ClientRegistrationTemplate.setLoginButtonLabel("Login Button Label");
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    actualOAuth2ClientRegistrationTemplate.setMapperConfig(mapperConfig);
    actualOAuth2ClientRegistrationTemplate.setProviderId("42");
    ArrayList<String> scope = new ArrayList<>();
    actualOAuth2ClientRegistrationTemplate.setScope(scope);
    actualOAuth2ClientRegistrationTemplate.setUserInfoUri("User Info Uri");
    actualOAuth2ClientRegistrationTemplate.setUserNameAttributeName("janedoe");
    String actualToStringResult = actualOAuth2ClientRegistrationTemplate.toString();
    String actualAccessTokenUri = actualOAuth2ClientRegistrationTemplate.getAccessTokenUri();
    String actualAuthorizationUri = actualOAuth2ClientRegistrationTemplate.getAuthorizationUri();
    String actualClientAuthenticationMethod = actualOAuth2ClientRegistrationTemplate.getClientAuthenticationMethod();
    String actualComment = actualOAuth2ClientRegistrationTemplate.getComment();
    String actualHelpLink = actualOAuth2ClientRegistrationTemplate.getHelpLink();
    String actualJwkSetUri = actualOAuth2ClientRegistrationTemplate.getJwkSetUri();
    String actualLoginButtonIcon = actualOAuth2ClientRegistrationTemplate.getLoginButtonIcon();
    String actualLoginButtonLabel = actualOAuth2ClientRegistrationTemplate.getLoginButtonLabel();
    OAuth2MapperConfig actualMapperConfig = actualOAuth2ClientRegistrationTemplate.getMapperConfig();
    String actualName = actualOAuth2ClientRegistrationTemplate.getName();
    String actualProviderId = actualOAuth2ClientRegistrationTemplate.getProviderId();
    List<String> actualScope = actualOAuth2ClientRegistrationTemplate.getScope();
    String actualUserInfoUri = actualOAuth2ClientRegistrationTemplate.getUserInfoUri();

    // Assert that nothing has changed
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
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
    assertTrue(actualScope.isEmpty());
    assertSame(scope, actualScope);
    assertSame(mapperConfig, actualMapperConfig);
  }

  /**
   * Test
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)")
  void testNewOAuth2ClientRegistrationTemplate() throws IOException {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate(
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate()));

    // Assert
    JsonNode additionalInfo = actualOAuth2ClientRegistrationTemplate.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
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
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)")
  void testNewOAuth2ClientRegistrationTemplate2() throws IOException {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate(
        new OAuth2ClientRegistrationTemplate(
            new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate())));

    // Assert
    JsonNode additionalInfo = actualOAuth2ClientRegistrationTemplate.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
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
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <ul>
   *   <li>When
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplate(OAuth2ClientRegistrationTemplate); when OAuth2ClientRegistrationTemplate()")
  void testNewOAuth2ClientRegistrationTemplate_whenOAuth2ClientRegistrationTemplate() throws IOException {
    // Arrange and Act
    OAuth2ClientRegistrationTemplate actualOAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate(
        new OAuth2ClientRegistrationTemplate());

    // Assert
    JsonNode additionalInfo = actualOAuth2ClientRegistrationTemplate.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
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
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplate.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
