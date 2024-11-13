package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetProfileEvictEventDiffblueTest {
  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileEvictEvent assetProfileEvictEvent = new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", mock(AssetProfileId.class), true);

    // Act and Assert
    assertNotEquals(assetProfileEvictEvent,
        new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name", null, true));
  }

  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name",
        mock(AssetProfileId.class), true), "42");
  }

  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileEvictEvent assetProfileEvictEvent = new AssetProfileEvictEvent(null, "New Name", "Old Name",
        mock(AssetProfileId.class), true);

    // Act and Assert
    assertNotEquals(assetProfileEvictEvent,
        new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name", null, true));
  }

  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileEvictEvent assetProfileEvictEvent = new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT,
        "org.thingsboard.server.dao.asset.AssetProfileEvictEvent", "Old Name", mock(AssetProfileId.class), true);

    // Act and Assert
    assertNotEquals(assetProfileEvictEvent,
        new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name", null, true));
  }

  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileEvictEvent assetProfileEvictEvent = new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "org.thingsboard.server.dao.asset.AssetProfileEvictEvent", mock(AssetProfileId.class), true);

    // Act and Assert
    assertNotEquals(assetProfileEvictEvent,
        new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name", null, true));
  }

  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfileEvictEvent assetProfileEvictEvent = new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", mock(AssetProfileId.class), false);

    // Act and Assert
    assertNotEquals(assetProfileEvictEvent,
        new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name", null, true));
  }

  /**
   * Test {@link AssetProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetProfileEvictEvent assetProfileEvictEvent = new AssetProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", mock(AssetProfileId.class), true);

    // Act and Assert
    assertNotEquals(assetProfileEvictEvent, new AssetProfileEvictEvent(null, "New Name", "Old Name", null, true));
  }
}
