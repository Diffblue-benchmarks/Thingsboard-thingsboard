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
package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IosConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#equals(Object)}
   *   <li>{@link IosConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#equals(Object)}
   *   <li>{@link IosConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IosConfig.IosConfigBuilder iosConfigBuilder = mock(IosConfig.IosConfigBuilder.class);
    when(iosConfigBuilder.appId(Mockito.<String>any())).thenReturn(IosConfig.builder());
    IosConfig buildResult = iosConfigBuilder.appId("42").enabled(true).storeLink("Store Link").build();
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IosConfig.IosConfigBuilder iosConfigBuilder = mock(IosConfig.IosConfigBuilder.class);
    when(iosConfigBuilder.enabled(anyBoolean())).thenReturn(IosConfig.builder());
    IosConfig.IosConfigBuilder iosConfigBuilder2 = mock(IosConfig.IosConfigBuilder.class);
    when(iosConfigBuilder2.appId(Mockito.<String>any())).thenReturn(iosConfigBuilder);
    IosConfig buildResult = iosConfigBuilder2.appId("42").enabled(true).storeLink("Store Link").build();
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to IosConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#IosConfig()}
   *   <li>{@link IosConfig#setAppId(String)}
   *   <li>{@link IosConfig#setEnabled(boolean)}
   *   <li>{@link IosConfig#setStoreLink(String)}
   *   <li>{@link IosConfig#toString()}
   *   <li>{@link IosConfig#getAppId()}
   *   <li>{@link IosConfig#getStoreLink()}
   *   <li>{@link IosConfig#isEnabled()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    IosConfig actualIosConfig = new IosConfig();
    actualIosConfig.setAppId("42");
    actualIosConfig.setEnabled(true);
    actualIosConfig.setStoreLink("Store Link");
    String actualToStringResult = actualIosConfig.toString();
    String actualAppId = actualIosConfig.getAppId();
    String actualStoreLink = actualIosConfig.getStoreLink();

    // Assert that nothing has changed
    assertEquals("42", actualAppId);
    assertEquals("IosConfig(enabled=true, appId=42, storeLink=Store Link)", actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertTrue(actualIosConfig.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#IosConfig(boolean, String, String)}
   *   <li>{@link IosConfig#setAppId(String)}
   *   <li>{@link IosConfig#setEnabled(boolean)}
   *   <li>{@link IosConfig#setStoreLink(String)}
   *   <li>{@link IosConfig#toString()}
   *   <li>{@link IosConfig#getAppId()}
   *   <li>{@link IosConfig#getStoreLink()}
   *   <li>{@link IosConfig#isEnabled()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    IosConfig actualIosConfig = new IosConfig(true, "42", "Store Link");
    actualIosConfig.setAppId("42");
    actualIosConfig.setEnabled(true);
    actualIosConfig.setStoreLink("Store Link");
    String actualToStringResult = actualIosConfig.toString();
    String actualAppId = actualIosConfig.getAppId();
    String actualStoreLink = actualIosConfig.getStoreLink();

    // Assert that nothing has changed
    assertEquals("42", actualAppId);
    assertEquals("IosConfig(enabled=true, appId=42, storeLink=Store Link)", actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertTrue(actualIosConfig.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig.IosConfigBuilder#build()}
   *   <li>{@link IosConfig.IosConfigBuilder#appId(String)}
   *   <li>{@link IosConfig.IosConfigBuilder#enabled(boolean)}
   *   <li>{@link IosConfig.IosConfigBuilder#storeLink(String)}
   * </ul>
   */
  @Test
  void testIosConfigBuilderBuild() {
    // Arrange and Act
    IosConfig actualBuildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Assert
    assertEquals("42", actualBuildResult.getAppId());
    assertEquals("Store Link", actualBuildResult.getStoreLink());
    assertTrue(actualBuildResult.isEnabled());
  }
}
