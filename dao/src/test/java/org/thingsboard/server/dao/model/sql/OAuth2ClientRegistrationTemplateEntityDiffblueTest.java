package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.OAuth2ClientRegistrationTemplateId;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class OAuth2ClientRegistrationTemplateEntityDiffblueTest {
  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}, and {@link
   * OAuth2ClientRegistrationTemplateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
    int expectedHashCodeResult = oAuth2ClientRegistrationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientRegistrationTemplateEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}, and {@link
   * OAuth2ClientRegistrationTemplateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   *   <li>{@link OAuth2ClientRegistrationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity);
    int expectedHashCodeResult = oAuth2ClientRegistrationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientRegistrationTemplateEntity.hashCode());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(null);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(false);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(null);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("42");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri(null);
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("42");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(null);
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("42");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment(null);
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(3L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("42");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern(null);
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("42");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName(null);
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey(null);
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("John");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey(null);
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("42");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink(null);
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("42");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri(null);
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Smith");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey(null);
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("42");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon(null);
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("42");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel(null);
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId(null);
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("42");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope(null);
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("42");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual35() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern(null);
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual36() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(null);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual37() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual38() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("42");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual39() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri(null);
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual40() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(null);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual41() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.CUSTOM);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual42() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("42");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual43() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri(null);
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual44() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("42");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual45() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName(null);
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity, oAuth2ClientRegistrationTemplateEntity2);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(oAuth2ClientRegistrationTemplateEntity, null);
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2ClientRegistrationTemplateEntity.equals(Object)",
    "int OAuth2ClientRegistrationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        oAuth2ClientRegistrationTemplateEntity,
        "Different type to OAuth2ClientRegistrationTemplateEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *   <li>{@link
   *       OAuth2ClientRegistrationTemplateEntity#setTenantNameStrategy(TenantNameStrategyType)}
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
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>()",
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
    "String OAuth2ClientRegistrationTemplateEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(additionalInfo);
    actualOAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    actualOAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    actualOAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
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
    actualOAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(
        TenantNameStrategyType.DOMAIN);
    actualOAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    actualOAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    actualOAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    actualOAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    String actualToStringResult = actualOAuth2ClientRegistrationTemplateEntity.toString();
    JsonNode actualAdditionalInfo =
        actualOAuth2ClientRegistrationTemplateEntity.getAdditionalInfo();
    Boolean actualAlwaysFullScreen =
        actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen();
    String actualAuthorizationUri =
        actualOAuth2ClientRegistrationTemplateEntity.getAuthorizationUri();
    String actualClientAuthenticationMethod =
        actualOAuth2ClientRegistrationTemplateEntity.getClientAuthenticationMethod();
    String actualComment = actualOAuth2ClientRegistrationTemplateEntity.getComment();
    String actualCustomerNamePattern =
        actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern();
    String actualDefaultDashboardName =
        actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName();
    String actualEmailAttributeKey =
        actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey();
    String actualFirstNameAttributeKey =
        actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey();
    String actualHelpLink = actualOAuth2ClientRegistrationTemplateEntity.getHelpLink();
    String actualJwkSetUri = actualOAuth2ClientRegistrationTemplateEntity.getJwkSetUri();
    String actualLastNameAttributeKey =
        actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey();
    String actualLoginButtonIcon =
        actualOAuth2ClientRegistrationTemplateEntity.getLoginButtonIcon();
    String actualLoginButtonLabel =
        actualOAuth2ClientRegistrationTemplateEntity.getLoginButtonLabel();
    String actualProviderId = actualOAuth2ClientRegistrationTemplateEntity.getProviderId();
    String actualScope = actualOAuth2ClientRegistrationTemplateEntity.getScope();
    String actualTenantNamePattern =
        actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern();
    TenantNameStrategyType actualTenantNameStrategy =
        actualOAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy();
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
    assertEquals(
        "OAuth2ClientRegistrationTemplateEntity(providerId=42, authorizationUri=JaneDoe, tokenUri=ABC123,"
            + " scope=Scope, userInfoUri=User Info Uri, userNameAttributeName=janedoe, jwkSetUri=Jwk Set Uri,"
            + " clientAuthenticationMethod=Client Authentication Method, type=BASIC, emailAttributeKey=jane.doe@example.org,"
            + " firstNameAttributeKey=Jane, lastNameAttributeKey=Doe, tenantNameStrategy=DOMAIN, tenantNamePattern=Tenant"
            + " Name Pattern, customerNamePattern=Customer Name Pattern, defaultDashboardName=Default Dashboard Name,"
            + " alwaysFullScreen=true, comment=Comment, loginButtonIcon=Login Button Icon, loginButtonLabel=Login"
            + " Button Label, helpLink=Help Link, additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("Scope", actualScope);
    assertEquals("Tenant Name Pattern", actualTenantNamePattern);
    assertEquals("User Info Uri", actualUserInfoUri);
    assertEquals("jane.doe@example.org", actualEmailAttributeKey);
    assertEquals(
        "janedoe", actualOAuth2ClientRegistrationTemplateEntity.getUserNameAttributeName());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getId());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getUuid());
    assertEquals(0L, actualOAuth2ClientRegistrationTemplateEntity.getCreatedTime());
    assertEquals(MapperType.BASIC, actualType);
    assertEquals(TenantNameStrategyType.DOMAIN, actualTenantNameStrategy);
    assertTrue(actualAlwaysFullScreen);
    assertSame(additionalInfo, actualAdditionalInfo);
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>(OAuth2ClientRegistrationTemplate)"
  })
  public void testNewOAuth2ClientRegistrationTemplateEntity() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult =
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setBasic(null);

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setId(null);
    clientRegistrationTemplate.setMapperConfig(mapperConfig);
    clientRegistrationTemplate.setScope(new ArrayList<>());

    // Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity(clientRegistrationTemplate);

    // Assert
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>(OAuth2ClientRegistrationTemplate)"
  })
  public void testNewOAuth2ClientRegistrationTemplateEntity2() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    clientRegistrationTemplate.setId(new OAuth2ClientRegistrationTemplateId(id));
    OAuth2MapperConfigBuilder allowUserCreationResult =
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    clientRegistrationTemplate.setMapperConfig(mapperConfig);
    clientRegistrationTemplate.setScope(new ArrayList<>());

    // Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity(clientRegistrationTemplate);

    // Assert
    UUID id2 = actualOAuth2ClientRegistrationTemplateEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualOAuth2ClientRegistrationTemplateEntity.getUuid());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Then calls {@link OAuth2MapperConfig#getBasic()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>(OAuth2ClientRegistrationTemplate)"
  })
  public void testNewOAuth2ClientRegistrationTemplateEntity_thenCallsGetBasic() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    clientRegistrationTemplate.setScope(new ArrayList<>());
    OAuth2MapperConfig mapperConfig = mock(OAuth2MapperConfig.class);
    when(mapperConfig.getBasic()).thenReturn(null);
    when(mapperConfig.getType()).thenReturn(MapperType.BASIC);
    doNothing().when(mapperConfig).setBasic(Mockito.<OAuth2BasicMapperConfig>any());
    mapperConfig.setBasic(null);

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate2 =
        new OAuth2ClientRegistrationTemplate(clientRegistrationTemplate);
    clientRegistrationTemplate2.setId(null);
    clientRegistrationTemplate2.setMapperConfig(mapperConfig);

    // Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity(clientRegistrationTemplate2);

    // Assert
    verify(mapperConfig).getBasic();
    verify(mapperConfig).getType();
    verify(mapperConfig).setBasic(isNull());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>(OAuth2ClientRegistrationTemplate)"
  })
  public void testNewOAuth2ClientRegistrationTemplateEntity_thenReturnAdditionalInfoIsNull() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    clientRegistrationTemplate.setScope(new ArrayList<>());

    // Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity(clientRegistrationTemplate);

    // Assert
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getAdditionalInfo());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getType());
    assertNull(actualOAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Then return AlwaysFullScreen.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>(OAuth2ClientRegistrationTemplate)"
  })
  public void testNewOAuth2ClientRegistrationTemplateEntity_thenReturnAlwaysFullScreen() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setId(null);
    OAuth2MapperConfigBuilder allowUserCreationResult =
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    clientRegistrationTemplate.setMapperConfig(mapperConfig);
    clientRegistrationTemplate.setScope(new ArrayList<>());

    // Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity(clientRegistrationTemplate);

    // Assert
    assertEquals(
        "Customer Name Pattern",
        actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern());
    assertEquals(
        "Default Dashboard Name",
        actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName());
    assertEquals("Doe", actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey());
    assertEquals("Jane", actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey());
    assertEquals(
        "Tenant Name Pattern", actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern());
    assertEquals(
        "jane.doe@example.org",
        actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey());
    assertEquals(
        TenantNameStrategyType.DOMAIN,
        actualOAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy());
    assertTrue(actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen());
  }

  /**
   * Test {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Then return not AlwaysFullScreen.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateEntity#OAuth2ClientRegistrationTemplateEntity(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OAuth2ClientRegistrationTemplateEntity.<init>(OAuth2ClientRegistrationTemplate)"
  })
  public void testNewOAuth2ClientRegistrationTemplateEntity_thenReturnNotAlwaysFullScreen() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setId(null);
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);
    OAuth2BasicMapperConfig basic =
        OAuth2BasicMapperConfig.builder()
            .alwaysFullScreen(false)
            .customerNamePattern("Customer Name Pattern")
            .defaultDashboardName("Default Dashboard Name")
            .emailAttributeKey("jane.doe@example.org")
            .firstNameAttributeKey("Jane")
            .lastNameAttributeKey("Doe")
            .tenantNamePattern("Tenant Name Pattern")
            .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
            .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom =
        OAuth2CustomMapperConfig.builder()
            .password("iloveyou")
            .sendToken(true)
            .url("https://example.org/example")
            .username("janedoe")
            .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    clientRegistrationTemplate.setMapperConfig(mapperConfig);
    clientRegistrationTemplate.setScope(new ArrayList<>());

    // Act
    OAuth2ClientRegistrationTemplateEntity actualOAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity(clientRegistrationTemplate);

    // Assert
    assertEquals(
        "Customer Name Pattern",
        actualOAuth2ClientRegistrationTemplateEntity.getCustomerNamePattern());
    assertEquals(
        "Default Dashboard Name",
        actualOAuth2ClientRegistrationTemplateEntity.getDefaultDashboardName());
    assertEquals("Doe", actualOAuth2ClientRegistrationTemplateEntity.getLastNameAttributeKey());
    assertEquals("Jane", actualOAuth2ClientRegistrationTemplateEntity.getFirstNameAttributeKey());
    assertEquals(
        "Tenant Name Pattern", actualOAuth2ClientRegistrationTemplateEntity.getTenantNamePattern());
    assertEquals(
        "jane.doe@example.org",
        actualOAuth2ClientRegistrationTemplateEntity.getEmailAttributeKey());
    assertEquals(
        TenantNameStrategyType.DOMAIN,
        actualOAuth2ClientRegistrationTemplateEntity.getTenantNameStrategy());
    assertFalse(actualOAuth2ClientRegistrationTemplateEntity.getAlwaysFullScreen());
  }

  /**
   * Test {@link OAuth2ClientRegistrationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientRegistrationTemplateEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ClientRegistrationTemplateEntity.toData()"
  })
  public void testToData_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    oAuth2ClientRegistrationTemplateEntity.setUuid(id);

    // Act
    OAuth2ClientRegistrationTemplate actualToDataResult =
        oAuth2ClientRegistrationTemplateEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", actualToDataResult.getName());
    assertEquals("42", actualToDataResult.getProviderId());
    assertEquals("ABC123", actualToDataResult.getAccessTokenUri());
    assertEquals(
        "Client Authentication Method", actualToDataResult.getClientAuthenticationMethod());
    assertEquals("Comment", actualToDataResult.getComment());
    assertEquals("Help Link", actualToDataResult.getHelpLink());
    assertEquals("JaneDoe", actualToDataResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", actualToDataResult.getJwkSetUri());
    assertEquals("Login Button Icon", actualToDataResult.getLoginButtonIcon());
    assertEquals("Login Button Label", actualToDataResult.getLoginButtonLabel());
    assertEquals("User Info Uri", actualToDataResult.getUserInfoUri());
    assertEquals("janedoe", actualToDataResult.getUserNameAttributeName());
    assertEquals(1, actualToDataResult.getScope().size());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }
}
