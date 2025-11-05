package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.TbMsgMetaData;

class TbMathArgumentValueDiffblueTest {
  /**
   * Test {@link TbMathArgumentValue#constant(TbMathArgument)}.
   *
   * <ul>
   *   <li>Then return Value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#constant(TbMathArgument)}
   */
  @Test
  @DisplayName("Test constant(TbMathArgument); then return Value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathArgumentValue TbMathArgumentValue.constant(TbMathArgument)"})
  void testConstant_thenReturnValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42.0d,
        TbMathArgumentValue.constant(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "42"))
            .getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#constant(TbMathArgument)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#constant(TbMathArgument)}
   */
  @Test
  @DisplayName("Test constant(TbMathArgument); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathArgumentValue TbMathArgumentValue.constant(TbMathArgument)"})
  void testConstant_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TbMathArgumentValue.constant(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key")));
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then return Value is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test fromMessageBody(TbMathArgument, String, Optional); given ten; then return Value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageBody(TbMathArgument, String, Optional)"
  })
  void testFromMessageBody_givenTen_thenReturnValueIsTen() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);
    Optional<ObjectNode> jsonNodeOpt = Optional.empty();

    // Act
    TbMathArgumentValue actualFromMessageBodyResult =
        TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt);

    // Assert
    assertEquals(10.0d, actualFromMessageBodyResult.getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test fromMessageBody(TbMathArgument, String, Optional); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageBody(TbMathArgument, String, Optional)"
  })
  void testFromMessageBody_thenThrowRuntimeException() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> jsonNodeOpt = Optional.of(new ObjectNode(nc));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt));
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test fromMessageBody(TbMathArgument, String, Optional); when empty; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageBody(TbMathArgument, String, Optional)"
  })
  void testFromMessageBody_whenEmpty_thenThrowRuntimeException() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    Optional<ObjectNode> jsonNodeOpt = Optional.empty();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt));
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String, Optional)}.
   *
   * <ul>
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageBody(TbMathArgument, String,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test fromMessageBody(TbMathArgument, String, Optional); when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageBody(TbMathArgument, String, Optional)"
  })
  void testFromMessageBody_whenObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> jsonNodeOpt = Optional.of(new ObjectNode(nc));

    // Act
    TbMathArgumentValue actualFromMessageBodyResult =
        TbMathArgumentValue.fromMessageBody(arg, "Arg Key", jsonNodeOpt);

    // Assert
    assertEquals(10.0d, actualFromMessageBodyResult.getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String,
   * TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)"
  })
  void testFromMessageMetadata_givenNull() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", null));
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then return Value is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String,
   * TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); given ten; then return Value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)"
  })
  void testFromMessageMetadata_givenTen_thenReturnValueIsTen() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);

    // Act
    TbMathArgumentValue actualFromMessageMetadataResult =
        TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", null);

    // Assert
    assertEquals(10.0d, actualFromMessageMetadataResult.getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String,
   * TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)"
  })
  void testFromMessageMetadata_thenThrowRuntimeException() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", new TbMsgMetaData()));
  }

  /**
   * Test {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData(Map)} with data is {@link HashMap#HashMap()}.
   *   <li>Then return Value is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromMessageMetadata(TbMathArgument, String,
   * TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test fromMessageMetadata(TbMathArgument, String, TbMsgMetaData); when TbMsgMetaData(Map) with data is HashMap(); then return Value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMathArgumentValue TbMathArgumentValue.fromMessageMetadata(TbMathArgument, String, TbMsgMetaData)"
  })
  void testFromMessageMetadata_whenTbMsgMetaDataWithDataIsHashMap_thenReturnValueIsTen() {
    // Arrange
    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    arg.setDefaultValue(10.0d);

    // Act
    TbMathArgumentValue actualFromMessageMetadataResult =
        TbMathArgumentValue.fromMessageMetadata(arg, "Arg Key", new TbMsgMetaData(new HashMap<>()));

    // Assert
    assertEquals(10.0d, actualFromMessageMetadataResult.getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromLong(long)}.
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromLong(long)}
   */
  @Test
  @DisplayName("Test fromLong(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathArgumentValue TbMathArgumentValue.fromLong(long)"})
  void testFromLong() {
    // Arrange and Act
    TbMathArgumentValue actualFromLongResult = TbMathArgumentValue.fromLong(42L);

    // Assert
    assertEquals(42.0d, actualFromLongResult.getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromDouble(double)}.
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromDouble(double)}
   */
  @Test
  @DisplayName("Test fromDouble(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathArgumentValue TbMathArgumentValue.fromDouble(double)"})
  void testFromDouble() {
    // Arrange and Act
    TbMathArgumentValue actualFromDoubleResult = TbMathArgumentValue.fromDouble(10.0d);

    // Assert
    assertEquals(10.0d, actualFromDoubleResult.getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when '42'; then return Value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathArgumentValue TbMathArgumentValue.fromString(String)"})
  void testFromString_when42_thenReturnValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, TbMathArgumentValue.fromString("42").getValue());
  }

  /**
   * Test {@link TbMathArgumentValue#fromString(String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgumentValue#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when 'Value'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathArgumentValue TbMathArgumentValue.fromString(String)"})
  void testFromString_whenValue_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TbMathArgumentValue.fromString("Value"));
  }

  /**
   * Test {@link TbMathArgumentValue#getValue()}.
   *
   * <p>Method under test: {@link TbMathArgumentValue#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbMathArgumentValue.getValue()"})
  void testGetValue() {
    // Arrange
    TbMathArgumentValue fromDoubleResult = TbMathArgumentValue.fromDouble(10.0d);

    // Act and Assert
    assertEquals(10.0d, fromDoubleResult.getValue());
  }
}
