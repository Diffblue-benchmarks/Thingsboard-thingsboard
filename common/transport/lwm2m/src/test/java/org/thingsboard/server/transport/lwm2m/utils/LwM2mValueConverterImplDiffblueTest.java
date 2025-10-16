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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
   *   <li>When {@code BOOLEAN}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'BOOLEAN'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenBoolean_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'FLOAT'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenFloat_thenReturnValue()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals(
        "Value", instance.convertValue("Value", Type.FLOAT, Type.STRING, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'FLOAT'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenFloat_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.FLOAT, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'INTEGER'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenInteger_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.INTEGER, new LwM2mPath(1)));
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
        () -> instance.convertValue("Value", null, Type.NONE, new LwM2mIncompletePath(1)));
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
        () -> instance.convertValue("Value", null, Type.NONE, new LwM2mIncompletePath(1, 1)));
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
        () -> instance.convertValue("Value", null, Type.NONE, new LwM2mPath(1, 1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@link LwM2mPath#LwM2mPath(int)} with objectId is one.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when LwM2mPath(int) with objectId is one; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenLwM2mPathWithObjectIdIsOne_thenReturnValue()
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
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenNull_thenReturnNull() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertNull(instance.convertValue(null, null, null, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenNull_thenReturnValue()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value", instance.convertValue("Value", Type.NONE, null, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenNull_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", null, Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenNull_thenThrowCodecException2() throws CodecException {
    // Arrange, Act and Assert
    assertThrows(
        CodecException.class,
        () -> LwM2mValueConverterImpl.getInstance().convertValue("Value", null, Type.NONE, null));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code OBJLNK}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'OBJLNK'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenObjlnk_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.OBJLNK, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code OPAQUE}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'OPAQUE'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenOpaque_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.OPAQUE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'STRING'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenString_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.STRING, Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'STRING'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenString_thenThrowCodecException2()
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
   *   <li>When {@code TIME}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type,
   * LwM2mPath)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Type, Type, LwM2mPath); when 'TIME'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mValueConverterImpl.convertValue(Object, Type, Type, LwM2mPath)"})
  void testConvertValue_whenTime_thenThrowCodecException()
      throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> instance.convertValue("Value", Type.NONE, Type.TIME, new LwM2mPath(1)));
  }
}
