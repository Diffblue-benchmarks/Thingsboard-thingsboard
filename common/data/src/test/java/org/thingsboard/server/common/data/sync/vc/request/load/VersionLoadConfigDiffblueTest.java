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
package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VersionLoadConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, versionLoadConfig2);
    int expectedHashCodeResult = versionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionLoadConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = mock(EntityTypeVersionLoadConfig.class);
    when(entityTypeVersionLoadConfig.isLoadCredentials()).thenReturn(true);
    when(entityTypeVersionLoadConfig.isLoadAttributes()).thenReturn(true);
    when(entityTypeVersionLoadConfig.isLoadRelations()).thenReturn(true);
    when(entityTypeVersionLoadConfig.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(entityTypeVersionLoadConfig).setLoadAttributes(anyBoolean());
    doNothing().when(entityTypeVersionLoadConfig).setLoadCredentials(anyBoolean());
    doNothing().when(entityTypeVersionLoadConfig).setLoadRelations(anyBoolean());
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, entityTypeVersionLoadConfig);
    int notExpectedHashCodeResult = versionLoadConfig.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityTypeVersionLoadConfig.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, versionLoadConfig);
    int expectedHashCodeResult = versionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionLoadConfig.hashCode());
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, versionLoadConfig);
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(false);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(false);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(false);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, entityTypeVersionLoadConfig);
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, null);
  }

  /**
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, "Different type to VersionLoadConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link VersionLoadConfig}
   *   <li>{@link VersionLoadConfig#setLoadAttributes(boolean)}
   *   <li>{@link VersionLoadConfig#setLoadCredentials(boolean)}
   *   <li>{@link VersionLoadConfig#setLoadRelations(boolean)}
   *   <li>{@link VersionLoadConfig#toString()}
   *   <li>{@link VersionLoadConfig#isLoadAttributes()}
   *   <li>{@link VersionLoadConfig#isLoadCredentials()}
   *   <li>{@link VersionLoadConfig#isLoadRelations()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    VersionLoadConfig actualVersionLoadConfig = new VersionLoadConfig();
    actualVersionLoadConfig.setLoadAttributes(true);
    actualVersionLoadConfig.setLoadCredentials(true);
    actualVersionLoadConfig.setLoadRelations(true);
    String actualToStringResult = actualVersionLoadConfig.toString();
    boolean actualIsLoadAttributesResult = actualVersionLoadConfig.isLoadAttributes();
    boolean actualIsLoadCredentialsResult = actualVersionLoadConfig.isLoadCredentials();

    // Assert that nothing has changed
    assertEquals("VersionLoadConfig(loadRelations=true, loadAttributes=true, loadCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsLoadAttributesResult);
    assertTrue(actualIsLoadCredentialsResult);
    assertTrue(actualVersionLoadConfig.isLoadRelations());
  }
}
