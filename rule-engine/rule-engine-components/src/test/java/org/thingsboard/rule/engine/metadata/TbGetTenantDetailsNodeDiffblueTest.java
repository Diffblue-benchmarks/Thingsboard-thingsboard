package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.ContactBasedEntityDetails;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetTenantDetailsNodeDiffblueTest {
  /**
   * Test {@link TbGetTenantDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetTenantDetailsNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetTenantDetailsNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetTenantDetailsNodeConfiguration TbGetTenantDetailsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetTenantDetailsNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    TbGetTenantDetailsNodeConfiguration tbGetTenantDetailsNodeConfiguration =
        new TbGetTenantDetailsNodeConfiguration();
    tbGetTenantDetailsNodeConfiguration.setDetailsList(detailsList);

    // Act and Assert
    assertSame(
        tbGetTenantDetailsNodeConfiguration,
        tbGetTenantDetailsNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetTenantDetailsNodeConfiguration))));
  }

  /**
   * Test {@link TbGetTenantDetailsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetTenantDetailsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbGetTenantDetailsNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetTenantDetailsNode}
   *   <li>{@link TbGetTenantDetailsNode#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbGetTenantDetailsNode.<init>()",
    "java.lang.String TbGetTenantDetailsNode.getPrefix()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("tenant_", new TbGetTenantDetailsNode().getPrefix());
  }
}
