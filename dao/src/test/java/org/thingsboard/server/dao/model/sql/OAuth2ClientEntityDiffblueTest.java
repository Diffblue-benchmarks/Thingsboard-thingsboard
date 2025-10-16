/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.PlatformType;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class OAuth2ClientEntityDiffblueTest {
  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}, and {@link OAuth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientEntity#equals(Object)}
   *   <li>{@link OAuth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
    assertEquals(oAuth2ClientEntity.hashCode(), oAuth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}, and {@link OAuth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientEntity#equals(Object)}
   *   <li>{@link OAuth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(null);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(null);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
    assertEquals(oAuth2ClientEntity.hashCode(), oAuth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}, and {@link OAuth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientEntity#equals(Object)}
   *   <li>{@link OAuth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientEntity, oAuth2ClientEntity);
    int expectedHashCodeResult = oAuth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientEntity.hashCode());
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(false);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(null);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(null);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(false);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(null);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(false);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(null);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("Dr");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri(null);
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Dr");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod(null);
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("Dr");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId(null);
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Dr");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret(null);
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(3L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Dr");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern(null);
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Dr");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName(null);
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey(null);
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("John");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey(null);
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Dr");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri(null);
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey(null);
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Dr");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon(null);
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Dr");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel(null);
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("Dr");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual35() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword(null);
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual36() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Dr");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual37() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms(null);
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual38() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Dr");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual39() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope(null);
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual40() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(false);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual41() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(null);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual42() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(UUID.randomUUID());
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual43() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(null);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual44() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Dr");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual45() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern(null);
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual46() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(null);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual47() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual48() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Mr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual49() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle(null);
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual50() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("Dr");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual51() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri(null);
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual52() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(null);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual53() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual54() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("Dr");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual55() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl(null);
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual56() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("Dr");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual57() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri(null);
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual58() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("Dr");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual59() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName(null);
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual60() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("Dr");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual61() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername(null);
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity2.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity2.setClientId("42");
    oAuth2ClientEntity2.setClientSecret("Client Secret");
    oAuth2ClientEntity2.setCreatedTime(1L);
    oAuth2ClientEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity2.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity2.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity2.setPassword("iloveyou");
    oAuth2ClientEntity2.setPlatforms("Platforms");
    oAuth2ClientEntity2.setScope("Scope");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity2.setTitle("Dr");
    oAuth2ClientEntity2.setTokenUri("ABC123");
    oAuth2ClientEntity2.setType(MapperType.BASIC);
    oAuth2ClientEntity2.setUrl("https://example.org/example");
    oAuth2ClientEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity2.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity2.setUsername("janedoe");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, oAuth2ClientEntity2);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, null);
  }

  /**
   * Test {@link OAuth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientEntity.equals(Object)",
    "int OAuth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms("Platforms");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientEntity, "Different type to OAuth2ClientEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientEntity.<init>()",
    "Boolean OAuth2ClientEntity.getActivateUser()",
    "JsonNode OAuth2ClientEntity.getAdditionalInfo()",
    "Boolean OAuth2ClientEntity.getAllowUserCreation()",
    "Boolean OAuth2ClientEntity.getAlwaysFullScreen()",
    "String OAuth2ClientEntity.getAuthorizationUri()",
    "String OAuth2ClientEntity.getClientAuthenticationMethod()",
    "String OAuth2ClientEntity.getClientId()",
    "String OAuth2ClientEntity.getClientSecret()",
    "String OAuth2ClientEntity.getCustomerNamePattern()",
    "String OAuth2ClientEntity.getDefaultDashboardName()",
    "String OAuth2ClientEntity.getEmailAttributeKey()",
    "String OAuth2ClientEntity.getFirstNameAttributeKey()",
    "String OAuth2ClientEntity.getJwkSetUri()",
    "String OAuth2ClientEntity.getLastNameAttributeKey()",
    "String OAuth2ClientEntity.getLoginButtonIcon()",
    "String OAuth2ClientEntity.getLoginButtonLabel()",
    "String OAuth2ClientEntity.getPassword()",
    "String OAuth2ClientEntity.getPlatforms()",
    "String OAuth2ClientEntity.getScope()",
    "Boolean OAuth2ClientEntity.getSendToken()",
    "UUID OAuth2ClientEntity.getTenantId()",
    "String OAuth2ClientEntity.getTenantNamePattern()",
    "TenantNameStrategyType OAuth2ClientEntity.getTenantNameStrategy()",
    "String OAuth2ClientEntity.getTitle()",
    "String OAuth2ClientEntity.getTokenUri()",
    "MapperType OAuth2ClientEntity.getType()",
    "String OAuth2ClientEntity.getUrl()",
    "String OAuth2ClientEntity.getUserInfoUri()",
    "String OAuth2ClientEntity.getUserNameAttributeName()",
    "String OAuth2ClientEntity.getUsername()",
    "void OAuth2ClientEntity.setActivateUser(Boolean)",
    "void OAuth2ClientEntity.setAdditionalInfo(JsonNode)",
    "void OAuth2ClientEntity.setAllowUserCreation(Boolean)",
    "void OAuth2ClientEntity.setAlwaysFullScreen(Boolean)",
    "void OAuth2ClientEntity.setAuthorizationUri(String)",
    "void OAuth2ClientEntity.setClientAuthenticationMethod(String)",
    "void OAuth2ClientEntity.setClientId(String)",
    "void OAuth2ClientEntity.setClientSecret(String)",
    "void OAuth2ClientEntity.setCustomerNamePattern(String)",
    "void OAuth2ClientEntity.setDefaultDashboardName(String)",
    "void OAuth2ClientEntity.setEmailAttributeKey(String)",
    "void OAuth2ClientEntity.setFirstNameAttributeKey(String)",
    "void OAuth2ClientEntity.setJwkSetUri(String)",
    "void OAuth2ClientEntity.setLastNameAttributeKey(String)",
    "void OAuth2ClientEntity.setLoginButtonIcon(String)",
    "void OAuth2ClientEntity.setLoginButtonLabel(String)",
    "void OAuth2ClientEntity.setPassword(String)",
    "void OAuth2ClientEntity.setPlatforms(String)",
    "void OAuth2ClientEntity.setScope(String)",
    "void OAuth2ClientEntity.setSendToken(Boolean)",
    "void OAuth2ClientEntity.setTenantId(UUID)",
    "void OAuth2ClientEntity.setTenantNamePattern(String)",
    "void OAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType)",
    "void OAuth2ClientEntity.setTitle(String)",
    "void OAuth2ClientEntity.setTokenUri(String)",
    "void OAuth2ClientEntity.setType(MapperType)",
    "void OAuth2ClientEntity.setUrl(String)",
    "void OAuth2ClientEntity.setUserInfoUri(String)",
    "void OAuth2ClientEntity.setUserNameAttributeName(String)",
    "void OAuth2ClientEntity.setUsername(String)",
    "String OAuth2ClientEntity.toString()"
  })
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
    UUID tenantId = ModelConstants.NULL_UUID;
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
    String actualClientAuthenticationMethod =
        actualOAuth2ClientEntity.getClientAuthenticationMethod();
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
    TenantNameStrategyType actualTenantNameStrategy =
        actualOAuth2ClientEntity.getTenantNameStrategy();
    String actualTitle = actualOAuth2ClientEntity.getTitle();
    String actualTokenUri = actualOAuth2ClientEntity.getTokenUri();
    MapperType actualType = actualOAuth2ClientEntity.getType();
    String actualUrl = actualOAuth2ClientEntity.getUrl();
    String actualUserInfoUri = actualOAuth2ClientEntity.getUserInfoUri();
    String actualUserNameAttributeName = actualOAuth2ClientEntity.getUserNameAttributeName();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("42", actualClientId);
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
        "OAuth2ClientEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, clientId=42, clientSecret=Client"
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
    assertEquals("janedoe", actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getId());
    assertNull(actualOAuth2ClientEntity.getUuid());
    assertEquals(0L, actualOAuth2ClientEntity.getCreatedTime());
    assertEquals(MapperType.BASIC, actualType);
    assertEquals(TenantNameStrategyType.DOMAIN, actualTenantNameStrategy);
    assertTrue(actualActivateUser);
    assertTrue(actualAllowUserCreation);
    assertTrue(actualAlwaysFullScreen);
    assertTrue(actualSendToken);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Scope is {@code 42,foo}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_givenArrayListAdd42_thenReturnScopeIs42Foo() {
    // Arrange
    ArrayList<String> scope = new ArrayList<>();
    scope.add("42");
    scope.add("foo");

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setScope(scope);

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getPlatforms());
    assertEquals("42,foo", actualOAuth2ClientEntity.getScope());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Scope is {@code 42,42,foo}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_givenArrayListAdd42_thenReturnScopeIs4242Foo() {
    // Arrange
    ArrayList<String> scope = new ArrayList<>();
    scope.add("42");
    scope.add("42");
    scope.add("foo");

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setScope(scope);

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getPlatforms());
    assertEquals("42,42,foo", actualOAuth2ClientEntity.getScope());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Platforms is empty string.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_givenArrayList_thenReturnPlatformsIsEmptyString() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setScope(new ArrayList<>());

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getPlatforms());
    assertEquals("", actualOAuth2ClientEntity.getScope());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_givenSystem_tenant() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setScope(new ArrayList<>());
    oAuth2Client.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getPlatforms());
    assertEquals("", actualOAuth2ClientEntity.getScope());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Then return ActivateUser.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_thenReturnActivateUser() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

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
    oAuth2Client.setMapperConfig(
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
    oAuth2Client.setScope(new ArrayList<>());

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2ClientEntity.getCustomerNamePattern());
    assertEquals("Default Dashboard Name", actualOAuth2ClientEntity.getDefaultDashboardName());
    assertEquals("Doe", actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertEquals("Jane", actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertEquals("Tenant Name Pattern", actualOAuth2ClientEntity.getTenantNamePattern());
    assertEquals("https://example.org/example", actualOAuth2ClientEntity.getUrl());
    assertEquals("iloveyou", actualOAuth2ClientEntity.getPassword());
    assertEquals("jane.doe@example.org", actualOAuth2ClientEntity.getEmailAttributeKey());
    assertEquals("janedoe", actualOAuth2ClientEntity.getUsername());
    assertEquals(MapperType.BASIC, actualOAuth2ClientEntity.getType());
    assertEquals(TenantNameStrategyType.DOMAIN, actualOAuth2ClientEntity.getTenantNameStrategy());
    assertTrue(actualOAuth2ClientEntity.getActivateUser());
    assertTrue(actualOAuth2ClientEntity.getAllowUserCreation());
    assertTrue(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertTrue(actualOAuth2ClientEntity.getSendToken());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Then return not ActivateUser.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_thenReturnNotActivateUser() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

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
    oAuth2Client.setMapperConfig(
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
    oAuth2Client.setScope(new ArrayList<>());

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("Customer Name Pattern", actualOAuth2ClientEntity.getCustomerNamePattern());
    assertEquals("Default Dashboard Name", actualOAuth2ClientEntity.getDefaultDashboardName());
    assertEquals("Doe", actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertEquals("Jane", actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertEquals("Tenant Name Pattern", actualOAuth2ClientEntity.getTenantNamePattern());
    assertEquals("https://example.org/example", actualOAuth2ClientEntity.getUrl());
    assertEquals("iloveyou", actualOAuth2ClientEntity.getPassword());
    assertEquals("jane.doe@example.org", actualOAuth2ClientEntity.getEmailAttributeKey());
    assertEquals("janedoe", actualOAuth2ClientEntity.getUsername());
    assertEquals(MapperType.BASIC, actualOAuth2ClientEntity.getType());
    assertEquals(TenantNameStrategyType.DOMAIN, actualOAuth2ClientEntity.getTenantNameStrategy());
    assertFalse(actualOAuth2ClientEntity.getActivateUser());
    assertTrue(actualOAuth2ClientEntity.getAllowUserCreation());
    assertTrue(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertTrue(actualOAuth2ClientEntity.getSendToken());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Then return Platforms is {@code ANDROID,WEB}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_thenReturnPlatformsIsAndroidWeb() {
    // Arrange
    ArrayList<PlatformType> platforms = new ArrayList<>();
    platforms.add(PlatformType.ANDROID);
    platforms.add(PlatformType.WEB);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setPlatforms(platforms);
    oAuth2Client.setScope(new ArrayList<>());

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getScope());
    assertEquals("ANDROID,WEB", actualOAuth2ClientEntity.getPlatforms());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>Then return Platforms is {@code IOS,ANDROID,WEB}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_thenReturnPlatformsIsIosAndroidWeb() {
    // Arrange
    ArrayList<PlatformType> platforms = new ArrayList<>();
    platforms.add(PlatformType.IOS);
    platforms.add(PlatformType.ANDROID);
    platforms.add(PlatformType.WEB);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setPlatforms(platforms);
    oAuth2Client.setScope(new ArrayList<>());

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getScope());
    assertEquals("IOS,ANDROID,WEB", actualOAuth2ClientEntity.getPlatforms());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}.
   *
   * <ul>
   *   <li>When {@link OAuth2Client#OAuth2Client()} Platforms is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#OAuth2ClientEntity(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientEntity.<init>(OAuth2Client)"})
  public void testNewOAuth2ClientEntity_whenOAuth2ClientPlatformsIsArrayList() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setPlatforms(new ArrayList<>());
    oAuth2Client.setScope(new ArrayList<>());

    // Act
    OAuth2ClientEntity actualOAuth2ClientEntity = new OAuth2ClientEntity(oAuth2Client);

    // Assert
    assertEquals("", actualOAuth2ClientEntity.getPlatforms());
    assertEquals("", actualOAuth2ClientEntity.getScope());
    assertNull(actualOAuth2ClientEntity.getActivateUser());
    assertNull(actualOAuth2ClientEntity.getAllowUserCreation());
    assertNull(actualOAuth2ClientEntity.getAlwaysFullScreen());
    assertNull(actualOAuth2ClientEntity.getSendToken());
    assertNull(actualOAuth2ClientEntity.getCustomerNamePattern());
    assertNull(actualOAuth2ClientEntity.getDefaultDashboardName());
    assertNull(actualOAuth2ClientEntity.getEmailAttributeKey());
    assertNull(actualOAuth2ClientEntity.getFirstNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getLastNameAttributeKey());
    assertNull(actualOAuth2ClientEntity.getPassword());
    assertNull(actualOAuth2ClientEntity.getTenantNamePattern());
    assertNull(actualOAuth2ClientEntity.getUrl());
    assertNull(actualOAuth2ClientEntity.getUsername());
    assertNull(actualOAuth2ClientEntity.getType());
    assertNull(actualOAuth2ClientEntity.getTenantNameStrategy());
  }

  /**
   * Test {@link OAuth2ClientEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} Platforms is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2Client OAuth2ClientEntity.toData()"})
  public void testToData_givenOAuth2ClientEntityPlatformsIsComma() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setPlatforms(",");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(false);
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAllowUserCreation(false);

    // Act
    OAuth2Client actualToDataResult = oAuth2ClientEntity.toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalInfo());
    assertNull(actualToDataResult.getAccessTokenUri());
    assertNull(actualToDataResult.getAuthorizationUri());
    assertNull(actualToDataResult.getClientAuthenticationMethod());
    assertNull(actualToDataResult.getClientId());
    assertNull(actualToDataResult.getClientSecret());
    assertNull(actualToDataResult.getJwkSetUri());
    assertNull(actualToDataResult.getLoginButtonIcon());
    assertNull(actualToDataResult.getLoginButtonLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUserInfoUri());
    assertNull(actualToDataResult.getUserNameAttributeName());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} Platforms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2Client OAuth2ClientEntity.toData()"})
  public void testToData_givenOAuth2ClientEntityPlatformsIsNull() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setPlatforms(null);

    // Act
    OAuth2Client actualToDataResult = oAuth2ClientEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", actualToDataResult.getClientId());
    assertEquals("ABC123", actualToDataResult.getAccessTokenUri());
    assertEquals(
        "Client Authentication Method", actualToDataResult.getClientAuthenticationMethod());
    assertEquals("Client Secret", actualToDataResult.getClientSecret());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("JaneDoe", actualToDataResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", actualToDataResult.getJwkSetUri());
    assertEquals("Login Button Icon", actualToDataResult.getLoginButtonIcon());
    assertEquals("Login Button Label", actualToDataResult.getLoginButtonLabel());
    assertEquals("User Info Uri", actualToDataResult.getUserInfoUri());
    assertEquals("janedoe", actualToDataResult.getUserNameAttributeName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} Scope is {@code Scope}.
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2Client OAuth2ClientEntity.toData()"})
  public void testToData_givenOAuth2ClientEntityScopeIsScope_thenReturnAdditionalInfoIsNull() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(false);
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAllowUserCreation(false);

    // Act
    OAuth2Client actualToDataResult = oAuth2ClientEntity.toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalInfo());
    assertNull(actualToDataResult.getAccessTokenUri());
    assertNull(actualToDataResult.getAuthorizationUri());
    assertNull(actualToDataResult.getClientAuthenticationMethod());
    assertNull(actualToDataResult.getClientId());
    assertNull(actualToDataResult.getClientSecret());
    assertNull(actualToDataResult.getJwkSetUri());
    assertNull(actualToDataResult.getLoginButtonIcon());
    assertNull(actualToDataResult.getLoginButtonLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUserInfoUri());
    assertNull(actualToDataResult.getUserNameAttributeName());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} Type is {@link MapperType#APPLE}.
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2Client OAuth2ClientEntity.toData()"})
  public void testToData_givenOAuth2ClientEntityTypeIsApple_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setType(MapperType.APPLE);
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setPlatforms("");

    // Act
    OAuth2Client actualToDataResult = oAuth2ClientEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", actualToDataResult.getClientId());
    assertEquals("ABC123", actualToDataResult.getAccessTokenUri());
    assertEquals(
        "Client Authentication Method", actualToDataResult.getClientAuthenticationMethod());
    assertEquals("Client Secret", actualToDataResult.getClientSecret());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("JaneDoe", actualToDataResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", actualToDataResult.getJwkSetUri());
    assertEquals("Login Button Icon", actualToDataResult.getLoginButtonIcon());
    assertEquals("Login Button Label", actualToDataResult.getLoginButtonLabel());
    assertEquals("User Info Uri", actualToDataResult.getUserInfoUri());
    assertEquals("janedoe", actualToDataResult.getUserNameAttributeName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} Type is {@link MapperType#BASIC}.
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2Client OAuth2ClientEntity.toData()"})
  public void testToData_givenOAuth2ClientEntityTypeIsBasic_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setPlatforms("");

    // Act
    OAuth2Client actualToDataResult = oAuth2ClientEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", actualToDataResult.getClientId());
    assertEquals("ABC123", actualToDataResult.getAccessTokenUri());
    assertEquals(
        "Client Authentication Method", actualToDataResult.getClientAuthenticationMethod());
    assertEquals("Client Secret", actualToDataResult.getClientSecret());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("JaneDoe", actualToDataResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", actualToDataResult.getJwkSetUri());
    assertEquals("Login Button Icon", actualToDataResult.getLoginButtonIcon());
    assertEquals("Login Button Label", actualToDataResult.getLoginButtonLabel());
    assertEquals("User Info Uri", actualToDataResult.getUserInfoUri());
    assertEquals("janedoe", actualToDataResult.getUserNameAttributeName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} Type is {@link MapperType#GITHUB}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2Client OAuth2ClientEntity.toData()"})
  public void testToData_givenOAuth2ClientEntityTypeIsGithub() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setType(MapperType.GITHUB);
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setPlatforms("");

    // Act
    OAuth2Client actualToDataResult = oAuth2ClientEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", actualToDataResult.getClientId());
    assertEquals("ABC123", actualToDataResult.getAccessTokenUri());
    assertEquals(
        "Client Authentication Method", actualToDataResult.getClientAuthenticationMethod());
    assertEquals("Client Secret", actualToDataResult.getClientSecret());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("JaneDoe", actualToDataResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", actualToDataResult.getJwkSetUri());
    assertEquals("Login Button Icon", actualToDataResult.getLoginButtonIcon());
    assertEquals("Login Button Label", actualToDataResult.getLoginButtonLabel());
    assertEquals("User Info Uri", actualToDataResult.getUserInfoUri());
    assertEquals("janedoe", actualToDataResult.getUserNameAttributeName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }
}
