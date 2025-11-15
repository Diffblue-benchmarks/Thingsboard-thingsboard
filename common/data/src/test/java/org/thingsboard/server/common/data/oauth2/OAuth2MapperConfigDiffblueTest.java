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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
  @Autowired
  private OAuth2MapperConfigBuilder oAuth2MapperConfigBuilder;

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}, and {@link OAuth2MapperConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2MapperConfig#equals(Object)}
   *   <li>{@link OAuth2MapperConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2MapperConfig.equals(Object)", "int OAuth2MapperConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    OAuth2MapperConfigBuilder allowUserCreationResult2 = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult2 = allowUserCreationResult2.basic(basic2);
    OAuth2CustomMapperConfig custom2 = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult2 = basicResult2.custom(custom2).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}, and {@link OAuth2MapperConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2MapperConfig#equals(Object)}
   *   <li>{@link OAuth2MapperConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2MapperConfig.equals(Object)", "int OAuth2MapperConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2MapperConfig.equals(Object)", "int OAuth2MapperConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2MapperConfigBuilder oAuth2MapperConfigBuilder = mock(OAuth2MapperConfigBuilder.class);
    when(oAuth2MapperConfigBuilder.activateUser(anyBoolean())).thenReturn(OAuth2MapperConfig.builder());
    OAuth2MapperConfigBuilder allowUserCreationResult = oAuth2MapperConfigBuilder.activateUser(true)
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
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    OAuth2MapperConfigBuilder allowUserCreationResult2 = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult2 = allowUserCreationResult2.basic(basic2);
    OAuth2CustomMapperConfig custom2 = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult2 = basicResult2.custom(custom2).type(MapperType.BASIC).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2MapperConfig.equals(Object)", "int OAuth2MapperConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2MapperConfigBuilder oAuth2MapperConfigBuilder = mock(OAuth2MapperConfigBuilder.class);
    when(oAuth2MapperConfigBuilder.allowUserCreation(anyBoolean())).thenReturn(OAuth2MapperConfig.builder());
    OAuth2MapperConfigBuilder oAuth2MapperConfigBuilder2 = mock(OAuth2MapperConfigBuilder.class);
    when(oAuth2MapperConfigBuilder2.activateUser(anyBoolean())).thenReturn(oAuth2MapperConfigBuilder);
    OAuth2MapperConfigBuilder allowUserCreationResult = oAuth2MapperConfigBuilder2.activateUser(true)
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
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    OAuth2MapperConfigBuilder allowUserCreationResult2 = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult2 = allowUserCreationResult2.basic(basic2);
    OAuth2CustomMapperConfig custom2 = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult2 = basicResult2.custom(custom2).type(MapperType.BASIC).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2MapperConfig.equals(Object)", "int OAuth2MapperConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link OAuth2MapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2MapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2MapperConfig.equals(Object)", "int OAuth2MapperConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to OAuth2MapperConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2MapperConfig#OAuth2MapperConfig(boolean, boolean, MapperType, OAuth2BasicMapperConfig, OAuth2CustomMapperConfig)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void OAuth2MapperConfig.<init>(boolean, boolean, MapperType, OAuth2BasicMapperConfig, OAuth2CustomMapperConfig)",
      "OAuth2BasicMapperConfig OAuth2MapperConfig.getBasic()",
      "OAuth2CustomMapperConfig OAuth2MapperConfig.getCustom()", "MapperType OAuth2MapperConfig.getType()",
      "boolean OAuth2MapperConfig.isActivateUser()", "boolean OAuth2MapperConfig.isAllowUserCreation()",
      "void OAuth2MapperConfig.setActivateUser(boolean)", "void OAuth2MapperConfig.setAllowUserCreation(boolean)",
      "void OAuth2MapperConfig.setBasic(OAuth2BasicMapperConfig)",
      "void OAuth2MapperConfig.setCustom(OAuth2CustomMapperConfig)", "void OAuth2MapperConfig.setType(MapperType)",
      "OAuth2MapperConfigBuilder OAuth2MapperConfig.toBuilder()", "String OAuth2MapperConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange
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
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act
    OAuth2MapperConfig actualOAuth2MapperConfig = new OAuth2MapperConfig(true, true, MapperType.BASIC, basic, custom);
    actualOAuth2MapperConfig.setActivateUser(true);
    actualOAuth2MapperConfig.setAllowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
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
    OAuth2CustomMapperConfig custom2 = OAuth2CustomMapperConfig.builder()
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
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OAuth2MapperConfigBuilder.<init>()",
      "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.activateUser(boolean)",
      "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.allowUserCreation(boolean)",
      "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.basic(OAuth2BasicMapperConfig)",
      "OAuth2MapperConfig OAuth2MapperConfigBuilder.build()",
      "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.custom(OAuth2CustomMapperConfig)",
      "String OAuth2MapperConfigBuilder.toString()",
      "OAuth2MapperConfigBuilder OAuth2MapperConfigBuilder.type(MapperType)"})
  void testOAuth2MapperConfigBuilderBuild() {
    // Arrange
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

    // Act
    OAuth2MapperConfig actualBuildResult = basicResult.custom(custom).type(MapperType.BASIC).build();

    // Assert
    OAuth2BasicMapperConfig basic2 = actualBuildResult.getBasic();
    assertEquals("Customer Name Pattern", basic2.getCustomerNamePattern());
    assertEquals("Default Dashboard Name", basic2.getDefaultDashboardName());
    assertEquals("Doe", basic2.getLastNameAttributeKey());
    assertEquals("Jane", basic2.getFirstNameAttributeKey());
    assertEquals("Tenant Name Pattern", basic2.getTenantNamePattern());
    OAuth2CustomMapperConfig custom2 = actualBuildResult.getCustom();
    assertEquals("https://example.org/example", custom2.getUrl());
    assertEquals("iloveyou", custom2.getPassword());
    assertEquals("jane.doe@example.org", basic2.getEmailAttributeKey());
    assertEquals("janedoe", custom2.getUsername());
    assertEquals(MapperType.BASIC, actualBuildResult.getType());
    assertEquals(TenantNameStrategyType.DOMAIN, basic2.getTenantNameStrategy());
    assertTrue(basic2.isAlwaysFullScreen());
    assertTrue(custom2.isSendToken());
    assertTrue(actualBuildResult.isActivateUser());
    assertTrue(actualBuildResult.isAllowUserCreation());
  }
}
