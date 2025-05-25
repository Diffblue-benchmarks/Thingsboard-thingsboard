package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class OAuth2ClientEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientEntity#OAuth2ClientEntity()}
   *   <li>{@link OAuth2ClientEntity#setActivateUser(Boolean)}
   *   <li>{@link OAuth2ClientEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link OAuth2ClientEntity#setAllowUserCreation(Boolean)}
   *   <li>{@link OAuth2ClientEntity#setAlwaysFullScreen(Boolean)}
   *   <li>{@link OAuth2ClientEntity#setAuthorizationUri(String)}
   *   <li>{@link OAuth2ClientEntity#setClientAuthenticationMethod(String)}
   *   <li>{@link OAuth2ClientEntity#setClientId(String)}
   *   <li>{@link OAuth2ClientEntity#setClientSecret(String)}
   *   <li>{@link OAuth2ClientEntity#setCustomerNamePattern(String)}
   *   <li>{@link OAuth2ClientEntity#setDefaultDashboardName(String)}
   *   <li>{@link OAuth2ClientEntity#setEmailAttributeKey(String)}
   *   <li>{@link OAuth2ClientEntity#setFirstNameAttributeKey(String)}
   *   <li>{@link OAuth2ClientEntity#setJwkSetUri(String)}
   *   <li>{@link OAuth2ClientEntity#setLastNameAttributeKey(String)}
   *   <li>{@link OAuth2ClientEntity#setLoginButtonIcon(String)}
   *   <li>{@link OAuth2ClientEntity#setLoginButtonLabel(String)}
   *   <li>{@link OAuth2ClientEntity#setPassword(String)}
   *   <li>{@link OAuth2ClientEntity#setPlatforms(String)}
   *   <li>{@link OAuth2ClientEntity#setScope(String)}
   *   <li>{@link OAuth2ClientEntity#setSendToken(Boolean)}
   *   <li>{@link OAuth2ClientEntity#setTenantId(UUID)}
   *   <li>{@link OAuth2ClientEntity#setTenantNamePattern(String)}
   *   <li>{@link OAuth2ClientEntity#setTenantNameStrategy(TenantNameStrategyType)}
   *   <li>{@link OAuth2ClientEntity#setTitle(String)}
   *   <li>{@link OAuth2ClientEntity#setTokenUri(String)}
   *   <li>{@link OAuth2ClientEntity#setType(MapperType)}
   *   <li>{@link OAuth2ClientEntity#setUrl(String)}
   *   <li>{@link OAuth2ClientEntity#setUserInfoUri(String)}
   *   <li>{@link OAuth2ClientEntity#setUserNameAttributeName(String)}
   *   <li>{@link OAuth2ClientEntity#setUsername(String)}
   *   <li>{@link OAuth2ClientEntity#toString()}
   *   <li>{@link OAuth2ClientEntity#getActivateUser()}
   *   <li>{@link OAuth2ClientEntity#getAdditionalInfo()}
   *   <li>{@link OAuth2ClientEntity#getAllowUserCreation()}
   *   <li>{@link OAuth2ClientEntity#getAlwaysFullScreen()}
   *   <li>{@link OAuth2ClientEntity#getAuthorizationUri()}
   *   <li>{@link OAuth2ClientEntity#getClientAuthenticationMethod()}
   *   <li>{@link OAuth2ClientEntity#getClientId()}
   *   <li>{@link OAuth2ClientEntity#getClientSecret()}
   *   <li>{@link OAuth2ClientEntity#getCustomerNamePattern()}
   *   <li>{@link OAuth2ClientEntity#getDefaultDashboardName()}
   *   <li>{@link OAuth2ClientEntity#getEmailAttributeKey()}
   *   <li>{@link OAuth2ClientEntity#getFirstNameAttributeKey()}
   *   <li>{@link OAuth2ClientEntity#getJwkSetUri()}
   *   <li>{@link OAuth2ClientEntity#getLastNameAttributeKey()}
   *   <li>{@link OAuth2ClientEntity#getLoginButtonIcon()}
   *   <li>{@link OAuth2ClientEntity#getLoginButtonLabel()}
   *   <li>{@link OAuth2ClientEntity#getPassword()}
   *   <li>{@link OAuth2ClientEntity#getPlatforms()}
   *   <li>{@link OAuth2ClientEntity#getScope()}
   *   <li>{@link OAuth2ClientEntity#getSendToken()}
   *   <li>{@link OAuth2ClientEntity#getTenantId()}
   *   <li>{@link OAuth2ClientEntity#getTenantNamePattern()}
   *   <li>{@link OAuth2ClientEntity#getTenantNameStrategy()}
   *   <li>{@link OAuth2ClientEntity#getTitle()}
   *   <li>{@link OAuth2ClientEntity#getTokenUri()}
   *   <li>{@link OAuth2ClientEntity#getType()}
   *   <li>{@link OAuth2ClientEntity#getUrl()}
   *   <li>{@link OAuth2ClientEntity#getUserInfoUri()}
   *   <li>{@link OAuth2ClientEntity#getUserNameAttributeName()}
   *   <li>{@link OAuth2ClientEntity#getUsername()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>()", "Boolean OAuth2ClientEntity.getActivateUser()",
      "JsonNode OAuth2ClientEntity.getAdditionalInfo()", "Boolean OAuth2ClientEntity.getAllowUserCreation()",
      "Boolean OAuth2ClientEntity.getAlwaysFullScreen()", "String OAuth2ClientEntity.getAuthorizationUri()",
      "String OAuth2ClientEntity.getClientAuthenticationMethod()", "String OAuth2ClientEntity.getClientId()",
      "String OAuth2ClientEntity.getClientSecret()", "String OAuth2ClientEntity.getCustomerNamePattern()",
      "String OAuth2ClientEntity.getDefaultDashboardName()", "String OAuth2ClientEntity.getEmailAttributeKey()",
      "String OAuth2ClientEntity.getFirstNameAttributeKey()", "String OAuth2ClientEntity.getJwkSetUri()",
      "String OAuth2ClientEntity.getLastNameAttributeKey()", "String OAuth2ClientEntity.getLoginButtonIcon()",
      "String OAuth2ClientEntity.getLoginButtonLabel()", "String OAuth2ClientEntity.getPassword()",
      "String OAuth2ClientEntity.getPlatforms()", "String OAuth2ClientEntity.getScope()",
      "Boolean OAuth2ClientEntity.getSendToken()", "UUID OAuth2ClientEntity.getTenantId()",
      "String OAuth2ClientEntity.getTenantNamePattern()",
      "TenantNameStrategyType OAuth2ClientEntity.getTenantNameStrategy()", "String OAuth2ClientEntity.getTitle()",
      "String OAuth2ClientEntity.getTokenUri()", "MapperType OAuth2ClientEntity.getType()",
      "String OAuth2ClientEntity.getUrl()", "String OAuth2ClientEntity.getUserInfoUri()",
      "String OAuth2ClientEntity.getUserNameAttributeName()", "String OAuth2ClientEntity.getUsername()",
      "void OAuth2ClientEntity.setActivateUser(Boolean)", "void OAuth2ClientEntity.setAdditionalInfo(JsonNode)",
      "void OAuth2ClientEntity.setAllowUserCreation(Boolean)", "void OAuth2ClientEntity.setAlwaysFullScreen(Boolean)",
      "void OAuth2ClientEntity.setAuthorizationUri(String)",
      "void OAuth2ClientEntity.setClientAuthenticationMethod(String)", "void OAuth2ClientEntity.setClientId(String)",
      "void OAuth2ClientEntity.setClientSecret(String)", "void OAuth2ClientEntity.setCustomerNamePattern(String)",
      "void OAuth2ClientEntity.setDefaultDashboardName(String)", "void OAuth2ClientEntity.setEmailAttributeKey(String)",
      "void OAuth2ClientEntity.setFirstNameAttributeKey(String)", "void OAuth2ClientEntity.setJwkSetUri(String)",
      "void OAuth2ClientEntity.setLastNameAttributeKey(String)", "void OAuth2ClientEntity.setLoginButtonIcon(String)",
      "void OAuth2ClientEntity.setLoginButtonLabel(String)", "void OAuth2ClientEntity.setPassword(String)",
      "void OAuth2ClientEntity.setPlatforms(String)", "void OAuth2ClientEntity.setScope(String)",
      "void OAuth2ClientEntity.setSendToken(Boolean)", "void OAuth2ClientEntity.setTenantId(UUID)",
      "void OAuth2ClientEntity.setTenantNamePattern(String)",
      "void OAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType)",
      "void OAuth2ClientEntity.setTitle(String)", "void OAuth2ClientEntity.setTokenUri(String)",
      "void OAuth2ClientEntity.setType(MapperType)", "void OAuth2ClientEntity.setUrl(String)",
      "void OAuth2ClientEntity.setUserInfoUri(String)", "void OAuth2ClientEntity.setUserNameAttributeName(String)",
      "void OAuth2ClientEntity.setUsername(String)", "String OAuth2ClientEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity();
    actualOAuth2ClientEntity.setActivateUser(true);
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOAuth2ClientEntity.setAdditionalInfo(additionalInfo);
    actualOAuth2ClientEntity.setAllowUserCreation(true);
    actualOAuth2ClientEntity.setAlwaysFullScreen(true);
    actualOAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    actualOAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    actualOAuth2ClientEntity.setClientId("42");
    actualOAuth2ClientEntity.setClientSecret("Client Secret");
    actualOAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    actualOAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    actualOAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    actualOAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    actualOAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    actualOAuth2ClientEntity.setLastNameAttributeKey("Doe");
    actualOAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    actualOAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    actualOAuth2ClientEntity.setPassword("iloveyou");
    actualOAuth2ClientEntity.setPlatforms("Platforms");
    actualOAuth2ClientEntity.setScope("Scope");
    actualOAuth2ClientEntity.setSendToken(true);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOAuth2ClientEntity.setTenantId(tenantId);
    actualOAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    actualOAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    actualOAuth2ClientEntity.setTitle("Dr");
    actualOAuth2ClientEntity.setTokenUri("ABC123");
    actualOAuth2ClientEntity.setType(MapperType.BASIC);
    actualOAuth2ClientEntity.setUrl("https://example.org/example");
    actualOAuth2ClientEntity.setUserInfoUri("User Info Uri");
    actualOAuth2ClientEntity.setUserNameAttributeName("janedoe");
    actualOAuth2ClientEntity.setUsername("janedoe");
    String actualToStringResult = actualOAuth2ClientEntity.toString();
    Boolean actualActivateUser = actualOAuth2ClientEntity.getActivateUser();
    JsonNode actualAdditionalInfo = actualOAuth2ClientEntity.getAdditionalInfo();
    Boolean actualAllowUserCreation = actualOAuth2ClientEntity.getAllowUserCreation();
    Boolean actualAlwaysFullScreen = actualOAuth2ClientEntity.getAlwaysFullScreen();
    String actualAuthorizationUri = actualOAuth2ClientEntity.getAuthorizationUri();
    String actualClientAuthenticationMethod = actualOAuth2ClientEntity.getClientAuthenticationMethod();
    String actualClientId = actualOAuth2ClientEntity.getClientId();
    String actualClientSecret = actualOAuth2ClientEntity.getClientSecret();
    String actualCustomerNamePattern = actualOAuth2ClientEntity.getCustomerNamePattern();
    String actualDefaultDashboardName = actualOAuth2ClientEntity.getDefaultDashboardName();
    String actualEmailAttributeKey = actualOAuth2ClientEntity.getEmailAttributeKey();
    String actualFirstNameAttributeKey = actualOAuth2ClientEntity.getFirstNameAttributeKey();
    String actualJwkSetUri = actualOAuth2ClientEntity.getJwkSetUri();
    String actualLastNameAttributeKey = actualOAuth2ClientEntity.getLastNameAttributeKey();
    String actualLoginButtonIcon = actualOAuth2ClientEntity.getLoginButtonIcon();
    String actualLoginButtonLabel = actualOAuth2ClientEntity.getLoginButtonLabel();
    String actualPassword = actualOAuth2ClientEntity.getPassword();
    String actualPlatforms = actualOAuth2ClientEntity.getPlatforms();
    String actualScope = actualOAuth2ClientEntity.getScope();
    Boolean actualSendToken = actualOAuth2ClientEntity.getSendToken();
    UUID actualTenantId = actualOAuth2ClientEntity.getTenantId();
    String actualTenantNamePattern = actualOAuth2ClientEntity.getTenantNamePattern();
    TenantNameStrategyType actualTenantNameStrategy = actualOAuth2ClientEntity.getTenantNameStrategy();
    String actualTitle = actualOAuth2ClientEntity.getTitle();
    String actualTokenUri = actualOAuth2ClientEntity.getTokenUri();
    MapperType actualType = actualOAuth2ClientEntity.getType();
    String actualUrl = actualOAuth2ClientEntity.getUrl();
    String actualUserInfoUri = actualOAuth2ClientEntity.getUserInfoUri();
    String actualUserNameAttributeName = actualOAuth2ClientEntity.getUserNameAttributeName();
    String actualUsername = actualOAuth2ClientEntity.getUsername();

    // Assert
    assertEquals("42", actualClientId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("ABC123", actualTokenUri);
    assertEquals("Client Authentication Method", actualClientAuthenticationMethod);
    assertEquals("Client Secret", actualClientSecret);
    assertEquals("Customer Name Pattern", actualCustomerNamePattern);
    assertEquals("Default Dashboard Name", actualDefaultDashboardName);
    assertEquals("Doe", actualLastNameAttributeKey);
    assertEquals("Dr", actualTitle);
    assertEquals("Jane", actualFirstNameAttributeKey);
    assertEquals("JaneDoe", actualAuthorizationUri);
    assertEquals("Jwk Set Uri", actualJwkSetUri);
    assertEquals("Login Button Icon", actualLoginButtonIcon);
    assertEquals("Login Button Label", actualLoginButtonLabel);
    assertEquals(
        "OAuth2ClientEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, clientId=42, clientSecret=Client"
            + " Secret, authorizationUri=JaneDoe, tokenUri=ABC123, scope=Scope, platforms=Platforms, userInfoUri=User"
            + " Info Uri, userNameAttributeName=janedoe, jwkSetUri=Jwk Set Uri, clientAuthenticationMethod=Client"
            + " Authentication Method, loginButtonLabel=Login Button Label, loginButtonIcon=Login Button Icon,"
            + " allowUserCreation=true, activateUser=true, type=BASIC, emailAttributeKey=jane.doe@example.org,"
            + " firstNameAttributeKey=Jane, lastNameAttributeKey=Doe, tenantNameStrategy=DOMAIN, tenantNamePattern=Tenant"
            + " Name Pattern, customerNamePattern=Customer Name Pattern, defaultDashboardName=Default Dashboard Name,"
            + " alwaysFullScreen=true, url=https://example.org/example, username=janedoe, password=iloveyou,"
            + " sendToken=true, additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("Platforms", actualPlatforms);
    assertEquals("Scope", actualScope);
    assertEquals("Tenant Name Pattern", actualTenantNamePattern);
    assertEquals("User Info Uri", actualUserInfoUri);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmailAttributeKey);
    assertEquals("janedoe", actualUserNameAttributeName);
    assertEquals("janedoe", actualUsername);
    assertNull(actualOAuth2ClientEntity.getId());
    assertNull(actualOAuth2ClientEntity.getUuid());
    assertEquals(0L, actualOAuth2ClientEntity.getCreatedTime());
    assertEquals(MapperType.BASIC, actualType);
    assertEquals(TenantNameStrategyType.DOMAIN, actualTenantNameStrategy);
    assertTrue(actualActivateUser);
    assertTrue(actualAllowUserCreation);
    assertTrue(actualAlwaysFullScreen);
    assertTrue(actualSendToken);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
