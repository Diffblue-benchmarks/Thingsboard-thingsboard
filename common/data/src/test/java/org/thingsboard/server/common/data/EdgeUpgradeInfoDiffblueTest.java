package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeUpgradeInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeUpgradeInfo#EdgeUpgradeInfo(boolean, String)}
   *   <li>{@link EdgeUpgradeInfo#getNextEdgeVersion()}
   *   <li>{@link EdgeUpgradeInfo#isRequiresUpdateDb()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EdgeUpgradeInfo.<init>(boolean, String)",
    "String EdgeUpgradeInfo.getNextEdgeVersion()",
    "boolean EdgeUpgradeInfo.isRequiresUpdateDb()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeUpgradeInfo actualEdgeUpgradeInfo = new EdgeUpgradeInfo(true, "1.0.2");
    String actualNextEdgeVersion = actualEdgeUpgradeInfo.getNextEdgeVersion();

    // Assert
    assertEquals("1.0.2", actualNextEdgeVersion);
    assertTrue(actualEdgeUpgradeInfo.isRequiresUpdateDb());
  }
}
