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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;

class OAuth2ClientDiffblueTest {
  /**
   * Test {@link OAuth2Client#OAuth2Client(OAuth2Client)}.
   *
   * <p>Method under test: {@link OAuth2Client#OAuth2Client(OAuth2Client)}
   */
  @Test
  @DisplayName("Test new OAuth2Client(OAuth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2Client.<init>(OAuth2Client)"})
  void testNewOAuth2Client() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    // Act
    OAuth2Client actualOAuth2Client = new OAuth2Client(oAuth2Client);

    // Assert
    assertEquals(oAuth2Client, actualOAuth2Client);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}, and {@link OAuth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Client#equals(Object)}
   *   <li>{@link OAuth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    OAuth2Client oAuth2Client2 = new OAuth2Client();

    // Act and Assert
    assertEquals(oAuth2Client, oAuth2Client2);
    assertEquals(oAuth2Client.hashCode(), oAuth2Client2.hashCode());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}, and {@link OAuth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Client#equals(Object)}
   *   <li>{@link OAuth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    // Act and Assert
    assertEquals(oAuth2Client, oAuth2Client);
    int expectedHashCodeResult = oAuth2Client.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Client.hashCode());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Client(), 1);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setTitle("Dr");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setClientId("42");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setClientSecret("Client Secret");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setAuthorizationUri("JaneDoe");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setAccessTokenUri("ABC123");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setScope(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setUserInfoUri("User Info Uri");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setUserNameAttributeName("janedoe");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setJwkSetUri("Jwk Set Uri");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setClientAuthenticationMethod("Client Authentication Method");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setLoginButtonLabel("Login Button Label");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setLoginButtonIcon("Login Button Icon");

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setPlatforms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setAdditionalInfo(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(oAuth2Client, new OAuth2Client());
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();

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
    oAuth2Client2.setMapperConfig(
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

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setClientId("42");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setClientSecret("Client Secret");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setAuthorizationUri("JaneDoe");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setAccessTokenUri("ABC123");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setScope(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setUserInfoUri("User Info Uri");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setUserNameAttributeName("janedoe");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setJwkSetUri("Jwk Set Uri");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setClientAuthenticationMethod("Client Authentication Method");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setLoginButtonLabel("Login Button Label");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setLoginButtonIcon("Login Button Icon");

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setPlatforms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2Client oAuth2Client2 = new OAuth2Client();
    oAuth2Client2.setAdditionalInfo(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(oAuth2Client, oAuth2Client2);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Client(), null);
  }

  /**
   * Test {@link OAuth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Client.equals(Object)", "int OAuth2Client.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Client(), "Different type to OAuth2Client");
  }
}
