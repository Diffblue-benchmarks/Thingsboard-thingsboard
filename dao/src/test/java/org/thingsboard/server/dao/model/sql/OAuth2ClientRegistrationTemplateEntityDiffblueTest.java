package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class OAuth2ClientRegistrationTemplateEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setAlwaysFullScreen(Boolean)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setAuthorizationUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setClientAuthenticationMethod(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setComment(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setCustomerNamePattern(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setDefaultDashboardName(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setEmailAttributeKey(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setFirstNameAttributeKey(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setHelpLink(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setJwkSetUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setLastNameAttributeKey(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setLoginButtonIcon(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setLoginButtonLabel(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setProviderId(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setScope(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setTenantNamePattern(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setTenantNameStrategy(TenantNameStrategyType)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setTokenUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setType(MapperType)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setUserInfoUri(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#setUserNameAttributeName(String)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#toString()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getAdditionalInfo()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getAlwaysFullScreen()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getAuthorizationUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getClientAuthenticationMethod()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getComment()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getCustomerNamePattern()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getDefaultDashboardName()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getEmailAttributeKey()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getFirstNameAttributeKey()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getHelpLink()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getJwkSetUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getLastNameAttributeKey()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getLoginButtonIcon()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getLoginButtonLabel()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getProviderId()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getScope()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getTenantNamePattern()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getTenantNameStrategy()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getTokenUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getType()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getUserInfoUri()}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#getUserNameAttributeName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth2ClientRegistrationTemplateEntity.<init>()",
      "JsonNode OAuth2ClientRegistrationTemplateEntity.getAdditionalInfo()",
      "Boolean OAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen()",
      "String OAuth2ClientRegistrationTemplateEntity.getAuthorizationUri()",
      "String OAuth2ClientRegistrationTemplateEntity.getClientAuthenticationMethod()",
      "String OAuth2ClientRegistrationTemplateEntity.getComment()",
      "String OAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern()",
      "String OAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName()",
      "String OAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey()",
      "String OAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey()",
      "String OAuth2ClientRegistrationTemplateEntity.getHelpLink()",
      "String OAuth2ClientRegistrationTemplateEntity.getJwkSetUri()",
      "String OAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey()",
      "String OAuth2ClientRegistrationTemplateEntity.getLoginButtonIcon()",
      "String OAuth2ClientRegistrationTemplateEntity.getLoginButtonLabel()",
      "String OAuth2ClientRegistrationTemplateEntity.getProviderId()",
      "String OAuth2ClientRegistrationTemplateEntity.getScope()",
      "String OAuth2ClientRegistrationTemplateEntity.getTenantNamePattern()",
      "TenantNameStrategyType OAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy()",
      "String OAuth2ClientRegistrationTemplateEntity.getTokenUri()",
      "MapperType OAuth2ClientRegistrationTemplateEntity.getType()",
      "String OAuth2ClientRegistrationTemplateEntity.getUserInfoUri()",
      "String OAuth2ClientRegistrationTemplateEntity.getUserNameAttributeName()",
      "void OAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(JsonNode)",
      "void OAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(Boolean)",
      "void OAuth2ClientRegistrationTemplateEntity.setAuthorizationUri(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setComment(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setHelpLink(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setJwkSetUri(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setProviderId(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setScope(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setTenantNamePattern(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType)",
      "void OAuth2ClientRegistrationTemplateEntity.setTokenUri(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setType(MapperType)",
      "void OAuth2ClientRegistrationTemplateEntity.setUserInfoUri(String)",
      "void OAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName(String)",
      "String OAuth2ClientRegistrationTemplateEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity = new OAuth2ClientRegistrationTemplateEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(additionalInfo);
    actualOAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    actualOAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    actualOAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("Client Authentication Method");
    actualOAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    actualOAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    actualOAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    actualOAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    actualOAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    actualOAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    actualOAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    actualOAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    actualOAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    actualOAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    actualOAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    actualOAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    actualOAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    actualOAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    actualOAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    actualOAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    actualOAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    actualOAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    String actualToStringResult = actualOAuth2ClientRegistrationTemplateEntity.toString();
    JsonNode actualAdditionalInfo = actualOAuth2ClientRegistrationTemplateEntity.getAdditionalInfo();
    Boolean actualAlwaysFullScreen = actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen();
    String actualAuthorizationUri = actualOAuth2ClientRegistrationTemplateEntity.getAuthorizationUri();
    String actualClientAuthenticationMethod = actualOAuth2ClientRegistrationTemplateEntity
        .getClientAuthenticationMethod();
    String actualComment = actualOAuth2ClientRegistrationTemplateEntity.getComment();
    String actualCustomerNamePattern = actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern();
    String actualDefaultDashboardName = actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName();
    String actualEmailAttributeKey = actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey();
    String actualFirstNameAttributeKey = actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey();
    String actualHelpLink = actualOAuth2ClientRegistrationTemplateEntity.getHelpLink();
    String actualJwkSetUri = actualOAuth2ClientRegistrationTemplateEntity.getJwkSetUri();
    String actualLastNameAttributeKey = actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey();
    String actualLoginButtonIcon = actualOAuth2ClientRegistrationTemplateEntity.getLoginButtonIcon();
    String actualLoginButtonLabel = actualOAuth2ClientRegistrationTemplateEntity.getLoginButtonLabel();
    String actualProviderId = actualOAuth2ClientRegistrationTemplateEntity.getProviderId();
    String actualScope = actualOAuth2ClientRegistrationTemplateEntity.getScope();
    String actualTenantNamePattern = actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern();
    TenantNameStrategyType actualTenantNameStrategy = actualOAuth2ClientRegistrationTemplateEntity
        .getTenantNameStrategy();
    String actualTokenUri = actualOAuth2ClientRegistrationTemplateEntity.getTokenUri();
    MapperType actualType = actualOAuth2ClientRegistrationTemplateEntity.getType();
    String actualUserInfoUri = actualOAuth2ClientRegistrationTemplateEntity.getUserInfoUri();

    // Assert
    assertEquals("42", actualProviderId);
    assertEquals("ABC123", actualTokenUri);
    assertEquals("Client Authentication Method", actualClientAuthenticationMethod);
    assertEquals("Comment", actualComment);
    assertEquals("Customer Name Pattern", actualCustomerNamePattern);
    assertEquals("Default Dashboard Name", actualDefaultDashboardName);
    assertEquals("Doe", actualLastNameAttributeKey);
    assertEquals("Help Link", actualHelpLink);
    assertEquals("Jane", actualFirstNameAttributeKey);
    assertEquals("JaneDoe", actualAuthorizationUri);
    assertEquals("Jwk Set Uri", actualJwkSetUri);
    assertEquals("Login Button Icon", actualLoginButtonIcon);
    assertEquals("Login Button Label", actualLoginButtonLabel);
    assertEquals("OAuth2ClientRegistrationTemplateEntity(providerId=42, authorizationUri=JaneDoe, tokenUri=ABC123,"
        + " scope=Scope, userInfoUri=User Info Uri, userNameAttributeName=janedoe, jwkSetUri=Jwk Set Uri,"
        + " clientAuthenticationMethod=Client Authentication Method, type=BASIC, emailAttributeKey=jane.doe@example.org,"
        + " firstNameAttributeKey=Jane, lastNameAttributeKey=Doe, tenantNameStrategy=DOMAIN, tenantNamePattern=Tenant"
        + " Name Pattern, customerNamePattern=Customer Name Pattern, defaultDashboardName=Default Dashboard Name,"
        + " alwaysFullScreen=true, comment=Comment, loginButtonIcon=Login Button Icon, loginButtonLabel=Login"
        + " Button Label, helpLink=Help Link, additionalInfo={\"isPublic\":true})", actualToStringResult);
    assertEquals("Scope", actualScope);
    assertEquals("Tenant Name Pattern", actualTenantNamePattern);
    assertEquals("User Info Uri", actualUserInfoUri);
    assertEquals("jane.doe@example.org", actualEmailAttributeKey);
    assertEquals("janedoe", actualOAuth2ClientRegistrationTemplateEntity.getUserNameAttributeName());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getId());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getUuid());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplateEntity.getCreatedTime());
    assertEquals(MapperType.BASIC, actualType);
    assertEquals(TenantNameStrategyType.DOMAIN, actualTenantNameStrategy);
    assertTrue(actualAlwaysFullScreen);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
