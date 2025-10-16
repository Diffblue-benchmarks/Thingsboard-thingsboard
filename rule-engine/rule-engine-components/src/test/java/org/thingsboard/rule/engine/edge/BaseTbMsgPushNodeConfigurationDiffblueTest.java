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
package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseTbMsgPushNodeConfigurationDiffblueTest {
  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link BaseTbMsgPushNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName(
      "Test defaultConfiguration(); given BaseTbMsgPushNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BaseTbMsgPushNodeConfiguration BaseTbMsgPushNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration_givenBaseTbMsgPushNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        "SERVER_SCOPE", new BaseTbMsgPushNodeConfiguration().defaultConfiguration().getScope());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@link TbMsgPushToCloudNodeConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return TbMsgPushToCloudNodeConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BaseTbMsgPushNodeConfiguration BaseTbMsgPushNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration_thenReturnTbMsgPushToCloudNodeConfiguration() {
    // Arrange and Act
    TbMsgPushToCloudNodeConfiguration actualDefaultConfigurationResult =
        new TbMsgPushToCloudNodeConfiguration().defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult instanceof TbMsgPushToCloudNodeConfiguration);
    assertEquals("SERVER_SCOPE", actualDefaultConfigurationResult.getScope());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and {@link
   * BaseTbMsgPushNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration2 =
        new BaseTbMsgPushNodeConfiguration();

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, baseTbMsgPushNodeConfiguration2);
    assertEquals(
        baseTbMsgPushNodeConfiguration.hashCode(), baseTbMsgPushNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and {@link
   * BaseTbMsgPushNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();

    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration =
        mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn(null);
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
    assertNotEquals(
        baseTbMsgPushNodeConfiguration.hashCode(), tbMsgPushToCloudNodeConfiguration.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and {@link
   * BaseTbMsgPushNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();
    baseTbMsgPushNodeConfiguration.setScope("Scope");

    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration =
        mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn("Scope");
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
    assertNotEquals(
        baseTbMsgPushNodeConfiguration.hashCode(), tbMsgPushToCloudNodeConfiguration.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and {@link
   * BaseTbMsgPushNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, baseTbMsgPushNodeConfiguration);
    int expectedHashCodeResult = baseTbMsgPushNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, baseTbMsgPushNodeConfiguration.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration =
        new TbMsgPushToCloudNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbMsgPushToCloudNodeConfiguration, new BaseTbMsgPushNodeConfiguration());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();

    // Act and Assert
    assertNotEquals(baseTbMsgPushNodeConfiguration, new TbMsgPushToCloudNodeConfiguration());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();

    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration =
        mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn("Scope");
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();
    baseTbMsgPushNodeConfiguration.setScope("Scope");

    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration =
        mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn(null);
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTbMsgPushNodeConfiguration(), null);
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseTbMsgPushNodeConfiguration.equals(Object)",
    "int BaseTbMsgPushNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new BaseTbMsgPushNodeConfiguration(), "Different type to BaseTbMsgPushNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BaseTbMsgPushNodeConfiguration}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#setScope(String)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#toString()}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#getScope()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseTbMsgPushNodeConfiguration.<init>()",
    "String BaseTbMsgPushNodeConfiguration.getScope()",
    "void BaseTbMsgPushNodeConfiguration.setScope(String)",
    "String BaseTbMsgPushNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BaseTbMsgPushNodeConfiguration actualBaseTbMsgPushNodeConfiguration =
        new BaseTbMsgPushNodeConfiguration();
    actualBaseTbMsgPushNodeConfiguration.setScope("Scope");
    String actualToStringResult = actualBaseTbMsgPushNodeConfiguration.toString();

    // Assert
    assertEquals("BaseTbMsgPushNodeConfiguration(scope=Scope)", actualToStringResult);
    assertEquals("Scope", actualBaseTbMsgPushNodeConfiguration.getScope());
  }
}
