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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig.OAuth2CustomMapperConfigBuilder;

@ContextConfiguration(classes = {OAuth2CustomMapperConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class OAuth2CustomMapperConfigDiffblueTest {
  @Autowired
  private OAuth2CustomMapperConfigBuilder oAuth2CustomMapperConfigBuilder;

  /**
   * Test {@link OAuth2CustomMapperConfig#equals(Object)}, and {@link OAuth2CustomMapperConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2CustomMapperConfig#equals(Object)}
   *   <li>{@link OAuth2CustomMapperConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2CustomMapperConfig.equals(Object)", "int OAuth2CustomMapperConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2CustomMapperConfig buildResult = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2CustomMapperConfig buildResult2 = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link OAuth2CustomMapperConfig#equals(Object)}, and {@link OAuth2CustomMapperConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2CustomMapperConfig#equals(Object)}
   *   <li>{@link OAuth2CustomMapperConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2CustomMapperConfig.equals(Object)", "int OAuth2CustomMapperConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2CustomMapperConfig buildResult = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link OAuth2CustomMapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2CustomMapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2CustomMapperConfig.equals(Object)", "int OAuth2CustomMapperConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2CustomMapperConfigBuilder oAuth2CustomMapperConfigBuilder = mock(OAuth2CustomMapperConfigBuilder.class);
    when(oAuth2CustomMapperConfigBuilder.password(Mockito.<String>any()))
        .thenReturn(OAuth2CustomMapperConfig.builder());
    OAuth2CustomMapperConfig buildResult = oAuth2CustomMapperConfigBuilder.password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2CustomMapperConfig buildResult2 = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link OAuth2CustomMapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2CustomMapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2CustomMapperConfig.equals(Object)", "int OAuth2CustomMapperConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2CustomMapperConfigBuilder oAuth2CustomMapperConfigBuilder = mock(OAuth2CustomMapperConfigBuilder.class);
    when(oAuth2CustomMapperConfigBuilder.sendToken(anyBoolean())).thenReturn(OAuth2CustomMapperConfig.builder());
    OAuth2CustomMapperConfigBuilder oAuth2CustomMapperConfigBuilder2 = mock(OAuth2CustomMapperConfigBuilder.class);
    when(oAuth2CustomMapperConfigBuilder2.password(Mockito.<String>any())).thenReturn(oAuth2CustomMapperConfigBuilder);
    OAuth2CustomMapperConfig buildResult = oAuth2CustomMapperConfigBuilder2.password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2CustomMapperConfig buildResult2 = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link OAuth2CustomMapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2CustomMapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2CustomMapperConfig.equals(Object)", "int OAuth2CustomMapperConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2CustomMapperConfig buildResult = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link OAuth2CustomMapperConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2CustomMapperConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2CustomMapperConfig.equals(Object)", "int OAuth2CustomMapperConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2CustomMapperConfig buildResult = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to OAuth2CustomMapperConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2CustomMapperConfig#OAuth2CustomMapperConfig(String, String, String, boolean)}
   *   <li>{@link OAuth2CustomMapperConfig#toString()}
   *   <li>{@link OAuth2CustomMapperConfig#getPassword()}
   *   <li>{@link OAuth2CustomMapperConfig#getUrl()}
   *   <li>{@link OAuth2CustomMapperConfig#getUsername()}
   *   <li>{@link OAuth2CustomMapperConfig#isSendToken()}
   *   <li>{@link OAuth2CustomMapperConfig#toBuilder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OAuth2CustomMapperConfig.<init>(String, String, String, boolean)",
      "String OAuth2CustomMapperConfig.getPassword()", "String OAuth2CustomMapperConfig.getUrl()",
      "String OAuth2CustomMapperConfig.getUsername()", "boolean OAuth2CustomMapperConfig.isSendToken()",
      "OAuth2CustomMapperConfigBuilder OAuth2CustomMapperConfig.toBuilder()",
      "String OAuth2CustomMapperConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2CustomMapperConfig actualOAuth2CustomMapperConfig = new OAuth2CustomMapperConfig(
        "https://example.org/example", "janedoe", "iloveyou", true);
    String actualToStringResult = actualOAuth2CustomMapperConfig.toString();
    String actualPassword = actualOAuth2CustomMapperConfig.getPassword();
    String actualUrl = actualOAuth2CustomMapperConfig.getUrl();
    String actualUsername = actualOAuth2CustomMapperConfig.getUsername();
    boolean actualIsSendTokenResult = actualOAuth2CustomMapperConfig.isSendToken();
    actualOAuth2CustomMapperConfig.toBuilder();

    // Assert
    assertEquals("OAuth2CustomMapperConfig(url=https://example.org/example, username=janedoe, sendToken=true)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertTrue(actualIsSendTokenResult);
  }

  /**
   * Test OAuth2CustomMapperConfigBuilder {@link OAuth2CustomMapperConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2CustomMapperConfigBuilder#build()}
   *   <li>{@link OAuth2CustomMapperConfigBuilder#password(String)}
   *   <li>{@link OAuth2CustomMapperConfigBuilder#sendToken(boolean)}
   *   <li>{@link OAuth2CustomMapperConfigBuilder#url(String)}
   *   <li>{@link OAuth2CustomMapperConfigBuilder#username(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test OAuth2CustomMapperConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OAuth2CustomMapperConfigBuilder.<init>()",
      "OAuth2CustomMapperConfig OAuth2CustomMapperConfigBuilder.build()",
      "OAuth2CustomMapperConfigBuilder OAuth2CustomMapperConfigBuilder.password(String)",
      "OAuth2CustomMapperConfigBuilder OAuth2CustomMapperConfigBuilder.sendToken(boolean)",
      "String OAuth2CustomMapperConfigBuilder.toString()",
      "OAuth2CustomMapperConfigBuilder OAuth2CustomMapperConfigBuilder.url(String)",
      "OAuth2CustomMapperConfigBuilder OAuth2CustomMapperConfigBuilder.username(String)"})
  void testOAuth2CustomMapperConfigBuilderBuild() {
    // Arrange and Act
    OAuth2CustomMapperConfig actualBuildResult = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();

    // Assert
    assertEquals("https://example.org/example", actualBuildResult.getUrl());
    assertEquals("iloveyou", actualBuildResult.getPassword());
    assertEquals("janedoe", actualBuildResult.getUsername());
    assertTrue(actualBuildResult.isSendToken());
  }
}
