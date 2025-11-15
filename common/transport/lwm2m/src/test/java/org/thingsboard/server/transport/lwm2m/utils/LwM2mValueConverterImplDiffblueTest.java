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
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.Test;

class LwM2mValueConverterImplDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value",
        instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue2() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertNull(instance.convertValue(null, null, null, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue3() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", null, ResourceModel.Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue4() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.STRING, ResourceModel.Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue5() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value", instance.convertValue("Value", ResourceModel.Type.NONE, null, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue6() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.STRING, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue7() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.FLOAT, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue8() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.INTEGER, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue9() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue10() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.TIME, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue11() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.OPAQUE, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue12() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.OBJLNK, new LwM2mPath(1)));
  }

  /**
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  void testConvertValue13() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value",
        instance.convertValue("Value", ResourceModel.Type.FLOAT, ResourceModel.Type.STRING, new LwM2mPath(1)));
  }
}
