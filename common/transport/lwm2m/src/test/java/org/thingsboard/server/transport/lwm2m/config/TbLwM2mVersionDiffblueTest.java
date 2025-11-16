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
package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.LwM2mVersion;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbLwM2mVersionDiffblueTest {
  /**
   * Test {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When Default.
   *   <li>Then return {@code VERSION_1_0}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}
   */
  @Test
  @DisplayName("Test fromVersion(LwM2mVersion); when Default; then return 'VERSION_1_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromVersion(LwM2mVersion)"})
  void testFromVersion_whenDefault_thenReturnVersion10() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_0, TbLwM2mVersion.fromVersion(LwM2mVersion.getDefault()));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When lastSupported.
   *   <li>Then return {@code VERSION_1_1}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}
   */
  @Test
  @DisplayName("Test fromVersion(LwM2mVersion); when lastSupported; then return 'VERSION_1_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromVersion(LwM2mVersion)"})
  void testFromVersion_whenLastSupported_thenReturnVersion11() {
    // Arrange, Act and Assert
    assertEquals(
        TbLwM2mVersion.VERSION_1_1, TbLwM2mVersion.fromVersion(LwM2mVersion.lastSupported()));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}
   */
  @Test
  @DisplayName("Test fromVersion(LwM2mVersion); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromVersion(LwM2mVersion)"})
  void testFromVersion_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromVersion(null));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersionStr(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0}.
   *   <li>Then return {@code VERSION_1_0}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromVersionStr(String)}
   */
  @Test
  @DisplayName("Test fromVersionStr(String); when '1.0'; then return 'VERSION_1_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromVersionStr(String)"})
  void testFromVersionStr_when10_thenReturnVersion10() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_0, TbLwM2mVersion.fromVersionStr("1.0"));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersionStr(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromVersionStr(String)}
   */
  @Test
  @DisplayName("Test fromVersionStr(String); when '1.0.2'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromVersionStr(String)"})
  void testFromVersionStr_when102_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromVersionStr("1.0.2"));
  }

  /**
   * Test {@link TbLwM2mVersion#fromCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code VERSION_1_1}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromCode(int)}
   */
  @Test
  @DisplayName("Test fromCode(int); when one; then return 'VERSION_1_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromCode(int)"})
  void testFromCode_whenOne_thenReturnVersion11() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_1, TbLwM2mVersion.fromCode(1));
  }

  /**
   * Test {@link TbLwM2mVersion#fromCode(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mVersion#fromCode(int)}
   */
  @Test
  @DisplayName("Test fromCode(int); when two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2mVersion TbLwM2mVersion.fromCode(int)"})
  void testFromCode_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromCode(2));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2mVersion#getCode()}
   *   <li>{@link TbLwM2mVersion#getContentFormat()}
   *   <li>{@link TbLwM2mVersion#getVersion()}
   *   <li>{@link TbLwM2mVersion#isComposite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TbLwM2mVersion.getCode()",
    "ContentFormat TbLwM2mVersion.getContentFormat()",
    "LwM2mVersion TbLwM2mVersion.getVersion()",
    "boolean TbLwM2mVersion.isComposite()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2mVersion valueOfResult = TbLwM2mVersion.valueOf("VERSION_1_0");

    // Act
    int actualCode = valueOfResult.getCode();
    ContentFormat actualContentFormat = valueOfResult.getContentFormat();
    LwM2mVersion actualVersion = valueOfResult.getVersion();

    // Assert
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isComposite());
    assertTrue(actualVersion.isSupported());
    assertSame(LwM2mVersion.V1_0, actualVersion);
    assertSame(ContentFormat.TLV, actualContentFormat);
  }
}
