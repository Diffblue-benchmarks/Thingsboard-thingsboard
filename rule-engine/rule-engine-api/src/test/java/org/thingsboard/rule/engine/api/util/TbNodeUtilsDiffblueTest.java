package org.thingsboard.rule.engine.api.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

class TbNodeUtilsDiffblueTest {
  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given Instance")
  void testConvert_givenInstance() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given Instance; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  void testConvert_givenInstance_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addArray();
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given Instance; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  void testConvert_givenInstance_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray2() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addArray();
    data.addArray();
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given Instance; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  void testConvert_givenInstance_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given Instance; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  void testConvert_givenInstance_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject2() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addArray();
    data.addObject();
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given {@code Pojo}.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addPOJO {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given 'Pojo'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  void testConvert_givenPojo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addPOJO("Pojo");
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given {@code Pojo}.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addPOJO {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given 'Pojo'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  void testConvert_givenPojo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo2() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addArray();
    data.addPOJO("Pojo");
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addPOJO two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); given two; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO two")
  void testConvert_givenTwo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOTwo() throws TbNodeException {
    // Arrange
    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addPOJO(2);
    data.add(MissingNode.getInstance());
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then return List")
  void testConvert_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnList() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof List);
    assertTrue(((List<Object>) actualConvertResult).isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf
   * one.</li>
   *   <li>Then return {@link BigInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); when BigIntegerNode(BigInteger) with v is valueOf one; then return BigInteger")
  void testConvert_whenBigIntegerNodeWithVIsValueOfOne_thenReturnBigInteger() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(new BigIntegerNode(BigInteger.valueOf(1L)));
    Class<Object> clazz = Object.class;

    // Act
    Object actualConvertResult = TbNodeUtils.convert(configuration, clazz);

    // Assert
    assertTrue(actualConvertResult instanceof BigInteger);
    assertEquals("1", actualConvertResult.toString());
    assertEquals(0, ((BigInteger) actualConvertResult).getLowestSetBit());
    assertEquals(1, ((BigInteger) actualConvertResult).signum());
    assertArrayEquals(new byte[]{1}, ((BigInteger) actualConvertResult).toByteArray());
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is Instance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is Instance; then return 'null'")
  void testConvert_whenTbNodeConfigurationWithDataIsInstance_thenReturnNull() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(NullNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is Instance.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is Instance; then throw TbNodeException")
  void testConvert_whenTbNodeConfigurationWithDataIsInstance_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(TbNodeException.class, () -> TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#convert(TbNodeConfiguration, Class)}
   */
  @Test
  @DisplayName("Test convert(TbNodeConfiguration, Class); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  void testConvert_whenTbNodeConfigurationWithDataIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbNodeConfiguration configuration = new TbNodeConfiguration(null);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(TbNodeUtils.convert(configuration, clazz));
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with
   * {@code patterns}, {@code metaData}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; given '42'; when ArrayList() add '42'")
  void testProcessPatternsWithPatternsMetaData_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("42");
    patterns.add("foo");

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, new TbMsgMetaData());

    // Assert
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with
   * {@code patterns}, {@code metaData}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; given 'Value'")
  void testProcessPatternsWithPatternsMetaData_givenValue() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, metaData);

    // Assert
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with
   * {@code patterns}, {@code metaData}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; when ArrayList(); then return Empty")
  void testProcessPatternsWithPatternsMetaData_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, new TbMsgMetaData());

    // Assert
    assertTrue(actualProcessPatternsResult.isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)} with
   * {@code patterns}, {@code metaData}.
   * <ul>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPatterns(List, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsgMetaData) with 'patterns', 'metaData'; when TbMsgMetaData(); then return ArrayList()")
  void testProcessPatternsWithPatternsMetaData_whenTbMsgMetaData_thenReturnArrayList() {
    // Arrange
    ArrayList<String> patterns = new ArrayList<>();
    patterns.add("foo");

    // Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(patterns, new TbMsgMetaData());

    // Assert
    assertEquals(patterns, actualProcessPatternsResult);
  }

  /**
   * Test {@link TbNodeUtils#processPatterns(List, TbMsg)} with {@code patterns},
   * {@code tbMsg}.
   * <p>
   * Method under test: {@link TbNodeUtils#processPatterns(List, TbMsg)}
   */
  @Test
  @DisplayName("Test processPatterns(List, TbMsg) with 'patterns', 'tbMsg'")
  void testProcessPatternsWithPatternsTbMsg() {
    // Arrange and Act
    List<String> actualProcessPatternsResult = TbNodeUtils.processPatterns(new ArrayList<>(), (TbMsg) null);

    // Assert
    assertTrue(actualProcessPatternsResult.isEmpty());
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsgMetaData)} with
   * {@code pattern}, {@code metaData}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPattern(String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPattern(String, TbMsgMetaData) with 'pattern', 'metaData'; given 'foo'")
  void testProcessPatternWithPatternMetaData_givenFoo() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals("Pattern", TbNodeUtils.processPattern("Pattern", new TbMsgMetaData(data)));
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsgMetaData)} with
   * {@code pattern}, {@code metaData}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPattern(String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPattern(String, TbMsgMetaData) with 'pattern', 'metaData'; given 'Key'; when TbMsgMetaData() Value 'Key' is '42'")
  void testProcessPatternWithPatternMetaData_givenKey_whenTbMsgMetaDataValueKeyIs42() {
    // Arrange
    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act and Assert
    assertEquals("Pattern", TbNodeUtils.processPattern("Pattern", metaData));
  }

  /**
   * Test {@link TbNodeUtils#processPattern(String, TbMsgMetaData)} with
   * {@code pattern}, {@code metaData}.
   * <ul>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()}.</li>
   *   <li>Then return {@code Pattern}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processPattern(String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test processPattern(String, TbMsgMetaData) with 'pattern', 'metaData'; when TbMsgMetaData(); then return 'Pattern'")
  void testProcessPatternWithPatternMetaData_whenTbMsgMetaData_thenReturnPattern() {
    // Arrange, Act and Assert
    assertEquals("Pattern", TbNodeUtils.processPattern("Pattern", new TbMsgMetaData()));
  }

  /**
   * Test {@link TbNodeUtils#processTemplate(String, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); given BiFunction; when HashMap() computeIfPresent 'foo' and BiFunction")
  void testProcessTemplate_givenBiFunction_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    data.put("foo", "foo");

    // Act and Assert
    assertEquals("Template", TbNodeUtils.processTemplate("Template", data));
  }

  /**
   * Test {@link TbNodeUtils#processTemplate(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); given 'foo'; when HashMap() 'foo' is 'foo'")
  void testProcessTemplate_givenFoo_whenHashMapFooIsFoo() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("foo", "foo");

    // Act and Assert
    assertEquals("Template", TbNodeUtils.processTemplate("Template", data));
  }

  /**
   * Test {@link TbNodeUtils#processTemplate(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbNodeUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); when HashMap()")
  void testProcessTemplate_whenHashMap() {
    // Arrange, Act and Assert
    assertEquals("Template", TbNodeUtils.processTemplate("Template", new HashMap<>()));
  }

  /**
   * Test {@link TbNodeUtils#formatDataVarTemplate(String)}.
   * <p>
   * Method under test: {@link TbNodeUtils#formatDataVarTemplate(String)}
   */
  @Test
  @DisplayName("Test formatDataVarTemplate(String)")
  void testFormatDataVarTemplate() {
    // Arrange, Act and Assert
    assertEquals("$[Key]", TbNodeUtils.formatDataVarTemplate("Key"));
  }

  /**
   * Test {@link TbNodeUtils#formatMetadataVarTemplate(String)}.
   * <p>
   * Method under test: {@link TbNodeUtils#formatMetadataVarTemplate(String)}
   */
  @Test
  @DisplayName("Test formatMetadataVarTemplate(String)")
  void testFormatMetadataVarTemplate() {
    // Arrange, Act and Assert
    assertEquals("${Key}", TbNodeUtils.formatMetadataVarTemplate("Key"));
  }
}
