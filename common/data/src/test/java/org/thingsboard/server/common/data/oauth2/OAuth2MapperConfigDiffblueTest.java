package org.thingsboard.server.common.data.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;

@ContextConfiguration(classes = {OAuth2MapperConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class OAuth2MapperConfigDiffblueTest {
  @Autowired private OAuth2MapperConfigBuilder oAuth2MapperConfigBuilder;

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}, and {@link OAuth2MapperConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2MapperConfig#equals(Object)}
   *   <li>{@link OAuth2MapperConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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
    OAuth2MapperConfig oAuth2MapperConfig =
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

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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
    OAuth2MapperConfig oAuth2MapperConfig2 =
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build();

    // Act and Assert
    assertEquals(oAuth2MapperConfig, oAuth2MapperConfig2);
    assertEquals(oAuth2MapperConfig.hashCode(), oAuth2MapperConfig2.hashCode());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}, and {@link OAuth2MapperConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2MapperConfig#equals(Object)}
   *   <li>{@link OAuth2MapperConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    OAuth2MapperConfig oAuth2MapperConfig =
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

    // Act and Assert
    assertEquals(oAuth2MapperConfig, oAuth2MapperConfig);
    int expectedHashCodeResult = oAuth2MapperConfig.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2MapperConfig.hashCode());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(false).allowUserCreation(true);

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
    OAuth2MapperConfig oAuth2MapperConfig =
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

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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

    // Act and Assert
    assertNotEquals(
        oAuth2MapperConfig,
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(false);

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
    OAuth2MapperConfig oAuth2MapperConfig =
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

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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

    // Act and Assert
    assertNotEquals(
        oAuth2MapperConfig,
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(false)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("jane.doe@example.org")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    OAuth2MapperConfig oAuth2MapperConfig =
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

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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

    // Act and Assert
    assertNotEquals(
        oAuth2MapperConfig,
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
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
    OAuth2MapperConfig oAuth2MapperConfig =
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("jane.doe@example.org")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build();

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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

    // Act and Assert
    assertNotEquals(
        oAuth2MapperConfig,
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
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
    OAuth2MapperConfig oAuth2MapperConfig =
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(null)
            .build();

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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

    // Act and Assert
    assertNotEquals(
        oAuth2MapperConfig,
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
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
    OAuth2MapperConfig oAuth2MapperConfig =
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.CUSTOM)
            .build();

    OAuth2MapperConfigBuilder allowUserCreationResult2 =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult2 =
        allowUserCreationResult2.basic(
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

    // Act and Assert
    assertNotEquals(
        oAuth2MapperConfig,
        basicResult2
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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

    // Act and Assert
    assertNotEquals(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build(),
        null);
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2MapperConfig.equals(Object)",
    "int OAuth2MapperConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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

    // Act and Assert
    assertNotEquals(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build(),
        "Different type to OAuth2MapperConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2MapperConfig#OAuth2MapperConfig(boolean, boolean, MapperType,
   *       OAuth2BasicMapperConfig, OAuth2CustomMapperConfig)}
   *   <li>{@link OAuth2MapperConfig#setActivateUser(boolean)}
   *   <li>{@link OAuth2MapperConfig#setAllowUserCreation(boolean)}
   *   <li>{@link OAuth2MapperConfig#setBasic(OAuth2BasicMapperConfig)}
   *   <li>{@link OAuth2MapperConfig#setCustom(OAuth2CustomMapperConfig)}
   *   <li>{@link OAuth2MapperConfig#setType(MapperType)}
   *   <li>{@link OAuth2MapperConfig#toString()}
   *   <li>{@link OAuth2MapperConfig#getBasic()}
   *   <li>{@link OAuth2MapperConfig#getCustom()}
   *   <li>{@link OAuth2MapperConfig#getType()}
   *   <li>{@link OAuth2MapperConfig#isActivateUser()}
   *   <li>{@link OAuth2MapperConfig#isAllowUserCreation()}
   *   <li>{@link OAuth2MapperConfig#toBuilder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2MapperConfig.<init>(boolean, boolean, MapperType, OAuth2BasicMapperConfig, OAuth2CustomMapperConfig)",
    "OAuth2BasicMapperConfig OAuth2MapperConfig.getBasic()",
    "OAuth2CustomMapperConfig OAuth2MapperConfig.getCustom()",
    "MapperType OAuth2MapperConfig.getType()",
    "boolean OAuth2MapperConfig.isActivateUser()",
    "boolean OAuth2MapperConfig.isAllowUserCreation()",
    "void OAuth2MapperConfig.setActivateUser(boolean)",
    "void OAuth2MapperConfig.setAllowUserCreation(boolean)",
    "void OAuth2MapperConfig.setBasic(OAuth2BasicMapperConfig)",
    "void OAuth2MapperConfig.setCustom(OAuth2CustomMapperConfig)",
    "void OAuth2MapperConfig.setType(MapperType)",
    "OAuth2MapperConfigBuilder OAuth2MapperConfig.toBuilder()",
    "String OAuth2MapperConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    OAuth2BasicMapperConfig basic =
        OAuth2BasicMapperConfig.builder()
            .alwaysFullScreen(true)
            .customerNamePattern("Customer Name Pattern")
            .defaultDashboardName("Default Dashboard Name")
            .emailAttributeKey("jane.doe@example.org")
            .firstNameAttributeKey("Jane")
            .lastNameAttributeKey("Doe")
            .tenantNamePattern("Tenant Name Pattern")
            .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
            .build();
    OAuth2CustomMapperConfig custom =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();

    // Act
    OAuth2MapperConfig actualOAuth2MapperConfig =
        new OAuth2MapperConfig(true, true, MapperType.BASIC, basic, custom);
    actualOAuth2MapperConfig.setActivateUser(true);
    actualOAuth2MapperConfig.setAllowUserCreation(true);
    OAuth2BasicMapperConfig basic2 =
        OAuth2BasicMapperConfig.builder()
            .alwaysFullScreen(true)
            .customerNamePattern("Customer Name Pattern")
            .defaultDashboardName("Default Dashboard Name")
            .emailAttributeKey("jane.doe@example.org")
            .firstNameAttributeKey("Jane")
            .lastNameAttributeKey("Doe")
            .tenantNamePattern("Tenant Name Pattern")
            .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
            .build();
    actualOAuth2MapperConfig.setBasic(basic2);
    OAuth2CustomMapperConfig custom2 =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();
    actualOAuth2MapperConfig.setCustom(custom2);
    actualOAuth2MapperConfig.setType(MapperType.BASIC);
    String actualToStringResult = actualOAuth2MapperConfig.toString();
    OAuth2BasicMapperConfig actualBasic = actualOAuth2MapperConfig.getBasic();
    OAuth2CustomMapperConfig actualCustom = actualOAuth2MapperConfig.getCustom();
    MapperType actualType = actualOAuth2MapperConfig.getType();
    boolean actualIsActivateUserResult = actualOAuth2MapperConfig.isActivateUser();
    boolean actualIsAllowUserCreationResult = actualOAuth2MapperConfig.isAllowUserCreation();
    actualOAuth2MapperConfig.toBuilder();

    // Assert
    assertEquals(
        "OAuth2MapperConfig(allowUserCreation=true, activateUser=true, type=BASIC, basic=OAuth2BasicMapperConfig"
            + "(emailAttributeKey=jane.doe@example.org, firstNameAttributeKey=Jane, lastNameAttributeKey=Doe,"
            + " tenantNameStrategy=DOMAIN, tenantNamePattern=Tenant Name Pattern, customerNamePattern=Customer Name"
            + " Pattern, defaultDashboardName=Default Dashboard Name, alwaysFullScreen=true), custom=OAuth2CustomMa"
            + "pperConfig(url=https://example.org/example, username=janedoe, sendToken=true))",
        actualToStringResult);
    assertEquals(MapperType.BASIC, actualType);
    assertTrue(actualIsActivateUserResult);
    assertTrue(actualIsAllowUserCreationResult);
    assertSame(basic2, actualBasic);
    assertSame(custom2, actualCustom);
  }

  /**
   * Test OAuth2MapperConfigBuilder {@link OAuth2MapperConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2MapperConfigBuilder#build()}
   *   <li>{@link OAuth2MapperConfigBuilder#activateUser(boolean)}
   *   <li>{@link OAuth2MapperConfigBuilder#allowUserCreation(boolean)}
   *   <li>{@link OAuth2MapperConfigBuilder#basic(OAuth2BasicMapperConfig)}
   *   <li>{@link OAuth2MapperConfigBuilder#custom(OAuth2CustomMapperConfig)}
   *   <li>{@link OAuth2MapperConfigBuilder#type(MapperType)}
   * </ul>
   */
  @Test
  @DisplayName("Test OAuth2MapperConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2MapperConfigBuilder.<init>()",
    "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.activateUser(boolean)",
    "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.allowUserCreation(boolean)",
    "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.basic(OAuth2BasicMapperConfig)",
    "OAuth2MapperConfig OAuth2MapperConfigBuilder.build()",
    "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.custom(OAuth2CustomMapperConfig)",
    "String OAuth2MapperConfigBuilder.toString()",
    "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.type(MapperType)"
  })
  void testOAuth2MapperConfigBuilderBuild() {
    // Arrange and Act
    OAuth2MapperConfigBuilder actualAllowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);
    OAuth2BasicMapperConfig basic =
        OAuth2BasicMapperConfig.builder()
            .alwaysFullScreen(true)
            .customerNamePattern("Customer Name Pattern")
            .defaultDashboardName("Default Dashboard Name")
            .emailAttributeKey("jane.doe@example.org")
            .firstNameAttributeKey("Jane")
            .lastNameAttributeKey("Doe")
            .tenantNamePattern("Tenant Name Pattern")
            .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
            .build();
    OAuth2MapperConfigBuilder actualBasicResult = actualAllowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();
    OAuth2MapperConfig actualOAuth2MapperConfig =
        actualBasicResult.custom(custom).type(MapperType.BASIC).build();

    // Assert
    assertEquals(MapperType.BASIC, actualOAuth2MapperConfig.getType());
    assertTrue(actualOAuth2MapperConfig.isActivateUser());
    assertTrue(actualOAuth2MapperConfig.isAllowUserCreation());
    assertSame(basic, actualOAuth2MapperConfig.getBasic());
    assertSame(custom, actualOAuth2MapperConfig.getCustom());
  }
}
