package org.thingsboard.server.transport.lwm2m.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2mValueConverterImplDiffblueTest {
  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'BOOLEAN'; then throw CodecException")
  void testConvertValue_whenBoolean_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.BOOLEAN, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code FLOAT}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'FLOAT'; then return 'Value'")
  void testConvertValue_whenFloat_thenReturnValue() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value",
        instance.convertValue("Value", ResourceModel.Type.FLOAT, ResourceModel.Type.STRING, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code FLOAT}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'FLOAT'; then throw CodecException")
  void testConvertValue_whenFloat_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.FLOAT, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'INTEGER'; then throw CodecException")
  void testConvertValue_whenInteger_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.INTEGER, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code NONE}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'NONE'; then return 'Value'")
  void testConvertValue_whenNone_thenReturnValue() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value",
        instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then return 'null'")
  void testConvertValue_whenNull_thenReturnNull() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertNull(instance.convertValue(null, null, null, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then return 'Value'")
  void testConvertValue_whenNull_thenReturnValue() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertEquals("Value", instance.convertValue("Value", ResourceModel.Type.NONE, null, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'null'; then throw CodecException")
  void testConvertValue_whenNull_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", null, ResourceModel.Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code OBJLNK}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'OBJLNK'; then throw CodecException")
  void testConvertValue_whenObjlnk_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.OBJLNK, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code OPAQUE}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'OPAQUE'; then throw CodecException")
  void testConvertValue_whenOpaque_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.OPAQUE, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'STRING'; then throw CodecException")
  void testConvertValue_whenString_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.STRING, ResourceModel.Type.NONE, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'STRING'; then throw CodecException")
  void testConvertValue_whenString_thenThrowCodecException2() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.STRING, new LwM2mPath(1)));
  }

  /**
   * Test
   * {@link LwM2mValueConverterImpl#convertValue(Object, Type, Type, LwM2mPath)}.
   * <ul>
   *   <li>When {@code TIME}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mValueConverterImpl#convertValue(Object, ResourceModel.Type, ResourceModel.Type, LwM2mPath)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Type, Type, LwM2mPath); when 'TIME'; then throw CodecException")
  void testConvertValue_whenTime_thenThrowCodecException() throws InvalidLwM2mPathException, CodecException {
    // Arrange
    LwM2mValueConverterImpl instance = LwM2mValueConverterImpl.getInstance();

    // Act and Assert
    assertThrows(CodecException.class,
        () -> instance.convertValue("Value", ResourceModel.Type.NONE, ResourceModel.Type.TIME, new LwM2mPath(1)));
  }
}
