package org.thingsboard.monitoring.data.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.query.EntityDataQuery;

class CmdsWrapperDiffblueTest {
  /**
   * Test {@link CmdsWrapper#equals(Object)}, and {@link CmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CmdsWrapper#equals(Object)}
   *   <li>{@link CmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CmdsWrapper cmdsWrapper = new CmdsWrapper();
    cmdsWrapper.setEntityDataCmds(new ArrayList<>());

    CmdsWrapper cmdsWrapper2 = new CmdsWrapper();
    cmdsWrapper2.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertEquals(cmdsWrapper, cmdsWrapper2);
    int expectedHashCodeResult = cmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, cmdsWrapper2.hashCode());
  }

  /**
   * Test {@link CmdsWrapper#equals(Object)}, and {@link CmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CmdsWrapper#equals(Object)}
   *   <li>{@link CmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CmdsWrapper cmdsWrapper = new CmdsWrapper();
    cmdsWrapper.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertEquals(cmdsWrapper, cmdsWrapper);
    int expectedHashCodeResult = cmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, cmdsWrapper.hashCode());
  }

  /**
   * Test {@link CmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    ArrayList<EntityDataCmd> entityDataCmds = new ArrayList<>();
    entityDataCmds.add(entityDataCmd);

    CmdsWrapper cmdsWrapper = new CmdsWrapper();
    cmdsWrapper.setEntityDataCmds(entityDataCmds);

    CmdsWrapper cmdsWrapper2 = new CmdsWrapper();
    cmdsWrapper2.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cmdsWrapper, cmdsWrapper2);
  }

  /**
   * Test {@link CmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());
    EntityDataCmd entityDataCmd = mock(EntityDataCmd.class);
    doNothing().when(entityDataCmd).setCmdId(anyInt());
    doNothing().when(entityDataCmd).setLatestCmd(Mockito.<LatestValueCmd>any());
    doNothing().when(entityDataCmd).setQuery(Mockito.<EntityDataQuery>any());
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    ArrayList<EntityDataCmd> entityDataCmds = new ArrayList<>();
    entityDataCmds.add(entityDataCmd);

    CmdsWrapper cmdsWrapper = new CmdsWrapper();
    cmdsWrapper.setEntityDataCmds(entityDataCmds);

    CmdsWrapper cmdsWrapper2 = new CmdsWrapper();
    cmdsWrapper2.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cmdsWrapper, cmdsWrapper2);
  }

  /**
   * Test {@link CmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CmdsWrapper cmdsWrapper = new CmdsWrapper();
    cmdsWrapper.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cmdsWrapper, null);
  }

  /**
   * Test {@link CmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CmdsWrapper cmdsWrapper = new CmdsWrapper();
    cmdsWrapper.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cmdsWrapper, "Different type to CmdsWrapper");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CmdsWrapper}
   *   <li>{@link CmdsWrapper#setEntityDataCmds(List)}
   *   <li>{@link CmdsWrapper#toString()}
   *   <li>{@link CmdsWrapper#getEntityDataCmds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CmdsWrapper actualCmdsWrapper = new CmdsWrapper();
    ArrayList<EntityDataCmd> entityDataCmds = new ArrayList<>();
    actualCmdsWrapper.setEntityDataCmds(entityDataCmds);
    String actualToStringResult = actualCmdsWrapper.toString();
    List<EntityDataCmd> actualEntityDataCmds = actualCmdsWrapper.getEntityDataCmds();

    // Assert that nothing has changed
    assertEquals("CmdsWrapper(entityDataCmds=[])", actualToStringResult);
    assertTrue(actualEntityDataCmds.isEmpty());
    assertSame(entityDataCmds, actualEntityDataCmds);
  }
}
