package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.TbMsgMetaData;

class TbMathArgumentValueDiffblueTest {
  /**
   * Test {@link TbMathArgumentValue#constant(TbMathArgument)}.
   * <ul>
   *   <li>Then return Value is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathArgumentValue#constant(TbMathArgument)}
   */
  @Test
  @DisplayName("Test constant(TbMathArgument); then return Value is forty-two")
  void testConstant_thenReturnValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d,
        TbMathArgumentValue.constant(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "42")).getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#constant(TbMathArgument)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathArgumentValue#constant(TbMathArgument)}
   */
  @Test
  @DisplayName("Test constant(TbMathArgument); then throw RuntimeException")
  void testConstant_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> TbMathArgumentValue.constant(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key")));
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return Value is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}
   */
  @Test
  @DisplayName("Test fromMessageBody(TbMathArgument, String, Optional); given ten; then return Value is ten")
  void testFromMessageBody_givenTen_thenReturnValueIsTen() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);
    Optional<ObjectNode> jsonNodeOpt = Optional.of(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(10.0d, TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt).getValue());
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return Value is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}
   */
  @Test
  @DisplayName("Test fromMessageBody(TbMathArgument, String, Optional); given ten; then return Value is ten")
  void testFromMessageBody_givenTen_thenReturnValueIsTen2() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);
    Optional<ObjectNode> jsonNodeOpt = Optional.empty();

    // Act and Assert
    assertEquals(10.0d, TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt).getValue());
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}
   */
  @Test
  @DisplayName("Test fromMessageBody(TbMathArgument, String, Optional); then throw RuntimeException")
  void testFromMessageBody_thenThrowRuntimeException() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    Optional<ObjectNode> jsonNodeOpt = Optional.of(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt));
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}
   */
  @Test
  @DisplayName("Test fromMessageBody(TbMathArgument, String, Optional); when empty; then throw RuntimeException")
  void testFromMessageBody_whenEmpty_thenThrowRuntimeException() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    Optional<ObjectNode> jsonNodeOpt = Optional.empty();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt));
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); given 'null'")
  void testFromMessageMetadata_givenNull() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", null));
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return Value is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); given ten; then return Value is ten")
  void testFromMessageMetadata_givenTen_thenReturnValueIsTen() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);

    // Act and Assert
    assertEquals(10.0d, TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", null).getValue());
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return Value is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); given ten; then return Value is ten")
  void testFromMessageMetadata_givenTen_thenReturnValueIsTen2() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);

    // Act and Assert
    assertEquals(10.0d, TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", new TbMsgMetaData()).getValue());
  }

  /**
   * Test
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); then throw RuntimeException")
  void testFromMessageMetadata_thenThrowRuntimeException() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", new TbMsgMetaData()));
  }

  /**
   * Test {@link TbMathArgumentValue#fromLong(long)}.
   * <p>
   * Method under test: {@link TbMathArgumentValue#fromLong(long)}
   */
  @Test
  @DisplayName("Test fromLong(long)")
  void testFromLong() {
    // Arrange, Act and Assert
    assertEquals(42.0d, TbMathArgumentValue.fromLong(42L).getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromDouble(double)}.
   * <p>
   * Method under test: {@link TbMathArgumentValue#fromDouble(double)}
   */
  @Test
  @DisplayName("Test fromDouble(double)")
  void testFromDouble() {
    // Arrange, Act and Assert
    assertEquals(10.0d, TbMathArgumentValue.fromDouble(10.0d).getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Value is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathArgumentValue#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when '42'; then return Value is forty-two")
  void testFromString_when42_thenReturnValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, TbMathArgumentValue.fromString("42").getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromString(String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathArgumentValue#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when 'Value'; then throw RuntimeException")
  void testFromString_whenValue_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TbMathArgumentValue.fromString("Value"));
  }

  /**
   * Test {@link TbMathArgumentValue#getValue()}.
   * <p>
   * Method under test: {@link TbMathArgumentValue#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals(10.0d, TbMathArgumentValue.fromDouble(10.0d).getValue());
  }
}
