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
package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VersionCreateConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionCreateConfig#equals(Object)}
   *   <li>{@link VersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertEquals(versionCreateConfig, versionCreateConfig2);
    int expectedHashCodeResult = versionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionCreateConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionCreateConfig#equals(Object)}
   *   <li>{@link VersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.isSaveCredentials()).thenReturn(true);
    when(autoVersionCreateConfig.isSaveAttributes()).thenReturn(true);
    when(autoVersionCreateConfig.isSaveRelations()).thenReturn(true);
    when(autoVersionCreateConfig.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertEquals(versionCreateConfig, autoVersionCreateConfig);
    int notExpectedHashCodeResult = versionCreateConfig.hashCode();
    assertNotEquals(notExpectedHashCodeResult, autoVersionCreateConfig.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionCreateConfig#equals(Object)}
   *   <li>{@link VersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertEquals(versionCreateConfig, versionCreateConfig);
    int expectedHashCodeResult = versionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionCreateConfig.hashCode());
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, versionCreateConfig);
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(false);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, versionCreateConfig2);
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(false);
    versionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, versionCreateConfig2);
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(false);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, versionCreateConfig2);
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, autoVersionCreateConfig);
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, null);
  }

  /**
   * Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, "Different type to VersionCreateConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link VersionCreateConfig}
   *   <li>{@link VersionCreateConfig#setSaveAttributes(boolean)}
   *   <li>{@link VersionCreateConfig#setSaveCredentials(boolean)}
   *   <li>{@link VersionCreateConfig#setSaveRelations(boolean)}
   *   <li>{@link VersionCreateConfig#toString()}
   *   <li>{@link VersionCreateConfig#isSaveAttributes()}
   *   <li>{@link VersionCreateConfig#isSaveCredentials()}
   *   <li>{@link VersionCreateConfig#isSaveRelations()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    VersionCreateConfig actualVersionCreateConfig = new VersionCreateConfig();
    actualVersionCreateConfig.setSaveAttributes(true);
    actualVersionCreateConfig.setSaveCredentials(true);
    actualVersionCreateConfig.setSaveRelations(true);
    String actualToStringResult = actualVersionCreateConfig.toString();
    boolean actualIsSaveAttributesResult = actualVersionCreateConfig.isSaveAttributes();
    boolean actualIsSaveCredentialsResult = actualVersionCreateConfig.isSaveCredentials();

    // Assert that nothing has changed
    assertEquals("VersionCreateConfig(saveRelations=true, saveAttributes=true, saveCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsSaveAttributesResult);
    assertTrue(actualIsSaveCredentialsResult);
    assertTrue(actualVersionCreateConfig.isSaveRelations());
  }
}
