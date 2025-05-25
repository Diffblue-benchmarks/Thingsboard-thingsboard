package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.ContactBasedEntityDetails;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetCustomerDetailsNodeDiffblueTest {
  /**
   * Test {@link TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   * <ul>
   *   <li>Then return {@link TbGetCustomerDetailsNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetCustomerDetailsNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbGetCustomerDetailsNodeConfiguration TbGetCustomerDetailsNode.loadNodeConfiguration(TbNodeConfiguration)"})
  void testLoadNodeConfiguration_thenReturnTbGetCustomerDetailsNodeConfiguration() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(detailsList);

    // Act and Assert
    assertSame(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNode
        .loadNodeConfiguration(new TbNodeConfiguration(new POJONode(tbGetCustomerDetailsNodeConfiguration))));
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetCustomerDetailsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetCustomerDetailsNode.upgrade(int, JsonNode)"})
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetCustomerDetailsNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof MissingNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetCustomerDetailsNode}
   *   <li>{@link TbGetCustomerDetailsNode#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetCustomerDetailsNode.<init>()", "java.lang.String TbGetCustomerDetailsNode.getPrefix()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("customer_", (new TbGetCustomerDetailsNode()).getPrefix());
  }
}
