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
package org.thingsboard.server.common.data.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class OAuth2BasicMapperConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2BasicMapperConfig#equals(Object)}
   *   <li>{@link OAuth2BasicMapperConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2BasicMapperConfig buildResult = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2BasicMapperConfig buildResult2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2BasicMapperConfig#equals(Object)}
   *   <li>{@link OAuth2BasicMapperConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2BasicMapperConfig buildResult = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link OAuth2BasicMapperConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder oAuth2BasicMapperConfigBuilder = mock(
        OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder.class);
    when(oAuth2BasicMapperConfigBuilder.alwaysFullScreen(anyBoolean())).thenReturn(OAuth2BasicMapperConfig.builder());
    OAuth2BasicMapperConfig buildResult = oAuth2BasicMapperConfigBuilder.alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2BasicMapperConfig buildResult2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link OAuth2BasicMapperConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2BasicMapperConfig buildResult = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link OAuth2BasicMapperConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2BasicMapperConfig buildResult = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to OAuth2BasicMapperConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OAuth2BasicMapperConfig#OAuth2BasicMapperConfig(String, String, String, TenantNameStrategyType, String, String, String, boolean)}
   *   <li>{@link OAuth2BasicMapperConfig#toString()}
   *   <li>{@link OAuth2BasicMapperConfig#getCustomerNamePattern()}
   *   <li>{@link OAuth2BasicMapperConfig#getDefaultDashboardName()}
   *   <li>{@link OAuth2BasicMapperConfig#getEmailAttributeKey()}
   *   <li>{@link OAuth2BasicMapperConfig#getFirstNameAttributeKey()}
   *   <li>{@link OAuth2BasicMapperConfig#getLastNameAttributeKey()}
   *   <li>{@link OAuth2BasicMapperConfig#getTenantNamePattern()}
   *   <li>{@link OAuth2BasicMapperConfig#getTenantNameStrategy()}
   *   <li>{@link OAuth2BasicMapperConfig#isAlwaysFullScreen()}
   *   <li>{@link OAuth2BasicMapperConfig#toBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2BasicMapperConfig actualOAuth2BasicMapperConfig = new OAuth2BasicMapperConfig("jane.doe@example.org", "Jane",
        "Doe", TenantNameStrategyType.DOMAIN, "Tenant Name Pattern", "Customer Name Pattern", "Default Dashboard Name",
        true);
    String actualToStringResult = actualOAuth2BasicMapperConfig.toString();
    String actualCustomerNamePattern = actualOAuth2BasicMapperConfig.getCustomerNamePattern();
    String actualDefaultDashboardName = actualOAuth2BasicMapperConfig.getDefaultDashboardName();
    String actualEmailAttributeKey = actualOAuth2BasicMapperConfig.getEmailAttributeKey();
    String actualFirstNameAttributeKey = actualOAuth2BasicMapperConfig.getFirstNameAttributeKey();
    String actualLastNameAttributeKey = actualOAuth2BasicMapperConfig.getLastNameAttributeKey();
    String actualTenantNamePattern = actualOAuth2BasicMapperConfig.getTenantNamePattern();
    TenantNameStrategyType actualTenantNameStrategy = actualOAuth2BasicMapperConfig.getTenantNameStrategy();
    boolean actualIsAlwaysFullScreenResult = actualOAuth2BasicMapperConfig.isAlwaysFullScreen();
    actualOAuth2BasicMapperConfig.toBuilder();

    // Assert
    assertEquals("Customer Name Pattern", actualCustomerNamePattern);
    assertEquals("Default Dashboard Name", actualDefaultDashboardName);
    assertEquals("Doe", actualLastNameAttributeKey);
    assertEquals("Jane", actualFirstNameAttributeKey);
    assertEquals("OAuth2BasicMapperConfig(emailAttributeKey=jane.doe@example.org, firstNameAttributeKey=Jane,"
        + " lastNameAttributeKey=Doe, tenantNameStrategy=DOMAIN, tenantNamePattern=Tenant Name Pattern,"
        + " customerNamePattern=Customer Name Pattern, defaultDashboardName=Default Dashboard Name, alwaysFullScreen"
        + "=true)", actualToStringResult);
    assertEquals("Tenant Name Pattern", actualTenantNamePattern);
    assertEquals("jane.doe@example.org", actualEmailAttributeKey);
    assertEquals(TenantNameStrategyType.DOMAIN, actualTenantNameStrategy);
    assertTrue(actualIsAlwaysFullScreenResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#build()}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#alwaysFullScreen(boolean)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#customerNamePattern(String)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#defaultDashboardName(String)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#emailAttributeKey(String)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#firstNameAttributeKey(String)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#lastNameAttributeKey(String)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#tenantNamePattern(String)}
   *   <li>
   * {@link OAuth2BasicMapperConfig.OAuth2BasicMapperConfigBuilder#tenantNameStrategy(TenantNameStrategyType)}
   * </ul>
   */
  @Test
  void testOAuth2BasicMapperConfigBuilderBuild() {
    // Arrange and Act
    OAuth2BasicMapperConfig actualBuildResult = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();

    // Assert
    assertEquals("Customer Name Pattern", actualBuildResult.getCustomerNamePattern());
    assertEquals("Default Dashboard Name", actualBuildResult.getDefaultDashboardName());
    assertEquals("Doe", actualBuildResult.getLastNameAttributeKey());
    assertEquals("Jane", actualBuildResult.getFirstNameAttributeKey());
    assertEquals("Tenant Name Pattern", actualBuildResult.getTenantNamePattern());
    assertEquals("jane.doe@example.org", actualBuildResult.getEmailAttributeKey());
    assertEquals(TenantNameStrategyType.DOMAIN, actualBuildResult.getTenantNameStrategy());
    assertTrue(actualBuildResult.isAlwaysFullScreen());
  }
}
