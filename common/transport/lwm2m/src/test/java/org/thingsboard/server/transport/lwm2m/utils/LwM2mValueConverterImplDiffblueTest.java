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
package org.thingsboard.server.transport.lwm2m.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mIncompletePath;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mValueConverterImplDiffblueTest {
  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'BOOLEAN'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenBoolean_thenReturnTrue()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertTrue((Boolean) instance.convertValue(1L, Type.INTEGER, Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Type#BOOLEAN}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when BOOLEAN; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenBoolean_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, Type.BOOLEAN, Type.FLOAT, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Type#BOOLEAN}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when BOOLEAN; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenBoolean_thenThrowCodecException2()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, Type.BOOLEAN, Type.INTEGER, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code FLOAT}.
   *   <li>Then return doubleValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'FLOAT'; then return doubleValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenFloat_thenReturnDoubleValueIsOne()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals(
        1.0d,
        ((Double) instance.convertValue(1L, Type.INTEGER, Type.FLOAT, new LwM2mPath(1)))
            .doubleValue());
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Type#FLOAT}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when FLOAT; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenFloat_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, Type.FLOAT, Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Type#FLOAT}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when FLOAT; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenFloat_thenThrowCodecException2()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, Type.FLOAT, Type.TIME, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When forty-two.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when forty-two; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenFortyTwo_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(42L, Type.INTEGER, Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code INTEGER}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'INTEGER'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenInteger_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, null, Type.INTEGER, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code NONE}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'NONE'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenNone_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, Type.INTEGER, Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code null}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'null'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenNull_thenReturnLongValueIsOne()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals(
        1L, ((Long) instance.convertValue(1L, Type.INTEGER, null, new LwM2mPath(1))).longValue());
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenNull_thenReturnNull()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertNull(instance.convertValue(null, Type.NONE, Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code null}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'null'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenNull_thenThrowCodecException() throws CodecException {
    // Arrange, Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            LwM2mValueConverterImpl.getInstance()
                .convertValue("Value", Type.NONE, Type.STRING, null));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code OBJLNK}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'OBJLNK'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenObjlnk_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue(1L, Type.INTEGER, Type.OBJLNK, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Type#STRING}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when STRING; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenString_thenDoesNotThrow()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act
    assertDoesNotThrow(() -> instance.convertValue(1L, Type.STRING, Type.TIME, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code STRING}.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'STRING'; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenString_thenReturn1()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("1", instance.convertValue(1L, Type.INTEGER, Type.STRING, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code TIME}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'TIME'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenTime_thenDoesNotThrow()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act
    assertDoesNotThrow(() -> instance.convertValue(1L, Type.INTEGER, Type.TIME, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenValue_thenReturnValue()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value", instance.convertValue("Value", Type.NONE, Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code Value}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when 'Value'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenValue_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.STRING, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given Instance; when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenInstance_whenZero_thenReturnFalse()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertFalse((Boolean) instance.convertValue(0L, Type.INTEGER, Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mValueConverterImpl} (default constructor).
   *   <li>When {@code OPAQUE}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); given LwM2mValueConverterImpl (default constructor); when 'OPAQUE'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_givenLwM2mValueConverterImpl_whenOpaque_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl lwM2mValueConverterImpl = new LwM2mValueConverterImpl();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> lwM2mValueConverterImpl.convertValue(1L, Type.NONE, Type.OPAQUE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@link LwM2mIncompletePath#LwM2mIncompletePath(int)} with objectId is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when LwM2mIncompletePath(int) with objectId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenLwM2mIncompletePathWithObjectIdIsOne()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.STRING, new LwM2mIncompletePath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@link LwM2mIncompletePath#LwM2mIncompletePath(int, int)} with objectId is one and
   *       resourceId is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when LwM2mIncompletePath(int, int) with objectId is one and resourceId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenLwM2mIncompletePathWithObjectIdIsOneAndResourceIdIsOne()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            instance.convertValue("Value", Type.NONE, Type.STRING, new LwM2mIncompletePath(1, 1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@link LwM2mPath#LwM2mPath(int, int)} with objectId is one and objectInstanceId is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when LwM2mPath(int, int) with objectId is one and objectInstanceId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenLwM2mPathWithObjectIdIsOneAndObjectInstanceIdIsOne()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.STRING, new LwM2mPath(1, 1)));
  }
}
