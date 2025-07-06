package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbDeleteKeysNodeDiffblueTest {
  /**
   * Test {@link TbDeleteKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeleteKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbDeleteKeysNode tbDeleteKeysNode = new TbDeleteKeysNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbDeleteKeysNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteKeysNode}
   *   <li>{@link TbDeleteKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbDeleteKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbDeleteKeysNode.<init>()",
    "String TbDeleteKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteKeysNode actualTbDeleteKeysNode = new TbDeleteKeysNode();
    String actualKeyToUpgradeFromVersionOne =
        actualTbDeleteKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("dataToFetch", actualKeyToUpgradeFromVersionOne);
    assertEquals("deleteFrom", actualTbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
