package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.oauth2.OAuth2User;

class BasicMapperUtilsDiffblueTest {
  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig)")
  void testGetOAuth2User() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
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
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2User.getCustomerName());
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("example.org", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig)")
  void testGetOAuth2User2() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("")
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
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2User.getCustomerName());
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("example.org", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig)")
  void testGetOAuth2User3() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("")
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
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2User.getCustomerName());
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("example.org", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return CustomerName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig); then return CustomerName is 'null'")
  void testGetOAuth2User_thenReturnCustomerNameIsNull() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("")
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
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("example.org", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getCustomerName());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return CustomerName is {@code %{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMapperUtils#getOAuth2User(String, Map,
   * OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig); then return CustomerName is '%{'")
  void testGetOAuth2User_thenReturnCustomerNameIsPercentSignLeftCurlyBracket() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("%{")
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
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("%{", actualOAuth2User.getCustomerName());
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("example.org", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return DefaultDashboardName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig); then return DefaultDashboardName is 'null'")
  void testGetOAuth2User_thenReturnDefaultDashboardNameIsNull() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("")
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
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2User.getCustomerName());
    assertEquals("example.org", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getDefaultDashboardName());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return TenantName is {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig); then return TenantName is 'jane.doe@example.org'")
  void testGetOAuth2User_thenReturnTenantNameIsJaneDoeExampleOrg() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
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
        .tenantNameStrategy(TenantNameStrategyType.EMAIL)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2User.getCustomerName());
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertEquals("jane.doe@example.org", actualOAuth2User.getTenantName());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return TenantName is {@code Tenant Name Pattern}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getOAuth2User(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getOAuth2User(String, Map, OAuth2MapperConfig); then return TenantName is 'Tenant Name Pattern'")
  void testGetOAuth2User_thenReturnTenantNameIsTenantNamePattern() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
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
        .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig config = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act
    OAuth2User actualOAuth2User = BasicMapperUtils.getOAuth2User("jane.doe@example.org", attributes, config);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2User.getCustomerName());
    assertEquals("Default Dashboard Name", actualOAuth2User.getDefaultDashboardName());
    assertEquals("Tenant Name Pattern", actualOAuth2User.getTenantName());
    assertEquals("jane.doe@example.org", actualOAuth2User.getEmail());
    assertNull(actualOAuth2User.getFirstName());
    assertNull(actualOAuth2User.getLastName());
    assertNull(actualOAuth2User.getCustomerId());
    assertNull(actualOAuth2User.getTenantId());
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
  }

  /**
   * Test {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}.
   * <ul>
   *   <li>Then return {@code example.org}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return 'example.org'")
  void testGetTenantName_thenReturnExampleOrg() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
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
   * Method under test:
   * {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return 'jane.doe@example.org'")
  void testGetTenantName_thenReturnJaneDoeExampleOrg() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
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
        .tenantNameStrategy(TenantNameStrategyType.EMAIL)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
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
   *   <li>Then return {@code Tenant Name Pattern}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getTenantName(String, Map, OAuth2MapperConfig)}
   */
  @Test
  @DisplayName("Test getTenantName(String, Map, OAuth2MapperConfig); then return 'Tenant Name Pattern'")
  void testGetTenantName_thenReturnTenantNamePattern() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
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
        .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
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
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getStringAttributeByKey(Map, String)}
   */
  @Test
  @DisplayName("Test getStringAttributeByKey(Map, String); given 'foo'; when HashMap() computeIfPresent 'foo' and BiFunction")
  void testGetStringAttributeByKey_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(BasicMapperUtils.getStringAttributeByKey(attributes, "Key"));
  }

  /**
   * Test {@link BasicMapperUtils#getStringAttributeByKey(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicMapperUtils#getStringAttributeByKey(Map, String)}
   */
  @Test
  @DisplayName("Test getStringAttributeByKey(Map, String); when HashMap()")
  void testGetStringAttributeByKey_whenHashMap() {
    // Arrange, Act and Assert
    assertNull(BasicMapperUtils.getStringAttributeByKey(new HashMap<>(), "Key"));
  }
}
