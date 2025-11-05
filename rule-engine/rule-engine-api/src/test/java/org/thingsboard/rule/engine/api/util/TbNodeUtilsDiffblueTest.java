package org.thingsboard.rule.engine.api.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

class TbNodeUtilsDiffblueTest {
  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   *   <li>Then return first is {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); given 'Pojo'; then return first is 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_givenPojo_thenReturnFirstIsPojo() throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addPOJO("Pojo");
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertEquals(1, ((List<String>) actualConvertResult).size());
    assertEquals("Pojo", ((List<String>) actualConvertResult).get(0));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   *   <li>Then return second is {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); given 'Pojo'; then return second is 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_givenPojo_thenReturnSecondIsPojo() throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.add(DoubleNode.valueOf(10.0d));
    data.addPOJO("Pojo");
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertEquals(2, ((List<Object>) actualConvertResult).size());
    assertEquals("Pojo", ((List<Object>) actualConvertResult).get(1));
    assertEquals(10.0d, ((Double) ((List<Object>) actualConvertResult).get(0)).doubleValue());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_thenReturnDoubleValueIsTen() throws TbNodeException {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(10.0d, ((Double) TbNodeUtils.convert(configuration, clazz)).doubleValue());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Then return first Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); then return first Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_thenReturnFirstEmpty() throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addArray();
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertEquals(1, ((List<ArrayList>) actualConvertResult).size());
    assertTrue(((List<ArrayList>) actualConvertResult).get(0).isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Then return first Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); then return first Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_thenReturnFirstEmpty2() throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addObject();
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertEquals(1, ((List<LinkedHashMap>) actualConvertResult).size());
    assertTrue(((List<LinkedHashMap>) actualConvertResult).get(0).isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Then second return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); then second return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_thenSecondReturnList() throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.add(DoubleNode.valueOf(10.0d));
    data.addArray();
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertEquals(2, ((List<Object>) actualConvertResult).size());
    Object getResult = ((List<Object>) actualConvertResult).get(1);
    assertTrue(getResult instanceof List);
    assertTrue(actualConvertResult instanceof List);
    assertEquals(10.0d, ((Double) ((List<Object>) actualConvertResult).get(0)).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>Then second return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); then second return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_thenSecondReturnMap() throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.add(DoubleNode.valueOf(10.0d));
    data.addObject();
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertEquals(2, ((List<Object>) actualConvertResult).size());
    Object getResult = ((List<Object>) actualConvertResult).get(1);
    assertTrue(getResult instanceof Map);
    assertEquals(10.0d, ((Double) ((List<Object>) actualConvertResult).get(0)).doubleValue());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnEmpty()
      throws TbNodeException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode data = new ArrayNode(nf);
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertTrue(((List<Object>) actualConvertResult).isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when POJONode(Object) with v is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenPOJONodeWithVIs42_thenReturn42() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(new POJONode("42"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("42", TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenPOJONodeWithVIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(new POJONode(null));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is False.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is False; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenTbNodeConfigurationWithDataIsFalse_thenReturnFalse() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(BooleanNode.getFalse());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse((Boolean) TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is Instance; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenTbNodeConfigurationWithDataIsInstance_thenReturnNull()
      throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(NullNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is Instance.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is Instance; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenTbNodeConfigurationWithDataIsInstance_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenTbNodeConfigurationWithDataIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(null);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is True.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName(
      "Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is True; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbNodeUtils.convert(TbNodeConfiguration, Class)"})
  void testConvert_whenTbNodeConfigurationWithDataIsTrue_thenReturnTrue() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(BooleanNode.getTrue());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue((Boolean) TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with {@code patterns}, {@code
   * metaData}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsgMetaData)"})
  void testProcessPatternsWithPatternsMetaData_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("42");
    patterns.add("foo");

    // Act
    List<String> actualProcessPatternsResult =
        TbNodeUtils.processPatterns(patterns, new TbMsgMetaData());

    // Assert
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with {@code patterns}, {@code
   * metaData}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; given 'Key'; when TbMsgMetaData() Value 'Key' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsgMetaData)"})
  void testProcessPatternsWithPatternsMetaData_givenKey_whenTbMsgMetaDataValueKeyIs42() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, metaData);

    // Assert
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with {@code patterns}, {@code
   * metaData}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsgMetaData)"})
  void testProcessPatternsWithPatternsMetaData_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();

    // Act
    List<String> actualProcessPatternsResult =
        TbNodeUtils.processPatterns(patterns, new TbMsgMetaData());

    // Assert
    assertTrue(actualProcessPatternsResult.isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with {@code patterns}, {@code
   * metaData}.
   *
   * <ul>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; when TbMsgMetaData(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsgMetaData)"})
  void testProcessPatternsWithPatternsMetaData_whenTbMsgMetaData_thenReturnArrayList() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    // Act
    List<String> actualProcessPatternsResult =
        TbNodeUtils.processPatterns(patterns, new TbMsgMetaData());

    // Assert
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getMetaData()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPatterns(patterns, tbMsg));
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg2() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPatterns(patterns, tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg3() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Failed to process pattern!", "42");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("Data");
    when(tbMsg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPatterns(patterns, tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'; given '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg_given42_thenReturnArrayList() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("42");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, tbMsg);

    // Assert
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'; given 'Data'; when TbMsg getData() return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg_givenData_whenTbMsgGetDataReturnData() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("Data");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPatterns(patterns, tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'; given 'Data'; when TbMsg getData() return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg_givenData_whenTbMsgGetDataReturnData2() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");
    patterns.add("foo");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("Data");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPatterns(patterns, tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("42");
    patterns.add("foo");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("42");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, tbMsg);

    // Assert
    verify(tbMsg, atLeast(1)).getData();
    verify(tbMsg, atLeast(1)).getMetaData();
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns}, {@code tbMsg}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbNodeUtils.processPatterns(List, TbMsg)"})
  void testProcessPatternsWithPatternsTbMsg_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualProcessPatternsResult =
        TbNodeUtils.processPatterns(new ArrayList<>(), mock(TbMsg.class));

    // Assert
    assertTrue(actualProcessPatternsResult.isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsgMetaData)} with {@code pattern}, {@code
   * metaData}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test processPattern(String, TbMsgMetaData) with 'pattern', 'metaData'; given 'Key'; when TbMsgMetaData() Value 'Key' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsgMetaData)"})
  void testProcessPatternWithPatternMetaData_givenKey_whenTbMsgMetaDataValueKeyIs42() {
    // Arrange
    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act and Assert
    assertEquals("Pattern", TbNodeUtils.processPattern("Pattern", metaData));
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsgMetaData)} with {@code pattern}, {@code
   * metaData}.
   *
   * <ul>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>Then return {@code Pattern}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test processPattern(String, TbMsgMetaData) with 'pattern', 'metaData'; when TbMsgMetaData(); then return 'Pattern'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsgMetaData)"})
  void testProcessPatternWithPatternMetaData_whenTbMsgMetaData_thenReturnPattern() {
    // Arrange, Act and Assert
    assertEquals("Pattern", TbNodeUtils.processPattern("Pattern", new TbMsgMetaData()));
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsg)} with {@code pattern}, {@code tbMsg}.
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsg)}
   */
  @Test
  @DisplayName("Test processPattern(String, TbMsg) with 'pattern', 'tbMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsg)"})
  void testProcessPatternWithPatternTbMsg() {
    // Arrange
    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getMetaData()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPattern("Pattern", tbMsg));
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsg)} with {@code pattern}, {@code tbMsg}.
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsg)}
   */
  @Test
  @DisplayName("Test processPattern(String, TbMsg) with 'pattern', 'tbMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsg)"})
  void testProcessPatternWithPatternTbMsg2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Failed to process pattern!", "42");

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("Data");
    when(tbMsg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPattern("Pattern", tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsg)} with {@code pattern}, {@code tbMsg}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code Pattern}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPattern(String, TbMsg) with 'pattern', 'tbMsg'; given '42'; then return 'Pattern'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsg)"})
  void testProcessPatternWithPatternTbMsg_given42_thenReturnPattern() {
    // Arrange
    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("42");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    String actualProcessPatternResult = TbNodeUtils.processPattern("Pattern", tbMsg);

    // Assert
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
    assertEquals("Pattern", actualProcessPatternResult);
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsg)} with {@code pattern}, {@code tbMsg}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPattern(String, TbMsg) with 'pattern', 'tbMsg'; given 'Data'; when TbMsg getData() return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsg)"})
  void testProcessPatternWithPatternTbMsg_givenData_whenTbMsgGetDataReturnData() {
    // Arrange
    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("Data");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPattern("Pattern", tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsg)} with {@code pattern}, {@code tbMsg}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData(Map)} with data is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPattern(String, TbMsg) with 'pattern', 'tbMsg'; given TbMsgMetaData(Map) with data is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsg)"})
  void testProcessPatternWithPatternTbMsg_givenTbMsgMetaDataWithDataIsHashMap() {
    // Arrange
    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenReturn("42");
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData(new HashMap<>()));

    // Act
    String actualProcessPatternResult = TbNodeUtils.processPattern("Pattern", tbMsg);

    // Assert
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
    assertEquals("Pattern", actualProcessPatternResult);
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsg)} with {@code pattern}, {@code tbMsg}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processPattern(String, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processPattern(String, TbMsg) with 'pattern', 'tbMsg'; when TbMsg getData() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processPattern(String, TbMsg)"})
  void testProcessPatternWithPatternTbMsg_whenTbMsgGetDataThrowIllegalArgumentException() {
    // Arrange
    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getData()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbNodeUtils.processPattern("Pattern", tbMsg));
    verify(tbMsg).getData();
    verify(tbMsg).getMetaData();
  }

  /**
   * Test {@link TbNodeUtils#processTemplate(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); given 'Key'; when HashMap() 'Key' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processTemplate(String, Map)"})
  void testProcessTemplate_givenKey_whenHashMapKeyIs42() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("Key", "42");

    // Act and Assert
    assertEquals("Template", TbNodeUtils.processTemplate("Template", data));
  }

  /**
   * Test {@link TbNodeUtils#processTemplate(String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.processTemplate(String, Map)"})
  void testProcessTemplate_whenHashMap() {
    // Arrange, Act and Assert
    assertEquals("Template", TbNodeUtils.processTemplate("Template", new HashMap<>()));
  }

  /**
   * Test {@link TbNodeUtils#formatDataVarTemplate(String)}.
   *
   * <p>Method under test: {@link TbNodeUtils#formatDataVarTemplate(String)}
   */
  @Test
  @DisplayName("Test formatDataVarTemplate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.formatDataVarTemplate(String)"})
  void testFormatDataVarTemplate() {
    // Arrange, Act and Assert
    assertEquals("$[Key]", TbNodeUtils.formatDataVarTemplate("Key"));
  }

  /**
   * Test {@link TbNodeUtils#formatMetadataVarTemplate(String)}.
   *
   * <p>Method under test: {@link TbNodeUtils#formatMetadataVarTemplate(String)}
   */
  @Test
  @DisplayName("Test formatMetadataVarTemplate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbNodeUtils.formatMetadataVarTemplate(String)"})
  void testFormatMetadataVarTemplate() {
    // Arrange, Act and Assert
    assertEquals("${Key}", TbNodeUtils.formatMetadataVarTemplate("Key"));
  }
}
