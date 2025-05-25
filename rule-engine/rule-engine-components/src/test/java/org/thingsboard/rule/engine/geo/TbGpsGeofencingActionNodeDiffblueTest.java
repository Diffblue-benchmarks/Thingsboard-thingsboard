package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGpsGeofencingActionNodeDiffblueTest {
  /**
   * Test {@link TbGpsGeofencingActionNode#getConfigClazz()}.
   * <p>
   * Method under test: {@link TbGpsGeofencingActionNode#getConfigClazz()}
   */
  @Test
  @DisplayName("Test getConfigClazz()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class TbGpsGeofencingActionNode.getConfigClazz()"})
  void testGetConfigClazz() {
    // Arrange and Act
    Class<TbGpsGeofencingActionNodeConfiguration> actualConfigClazz = (new TbGpsGeofencingActionNode())
        .getConfigClazz();

    // Assert
    Class<TbGpsGeofencingActionNodeConfiguration> expectedConfigClazz = TbGpsGeofencingActionNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then Second return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGpsGeofencingActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGpsGeofencingActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnMissingNode() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGpsGeofencingActionNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof MissingNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGpsGeofencingActionNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbGpsGeofencingActionNode}
   */
  @Test
  @DisplayName("Test new TbGpsGeofencingActionNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.<init>()"})
  void testNewTbGpsGeofencingActionNode() {
    // Arrange and Act
    TbGpsGeofencingActionNode actualTbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    // Assert
    assertNull(actualTbGpsGeofencingActionNode.jtsCtx);
    assertNull(actualTbGpsGeofencingActionNode.config);
    Class<TbGpsGeofencingActionNodeConfiguration> expectedConfigClazz = TbGpsGeofencingActionNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualTbGpsGeofencingActionNode.getConfigClazz());
  }
}
