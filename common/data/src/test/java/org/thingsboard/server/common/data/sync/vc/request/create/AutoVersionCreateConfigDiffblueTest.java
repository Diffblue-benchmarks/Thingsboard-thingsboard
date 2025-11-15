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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class AutoVersionCreateConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AutoVersionCreateConfig#equals(Object)}
   *   <li>{@link AutoVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
    int expectedHashCodeResult = autoVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, autoVersionCreateConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AutoVersionCreateConfig#equals(Object)}
   *   <li>{@link AutoVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertEquals(autoVersionCreateConfig, autoVersionCreateConfig);
    int expectedHashCodeResult = autoVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, autoVersionCreateConfig.hashCode());
  }

  /**
   * Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("Branch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
  }

  /**
   * Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch(null);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
  }

  /**
   * Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(false);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
  }

  /**
   * Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, null);
  }

  /**
   * Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, "Different type to AutoVersionCreateConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AutoVersionCreateConfig}
   *   <li>{@link AutoVersionCreateConfig#setBranch(String)}
   *   <li>{@link AutoVersionCreateConfig#toString()}
   *   <li>{@link AutoVersionCreateConfig#getBranch()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AutoVersionCreateConfig actualAutoVersionCreateConfig = new AutoVersionCreateConfig();
    actualAutoVersionCreateConfig.setBranch("janedoe/featurebranch");
    String actualToStringResult = actualAutoVersionCreateConfig.toString();

    // Assert that nothing has changed
    assertEquals("AutoVersionCreateConfig(branch=janedoe/featurebranch)", actualToStringResult);
    assertEquals("janedoe/featurebranch", actualAutoVersionCreateConfig.getBranch());
    assertFalse(actualAutoVersionCreateConfig.isSaveAttributes());
    assertFalse(actualAutoVersionCreateConfig.isSaveCredentials());
    assertFalse(actualAutoVersionCreateConfig.isSaveRelations());
  }
}
