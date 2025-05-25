package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;

class BasicMapperUtilsDiffblueTest {
  /**
   * Test {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicMapperUtils.getTenantName(String, Map, OAuth2MapperConfig)"})
  void testGetTenantName_thenReturnEmptyString() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("")
        .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals("", BasicMapperUtils.getTenantName("jane.doe@example.org", attributes, config));
  }

  /**
   * Test {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return {@code example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return 'example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicMapperUtils.getTenantName(String, Map, OAuth2MapperConfig)"})
  void testGetTenantName_thenReturnExampleOrg() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals("example.org", BasicMapperUtils.getTenantName("jane.doe@example.org", attributes, config));
  }

  /**
   * Test {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicMapperUtils.getTenantName(String, Map, OAuth2MapperConfig)"})
  void testGetTenantName_thenReturnJaneDoeExampleOrg() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
        .tenantNameStrategy(TenantNameStrategyType.EMAIL)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals("jane.doe@example.org", BasicMapperUtils.getTenantName("jane.doe@example.org", attributes, config));
  }

  /**
   * Test {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return {@code %{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return '%{'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicMapperUtils.getTenantName(String, Map, OAuth2MapperConfig)"})
  void testGetTenantName_thenReturnPercentSignLeftCurlyBracket() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("%{")
        .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals("%{", BasicMapperUtils.getTenantName("jane.doe@example.org", attributes, config));
  }

  /**
   * Test {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return {@code Tenant Name Pattern}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return 'Tenant Name Pattern'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicMapperUtils.getTenantName(String, Map, OAuth2MapperConfig)"})
  void testGetTenantName_thenReturnTenantNamePattern() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
        .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals("Tenant Name Pattern", BasicMapperUtils.getTenantName("jane.doe@example.org", attributes, config));
  }

  /**
   * Test {@link BasicMapperUtils#getStringAttributeByKey(Map, String)}.
   * <p>
   * Method under test: {@link BasicMapperUtils#getStringAttributeByKey(Map, String)}
   */
  @Test
  @DisplayName("Test getStringAttributeByKey(Map, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicMapperUtils.getStringAttributeByKey(Map, String)"})
  void testGetStringAttributeByKey() {
    // Arrange, Act and Assert
    assertNull(BasicMapperUtils.getStringAttributeByKey(new HashMap<>(), "Key"));
  }
}
