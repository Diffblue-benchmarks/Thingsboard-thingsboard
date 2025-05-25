package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCopyKeysNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCopyKeysNode}
   *   <li>{@link TbCopyKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbCopyKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCopyKeysNode.<init>()", "String TbCopyKeysNode.getKeyToUpgradeFromVersionOne()",
      "String TbCopyKeysNode.getNewKeyForUpgradeFromVersionZero()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbCopyKeysNode actualTbCopyKeysNode = new TbCopyKeysNode();
    String actualKeyToUpgradeFromVersionOne = actualTbCopyKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("copyFrom", actualTbCopyKeysNode.getNewKeyForUpgradeFromVersionZero());
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
  }
}
