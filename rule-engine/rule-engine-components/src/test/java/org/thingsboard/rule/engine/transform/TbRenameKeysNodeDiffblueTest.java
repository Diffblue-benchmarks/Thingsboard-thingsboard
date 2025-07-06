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

class TbRenameKeysNodeDiffblueTest {
  /**
   * Test {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRenameKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbRenameKeysNode tbRenameKeysNode = new TbRenameKeysNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbRenameKeysNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRenameKeysNode}
   *   <li>{@link TbRenameKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbRenameKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbRenameKeysNode.<init>()",
    "String TbRenameKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbRenameKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRenameKeysNode actualTbRenameKeysNode = new TbRenameKeysNode();
    String actualKeyToUpgradeFromVersionOne =
        actualTbRenameKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
    assertEquals("renameIn", actualTbRenameKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
