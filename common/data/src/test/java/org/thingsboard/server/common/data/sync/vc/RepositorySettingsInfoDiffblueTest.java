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
package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RepositorySettingsInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.readOnly(Mockito.<Boolean>any())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder2 = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder2.configured(anyBoolean())).thenReturn(repositorySettingsInfoBuilder);
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder2.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(false).readOnly(null).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.configured(anyBoolean())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder.configured(true).readOnly(true).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.configured(anyBoolean())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(false).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.readOnly(Mockito.<Boolean>any())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder2 = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder2.configured(anyBoolean())).thenReturn(repositorySettingsInfoBuilder);
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder2.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(false).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RepositorySettingsInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#RepositorySettingsInfo()}
   *   <li>{@link RepositorySettingsInfo#setConfigured(boolean)}
   *   <li>{@link RepositorySettingsInfo#setReadOnly(Boolean)}
   *   <li>{@link RepositorySettingsInfo#toString()}
   *   <li>{@link RepositorySettingsInfo#getReadOnly()}
   *   <li>{@link RepositorySettingsInfo#isConfigured()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RepositorySettingsInfo actualRepositorySettingsInfo = new RepositorySettingsInfo();
    actualRepositorySettingsInfo.setConfigured(true);
    actualRepositorySettingsInfo.setReadOnly(true);
    String actualToStringResult = actualRepositorySettingsInfo.toString();
    Boolean actualReadOnly = actualRepositorySettingsInfo.getReadOnly();

    // Assert that nothing has changed
    assertEquals("RepositorySettingsInfo(configured=true, readOnly=true)", actualToStringResult);
    assertTrue(actualReadOnly);
    assertTrue(actualRepositorySettingsInfo.isConfigured());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#RepositorySettingsInfo(boolean, Boolean)}
   *   <li>{@link RepositorySettingsInfo#setConfigured(boolean)}
   *   <li>{@link RepositorySettingsInfo#setReadOnly(Boolean)}
   *   <li>{@link RepositorySettingsInfo#toString()}
   *   <li>{@link RepositorySettingsInfo#getReadOnly()}
   *   <li>{@link RepositorySettingsInfo#isConfigured()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    RepositorySettingsInfo actualRepositorySettingsInfo = new RepositorySettingsInfo(true, true);
    actualRepositorySettingsInfo.setConfigured(true);
    actualRepositorySettingsInfo.setReadOnly(true);
    String actualToStringResult = actualRepositorySettingsInfo.toString();
    Boolean actualReadOnly = actualRepositorySettingsInfo.getReadOnly();

    // Assert that nothing has changed
    assertEquals("RepositorySettingsInfo(configured=true, readOnly=true)", actualToStringResult);
    assertTrue(actualReadOnly);
    assertTrue(actualRepositorySettingsInfo.isConfigured());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo.RepositorySettingsInfoBuilder#build()}
   *   <li>
   * {@link RepositorySettingsInfo.RepositorySettingsInfoBuilder#configured(boolean)}
   *   <li>
   * {@link RepositorySettingsInfo.RepositorySettingsInfoBuilder#readOnly(Boolean)}
   * </ul>
   */
  @Test
  void testRepositorySettingsInfoBuilderBuild() {
    // Arrange and Act
    RepositorySettingsInfo actualBuildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Assert
    assertTrue(actualBuildResult.getReadOnly());
    assertTrue(actualBuildResult.isConfigured());
  }
}
