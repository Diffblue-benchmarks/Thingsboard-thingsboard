package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.util.TbPair;

class TbMsgAttributesNodeDiffblueTest {
  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42_thenReturnEmpty2() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and {@code Value}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and 'Value'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValue_thenReturnSizeIsOne() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "Value"));

    newAttributes.add(baseAttributeKvEntry);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult = tbMsgAttributesNode.filterChangedAttr(currentAttributes,
        newAttributes);

    // Assert
    assertEquals(1, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry, actualFilterChangedAttrResult.get(0));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with key is {@code null} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with key is 'null' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyIsNullAndValueIs42() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry(null, "42"));

    newAttributes.add(baseAttributeKvEntry);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult = tbMsgAttributesNode.filterChangedAttr(currentAttributes,
        newAttributes);

    // Assert
    assertEquals(1, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry, actualFilterChangedAttrResult.get(0));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenStringDataEntryWithKeyAndValueIs42() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new StringDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertEquals(newAttributes, tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnArrayList() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertSame(newAttributes, tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty2() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty3() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty4() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnSizeIsTwo() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    newAttributes.add(baseAttributeKvEntry);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult = tbMsgAttributesNode.filterChangedAttr(currentAttributes,
        newAttributes);

    // Assert
    assertEquals(2, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry, actualFilterChangedAttrResult.get(1));
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNode oldConfiguration = mock(JsonNode.class);
    when(oldConfiguration.has(Mockito.<String>any())).thenReturn(true);
    when(oldConfiguration.get(Mockito.<String>any()))
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(oldConfiguration.hasNonNull(Mockito.<String>any())).thenReturn(true);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMsgAttributesNode.upgrade(0, oldConfiguration);

    // Assert
    verify(oldConfiguration, atLeast(1)).get(Mockito.<String>any());
    verify(oldConfiguration).has(eq("updateAttributesOnlyOnValueChange"));
    verify(oldConfiguration, atLeast(1)).hasNonNull(Mockito.<String>any());
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link JsonNode} {@link JsonNode#get(String)} return Instance.</li>
   *   <li>Then calls {@link JsonNode#has(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given Instance; when JsonNode get(String) return Instance; then calls has(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance_whenJsonNodeGetReturnInstance_thenCallsHas() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNode oldConfiguration = mock(JsonNode.class);
    when(oldConfiguration.has(Mockito.<String>any())).thenReturn(true);
    when(oldConfiguration.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(oldConfiguration.hasNonNull(Mockito.<String>any())).thenReturn(true);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMsgAttributesNode.upgrade(0, oldConfiguration);

    // Assert
    verify(oldConfiguration, atLeast(1)).get(Mockito.<String>any());
    verify(oldConfiguration).has(eq("updateAttributesOnlyOnValueChange"));
    verify(oldConfiguration, atLeast(1)).hasNonNull(Mockito.<String>any());
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When one.</li>
   *   <li>Then return not First.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given Instance; when one; then return not First")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance_whenOne_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNode oldConfiguration = mock(JsonNode.class);
    when(oldConfiguration.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(oldConfiguration.hasNonNull(Mockito.<String>any())).thenReturn(true);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMsgAttributesNode.upgrade(1, oldConfiguration);

    // Assert
    verify(oldConfiguration, atLeast(1)).get(Mockito.<String>any());
    verify(oldConfiguration, atLeast(1)).hasNonNull(Mockito.<String>any());
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNode oldConfiguration = mock(JsonNode.class);
    when(oldConfiguration.get(Mockito.<String>any())).thenThrow(new IllegalArgumentException("notifyDevice"));
    when(oldConfiguration.hasNonNull(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgAttributesNode.upgrade(1, oldConfiguration));
    verify(oldConfiguration).get(eq("notifyDevice"));
    verify(oldConfiguration).hasNonNull(eq("notifyDevice"));
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return not First.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when minus one; then return not First")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenMinusOne_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    JsonNode oldConfiguration = mock(JsonNode.class);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = (new TbMsgAttributesNode()).upgrade(-1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }
}
